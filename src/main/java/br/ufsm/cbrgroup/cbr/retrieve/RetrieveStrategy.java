package br.ufsm.cbrgroup.cbr.retrieve;

import br.ufsm.cbrgroup.description.GenericDescription;
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

    public GenericDescription getQueryEnvido(GameState gameState, GenericDescription query);
    public GenericDescription getQueryFlor(GameState gameState, GenericDescription query);
    public GenericDescription getQueryTruco(GameState gameState, GenericDescription query);
    public GenericDescription getQueryPlayCard(GameState gameState, GenericDescription query);
    public GenericDescription getQueryShowPoints(GameState gameState, GenericDescription query);

}
