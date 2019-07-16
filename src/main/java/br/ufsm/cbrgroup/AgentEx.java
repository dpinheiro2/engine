package br.ufsm.cbrgroup;

import br.ufsm.cbrgroup.cbr.learning.LearningStrategyEx;
import br.ufsm.cbrgroup.cbr.retrieve.RetrieveStrategyEx;
import br.ufsm.cbrgroup.cbr.reuse.ReuseStrategyEx;
import br.ufsm.cbrgroup.cbr.similarity.SimilarityStrategyEx;
import br.ufsm.cbrgroup.description.*;
import br.ufsm.cbrgroup.enums.StateDecisionToken;
import br.ufsm.cbrgroup.enums.StateDecisionTurn;
import br.ufsm.cbrgroup.enums.TypeCaseBase;
import br.ufsm.cbrgroup.game.GameState;
import br.ufsm.cbrgroup.jcolibriex.DBConnEnvido;
import br.ufsm.cbrgroup.jcolibriex.DBConnFlor;
import br.ufsm.cbrgroup.jcolibriex.DBConnPlayCard;
import br.ufsm.cbrgroup.jcolibriex.DBConnTruco;
import br.ufsm.cbrgroup.jcolibriex.retainactive.DBConnEnvidoRetainActive;
import br.ufsm.cbrgroup.jcolibriex.retainactive.DBConnFlorRetainActive;
import br.ufsm.cbrgroup.jcolibriex.retainactive.DBConnPlayCardRetainActive;
import br.ufsm.cbrgroup.jcolibriex.retainactive.DBConnTrucoRetainActive;
import br.ufsm.cbrgroup.websocket.Message;
import es.ucm.fdi.gaia.jcolibri.casebase.LinealCaseBase;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCaseBase;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRQuery;
import es.ucm.fdi.gaia.jcolibri.cbrcore.Connector;
import es.ucm.fdi.gaia.jcolibri.exception.InitializingException;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import javafx.scene.layout.AnchorPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 01/07/2019.
 */


public class AgentEx {

    private static Logger logger = LogManager.getLogger(AgentEx.class);

    private GameState gameState;
    private RetrieveStrategyEx retrieveStrategy;
    private SimilarityStrategyEx similarityStrategy;
    private ReuseStrategyEx reuseStrategy;
    private LearningStrategyEx learningStrategy;

    private Connector reuseConnectorEnvido;
    private CBRCaseBase reuseCaseBaseEnvido;

    private Connector reuseConnectorFlor;
    private CBRCaseBase reuseCaseBaseFlor;

    private Connector reuseConnectorTruco;
    private CBRCaseBase reuseCaseBaseTruco;

    private Connector reuseConnectorPlayCard;
    private CBRCaseBase reuseCaseBasePlayCard;

    private Connector learningConnectorEnvido;
    private CBRCaseBase learningCaseBaseEnvido;

    private Connector learningConnectorFlor;
    private CBRCaseBase learningCaseBaseFlor;

    private Connector learningConnectorTruco;
    private CBRCaseBase learningCaseBaseTruco;

    private Connector learningConnectorPlayCard;
    private CBRCaseBase learningCaseBasePlayCard;

    private TypeCaseBase typeCaseBaseReuse;
    private TypeCaseBase typeCaseBaseLearning;

    private GenericEnvido reuseEnvidoDescription;
    private GenericFlor reuseFlorDescription;
    private GenericTruco reuseTrucoDescription;
    private GenericPlayCard reusePlayCardDescription;

    private GenericEnvido learningEnvidoDescription;
    private GenericFlor learningFlorDescription;
    private GenericTruco learningTrucoDescription;
    private GenericPlayCard learningPlayCardDescription;

    public void initializingCaseBase() {

        switch (typeCaseBaseReuse) {

            case BASELINE:
                reuseConnectorEnvido = new DBConnEnvido();
                reuseEnvidoDescription = new Envido();

                reuseConnectorFlor = new DBConnFlor();
                reuseFlorDescription = new Flor();

                reuseConnectorTruco = new DBConnTruco();
                reuseTrucoDescription = new Truco();

                reuseConnectorPlayCard = new DBConnPlayCard();
                reusePlayCardDescription = new PlayCard();
                break;

            case ACTIVE_DECEPTION:

                reuseConnectorEnvido = new DBConnEnvidoRetainActive();
                reuseEnvidoDescription = new EnvidoRetainActive();

                reuseConnectorFlor = new DBConnFlorRetainActive();
                reuseFlorDescription = new FlorRetainActive();

                reuseConnectorTruco = new DBConnTrucoRetainActive();
                reuseTrucoDescription = new TrucoRetainActive();

                reuseConnectorPlayCard = new DBConnPlayCardRetainActive();
                reusePlayCardDescription = new PlayCardRetainActive();
                break;
        }

        switch (typeCaseBaseLearning) {
            case ACTIVE_DECEPTION:

                learningConnectorEnvido = new DBConnEnvidoRetainActive();
                learningEnvidoDescription = new EnvidoRetainActive();

                learningConnectorFlor = new DBConnFlorRetainActive();
                learningFlorDescription = new FlorRetainActive();

                learningConnectorTruco = new DBConnTrucoRetainActive();
                learningTrucoDescription = new TrucoRetainActive();

                learningConnectorPlayCard = new DBConnPlayCardRetainActive();
                learningPlayCardDescription = new PlayCardRetainActive();

                break;
            case NONE:
                learningConnectorEnvido = null;
                learningEnvidoDescription = new Envido();

                learningConnectorFlor = null;
                learningFlorDescription = new Flor();

                learningConnectorTruco = null;
                learningTrucoDescription = new Truco();

                learningConnectorPlayCard = null;
                learningPlayCardDescription = new PlayCard();
                break;
        }

        reuseCaseBaseEnvido = new LinealCaseBase();
        reuseCaseBaseFlor = new LinealCaseBase();
        reuseCaseBaseTruco = new LinealCaseBase();
        reuseCaseBasePlayCard = new LinealCaseBase();

        learningCaseBaseEnvido = new LinealCaseBase();
        learningCaseBaseFlor = new LinealCaseBase();
        learningCaseBaseTruco = new LinealCaseBase();
        learningCaseBasePlayCard = new LinealCaseBase();

        try {
            reuseCaseBaseEnvido.init(reuseConnectorEnvido);
            reuseCaseBaseFlor.init(reuseConnectorFlor);
            reuseCaseBaseTruco.init(reuseConnectorTruco);
            reuseCaseBasePlayCard.init(reuseConnectorPlayCard);

            if (learningConnectorEnvido != null) {
                learningCaseBaseEnvido.init(learningConnectorEnvido);
            }

            if (learningConnectorFlor != null) {
                learningCaseBaseFlor.init(learningConnectorFlor);
            }

            if (learningConnectorTruco != null) {
                learningCaseBaseTruco.init(learningConnectorTruco);
            }

            if (learningConnectorPlayCard != null) {
                learningCaseBasePlayCard.init(learningConnectorPlayCard);
            }

        } catch (InitializingException ie) {
            ie.printStackTrace();
        }

    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public RetrieveStrategyEx getRetrieveStrategy() {
        return retrieveStrategy;
    }

    public void setRetrieveStrategy(RetrieveStrategyEx retrieveStrategy) {
        this.retrieveStrategy = retrieveStrategy;
    }

    public SimilarityStrategyEx getSimilarityStrategy() {
        return similarityStrategy;
    }

    public void setSimilarityStrategy(SimilarityStrategyEx similarityStrategy) {
        this.similarityStrategy = similarityStrategy;
    }

    public ReuseStrategyEx getReuseStrategy() {
        return reuseStrategy;
    }

    public void setReuseStrategy(ReuseStrategyEx reuseStrategy) {
        this.reuseStrategy = reuseStrategy;
    }

    public Connector getReuseConnectorEnvido() {
        return reuseConnectorEnvido;
    }

    public void setReuseConnectorEnvido(Connector reuseConnectorEnvido) {
        this.reuseConnectorEnvido = reuseConnectorEnvido;
    }

    public CBRCaseBase getReuseCaseBaseEnvido() {
        return reuseCaseBaseEnvido;
    }

    public void setReuseCaseBaseEnvido(CBRCaseBase reuseCaseBaseEnvido) {
        this.reuseCaseBaseEnvido = reuseCaseBaseEnvido;
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

    public GenericEnvido getReuseEnvidoDescription() {
        return reuseEnvidoDescription;
    }

    public void setReuseEnvidoDescription(GenericEnvido reuseEnvidoDescription) {
        this.reuseEnvidoDescription = reuseEnvidoDescription;
    }

    public Connector getReuseConnectorFlor() {
        return reuseConnectorFlor;
    }

    public void setReuseConnectorFlor(Connector reuseConnectorFlor) {
        this.reuseConnectorFlor = reuseConnectorFlor;
    }

    public CBRCaseBase getReuseCaseBaseFlor() {
        return reuseCaseBaseFlor;
    }

    public void setReuseCaseBaseFlor(CBRCaseBase reuseCaseBaseFlor) {
        this.reuseCaseBaseFlor = reuseCaseBaseFlor;
    }

    public Connector getReuseConnectorTruco() {
        return reuseConnectorTruco;
    }

    public void setReuseConnectorTruco(Connector reuseConnectorTruco) {
        this.reuseConnectorTruco = reuseConnectorTruco;
    }

    public CBRCaseBase getReuseCaseBaseTruco() {
        return reuseCaseBaseTruco;
    }

    public void setReuseCaseBaseTruco(CBRCaseBase reuseCaseBaseTruco) {
        this.reuseCaseBaseTruco = reuseCaseBaseTruco;
    }

    public Connector getReuseConnectorPlayCard() {
        return reuseConnectorPlayCard;
    }

    public void setReuseConnectorPlayCard(Connector reuseConnectorPlayCard) {
        this.reuseConnectorPlayCard = reuseConnectorPlayCard;
    }

    public CBRCaseBase getReuseCaseBasePlayCard() {
        return reuseCaseBasePlayCard;
    }

    public void setReuseCaseBasePlayCard(CBRCaseBase reuseCaseBasePlayCard) {
        this.reuseCaseBasePlayCard = reuseCaseBasePlayCard;
    }

    public GenericFlor getReuseFlorDescription() {
        return reuseFlorDescription;
    }

    public void setReuseFlorDescription(GenericFlor reuseFlorDescription) {
        this.reuseFlorDescription = reuseFlorDescription;
    }

    public GenericTruco getReuseTrucoDescription() {
        return reuseTrucoDescription;
    }

    public void setReuseTrucoDescription(GenericTruco reuseTrucoDescription) {
        this.reuseTrucoDescription = reuseTrucoDescription;
    }

    public GenericPlayCard getReusePlayCardDescription() {
        return reusePlayCardDescription;
    }

    public void setReusePlayCardDescription(GenericPlayCard reusePlayCardDescription) {
        this.reusePlayCardDescription = reusePlayCardDescription;
    }

    public CBRQuery getQueryEnvido() {
        return retrieveStrategy.getQueryEnvido(gameState, reuseEnvidoDescription);
    }

    public CBRQuery getQueryFlor() {
        return retrieveStrategy.getQueryFlor(gameState, reuseFlorDescription);
    }

    public CBRQuery getQueryTruco() {
        return retrieveStrategy.getQueryTruco(gameState, reuseTrucoDescription);
    }

    public CBRQuery getQueryPlayCard() {
        return retrieveStrategy.getQueryPlayCard(gameState, reusePlayCardDescription);
    }

    public NNConfig getSimConfigEnvido(CBRQuery gameStateQuery){
        return similarityStrategy.getSimConfigEnvido(gameStateQuery);
    }

    public NNConfig getSimConfigFlor(CBRQuery gameStateQuery){
        return similarityStrategy.getSimConfigFlor(gameStateQuery);
    }

    public NNConfig getSimConfigTruco(CBRQuery gameStateQuery){
        return similarityStrategy.getSimConfigTruco(gameStateQuery);
    }

    public NNConfig getSimConfigPlayCard(CBRQuery gameStateQuery){
        return similarityStrategy.getSimConfigPlayCard(gameStateQuery);
    }

    public Message decisionMakingEnvido(boolean isTurn) {

        CBRQuery query = getQueryEnvido();
        NNConfig simConfig = getSimConfigEnvido(query);

        return reuseStrategy.decisionMakingEnvido(reuseCaseBaseEnvido, gameState, query, simConfig, isTurn);
    }

    public Message decisionMakingFlor(boolean isTurn) {

        CBRQuery query = getQueryFlor();
        NNConfig simConfig = getSimConfigFlor(query);

        return reuseStrategy.decisionMakingFlor(reuseCaseBaseFlor, gameState, query, simConfig, isTurn);
    }

    public Message decisionMakingTruco(boolean isTurn) {

        CBRQuery query = getQueryTruco();
        NNConfig simConfig = getSimConfigTruco(query);

        return reuseStrategy.decisionMakingTruco(reuseCaseBaseTruco, gameState, query, simConfig, isTurn);
    }

    public Message decisionMakingPlayCard(boolean isTurn) {

        CBRQuery query = getQueryPlayCard();
        NNConfig simConfig = getSimConfigPlayCard(query);

        return reuseStrategy.decisionMakingPlayCard(reuseCaseBasePlayCard, gameState, query, simConfig, isTurn);
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

    public void showActiveWindow() {



    }

}
