package br.ufsm.cbrgroup;

import br.ufsm.cbrgroup.cbr.learning.LearningStrategy;
import br.ufsm.cbrgroup.cbr.retrieve.RetrieveStrategy;
import br.ufsm.cbrgroup.cbr.reuse.ReuseStrategy;
import br.ufsm.cbrgroup.cbr.similarity.SimilarityStrategy;
import br.ufsm.cbrgroup.description.TrucoDescription;
import br.ufsm.cbrgroup.enums.StateDecisionToken;
import br.ufsm.cbrgroup.enums.StateDecisionTurn;
import br.ufsm.cbrgroup.enums.TypeCaseBase;
import br.ufsm.cbrgroup.game.GameState;
import br.ufsm.cbrgroup.jcolibriex.DBConnRetainAllDescription;
import br.ufsm.cbrgroup.jcolibriex.DBConnTrucoDescription;
import br.ufsm.cbrgroup.websocket.Message;
import es.ucm.fdi.gaia.jcolibri.casebase.LinealCaseBase;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCaseBase;
import es.ucm.fdi.gaia.jcolibri.cbrcore.Connector;
import es.ucm.fdi.gaia.jcolibri.exception.InitializingException;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 21/05/2019.
 */


public class Agent {

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

    private static Logger logger = LogManager.getLogger(Agent.class);

    public void initializingCaseBase() {

        switch (typeCaseBaseReuse) {
            case BASELINE:
                reuseConnector = new DBConnTrucoDescription();
                break;
            case ACTIVE_DECEPTION:
                break;
            case RETAIN_ALL:
                reuseConnector = new DBConnRetainAllDescription();
                break;
        }

        switch (typeCaseBaseLearning) {
            case ACTIVE_DECEPTION:

                break;
            case RETAIN_ALL:
                learningConnector = new DBConnRetainAllDescription();
                break;
            case NONE:
                learningConnector = null;
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

    public TrucoDescription getQueryEnvido() {
        return retrieveStrategy.getQueryEnvido(gameState);
    }

    public TrucoDescription getQueryFlor() {
        return retrieveStrategy.getQueryFlor(gameState);
    }

    public TrucoDescription getQueryTruco() {
        return retrieveStrategy.getQueryTruco(gameState);
    }

    public TrucoDescription getQueryPlayCard() {
        return retrieveStrategy.getQueryPlayCard(gameState);
    }

    public TrucoDescription getQueryShowPoints() {
        return retrieveStrategy.getQueryShowPoints(gameState);
    }

    public NNConfig getSimConfigEnvido(TrucoDescription gameStateQuery){
        return similarityStrategy.getSimConfigEnvido(gameStateQuery);
    }

    public NNConfig getSimConfigFlor(TrucoDescription gameStateQuery){
        return similarityStrategy.getSimConfigFlor(gameStateQuery);
    }

    public NNConfig getSimConfigTruco(TrucoDescription gameStateQuery){
        return similarityStrategy.getSimConfigTruco(gameStateQuery);
    }

    public NNConfig getSimConfigPlayCard(TrucoDescription gameStateQuery){
        return similarityStrategy.getSimConfigPlayCard(gameStateQuery);
    }

    public NNConfig getSimConfigShowPoints(TrucoDescription gameStateQuery){
        return similarityStrategy.getSimConfigShowPoints(gameStateQuery);
    }

    public Message decisionMakingEnvido() {

        TrucoDescription query = getQueryEnvido();
        NNConfig simConfig = getSimConfigEnvido(query);

        return reuseStrategy.decisionMakingEnvido(reuseCaseBase, gameState, query, simConfig);
    }

    public Message decisionMakingFlor() {

        TrucoDescription query = getQueryFlor();
        NNConfig simConfig = getSimConfigFlor(query);

        return reuseStrategy.decisionMakingFlor(reuseCaseBase, gameState, query, simConfig);

    }

    public Message decisionMakingTruco(boolean isTurn) {

        TrucoDescription query = getQueryTruco();
        NNConfig simConfig = getSimConfigTruco(query);

        return reuseStrategy.decisionMakingTruco(reuseCaseBase, gameState, query, simConfig, isTurn);
    }

    public Message decisionMakingPlayCard() {

        TrucoDescription query = getQueryPlayCard();
        NNConfig simConfig = getSimConfigPlayCard(query);

        return reuseStrategy.decisionMakingPlayCard(reuseCaseBase, gameState, query, simConfig);

    }

    public Message decisionMakingShowPoints() {

        return null;
    }

    public Message receivedToken() {
        logger.debug("receivedToken");
        Message msg = null;

        if (gameState.getStateDecisionToken() == StateDecisionToken.FLOR || gameState.getStateDecisionToken() == StateDecisionToken.FLOR_FLOR
                || gameState.getStateDecisionToken() == StateDecisionToken.CONTRA_FLOR || gameState.getStateDecisionToken() == StateDecisionToken.CONTRA_FLOR_FALTA
                || gameState.getStateDecisionToken() == StateDecisionToken.CONTRA_FLOR_RESTO) {

            if (gameState.isHasFlor()) {
                msg = decisionMakingFlor();
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
                msg = decisionMakingEnvido();
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
                        msg = decisionMakingEnvido();
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

        msg = decisionMakingPlayCard();

        System.out.println(msg.toString());

        return msg;
    }

}
