package br.ufsm.cbrgroup.ui;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.net.URI;

import java.util.ArrayList;
import java.util.List;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 22/04/2019.
 */


public class PromptController {

    final StringProperty info = new SimpleStringProperty("");

    Scene activeScene;
    Stage stage;


    int numberGames;

    String chosenAgent;
    String learningStrategy;

    //private Brain agent;
    private String agenteName;
    private String SERVER = "ws://localhost:8080/truco/cbr/";

    //static LocalEndpoint endpoint = new LocalEndpoint();

    public String getAgenteName() {
        return agenteName;
    }

    public void setAgenteName(String agenteName) {
        this.agenteName = agenteName;
    }

   /* public Brain getAgent() {
        return agent;
    }

    public void setAgent(Brain agent) {
        this.agent = agent;
    }*/

    @FXML
    private ComboBox<String> cmbAgent;

    @FXML
    private ComboBox<String> cmbLearningStrategy;

    @FXML
    private TextField txtNumberGames;

    @FXML
    private Button btnPlay;

    @FXML
    private Text statusBar;

    @FXML
    public void initialize() {

        statusBar.setText("");

        List<String> agents = new ArrayList<>();
        agents.add("Most_Similar_Unweighted");
        agents.add("Most_Similar_Weighted");
        agents.add("Majority_Vote_Unweighted");
        agents.add("Majority_Vote_Weighted");

        List<String> learningStrategies = new ArrayList<>();
        learningStrategies.add("Nothing");
        learningStrategies.add("Retain_All");
        learningStrategies.add("Treshold");
        learningStrategies.add("Ativo");
        learningStrategies.add("Deception_Active");

        cmbAgent.setItems(FXCollections.observableArrayList(agents));
        cmbAgent.getSelectionModel().selectFirst();

        cmbLearningStrategy.setItems(FXCollections.observableArrayList(learningStrategies));
        cmbLearningStrategy.getSelectionModel().selectFirst();

        //criarTela();

    }


    public void enableDisableComponents(boolean aDisable) {

        btnPlay.setDisable(aDisable);
        cmbAgent.setDisable(aDisable);
        cmbLearningStrategy.setDisable(aDisable);
        txtNumberGames.setDisable(aDisable);
    }

    @FXML
    public void playTraining() {


        /*endpoint.promptController = this;
        statusBar.setText("Conectando ao Servidor....");
        chosenAgent = cmbAgent.getValue();
        learningStrategy = cmbLearningStrategy.getValue();

        setAgenteName(chosenAgent);

        numberGames = (txtNumberGames.getText().isEmpty() ? 1 : Integer.parseInt(txtNumberGames.getText()));
        endpoint.gameState.setNumberGames(numberGames);

        if (chosenAgent.equals("Most_Similar_Unweighted")) {
            endpoint.agent = new MostSimilarUnweightedBrain();
        } else if (chosenAgent.equals("Most_Similar_Unweighted")) {
            endpoint.agent = new MostSimilarWeightedBrain();
        }

        try {
            startGame();

        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        } catch (DeploymentException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }



        enableDisableComponents(true);
*/
    }

    public void setInfo(String status) {
        this.info.set(status);
        statusBar.setText(status);
        System.out.println(status);
    }

    /*private void startGame() throws URISyntaxException, DeploymentException, IOException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        container.connectToServer(endpoint.getClass(), null, new URI(SERVER+agenteName));
    }*/

    /*public void criarTela() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("fxml/ActiveLearning.fxml"));


            activeScene = new Scene(fxmlLoader.load(), 1024, 600);

            stage = new Stage();
            stage.setTitle("CBR Group | UFSM");
            stage.setScene(scene);
            //stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

 /*   public static void showAlert(String jogada, String typeJogada, String detailJogada) {


            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //String stateTurn = stateDecisionTurn.name() != null ? stateDecisionTurn.name() : "";
        //String stateToken = stateDecisionToken.name() != null ? stateDecisionToken.name() : "";
        *//* String text = "Jogada: " + jogada + " - Tipo Jogada: " + typeJogada + " - Detalhe: " + detailJogada; *//**//* + " - Estado Turno: " + stateTurn +
                " - Estado Token: " + stateToken;*//**//*

        //String text = "Jogada: " + jogada + " - Tipo Jogada: " + typeJogada + " - Detalhe: " + detailJogada;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Decisão Tomada");
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.setContentText(text);

        alert.showAndWait();*//*
    }*/

}
