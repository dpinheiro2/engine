package br.ufsm.cbrgroup.ui;

import br.ufsm.cbrgroup.game.GameState;
import br.ufsm.cbrgroup.model.Card;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 15/07/2019.
 */


public class ActiveController {

    @FXML
    private Label lblAgent;
    @FXML private Label lblOpponent;
    @FXML private Label lblAgentPoints;
    @FXML private Label lblOpponentPoints;
    @FXML private Label lblAgentEnvidoPoints;
    @FXML private Label lblOpponentEnvidoPoints;
    @FXML private Label lblAgentPlayedCards;
    @FXML private Label lblOpponentPlayedCards;
    @FXML private Label lblAgentHandCards;
    @FXML private Label lblEnvidoHistory;
    @FXML private Label lblFlorHistory;
    @FXML private Label lblTrucoHistory;
    @FXML private Label lblCardHistory;
    @FXML private Label lblTriedSuccess;
    @FXML private Label lblTriedFailure;
    @FXML private Label lblDetectedSuccess;
    @FXML private Label lblDetectedFailure;
    @FXML private CheckBox cbStrongHand;
    @FXML private CheckBox cbWeakHand;
    @FXML private CheckBox cbManyEnvPoints;
    @FXML private CheckBox cbFewEnvPoints;
    @FXML private CheckBox cbManyPointsAgo;
    @FXML private CheckBox cbManyPointsForward;
    @FXML private CheckBox cbTestOpponent;
    @FXML private CheckBox cbTightOpponent;
    @FXML private CheckBox cbLooseOpponent;
    @FXML private CheckBox cbAgressiveOpponent;
    @FXML private CheckBox cbPassiveOpponent;
    @FXML private CheckBox cbCardsCanBe;
    @FXML private CheckBox cbOpponentCardsInferred;
    @FXML private HBox pnlRetievedMove;
    @FXML private Label lblRetrievedMove;
    @FXML private HBox pnlNewMove;
    @FXML private ComboBox<String> comboBoxNewMove;
    @FXML private ComboBox<String> comBoxBluffTypes;
    @FXML private CheckBox cbConfirmMove;
    @FXML private CheckBox cbIsBluff;

    private List<String> moves;
    private GameState gameState;
    private String decisionType;
    private boolean isTurnMethod;

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public String getDecisionType() {
        return decisionType;
    }

    public void setDecisionType(String decisionType) {
        this.decisionType = decisionType;
    }

    public boolean isTurnMethod() {
        return isTurnMethod;
    }

    public void setTurnMethod(boolean turnMethod) {
        isTurnMethod = turnMethod;
    }

    @FXML
    public void initialize() {

        TesteLoader.addOnChangeScreenListener(new TesteLoader.OnChangeScreen() {
            @Override
            public void onChangedScreen(String newScreen, String retrievedMove, GameState gameState, String decisionType, boolean isTurnMethod) {
                if (newScreen.equals("active")){
                    setGameState(gameState);
                    setDecisionType(decisionType);
                    setTurnMethod(isTurnMethod);
                    getPossibleAction();
                    setInfoGameState();
                    setInfoRetrievedMove(retrievedMove);

                    System.out.println("tela active");
                }
            }
        });

        List<String> bluffTypes = new ArrayList<>();
        bluffTypes.add("Simulation (Show False)");
        bluffTypes.add("Dissimulation (Hide Real)");
        bluffTypes.add("Simulation and Dissimulation");

        moves = new ArrayList<>();

        comBoxBluffTypes.setItems(FXCollections.observableArrayList(bluffTypes));
        comboBoxNewMove.setItems(FXCollections.observableArrayList(moves));



        cbConfirmMove.setSelected(true);
        cbIsBluff.setSelected(false);
        comBoxBluffTypes.setVisible(cbIsBluff.isSelected());
        enableDisableBluffJustifications(!cbIsBluff.isSelected());
        pnlNewMove.setVisible(!cbConfirmMove.isSelected());
        pnlRetievedMove.setVisible(cbConfirmMove.isSelected());

        cbIsBluff.setOnAction((event) -> {
            boolean selected = cbIsBluff.isSelected();
            comBoxBluffTypes.setVisible(selected);
            enableDisableBluffJustifications(!selected);
            if (!selected) {
                unSelectBluff(false);
            }
        });

        cbConfirmMove.setOnAction((event) -> {
            boolean selected = cbConfirmMove.isSelected();
            pnlRetievedMove.setVisible(selected);
            pnlNewMove.setVisible(!selected);
        });



    }

    public void enableDisableBluffJustifications(boolean aEnable) {
        cbStrongHand.setDisable(aEnable);
        cbWeakHand.setDisable(aEnable);
        cbManyEnvPoints.setDisable(aEnable);
        cbFewEnvPoints.setDisable(aEnable);
        cbManyPointsAgo.setDisable(aEnable);
        cbManyPointsForward.setDisable(aEnable);
        cbTestOpponent.setDisable(aEnable);
        cbTightOpponent.setDisable(aEnable);
        cbLooseOpponent.setDisable(aEnable);
        cbAgressiveOpponent.setDisable(aEnable);
        cbPassiveOpponent.setDisable(aEnable);
        cbCardsCanBe.setDisable(aEnable);
        cbOpponentCardsInferred.setDisable(aEnable);
    }

    public void unSelectBluff(boolean aSelect) {
        cbStrongHand.setSelected(aSelect);
        cbWeakHand.setSelected(aSelect);
        cbManyEnvPoints.setSelected(aSelect);
        cbFewEnvPoints.setSelected(aSelect);
        cbManyPointsAgo.setSelected(aSelect);
        cbManyPointsForward.setSelected(aSelect);
        cbTestOpponent.setSelected(aSelect);
        cbTightOpponent.setSelected(aSelect);
        cbLooseOpponent.setSelected(aSelect);
        cbAgressiveOpponent.setSelected(aSelect);
        cbPassiveOpponent.setSelected(aSelect);
        cbCardsCanBe.setSelected(aSelect);
        cbOpponentCardsInferred.setSelected(aSelect);
        comBoxBluffTypes.getSelectionModel().clearSelection();
    }


    public void getPossibleAction() {
        moves.clear();
        if (decisionType.equals("ENVIDO")) {

            if (!gameState.isEnvido()) {
                moves.add("NO_CALL_ENVIDO");
                moves.add("ENVIDO");
                moves.add("REAL_ENVIDO");
                moves.add("FALTA_ENVIDO");
            } else {
                switch (gameState.getStateDecisionToken()) {
                    //0: NÃO ACEITAR 1: ACEITAR; 2: ENVIDO_ENVIDO; 3: REAL_ENVIDO; 4: FALTA_ENVIDO
                    case ENVIDO:
                        moves.add("ACCEPT");
                        moves.add("DECLINE");
                        moves.add("ENVIDO_ENVIDO");
                        moves.add("REAL_ENVIDO");
                        moves.add("FALTA_ENVIDO");
                        break;
                    //0: NÃO ACEITAR 1: ACEITAR; 3: REAL_ENVIDO; 4: FALTA_ENVIDO
                    case ENVIDO_ENVIDO:
                        moves.add("ACCEPT");
                        moves.add("DECLINE");
                        moves.add("REAL_ENVIDO");
                        moves.add("FALTA_ENVIDO");
                        break;
                    //0: NÃO ACEITAR 1: ACEITAR; 4: FALTA_ENVIDO
                    case REAL_ENVIDO:
                        moves.add("ACCEPT");
                        moves.add("DECLINE");
                        moves.add("FALTA_ENVIDO");
                        break;
                    //0: NÃO ACEITAR 1: ACEITAR;
                    case FALTA_ENVIDO:
                        moves.add("ACCEPT");
                        moves.add("DECLINE");
                        break;
                }
            }

        } else if (decisionType.equals("FLOR")) {

            switch (gameState.getStateDecisionToken()) {
                //0: NADA 2: FLOR_FLOR; 3: CONTRA_FLOR;
                case FLOR:
                    moves.add("FLOR_FLOR");
                    moves.add("CONTRA_FLOR");
                    break;
                //0: NÃO ACEITAR 1: ACEITAR; 3: CONTRA_FLOR;
                case FLOR_FLOR:
                    moves.add("ACCEPT");
                    moves.add("DECLINE");
                    moves.add("CONTRA_FLOR_FALTA");
                    break;
                //0: NÃO ACEITAR 1: ACEITAR; 4: CONTRA_FLOR_FALTA; 5: CONTRA_FLOR_RESTO;
                case CONTRA_FLOR:
                    moves.add("ACCEPT");
                    moves.add("DECLINE");
                    moves.add("CONTRA_FLOR_FALTA");
                    moves.add("CONTRA_FLOR_RESTO");
                    break;
                //0: NÃO ACEITAR 1: ACEITAR;  5: CONTRA_FLOR_RESTO;
                case CONTRA_FLOR_FALTA:
                    moves.add("ACCEPT");
                    moves.add("DECLINE");
                    moves.add("CONTRA_FLOR_RESTO");
                    break;
                //0: NÃO ACEITAR 1: ACEITAR;
                case CONTRA_FLOR_RESTO:
                    moves.add("ACCEPT");
                    moves.add("DECLINE");
                    break;
            }

        } else if (decisionType.equals("TRUCO")) {

            if (!gameState.isTruco()) {
                // 0: NÃO CHAMAR 1: TRUCO;
                moves.add("NO_CALL_TRUCO");
                moves.add("TRUCO");
            } else {
                switch (gameState.getStateDecisionToken()) {
                    case TRUCO:
                        //0: NÃO ACEITAR 1: ACEITAR; 2: RETRUCO
                        if (isTurnMethod) {
                            moves.add("NO_CALL_RETRUCO");
                            moves.add("RETRUCO");
                        } else {
                            moves.add("ACCEPT");
                            moves.add("DECLINE");
                            moves.add("RETRUCO");
                        }
                        break;
                    case RETRUCO:
                        //0: NÃO ACEITAR 1: ACEITAR; 3: VALE4
                        if (isTurnMethod) {
                            moves.add("NO_CALL_VALE4");
                            moves.add("VALE4");
                        } else {
                            moves.add("ACCEPT");
                            moves.add("DECLINE");
                            moves.add("VALE4");
                        }
                        break;
                    case VALE4:
                        //0: NÃO ACEITAR 1: ACEITAR;
                        moves.add("ACCEPT");
                        moves.add("DECLINE");
                        break;
                }
            }

        } else {
            moves.add("FOLD");
            ArrayList<Card> agentCards = gameState.getAgentCards();
            if (agentCards.size() > 0) {
                for (Card card : agentCards) {
                    if (!gameState.isPlayedCard(gameState.getAgentPlayedCards(), card)) {
                        moves.add(card.getFace().name() + " - " + card.getSuit().name());
                        moves.add("PLAY_FACE_DOWN" + card.getFace().name() + " - " + card.getSuit().name());
                    }
                }
            }

        }
    }

    public void setInfoGameState() {
        lblAgentPoints.setText(String.valueOf(gameState.getAgentPoints()));
        lblOpponentPoints.setText(String.valueOf(gameState.getAgentPoints()));
        lblAgentPoints.setUnderline(gameState.isHand());
        lblOpponentPoints.setUnderline(!gameState.isHand());
        lblAgentEnvidoPoints.setText(String.valueOf(gameState.getEnvidoPoints()));
        lblAgentPlayedCards.setText(gameState.getStringAgentPlayedCards());
        lblAgentHandCards.setText(gameState.getStringHandCards());
        lblOpponentEnvidoPoints.setText(String.valueOf(gameState.getOpponentEnvidoPoints()));
        lblOpponentPlayedCards.setText(gameState.getStringOpponentPlayedCards());
    }

    public void setInfoRetrievedMove(String retrievedMove) {
        lblRetrievedMove.setText(retrievedMove);
    }
}
