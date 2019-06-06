package br.ufsm.cbrgroup.cbr.similarity;

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

    public NNConfig getSimConfigEnvido(TrucoDescription gameStateQuery);
    public NNConfig getSimConfigFlor(TrucoDescription gameStateQuery);
    public NNConfig getSimConfigTruco(TrucoDescription gameStateQuery);
    public NNConfig getSimConfigPlayCard(TrucoDescription gameStateQuery);
    public NNConfig getSimConfigShowPoints(TrucoDescription gameStateQuery);

}
