package br.ufsm.cbrgroup.cbr.reuse;

import br.ufsm.cbrgroup.Agent;
import br.ufsm.cbrgroup.description.GenericDescription;
import br.ufsm.cbrgroup.game.GameState;
import br.ufsm.cbrgroup.model.Card;
import br.ufsm.cbrgroup.websocket.Message;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCaseBase;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.RetrievalResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Iterator;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 21/05/2019.
 */


public class ReuseMostSimilar implements ReuseStrategy {

    private static Logger logger = LogManager.getLogger(ReuseMostSimilar.class);

    @Override
    public Message decisionMakingEnvido(CBRCaseBase caseBase, GameState gameState, GenericDescription query, NNConfig simConfig, boolean isTurn) {
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
            // if (retrievedCase.getEval())
            message = reasoningEnvido(gameState, (GenericDescription) retrievedCase.get_case().getDescription());
        }

        return message;
    }

    @Override
    public Message decisionMakingFlor(CBRCaseBase caseBase, GameState gameState, GenericDescription query, NNConfig simConfig, boolean isTurn) {
        Message message = null;

        Collection<RetrievalResult> retrievedCases = null;
        retrievedCases = getMostSimilarCases(caseBase, query, simConfig, 1);

        printRetrievedCases(retrievedCases, "FLOR");

        RetrievalResult retrievedCase = null;

        Iterator i = retrievedCases.iterator();
        if (i.hasNext()) {
            retrievedCase = (RetrievalResult) i.next();
        }

        if (retrievedCase != null) {
            message = reasoningFlor(gameState, (GenericDescription) retrievedCase.get_case().getDescription());
        }

        return message;
    }

    @Override
    public Message decisionMakingTruco(CBRCaseBase caseBase, GameState gameState, GenericDescription query,
                                       NNConfig simConfig, boolean isTurn) {
        Message message = null;

        Collection<RetrievalResult> retrievedCases = null;
        retrievedCases = getMostSimilarCases(caseBase, query, simConfig, 1);

        printRetrievedCases(retrievedCases, "TRUCO");

        RetrievalResult retrievedCase = null;

        Iterator i = retrievedCases.iterator();
        if (i.hasNext()) {
            retrievedCase = (RetrievalResult) i.next();
        }

        if (retrievedCase != null) {
           /* if ((retrievedCase.getEval() < 0.97 && agent.getLearningStrategy() != null) &&
                    (gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_5 ||
                            gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_6) ) {
                message = agent.createAlert(isTurn);
            } else {*/
                message = reasoningTruco(gameState, (GenericDescription) retrievedCase.get_case().getDescription(), isTurn);
            /*}*/

        }

        return message;
    }

    @Override
    public Message decisionMakingPlayCard(CBRCaseBase caseBase, GameState gameState, GenericDescription query, NNConfig simConfig, boolean isTurn) {
        Message message = null;

        Collection<RetrievalResult> retrievedCases = null;
        retrievedCases = getMostSimilarCases(caseBase, query, simConfig, 1);

        printRetrievedCases(retrievedCases, "PLAY_CARD");

        RetrievalResult retrievedCase = null;

        Iterator i = retrievedCases.iterator();
        if (i.hasNext()) {
            retrievedCase = (RetrievalResult) i.next();
        }

        if (retrievedCase != null) {
            message = reasoningPlayCard(gameState, (GenericDescription) retrievedCase.get_case().getDescription());
        }

        return message;
    }

    @Override
    public Message decisionMakingShowPoints(CBRCaseBase caseBase, GameState gameState, GenericDescription query, NNConfig simConfig, boolean isTurn) {
        return null;
    }

    public Message reasoningEnvido(GameState gameState, GenericDescription retrievedCase) {

        Message message = new Message();

        boolean isNoCallEnvido = false;
        boolean isCallEnvido = false;
        boolean isCallEnvidoEnvido = false;
        boolean isCallRealEnvido = false;
        boolean isCallFaltaEnvido = false;

        isCallEnvido = retrievedCase.getQuemPediuEnvido() != null && retrievedCase.getQuemPediuEnvido() == 1 &&
                retrievedCase.getQuemGanhouEnvido()  != null && retrievedCase.getQuemGanhouEnvido() == 1;

        isCallEnvidoEnvido = retrievedCase.getQuemEnvidoEnvido() != null && retrievedCase.getQuemEnvidoEnvido() == 1 &&
                retrievedCase.getQuemGanhouEnvido()  != null && retrievedCase.getQuemGanhouEnvido() == 1;

        isCallRealEnvido = retrievedCase.getQuemPediuRealEnvido() != null && retrievedCase.getQuemPediuRealEnvido() == 1 &&
                retrievedCase.getQuemGanhouEnvido()  != null && retrievedCase.getQuemGanhouEnvido() == 1;

        isCallFaltaEnvido = retrievedCase.getQuemPediuFaltaEnvido() != null && retrievedCase.getQuemPediuFaltaEnvido() == 1 &&
                retrievedCase.getQuemGanhouEnvido()  != null && retrievedCase.getQuemGanhouEnvido() == 1;

        isNoCallEnvido = (retrievedCase.getQuemGanhouEnvido() == null || retrievedCase.getQuemGanhouEnvido() != 1) ||
                (!isCallEnvido && !isCallRealEnvido && !isCallFaltaEnvido);

        if (!gameState.isEnvido()) {
            // 0: NÃO CHAMAR 1: ENVIDO; 3: REAL_ENVIDO; 4: FALTA_ENVIDO

            if (isNoCallEnvido) {
                message = null;
            } else if (isCallEnvido) {
                message.setAction("ENVIDO");
                message.setInfo("1");
            } else if (isCallRealEnvido) {
                message.setAction("ENVIDO");
                message.setInfo("3");
            } else if (isCallFaltaEnvido) {
                message.setAction("ENVIDO");
                message.setInfo("4");
            } else {
                message = null;
            }

        } else {

            switch (gameState.getStateDecisionToken()) {
                //0: NÃO ACEITAR 1: ACEITAR; 2: ENVIDO_ENVIDO; 3: REAL_ENVIDO; 4: FALTA_ENVIDO
                case ENVIDO:
                    if (retrievedCase.getQuemNegouEnvido() != null && retrievedCase.getQuemNegouEnvido() == 1) {
                        message.setAction("NAO_QUERO");
                        message.setInfo("1");
                    } else if (isCallEnvidoEnvido) {
                        message.setAction("ENVIDO");
                        message.setInfo("2");
                    } else if (isCallRealEnvido) {
                        message.setAction("ENVIDO");
                        message.setInfo("3");
                    } else if (isCallFaltaEnvido) {
                        message.setAction("ENVIDO");
                        message.setInfo("4");
                    } else {
                        message.setAction("QUERO");
                        message.setInfo("1");
                    }
                    break;
                //0: NÃO ACEITAR 1: ACEITAR; 3: REAL_ENVIDO; 4: FALTA_ENVIDO
                case ENVIDO_ENVIDO:
                    if (retrievedCase.getQuemNegouEnvido() != null && retrievedCase.getQuemNegouEnvido() == 1) {
                        message.setAction("NAO_QUERO");
                        message.setInfo("1");
                    } else if (isCallRealEnvido) {
                        message.setAction("ENVIDO");
                        message.setInfo("3");
                    } else if (isCallFaltaEnvido) {
                        message.setAction("ENVIDO");
                        message.setInfo("4");
                    } else {
                        message.setAction("QUERO");
                        message.setInfo("1");
                    }
                    break;
                //0: NÃO ACEITAR 1: ACEITAR; 4: FALTA_ENVIDO
                case REAL_ENVIDO:
                    if (retrievedCase.getQuemNegouEnvido() != null && retrievedCase.getQuemNegouEnvido() == 1) {
                        message.setAction("NAO_QUERO");
                        message.setInfo("1");
                    } else if (isCallFaltaEnvido) {
                        message.setAction("ENVIDO");
                        message.setInfo("4");
                    } else {
                        message.setAction("QUERO");
                        message.setInfo("1");
                    }
                    break;
                //0: NÃO ACEITAR 1: ACEITAR;
                case FALTA_ENVIDO:
                    if (retrievedCase.getQuemNegouEnvido() != null && retrievedCase.getQuemNegouEnvido() == 1) {
                        message.setAction("NAO_QUERO");
                        message.setInfo("1");
                    } else {
                        message.setAction("QUERO");
                        message.setInfo("1");
                    }
                    break;

            }
        }

        return message;
    }

    public Message reasoningFlor(GameState gameState, GenericDescription retrievedCase) {

        Message message = new Message();

        switch (gameState.getStateDecisionToken()) {
            //0: NADA 2: FLOR_FLOR; 3: CONTRA_FLOR;
            case FLOR:
               if (retrievedCase.getQuemContraFlor() != null && retrievedCase.getQuemContraFlor() == 1) {
                    message.setAction("FLOR");
                    message.setInfo("3");
                } else {
                    message.setAction("FLOR");
                    message.setInfo("2");
                }
                break;
            //0: NÃO ACEITAR 1: ACEITAR; 3: CONTRA_FLOR;
            case FLOR_FLOR:
                if (retrievedCase.getQuemNegouFlor() != null && retrievedCase.getQuemNegouFlor() == 1) {
                    message.setAction("NAO_QUERO");
                    message.setInfo("3");
                } else if (retrievedCase.getQuemContraFlor() != null && retrievedCase.getQuemContraFlor() == 1) {
                    message.setAction("FLOR");
                    message.setInfo("3");
                }  else {
                    message.setAction("QUERO");
                    message.setInfo("3");
                }
                break;
            //0: NÃO ACEITAR 1: ACEITAR; 4: CONTRA_FLOR_FALTA; 5: CONTRA_FLOR_RESTO;
            case CONTRA_FLOR:
                if (retrievedCase.getQuemNegouFlor() != null && retrievedCase.getQuemNegouFlor() == 1) {
                    message.setAction("NAO_QUERO");
                    message.setInfo("3");
                } else if (retrievedCase.getQuemContraFlorFalta() != null && retrievedCase.getQuemContraFlorFalta() == 1) {
                    message.setAction("FLOR");
                    message.setInfo("4");
                } else if (retrievedCase.getQuemContraFlorResto() != null && retrievedCase.getQuemContraFlorResto() == 1) {
                    message.setAction("FLOR");
                    message.setInfo("5");
                }  else {
                    message.setAction("QUERO");
                    message.setInfo("3");
                }
                break;
            //0: NÃO ACEITAR 1: ACEITAR;  5: CONTRA_FLOR_RESTO;
            case CONTRA_FLOR_FALTA:
                if (retrievedCase.getQuemNegouFlor() != null && retrievedCase.getQuemNegouFlor() == 1) {
                    message.setAction("NAO_QUERO");
                    message.setInfo("3");
                } else if (retrievedCase.getQuemContraFlorResto() != null && retrievedCase.getQuemContraFlorResto() == 1) {
                    message.setAction("FLOR");
                    message.setInfo("5");
                }  else {
                    message.setAction("QUERO");
                    message.setInfo("3");
                }
                break;
            //0: NÃO ACEITAR 1: ACEITAR;
            case CONTRA_FLOR_RESTO:
                if (retrievedCase.getQuemNegouFlor() != null && retrievedCase.getQuemNegouFlor() == 1) {
                    message.setAction("NAO_QUERO");
                    message.setInfo("3");
                } else {
                    message.setAction("QUERO");
                    message.setInfo("3");
                }
                break;
        }

        return message;
    }

    public Message reasoningTruco(GameState gameState, GenericDescription retrievedCase, boolean isTurn) {
        Message message = new Message();

        if (!gameState.isTruco()) {
            // 0: NÃO CHAMAR 1: ENVIDO;

            if (retrievedCase.getQuemTruco() != null && retrievedCase.getQuemTruco() == 1 &&
                    retrievedCase.getQuemGanhouTruco() != null && retrievedCase.getQuemGanhouTruco() == 1 && retrievedCase.getQuandoTruco() ==
                    gameState.getCurrentRound()) {

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
                        if (retrievedCase.getQuemRetruco() != null && retrievedCase.getQuemRetruco() == 1 &&
                                retrievedCase.getQuemGanhouTruco() != null && retrievedCase.getQuemGanhouTruco() == 1) {
                            message.setAction("TRUCO");
                            message.setInfo("2");
                        }
                    } else {
                        if ((retrievedCase.getQuemNegouTruco() != null && retrievedCase.getQuemNegouTruco() == 1) ||
                                (retrievedCase.getQuemGanhouTruco() != null && retrievedCase.getQuemGanhouTruco() != 1)) {
                            message.setAction("NAO_QUERO");
                            message.setInfo("2");
                        } else if (retrievedCase.getQuemRetruco() != null && retrievedCase.getQuemRetruco() == 1 &&
                                (retrievedCase.getQuemGanhouTruco() != null && retrievedCase.getQuemGanhouTruco() != 1)) {
                            message.setAction("TRUCO");
                            message.setInfo("2");
                        } else {
                            message.setAction("QUERO");
                            message.setInfo("2");
                        }
                    }
                    break;
                case RETRUCO:
                    //0: NÃO ACEITAR 1: ACEITAR; 3: VALE4
                    if (isTurn) {
                        if (retrievedCase.getQuemValeQuatro() != null && retrievedCase.getQuemValeQuatro() == 1 &&
                                (retrievedCase.getQuemGanhouTruco() != null && retrievedCase.getQuemGanhouTruco() != 1)) {
                            message.setAction("TRUCO");
                            message.setInfo("3");
                        }
                    } else {

                        if ((retrievedCase.getQuemNegouTruco() != null && retrievedCase.getQuemNegouTruco() == 1) ||
                                (retrievedCase.getQuemGanhouTruco() != null && retrievedCase.getQuemGanhouTruco() != 1)) {
                            message.setAction("NAO_QUERO");
                            message.setInfo("2");
                        } else if (retrievedCase.getQuemValeQuatro() != null && retrievedCase.getQuemValeQuatro() == 1 &&
                                (retrievedCase.getQuemGanhouTruco() != null && retrievedCase.getQuemGanhouTruco() != 1)) {
                            message.setAction("TRUCO");
                            message.setInfo("3");
                        } else {
                            message.setAction("QUERO");
                            message.setInfo("2");
                        }
                    }
                    break;
                case VALE4:
                    //0: NÃO ACEITAR 1: ACEITAR;
                    if ((retrievedCase.getQuemNegouTruco() != null && retrievedCase.getQuemNegouTruco() == 1) ||
                            (retrievedCase.getQuemGanhouTruco() != null && retrievedCase.getQuemGanhouTruco() != 1)) {
                        message.setAction("NAO_QUERO");
                        message.setInfo("2");
                    } else {
                        message.setAction("QUERO");
                        message.setInfo("2");
                    }
                    break;
            }

        }

        return message;
    }

    public Message reasoningPlayCard(GameState gameState, GenericDescription retrievedCase) {

        Message message = new Message();


        if (retrievedCase.getQuemBaralho() != null && retrievedCase.getQuemBaralho() == 1 &&
                retrievedCase.getQuandoBaralho() != null && retrievedCase.getQuandoBaralho() == gameState.getCurrentRound()) {
            message.setAction("IR_BARALHO");
        } else {

            if (retrievedCase.getRoboCartaVirada() != null && retrievedCase.getRoboCartaVirada() == gameState.getCurrentRound()) {
                message.setAction("FACE_DOWN_CARD");
            } else {
                message.setAction("PLAY_CARD");
            }

            switch (gameState.getStateDecisionTurn()) {
                case START_HAND:
                    if (retrievedCase.getPrimeiraCartaRobo() == retrievedCase.getCartaAltaRobo()) {
                        message.setCard(getPreferCartaAlta(gameState));
                    } else if (retrievedCase.getPrimeiraCartaRobo() == retrievedCase.getCartaMediaRobo()) {
                        message.setCard(getPreferCartaMedia(gameState));
                    } else {
                        message.setCard(getPreferCartaBaixa(gameState));
                    }
                    break;
                case PLAY_CARD_2:
                    if (retrievedCase.getPrimeiraCartaRobo() == retrievedCase.getCartaAltaRobo()) {
                        message.setCard(getPreferCartaAlta(gameState));
                    } else if (retrievedCase.getPrimeiraCartaRobo() == retrievedCase.getCartaMediaRobo()) {
                        message.setCard(getPreferCartaMedia(gameState));
                    } else {
                        message.setCard(getPreferCartaBaixa(gameState));
                    }
                    break;
                case PLAY_CARD_3:

                    if (retrievedCase.getSegundaCartaRobo() == retrievedCase.getCartaAltaRobo()) {
                        message.setCard(getPreferCartaAlta(gameState));
                    } else if (retrievedCase.getSegundaCartaRobo() == retrievedCase.getCartaMediaRobo()) {
                        message.setCard(getPreferCartaMedia(gameState));
                    } else {
                        message.setCard(getPreferCartaBaixa(gameState));
                    }
                    break;
                case PLAY_CARD_4:
                    if (retrievedCase.getSegundaCartaRobo() == retrievedCase.getCartaAltaRobo()) {
                        message.setCard(getPreferCartaAlta(gameState));
                    } else if (retrievedCase.getSegundaCartaRobo() == retrievedCase.getCartaMediaRobo()) {
                        message.setCard(getPreferCartaMedia(gameState));
                    } else {
                        message.setCard(getPreferCartaBaixa(gameState));
                    }
                    break;
                case PLAY_CARD_5:
                    if (retrievedCase.getTerceiraCartaRobo() == retrievedCase.getCartaAltaRobo()) {
                        message.setCard(getPreferCartaAlta(gameState));
                    } else if (retrievedCase.getTerceiraCartaRobo() == retrievedCase.getCartaMediaRobo()) {
                        message.setCard(getPreferCartaMedia(gameState));
                    } else {
                        message.setCard(getPreferCartaBaixa(gameState));
                    }
                    break;
                case PLAY_CARD_6:
                    if (retrievedCase.getTerceiraCartaRobo() == retrievedCase.getCartaAltaRobo()) {
                        message.setCard(getPreferCartaAlta(gameState));
                    } else if (retrievedCase.getTerceiraCartaRobo() == retrievedCase.getCartaMediaRobo()) {
                        message.setCard(getPreferCartaMedia(gameState));
                    } else {
                        message.setCard(getPreferCartaBaixa(gameState));
                    }
                    break;
            }

        }

        return message;

    }
/*
    *//** dentre as cartas que tem na mão tentar jogar preferencialmente a mais baixa *//*
    private Card getPreferCartaBaixa(GameState gameState) {

        Card card;

        if (!gameState.isPlayedCard(gameState.getAgentPlayedCards(), gameState.getAgentCards().get(0))) {
            card =  gameState.getAgentCards().get(0);
        } else if (!gameState.isPlayedCard(gameState.getAgentPlayedCards(), gameState.getAgentCards().get(1))) {
            card = gameState.getAgentCards().get(1);
        } else {
            card = gameState.getAgentCards().get(2);
        }

        return card;

    }

    *//** dentre as cartas que tem na mão tentar jogar preferencialmente a media *//*
    private Card getPreferCartaMedia(GameState gameState) {

        Card card;

        if (!gameState.isPlayedCard(gameState.getAgentPlayedCards(), gameState.getAgentCards().get(1))) {
            card =  gameState.getAgentCards().get(1);
        } else if (!gameState.isPlayedCard(gameState.getAgentPlayedCards(), gameState.getAgentCards().get(2))) {
            card = gameState.getAgentCards().get(2);
        } else {
            card = gameState.getAgentCards().get(0);
        }

        return card;

    }

    *//** dentre as cartas que tem na mão tentar jogar preferencialmente a mais alta *//*
    private Card getPreferCartaAlta(GameState gameState) {

        Card card;

        if (!gameState.isPlayedCard(gameState.getAgentPlayedCards(), gameState.getAgentCards().get(2))) {
            card =  gameState.getAgentCards().get(2);
        } else if (!gameState.isPlayedCard(gameState.getAgentPlayedCards(), gameState.getAgentCards().get(1))) {
            card = gameState.getAgentCards().get(1);
        } else {
            card = gameState.getAgentCards().get(0);
        }

        return card;

    }*/
}
