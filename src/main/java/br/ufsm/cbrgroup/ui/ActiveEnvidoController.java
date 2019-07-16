package br.ufsm.cbrgroup.ui;

import br.ufsm.cbrgroup.game.GameState;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 05/07/2019.
 */


public class ActiveEnvidoController {

    @FXML private Label lblAgentHand;
    @FXML private Label lblOpponentHand;
    @FXML private Label lblAgentPoints;
    @FXML private Label lblAgentEnvidoPts;
    @FXML private Label lblAgentPlayedCards;
    @FXML private Label lblAgentHandCards;
    @FXML private Label lblOpponentPoints;
    @FXML private Label lblOpponentEnvidoPts;
    @FXML private Label lblOpponentPlayedCards;
    @FXML private TableView tvAgentBluff;
    @FXML private TableView tvOpponentBluff;
    @FXML private TreeTableView ttvHandHistory;
    @FXML private Label lblRetrievedMove;
    @FXML private CheckBox cboxIsBluff;
    @FXML private ComboBox<String> cbBluffType;
    @FXML private ListView<String> lvMotivateRetrieved;
    @FXML private CheckBox cboxIsBluffRevised;
    @FXML private ComboBox<String> cbBluffTypeRevised;
    @FXML private ListView<String> lvMotivateRevised;
    @FXML private CheckBox cboxConfirmMove;
    @FXML private Button btnCancel;
    @FXML private Button btnSave;
    @FXML private ComboBox<String> cbNewMove;
    @FXML private Accordion accordion;
    @FXML private TitledPane tpGameState;
    @FXML private TitledPane tpBluffStats;
    @FXML private TitledPane tpHandHistory;
    @FXML private BorderPane bpMotiveRetrieved, bpRevisedMove, bpMotiveRevised;
    @FXML private HBox hbNewMove;

    private GameState gameState;

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @FXML
    public void initialize() {

        gameState = new GameState();

        List<String> moves = new ArrayList<>();
        if (!gameState.isEnvido()) {
            moves.add("No Call Envido");
            moves.add("Call Envido");
            moves.add("Call Real Envido");
            moves.add("Call Falta Envido");
        } else {
            switch (gameState.getStateDecisionToken()) {
                //0: NÃO ACEITAR 1: ACEITAR; 2: ENVIDO_ENVIDO; 3: REAL_ENVIDO; 4: FALTA_ENVIDO
                case ENVIDO:
                    moves.add("Accept");
                    moves.add("Decline");
                    moves.add("Call Envido Envido");
                    moves.add("Call Real Envido");
                    moves.add("Call Falta Envido");
                    break;
                //0: NÃO ACEITAR 1: ACEITAR; 3: REAL_ENVIDO; 4: FALTA_ENVIDO
                case ENVIDO_ENVIDO:
                    moves.add("Accept");
                    moves.add("Decline");
                    moves.add("Call Real Envido");
                    moves.add("Call Falta Envido");
                    break;
                //0: NÃO ACEITAR 1: ACEITAR; 4: FALTA_ENVIDO
                case REAL_ENVIDO:
                    moves.add("Accept");
                    moves.add("Decline");
                    moves.add("Call Falta Envido");
                    break;
                //0: NÃO ACEITAR 1: ACEITAR;
                case FALTA_ENVIDO:
                    moves.add("Accept");
                    moves.add("Decline");
                    break;
            }
        }

        List<String> envidoBluffs = new ArrayList<>();
        envidoBluffs.add("Simulation (Show False)");
        envidoBluffs.add("Dissimulation (Hide Real)");
        envidoBluffs.add("Simulation and Dissimulation");

        List<String> bluffReasons = new ArrayList<>();
        bluffReasons.add("Strong Hand");
        bluffReasons.add("Weak Hand");
        bluffReasons.add("Few Envido Points");
        bluffReasons.add("Many Envido Points");
        bluffReasons.add("Many Points Ago");
        bluffReasons.add("Many Points Foreward");
        bluffReasons.add("Only To Test Opponent");
        bluffReasons.add("Opponent Tight");
        bluffReasons.add("Opponent Loose");
        bluffReasons.add("Opponent Agressive");
        bluffReasons.add("Opponent Passive");
        bluffReasons.add("Opponent Can Infer my Cards");
        bluffReasons.add("I Can Infer Opponent's Cards");

        cbBluffType.setItems(null);
        cboxConfirmMove.setSelected(true);
        cbBluffType.setItems(FXCollections.observableArrayList(envidoBluffs));
        cbBluffTypeRevised.setItems(FXCollections.observableArrayList(envidoBluffs));

        cbNewMove.setItems(FXCollections.observableArrayList(moves));

        lvMotivateRetrieved.setItems(FXCollections.observableArrayList(bluffReasons));
        lvMotivateRetrieved.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        lvMotivateRevised.setItems(FXCollections.observableArrayList(bluffReasons));
        lvMotivateRevised.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        accordion.setExpandedPane(tpGameState);

        lblAgentHand.setVisible(gameState.isHand());
        lblOpponentHand.setVisible(!gameState.isHand());

        bpMotiveRetrieved.setVisible(false);
        bpMotiveRevised.setVisible(false);
        hbNewMove.setVisible(false);
        cbBluffTypeRevised.setVisible(false);
        bpRevisedMove.setVisible(false);

        cboxIsBluff.setOnAction((event) -> {
            boolean selected = cboxIsBluff.isSelected();
            cbBluffType.setVisible(selected);
            bpMotiveRetrieved.setVisible(selected);
        });

        cboxConfirmMove.setOnAction((event) -> {
            boolean selected = cboxConfirmMove.isSelected();
            cbBluffTypeRevised.setVisible(false);
            bpMotiveRevised.setVisible(false);
            bpRevisedMove.setVisible(!selected);
            hbNewMove.setVisible(!selected);
        });

        cboxIsBluffRevised.setOnAction((event) -> {
            boolean selected = cboxIsBluffRevised.isSelected();
            cbBluffTypeRevised.setVisible(selected);
            bpMotiveRevised.setVisible(selected);
        });

    }

}
