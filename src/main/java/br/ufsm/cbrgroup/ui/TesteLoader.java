package br.ufsm.cbrgroup.ui;

import br.ufsm.cbrgroup.game.GameState;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 22/05/2019.
 */


public class TesteLoader extends Application {

    private static Stage stageGlobal;
    private static Scene testeScene;
    private static Scene activeScene;


    @Override
    public void start(Stage stage) throws Exception {

        stageGlobal = stage;

        FXMLLoader testeLoader = new FXMLLoader(getClass().getResource("/fxml/teste.fxml"));
        Parent fxmlTeste = testeLoader.load();
        testeScene = new Scene(fxmlTeste);

        FXMLLoader activeLoader = new FXMLLoader(getClass().getResource("/fxml/activeScreen.fxml"));
        Parent fxmlActive = activeLoader.load();
        activeScene = new Scene(fxmlActive);


        stage.setScene(testeScene);
        stage.setResizable(false);
        stage.setTitle("UFSM - CBR Group");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void changeScreen(String screen, String retrievedMove, GameState gameState, String decisionType, boolean isTurnMethod) {
        switch(screen){
            case "teste":
                stageGlobal.setScene(testeScene);
                notifyAllListeners("main", retrievedMove, gameState, decisionType, isTurnMethod);
                break;
            case "active":
                stageGlobal.setScene(activeScene);
                notifyAllListeners("active", retrievedMove, gameState, decisionType, isTurnMethod);
                break;
        }
    }


    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

    public static interface OnChangeScreen {
        void onChangedScreen(String newScreen, String retrievedMove, GameState gameState, String decisionType, boolean isTurnMethod);
    }

    public static void addOnChangeScreenListener(OnChangeScreen newListener) {
        listeners.add(newListener);
    }

    private static void notifyAllListeners(String newScreen, String retrievedMove, GameState gameState, String decisionType, boolean isTurnMethod) {
        for (OnChangeScreen listener : listeners) {
            listener.onChangedScreen(newScreen, retrievedMove, gameState, decisionType, isTurnMethod);
        }
    }


}
