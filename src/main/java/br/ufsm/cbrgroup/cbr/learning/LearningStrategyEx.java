package br.ufsm.cbrgroup.cbr.learning;

import br.ufsm.cbrgroup.description.*;
import es.ucm.fdi.gaia.jcolibri.cbrcore.*;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.RetrievalResult;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.selection.SelectCases;

import java.util.Collection;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 04/07/2019.
 */


public interface LearningStrategyEx {

    default Collection<RetrievalResult> getMostSimilarCases(CBRCaseBase caseBase, CBRQuery query, NNConfig simConfig, int k) {

        Collection<RetrievalResult> results = null;
        results = NNScoringMethod.evaluateSimilarity(caseBase.getCases(), query, simConfig);
        results = SelectCases.selectTopKRR(results, k);

        return results;
    }

    default NNConfig getSimConfigEnvido(GenericEnvido query) {
        
        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        Attribute isHand = new Attribute("isHand", query.getClass());
        simConfig.addMapping(isHand, new Equal());
        simConfig.setWeight(isHand, 1.0);

        if (query.getHighCardCode() != null) {
            Attribute highCardCode = new Attribute("highCardCode", query.getClass());
            simConfig.addMapping(highCardCode, new Equal());
            simConfig.setWeight(highCardCode, 1.0);
        }

        if (query.getHighCardSuit() != null) {
            Attribute highCardSuit = new Attribute("highCardSuit", query.getClass());
            simConfig.addMapping(highCardSuit, new Equal());
            simConfig.setWeight(highCardSuit, 1.0);
        }

        if (query.getMediumCardCode() != null) {
            Attribute mediumCardCode = new Attribute("mediumCardCode", query.getClass());
            simConfig.addMapping(mediumCardCode, new Equal());
            simConfig.setWeight(mediumCardCode, 1.0);
        }

        if (query.getMediumCardSuit() != null) {
            Attribute mediumCardSuit = new Attribute("mediumCardSuit", query.getClass());
            simConfig.addMapping(mediumCardSuit, new Equal());
            simConfig.setWeight(mediumCardSuit, 1.0);
        }

        if (query.getLowCardCode() != null) {
            Attribute lowCardCode = new Attribute("lowCardCode", query.getClass());
            simConfig.addMapping(lowCardCode, new Equal());
            simConfig.setWeight(lowCardCode, 1.0);
        }

        if (query.getLowCardSuit() != null) {
            Attribute lowCardSuit = new Attribute("lowCardSuit", query.getClass());
            simConfig.addMapping(lowCardSuit, new Equal());
            simConfig.setWeight(lowCardSuit, 1.0);
        }

        if (query.getEnvidoPoints() != null) {
            Attribute envidoPoints = new Attribute("envidoPoints", query.getClass());
            simConfig.addMapping(envidoPoints, new Equal());
            simConfig.setWeight(envidoPoints, 1.0);
        }

        if (query.getPoints() != null) {
            Attribute points = new Attribute("points", query.getClass());
            simConfig.addMapping(points, new Equal());
            simConfig.setWeight(points, 1.0);
        }

        if (query.getStateDecision() != null) {
            Attribute stateDecision = new Attribute("stateDecision", query.getClass());
            simConfig.addMapping(stateDecision, new Equal());
            simConfig.setWeight(stateDecision, 1.0);
        }

        if (query.getEnvidoChainSize() != null) {
            Attribute envidoChainSize = new Attribute("envidoChainSize", query.getClass());
            simConfig.addMapping(envidoChainSize, new Equal());
            simConfig.setWeight(envidoChainSize, 1.0);
        }

        if (query.getOpponentPoints() != null) {
            Attribute opponentPoints = new Attribute("opponentPoints", query.getClass());
            simConfig.addMapping(opponentPoints, new Equal());
            simConfig.setWeight(opponentPoints, 1.0);
        }

        if (query.getOpponentPlayedCardCode() != null) {
            Attribute opponentPlayedCardCode = new Attribute("opponentPlayedCardCode", query.getClass());
            simConfig.addMapping(opponentPlayedCardCode, new Equal());
            simConfig.setWeight(opponentPlayedCardCode, 1.0);
        }

        if (query.getOpponentPlayedCardSuit() != null) {
            Attribute opponentPlayedCardSuit = new Attribute("opponentPlayedCardSuit", query.getClass());
            simConfig.addMapping(opponentPlayedCardSuit, new Equal());
            simConfig.setWeight(opponentPlayedCardSuit, 1.0);
        }

        if (query.getTriedEnvidoBluffs() != null) {
            Attribute triedEnvidoBluffs = new Attribute("triedEnvidoBluffs", query.getClass());
            simConfig.addMapping(triedEnvidoBluffs, new Equal());
            simConfig.setWeight(triedEnvidoBluffs, 1.0);
        }

        if (query.getEnvidoBluffCanBeDetected() != null) {
            Attribute envidoBluffCanBeDetected = new Attribute("envidoBluffCanBeDetected", query.getClass());
            simConfig.addMapping(envidoBluffCanBeDetected, new Equal());
            simConfig.setWeight(envidoBluffCanBeDetected, 1.0);
        }

        if (query.getEnvidoBluffSuccessful() != null) {
            Attribute envidoBluffSuccessful = new Attribute("envidoBluffSuccessful", query.getClass());
            simConfig.addMapping(envidoBluffSuccessful, new Equal());
            simConfig.setWeight(envidoBluffSuccessful, 1.0);
        }

        if (query.getJogada() != null) {
            Attribute jogada = new Attribute("jogada", query.getClass());
            simConfig.addMapping(jogada, new Equal());
            simConfig.setWeight(jogada, 1.0);
        }

        if (query.getIsBluff() != null) {
            Attribute isBluff = new Attribute("isBluff", query.getClass());
            simConfig.addMapping(isBluff, new Equal());
            simConfig.setWeight(isBluff, 1.0);
        }

        if (query.getTypeBluff() != null) {
            Attribute typeBluff = new Attribute("typeBluff", query.getClass());
            simConfig.addMapping(typeBluff, new Equal());
            simConfig.setWeight(typeBluff, 1.0);
        }

        if (query.getExpectedValue() != 0.0) {
            Attribute expectedValue = new Attribute("expectedValue", query.getClass());
            simConfig.addMapping(expectedValue, new Equal());
            simConfig.setWeight(expectedValue, 1.0);
        }

        if (query.getIsSucessful() != 0.0) {
            Attribute isSucessful = new Attribute("isSucessful", query.getClass());
            simConfig.addMapping(isSucessful, new Equal());
            simConfig.setWeight(isSucessful, 1.0);
        }

        if (query.getWonPoints() != 0.0) {
            Attribute wonPoints = new Attribute("wonPoints", query.getClass());
            simConfig.addMapping(wonPoints, new Equal());
            simConfig.setWeight(wonPoints, 1.0);
        }

        if (query.getLostPoints() != 0.0) {
            Attribute lostPoints = new Attribute("lostPoints", query.getClass());
            simConfig.addMapping(lostPoints, new Equal());
            simConfig.setWeight(lostPoints, 1.0);
        }

        if (query.getBluffCanBeDetected() != 0.0) {
            Attribute bluffCanBeDetected = new Attribute("bluffCanBeDetected", query.getClass());
            simConfig.addMapping(bluffCanBeDetected, new Equal());
            simConfig.setWeight(bluffCanBeDetected, 1.0);
        }

        if (query.getIsStrongHand() != 0.0) {
            Attribute isStrongHand = new Attribute("isStrongHand", query.getClass());
            simConfig.addMapping(isStrongHand, new Equal());
            simConfig.setWeight(isStrongHand, 1.0);
        }

        if (query.getIsWeakHand() != 0.0) {
            Attribute isWeakHand = new Attribute("isWeakHand", query.getClass());
            simConfig.addMapping(isWeakHand, new Equal());
            simConfig.setWeight(isWeakHand, 1.0);
        }

        if (query.getIsFewPoints() != 0.0) {
            Attribute isFewPoints = new Attribute("isFewPoints", query.getClass());
            simConfig.addMapping(isFewPoints, new Equal());
            simConfig.setWeight(isFewPoints, 1.0);
        }

        if (query.getIsManyPoints() != 0.0) {
            Attribute isManyPoints = new Attribute("isManyPoints", query.getClass());
            simConfig.addMapping(isManyPoints, new Equal());
            simConfig.setWeight(isManyPoints, 1.0);
        }

        if (query.getIsManyPointsAgo() != 0.0) {
            Attribute isManyPointsAgo = new Attribute("isManyPointsAgo", query.getClass());
            simConfig.addMapping(isManyPointsAgo, new Equal());
            simConfig.setWeight(isManyPointsAgo, 1.0);
        }

        if (query.getIsManyPointsForeward() != 0.0) {
            Attribute isManyPointsForeward = new Attribute("isManyPointsForeward", query.getClass());
            simConfig.addMapping(isManyPointsForeward, new Equal());
            simConfig.setWeight(isManyPointsForeward, 1.0);
        }

        if (query.getIsTestOpponent() != 0.0) {
            Attribute isTestOpponent = new Attribute("isTestOpponent", query.getClass());
            simConfig.addMapping(isTestOpponent, new Equal());
            simConfig.setWeight(isTestOpponent, 1.0);
        }

        if (query.getIsOpponentTight() != 0.0) {
            Attribute isOpponentTight = new Attribute("isOpponentTight", query.getClass());
            simConfig.addMapping(isOpponentTight, new Equal());
            simConfig.setWeight(isOpponentTight, 1.0);
        }

        if (query.getIsOpponentLoose() != 0.0) {
            Attribute isOpponentLoose = new Attribute("isOpponentLoose", query.getClass());
            simConfig.addMapping(isOpponentLoose, new Equal());
            simConfig.setWeight(isOpponentLoose, 1.0);
        }

        if (query.getIsOpponentAgressive() != 0.0) {
            Attribute isOpponentAgressive = new Attribute("isOpponentAgressive", query.getClass());
            simConfig.addMapping(isOpponentAgressive, new Equal());
            simConfig.setWeight(isOpponentAgressive, 1.0);
        }

        if (query.getIsOpponentPassive() != 0.0) {
            Attribute isOpponentPassive = new Attribute("isOpponentPassive", query.getClass());
            simConfig.addMapping(isOpponentPassive, new Equal());
            simConfig.setWeight(isOpponentPassive, 1.0);
        }

        if (query.getCanOpponentInferCards() != 0.0) {
            Attribute canOpponentInferCards = new Attribute("canOpponentInferCards", query.getClass());
            simConfig.addMapping(canOpponentInferCards, new Equal());
            simConfig.setWeight(canOpponentInferCards, 1.0);
        }

        if (query.getCanInferOpponentCards() != 0.0) {
            Attribute canInferOpponentCards = new Attribute("canInferOpponentCards", query.getClass());
            simConfig.addMapping(canInferOpponentCards, new Equal());
            simConfig.setWeight(canInferOpponentCards, 1.0);
        }

        return simConfig;
    }

    default NNConfig getSimConfigFlor(GenericFlor query) {

        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        Attribute isHand = new Attribute("isHand", query.getClass());
        simConfig.addMapping(isHand, new Equal());
        simConfig.setWeight(isHand, 1.0);

        if (query.getHighCardCode() != null) {
            Attribute highCardCode = new Attribute("highCardCode", query.getClass());
            simConfig.addMapping(highCardCode, new Equal());
            simConfig.setWeight(highCardCode, 1.0);
        }

        if (query.getHighCardSuit() != null) {
            Attribute highCardSuit = new Attribute("highCardSuit", query.getClass());
            simConfig.addMapping(highCardSuit, new Equal());
            simConfig.setWeight(highCardSuit, 1.0);
        }

        if (query.getMediumCardCode() != null) {
            Attribute mediumCardCode = new Attribute("mediumCardCode", query.getClass());
            simConfig.addMapping(mediumCardCode, new Equal());
            simConfig.setWeight(mediumCardCode, 1.0);
        }

        if (query.getMediumCardSuit() != null) {
            Attribute mediumCardSuit = new Attribute("mediumCardSuit", query.getClass());
            simConfig.addMapping(mediumCardSuit, new Equal());
            simConfig.setWeight(mediumCardSuit, 1.0);
        }

        if (query.getLowCardCode() != null) {
            Attribute lowCardCode = new Attribute("lowCardCode", query.getClass());
            simConfig.addMapping(lowCardCode, new Equal());
            simConfig.setWeight(lowCardCode, 1.0);
        }

        if (query.getLowCardSuit() != null) {
            Attribute lowCardSuit = new Attribute("lowCardSuit", query.getClass());
            simConfig.addMapping(lowCardSuit, new Equal());
            simConfig.setWeight(lowCardSuit, 1.0);
        }

        if (query.getFlorPoints() != null) {
            Attribute florPoints = new Attribute("florPoints", query.getClass());
            simConfig.addMapping(florPoints, new Equal());
            simConfig.setWeight(florPoints, 1.0);
        }

        if (query.getPoints() != null) {
            Attribute points = new Attribute("points", query.getClass());
            simConfig.addMapping(points, new Equal());
            simConfig.setWeight(points, 1.0);
        }

        if (query.getStateDecision() != null) {
            Attribute stateDecision = new Attribute("stateDecision", query.getClass());
            simConfig.addMapping(stateDecision, new Equal());
            simConfig.setWeight(stateDecision, 1.0);
        }

        if (query.getFlorChainSize() != null) {
            Attribute florChainSize = new Attribute("florChainSize", query.getClass());
            simConfig.addMapping(florChainSize, new Equal());
            simConfig.setWeight(florChainSize, 1.0);
        }

        if (query.getOpponentPoints() != null) {
            Attribute opponentPoints = new Attribute("opponentPoints", query.getClass());
            simConfig.addMapping(opponentPoints, new Equal());
            simConfig.setWeight(opponentPoints, 1.0);
        }

        if (query.getOpponentPlayedCardCode() != null) {
            Attribute opponentPlayedCardCode = new Attribute("opponentPlayedCardCode", query.getClass());
            simConfig.addMapping(opponentPlayedCardCode, new Equal());
            simConfig.setWeight(opponentPlayedCardCode, 1.0);
        }

        if (query.getOpponentPlayedCardSuit() != null) {
            Attribute opponentPlayedCardSuit = new Attribute("opponentPlayedCardSuit", query.getClass());
            simConfig.addMapping(opponentPlayedCardSuit, new Equal());
            simConfig.setWeight(opponentPlayedCardSuit, 1.0);
        }

        if (query.getTriedFlorBluffs() != null) {
            Attribute triedFlorBluffs = new Attribute("triedFlorBluffs", query.getClass());
            simConfig.addMapping(triedFlorBluffs, new Equal());
            simConfig.setWeight(triedFlorBluffs, 1.0);
        }

        if (query.getFlorBluffCanBeDetected() != null) {
            Attribute florBluffCanBeDetected = new Attribute("florBluffCanBeDetected", query.getClass());
            simConfig.addMapping(florBluffCanBeDetected, new Equal());
            simConfig.setWeight(florBluffCanBeDetected, 1.0);
        }

        if (query.getFlorBluffSuccessful() != null) {
            Attribute florBluffSuccessful = new Attribute("florBluffSuccessful", query.getClass());
            simConfig.addMapping(florBluffSuccessful, new Equal());
            simConfig.setWeight(florBluffSuccessful, 1.0);
        }

        if (query.getJogada() != null) {
            Attribute jogada = new Attribute("jogada", query.getClass());
            simConfig.addMapping(jogada, new Equal());
            simConfig.setWeight(jogada, 1.0);
        }

        if (query.getIsBluff() != null) {
            Attribute isBluff = new Attribute("isBluff", query.getClass());
            simConfig.addMapping(isBluff, new Equal());
            simConfig.setWeight(isBluff, 1.0);
        }

        if (query.getTypeBluff() != null) {
            Attribute typeBluff = new Attribute("typeBluff", query.getClass());
            simConfig.addMapping(typeBluff, new Equal());
            simConfig.setWeight(typeBluff, 1.0);
        }

        if (query.getExpectedValue() != 0.0) {
            Attribute expectedValue = new Attribute("expectedValue", query.getClass());
            simConfig.addMapping(expectedValue, new Equal());
            simConfig.setWeight(expectedValue, 1.0);
        }

        if (query.getIsSucessful() != 0.0) {
            Attribute isSucessful = new Attribute("isSucessful", query.getClass());
            simConfig.addMapping(isSucessful, new Equal());
            simConfig.setWeight(isSucessful, 1.0);
        }

        if (query.getWonPoints() != 0.0) {
            Attribute wonPoints = new Attribute("wonPoints", query.getClass());
            simConfig.addMapping(wonPoints, new Equal());
            simConfig.setWeight(wonPoints, 1.0);
        }

        if (query.getLostPoints() != 0.0) {
            Attribute lostPoints = new Attribute("lostPoints", query.getClass());
            simConfig.addMapping(lostPoints, new Equal());
            simConfig.setWeight(lostPoints, 1.0);
        }

        if (query.getBluffCanBeDetected() != 0.0) {
            Attribute bluffCanBeDetected = new Attribute("bluffCanBeDetected", query.getClass());
            simConfig.addMapping(bluffCanBeDetected, new Equal());
            simConfig.setWeight(bluffCanBeDetected, 1.0);
        }

        if (query.getIsStrongHand() != 0.0) {
            Attribute isStrongHand = new Attribute("isStrongHand", query.getClass());
            simConfig.addMapping(isStrongHand, new Equal());
            simConfig.setWeight(isStrongHand, 1.0);
        }

        if (query.getIsWeakHand() != 0.0) {
            Attribute isWeakHand = new Attribute("isWeakHand", query.getClass());
            simConfig.addMapping(isWeakHand, new Equal());
            simConfig.setWeight(isWeakHand, 1.0);
        }

        if (query.getIsFewPoints() != 0.0) {
            Attribute isFewPoints = new Attribute("isFewPoints", query.getClass());
            simConfig.addMapping(isFewPoints, new Equal());
            simConfig.setWeight(isFewPoints, 1.0);
        }

        if (query.getIsManyPoints() != 0.0) {
            Attribute isManyPoints = new Attribute("isManyPoints", query.getClass());
            simConfig.addMapping(isManyPoints, new Equal());
            simConfig.setWeight(isManyPoints, 1.0);
        }

        if (query.getIsManyPointsAgo() != 0.0) {
            Attribute isManyPointsAgo = new Attribute("isManyPointsAgo", query.getClass());
            simConfig.addMapping(isManyPointsAgo, new Equal());
            simConfig.setWeight(isManyPointsAgo, 1.0);
        }

        if (query.getIsManyPointsForeward() != 0.0) {
            Attribute isManyPointsForeward = new Attribute("isManyPointsForeward", query.getClass());
            simConfig.addMapping(isManyPointsForeward, new Equal());
            simConfig.setWeight(isManyPointsForeward, 1.0);
        }

        if (query.getIsTestOpponent() != 0.0) {
            Attribute isTestOpponent = new Attribute("isTestOpponent", query.getClass());
            simConfig.addMapping(isTestOpponent, new Equal());
            simConfig.setWeight(isTestOpponent, 1.0);
        }

        if (query.getIsOpponentTight() != 0.0) {
            Attribute isOpponentTight = new Attribute("isOpponentTight", query.getClass());
            simConfig.addMapping(isOpponentTight, new Equal());
            simConfig.setWeight(isOpponentTight, 1.0);
        }

        if (query.getIsOpponentLoose() != 0.0) {
            Attribute isOpponentLoose = new Attribute("isOpponentLoose", query.getClass());
            simConfig.addMapping(isOpponentLoose, new Equal());
            simConfig.setWeight(isOpponentLoose, 1.0);
        }

        if (query.getIsOpponentAgressive() != 0.0) {
            Attribute isOpponentAgressive = new Attribute("isOpponentAgressive", query.getClass());
            simConfig.addMapping(isOpponentAgressive, new Equal());
            simConfig.setWeight(isOpponentAgressive, 1.0);
        }

        if (query.getIsOpponentPassive() != 0.0) {
            Attribute isOpponentPassive = new Attribute("isOpponentPassive", query.getClass());
            simConfig.addMapping(isOpponentPassive, new Equal());
            simConfig.setWeight(isOpponentPassive, 1.0);
        }

        if (query.getCanOpponentInferCards() != 0.0) {
            Attribute canOpponentInferCards = new Attribute("canOpponentInferCards", query.getClass());
            simConfig.addMapping(canOpponentInferCards, new Equal());
            simConfig.setWeight(canOpponentInferCards, 1.0);
        }

        if (query.getCanInferOpponentCards() != 0.0) {
            Attribute canInferOpponentCards = new Attribute("canInferOpponentCards", query.getClass());
            simConfig.addMapping(canInferOpponentCards, new Equal());
            simConfig.setWeight(canInferOpponentCards, 1.0);
        }


        return simConfig;
    }

    default NNConfig getSimConfigTruco(GenericTruco query) {

        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        Attribute isHand = new Attribute("isHand", query.getClass());
        simConfig.addMapping(isHand, new Equal());
        simConfig.setWeight(isHand, 1.0);

        if (query.getHighCardCode() != null) {
            Attribute highCardCode = new Attribute("highCardCode", query.getClass());
            simConfig.addMapping(highCardCode, new Equal());
            simConfig.setWeight(highCardCode, 1.0);
        }

        if (query.getHighCardSuit() != null) {
            Attribute highCardSuit = new Attribute("highCardSuit", query.getClass());
            simConfig.addMapping(highCardSuit, new Equal());
            simConfig.setWeight(highCardSuit, 1.0);
        }

        if (query.getMediumCardCode() != null) {
            Attribute mediumCardCode = new Attribute("mediumCardCode", query.getClass());
            simConfig.addMapping(mediumCardCode, new Equal());
            simConfig.setWeight(mediumCardCode, 1.0);
        }

        if (query.getMediumCardSuit() != null) {
            Attribute mediumCardSuit = new Attribute("mediumCardSuit", query.getClass());
            simConfig.addMapping(mediumCardSuit, new Equal());
            simConfig.setWeight(mediumCardSuit, 1.0);
        }

        if (query.getLowCardCode() != null) {
            Attribute lowCardCode = new Attribute("lowCardCode", query.getClass());
            simConfig.addMapping(lowCardCode, new Equal());
            simConfig.setWeight(lowCardCode, 1.0);
        }

        if (query.getLowCardSuit() != null) {
            Attribute lowCardSuit = new Attribute("lowCardSuit", query.getClass());
            simConfig.addMapping(lowCardSuit, new Equal());
            simConfig.setWeight(lowCardSuit, 1.0);
        }


        if (query.getPoints() != null) {
            Attribute points = new Attribute("points", query.getClass());
            simConfig.addMapping(points, new Equal());
            simConfig.setWeight(points, 1.0);
        }

        if (query.getOpponentPoints() != null) {
            Attribute opponentPoints = new Attribute("opponentPoints", query.getClass());
            simConfig.addMapping(opponentPoints, new Equal());
            simConfig.setWeight(opponentPoints, 1.0);
        }

        if (query.getStateDecisionTurn() != null) {
            Attribute stateDecisionTurn = new Attribute("stateDecisionTurn", query.getClass());
            simConfig.addMapping(stateDecisionTurn, new Equal());
            simConfig.setWeight(stateDecisionTurn, 1.0);
        }

        if (query.getStateDecisionToken() != null) {
            Attribute stateTruco = new Attribute("stateDecisionToken", query.getClass());
            simConfig.addMapping(stateTruco, new Equal());
            simConfig.setWeight(stateTruco, 1.0);
        }

        if (query.getEnvidoPointsWon() != null) {
            Attribute envidoPointsWon = new Attribute("envidoPointsWon", query.getClass());
            simConfig.addMapping(envidoPointsWon, new Equal());
            simConfig.setWeight(envidoPointsWon, 1.0);
        }

        if (query.getFlorPointsWon() != null) {
            Attribute florPointsWon = new Attribute("florPointsWon", query.getClass());
            simConfig.addMapping(florPointsWon, new Equal());
            simConfig.setWeight(florPointsWon, 1.0);
        }

        if (query.getTrucoChainSize() != null) {
            Attribute trucoChainSize = new Attribute("trucoChainSize", query.getClass());
            simConfig.addMapping(trucoChainSize, new Equal());
            simConfig.setWeight(trucoChainSize, 1.0);
        }

        if (query.getWinnerRound1() != null) {
            Attribute winnerRound1 = new Attribute("winnerRound1", query.getClass());
            simConfig.addMapping(winnerRound1, new Equal());
            simConfig.setWeight(winnerRound1, 1.0);
        }

        if (query.getWinnerRound2() != null) {
            Attribute winnerRound2 = new Attribute("winnerRound2", query.getClass());
            simConfig.addMapping(winnerRound2, new Equal());
            simConfig.setWeight(winnerRound2, 1.0);
        }

        if (query.getPlayedCard1Code() != null) {
            Attribute playedCard1Code = new Attribute("playedCard1Code", query.getClass());
            simConfig.addMapping(playedCard1Code, new Equal());
            simConfig.setWeight(playedCard1Code, 1.0);
        }

        if (query.getPlayedCard1Suit() != null) {
            Attribute playedCard1Suit = new Attribute("playedCard1Suit", query.getClass());
            simConfig.addMapping(playedCard1Suit, new Equal());
            simConfig.setWeight(playedCard1Suit, 1.0);
        }

        if (query.getPlayedCard2Code() != null) {
            Attribute playedCard2Code = new Attribute("playedCard2Code", query.getClass());
            simConfig.addMapping(playedCard2Code, new Equal());
            simConfig.setWeight(playedCard2Code, 1.0);
        }

        if (query.getPlayedCard2Suit() != null) {
            Attribute playedCard2Suit = new Attribute("playedCard2Suit", query.getClass());
            simConfig.addMapping(playedCard2Suit, new Equal());
            simConfig.setWeight(playedCard2Suit, 1.0);
        }

        if (query.getPlayedCard3Code() != null) {
            Attribute playedCard3Code = new Attribute("playedCard3Code", query.getClass());
            simConfig.addMapping(playedCard3Code, new Equal());
            simConfig.setWeight(playedCard3Code, 1.0);
        }

        if (query.getPlayedCard3Suit() != null) {
            Attribute playedCard3Suit = new Attribute("playedCard3Suit", query.getClass());
            simConfig.addMapping(playedCard3Suit, new Equal());
            simConfig.setWeight(playedCard3Suit, 1.0);
        }

        if (query.getPlayedCard4Code() != null) {
            Attribute playedCard4Code = new Attribute("playedCard4Code", query.getClass());
            simConfig.addMapping(playedCard4Code, new Equal());
            simConfig.setWeight(playedCard4Code, 1.0);
        }

        if (query.getPlayedCard4Suit() != null) {
            Attribute playedCard4Suit = new Attribute("playedCard4Suit", query.getClass());
            simConfig.addMapping(playedCard4Suit, new Equal());
            simConfig.setWeight(playedCard4Suit, 1.0);
        }

        if (query.getPlayedCard5Code() != null) {
            Attribute playedCard5Code = new Attribute("playedCard5Code", query.getClass());
            simConfig.addMapping(playedCard5Code, new Equal());
            simConfig.setWeight(playedCard5Code, 1.0);
        }

        if (query.getPlayedCard5Suit() != null) {
            Attribute playedCard5Suit = new Attribute("playedCard5Suit", query.getClass());
            simConfig.addMapping(playedCard5Suit, new Equal());
            simConfig.setWeight(playedCard5Suit, 1.0);
        }

        if (query.getPlayedCard6Code() != null) {
            Attribute playedCard6Code = new Attribute("playedCard6Code", query.getClass());
            simConfig.addMapping(playedCard6Code, new Equal());
            simConfig.setWeight(playedCard6Code, 1.0);
        }

        if (query.getPlayedCard6Suit() != null) {
            Attribute playedCard6Suit = new Attribute("playedCard6Suit", query.getClass());
            simConfig.addMapping(playedCard6Suit, new Equal());
            simConfig.setWeight(playedCard6Suit, 1.0);
        }

        if (query.getWhoCard1() != null) {
            Attribute whoCard1 = new Attribute("whoCard1", query.getClass());
            simConfig.addMapping(whoCard1, new Equal());
            simConfig.setWeight(whoCard1, 1.0);
        }

        if (query.getWhoCard2() != null) {
            Attribute whoCard2 = new Attribute("whoCard1", query.getClass());
            simConfig.addMapping(whoCard2, new Equal());
            simConfig.setWeight(whoCard2, 1.0);
        }

        if (query.getWhoCard3() != null) {
            Attribute whoCard3 = new Attribute("whoCard1", query.getClass());
            simConfig.addMapping(whoCard3, new Equal());
            simConfig.setWeight(whoCard3, 1.0);
        }

        if (query.getWhoCard4() != null) {
            Attribute whoCard4 = new Attribute("whoCard1", query.getClass());
            simConfig.addMapping(whoCard4, new Equal());
            simConfig.setWeight(whoCard4, 1.0);
        }

        if (query.getWhoCard5() != null) {
            Attribute whoCard5 = new Attribute("whoCard1", query.getClass());
            simConfig.addMapping(whoCard5, new Equal());
            simConfig.setWeight(whoCard5, 1.0);
        }

        if (query.getWhoCard6() != null) {
            Attribute whoCard6 = new Attribute("whoCard6", query.getClass());
            simConfig.addMapping(whoCard6, new Equal());
            simConfig.setWeight(whoCard6, 1.0);
        }

        if (query.getTriedTrucoBluffs() != null) {
            Attribute triedTrucoBluffs = new Attribute("triedTrucoBluffs", query.getClass());
            simConfig.addMapping(triedTrucoBluffs, new Equal());
            simConfig.setWeight(triedTrucoBluffs, 1.0);
        }

        if (query.getTrucoBluffCanBeDetected() != null) {
            Attribute trucoBluffCanBeDetected = new Attribute("trucoBluffCanBeDetected", query.getClass());
            simConfig.addMapping(trucoBluffCanBeDetected, new Equal());
            simConfig.setWeight(trucoBluffCanBeDetected, 1.0);
        }

        if (query.getTrucoBluffSuccessful() != null) {
            Attribute trucoBluffSuccessful = new Attribute("trucoBluffSuccessful", query.getClass());
            simConfig.addMapping(trucoBluffSuccessful, new Equal());
            simConfig.setWeight(trucoBluffSuccessful, 1.0);
        }

        if (query.getJogada() != null) {
            Attribute jogada = new Attribute("jogada", query.getClass());
            simConfig.addMapping(jogada, new Equal());
            simConfig.setWeight(jogada, 1.0);
        }

        if (query.getIsBluff() != null) {
            Attribute isBluff = new Attribute("isBluff", query.getClass());
            simConfig.addMapping(isBluff, new Equal());
            simConfig.setWeight(isBluff, 1.0);
        }

        if (query.getTypeBluff() != null) {
            Attribute typeBluff = new Attribute("typeBluff", query.getClass());
            simConfig.addMapping(typeBluff, new Equal());
            simConfig.setWeight(typeBluff, 1.0);
        }

        if (query.getExpectedValue() != 0.0) {
            Attribute expectedValue = new Attribute("expectedValue", query.getClass());
            simConfig.addMapping(expectedValue, new Equal());
            simConfig.setWeight(expectedValue, 1.0);
        }

        if (query.getIsSucessful() != 0.0) {
            Attribute isSucessful = new Attribute("isSucessful", query.getClass());
            simConfig.addMapping(isSucessful, new Equal());
            simConfig.setWeight(isSucessful, 1.0);
        }

        if (query.getWonPoints() != 0.0) {
            Attribute wonPoints = new Attribute("wonPoints", query.getClass());
            simConfig.addMapping(wonPoints, new Equal());
            simConfig.setWeight(wonPoints, 1.0);
        }

        if (query.getBluffCanBeDetected() != 0.0) {
            Attribute bluffCanBeDetected = new Attribute("bluffCanBeDetected", query.getClass());
            simConfig.addMapping(bluffCanBeDetected, new Equal());
            simConfig.setWeight(bluffCanBeDetected, 1.0);
        }

        if (query.getIsStrongHand() != 0.0) {
            Attribute isStrongHand = new Attribute("isStrongHand", query.getClass());
            simConfig.addMapping(isStrongHand, new Equal());
            simConfig.setWeight(isStrongHand, 1.0);
        }

        if (query.getIsWeakHand() != 0.0) {
            Attribute isWeakHand = new Attribute("isWeakHand", query.getClass());
            simConfig.addMapping(isWeakHand, new Equal());
            simConfig.setWeight(isWeakHand, 1.0);
        }

        if (query.getIsFewPoints() != 0.0) {
            Attribute isFewPoints = new Attribute("isFewPoints", query.getClass());
            simConfig.addMapping(isFewPoints, new Equal());
            simConfig.setWeight(isFewPoints, 1.0);
        }

        if (query.getIsManyPoints() != 0.0) {
            Attribute isManyPoints = new Attribute("isManyPoints", query.getClass());
            simConfig.addMapping(isManyPoints, new Equal());
            simConfig.setWeight(isManyPoints, 1.0);
        }

        if (query.getIsManyPointsAgo() != 0.0) {
            Attribute isManyPointsAgo = new Attribute("isManyPointsAgo", query.getClass());
            simConfig.addMapping(isManyPointsAgo, new Equal());
            simConfig.setWeight(isManyPointsAgo, 1.0);
        }

        if (query.getIsManyPointsForeward() != 0.0) {
            Attribute isManyPointsForeward = new Attribute("isManyPointsForeward", query.getClass());
            simConfig.addMapping(isManyPointsForeward, new Equal());
            simConfig.setWeight(isManyPointsForeward, 1.0);
        }

        if (query.getIsTestOpponent() != 0.0) {
            Attribute isTestOpponent = new Attribute("isTestOpponent", query.getClass());
            simConfig.addMapping(isTestOpponent, new Equal());
            simConfig.setWeight(isTestOpponent, 1.0);
        }

        if (query.getIsOpponentTight() != 0.0) {
            Attribute isOpponentTight = new Attribute("isOpponentTight", query.getClass());
            simConfig.addMapping(isOpponentTight, new Equal());
            simConfig.setWeight(isOpponentTight, 1.0);
        }

        if (query.getIsOpponentLoose() != 0.0) {
            Attribute isOpponentLoose = new Attribute("isOpponentLoose", query.getClass());
            simConfig.addMapping(isOpponentLoose, new Equal());
            simConfig.setWeight(isOpponentLoose, 1.0);
        }

        if (query.getIsOpponentAgressive() != 0.0) {
            Attribute isOpponentAgressive = new Attribute("isOpponentAgressive", query.getClass());
            simConfig.addMapping(isOpponentAgressive, new Equal());
            simConfig.setWeight(isOpponentAgressive, 1.0);
        }

        if (query.getIsOpponentPassive() != 0.0) {
            Attribute isOpponentPassive = new Attribute("isOpponentPassive", query.getClass());
            simConfig.addMapping(isOpponentPassive, new Equal());
            simConfig.setWeight(isOpponentPassive, 1.0);
        }


        return simConfig;
    }

    default NNConfig getSimConfigPlayCard(GenericPlayCard query) {

        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        Attribute isHand = new Attribute("isHand", query.getClass());
        simConfig.addMapping(isHand, new Equal());
        simConfig.setWeight(isHand, 1.0);

        if (query.getHighCardCode() != null) {
            Attribute highCardCode = new Attribute("highCardCode", query.getClass());
            simConfig.addMapping(highCardCode, new Equal());
            simConfig.setWeight(highCardCode, 1.0);
        }

        if (query.getHighCardSuit() != null) {
            Attribute highCardSuit = new Attribute("highCardSuit", query.getClass());
            simConfig.addMapping(highCardSuit, new Equal());
            simConfig.setWeight(highCardSuit, 1.0);
        }

        if (query.getMediumCardCode() != null) {
            Attribute mediumCardCode = new Attribute("mediumCardCode", query.getClass());
            simConfig.addMapping(mediumCardCode, new Equal());
            simConfig.setWeight(mediumCardCode, 1.0);
        }

        if (query.getMediumCardSuit() != null) {
            Attribute mediumCardSuit = new Attribute("mediumCardSuit", query.getClass());
            simConfig.addMapping(mediumCardSuit, new Equal());
            simConfig.setWeight(mediumCardSuit, 1.0);
        }

        if (query.getLowCardCode() != null) {
            Attribute lowCardCode = new Attribute("lowCardCode", query.getClass());
            simConfig.addMapping(lowCardCode, new Equal());
            simConfig.setWeight(lowCardCode, 1.0);
        }

        if (query.getLowCardSuit() != null) {
            Attribute lowCardSuit = new Attribute("lowCardSuit", query.getClass());
            simConfig.addMapping(lowCardSuit, new Equal());
            simConfig.setWeight(lowCardSuit, 1.0);
        }


        if (query.getPoints() != null) {
            Attribute points = new Attribute("points", query.getClass());
            simConfig.addMapping(points, new Equal());
            simConfig.setWeight(points, 1.0);
        }

        if (query.getOpponentPoints() != null) {
            Attribute opponentPoints = new Attribute("opponentPoints", query.getClass());
            simConfig.addMapping(opponentPoints, new Equal());
            simConfig.setWeight(opponentPoints, 1.0);
        }

        if (query.getStateDecisionTurn() != null) {
            Attribute stateDecisionTurn = new Attribute("stateDecisionTurn", query.getClass());
            simConfig.addMapping(stateDecisionTurn, new Equal());
            simConfig.setWeight(stateDecisionTurn, 1.0);
        }

        if (query.getStateDecisionToken() != null) {
            Attribute stateTruco = new Attribute("stateDecisionToken", query.getClass());
            simConfig.addMapping(stateTruco, new Equal());
            simConfig.setWeight(stateTruco, 1.0);
        }

        if (query.getEnvidoPointsWon() != null) {
            Attribute envidoPointsWon = new Attribute("envidoPointsWon", query.getClass());
            simConfig.addMapping(envidoPointsWon, new Equal());
            simConfig.setWeight(envidoPointsWon, 1.0);
        }

        if (query.getFlorPointsWon() != null) {
            Attribute florPointsWon = new Attribute("florPointsWon", query.getClass());
            simConfig.addMapping(florPointsWon, new Equal());
            simConfig.setWeight(florPointsWon, 1.0);
        }

        if (query.getEnvidoChainSize() != null) {
            Attribute envidoChainSize = new Attribute("envidoChainSize", query.getClass());
            simConfig.addMapping(envidoChainSize, new Equal());
            simConfig.setWeight(envidoChainSize, 1.0);
        }

        if (query.getFlorChainSize() != null) {
            Attribute florChainSize = new Attribute("florChainSize", query.getClass());
            simConfig.addMapping(florChainSize, new Equal());
            simConfig.setWeight(florChainSize, 1.0);
        }

        if (query.getTrucoChainSize() != null) {
            Attribute trucoChainSize = new Attribute("trucoChainSize", query.getClass());
            simConfig.addMapping(trucoChainSize, new Equal());
            simConfig.setWeight(trucoChainSize, 1.0);
        }

        if (query.getWinnerRound1() != null) {
            Attribute winnerRound1 = new Attribute("winnerRound1", query.getClass());
            simConfig.addMapping(winnerRound1, new Equal());
            simConfig.setWeight(winnerRound1, 1.0);
        }

        if (query.getWinnerRound2() != null) {
            Attribute winnerRound2 = new Attribute("winnerRound2", query.getClass());
            simConfig.addMapping(winnerRound2, new Equal());
            simConfig.setWeight(winnerRound2, 1.0);
        }

        if (query.getPlayedCard1Code() != null) {
            Attribute playedCard1Code = new Attribute("playedCard1Code", query.getClass());
            simConfig.addMapping(playedCard1Code, new Equal());
            simConfig.setWeight(playedCard1Code, 1.0);
        }

        if (query.getPlayedCard1Suit() != null) {
            Attribute playedCard1Suit = new Attribute("playedCard1Suit", query.getClass());
            simConfig.addMapping(playedCard1Suit, new Equal());
            simConfig.setWeight(playedCard1Suit, 1.0);
        }

        if (query.getPlayedCard2Code() != null) {
            Attribute playedCard2Code = new Attribute("playedCard2Code", query.getClass());
            simConfig.addMapping(playedCard2Code, new Equal());
            simConfig.setWeight(playedCard2Code, 1.0);
        }

        if (query.getPlayedCard2Suit() != null) {
            Attribute playedCard2Suit = new Attribute("playedCard2Suit", query.getClass());
            simConfig.addMapping(playedCard2Suit, new Equal());
            simConfig.setWeight(playedCard2Suit, 1.0);
        }

        if (query.getPlayedCard3Code() != null) {
            Attribute playedCard3Code = new Attribute("playedCard3Code", query.getClass());
            simConfig.addMapping(playedCard3Code, new Equal());
            simConfig.setWeight(playedCard3Code, 1.0);
        }

        if (query.getPlayedCard3Suit() != null) {
            Attribute playedCard3Suit = new Attribute("playedCard3Suit", query.getClass());
            simConfig.addMapping(playedCard3Suit, new Equal());
            simConfig.setWeight(playedCard3Suit, 1.0);
        }

        if (query.getPlayedCard4Code() != null) {
            Attribute playedCard4Code = new Attribute("playedCard4Code", query.getClass());
            simConfig.addMapping(playedCard4Code, new Equal());
            simConfig.setWeight(playedCard4Code, 1.0);
        }

        if (query.getPlayedCard4Suit() != null) {
            Attribute playedCard4Suit = new Attribute("playedCard4Suit", query.getClass());
            simConfig.addMapping(playedCard4Suit, new Equal());
            simConfig.setWeight(playedCard4Suit, 1.0);
        }

        if (query.getPlayedCard5Code() != null) {
            Attribute playedCard5Code = new Attribute("playedCard5Code", query.getClass());
            simConfig.addMapping(playedCard5Code, new Equal());
            simConfig.setWeight(playedCard5Code, 1.0);
        }

        if (query.getPlayedCard5Suit() != null) {
            Attribute playedCard5Suit = new Attribute("playedCard5Suit", query.getClass());
            simConfig.addMapping(playedCard5Suit, new Equal());
            simConfig.setWeight(playedCard5Suit, 1.0);
        }

        if (query.getPlayedCard6Code() != null) {
            Attribute playedCard6Code = new Attribute("playedCard6Code", query.getClass());
            simConfig.addMapping(playedCard6Code, new Equal());
            simConfig.setWeight(playedCard6Code, 1.0);
        }

        if (query.getPlayedCard6Suit() != null) {
            Attribute playedCard6Suit = new Attribute("playedCard6Suit", query.getClass());
            simConfig.addMapping(playedCard6Suit, new Equal());
            simConfig.setWeight(playedCard6Suit, 1.0);
        }

        if (query.getWhoCard1() != null) {
            Attribute whoCard1 = new Attribute("whoCard1", query.getClass());
            simConfig.addMapping(whoCard1, new Equal());
            simConfig.setWeight(whoCard1, 1.0);
        }

        if (query.getWhoCard2() != null) {
            Attribute whoCard2 = new Attribute("whoCard1", query.getClass());
            simConfig.addMapping(whoCard2, new Equal());
            simConfig.setWeight(whoCard2, 1.0);
        }

        if (query.getWhoCard3() != null) {
            Attribute whoCard3 = new Attribute("whoCard1", query.getClass());
            simConfig.addMapping(whoCard3, new Equal());
            simConfig.setWeight(whoCard3, 1.0);
        }

        if (query.getWhoCard4() != null) {
            Attribute whoCard4 = new Attribute("whoCard1", query.getClass());
            simConfig.addMapping(whoCard4, new Equal());
            simConfig.setWeight(whoCard4, 1.0);
        }

        if (query.getWhoCard5() != null) {
            Attribute whoCard5 = new Attribute("whoCard1", query.getClass());
            simConfig.addMapping(whoCard5, new Equal());
            simConfig.setWeight(whoCard5, 1.0);
        }

        if (query.getWhoCard6() != null) {
            Attribute whoCard6 = new Attribute("whoCard6", query.getClass());
            simConfig.addMapping(whoCard6, new Equal());
            simConfig.setWeight(whoCard6, 1.0);
        }

        if (query.getTriedCardBluffs() != null) {
            Attribute triedCardBluffs = new Attribute("triedCardBluffs", query.getClass());
            simConfig.addMapping(triedCardBluffs, new Equal());
            simConfig.setWeight(triedCardBluffs, 1.0);
        }

        if (query.getCardBluffCanBeDetected() != null) {
            Attribute cardBluffCanBeDetected = new Attribute("cardBluffCanBeDetected", query.getClass());
            simConfig.addMapping(cardBluffCanBeDetected, new Equal());
            simConfig.setWeight(cardBluffCanBeDetected, 1.0);
        }

        if (query.getCardBluffSuccessful() != null) {
            Attribute cardBluffSuccessful = new Attribute("cardBluffSuccessful", query.getClass());
            simConfig.addMapping(cardBluffSuccessful, new Equal());
            simConfig.setWeight(cardBluffSuccessful, 1.0);
        }

        if (query.getJogada() != null) {
            Attribute jogada = new Attribute("jogada", query.getClass());
            simConfig.addMapping(jogada, new Equal());
            simConfig.setWeight(jogada, 1.0);
        }

        if (query.getIsBluff() != null) {
            Attribute isBluff = new Attribute("isBluff", query.getClass());
            simConfig.addMapping(isBluff, new Equal());
            simConfig.setWeight(isBluff, 1.0);
        }

        if (query.getTypeBluff() != null) {
            Attribute typeBluff = new Attribute("typeBluff", query.getClass());
            simConfig.addMapping(typeBluff, new Equal());
            simConfig.setWeight(typeBluff, 1.0);
        }

        if (query.getExpectedValue() != 0.0) {
            Attribute expectedValue = new Attribute("expectedValue", query.getClass());
            simConfig.addMapping(expectedValue, new Equal());
            simConfig.setWeight(expectedValue, 1.0);
        }

        if (query.getIsSucessful() != 0.0) {
            Attribute isSucessful = new Attribute("isSucessful", query.getClass());
            simConfig.addMapping(isSucessful, new Equal());
            simConfig.setWeight(isSucessful, 1.0);
        }

        if (query.getWonPoints() != 0.0) {
            Attribute wonPoints = new Attribute("wonPoints", query.getClass());
            simConfig.addMapping(wonPoints, new Equal());
            simConfig.setWeight(wonPoints, 1.0);
        }

        if (query.getBluffCanBeDetected() != 0.0) {
            Attribute bluffCanBeDetected = new Attribute("bluffCanBeDetected", query.getClass());
            simConfig.addMapping(bluffCanBeDetected, new Equal());
            simConfig.setWeight(bluffCanBeDetected, 1.0);
        }

        if (query.getIsStrongHand() != 0.0) {
            Attribute isStrongHand = new Attribute("isStrongHand", query.getClass());
            simConfig.addMapping(isStrongHand, new Equal());
            simConfig.setWeight(isStrongHand, 1.0);
        }

        if (query.getIsWeakHand() != 0.0) {
            Attribute isWeakHand = new Attribute("isWeakHand", query.getClass());
            simConfig.addMapping(isWeakHand, new Equal());
            simConfig.setWeight(isWeakHand, 1.0);
        }

        if (query.getIsFewPoints() != 0.0) {
            Attribute isFewPoints = new Attribute("isFewPoints", query.getClass());
            simConfig.addMapping(isFewPoints, new Equal());
            simConfig.setWeight(isFewPoints, 1.0);
        }

        if (query.getIsManyPoints() != 0.0) {
            Attribute isManyPoints = new Attribute("isManyPoints", query.getClass());
            simConfig.addMapping(isManyPoints, new Equal());
            simConfig.setWeight(isManyPoints, 1.0);
        }

        if (query.getIsManyPointsAgo() != 0.0) {
            Attribute isManyPointsAgo = new Attribute("isManyPointsAgo", query.getClass());
            simConfig.addMapping(isManyPointsAgo, new Equal());
            simConfig.setWeight(isManyPointsAgo, 1.0);
        }

        if (query.getIsManyPointsForeward() != 0.0) {
            Attribute isManyPointsForeward = new Attribute("isManyPointsForeward", query.getClass());
            simConfig.addMapping(isManyPointsForeward, new Equal());
            simConfig.setWeight(isManyPointsForeward, 1.0);
        }

        if (query.getIsTestOpponent() != 0.0) {
            Attribute isTestOpponent = new Attribute("isTestOpponent", query.getClass());
            simConfig.addMapping(isTestOpponent, new Equal());
            simConfig.setWeight(isTestOpponent, 1.0);
        }

        if (query.getIsOpponentTight() != 0.0) {
            Attribute isOpponentTight = new Attribute("isOpponentTight", query.getClass());
            simConfig.addMapping(isOpponentTight, new Equal());
            simConfig.setWeight(isOpponentTight, 1.0);
        }

        if (query.getIsOpponentLoose() != 0.0) {
            Attribute isOpponentLoose = new Attribute("isOpponentLoose", query.getClass());
            simConfig.addMapping(isOpponentLoose, new Equal());
            simConfig.setWeight(isOpponentLoose, 1.0);
        }

        if (query.getIsOpponentAgressive() != 0.0) {
            Attribute isOpponentAgressive = new Attribute("isOpponentAgressive", query.getClass());
            simConfig.addMapping(isOpponentAgressive, new Equal());
            simConfig.setWeight(isOpponentAgressive, 1.0);
        }

        if (query.getIsOpponentPassive() != 0.0) {
            Attribute isOpponentPassive = new Attribute("isOpponentPassive", query.getClass());
            simConfig.addMapping(isOpponentPassive, new Equal());
            simConfig.setWeight(isOpponentPassive, 1.0);
        }

        return simConfig;
    }

    public void learningCases(Collection<CBRCase> newCases, CBRCaseBase learningCaseBase);

    public void learningCriteriaEnvido(GenericEnvido newCase, CBRCaseBase learningCaseBase);

    public void learningCriteriaFlor(GenericFlor newCase, CBRCaseBase learningCaseBase);

    public void learningCriteriaTruco(GenericTruco newCase, CBRCaseBase learningCaseBase);

    public void learningCriteriaPlayCard(GenericPlayCard newCase, CBRCaseBase learningCaseBase);

}
