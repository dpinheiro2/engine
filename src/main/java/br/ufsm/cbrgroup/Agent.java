package br.ufsm.cbrgroup;

import br.ufsm.cbrgroup.cbr.learning.LearningStrategy;
import br.ufsm.cbrgroup.cbr.retrieve.RetrieveStrategy;
import br.ufsm.cbrgroup.cbr.reuse.ReuseStrategy;
import br.ufsm.cbrgroup.cbr.similarity.SimilarityStrategy;
import br.ufsm.cbrgroup.description.GenericDescription;
import br.ufsm.cbrgroup.description.RetainActiveDescription;
import br.ufsm.cbrgroup.description.RetainAllDescription;
import br.ufsm.cbrgroup.description.TrucoDescription;
import br.ufsm.cbrgroup.enums.StateDecisionToken;
import br.ufsm.cbrgroup.enums.StateDecisionTurn;
import br.ufsm.cbrgroup.enums.TypeCaseBase;
import br.ufsm.cbrgroup.game.Action;
import br.ufsm.cbrgroup.game.GameState;
import br.ufsm.cbrgroup.jcolibriex.retainactive.DBConnRetainActiveDescription;
import br.ufsm.cbrgroup.jcolibriex.retainall.DBConnRetainAllDescription;
import br.ufsm.cbrgroup.jcolibriex.DBConnTrucoDescription;
import br.ufsm.cbrgroup.model.Card;
import br.ufsm.cbrgroup.websocket.Message;
import es.ucm.fdi.gaia.jcolibri.casebase.LinealCaseBase;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCaseBase;
import es.ucm.fdi.gaia.jcolibri.cbrcore.Connector;
import es.ucm.fdi.gaia.jcolibri.exception.InitializingException;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 21/05/2019.
 */


public class Agent {

    private final int LOW_ENVIDO_POINTS = 24;
    private final int HIGH_ENVIDO_POINTS = 29;
    private final int LOW_CARD = 7;


    private RetrieveStrategy retrieveStrategy;
    private SimilarityStrategy similarityStrategy;
    private ReuseStrategy reuseStrategy;
    private LearningStrategy learningStrategy;
    private GameState gameState;
    private Connector reuseConnector;
    private CBRCaseBase reuseCaseBase;
    private Connector learningConnector;
    private CBRCaseBase learningCaseBase;
    private TypeCaseBase typeCaseBaseReuse;
    private TypeCaseBase typeCaseBaseLearning;
    private GenericDescription reuseDescription;
    private GenericDescription learningDescription;


    private static Logger logger = LogManager.getLogger(Agent.class);

    public void initializingCaseBase() {

        switch (typeCaseBaseReuse) {
            case BASELINE:
                reuseConnector = new DBConnTrucoDescription();
                reuseDescription = new TrucoDescription();
                break;
            case ACTIVE_DECEPTION:
                reuseConnector = new DBConnRetainActiveDescription();
                reuseDescription = new RetainActiveDescription();
                break;
            case RETAIN_ALL:
                reuseConnector = new DBConnRetainAllDescription();
                reuseDescription = new RetainAllDescription();
                break;
        }

        switch (typeCaseBaseLearning) {
            case ACTIVE_DECEPTION:
                learningConnector = new DBConnRetainActiveDescription();
                learningDescription = new RetainActiveDescription();
                break;
            case RETAIN_ALL:
                learningConnector = new DBConnRetainAllDescription();
                learningDescription = new RetainAllDescription();
                break;
            case NONE:
                learningConnector = null;
                learningDescription = new TrucoDescription();
                break;
        }

        reuseCaseBase = new LinealCaseBase();
        learningCaseBase = new LinealCaseBase();

        try {
            reuseCaseBase.init(reuseConnector);
            if (learningConnector != null) {
                learningCaseBase.init(learningConnector);
            }


        } catch (InitializingException ie) {
            ie.printStackTrace();
        }

    }

    public Connector getReuseConnector() {
        return reuseConnector;
    }

    public void setReuseConnector(Connector reuseConnector) {
        this.reuseConnector = reuseConnector;
    }

    public GenericDescription getLearningDescription() {
        return learningDescription;
    }

    public void setLearningDescription(GenericDescription learningDescription) {
        this.learningDescription = learningDescription;
    }

    public RetrieveStrategy getRetrieveStrategy() {
        return retrieveStrategy;
    }

    public void setRetrieveStrategy(RetrieveStrategy retrieveStrategy) {
        this.retrieveStrategy = retrieveStrategy;
    }

    public SimilarityStrategy getSimilarityStrategy() {
        return similarityStrategy;
    }

    public void setSimilarityStrategy(SimilarityStrategy similarityStrategy) {
        this.similarityStrategy = similarityStrategy;
    }

    public ReuseStrategy getReuseStrategy() {
        return reuseStrategy;
    }

    public void setReuseStrategy(ReuseStrategy reuseStrategy) {
        this.reuseStrategy = reuseStrategy;
    }

    public LearningStrategy getLearningStrategy() {
        return learningStrategy;
    }

    public void setLearningStrategy(LearningStrategy learningStrategy) {
        this.learningStrategy = learningStrategy;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public CBRCaseBase getReuseCaseBase() {
        return reuseCaseBase;
    }

    public void setReuseCaseBase(CBRCaseBase reuseCaseBase) {
        this.reuseCaseBase = reuseCaseBase;
    }

    public CBRCaseBase getLearningCaseBase() {
        return learningCaseBase;
    }

    public void setLearningCaseBase(CBRCaseBase learningCaseBase) {
        this.learningCaseBase = learningCaseBase;
    }

    public TypeCaseBase getTypeCaseBaseReuse() {
        return typeCaseBaseReuse;
    }

    public void setTypeCaseBaseReuse(TypeCaseBase typeCaseBaseReuse) {
        this.typeCaseBaseReuse = typeCaseBaseReuse;
    }

    public TypeCaseBase getTypeCaseBaseLearning() {
        return typeCaseBaseLearning;
    }

    public void setTypeCaseBaseLearning(TypeCaseBase typeCaseBaseLearning) {
        this.typeCaseBaseLearning = typeCaseBaseLearning;
    }

    public GenericDescription getQueryEnvido() {
        return retrieveStrategy.getQueryEnvido(gameState, reuseDescription);
    }

    public GenericDescription getQueryFlor() {
        return retrieveStrategy.getQueryFlor(gameState, reuseDescription);
    }

    public GenericDescription getQueryTruco() {
        return retrieveStrategy.getQueryTruco(gameState, reuseDescription);
    }

    public GenericDescription getQueryPlayCard() {
        return retrieveStrategy.getQueryPlayCard(gameState, reuseDescription);
    }

    public GenericDescription getQueryShowPoints() {
        return retrieveStrategy.getQueryShowPoints(gameState, reuseDescription);
    }

    public NNConfig getSimConfigEnvido(GenericDescription gameStateQuery){
        return similarityStrategy.getSimConfigEnvido(gameStateQuery);
    }

    public NNConfig getSimConfigFlor(GenericDescription gameStateQuery){
        return similarityStrategy.getSimConfigFlor(gameStateQuery);
    }

    public NNConfig getSimConfigTruco(GenericDescription gameStateQuery){
        return similarityStrategy.getSimConfigTruco(gameStateQuery);
    }

    public NNConfig getSimConfigPlayCard(GenericDescription gameStateQuery){
        return similarityStrategy.getSimConfigPlayCard(gameStateQuery);
    }

    public NNConfig getSimConfigShowPoints(GenericDescription gameStateQuery){
        return similarityStrategy.getSimConfigShowPoints(gameStateQuery);
    }

    public Message decisionMakingEnvido(boolean isTurn) {

        GenericDescription query = getQueryEnvido();
        NNConfig simConfig = getSimConfigEnvido(query);

        return reuseStrategy.decisionMakingEnvido(reuseCaseBase, gameState, query, simConfig, isTurn);
    }

    public Message decisionMakingFlor(boolean isTurn) {

        GenericDescription query = getQueryFlor();
        NNConfig simConfig = getSimConfigFlor(query);

        return reuseStrategy.decisionMakingFlor(reuseCaseBase, gameState, query, simConfig, isTurn);

    }

    public Message decisionMakingTruco(boolean isTurn) {

        GenericDescription query = getQueryTruco();
        NNConfig simConfig = getSimConfigTruco(query);

       /* if (learningStrategy != null && ((gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_5 &&
                gameState.getLastCardHand().getCbrCode() < 8) ||
                ((gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_6)))
                ) {

           return createAlert(isTurn);

        } else {*/
        return reuseStrategy.decisionMakingTruco(reuseCaseBase, gameState, query, simConfig, isTurn);
        /*}*/


    }

    public Message decisionMakingPlayCard(boolean isTurn) {

        GenericDescription query = getQueryPlayCard();
        NNConfig simConfig = getSimConfigPlayCard(query);

        return reuseStrategy.decisionMakingPlayCard(reuseCaseBase, gameState, query, simConfig, isTurn);

    }

    public Message decisionMakingShowPoints(boolean isTurn) {

        return null;
    }

    public void learningCriteria() {

        learningStrategy.learningCriteria(learningDescription, learningCaseBase);
    }

    public Message receivedToken() {
        logger.debug("receivedToken");
        Message msg = null;

        if (gameState.getStateDecisionToken() == StateDecisionToken.FLOR || gameState.getStateDecisionToken() == StateDecisionToken.FLOR_FLOR
                || gameState.getStateDecisionToken() == StateDecisionToken.CONTRA_FLOR || gameState.getStateDecisionToken() == StateDecisionToken.CONTRA_FLOR_FALTA
                || gameState.getStateDecisionToken() == StateDecisionToken.CONTRA_FLOR_RESTO) {

            if (gameState.isHasFlor()) {
                msg = decisionMakingFlor(false);
                if (msg != null) {
                    System.out.println(msg.toString());
                    return msg;
                }
            }


        } else if (gameState.getStateDecisionToken() == StateDecisionToken.ENVIDO || gameState.getStateDecisionToken() == StateDecisionToken.ENVIDO_ENVIDO
                || gameState.getStateDecisionToken() == StateDecisionToken.REAL_ENVIDO || gameState.getStateDecisionToken() == StateDecisionToken.FALTA_ENVIDO) {

            if (gameState.isHasFlor() && !gameState.isFlor()) {
                msg = new Message();
                msg.setAction("FLOR");
                msg.setInfo("1");
                return msg;
            } else {
                msg = decisionMakingEnvido(false);
                if (msg != null) {
                    System.out.println(msg.toString());
                    return msg;
                }
            }

        } else if (gameState.getStateDecisionToken() == StateDecisionToken.TRUCO || gameState.getStateDecisionToken() == StateDecisionToken.RETRUCO
                || gameState.getStateDecisionToken() == StateDecisionToken.VALE4) {

            if (gameState.isHasFlor() && !gameState.isFlor() && gameState.getCurrentRound() == 1 &&
                    !gameState.isEnvido() && gameState.getStateDecisionToken() == StateDecisionToken.TRUCO ) {
                msg = new Message();
                msg.setAction("FLOR");
                msg.setInfo("1");
                System.out.println(msg.toString());
                return msg;
            } else {
                msg = decisionMakingTruco(false);
                if (msg != null) {
                    System.out.println(msg.toString());
                    return msg;
                }
            }
        }

        System.out.println(msg.toString());
        return msg;
    }

    public Message receivedTurn() {
        logger.debug("receivedTurn");
        logger.debug("stateDecisionTurn: " + gameState.getStateDecisionTurn().name());
        logger.debug("isFlor: " + gameState.isFlor());
        logger.debug("isEnvido: " + gameState.isEnvido());
        logger.debug("isHasFlor: " + gameState.isHasFlor());
        Message msg = new Message();

        if (gameState.getStateDecisionTurn() == StateDecisionTurn.START_HAND ||
                gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_2) {

            if (!gameState.isFlor() && !gameState.isEnvido()) {

                if (gameState.isHasFlor()) {
                    msg.setAction("FLOR");
                    msg.setInfo("1");
                    System.out.println(msg.toString());
                    return msg;
                } else {
                    if (!gameState.isLastRaise()) {
                        msg = decisionMakingEnvido(true);
                        if (msg != null) {
                            System.out.println(msg.toString());
                            return msg;
                        }
                    }
                }
            }
        }

        if (!gameState.isTruco()) {
            msg = decisionMakingTruco(true);
            if (msg != null) {
                System.out.println(msg.toString());
                return msg;
            }
        } else {
            if (!gameState.isLastRaise()) {

                msg = decisionMakingTruco(true);
                if (msg != null && msg.getAction() != null) {
                    System.out.println(msg.toString());
                    return msg;
                }
            }
        }

        msg = decisionMakingPlayCard(true);

        System.out.println(msg.toString());

        return msg;
    }

    public int getQualidadeMao(ArrayList<Card> cards){
        if ((cards.get(2).getCbrCode() > 24 && cards.get(1).getCbrCode() > 16) ||
                (cards.get(2).getCbrCode() > 24 && cards.get(1).getCbrCode() > 12 && cards.get(0).getCbrCode() > 4)){
            return 1;
        } else if (cards.get(2).getCbrCode() < 12 || cards.get(1).getCbrCode() < 6) {
            return 3;
        } else {
            return 2;
        }
    }

    public int getQualidadeMao(LinkedList<Card> cards){
        if ((cards.get(2).getCbrCode() > 24 && cards.get(1).getCbrCode() > 16) ||
                (cards.get(2).getCbrCode() > 24 && cards.get(1).getCbrCode() > 12 && cards.get(0).getCbrCode() > 4)){
            return 1;
        } else if (cards.get(2).getCbrCode() < 12 || cards.get(1).getCbrCode() < 6) {
            return 3;
        } else {
            return 2;
        }
    }

    public boolean hasCardToWinRound(int cbrCode) {

        boolean win = false;

        for (Card card : gameState.getHandCards()) {
            if (card.getCbrCode() > cbrCode ) {
                win = true;
            }
        }

        return win;
    }


    //////Métodos Persistência

    public void createNewLearnedCase() {

        switch (typeCaseBaseLearning) {
            case ACTIVE_DECEPTION:
                learningDescription = new RetainActiveDescription();
                break;
            case RETAIN_ALL:
                learningDescription = new RetainAllDescription();
                break;
            case NONE:
                learningDescription = new TrucoDescription();
                break;
        }

    }

    public void setCaseInitialInformation() {

        learningDescription.setIdPartida(gameState.getIdPartida());
        learningDescription.setJogadorMao(gameState.isHand() ? 1 : 2);
        learningDescription.setCartaAltaRobo(gameState.getAgentCards().get(2).getCbrCode());
        learningDescription.setNaipeCartaAltaRobo(gameState.getAgentCards().get(2).getSuit().name());
        learningDescription.setCartaMediaRobo(gameState.getAgentCards().get(1).getCbrCode());
        learningDescription.setNaipeCartaMediaRobo(gameState.getAgentCards().get(1).getSuit().name());
        learningDescription.setCartaBaixaRobo(gameState.getAgentCards().get(0).getCbrCode());
        learningDescription.setNaipeCartaBaixaRobo(gameState.getAgentCards().get(0).getSuit().name());
        learningDescription.setPontosEnvidoRobo(gameState.getEnvidoPoints());
        learningDescription.setTentosAnterioresRobo(gameState.getAgentPoints());
        learningDescription.setTentosAnterioresHumano(gameState.getOpponentPoints());
        if (gameState.isHasFlor()) {
            learningDescription.setPontosFlorRobo(gameState.getEnvidoPoints());
        }

    }

    public void setPlayedCards(Card card, int player) {

        int size = gameState.getDealtCards().size();

        if (size == 1 || size == 2) {
            if (player == 1) {
                if (card != null) {
                    learningDescription.setPrimeiraCartaRobo(card.getCbrCode());
                    learningDescription.setNaipePrimeiraCartaRobo(card.getSuit().name());
                } else {
                    learningDescription.setRoboCartaVirada(1);
                    learningDescription.setQuandoCartaVirada(1);
                }

            } else {
                if (card != null) {
                    learningDescription.setPrimeiraCartaHumano(card.getCbrCode());
                    learningDescription.setNaipePrimeiraCartaHumano(card.getSuit().name());
                } else {
                    learningDescription.setHumanoCartaVirada(1);
                    learningDescription.setQuandoCartaVirada(1);
                }
            }
        } else if (size == 3 || size == 4) {
            if (player == 1) {
                if (card != null) {
                    learningDescription.setSegundaCartaRobo(card.getCbrCode());
                    learningDescription.setNaipeSegundaCartaRobo(card.getSuit().name());
                } else {
                    learningDescription.setRoboCartaVirada(2);
                    learningDescription.setQuandoCartaVirada(2);
                }
            } else {
                if (card != null) {
                    learningDescription.setSegundaCartaHumano(card.getCbrCode());
                    learningDescription.setNaipeSegundaCartaHumano(card.getSuit().name());
                } else {
                    learningDescription.setHumanoCartaVirada(2);
                    learningDescription.setQuandoCartaVirada(2);
                }
            }
        } else {
            if (player == 1) {
                if (card != null) {
                    learningDescription.setTerceiraCartaRobo(card.getCbrCode());
                    learningDescription.setNaipeTerceiraCartaRobo(card.getSuit().name());
                } else {
                    learningDescription.setRoboCartaVirada(3);
                    learningDescription.setQuandoCartaVirada(3);
                }
            } else {
                if (card != null) {
                    learningDescription.setTerceiraCartaHumano(card.getCbrCode());
                    learningDescription.setNaipeTerceiraCartaHumano(card.getSuit().name());
                } else {
                    learningDescription.setHumanoCartaVirada(3);
                    learningDescription.setQuandoCartaVirada(3);
                }
            }
        }

    }

    public void setGanhadorRodada(int round) {

        if (round == 1) {
            if (gameState.isEmpateRound1()) {
                learningDescription.setGanhadorPrimeiraRodada(0);
            } else if (gameState.isWinnerRound1()) {
                learningDescription.setGanhadorPrimeiraRodada(1);
            } else {
                learningDescription.setGanhadorPrimeiraRodada(2);
            }
        } else if (round == 2) {
            if (gameState.isEmpateRound2()) {
                learningDescription.setGanhadorSegundaRodada(0);
            } else if (gameState.isWinnerRound2()) {
                learningDescription.setGanhadorSegundaRodada(1);
            } else {
                learningDescription.setGanhadorSegundaRodada(2);
            }
        } else {
            if (gameState.isEmpateRound3()) {
                learningDescription.setGanhadorTerceiraRodada(0);
            } else if (gameState.isWinnerRound3()) {
                learningDescription.setGanhadorTerceiraRodada(1);
            } else {
                learningDescription.setGanhadorTerceiraRodada(2);
            }
        }

    }

    public void setPontosEnvidoByPlayedCards() {
        ArrayList<Card> cards = new ArrayList<>();
        LinkedList<Card> tmp = gameState.getOpponentPlayedCards();
        tmp.forEach(card -> {
            cards.add(card);
        });
        learningDescription.setPontosEnvidoHumano(gameState.getEnvidoPoints(cards));
    }

    ////Fim Métodos Persistencia

    ///Métodos Deception

    /////AGENT DECEPTION

    public void verifyDeceptionEnvidoAtCallPoints() {

        logger.debug("AtCallPoints - " + gameState.getStateDecisionTurn().name());
        logger.debug("PontosEnvido - " + gameState.getEnvidoPoints());

        if (gameState.getStateDecisionTurn() == StateDecisionTurn.START_HAND) {
            //TODO: Definir o que é poucos pontos como mão
            // #1 - Jogador mão canta ENVIDO/REAL/FALTA sem ter muitos pontos;
            if (gameState.getEnvidoPoints() < LOW_ENVIDO_POINTS) {
                learningDescription.setHasDeception(1);
                learningDescription.setRoboMentiuEnvido(1);
            }
        }

        if (gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_2) {
            // #3 - Jogador pé, sem ter muitos pontos, canta ENVIDO/REAL/FALTA porque o oponente não cantou;
            if (gameState.getEnvidoPoints() < LOW_ENVIDO_POINTS && !gameState.isEnvido()) {
                learningDescription.setHasDeception(1);
                learningDescription.setRoboMentiuEnvido(3);
            }

            // #6 - Jogador pé, sem ter muitos pontos, aumenta ENVIDO/REAL para oponente fugir;
            if (gameState.getEnvidoPoints() < LOW_ENVIDO_POINTS && gameState.isEnvido()) {
                learningDescription.setHasDeception(1);
                learningDescription.setRoboMentiuEnvido(6);
            }
        }
    }

    public void verifyDeceptionEnvidoAtHidePoints() {
        logger.debug("AtHidePoints - " + gameState.getStateDecisionTurn().name());

        //TODO: Definir o que é muitos pontos como mão
        // #4 - Jogador pé, não canta os pontos para não entregar suas cartas;
        learningDescription.setHasDeception(1);
        learningDescription.setRoboMentiuEnvido(4);
    }

    public void verifyDeceptionAtCallTruco() {

        logger.debug("AtCallTruco - " + gameState.getStateDecisionTurn().name());
        logger.debug("QualidadeMao - " + getQualidadeMao(gameState.getAgentCards()));

        // #15 - Jogador com mão ruim chama TRUCO antes de mostrar as cartas;
        if (getQualidadeMao(gameState.getAgentCards()) == 3 && gameState.getAgentPlayedCards().size() == 0) {
            learningDescription.setHasDeception(1);
            learningDescription.setRoboMentiuRound1(15);
        }

        // #23 - Tem uma mão ruim, chama TRUCO antes de largar a segunda carta;
        if (getQualidadeMao(gameState.getAgentCards()) == 3 && gameState.getAgentPlayedCards().size() == 1 &&
                gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_3) {
            learningDescription.setHasDeception(1);
            learningDescription.setRoboMentiuRound2(23);
        }

        // #24 - Jogador perdeu primeira, e não tem carta para fazer a segunda, chama TRUCO antes de largar a segunda carta;
        if (gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_4 && gameState.getOpponentPlayedCards().size() > 0
                && !hasCardToWinRound(gameState.getOpponentPlayedCards().get(1).getCbrCode()) ) {
            learningDescription.setHasDeception(1);
            learningDescription.setRoboMentiuRound2(24);
        }

        // #31 - Jogador possui terceira carta baixa, chama TRUCO/RETRUCO/VALE4 antes de largar a carta;
        if (gameState.getLastCardHand().getCbrCode() < LOW_CARD && gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_5) {
            learningDescription.setHasDeception(1);
            learningDescription.setRoboMentiuRound3(31);
        }

        // #32 - Jogador é o pé e não tem carta para fazer a terceira, chama TRUCO antes de largar a terceira carta;
        if (gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_6 && gameState.getOpponentPlayedCards().size() > 1
                && !hasCardToWinRound(gameState.getOpponentPlayedCards().get(2).getCbrCode())) {
            learningDescription.setHasDeception(1);
            learningDescription.setRoboMentiuRound3(32);
        }
    }

    public void verifyDeceptionAtPlayCard(Card card) {

        logger.debug("AtPlayCard - " + gameState.getStateDecisionTurn().name());
        logger.debug("PontosEnvido - " + gameState.getEnvidoPoints());
        logger.debug("QualidadeMao - " + getQualidadeMao(gameState.getAgentCards()));

        //TODO: Definir o que é muitos pontos como mão
        //#2 - Jogador mão deixa de cantar ENVIDO/REAL/FALTA mesmo com bastantes pontos;
        if (gameState.getEnvidoPoints() > HIGH_ENVIDO_POINTS && !gameState.isEnvido() && !gameState.isFlor()) {
            learningDescription.setHasDeception(1);
            learningDescription.setRoboMentiuEnvido(2);
        }

        //#21 - Jogador ganhou primeira e tem uma mão boa, joga a segunda carta virada;
        if (getQualidadeMao(gameState.getAgentCards()) == 1 && gameState.isWinnerRound1() && card == null &&
                gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_3 && gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_4) {
            learningDescription.setHasDeception(1);
            learningDescription.setRoboMentiuEnvido(21);
        }

        //#22 - Jogador ganhou primeira e tem uma mão ruim, joga a segunda carta virada;
        if (getQualidadeMao(gameState.getAgentCards()) == 3 && gameState.isWinnerRound1() && card == null &&
                gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_3 && gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_4) {
            learningDescription.setHasDeception(1);
            learningDescription.setRoboMentiuEnvido(22);
        }

        if ((!gameState.isTruco() || !gameState.isLastRaise()) && getQualidadeMao(gameState.getAgentCards()) == 1) {

            //#16 - Jogador com uma mão boa deixa de chamar TRUCO;
            if (gameState.getStateDecisionTurn() == StateDecisionTurn.START_HAND && gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_2) {
                learningDescription.setHasDeception(1);
                learningDescription.setRoboMentiuEnvido(16);
            }

            //#25 - Jogador com uma mão boa deixa de chamar TRUCO;
            if (gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_3 && gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_4) {
                learningDescription.setHasDeception(1);
                learningDescription.setRoboMentiuEnvido(25);
            }
        }

        if (card != null) {
            //#5 – Jogador mão, com poucos pontos, não canta envido e larga um 6 ou 7 para o adversário não cantar envido;
            if (card.getCbrCode() > 1 && card.getCbrCode() < 5 && gameState.getStateDecisionTurn() == StateDecisionTurn.START_HAND
                    && !gameState.isEnvido()) {
                learningDescription.setHasDeception(1);
                learningDescription.setRoboMentiuEnvido(5);
            }

            // #11 - Jogador com mão boa larga a carta mais baixa;
            if (getQualidadeMao(gameState.getAgentCards()) == 1 && gameState.getStateDecisionTurn() == StateDecisionTurn.START_HAND
                    && gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_2 && card.equals(gameState.getAgentCards().get(0))) {
                learningDescription.setHasDeception(1);
                learningDescription.setRoboMentiuRound1(11);
            }

            //#12 - Jogador com mão ruim larga a carta mais alta;
            if (getQualidadeMao(gameState.getAgentCards()) == 3 && gameState.getStateDecisionTurn() == StateDecisionTurn.START_HAND
                    && gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_2 && card.equals(gameState.getAgentCards().get(2))) {
                learningDescription.setHasDeception(1);
                learningDescription.setRoboMentiuRound1(12);
            }

            //#13 - Caso jogador com uma mão boa tenha cantado seus pontos de envido, joga carta para despitar as cartas que compoem os pontos;
            if (getQualidadeMao(gameState.getAgentCards()) == 1 && gameState.getStateDecisionTurn() == StateDecisionTurn.START_HAND
                    && gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_2 &&
                    !gameState.isEnvidoPossible(card.getCbrCode(), gameState.getEnvidoPoints()) && gameState.isEnvido()) {
                learningDescription.setHasDeception(1);
                learningDescription.setRoboMentiuRound1(13);
            }

            //#14 - Caso jogador com uma mão ruim tenha cantado seus pontos de envido, joga carta para despitar as cartas que compoem os pontos;
            if (getQualidadeMao(gameState.getAgentCards()) == 1 && gameState.getStateDecisionTurn() == StateDecisionTurn.START_HAND
                    && gameState.getStateDecisionTurn() == StateDecisionTurn.PLAY_CARD_2  &&
                    !gameState.isEnvidoPossible(card.getCbrCode(), gameState.getEnvidoPoints()) && gameState.isEnvido()) {
                learningDescription.setHasDeception(1);
                learningDescription.setRoboMentiuRound1(14);
            }
        }
    }

    /////OPPONENT DECEPTION DETECTION

    public void detectDeceptionOpponent() {

        if (gameState.getOpponentPlayedCards().size() > 1) {


            if (gameState.getOpponentEnvidoPoints() > 0 &&
                    gameState.getOpponentEnvidoPoints() > HIGH_ENVIDO_POINTS) {

                if (!gameState.isHand()) {

                    //#2 - Jogador mão deixa de cantar ENVIDO/REAL/FALTA mesmo com bastantes pontos;
                    if (!gameState.isEnvido() && !gameState.isFlor()) {
                        learningDescription.setHasDeception(1);
                        learningDescription.setHumanoMentiuEnvido(2);
                    }
                }

                //#2 - Jogador mão deixa de cantar ENVIDO/REAL/FALTA mesmo com bastantes pontos;
                if (gameState.isEnvido()) {
                    if (gameState.getEnvidoHistory().size() > 0) {
                        if (gameState.getEnvidoHistory().getFirst().getPlayer().equals("Agent")) {
                            learningDescription.setHasDeception(1);
                            learningDescription.setHumanoMentiuEnvido(2);
                        }

                    }
                }

            }


            if (gameState.getOpponentEnvidoPoints() > 0 &&
                    gameState.getOpponentEnvidoPoints() < LOW_ENVIDO_POINTS) {


                if (!gameState.isHand()) {

                    //#1 - Jogador mão canta ENVIDO/REAL/FALTA sem ter muitos pontos;
                    if (gameState.getEnvidoHistory().size() > 0) {
                        if (gameState.getEnvidoHistory().getFirst().getPlayer().equals("Opponent")) {
                            learningDescription.setHasDeception(1);
                            learningDescription.setHumanoMentiuEnvido(1);
                        }
                    }

                    //#5 – Jogador mão, com poucos pontos, não canta envido e larga um 6 ou 7 para o adversário não cantar envido;
                    if (gameState.getOpponentPlayedCards().size() > 0) {
                        if ((gameState.getEnvidoHistory().size() == 0 || gameState.getEnvidoHistory().getFirst().getPlayer().equals("Agent")) &&
                                gameState.getOpponentPlayedCards().getFirst() != null && gameState.getOpponentPlayedCards().getFirst().getCbrCode() > 1 &&
                                gameState.getOpponentPlayedCards().getFirst().getCbrCode() < 5) {
                            learningDescription.setHasDeception(1);
                            learningDescription.setHumanoMentiuEnvido(5);
                        }
                    }

                } else {
                    //#3 - Jogador pé, sem ter muitos pontos, canta ENVIDO/REAL/FALTA porque o oponente não cantou;
                    if (gameState.getEnvidoHistory().size() > 0) {
                        if (gameState.getEnvidoHistory().getFirst().getPlayer().equals("Opponent")) {
                            learningDescription.setHasDeception(1);
                            learningDescription.setHumanoMentiuEnvido(1);
                        }
                    }

                    //#6 - Jogador pé, sem ter muitos pontos, canta ENVIDO/REAL/FALTA porque o oponente não cantou;
                    if (gameState.getEnvidoHistory().size() > 0) {
                        if (gameState.getEnvidoHistory().getFirst().getPlayer().equals("Agent")) {
                            learningDescription.setHasDeception(1);
                            learningDescription.setHumanoMentiuEnvido(6);
                        }
                    }

                }
            }


            if (gameState.getOpponentPlayedCards().size() == 3) {

                if (gameState.getOpponentPlayedCards().get(0) != null && gameState.getOpponentPlayedCards().get(1) != null
                        && gameState.getOpponentPlayedCards().get(2) != null) {

                    LinkedList<Card> tmp = gameState.getOpponentPlayedCards();

                    Collections.sort(tmp, Card.compareCards());

                    //#24 - Jogador perdeu primeira, e não tem carta para fazer a segunda, chama TRUCO antes de largar a segunda carta;
                    if (learningDescription.getGanhadorPrimeiraRodada() != 2 && (learningDescription.getRoboCartaVirada() == null ||
                            learningDescription.getRoboCartaVirada() != 2)) {
                        if (gameState.getOpponentPlayedCards().get(1).getCbrCode() < gameState.getAgentPlayedCards().get(1).getCbrCode() &&
                                ((learningDescription.getQuemTruco() != null && learningDescription.getQuemTruco() == 2) ||
                                        (learningDescription.getQuemRetruco() != null && learningDescription.getQuemRetruco() == 2) ||
                                        (learningDescription.getQuemValeQuatro() != null && learningDescription.getQuemValeQuatro() == 2))) {
                            learningDescription.setHasDeception(1);
                            learningDescription.setHumanoMentiuRound2(24);
                        }
                    }

                    if (getQualidadeMao(gameState.getOpponentPlayedCards()) == 1) {

                        //#11 - Jogador com mão boa larga a carta mais baixa;
                        if (gameState.getOpponentPlayedCards().get(0).equals(tmp.get(0))) {
                            learningDescription.setHasDeception(1);
                            learningDescription.setHumanoMentiuRound1(11);
                        }

                        //#13 - Caso jogador com uma mão boa tenha cantado seus pontos de envido, joga carta para despitar as cartas que compoem os pontos;
                        if (!gameState.isEnvidoPossible(gameState.getOpponentPlayedCards().get(0).getCbrCode(), gameState.getOpponentEnvidoPoints()) && gameState.isEnvido()) {
                            learningDescription.setHasDeception(1);
                            learningDescription.setHumanoMentiuRound1(13);
                        }


                        if (!gameState.isTruco() || (gameState.getTrucoHistory().size() > 0 &&
                                gameState.getTrucoHistory().getFirst().getPlayer().equals("Agent") && gameState.isHand())) {

                            //#16 - Jogador com uma mão boa deixa de chamar TRUCO;
                            if (gameState.isTruco() && gameState.getTrucoHistory().get(0).getWhen() > 0 && gameState.getTrucoHistory().get(0).getWhen() == 1) {
                                learningDescription.setHasDeception(1);
                                learningDescription.setHumanoMentiuRound1(16);
                            }

                            //#25 - Jogador com uma mão boa deixa de chamar TRUCO;
                            if (gameState.isTruco() && gameState.getTrucoHistory().get(0).getWhen() > 0 && gameState.getTrucoHistory().get(0).getWhen() == 2) {
                                learningDescription.setHasDeception(1);
                                learningDescription.setHumanoMentiuRound2(25);
                            }

                        }

                        //#21 - Jogador ganhou primeira e tem uma mão boa, joga a segunda carta virada;
                        if (learningDescription.getGanhadorPrimeiraRodada() == 2) {
                            if (gameState.getOpponentPlayedCards().get(1) == null ||
                                    (learningDescription.getHumanoCartaVirada() != null && learningDescription.getHumanoCartaVirada() == 2)) {
                                learningDescription.setHasDeception(1);
                                learningDescription.setHumanoMentiuRound2(21);
                            }

                        }


                    }

                    if (getQualidadeMao(gameState.getOpponentPlayedCards()) == 3) {

                        //#12 - Jogador com mão ruim larga a carta mais alta;
                        if (gameState.getOpponentPlayedCards().get(0).equals(tmp.get(2))) {
                            learningDescription.setHasDeception(1);
                            learningDescription.setHumanoMentiuRound1(12);
                        }

                        //#14 - Caso jogador com uma mão ruim tenha cantado seus pontos de envido, joga carta para despitar as cartas que compoem os pontos;
                        if (!gameState.isEnvidoPossible(gameState.getOpponentPlayedCards().get(0).getCbrCode(), gameState.getOpponentEnvidoPoints())
                                && gameState.isEnvido()) {
                            learningDescription.setHasDeception(1);
                            learningDescription.setHumanoMentiuRound1(14);
                        }

                        if (gameState.getTrucoHistory().size() > 0) {
                            if (gameState.getTrucoHistory().getFirst().getPlayer().equals("Opponent")) {
                                //#15 - Jogador com mão ruim chama TRUCO antes de mostrar as cartas;
                                if (gameState.getTrucoHistory().getFirst().getWhen() > 0 && gameState.getEnvidoHistory().getFirst().getWhen() == 1) {
                                    learningDescription.setHasDeception(1);
                                    learningDescription.setHumanoMentiuRound1(15);
                                }

                                //23 - Tem uma mão ruim, chama TRUCO antes de largar a segunda carta;
                                if (gameState.getTrucoHistory().getFirst().getWhen() > 0 && gameState.getEnvidoHistory().getFirst().getWhen() == 2) {
                                    learningDescription.setHasDeception(1);
                                    learningDescription.setHumanoMentiuRound1(23);
                                }
                            }

                        }

                        //#22 - Jogador ganhou primeira e tem uma mão ruim, joga a segunda carta virada;
                        if (learningDescription.getGanhadorPrimeiraRodada() == 2) {
                            if (gameState.getOpponentPlayedCards().get(1) == null ||
                                    (learningDescription.getHumanoCartaVirada() != null && learningDescription.getHumanoCartaVirada() == 2)) {
                                learningDescription.setHasDeception(1);
                                learningDescription.setHumanoMentiuRound2(22);
                            }

                        }

                    }
                }

                //#31 - Jogador possui terceira carta baixa, chama TRUCO/RETRUCO/VALE4 antes de largar a carta;
                if (learningDescription.getGanhadorSegundaRodada() == 2 && gameState.getOpponentPlayedCards().getLast().getCbrCode() < LOW_CARD &&
                        ((learningDescription.getQuemTruco() != null && learningDescription.getQuemTruco() == 2) ||
                                (learningDescription.getQuemRetruco() != null && learningDescription.getQuemRetruco() == 2) ||
                                (learningDescription.getQuemValeQuatro() != null && learningDescription.getQuemValeQuatro() == 2)) && gameState.getTrucoHistory().size() > 0 &&
                        gameState.getTrucoHistory().getLast().getWhen() > 0 && gameState.getTrucoHistory().getLast().getWhen() == 3) {
                    learningDescription.setHasDeception(1);
                    learningDescription.setHumanoMentiuRound3(31);
                }

                //#32 - Jogador é o pé e não tem carta para fazer a terceira, chama TRUCO antes de largar a terceira carta;
                if (learningDescription.getGanhadorSegundaRodada() != 2 &&
                        gameState.getOpponentPlayedCards().getLast().getCbrCode() < gameState.getAgentPlayedCards().getLast().getCbrCode() &&
                        ((learningDescription.getQuemTruco() != null && learningDescription.getQuemTruco() == 2) ||
                                (learningDescription.getQuemRetruco() != null && learningDescription.getQuemRetruco() == 2) ||
                                (learningDescription.getQuemValeQuatro() != null && learningDescription.getQuemValeQuatro() == 2)) && gameState.getTrucoHistory().size() > 0 &&
                        gameState.getTrucoHistory().getLast().getWhen() > 0 && gameState.getTrucoHistory().getLast().getWhen() == 3) {
                    learningDescription.setHasDeception(1);
                    learningDescription.setHumanoMentiuRound3(31);
                }
            }
        }
    }

    ////Fim Métodos Deception


    ////Métodos Active Learning


    public Message createAlert(boolean isTurn) {

        Message msg = new Message();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Active Learning Deception");
        alert.setHeaderText("What decision to make");

        String content = "Game State";
        content += "\n";
        content += "\n :: Agent Information ::";
        content += "\n Points: " + gameState.getAgentPoints();
        content += "\n Envido Points: " + gameState.getEnvidoPoints();
        content += "\n Hand Cards: " + getHandCardsAlert();
        content += "\n Played Cards: " + getPlayedCardsAlert(1);
        content += "\n ::::::::::::::::";
        content += "\n :: Opponent Information ::";
        content += "\n Opponent Points: " + gameState.getOpponentPoints();
        content += "\n Envido Points: " + gameState.getOpponentEnvidoPoints();
        content += "\n Played Cards: " + getPlayedCardsAlert(2);
        content += "\n ::::::::::::::::";
        content += "\n :: Hand History ::";
        content += "\n Flor History: " + getFlorHistoryAlert();
        content += "\n Envido History: " + getEnvidoHistoryAlert();
        content += "\n Truco History: " + getTrucoHistoryAlert();
        content += "\n ::::::::::::::::";

        alert.setContentText(content);


        LinkedList<ButtonType> buttons = new LinkedList<>();


        ButtonType btnTruco = new ButtonType("Truco");
        ButtonType btnRetruco = new ButtonType("Retruco");
        ButtonType btnVale4 = new ButtonType("Vale 4");
        ButtonType btnAccept = new ButtonType("Quero");
        ButtonType btnDecline = new ButtonType("Não Quero");

        ButtonType btnCancel = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);


        if (isTurn) {

            logger.debug("TRUCO.size() = " + gameState.getTrucoSize());
            switch (gameState.getTrucoSize()) {
                case 0:
                    buttons.add(btnTruco);
                    break;
                case 1:
                    if (!gameState.isLastRaise()) {
                        buttons.add(btnRetruco);
                    }
                    break;
                case 2:
                    if (!gameState.isLastRaise()) {
                        buttons.add(btnVale4);
                    }
                    break;
            }

        } else {

            switch (gameState.getStateDecisionToken()) {
                case TRUCO:
                    //0: NÃO ACEITAR 1: ACEITAR; 2: RETRUCO
                    buttons.add(btnAccept);
                    buttons.add(btnDecline);
                    buttons.add(btnRetruco);
                    break;
                case RETRUCO:
                    //0: NÃO ACEITAR 1: ACEITAR; 3: VALE4
                    buttons.add(btnAccept);
                    buttons.add(btnDecline);
                    buttons.add(btnVale4);
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
        } else {
            msg = null;
        }

        return msg;
    }


    public String getHandCardsAlert() {

        String handCards = "";

        if (gameState.getHandCards().size() > 0) {
            for (Card card : gameState.getHandCards()) {
                handCards += card.getFace().name() + "-" + card.getSuit().name() + "; ";
            }
        }

        return handCards;
    }

    public String getPlayedCardsAlert(int player) {

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


    public String getEnvidoHistoryAlert() {

        String envidoHistory = "";

        if (gameState.getEnvidoHistory().size() > 0) {
            for (Action action : gameState.getEnvidoHistory()) {
                envidoHistory += action.getPlayer() + "-" + action.getAction() + " --> \n";
            }
        }

        return envidoHistory;

    }

    public String getFlorHistoryAlert() {

        String florHistory = "";

        if (gameState.getFlorHistory().size() > 0) {
            for (Action action : gameState.getFlorHistory()) {
                florHistory += action.getPlayer() + "-" + action.getAction() + " --> \n";
            }
        }

        return florHistory;

    }

    public String getTrucoHistoryAlert() {

        String trucoHistory = "";

        if (gameState.getTrucoHistory().size() > 0) {
            for (Action action : gameState.getTrucoHistory()) {
                trucoHistory += action.getPlayer() + "-" + action.getAction() + "-->";
            }
        }

        return trucoHistory;

    }


    ////Fim Métodos Active Learning


}
