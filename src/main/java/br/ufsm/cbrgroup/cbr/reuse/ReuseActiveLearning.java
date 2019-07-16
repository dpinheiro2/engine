package br.ufsm.cbrgroup.cbr.reuse;

import br.ufsm.cbrgroup.Agent;
import br.ufsm.cbrgroup.description.GenericDescription;
import br.ufsm.cbrgroup.game.Action;
import br.ufsm.cbrgroup.game.GameState;
import br.ufsm.cbrgroup.model.Card;
import br.ufsm.cbrgroup.websocket.Message;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCaseBase;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.RetrievalResult;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 13/06/2019.
 */


public class ReuseActiveLearning implements ReuseStrategy {

    private static Logger logger = LogManager.getLogger(ReuseActiveLearning.class);

    private final double THRESHOLD_ACTIVE_LEARNING = 0.97;

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
            if (retrievedCase.getEval() < THRESHOLD_ACTIVE_LEARNING ) {
                message = createAlertEnvido(isTurn, gameState, (GenericDescription) retrievedCase.get_case().getDescription());
            } else {
                message = reasoningEnvido(gameState, (GenericDescription) retrievedCase.get_case().getDescription());
            }
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
            if (retrievedCase.getEval() < THRESHOLD_ACTIVE_LEARNING ) {
                message = createAlertFlor(isTurn, gameState, (GenericDescription) retrievedCase.get_case().getDescription());
            } else {
                message = reasoningFlor(gameState, (GenericDescription) retrievedCase.get_case().getDescription());
            }
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
            if (retrievedCase.getEval() < THRESHOLD_ACTIVE_LEARNING ) {
                message = createAlertTruco(isTurn, gameState, (GenericDescription) retrievedCase.get_case().getDescription());
            } else {
                message = reasoningTruco(gameState, (GenericDescription) retrievedCase.get_case().getDescription(), isTurn);
            }
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
            if (retrievedCase.getEval() < THRESHOLD_ACTIVE_LEARNING ) {
                message = createAlertPlayCard(isTurn, gameState, (GenericDescription) retrievedCase.get_case().getDescription());
            } else {
                message = reasoningPlayCard(gameState, (GenericDescription) retrievedCase.get_case().getDescription());
            }
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

    public Message createAlertEnvido(boolean isTurn, GameState gameState, GenericDescription retrievedCase) {
        Message msg = new Message();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Active Learning Deception ");
        alert.setHeaderText("What Envido decision to make");

        String content = "Game State";
        content += "\n";
        content += "\n :: Agent Information ::";
        content += "\n Points: " + gameState.getAgentPoints();
        content += "\n Envido Points: " + gameState.getEnvidoPoints();
        content += "\n Hand Cards: " + getHandCardsAlert(gameState);
        content += "\n Played Cards: " + getPlayedCardsAlert(1, gameState);
        content += "\n ::::::::::::::::";
        content += "\n :: Opponent Information ::";
        content += "\n Opponent Points: " + gameState.getOpponentPoints();
        content += "\n Envido Points: " + gameState.getOpponentEnvidoPoints();
        content += "\n Played Cards: " + getPlayedCardsAlert(2, gameState);
        content += "\n ::::::::::::::::";
        content += "\n :: Hand History ::";
        content += "\n Flor History: " + getFlorHistoryAlert(gameState);
        content += "\n Envido History: " + getEnvidoHistoryAlert(gameState);
        content += "\n Truco History: " + getTrucoHistoryAlert(gameState);
        content += "\n ::::::::::::::::";

        alert.setContentText(content);

        LinkedList<ButtonType> buttons = new LinkedList<>();

        ButtonType btnEnvido = new ButtonType("Envido");
        ButtonType btnEnvidoEnvido = new ButtonType("Envido Envido");
        ButtonType btnRealEnvido = new ButtonType("Real Envido");
        ButtonType btnFaltaEnvido = new ButtonType("Falta Envido");
        ButtonType btnNoCall = new ButtonType("No Call");
        ButtonType btnAccept = new ButtonType("Quero");
        ButtonType btnDecline = new ButtonType("Não Quero");


        ButtonType btnCancel = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

        if (isTurn) {
            logger.debug("ENVIDO.size() = " + gameState.getEnvidoSize());
            if (!gameState.isEnvido() && !gameState.isFlor()) {
                buttons.add(btnEnvido);
                buttons.add(btnRealEnvido);
                buttons.add(btnFaltaEnvido);
                buttons.add(btnNoCall);
            }
        } else {

            switch (gameState.getStateDecisionToken()) {
                //0: NÃO ACEITAR 1: ACEITAR; 2: ENVIDO_ENVIDO; 3: REAL_ENVIDO; 4: FALTA_ENVIDO
                case ENVIDO:
                    buttons.add(btnEnvidoEnvido);
                    buttons.add(btnRealEnvido);
                    buttons.add(btnFaltaEnvido);
                    buttons.add(btnAccept);
                    buttons.add(btnDecline);
                    break;
                //0: NÃO ACEITAR 1: ACEITAR; 3: REAL_ENVIDO; 4: FALTA_ENVIDO
                case ENVIDO_ENVIDO:
                    buttons.add(btnRealEnvido);
                    buttons.add(btnFaltaEnvido);
                    buttons.add(btnAccept);
                    buttons.add(btnDecline);
                    break;
                //0: NÃO ACEITAR 1: ACEITAR; 4: FALTA_ENVIDO
                case REAL_ENVIDO:
                    buttons.add(btnFaltaEnvido);
                    buttons.add(btnAccept);
                    buttons.add(btnDecline);
                    break;
                //0: NÃO ACEITAR 1: ACEITAR;
                case FALTA_ENVIDO:
                    buttons.add(btnAccept);
                    buttons.add(btnDecline);
                    break;
            }
        }

        buttons.add(btnCancel);

        switch (buttons.size()) {
            case 1:
                alert.getButtonTypes().setAll(buttons.get(0));
                break;
            case 2:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1));
                break;
            case 3:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2));
                break;
            case 4:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3));
                break;
            case 5:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3),
                        buttons.get(4));
                break;
            case 6:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3),
                        buttons.get(4), buttons.get(5));
                break;
            case 7:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3),
                        buttons.get(4), buttons.get(5), buttons.get(6));
                break;
            case 8:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3),
                        buttons.get(4), buttons.get(5), buttons.get(6));
                break;
        }

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == btnEnvido){
            msg.setAction("ENVIDO");
            msg.setInfo("1");
            System.out.println("btnEnvido");
        } else if (result.get() == btnEnvidoEnvido) {
            msg.setAction("ENVIDO");
            msg.setInfo("2");
            System.out.println("btnEnvidoEnvido");
        } else if (result.get() == btnRealEnvido) {
            msg.setAction("ENVIDO");
            msg.setInfo("3");
            System.out.println("btnRealEnvido");
        } else if (result.get() == btnFaltaEnvido) {
            msg.setAction("ENVIDO");
            msg.setInfo("4");
            System.out.println("btnFaltaEnvido");
        } else if (result.get() == btnAccept) {
            msg.setAction("QUERO");
            msg.setInfo("1");
            System.out.println("btnAccept");
        } else if (result.get() == btnDecline) {
            msg.setAction("NAO_QUERO");
            msg.setInfo("1");
            System.out.println("btnDecline");
        } else if (result.get() == btnNoCall) {
            msg = null;
            System.out.println("btnNoCall");
        } else {
            msg = reasoningEnvido(gameState, retrievedCase);
        }

        return msg;

    }

    public Message createAlertFlor(boolean isTurn, GameState gameState, GenericDescription retrievedCase) {

        Message msg = new Message();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Active Learning Deception ");
        alert.setHeaderText("What Flor decision to make");

        String content = "Game State";
        content += "\n";
        content += "\n :: Agent Information ::";
        content += "\n Points: " + gameState.getAgentPoints();
        content += "\n Envido Points: " + gameState.getEnvidoPoints();
        content += "\n Hand Cards: " + getHandCardsAlert(gameState);
        content += "\n Played Cards: " + getPlayedCardsAlert(1, gameState);
        content += "\n ::::::::::::::::";
        content += "\n :: Opponent Information ::";
        content += "\n Opponent Points: " + gameState.getOpponentPoints();
        content += "\n Envido Points: " + gameState.getOpponentEnvidoPoints();
        content += "\n Played Cards: " + getPlayedCardsAlert(2, gameState);
        content += "\n ::::::::::::::::";
        content += "\n :: Hand History ::";
        content += "\n Flor History: " + getFlorHistoryAlert(gameState);
        content += "\n Envido History: " + getEnvidoHistoryAlert(gameState);
        content += "\n Truco History: " + getTrucoHistoryAlert(gameState);
        content += "\n ::::::::::::::::";

        alert.setContentText(content);

        LinkedList<ButtonType> buttons = new LinkedList<>();

        ButtonType btnFlorFlor = new ButtonType("Flor Flor");
        ButtonType btnContraFlor = new ButtonType("Contra Flor");
        ButtonType btnContraFlorFalta = new ButtonType("Contra Flor Falta");
        ButtonType btnContraFlorResto = new ButtonType("Contra Flor Resto");
        ButtonType btnAccept = new ButtonType("Quero");
        ButtonType btnDecline = new ButtonType("Me Achico");


        ButtonType btnCancel = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

        if (!isTurn) {

            switch (gameState.getStateDecisionToken()) {
                //0: NADA 2: FLOR_FLOR; 3: CONTRA_FLOR;
                case FLOR:
                    buttons.add(btnFlorFlor);
                    buttons.add(btnContraFlor);
                    break;
                //0: NÃO ACEITAR 1: ACEITAR; 3: CONTRA_FLOR;
                case FLOR_FLOR:
                    buttons.add(btnContraFlor);
                    buttons.add(btnAccept);
                    buttons.add(btnDecline);
                    break;
                //0: NÃO ACEITAR 1: ACEITAR; 4: CONTRA_FLOR_FALTA; 5: CONTRA_FLOR_RESTO;
                case CONTRA_FLOR:
                    buttons.add(btnContraFlorFalta);
                    buttons.add(btnContraFlorResto);
                    buttons.add(btnAccept);
                    buttons.add(btnDecline);
                    break;
                //0: NÃO ACEITAR 1: ACEITAR;  5: CONTRA_FLOR_RESTO;
                case CONTRA_FLOR_FALTA:
                    buttons.add(btnContraFlorResto);
                    buttons.add(btnAccept);
                    buttons.add(btnDecline);
                    break;
                //0: NÃO ACEITAR 1: ACEITAR;
                case CONTRA_FLOR_RESTO:
                    buttons.add(btnAccept);
                    buttons.add(btnDecline);
                    break;
            }
        }

        buttons.add(btnCancel);

        switch (buttons.size()) {
            case 1:
                alert.getButtonTypes().setAll(buttons.get(0));
                break;
            case 2:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1));
                break;
            case 3:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2));
                break;
            case 4:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3));
                break;
            case 5:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3),
                        buttons.get(4));
                break;
            case 6:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3),
                        buttons.get(4), buttons.get(5));
                break;
            case 7:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3),
                        buttons.get(4), buttons.get(5), buttons.get(6));
                break;
        }

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == btnFlorFlor){
            msg.setAction("FLOR");
            msg.setInfo("2");
            System.out.println("btnFlorFlor");
        } else if (result.get() == btnContraFlor) {
            msg.setAction("FLOR");
            msg.setInfo("3");
            System.out.println("btnContraFlor");
        } else if (result.get() == btnContraFlorFalta) {
            msg.setAction("FLOR");
            msg.setInfo("4");
            System.out.println("btnContraFlorFalta");
        } else if (result.get() == btnContraFlorResto) {
            msg.setAction("FLOR");
            msg.setInfo("5");
            System.out.println("btnContraFlorResto");
        } else if (result.get() == btnAccept) {
            msg.setAction("QUERO");
            msg.setInfo("3");
            System.out.println("btnAccept");
        } else if (result.get() == btnDecline) {
            msg.setAction("NAO_QUERO");
            msg.setInfo("3");
            System.out.println("btnDecline");
        }  else {
            msg = reasoningFlor(gameState, retrievedCase);
        }

        return msg;

    }

    public Message createAlertTruco(boolean isTurn, GameState gameState, GenericDescription retrievedCase) {

        Message msg = new Message();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Active Learning Deception");
        alert.setHeaderText("What Truco decision to make");

        String content = "Game State";
        content += "\n";
        content += "\n :: Agent Information ::";
        content += "\n Points: " + gameState.getAgentPoints();
        content += "\n Envido Points: " + gameState.getEnvidoPoints();
        content += "\n Hand Cards: " + getHandCardsAlert(gameState);
        content += "\n Played Cards: " + getPlayedCardsAlert(1, gameState);
        content += "\n ::::::::::::::::";
        content += "\n :: Opponent Information ::";
        content += "\n Opponent Points: " + gameState.getOpponentPoints();
        content += "\n Envido Points: " + gameState.getOpponentEnvidoPoints();
        content += "\n Played Cards: " + getPlayedCardsAlert(2, gameState);
        content += "\n ::::::::::::::::";
        content += "\n :: Hand History ::";
        content += "\n Flor History: " + getFlorHistoryAlert(gameState);
        content += "\n Envido History: " + getEnvidoHistoryAlert(gameState);
        content += "\n Truco History: " + getTrucoHistoryAlert(gameState);
        content += "\n ::::::::::::::::";

        alert.setContentText(content);


        LinkedList<ButtonType> buttons = new LinkedList<>();


        ButtonType btnTruco = new ButtonType("Truco");
        ButtonType btnRetruco = new ButtonType("Retruco");
        ButtonType btnVale4 = new ButtonType("Vale 4");
        ButtonType btnAccept = new ButtonType("Quero");
        ButtonType btnDecline = new ButtonType("Não Quero");
        ButtonType btnNoCall = new ButtonType("No Call");

        ButtonType btnCancel = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);


        if (isTurn) {

            logger.debug("TRUCO.size() = " + gameState.getTrucoSize());
            switch (gameState.getTrucoSize()) {
                case 0:
                    buttons.add(btnTruco);
                    buttons.add(btnNoCall);
                    break;
                case 1:
                    if (!gameState.isLastRaise()) {
                        buttons.add(btnRetruco);
                        buttons.add(btnNoCall);
                    }
                    break;
                case 2:
                    if (!gameState.isLastRaise()) {
                        buttons.add(btnVale4);
                        buttons.add(btnNoCall);
                    }
                    break;
            }

        } else {

            switch (gameState.getStateDecisionToken()) {
                case TRUCO:
                    //0: NÃO ACEITAR 1: ACEITAR; 2: RETRUCO
                    buttons.add(btnRetruco);
                    buttons.add(btnAccept);
                    buttons.add(btnDecline);
                    break;
                case RETRUCO:
                    //0: NÃO ACEITAR 1: ACEITAR; 3: VALE4
                    buttons.add(btnVale4);
                    buttons.add(btnAccept);
                    buttons.add(btnDecline);
                    break;
                case VALE4:
                    //0: NÃO ACEITAR 1: ACEITAR;
                    buttons.add(btnAccept);
                    buttons.add(btnDecline);
                    break;
            }
        }

        buttons.add(btnCancel);

        switch (buttons.size()) {
            case 1:
                alert.getButtonTypes().setAll(buttons.get(0));
                break;
            case 2:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1));
                break;
            case 3:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2));
                break;
            case 4:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3));
                break;
            case 5:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3),
                        buttons.get(4));
                break;
            case 6:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3),
                        buttons.get(4), buttons.get(5));
                break;
            case 7:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3),
                        buttons.get(4), buttons.get(5), buttons.get(6));
                break;
        }

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == btnTruco){
            msg.setAction("TRUCO");
            msg.setInfo("1");
            System.out.println("btnTruco");
        } else if (result.get() == btnRetruco) {
            msg.setAction("TRUCO");
            msg.setInfo("2");
            System.out.println("btnRetruco");
        } else if (result.get() == btnVale4) {
            msg.setAction("TRUCO");
            msg.setInfo("3");
            System.out.println("btnVale4");
        } else if (result.get() == btnAccept) {
            msg.setAction("QUERO");
            msg.setInfo("2");
            System.out.println("btnAccept");
        } else if (result.get() == btnDecline) {
            msg.setAction("NAO_QUERO");
            msg.setInfo("2");
            System.out.println("btnDecline");
        } else if (result.get() == btnNoCall) {
            msg = null;
            System.out.println("btnNoCall");
        } else {
            msg = reasoningTruco(gameState, retrievedCase, isTurn);
        }

        return msg;
    }

    public Message createAlertPlayCard(boolean isTurn, GameState gameState, GenericDescription retrievedCase) {

        Message msg = new Message();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Active Learning Deception");
        alert.setHeaderText("What Card to play");

        String content = "Game State";
        content += "\n";
        content += "\n :: Agent Information ::";
        content += "\n Points: " + gameState.getAgentPoints();
        content += "\n Envido Points: " + gameState.getEnvidoPoints();
        content += "\n Hand Cards: " + getHandCardsAlert(gameState);
        content += "\n Played Cards: " + getPlayedCardsAlert(1, gameState);
        content += "\n ::::::::::::::::";
        content += "\n :: Opponent Information ::";
        content += "\n Opponent Points: " + gameState.getOpponentPoints();
        content += "\n Envido Points: " + gameState.getOpponentEnvidoPoints();
        content += "\n Played Cards: " + getPlayedCardsAlert(2, gameState);
        content += "\n ::::::::::::::::";
        content += "\n :: Hand History ::";
        content += "\n Flor History: " + getFlorHistoryAlert(gameState);
        content += "\n Envido History: " + getEnvidoHistoryAlert(gameState);
        content += "\n Truco History: " + getTrucoHistoryAlert(gameState);
        content += "\n ::::::::::::::::";

        alert.setContentText(content);


        LinkedList<ButtonType> buttons = new LinkedList<>();

        ArrayList<Card> cards = gameState.getHandCards();

        ButtonType btnCarta1 = null;
        ButtonType btnCarta2 = null;
        ButtonType btnCarta3 = null;
        ButtonType btnIrBaralho = new ButtonType("Ir Baralho");
        ButtonType btnCancel = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

        Card card1  = null;
        Card card2  = null;
        Card card3  = null;

        if (cards.size() == 1) {
            card1 = cards.get(0);//cards.get(0).getFace().name() + "-" + cards.get(0).getSuit().name();
            btnCarta1 = new ButtonType(cards.get(0).getFace().name() + "-" + cards.get(0).getSuit().name());
        } else if (cards.size() == 2) {
            card1 = cards.get(0);
            card2 = cards.get(1);
            btnCarta1 = new ButtonType(cards.get(0).getFace().name() + "-" + cards.get(0).getSuit().name());
            btnCarta2 = new ButtonType(cards.get(1).getFace().name() + "-" + cards.get(1).getSuit().name());
        } else if (cards.size() == 3) {
            card1 = cards.get(0);
            card2 = cards.get(1);
            card3 = cards.get(2);
            btnCarta1 = new ButtonType(cards.get(0).getFace().name() + "-" + cards.get(0).getSuit().name());
            btnCarta2 = new ButtonType(cards.get(1).getFace().name() + "-" + cards.get(1).getSuit().name());
            btnCarta3 = new ButtonType(cards.get(2).getFace().name() + "-" + cards.get(2).getSuit().name());
        }

        if (btnCarta1 != null) {
            buttons.add(btnCarta1);
        }

        if (btnCarta2 != null) {
            buttons.add(btnCarta2);
        }

        if (btnCarta3 != null) {
            buttons.add(btnCarta3);
        }

        buttons.add(btnIrBaralho);
        buttons.add(btnCancel);

        switch (buttons.size()) {
            case 1:
                alert.getButtonTypes().setAll(buttons.get(0));
                break;
            case 2:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1));
                break;
            case 3:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2));
                break;
            case 4:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3));
                break;
            case 5:
                alert.getButtonTypes().setAll(buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3),
                        buttons.get(4));
                break;
        }

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == btnCarta1){
            msg.setAction("PLAY_CARD");
            msg.setCard(card1);
            System.out.println(card1.getCbrCode());
        } else if (result.get() == btnCarta2) {
            msg.setAction("PLAY_CARD");
            msg.setCard(card2);
            System.out.println(card2.getCbrCode());
        } else if (result.get() == btnCarta3) {
            msg.setAction("PLAY_CARD");
            msg.setCard(card3);
            System.out.println(card3.getCbrCode());
        } else if (result.get() == btnIrBaralho) {
            msg.setAction("IR_BARALHO");
            System.out.println("btnIrBaralho");
        } else {
            msg = reasoningPlayCard(gameState, retrievedCase);
        }

        return msg;
    }

    public String getHandCardsAlert(GameState gameState) {

        String handCards = "";

        ArrayList<Card> cards = gameState.getHandCards();

        if (cards.size() > 0) {
            for (Card card : cards) {
                handCards += card.getFace().name() + "-" + card.getSuit().name() + "; ";
            }
        }

        return handCards;
    }

    public String getPlayedCardsAlert(int player, GameState gameState) {

        String playedCards = "";

        if (player == 1) {
            if (gameState.getAgentPlayedCards().size() > 0) {
                for (Card card : gameState.getAgentPlayedCards()) {
                    playedCards += card.getFace().name() + "-" + card.getSuit().name() + "; ";
                }
            }
        } else {
            if (gameState.getOpponentPlayedCards().size() > 0) {
                for (Card card : gameState.getOpponentPlayedCards()) {
                    if (card != null) {
                        playedCards += card.getFace().name() + "-" + card.getSuit().name() + "; ";
                    } else {
                        playedCards += "Face Down Card; ";
                    }

                }
            }
        }

        return playedCards;
    }


    public String getEnvidoHistoryAlert(GameState gameState) {

        String envidoHistory = "";

        if (gameState.getEnvidoHistory().size() > 0) {
            for (Action action : gameState.getEnvidoHistory()) {
                envidoHistory += action.getPlayer() + "-" + action.getAction() + " --> \n";
            }
        }

        return envidoHistory;

    }

    public String getFlorHistoryAlert(GameState gameState) {

        String florHistory = "";

        if (gameState.getFlorHistory().size() > 0) {
            for (Action action : gameState.getFlorHistory()) {
                florHistory += action.getPlayer() + "-" + action.getAction() + " --> \n";
            }
        }

        return florHistory;

    }

    public String getTrucoHistoryAlert(GameState gameState) {

        String trucoHistory = "";

        if (gameState.getTrucoHistory().size() > 0) {
            for (Action action : gameState.getTrucoHistory()) {
                trucoHistory += action.getPlayer() + "-" + action.getAction() + "-->";
            }
        }

        return trucoHistory;

    }

}


