package br.ufsm.cbrgroup.cbr.similarity;

import br.ufsm.cbrgroup.description.GenericDescription;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRQuery;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 01/07/2019.
 */


public interface SimilarityStrategyEx {

    public NNConfig getSimConfigEnvido(CBRQuery gameStateQuery);
    public NNConfig getSimConfigFlor(CBRQuery gameStateQuery);
    public NNConfig getSimConfigTruco(CBRQuery gameStateQuery);
    public NNConfig getSimConfigPlayCard(CBRQuery gameStateQuery);
}
