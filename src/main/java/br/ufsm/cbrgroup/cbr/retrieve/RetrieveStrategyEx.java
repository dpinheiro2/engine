package br.ufsm.cbrgroup.cbr.retrieve;

import br.ufsm.cbrgroup.description.*;
import br.ufsm.cbrgroup.game.GameState;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRQuery;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 01/07/2019.
 */


public interface RetrieveStrategyEx {

    public CBRQuery getQueryEnvido(GameState gameState, GenericEnvido desc);
    public CBRQuery getQueryFlor(GameState gameState, GenericFlor desc);
    public CBRQuery getQueryTruco(GameState gameState, GenericTruco desc);
    public CBRQuery getQueryPlayCard(GameState gameState, GenericPlayCard desc);

}
