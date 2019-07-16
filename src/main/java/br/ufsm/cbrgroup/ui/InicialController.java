package br.ufsm.cbrgroup.ui;

import br.ufsm.cbrgroup.Agent;
import br.ufsm.cbrgroup.cbr.learning.LearningDefault;
import br.ufsm.cbrgroup.cbr.retrieve.RetrieveDefault;
import br.ufsm.cbrgroup.cbr.reuse.ReuseActiveLearning;
import br.ufsm.cbrgroup.cbr.reuse.ReuseMostSimilar;
import br.ufsm.cbrgroup.cbr.similarity.SimilarityUnweighted;
import br.ufsm.cbrgroup.cbr.similarity.SimilarityWeighted;
import br.ufsm.cbrgroup.enums.TypeCaseBase;
import br.ufsm.cbrgroup.game.GameState;
import br.ufsm.cbrgroup.websocket.LocalEndpoint;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 14/06/2019.
 */


public class InicialController {

    private String SERVER = "ws://localhost:8080/truco/cbr/";
    private Agent agent;
    private LocalEndpoint endpoint;

    @FXML
    private ComboBox<String> cmbCaseBaseReuse;

    @FXML
    private ComboBox<String> cmbRetrieveStrategy;

    @FXML
    private ComboBox<String> cmbSimilarityStrategy;

    @FXML
    private ComboBox<String> cmbReuseStrategy;

    @FXML
    private ComboBox<String> cmbLearningStrategy;

    @FXML
    private ComboBox<String> cmbCaseBaseRetain;


    @FXML
    private TextField txtNumberGames;

    @FXML
    private Button btnPlay;


    @FXML
    public void initialize() {

        agent = new Agent();
        endpoint = new LocalEndpoint();
        agent.setGameState(new GameState());

        List<String> caseBases = new ArrayList<>();
        caseBases.add(TypeCaseBase.BASELINE.name());
        caseBases.add(TypeCaseBase.ACTIVE_DECEPTION.name());
        caseBases.add(TypeCaseBase.RETAIN_ALL.name());
        caseBases.add(TypeCaseBase.NONE.name());


        List<String> retrieves = new ArrayList<>();
        retrieves.add("Default");

        List<String> similarities = new ArrayList<>();
        similarities.add("Similarity_Unweighted");
        similarities.add("Similarity_Weighted");
        similarities.add("Similarity_Active_Learning");

        List<String> reuses = new ArrayList<>();
        reuses.add("Most_Similar");
        reuses.add("Active_Learning");

        List<String> learns = new ArrayList<>();
        learns.add("Default");
        learns.add("None");


        cmbCaseBaseReuse.setItems(FXCollections.observableArrayList(caseBases));
        cmbCaseBaseReuse.getSelectionModel().selectFirst();

        cmbRetrieveStrategy.setItems(FXCollections.observableArrayList(retrieves));
        cmbRetrieveStrategy.getSelectionModel().selectFirst();

        cmbSimilarityStrategy.setItems(FXCollections.observableArrayList(similarities));
        cmbSimilarityStrategy.getSelectionModel().selectFirst();

        cmbReuseStrategy.setItems(FXCollections.observableArrayList(reuses));
        cmbReuseStrategy.getSelectionModel().selectFirst();

        cmbLearningStrategy.setItems(FXCollections.observableArrayList(learns));
        cmbLearningStrategy.getSelectionModel().selectFirst();

        cmbCaseBaseRetain.setItems(FXCollections.observableArrayList(caseBases));
        cmbCaseBaseRetain.getSelectionModel().selectLast();



    }



    @FXML
    public void playTraining() {

        String caseBaseReuse = cmbCaseBaseReuse.getValue();
        String retrieveStrategy = cmbRetrieveStrategy.getValue();
        String similarityStrategy = cmbSimilarityStrategy.getValue();
        String reuseStrategy = cmbReuseStrategy.getValue();
        String learningStrategy = cmbLearningStrategy.getValue();
        String caseBaseRetain = cmbCaseBaseRetain.getValue();

        if (caseBaseReuse.equals("RETAIN_ALL")) {
            agent.setTypeCaseBaseReuse(TypeCaseBase.RETAIN_ALL);
        } else if (caseBaseReuse.equals("ACTIVE_DECEPTION")) {
            agent.setTypeCaseBaseReuse(TypeCaseBase.ACTIVE_DECEPTION);
        } else {
            agent.setTypeCaseBaseReuse(TypeCaseBase.BASELINE);
        }


        if (retrieveStrategy.equals("Default")) {
            agent.setRetrieveStrategy(new RetrieveDefault());
        } else {
            agent.setRetrieveStrategy(null);
        }

        if (similarityStrategy.equals("Similarity_Unweighted")) {
            agent.setSimilarityStrategy(new SimilarityUnweighted());
        } else if (similarityStrategy.equals("Similarity_Weighted")) {
            agent.setSimilarityStrategy(new SimilarityWeighted());
        } else if (similarityStrategy.equals("Similarity_Active_Learning")) {
            agent.setSimilarityStrategy(new SimilarityWeighted());
        } else {
            agent.setSimilarityStrategy(null);
        }

        if (reuseStrategy.equals("Most_Similar")) {
            agent.setReuseStrategy(new ReuseMostSimilar());
        } else if (reuseStrategy.equals("Active_Learning")) {
            agent.setReuseStrategy(new ReuseActiveLearning());
        } else {
            agent.setReuseStrategy(null);
        }

        if (learningStrategy.equals("Default")) {
            agent.setLearningStrategy(new LearningDefault());
        } else {
            agent.setLearningStrategy(null);
        }

        if (caseBaseRetain.equals("RETAIN_ALL")) {
            agent.setTypeCaseBaseLearning(TypeCaseBase.RETAIN_ALL);
        } else if (caseBaseReuse.equals("ACTIVE_DECEPTION")) {
            agent.setTypeCaseBaseLearning(TypeCaseBase.ACTIVE_DECEPTION);
        } else {
            agent.setTypeCaseBaseLearning(TypeCaseBase.NONE);
        }


        agent.initializingCaseBase();
        endpoint.setAgent(agent);

        try {
            startGame();

        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        } catch (DeploymentException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void enableDisableComponents(boolean aDisable) {

        btnPlay.setDisable(aDisable);
        cmbCaseBaseReuse.setDisable(aDisable);
        cmbRetrieveStrategy.setDisable(aDisable);
        cmbSimilarityStrategy.setDisable(aDisable);
        cmbReuseStrategy.setDisable(aDisable);
        cmbLearningStrategy.setDisable(aDisable);
        cmbCaseBaseRetain.setDisable(aDisable);
        txtNumberGames.setDisable(aDisable);
    }

    private void startGame() throws URISyntaxException, DeploymentException, IOException {
        Random r     = new Random();
        int player = (r.nextInt((99) + 1));
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        container.connectToServer(endpoint, null, new URI(SERVER+"Agente"+player));
    }

}
