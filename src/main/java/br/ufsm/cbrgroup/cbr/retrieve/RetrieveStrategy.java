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


public interface RetrieveStrategy {

    public TrucoDescription getQueryEnvido(GameState gameState);
    public TrucoDescription getQueryFlor(GameState gameState);
    public TrucoDescription getQueryTruco(GameState gameState);
    public TrucoDescription getQueryPlayCard(GameState gameState);
    public TrucoDescription getQueryShowPoints(GameState gameState);

}
