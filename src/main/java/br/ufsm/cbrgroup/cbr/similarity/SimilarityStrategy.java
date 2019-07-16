package br.ufsm.cbrgroup.cbr.similarity;

import br.ufsm.cbrgroup.description.GenericDescription;
import br.ufsm.cbrgroup.description.TrucoDescription;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 21/05/2019.
 */


public interface SimilarityStrategy {

    public NNConfig getSimConfigEnvido(GenericDescription gameStateQuery);
    public NNConfig getSimConfigFlor(GenericDescription gameStateQuery);
    public NNConfig getSimConfigTruco(GenericDescription gameStateQuery);
    public NNConfig getSimConfigPlayCard(GenericDescription gameStateQuery);
    public NNConfig getSimConfigShowPoints(GenericDescription gameStateQuery);

}
