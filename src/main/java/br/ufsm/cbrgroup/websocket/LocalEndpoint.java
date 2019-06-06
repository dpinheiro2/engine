package br.ufsm.cbrgroup.websocket;


import br.ufsm.cbrgroup.Agent;
import br.ufsm.cbrgroup.enums.Face;
import br.ufsm.cbrgroup.enums.StateDecisionToken;
import br.ufsm.cbrgroup.enums.StateDecisionTurn;
import br.ufsm.cbrgroup.enums.Suit;
import br.ufsm.cbrgroup.model.Card;
import com.google.gson.Gson;
import javafx.application.Platform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.spi.JsonProvider;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;


/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 16/10/2018.
 */


public class LocalEndpoint extends Endpoint implements MessageHandler.Whole<String>{

    private static Logger logger = LogManager.getLogger(LocalEndpoint.class);

    static Session session;
    public Agent agent;

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public void esperar(int i) {
        int time = i*1000;
        try {
            Thread.currentThread().sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        logger.info("Endpoint opened, session = " + session + ", config = " + config);
        logger.debug("OPEN SESSION: " + session);
        this.session = session;
        this.session.addMessageHandler(this);
    }

    @Override
    public void onMessage(String message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                JsonReader reader = Json.createReader(new StringReader(message));
                JsonObject messageJson = reader.readObject();
                logger.info("MSG_RECEBIDA: " + messageJson.toString());
                Message action;
                switch (messageJson.getString("action")) {
                    case "WAIT":
                        logger.debug("WAIT");
                        System.out.println("Aguardando oponente!");
                        break;
                    case "START":
                        logger.debug("START");
                        agent.getGameState().initHand();
                        agent.getGameState().setStateDecisionTurn(StateDecisionTurn.START_HAND);
                        agent.getGameState().setHand(messageJson.getBoolean("isHand"));
                        agent.getGameState().setTurno(messageJson.getBoolean("isTurn"));
                        agent.getGameState().setToken(messageJson.getBoolean("isToken"));
                        agent.getGameState().setHasFlor(messageJson.getBoolean("hasFlor"));
                        setReceiptCards(messageJson);
                        agent.getGameState().setCurrentRound(1);
                        if (agent.getGameState().isTurno()) {
                            action = agent.receivedTurn();
                            if (action != null) executeAction(action);
                        }
                        break;
                    case "SHIFT_TURN":
                        logger.debug("SHIFT_TURN");
                        agent.getGameState().setTurno(messageJson.getBoolean("isTurn"));
                        agent.getGameState().setToken(messageJson.getBoolean("isToken"));
                        break;
                    case "SHIFT_TOKEN":
                        logger.debug("SHIFT_TOKEN");
                        agent.getGameState().setToken(messageJson.getBoolean("isToken"));
                        break;
                    case "FLOR":
                        logger.debug("FLOR");
                        int tipoFlor = messageJson.getInt("tipoFlor");
                        agent.getGameState().setHasFlor(messageJson.getBoolean("hasFlor"));
                        agent.getGameState().setFlorLevel(messageJson.getInt("tipoFlor"));
                        agent.getGameState().setFlorSize(messageJson.getInt("florSize"));
                        agent.getGameState().setFlor(true);
                        agent.getGameState().setEnvido(false);
                        agent.getGameState().setTruco(false);
                        agent.getGameState().setLastFlorRaise(messageJson.getBoolean("isPediu"));
                        switch (tipoFlor) {
                            case 1:
                                agent.getGameState().setStateDecisionToken(StateDecisionToken.FLOR);
                                break;
                            case 2:
                                agent.getGameState().setStateDecisionToken(StateDecisionToken.FLOR_FLOR);
                                break;
                            case 3:
                                agent.getGameState().setStateDecisionToken(StateDecisionToken.CONTRA_FLOR);
                                break;
                            case 4:
                                agent.getGameState().setStateDecisionToken(StateDecisionToken.CONTRA_FLOR_FALTA);
                                break;
                            case 5:
                                agent.getGameState().setStateDecisionToken(StateDecisionToken.CONTRA_FLOR_RESTO);
                                break;
                        }
                        if (agent.getGameState().isToken()) {

                            if (!agent.getGameState().isLastFlorRaise() && agent.getGameState().isHasFlor()) {

                                action = agent.receivedToken();
                                if (action != null) executeAction(action);

                            } else {

                                action = agent.receivedTurn();
                                if (action != null) executeAction(action);
                            }
                        }
                        break;
                    case "ENVIDO":
                        logger.debug("ENVIDO");
                        int tipoEnvido = messageJson.getInt("tipoEnvido");
                        agent.getGameState().setHasFlor(messageJson.getBoolean("hasFlor"));
                        agent.getGameState().setEnvidoLevel(messageJson.getInt("tipoEnvido"));
                        agent.getGameState().setEnvidoSize(messageJson.getInt("envidoSize"));
                        agent.getGameState().setEnvido(true);
                        agent.getGameState().setLastEnvidoRaise(messageJson.getBoolean("isPediu"));
                        agent.getGameState().setTruco(false);
                        switch (tipoEnvido) {
                            case 1:
                                agent.getGameState().setStateDecisionToken(StateDecisionToken.ENVIDO);
                                break;
                            case 2:
                                agent.getGameState().setStateDecisionToken(StateDecisionToken.ENVIDO_ENVIDO);
                                break;
                            case 3:
                                agent.getGameState().setStateDecisionToken(StateDecisionToken.REAL_ENVIDO);
                                break;
                            case 4:
                                agent.getGameState().setStateDecisionToken(StateDecisionToken.FALTA_ENVIDO);
                                break;
                        }
                        if (agent.getGameState().isToken()) {

                            action = agent.receivedToken();
                            if (action != null) executeAction(action);
                        }
                        break;
                    case "TRUCO":
                        logger.debug("TRUCO");
                        int tipoTruco = messageJson.getInt("tipoTruco");
                        agent.getGameState().setHasFlor(messageJson.getBoolean("hasFlor"));
                        agent.getGameState().setTruco(true);
                        agent.getGameState().setLastRaise(messageJson.getBoolean("isPediu"));
                        switch (tipoTruco) {
                            case 1:
                                agent.getGameState().setStateDecisionToken(StateDecisionToken.TRUCO);
                                break;
                            case 2:
                                agent.getGameState().setStateDecisionToken(StateDecisionToken.RETRUCO);
                                break;
                            case 3:
                                agent.getGameState().setStateDecisionToken(StateDecisionToken.VALE4);
                                break;
                        }
                        if (agent.getGameState().isToken()) {
                            action = agent.receivedToken();
                            if (action != null) executeAction(action);
                        }
                        break;
                    case "PLAY_CARD":
                        logger.debug("PLAY_CARD");
                        JsonReader jsonReader = Json.createReader(new StringReader(messageJson.getString("card")));
                        JsonObject card = jsonReader.readObject();
                        String face = card.getString("face");
                        String suit = card.getString("suit");
                        int cbrCode = card.getInt("cbrCode");
                        Card carta = new Card(getFaceByString(face), getSuitByString(suit), cbrCode);
                        agent.getGameState().addCardTable(carta);
                        agent.getGameState().processaRound(carta, messageJson.getBoolean("isPlayed") ? 1 : 2);
                        if (messageJson.getBoolean("isPlayed")) {
                            agent.getGameState().getAgentPlayedCards().add(carta);
                            logger.debug("AgentCards: " + agent.getGameState().getAgentPlayedCards().toString());
                        } else {
                            agent.getGameState().getOpponentPlayedCards().add(carta);
                            logger.debug("OpponentCards: " + agent.getGameState().getOpponentPlayedCards().toString());
                        }

                        setStateTurn(agent.getGameState().getDealtCards().size());

                        if (agent.getGameState().isToken() && !agent.getGameState().isHandFinish()) {

                            action = agent.receivedTurn();
                            if (action != null) executeAction(action);
                        }
                        break;
                    case "FACE_DOWN_CARD":
                        logger.debug("FACE_DOWN_CARD");
                        Card faceDowncarta = null;
                        agent.getGameState().addCardTable(faceDowncarta);
                        agent.getGameState().processaRound(null, messageJson.getBoolean("isPlayed") ? 1 : 2);
                        agent.getGameState().setOpponentCartaVirada(agent.getGameState().getCurrentRound());
                        agent.getGameState().setTurno(!messageJson.getBoolean("isPlayed"));
                        if (!messageJson.getBoolean("isPlayed")) {
                            agent.getGameState().getOpponentPlayedCards().add(faceDowncarta);
                        } else {
                            //TODO: add nas cartas jogadas do agente a certa jogada virada
                        }

                        setStateTurn(agent.getGameState().getDealtCards().size());

                        if (agent.getGameState().isToken()  && !agent.getGameState().isHandFinish()) {
                            action = agent.receivedTurn();
                            if (action != null) executeAction(action);
                        }
                        break;
                    case "RESULT_ROUND":
                        logger.debug("RESULT_ROUND");
                        if (messageJson.getInt("round") == 1 ) {
                            agent.getGameState().setWinnerRound1(messageJson.getBoolean("isWinner"));
                            agent.getGameState().setEmpateRound1(messageJson.getBoolean("isEmpate"));
                        } else if (messageJson.getInt("round") == 2 ) {
                            agent.getGameState().setWinnerRound2(messageJson.getBoolean("isWinner"));
                            agent.getGameState().setEmpateRound2(messageJson.getBoolean("isEmpate"));
                        } else if (messageJson.getInt("round") == 3 ) {
                            agent.getGameState().setWinnerRound2(messageJson.getBoolean("isWinner"));
                            agent.getGameState().setEmpateRound2(messageJson.getBoolean("isEmpate"));
                        }
                        break;
                    case "IR_BARALHO":
                        logger.debug("IR_BARALHO");
                        break;
                    case "RESULT_ENVIDO":
                        logger.debug("RESULT_ENVIDO");
                        if (agent.getGameState().isToken()) {
                            action = agent.receivedTurn();
                            if (action != null) executeAction(action);
                        }
                        break;
                    case "RESULT_ENVIDO_DECLINED":
                        logger.debug("RESULT_ENVIDO_DECLINED");
                        if (agent.getGameState().isToken()) {
                            action = agent.receivedTurn();
                            if (action != null) executeAction(action);
                        }
                        break;
                    case "RESULT_FLOR":
                        logger.debug("RESULT_FLOR");
                        if (agent.getGameState().isToken()) {
                            action = agent.receivedTurn();
                            if (action != null) executeAction(action);
                        }
                        break;
                    case "RESULT_FLOR_DECLINED":
                        logger.debug("RESULT_FLOR_DECLINED");
                        if (agent.getGameState().isToken()) {
                            action = agent.receivedTurn();
                            if (action != null) executeAction(action);
                        }
                        break;
                    case "RESULT_TRUCO_DECLINED":
                        logger.debug("RESULT_TRUCO_DECLINED");
                        break;
                    case "UPDATE_PLACAR":
                        logger.debug("UPDATE_PLACAR");
                        agent.getGameState().setAgentPoints(messageJson.getInt("myPoints"));
                        agent.getGameState().setOpponentPoints(messageJson.getInt("otherPoints"));
                        break;
                    case "FINISH_HAND":
                        esperar(5);
                        logger.debug("FINISH_HAND");
                        agent.getGameState().initHand();
                        agent.getGameState().setStateDecisionTurn(StateDecisionTurn.START_HAND);
                        agent.getGameState().setHand(messageJson.getBoolean("isHand"));
                        agent.getGameState().setTurno(messageJson.getBoolean("isTurn"));
                        agent.getGameState().setToken(messageJson.getBoolean("isToken"));
                        agent.getGameState().setHasFlor(messageJson.getBoolean("hasFlor"));
                        setReceiptCards(messageJson);
                        agent.getGameState().setCurrentRound(1);
                        if (agent.getGameState().isToken()) {
                            action = agent.receivedTurn();
                            if (action != null) executeAction(action);
                        }
                        break;
                    case "FINISH_GAME":
                        logger.debug("FINISH_GAME");
                        esperar(5);
                        break;
                    case "RESPONSE_TRUCO":
                        logger.debug("RESPONSE_TRUCO");
                        if (agent.getGameState().isToken()) {
                            action = agent.receivedTurn();
                            if (action != null) executeAction(action);
                        }
                        break;

                    case "ENVIDO_POINTS":
                        logger.debug("ENVIDO_POINTS");
                        agent.getGameState().setOpponentEnvidoPoints(messageJson.getInt("opponentEnvidoPoints"));
                        if (agent.getGameState().getOpponentEnvidoPoints() < agent.getGameState().getEnvidoPoints()) {
                            showPoints(true);
                        } else {
                            showPoints(false);
                        }
                        break;
                }

            }
        });

    }

    /** :::: Métodos para enviar mensagens ao servidor ::::*/

    public void executeAction(Message message) {

        JsonProvider provider = JsonProvider.provider();
        JsonObject jsonMessage;
        Gson gson;
        System.out.println("PPK" + message.toString());

        switch (message.getAction()) {
            case "FLOR":
                jsonMessage = provider.createObjectBuilder()
                        .add("action", message.getAction())
                        .add("tipo", message.getInfo())
                        .build();
                sendMessage(jsonMessage.toString());
                break;
            case "ENVIDO":
                jsonMessage = provider.createObjectBuilder()
                        .add("action", message.getAction())
                        .add("tipo", message.getInfo())
                        .build();
                sendMessage(jsonMessage.toString());
                break;
            case "TRUCO":
                jsonMessage = provider.createObjectBuilder()
                        .add("action", message.getAction())
                        .add("tipo", message.getInfo())
                        .build();
                sendMessage(jsonMessage.toString());
                break;
            case "IR_BARALHO":
                jsonMessage = provider.createObjectBuilder()
                        .add("action", message.getAction())
                        .build();
                sendMessage(jsonMessage.toString());
                break;
            case "QUERO":
                jsonMessage = provider.createObjectBuilder()
                        .add("action", message.getAction())
                        .add("tipo", message.getInfo())
                        .build();
                sendMessage(jsonMessage.toString());
                break;
            case "NAO_QUERO":
                jsonMessage = provider.createObjectBuilder()
                        .add("action", message.getAction())
                        .add("tipo", message.getInfo())
                        .build();
                sendMessage(jsonMessage.toString());
                break;
            case "PLAY_CARD":
                gson = new Gson();
                jsonMessage = provider.createObjectBuilder()
                        .add("action", message.getAction())
                        .add("card", gson.toJson(message.getCard()))
                        .build();
                sendMessage(jsonMessage.toString());
                break;
            case "FACE_DOWN_CARD":
                gson = new Gson();
                jsonMessage = provider.createObjectBuilder()
                        .add("action", message.getAction())
                        .add("card", gson.toJson(message.getCard()))
                        .build();
                sendMessage(jsonMessage.toString());
                break;
            case "SHOW_POINTS":
                jsonMessage = provider.createObjectBuilder()
                        .add("action", message.getAction())
                        .add("isShowPoints", message.getInfo().equals("1"))
                        .build();
                sendMessage(jsonMessage.toString());
                break;
        }

    }

    /** tipo 1-FLOR; 2-FLOR_FLOR; 3-CONTRA_FLOR; 4-CONTRA_FLOR_FALTA; 5-CONTRA_FLOR_RESTO*/
    public void callFlor(String tipo) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject jsonMessage = provider.createObjectBuilder()
                .add("action", "FLOR")
                .add("tipo", tipo)
                .build();
        sendMessage(jsonMessage.toString());
    }

    /** tipo 1-ENVIDO; 2-ENVIDO_ENVIDO; 3-REAL_ENVIDO; 4-FALTA_ENVIDO; */
    public void callEnvido(String tipo) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject jsonMessage = provider.createObjectBuilder()
                .add("action", "ENVIDO")
                .add("tipo", tipo)
                .build();
        sendMessage(jsonMessage.toString());

    }

    /** tipo 1-TRUCO; 2-RETRUCO; 3-VALE4;*/
    public void callTruco(String tipo) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject jsonMessage = provider.createObjectBuilder()
                .add("action", "TRUCO")
                .add("tipo", tipo)
                .build();
        sendMessage(jsonMessage.toString());
    }

    public void irBaralho() {
        JsonProvider provider = JsonProvider.provider();
        JsonObject jsonMessage = provider.createObjectBuilder()
                .add("action", "IR_BARALHO")
                .build();
        sendMessage(jsonMessage.toString());
    }

    /** tipo 1-ENVIDO; 2-TRUCO; 3-FLOR;*/
    public void accept(String tipo) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject jsonMessage = provider.createObjectBuilder()
                .add("action", "QUERO")
                .add("tipo", tipo)
                .build();
        sendMessage(jsonMessage.toString());
    }

    /** tipo 1-ENVIDO; 2-TRUCO; 3-FLOR;*/
    public void decline(String tipo) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject jsonMessage = provider.createObjectBuilder()
                .add("action", "NAO_QUERO")
                .add("tipo", tipo)
                .build();
        sendMessage(jsonMessage.toString());
    }


    public void playCard(Card card) {
        Gson gson = new Gson();
        JsonProvider provider = JsonProvider.provider();
        JsonObject jsonMessage = provider.createObjectBuilder()
                .add("action", "PLAY_CARD")
                .add("card", gson.toJson(card))
                .build();
        sendMessage(jsonMessage.toString());
    }

    public void playFacedDownCard(Card card) {
        Gson gson = new Gson();
        JsonProvider provider = JsonProvider.provider();
        JsonObject jsonMessage = provider.createObjectBuilder()
                .add("action", "FACE_DOWN_CARD")
                .add("card", gson.toJson(card))
                .build();
        sendMessage(jsonMessage.toString());
    }

    public void showPoints(boolean isShowPoints) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject jsonMessage = provider.createObjectBuilder()
                .add("action", "SHOW_POINTS")
                .add("isShowPoints", isShowPoints)
                .build();
        sendMessage(jsonMessage.toString());
    }

    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
            logger.info("MSG_ENVIADA: " + message);
            //System.out.println(message);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /** Úteis  */

    private void setStateTurn(int size) {
        switch (size) {
            case 1:
                agent.getGameState().setStateDecisionTurn(StateDecisionTurn.PLAY_CARD_2);
                break;
            case 2:
                agent.getGameState().setStateDecisionTurn(StateDecisionTurn.PLAY_CARD_3);
                break;
            case 3:
                agent.getGameState().setStateDecisionTurn(StateDecisionTurn.PLAY_CARD_4);
                break;
            case 4:
                agent.getGameState().setStateDecisionTurn(StateDecisionTurn.PLAY_CARD_5);
                break;
            case 5:
                agent.getGameState().setStateDecisionTurn(StateDecisionTurn.PLAY_CARD_6);
                break;
        }
    }

    public void setReceiptCards(JsonObject messageJson) {

        JsonReader reader = Json.createReader(new StringReader(messageJson.getString("cartas")));
        JsonObject cartas = reader.readObject();
        JsonArray ListCartas = cartas.getJsonArray("cards");

        for(int i=0; i<ListCartas.size();i++) {
            JsonObject temp = ListCartas.getJsonObject(i);
            String face = temp.getString("face");
            String suit = temp.getString("suit");
            int cbrCode = temp.getInt("cbrCode");
            Card card = new Card(getFaceByString(face), getSuitByString(suit), cbrCode);
            agent.getGameState().getAgentCards().add(card);
            agent.getGameState().getAgentHandCards().add(card);
            logger.info("Carta Recebida: " + card.toString());
        }
        agent.getGameState().setEnvidoPoints(agent.getGameState().getEnvidoPoints(agent.getGameState().getAgentCards()));
        Collections.sort(agent.getGameState().getAgentCards(), Card.compareCards()); //Alta-2 Media-1 Baixa-0
    }

    public Suit getSuitByString(String suitString) {
        Suit suit = null;

        switch (suitString) {
            case "ESPADAS":
                suit = Suit.ESPADAS;
                break;
            case "BASTOS":
                suit = Suit.BASTOS;
                break;
            case "OURO":
                suit = Suit.OURO;
                break;
            case "COPAS":
                suit = Suit.COPAS;
                break;
        }

        return suit;
    }


    public Face getFaceByString(String faceString) {
        Face face = null;

        switch (faceString) {
            case "AS":
                face = Face.AS;
                break;
            case "DOIS":
                face = Face.DOIS;
                break;
            case "TRES":
                face = Face.TRES;
                break;
            case "QUATRO":
                face = Face.QUATRO;
                break;
            case "CINCO":
                face = Face.CINCO;
                break;
            case "SEIS":
                face = Face.SEIS;
                break;
            case "SETE":
                face = Face.SETE;
                break;
            case "DEZ":
                face = Face.DEZ;
                break;
            case "VALETE":
                face = Face.VALETE;
                break;
            case "REI":
                face = Face.REI;
                break;
        }

        return face;
    }
}
