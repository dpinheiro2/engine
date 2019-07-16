package br.ufsm.cbrgroup.cbr.reuse;

import br.ufsm.cbrgroup.game.GameState;
import br.ufsm.cbrgroup.model.Card;
import br.ufsm.cbrgroup.websocket.Message;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCase;
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
 * Criado em 01/07/2019.
 */


public interface ReuseStrategyEx {

    default Collection<RetrievalResult> getMostSimilarCases(CBRCaseBase caseBase, CBRQuery query, NNConfig simConfig, int k) {

        Collection<RetrievalResult> results = null;
        results = NNScoringMethod.evaluateSimilarity(caseBase.getCases(), query, simConfig);
        results = SelectCases.selectTopKRR(results, k);

        return results;
    }

    default void printRetrievedCases(Collection<RetrievalResult> retrievalResults, String decision) {

        retrievalResults.forEach(rr -> {
            System.out.println(decision + " --> Eval: " + rr.getEval() + " - CaseId: " + rr.get_case().getID());
            //logger.info("Eval: " + rr.getEval() + " - CaseId: " + rr.get_case().getID());
        });
    }

    /** dentre as cartas que tem na mão tentar jogar preferencialmente a mais baixa */
    default Card getPreferCartaBaixa(GameState gameState) {

        Card card;

        if (!gameState.isPlayedCard(gameState.getAgentPlayedCards(), gameState.getAgentCards().get(0))) {
            card =  gameState.getAgentCards().get(0);
        } else if (!gameState.isPlayedCard(gameState.getAgentPlayedCards(), gameState.getAgentCards().get(1))) {
            card = gameState.getAgentCards().get(1);
        } else {
            card = gameState.getAgentCards().get(2);
        }

        return card;

    }

    /** dentre as cartas que tem na mão tentar jogar preferencialmente a media */
    default Card getPreferCartaMedia(GameState gameState) {

        Card card;

        if (!gameState.isPlayedCard(gameState.getAgentPlayedCards(), gameState.getAgentCards().get(1))) {
            card =  gameState.getAgentCards().get(1);
        } else if (!gameState.isPlayedCard(gameState.getAgentPlayedCards(), gameState.getAgentCards().get(2))) {
            card = gameState.getAgentCards().get(2);
        } else {
            card = gameState.getAgentCards().get(0);
        }

        return card;

    }

    /** dentre as cartas que tem na mão tentar jogar preferencialmente a mais alta */
    default Card getPreferCartaAlta(GameState gameState) {

        Card card;

        if (!gameState.isPlayedCard(gameState.getAgentPlayedCards(), gameState.getAgentCards().get(2))) {
            card =  gameState.getAgentCards().get(2);
        } else if (!gameState.isPlayedCard(gameState.getAgentPlayedCards(), gameState.getAgentCards().get(1))) {
            card = gameState.getAgentCards().get(1);
        } else {
            card = gameState.getAgentCards().get(0);
        }

        return card;

    }

    public Message decisionMakingEnvido(CBRCaseBase caseBase, GameState gameState, CBRQuery query, NNConfig simConfig, boolean isTurn);
    public Message decisionMakingFlor(CBRCaseBase caseBase, GameState gameState, CBRQuery query, NNConfig simConfig, boolean isTurn);
    public Message decisionMakingTruco(CBRCaseBase caseBase, GameState gameState, CBRQuery query, NNConfig simConfig, boolean isTurn);
    public Message decisionMakingPlayCard(CBRCaseBase caseBase, GameState gameState, CBRQuery query, NNConfig simConfig, boolean isTurn);

}
