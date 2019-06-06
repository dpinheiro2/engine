package br.ufsm.cbrgroup.cbr.reuse;

import br.ufsm.cbrgroup.description.TrucoDescription;
import br.ufsm.cbrgroup.game.GameState;
import br.ufsm.cbrgroup.websocket.Message;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCaseBase;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRQuery;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CaseComponent;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.RetrievalResult;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.selection.SelectCases;

import java.util.Collection;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 21/05/2019.
 */


public interface ReuseStrategy {

    default Collection<RetrievalResult> getMostSimilarCases(CBRCaseBase caseBase, TrucoDescription gameStateQuery, NNConfig simConfig, int k) {

        Collection<RetrievalResult> results = null;
        CBRQuery query = new CBRQuery();
        query.setDescription((CaseComponent) gameStateQuery);
        results = NNScoringMethod.evaluateSimilarity(caseBase.getCases(), query, simConfig);
        results = SelectCases.selectTopKRR(results, k);
        SelectCases.selectTopK(results, k);

        return results;
    }

    default void printRetrievedCases(Collection<RetrievalResult> retrievalResults, String decision) {

        retrievalResults.forEach(rr -> {
            System.out.println(decision + " --> Eval: " + rr.getEval() + " - CaseId: " + rr.get_case().getID());
            //logger.info("Eval: " + rr.getEval() + " - CaseId: " + rr.get_case().getID());
        });
    }

    public Message decisionMakingEnvido(CBRCaseBase caseBase, GameState gameState, TrucoDescription query, NNConfig simConfig);
    public Message decisionMakingFlor(CBRCaseBase caseBase, GameState gameState, TrucoDescription query, NNConfig simConfig);
    public Message decisionMakingTruco(CBRCaseBase caseBase, GameState gameState, TrucoDescription query, NNConfig simConfig, boolean isTurn);
    public Message decisionMakingPlayCard(CBRCaseBase caseBase, GameState gameState, TrucoDescription query, NNConfig simConfig);
    public Message decisionMakingShowPoints(CBRCaseBase caseBase, GameState gameState, TrucoDescription query, NNConfig simConfig);

}
