package br.ufsm.cbrgroup.cbr.reuse;

import br.ufsm.cbrgroup.description.Envido;
import br.ufsm.cbrgroup.description.Flor;
import br.ufsm.cbrgroup.description.PlayCard;
import br.ufsm.cbrgroup.description.Truco;
import br.ufsm.cbrgroup.game.GameState;
import br.ufsm.cbrgroup.ui.TesteLoader;
import br.ufsm.cbrgroup.websocket.Message;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCaseBase;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRQuery;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.RetrievalResult;

import java.util.Collection;
import java.util.Iterator;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 15/07/2019.
 */


public class ReuseActiveLearningEx implements ReuseStrategyEx {

    private final double THRESHOLD_ACTIVE_LEARNING = 0.97;

    @Override
    public Message decisionMakingEnvido(CBRCaseBase caseBase, GameState gameState, CBRQuery query, NNConfig simConfig, boolean isTurn) {
        Message message = null;

        Collection<RetrievalResult> retrievedCases = null;
        retrievedCases = getMostSimilarCases(caseBase, query, simConfig, 1);

        printRetrievedCases(retrievedCases, "ENVIDO");

        RetrievalResult retrievedCase = null;

        Iterator i = retrievedCases.iterator();
        if (i.hasNext()) {
            retrievedCase = (RetrievalResult) i.next();
        }

        if (retrievedCase != null) {
            Envido envido = (Envido) retrievedCase.get_case().getDescription();
            if (retrievedCase.getEval() < THRESHOLD_ACTIVE_LEARNING ) {
                TesteLoader.changeScreen("active", envido.getJogada(), gameState, "ENVIDO", isTurn);
            } else {
                message = reasoningEnvido(gameState, (Envido) retrievedCase.get_case().getDescription());
            }

        }

        return message;
    }

    @Override
    public Message decisionMakingFlor(CBRCaseBase caseBase, GameState gameState, CBRQuery query, NNConfig simConfig, boolean isTurn) {
        return null;
    }

    @Override
    public Message decisionMakingTruco(CBRCaseBase caseBase, GameState gameState, CBRQuery query, NNConfig simConfig, boolean isTurn) {
        return null;
    }

    @Override
    public Message decisionMakingPlayCard(CBRCaseBase caseBase, GameState gameState, CBRQuery query, NNConfig simConfig, boolean isTurn) {
        return null;
    }

    public Message reasoningEnvido(GameState gameState, Envido retrievedCase) {

        Message message = new Message();
        String solution = retrievedCase.getJogada();
        System.out.println("SOLUTION_ENVIDO: " + solution);

        if (!gameState.isEnvido()) {
            // 0: NÃO CHAMAR 1: ENVIDO; 3: REAL_ENVIDO; 4: FALTA_ENVIDO
            if (solution.equals("NO_CALL")) {
                message = null;
            } else if (solution.equals("ENVIDO")) {
                message.setAction("ENVIDO");
                message.setInfo("1");
            } else if (solution.equals("REAL_ENVIDO")) {
                message.setAction("ENVIDO");
                message.setInfo("3");
            } else if (solution.equals("FALTA_ENVIDO")) {
                message.setAction("ENVIDO");
                message.setInfo("4");
            } else {
                message = null;
            }
        } else {
            switch (gameState.getStateDecisionToken()) {
                //0: NÃO ACEITAR 1: ACEITAR; 2: ENVIDO_ENVIDO; 3: REAL_ENVIDO; 4: FALTA_ENVIDO
                case ENVIDO:
                    if (solution.equals("ACCEPT")) {
                        message.setAction("QUERO");
                        message.setInfo("1");
                    } else if (solution.equals("ENVIDO_ENVIDO")) {
                        message.setAction("ENVIDO");
                        message.setInfo("2");
                    } else if (solution.equals("REAL_ENVIDO")) {
                        message.setAction("ENVIDO");
                        message.setInfo("3");
                    } else if (solution.equals("FALTA_ENVIDO")) {
                        message.setAction("ENVIDO");
                        message.setInfo("4");
                    } else {
                        message.setAction("NAO_QUERO");
                        message.setInfo("1");
                    }
                    break;
                //0: NÃO ACEITAR 1: ACEITAR; 3: REAL_ENVIDO; 4: FALTA_ENVIDO
                case ENVIDO_ENVIDO:
                    if (solution.equals("ACCEPT")) {
                        message.setAction("QUERO");
                        message.setInfo("1");
                    } else if (solution.equals("REAL_ENVIDO")) {
                        message.setAction("ENVIDO");
                        message.setInfo("3");
                    } else if (solution.equals("FALTA_ENVIDO")) {
                        message.setAction("ENVIDO");
                        message.setInfo("4");
                    } else {
                        message.setAction("NAO_QUERO");
                        message.setInfo("1");
                    }
                    break;
                //0: NÃO ACEITAR 1: ACEITAR; 4: FALTA_ENVIDO
                case REAL_ENVIDO:
                    if (solution.equals("ACCEPT")) {
                        message.setAction("QUERO");
                        message.setInfo("1");
                    } else if (solution.equals("FALTA_ENVIDO")) {
                        message.setAction("ENVIDO");
                        message.setInfo("4");
                    } else {
                        message.setAction("NAO_QUERO");
                        message.setInfo("1");
                    }
                    break;
                //0: NÃO ACEITAR 1: ACEITAR;
                case FALTA_ENVIDO:
                    if (solution.equals("ACCEPT")) {
                        message.setAction("QUERO");
                        message.setInfo("1");
                    } else {
                        message.setAction("NAO_QUERO");
                        message.setInfo("1");
                    }
                    break;
            }
        }

        return message;
    }

    public Message reasoningFlor(GameState gameState, Flor retrievedCase) {

        Message message = new Message();
        String solution = retrievedCase.getJogada();
        System.out.println("SOLUTION_FLOR: " + solution);

        switch (gameState.getStateDecisionToken()) {
            //0: NADA 2: FLOR_FLOR; 3: CONTRA_FLOR;
            case FLOR:
                if (solution.equals("CONTRA_FLOR")) {
                    message.setAction("FLOR");
                    message.setInfo("3");
                } else if (solution.equals("FLOR_FLOR")) {
                    message.setAction("FLOR");
                    message.setInfo("2");
                } else {
                    message = null;
                }
                break;
            //0: NÃO ACEITAR 1: ACEITAR; 3: CONTRA_FLOR;
            case FLOR_FLOR:
                if (solution.equals("ACCEPT")) {
                    message.setAction("QUERO");
                    message.setInfo("3");
                } else if (solution.equals("CONTRA_FLOR_FALTA")) {
                    message.setAction("FLOR");
                    message.setInfo("4");
                } else {
                    message.setAction("NAO_QUERO");
                    message.setInfo("3");
                }
                break;
            //0: NÃO ACEITAR 1: ACEITAR; 4: CONTRA_FLOR_FALTA; 5: CONTRA_FLOR_RESTO;
            case CONTRA_FLOR:
                if (solution.equals("ACCEPT")) {
                    message.setAction("QUERO");
                    message.setInfo("3");
                } else if (solution.equals("CONTRA_FLOR_FALTA")) {
                    message.setAction("FLOR");
                    message.setInfo("4");
                } else if (solution.equals("CONTRA_FLOR_RESTO")) {
                    message.setAction("FLOR");
                    message.setInfo("5");
                } else {
                    message.setAction("NAO_QUERO");
                    message.setInfo("3");
                }
                break;
            //0: NÃO ACEITAR 1: ACEITAR;  5: CONTRA_FLOR_RESTO;
            case CONTRA_FLOR_FALTA:
                if (solution.equals("ACCEPT")) {
                    message.setAction("QUERO");
                    message.setInfo("3");
                } else if (solution.equals("CONTRA_FLOR_RESTO")) {
                    message.setAction("FLOR");
                    message.setInfo("5");
                } else {
                    message.setAction("NAO_QUERO");
                    message.setInfo("3");
                }
                break;
            //0: NÃO ACEITAR 1: ACEITAR;
            case CONTRA_FLOR_RESTO:
                if (solution.equals("ACCEPT")) {
                    message.setAction("QUERO");
                    message.setInfo("3");
                } else {
                    message.setAction("NAO_QUERO");
                    message.setInfo("3");
                }
                break;
        }


        return message;
    }

    public Message reasoningTruco(GameState gameState, Truco retrievedCase, boolean isTurn) {

        Message message = new Message();
        String solution = retrievedCase.getJogada();
        System.out.println("SOLUTION_TRUCO: " + solution);

        if (!gameState.isTruco()) {
            // 0: NÃO CHAMAR 1: TRUCO;
            if (solution.equals("TRUCO")) {
                message.setAction("TRUCO");
                message.setInfo("1");
            } else {
                message = null;
            }
        } else {
            switch (gameState.getStateDecisionToken()) {
                case TRUCO:
                    //0: NÃO ACEITAR 1: ACEITAR; 2: RETRUCO
                    if (isTurn) {
                        if (solution.equals("RETRUCO")) {
                            message.setAction("TRUCO");
                            message.setInfo("2");
                        }
                    } else {
                        if (solution.equals("ACCEPT")) {
                            message.setAction("QUERO");
                            message.setInfo("2");
                        } else if (solution.equals("RETRUCO")) {
                            message.setAction("TRUCO");
                            message.setInfo("2");
                        } else {
                            message.setAction("NAO_QUERO");
                            message.setInfo("2");
                        }
                    }
                    break;
                case RETRUCO:
                    //0: NÃO ACEITAR 1: ACEITAR; 3: VALE4
                    if (isTurn) {
                        if (solution.equals("VALE4")) {
                            message.setAction("TRUCO");
                            message.setInfo("3");
                        }
                    } else {
                        if (solution.equals("ACCEPT")) {
                            message.setAction("QUERO");
                            message.setInfo("2");
                        } else if (solution.equals("VALE4")) {
                            message.setAction("TRUCO");
                            message.setInfo("3");
                        } else {
                            message.setAction("NAO_QUERO");
                            message.setInfo("2");
                        }
                    }
                    break;
                case VALE4:
                    //0: NÃO ACEITAR 1: ACEITAR;
                    if (solution.equals("ACCEPT")) {
                        message.setAction("QUERO");
                        message.setInfo("2");
                    } else {
                        message.setAction("NAO_QUERO");
                        message.setInfo("2");
                    }
                    break;
            }
        }

        return message;
    }

    public Message reasoningPlayCard(GameState gameState, PlayCard retrievedCase) {

        Message message = new Message();
        String solution = retrievedCase.getJogada();
        System.out.println("SOLUTION_PLAY_CARD: " + solution);
        //"HIGH_CARD" "FOLD" "LOW_CARD" "MEDIUM_CARD" "FACE_DOWN_CARD"

        if (solution.equals("FOLD")) {
            message.setAction("IR_BARALHO");
        } else if (solution.equals("FACE_DOWN_CARD")) {
            message.setAction("FACE_DOWN_CARD");
        } else if (solution.equals("HIGH_CARD")) {
            message.setAction("PLAY_CARD");
            message.setCard(getPreferCartaAlta(gameState));
        } else if (solution.equals("MEDIUM_CARD")) {
            message.setAction("PLAY_CARD");
            message.setCard(getPreferCartaMedia(gameState));
        } else {
            message.setAction("PLAY_CARD");
            message.setCard(getPreferCartaBaixa(gameState));
        }

        return message;
    }
}
