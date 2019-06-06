package br.ufsm.cbrgroup.ui;

import br.ufsm.cbrgroup.Agent;
import br.ufsm.cbrgroup.cbr.retrieve.RetrieveDefault;
import br.ufsm.cbrgroup.cbr.reuse.ReuseMostSimilar;
import br.ufsm.cbrgroup.cbr.similarity.SimilarityUnweighted;
import br.ufsm.cbrgroup.enums.TypeCaseBase;
import br.ufsm.cbrgroup.game.GameState;
import br.ufsm.cbrgroup.websocket.LocalEndpoint;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 22/05/2019.
 */


public class TesteController {

    private String SERVER = "ws://localhost:8080/truco/cbr/";
    private Agent agent;
    private LocalEndpoint endpoint;

    @FXML
    private Button btnJogar;


    @FXML
    public void initialize() {

        agent = new Agent();
        endpoint = new LocalEndpoint();
        agent.setGameState(new GameState());
        agent.setTypeCaseBaseReuse(TypeCaseBase.BASELINE);
        agent.setTypeCaseBaseLearning(TypeCaseBase.NONE);
        agent.setRetrieveStrategy(new RetrieveDefault());
        agent.setSimilarityStrategy(new SimilarityUnweighted());
        agent.setReuseStrategy(new ReuseMostSimilar());
        agent.setLearningStrategy(null);
        agent.initializingCaseBase();
        endpoint.setAgent(agent);

    }

    @FXML
    public void jogar() {

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

    private void startGame() throws URISyntaxException, DeploymentException, IOException {
        Random r     = new Random();
        int player = (r.nextInt((99) + 1));
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        container.connectToServer(endpoint, null, new URI(SERVER+"Agente"+player));
    }
}
