package br.ufsm.cbrgroup.cbr.retrieve;

import br.ufsm.cbrgroup.description.TrucoDescription;
import br.ufsm.cbrgroup.game.GameState;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 21/05/2019.
 */


public class RetrieveDefault implements RetrieveStrategy {

    @Override
    public TrucoDescription getQueryEnvido(GameState gameState) {

        TrucoDescription query = new TrucoDescription();

        query.setJogadorMao(gameState.isHand() ? 1 : 2);
        query.setPontosEnvidoRobo(gameState.getEnvidoPoints());
        query.setTentosAnterioresRobo(gameState.getAgentPoints());
        query.setTentosAnterioresHumano(gameState.getOpponentPoints());

        //query.setQuemGanhouEnvido(1);

        if (gameState.getStateDecisionToken() != null) {

            switch (gameState.getStateDecisionToken()) {
                case ENVIDO:
                    query.setQuemPediuEnvido(2);
                    break;
                case ENVIDO_ENVIDO:
                    query.setQuemEnvidoEnvido(2);
                    break;
                case REAL_ENVIDO:
                    query.setQuemPediuRealEnvido(2);
                    break;
                case FALTA_ENVIDO:
                    query.setQuemPediuFaltaEnvido(2);
                    break;
            }
        }

        switch (gameState.getStateDecisionTurn()) {
            case PLAY_CARD_2:
                if (gameState.getOpponentCartaVirada() == 0) {
                    query.setPrimeiraCartaHumano(gameState.getDealtCards().get(0).getCbrCode());
                } else if (gameState.getOpponentCartaVirada() == 1) {
                    query.setHumanoCartaVirada(gameState.getOpponentCartaVirada());
                }
                break;
        }

        return query;
    }

    @Override
    public TrucoDescription getQueryFlor(GameState gameState) {

        TrucoDescription query = new TrucoDescription();

        query.setJogadorMao(gameState.isHand() ? 1 : 2);
        query.setPontosFlorRobo(gameState.getEnvidoPoints());
        query.setTentosAnterioresRobo(gameState.getAgentPoints());
        query.setTentosAnterioresHumano(gameState.getOpponentPoints());

        //query.setQuemGanhouFlor(1);

        if (gameState.getStateDecisionToken() != null) {
            switch (gameState.getStateDecisionToken()) {
                case FLOR:
                    query.setQuemFlor(2);
                    break;
                case FLOR_FLOR:
                    query.setQuemFlorFlor(2);
                    break;
                case CONTRA_FLOR:
                    query.setQuemContraFlor(2);
                    break;
                case CONTRA_FLOR_FALTA:
                    query.setQuemContraFlorFalta(2);
                    break;
                case CONTRA_FLOR_RESTO:
                    query.setQuemContraFlorResto(2);
                    break;
            }
        }

        return query;
    }

    @Override
    public TrucoDescription getQueryTruco(GameState gameState) {

        TrucoDescription query = new TrucoDescription();

        query.setJogadorMao(gameState.isHand() ? 1 : 2);
        query.setQuandoTruco(gameState.getCurrentRound());
        query.setTentosAnterioresRobo(gameState.getAgentPoints());
        query.setTentosAnterioresHumano(gameState.getOpponentPoints());
        query.setCartaAltaRobo(gameState.getAgentCards().get(2).getCbrCode());
        query.setCartaMediaRobo(gameState.getAgentCards().get(1).getCbrCode());
        query.setCartaBaixaRobo(gameState.getAgentCards().get(0).getCbrCode());


        switch (gameState.getStateDecisionTurn()) {
            case PLAY_CARD_2:
                if (gameState.getOpponentCartaVirada() == 0) {
                    query.setPrimeiraCartaHumano(gameState.getDealtCards().get(0).getCbrCode());
                } else if (gameState.getOpponentCartaVirada() == 1){
                    query.setHumanoCartaVirada(gameState.getOpponentCartaVirada());
                }
                break;
            case PLAY_CARD_3:
                if (gameState.isWinnerRound1()) {
                    query.setGanhadorPrimeiraRodada(1);
                } else {
                    if (gameState.isEmpateRound1()) {
                        query.setGanhadorPrimeiraRodada(0);
                    } else {
                        query.setGanhadorPrimeiraRodada(2);
                    }
                }

                if (gameState.getAgentCartaVirada() == 0) {
                    query.setPrimeiraCartaRobo(gameState.getAgentPlayedCards().get(0).getCbrCode());
                } else if (gameState.getAgentCartaVirada() == 1){
                    query.setRoboCartaVirada(gameState.getAgentCartaVirada());
                }

                if (gameState.getOpponentCartaVirada() == 0) {
                    query.setPrimeiraCartaHumano(gameState.getOpponentPlayedCards().get(0).getCbrCode());
                } else if (gameState.getOpponentCartaVirada() == 1){
                    query.setHumanoCartaVirada(gameState.getOpponentCartaVirada());
                }
                break;
            case PLAY_CARD_4:

                if (gameState.isWinnerRound1()) {
                    query.setGanhadorPrimeiraRodada(1);
                } else {
                    if (gameState.isEmpateRound1()) {
                        query.setGanhadorPrimeiraRodada(0);
                    } else {
                        query.setGanhadorPrimeiraRodada(2);
                    }
                }

                if (gameState.getAgentCartaVirada() == 0) {
                    query.setPrimeiraCartaRobo(gameState.getAgentPlayedCards().get(0).getCbrCode());
                } else if (gameState.getAgentCartaVirada() == 1){
                    query.setRoboCartaVirada(gameState.getAgentCartaVirada());
                }

                if (gameState.getOpponentCartaVirada() == 0) {
                    query.setPrimeiraCartaHumano(gameState.getOpponentPlayedCards().get(0).getCbrCode());
                    if (gameState.getOpponentPlayedCards().size() > 1) {
                        query.setSegundaCartaHumano(gameState.getOpponentPlayedCards().get(1).getCbrCode());
                    }
                } else if (gameState.getOpponentCartaVirada() == 1 || gameState.getOpponentCartaVirada() == 2){
                    query.setHumanoCartaVirada(gameState.getOpponentCartaVirada());
                }

                break;
            case PLAY_CARD_5:

                if (gameState.isWinnerRound1()) {
                    query.setGanhadorPrimeiraRodada(1);
                } else {
                    if (gameState.isEmpateRound1()) {
                        query.setGanhadorPrimeiraRodada(0);
                    } else {
                        query.setGanhadorPrimeiraRodada(2);
                    }
                }

                if (gameState.isWinnerRound2()) {
                    query.setGanhadorSegundaRodada(1);
                } else {
                    if (gameState.isEmpateRound2()) {
                        query.setGanhadorSegundaRodada(0);
                    } else {
                        query.setGanhadorSegundaRodada(2);
                    }
                }

                if (gameState.getAgentCartaVirada() == 0) {
                    query.setPrimeiraCartaRobo(gameState.getAgentPlayedCards().get(0).getCbrCode());
                    query.setSegundaCartaRobo(gameState.getAgentPlayedCards().get(1).getCbrCode());
                } else if (gameState.getAgentCartaVirada() == 1 || gameState.getAgentCartaVirada() == 2){
                    query.setRoboCartaVirada(gameState.getAgentCartaVirada());
                }

                if (gameState.getOpponentCartaVirada() == 0) {
                    query.setPrimeiraCartaHumano(gameState.getOpponentPlayedCards().get(0).getCbrCode());
                    if (gameState.getOpponentPlayedCards().size() > 1) {
                        query.setSegundaCartaHumano(gameState.getOpponentPlayedCards().get(1).getCbrCode());
                    }
                } else if (gameState.getOpponentCartaVirada() == 1 || gameState.getOpponentCartaVirada() == 2){
                    query.setHumanoCartaVirada(gameState.getOpponentCartaVirada());
                }

                break;
            case PLAY_CARD_6:

                if (gameState.isWinnerRound1()) {
                    query.setGanhadorPrimeiraRodada(1);
                } else {
                    if (gameState.isEmpateRound1()) {
                        query.setGanhadorPrimeiraRodada(0);
                    } else {
                        query.setGanhadorPrimeiraRodada(2);
                    }
                }

                if (gameState.isWinnerRound2()) {
                    query.setGanhadorSegundaRodada(1);
                } else {
                    if (gameState.isEmpateRound2()) {
                        query.setGanhadorSegundaRodada(0);
                    } else {
                        query.setGanhadorSegundaRodada(2);
                    }
                }

                if (gameState.getAgentCartaVirada() == 0) {
                    query.setPrimeiraCartaRobo(gameState.getAgentPlayedCards().get(0).getCbrCode());
                    query.setSegundaCartaRobo(gameState.getAgentPlayedCards().get(1).getCbrCode());
                } else if (gameState.getAgentCartaVirada() == 1 || gameState.getAgentCartaVirada() == 2){
                    query.setRoboCartaVirada(gameState.getAgentCartaVirada());
                }

                if (gameState.getOpponentCartaVirada() == 0) {
                    query.setPrimeiraCartaHumano(gameState.getOpponentPlayedCards().get(0).getCbrCode());
                    query.setSegundaCartaHumano(gameState.getOpponentPlayedCards().get(1).getCbrCode());
                    if (gameState.getOpponentPlayedCards().size() > 2) {
                        query.setTerceiraCartaHumano(gameState.getOpponentPlayedCards().get(2).getCbrCode());
                    }
                } else if (gameState.getOpponentCartaVirada() == 1 || gameState.getOpponentCartaVirada() == 2
                        || gameState.getOpponentCartaVirada() == 3){
                    query.setHumanoCartaVirada(gameState.getOpponentCartaVirada());
                }

                break;
        }

        if (gameState.getStateDecisionToken() != null) {
            switch (gameState.getStateDecisionToken()) {
                case TRUCO:
                    query.setQuemTruco(2);
                    break;
                case RETRUCO:
                    query.setQuemRetruco(2);
                    break;
                case VALE4:
                    query.setQuemValeQuatro(2);
                    break;
            }
        }
        return query;
    }

    @Override
    public TrucoDescription getQueryPlayCard(GameState gameState) {
        TrucoDescription query = new TrucoDescription();

        query.setJogadorMao(gameState.isHand() ? 1 : 2);
        query.setCartaAltaRobo(gameState.getAgentCards().get(2).getCbrCode());
        query.setCartaMediaRobo(gameState.getAgentCards().get(1).getCbrCode());
        query.setCartaBaixaRobo(gameState.getAgentCards().get(0).getCbrCode());
        query.setTentosAnterioresRobo(gameState.getAgentPoints());
        query.setTentosAnterioresHumano(gameState.getOpponentPoints());
        //query.setQuemGanhouTruco(1);

        switch (gameState.getStateDecisionTurn()) {
            case PLAY_CARD_2:
                if (gameState.getOpponentCartaVirada() == 0) {
                    query.setPrimeiraCartaHumano(gameState.getDealtCards().get(0).getCbrCode());
                } else if (gameState.getOpponentCartaVirada() == 1){
                    query.setHumanoCartaVirada(gameState.getOpponentCartaVirada());
                }
                break;
            case PLAY_CARD_3:
                if (gameState.isWinnerRound1()) {
                    query.setGanhadorPrimeiraRodada(1);
                } else {
                    if (gameState.isEmpateRound1()) {
                        query.setGanhadorPrimeiraRodada(0);
                    } else {
                        query.setGanhadorPrimeiraRodada(2);
                    }
                }

                if (gameState.getAgentCartaVirada() == 0) {
                    query.setPrimeiraCartaRobo(gameState.getAgentPlayedCards().get(0).getCbrCode());
                } else if (gameState.getAgentCartaVirada() == 1){
                    query.setRoboCartaVirada(gameState.getAgentCartaVirada());
                }

                if (gameState.getOpponentCartaVirada() == 0) {
                    query.setPrimeiraCartaHumano(gameState.getOpponentPlayedCards().get(0).getCbrCode());
                } else if (gameState.getOpponentCartaVirada() == 1){
                    query.setHumanoCartaVirada(gameState.getOpponentCartaVirada());
                }
                break;
            case PLAY_CARD_4:

                if (gameState.isWinnerRound1()) {
                    query.setGanhadorPrimeiraRodada(1);
                } else {
                    if (gameState.isEmpateRound1()) {
                        query.setGanhadorPrimeiraRodada(0);
                    } else {
                        query.setGanhadorPrimeiraRodada(2);
                    }
                }

                if (gameState.getAgentCartaVirada() == 0) {
                    query.setPrimeiraCartaRobo(gameState.getAgentPlayedCards().get(0).getCbrCode());
                } else if (gameState.getAgentCartaVirada() == 1){
                    query.setRoboCartaVirada(gameState.getAgentCartaVirada());
                }

                if (gameState.getOpponentCartaVirada() == 0) {
                    query.setPrimeiraCartaHumano(gameState.getOpponentPlayedCards().get(0).getCbrCode());
                    query.setSegundaCartaHumano(gameState.getOpponentPlayedCards().get(1).getCbrCode());
                } else if (gameState.getOpponentCartaVirada() == 1 || gameState.getOpponentCartaVirada() == 2){
                    query.setHumanoCartaVirada(gameState.getOpponentCartaVirada());
                }

                break;
            case PLAY_CARD_5:

                if (gameState.isWinnerRound1()) {
                    query.setGanhadorPrimeiraRodada(1);
                } else {
                    if (gameState.isEmpateRound1()) {
                        query.setGanhadorPrimeiraRodada(0);
                    } else {
                        query.setGanhadorPrimeiraRodada(2);
                    }
                }

                if (gameState.isWinnerRound2()) {
                    query.setGanhadorSegundaRodada(1);
                } else {
                    if (gameState.isEmpateRound2()) {
                        query.setGanhadorSegundaRodada(0);
                    } else {
                        query.setGanhadorSegundaRodada(2);
                    }
                }

                if (gameState.getAgentCartaVirada() == 0) {
                    query.setPrimeiraCartaRobo(gameState.getAgentPlayedCards().get(0).getCbrCode());
                    query.setSegundaCartaRobo(gameState.getAgentPlayedCards().get(1).getCbrCode());
                } else if (gameState.getAgentCartaVirada() == 1 || gameState.getAgentCartaVirada() == 2){
                    query.setRoboCartaVirada(gameState.getAgentCartaVirada());
                }

                if (gameState.getOpponentCartaVirada() == 0) {
                    query.setPrimeiraCartaHumano(gameState.getOpponentPlayedCards().get(0).getCbrCode());
                    query.setSegundaCartaHumano(gameState.getOpponentPlayedCards().get(1).getCbrCode());
                } else if (gameState.getOpponentCartaVirada() == 1 || gameState.getOpponentCartaVirada() == 2){
                    query.setHumanoCartaVirada(gameState.getOpponentCartaVirada());
                }

                break;
            case PLAY_CARD_6:

                if (gameState.isWinnerRound1()) {
                    query.setGanhadorPrimeiraRodada(1);
                } else {
                    if (gameState.isEmpateRound1()) {
                        query.setGanhadorPrimeiraRodada(0);
                    } else {
                        query.setGanhadorPrimeiraRodada(2);
                    }
                }

                if (gameState.isWinnerRound2()) {
                    query.setGanhadorSegundaRodada(1);
                } else {
                    if (gameState.isEmpateRound2()) {
                        query.setGanhadorSegundaRodada(0);
                    } else {
                        query.setGanhadorSegundaRodada(2);
                    }
                }

                if (gameState.getAgentCartaVirada() == 0) {
                    query.setPrimeiraCartaRobo(gameState.getAgentPlayedCards().get(0).getCbrCode());
                    query.setSegundaCartaRobo(gameState.getAgentPlayedCards().get(1).getCbrCode());
                } else if (gameState.getAgentCartaVirada() == 1 || gameState.getAgentCartaVirada() == 2){
                    query.setRoboCartaVirada(gameState.getAgentCartaVirada());
                }

                if (gameState.getOpponentCartaVirada() == 0) {
                    query.setPrimeiraCartaHumano(gameState.getOpponentPlayedCards().get(0).getCbrCode());
                    query.setSegundaCartaHumano(gameState.getOpponentPlayedCards().get(1).getCbrCode());
                    query.setTerceiraCartaHumano(gameState.getOpponentPlayedCards().get(2).getCbrCode());
                } else if (gameState.getOpponentCartaVirada() == 1 || gameState.getOpponentCartaVirada() == 2
                        || gameState.getOpponentCartaVirada() == 3){
                    query.setHumanoCartaVirada(gameState.getOpponentCartaVirada());
                }

                break;
        }

        return query;
    }

    @Override
    public TrucoDescription getQueryShowPoints(GameState gameState) {

        TrucoDescription query = new TrucoDescription();

        query.setJogadorMao(gameState.isHand() ? 1 : 2);
        query.setPontosEnvidoRobo(gameState.getEnvidoPoints());
        query.setTentosAnterioresRobo(gameState.getAgentPoints());
        query.setTentosAnterioresHumano(gameState.getOpponentPoints());


        return query;
    }
}
