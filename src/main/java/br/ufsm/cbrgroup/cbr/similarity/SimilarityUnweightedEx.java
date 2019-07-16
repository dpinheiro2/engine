package br.ufsm.cbrgroup.cbr.similarity;

import br.ufsm.cbrgroup.description.*;
import es.ucm.fdi.gaia.jcolibri.cbrcore.Attribute;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRQuery;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 01/07/2019.
 */


public class SimilarityUnweightedEx implements SimilarityStrategyEx {


    @Override
    public NNConfig getSimConfigEnvido(CBRQuery gameStateQuery) {

        Envido query = (Envido) gameStateQuery.getDescription();

        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        Attribute isHand = new Attribute("isHand", gameStateQuery.getDescription().getClass());
        simConfig.addMapping(isHand, new Equal());
        simConfig.setWeight(isHand, 1.0);

        if (query.getHighCardCode() != null) {
            Attribute highCardCode = new Attribute("highCardCode", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(highCardCode, new Equal());
            simConfig.setWeight(highCardCode, 1.0);
        }

        if (query.getHighCardSuit() != null) {
            Attribute highCardSuit = new Attribute("highCardSuit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(highCardSuit, new Equal());
            simConfig.setWeight(highCardSuit, 1.0);
        }

        if (query.getMediumCardCode() != null) {
            Attribute mediumCardCode = new Attribute("mediumCardCode", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(mediumCardCode, new Equal());
            simConfig.setWeight(mediumCardCode, 1.0);
        }

        if (query.getMediumCardSuit() != null) {
            Attribute mediumCardSuit = new Attribute("mediumCardSuit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(mediumCardSuit, new Equal());
            simConfig.setWeight(mediumCardSuit, 1.0);
        }

        if (query.getLowCardCode() != null) {
            Attribute lowCardCode = new Attribute("lowCardCode", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(lowCardCode, new Equal());
            simConfig.setWeight(lowCardCode, 1.0);
        }

        if (query.getLowCardSuit() != null) {
            Attribute lowCardSuit = new Attribute("lowCardSuit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(lowCardSuit, new Equal());
            simConfig.setWeight(lowCardSuit, 1.0);
        }

        if (query.getEnvidoPoints() != null) {
            Attribute envidoPoints = new Attribute("envidoPoints", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(envidoPoints, new Equal());
            simConfig.setWeight(envidoPoints, 1.0);
        }

        if (query.getPoints() != null) {
            Attribute points = new Attribute("points", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(points, new Equal());
            simConfig.setWeight(points, 1.0);
        }

        if (query.getStateDecision() != null) {
            Attribute stateDecision = new Attribute("stateDecision", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(stateDecision, new Equal());
            simConfig.setWeight(stateDecision, 1.0);
        }

        if (query.getEnvidoChainSize() != null) {
            Attribute envidoChainSize = new Attribute("envidoChainSize", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(envidoChainSize, new Equal());
            simConfig.setWeight(envidoChainSize, 1.0);
        }

        if (query.getOpponentPoints() != null) {
            Attribute opponentPoints = new Attribute("opponentPoints", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(opponentPoints, new Equal());
            simConfig.setWeight(opponentPoints, 1.0);
        }

        if (query.getOpponentPlayedCardCode() != null) {
            Attribute opponentPlayedCardCode = new Attribute("opponentPlayedCardCode", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(opponentPlayedCardCode, new Equal());
            simConfig.setWeight(opponentPlayedCardCode, 1.0);
        }

        if (query.getOpponentPlayedCardSuit() != null) {
            Attribute opponentPlayedCardSuit = new Attribute("opponentPlayedCardSuit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(opponentPlayedCardSuit, new Equal());
            simConfig.setWeight(opponentPlayedCardSuit, 1.0);
        }


        Attribute isSucessful = new Attribute("isSucessful", gameStateQuery.getDescription().getClass());
        simConfig.addMapping(isSucessful, new Equal());
        simConfig.setWeight(isSucessful, 1.0);

        return simConfig;

    }

    @Override
    public NNConfig getSimConfigFlor(CBRQuery gameStateQuery) {

        Flor query = (Flor) gameStateQuery.getDescription();

        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        Attribute isHand = new Attribute("isHand", gameStateQuery.getDescription().getClass());
        simConfig.addMapping(isHand, new Equal());
        simConfig.setWeight(isHand, 1.0);

        if (query.getHighCardCode() != null) {
            Attribute highCardCode = new Attribute("highCardCode", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(highCardCode, new Equal());
            simConfig.setWeight(highCardCode, 1.0);
        }

        if (query.getHighCardSuit() != null) {
            Attribute highCardSuit = new Attribute("highCardSuit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(highCardSuit, new Equal());
            simConfig.setWeight(highCardSuit, 1.0);
        }

        if (query.getMediumCardCode() != null) {
            Attribute mediumCardCode = new Attribute("mediumCardCode", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(mediumCardCode, new Equal());
            simConfig.setWeight(mediumCardCode, 1.0);
        }

        if (query.getMediumCardSuit() != null) {
            Attribute mediumCardSuit = new Attribute("mediumCardSuit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(mediumCardSuit, new Equal());
            simConfig.setWeight(mediumCardSuit, 1.0);
        }

        if (query.getLowCardCode() != null) {
            Attribute lowCardCode = new Attribute("lowCardCode", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(lowCardCode, new Equal());
            simConfig.setWeight(lowCardCode, 1.0);
        }

        if (query.getLowCardSuit() != null) {
            Attribute lowCardSuit = new Attribute("lowCardSuit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(lowCardSuit, new Equal());
            simConfig.setWeight(lowCardSuit, 1.0);
        }

        if (query.getFlorPoints() != null) {
            Attribute florPoints = new Attribute("florPoints", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(florPoints, new Equal());
            simConfig.setWeight(florPoints, 1.0);
        }

        if (query.getPoints() != null) {
            Attribute points = new Attribute("points", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(points, new Equal());
            simConfig.setWeight(points, 1.0);
        }

        if (query.getStateDecision() != null) {
            Attribute stateDecision = new Attribute("stateDecision", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(stateDecision, new Equal());
            simConfig.setWeight(stateDecision, 1.0);
        }

        if (query.getFlorChainSize() != null) {
            Attribute florChainSize = new Attribute("florChainSize", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(florChainSize, new Equal());
            simConfig.setWeight(florChainSize, 1.0);
        }

        if (query.getOpponentPoints() != null) {
            Attribute opponentPoints = new Attribute("opponentPoints", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(opponentPoints, new Equal());
            simConfig.setWeight(opponentPoints, 1.0);
        }

        if (query.getOpponentPlayedCardCode() != null) {
            Attribute opponentPlayedCardCode = new Attribute("opponentPlayedCardCode", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(opponentPlayedCardCode, new Equal());
            simConfig.setWeight(opponentPlayedCardCode, 1.0);
        }

        if (query.getOpponentPlayedCardSuit() != null) {
            Attribute opponentPlayedCardSuit = new Attribute("opponentPlayedCardSuit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(opponentPlayedCardSuit, new Equal());
            simConfig.setWeight(opponentPlayedCardSuit, 1.0);
        }

        Attribute isSucessful = new Attribute("isSucessful", gameStateQuery.getDescription().getClass());
        simConfig.addMapping(isSucessful, new Equal());
        simConfig.setWeight(isSucessful, 1.0);

        return simConfig;

    }

    @Override
    public NNConfig getSimConfigTruco(CBRQuery gameStateQuery) {

        Truco query = (Truco) gameStateQuery.getDescription();

        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        Attribute isHand = new Attribute("isHand", gameStateQuery.getDescription().getClass());
        simConfig.addMapping(isHand, new Equal());
        simConfig.setWeight(isHand, 1.0);

        if (query.getHighCardCode() != null) {
            Attribute highCardCode = new Attribute("highCardCode", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(highCardCode, new Equal());
            simConfig.setWeight(highCardCode, 1.0);
        }

        if (query.getHighCardSuit() != null) {
            Attribute highCardSuit = new Attribute("highCardSuit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(highCardSuit, new Equal());
            simConfig.setWeight(highCardSuit, 1.0);
        }

        if (query.getMediumCardCode() != null) {
            Attribute mediumCardCode = new Attribute("mediumCardCode", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(mediumCardCode, new Equal());
            simConfig.setWeight(mediumCardCode, 1.0);
        }

        if (query.getMediumCardSuit() != null) {
            Attribute mediumCardSuit = new Attribute("mediumCardSuit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(mediumCardSuit, new Equal());
            simConfig.setWeight(mediumCardSuit, 1.0);
        }

        if (query.getLowCardCode() != null) {
            Attribute lowCardCode = new Attribute("lowCardCode", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(lowCardCode, new Equal());
            simConfig.setWeight(lowCardCode, 1.0);
        }

        if (query.getLowCardSuit() != null) {
            Attribute lowCardSuit = new Attribute("lowCardSuit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(lowCardSuit, new Equal());
            simConfig.setWeight(lowCardSuit, 1.0);
        }


        if (query.getPoints() != null) {
            Attribute points = new Attribute("points", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(points, new Equal());
            simConfig.setWeight(points, 1.0);
        }

        if (query.getOpponentPoints() != null) {
            Attribute opponentPoints = new Attribute("opponentPoints", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(opponentPoints, new Equal());
            simConfig.setWeight(opponentPoints, 1.0);
        }

        if (query.getStateDecisionTurn() != null) {
            Attribute stateDecisionTurn = new Attribute("stateDecisionTurn", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(stateDecisionTurn, new Equal());
            simConfig.setWeight(stateDecisionTurn, 1.0);
        }

        if (query.getStateDecisionToken() != null) {
            Attribute stateTruco = new Attribute("stateDecisionToken", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(stateTruco, new Equal());
            simConfig.setWeight(stateTruco, 1.0);
        }

        if (query.getEnvidoPointsWon() != null) {
            Attribute envidoPointsWon = new Attribute("envidoPointsWon", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(envidoPointsWon, new Equal());
            simConfig.setWeight(envidoPointsWon, 1.0);
        }

        if (query.getFlorPointsWon() != null) {
            Attribute florPointsWon = new Attribute("florPointsWon", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(florPointsWon, new Equal());
            simConfig.setWeight(florPointsWon, 1.0);
        }

        if (query.getTrucoChainSize() != null) {
            Attribute trucoChainSize = new Attribute("trucoChainSize", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(trucoChainSize, new Equal());
            simConfig.setWeight(trucoChainSize, 1.0);
        }

        if (query.getWinnerRound1() != null) {
            Attribute winnerRound1 = new Attribute("winnerRound1", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(winnerRound1, new Equal());
            simConfig.setWeight(winnerRound1, 1.0);
        }

        if (query.getWinnerRound2() != null) {
            Attribute winnerRound2 = new Attribute("winnerRound2", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(winnerRound2, new Equal());
            simConfig.setWeight(winnerRound2, 1.0);
        }

        if (query.getPlayedCard1Code() != null) {
            Attribute playedCard1Code = new Attribute("playedCard1Code", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard1Code, new Equal());
            simConfig.setWeight(playedCard1Code, 1.0);
        }

        if (query.getPlayedCard1Suit() != null) {
            Attribute playedCard1Suit = new Attribute("playedCard1Suit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard1Suit, new Equal());
            simConfig.setWeight(playedCard1Suit, 1.0);
        }

        if (query.getPlayedCard2Code() != null) {
            Attribute playedCard2Code = new Attribute("playedCard2Code", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard2Code, new Equal());
            simConfig.setWeight(playedCard2Code, 1.0);
        }

        if (query.getPlayedCard2Suit() != null) {
            Attribute playedCard2Suit = new Attribute("playedCard2Suit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard2Suit, new Equal());
            simConfig.setWeight(playedCard2Suit, 1.0);
        }

        if (query.getPlayedCard3Code() != null) {
            Attribute playedCard3Code = new Attribute("playedCard3Code", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard3Code, new Equal());
            simConfig.setWeight(playedCard3Code, 1.0);
        }

        if (query.getPlayedCard3Suit() != null) {
            Attribute playedCard3Suit = new Attribute("playedCard3Suit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard3Suit, new Equal());
            simConfig.setWeight(playedCard3Suit, 1.0);
        }

        if (query.getPlayedCard4Code() != null) {
            Attribute playedCard4Code = new Attribute("playedCard4Code", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard4Code, new Equal());
            simConfig.setWeight(playedCard4Code, 1.0);
        }

        if (query.getPlayedCard4Suit() != null) {
            Attribute playedCard4Suit = new Attribute("playedCard4Suit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard4Suit, new Equal());
            simConfig.setWeight(playedCard4Suit, 1.0);
        }

        if (query.getPlayedCard5Code() != null) {
            Attribute playedCard5Code = new Attribute("playedCard5Code", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard5Code, new Equal());
            simConfig.setWeight(playedCard5Code, 1.0);
        }

        if (query.getPlayedCard5Suit() != null) {
            Attribute playedCard5Suit = new Attribute("playedCard5Suit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard5Suit, new Equal());
            simConfig.setWeight(playedCard5Suit, 1.0);
        }

        if (query.getPlayedCard6Code() != null) {
            Attribute playedCard6Code = new Attribute("playedCard6Code", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard6Code, new Equal());
            simConfig.setWeight(playedCard6Code, 1.0);
        }

        if (query.getPlayedCard6Suit() != null) {
            Attribute playedCard6Suit = new Attribute("playedCard6Suit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard6Suit, new Equal());
            simConfig.setWeight(playedCard6Suit, 1.0);
        }

        if (query.getWhoCard1() != null) {
            Attribute whoCard1 = new Attribute("whoCard1", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(whoCard1, new Equal());
            simConfig.setWeight(whoCard1, 1.0);
        }

        if (query.getWhoCard2() != null) {
            Attribute whoCard2 = new Attribute("whoCard1", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(whoCard2, new Equal());
            simConfig.setWeight(whoCard2, 1.0);
        }

        if (query.getWhoCard3() != null) {
            Attribute whoCard3 = new Attribute("whoCard1", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(whoCard3, new Equal());
            simConfig.setWeight(whoCard3, 1.0);
        }

        if (query.getWhoCard4() != null) {
            Attribute whoCard4 = new Attribute("whoCard1", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(whoCard4, new Equal());
            simConfig.setWeight(whoCard4, 1.0);
        }

        if (query.getWhoCard5() != null) {
            Attribute whoCard5 = new Attribute("whoCard1", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(whoCard5, new Equal());
            simConfig.setWeight(whoCard5, 1.0);
        }

        if (query.getWhoCard6() != null) {
            Attribute whoCard6 = new Attribute("whoCard6", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(whoCard6, new Equal());
            simConfig.setWeight(whoCard6, 1.0);
        }

        Attribute isSucessful = new Attribute("isSucessful", gameStateQuery.getDescription().getClass());
        simConfig.addMapping(isSucessful, new Equal());
        simConfig.setWeight(isSucessful, 1.0);


        return simConfig;
    }

    @Override
    public NNConfig getSimConfigPlayCard(CBRQuery gameStateQuery) {

        PlayCard query = (PlayCard) gameStateQuery.getDescription();

        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        Attribute isHand = new Attribute("isHand", gameStateQuery.getDescription().getClass());
        simConfig.addMapping(isHand, new Equal());
        simConfig.setWeight(isHand, 1.0);

        if (query.getHighCardCode() != null) {
            Attribute highCardCode = new Attribute("highCardCode", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(highCardCode, new Equal());
            simConfig.setWeight(highCardCode, 1.0);
        }

        if (query.getHighCardSuit() != null) {
            Attribute highCardSuit = new Attribute("highCardSuit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(highCardSuit, new Equal());
            simConfig.setWeight(highCardSuit, 1.0);
        }

        if (query.getMediumCardCode() != null) {
            Attribute mediumCardCode = new Attribute("mediumCardCode", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(mediumCardCode, new Equal());
            simConfig.setWeight(mediumCardCode, 1.0);
        }

        if (query.getMediumCardSuit() != null) {
            Attribute mediumCardSuit = new Attribute("mediumCardSuit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(mediumCardSuit, new Equal());
            simConfig.setWeight(mediumCardSuit, 1.0);
        }

        if (query.getLowCardCode() != null) {
            Attribute lowCardCode = new Attribute("lowCardCode", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(lowCardCode, new Equal());
            simConfig.setWeight(lowCardCode, 1.0);
        }

        if (query.getLowCardSuit() != null) {
            Attribute lowCardSuit = new Attribute("lowCardSuit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(lowCardSuit, new Equal());
            simConfig.setWeight(lowCardSuit, 1.0);
        }


        if (query.getPoints() != null) {
            Attribute points = new Attribute("points", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(points, new Equal());
            simConfig.setWeight(points, 1.0);
        }

        if (query.getOpponentPoints() != null) {
            Attribute opponentPoints = new Attribute("opponentPoints", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(opponentPoints, new Equal());
            simConfig.setWeight(opponentPoints, 1.0);
        }

        if (query.getStateDecisionTurn() != null) {
            Attribute stateDecisionTurn = new Attribute("stateDecisionTurn", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(stateDecisionTurn, new Equal());
            simConfig.setWeight(stateDecisionTurn, 1.0);
        }

        if (query.getStateDecisionToken() != null) {
            Attribute stateTruco = new Attribute("stateDecisionToken", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(stateTruco, new Equal());
            simConfig.setWeight(stateTruco, 1.0);
        }

        if (query.getEnvidoPointsWon() != null) {
            Attribute envidoPointsWon = new Attribute("envidoPointsWon", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(envidoPointsWon, new Equal());
            simConfig.setWeight(envidoPointsWon, 1.0);
        }

        if (query.getFlorPointsWon() != null) {
            Attribute florPointsWon = new Attribute("florPointsWon", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(florPointsWon, new Equal());
            simConfig.setWeight(florPointsWon, 1.0);
        }

        if (query.getEnvidoChainSize() != null) {
            Attribute envidoChainSize = new Attribute("envidoChainSize", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(envidoChainSize, new Equal());
            simConfig.setWeight(envidoChainSize, 1.0);
        }

        if (query.getFlorChainSize() != null) {
            Attribute florChainSize = new Attribute("florChainSize", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(florChainSize, new Equal());
            simConfig.setWeight(florChainSize, 1.0);
        }

        if (query.getTrucoChainSize() != null) {
            Attribute trucoChainSize = new Attribute("trucoChainSize", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(trucoChainSize, new Equal());
            simConfig.setWeight(trucoChainSize, 1.0);
        }

        if (query.getWinnerRound1() != null) {
            Attribute winnerRound1 = new Attribute("winnerRound1", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(winnerRound1, new Equal());
            simConfig.setWeight(winnerRound1, 1.0);
        }

        if (query.getWinnerRound2() != null) {
            Attribute winnerRound2 = new Attribute("winnerRound2", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(winnerRound2, new Equal());
            simConfig.setWeight(winnerRound2, 1.0);
        }

        if (query.getPlayedCard1Code() != null) {
            Attribute playedCard1Code = new Attribute("playedCard1Code", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard1Code, new Equal());
            simConfig.setWeight(playedCard1Code, 1.0);
        }

        if (query.getPlayedCard1Suit() != null) {
            Attribute playedCard1Suit = new Attribute("playedCard1Suit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard1Suit, new Equal());
            simConfig.setWeight(playedCard1Suit, 1.0);
        }

        if (query.getPlayedCard2Code() != null) {
            Attribute playedCard2Code = new Attribute("playedCard2Code", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard2Code, new Equal());
            simConfig.setWeight(playedCard2Code, 1.0);
        }

        if (query.getPlayedCard2Suit() != null) {
            Attribute playedCard2Suit = new Attribute("playedCard2Suit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard2Suit, new Equal());
            simConfig.setWeight(playedCard2Suit, 1.0);
        }

        if (query.getPlayedCard3Code() != null) {
            Attribute playedCard3Code = new Attribute("playedCard3Code", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard3Code, new Equal());
            simConfig.setWeight(playedCard3Code, 1.0);
        }

        if (query.getPlayedCard3Suit() != null) {
            Attribute playedCard3Suit = new Attribute("playedCard3Suit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard3Suit, new Equal());
            simConfig.setWeight(playedCard3Suit, 1.0);
        }

        if (query.getPlayedCard4Code() != null) {
            Attribute playedCard4Code = new Attribute("playedCard4Code", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard4Code, new Equal());
            simConfig.setWeight(playedCard4Code, 1.0);
        }

        if (query.getPlayedCard4Suit() != null) {
            Attribute playedCard4Suit = new Attribute("playedCard4Suit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard4Suit, new Equal());
            simConfig.setWeight(playedCard4Suit, 1.0);
        }

        if (query.getPlayedCard5Code() != null) {
            Attribute playedCard5Code = new Attribute("playedCard5Code", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard5Code, new Equal());
            simConfig.setWeight(playedCard5Code, 1.0);
        }

        if (query.getPlayedCard5Suit() != null) {
            Attribute playedCard5Suit = new Attribute("playedCard5Suit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard5Suit, new Equal());
            simConfig.setWeight(playedCard5Suit, 1.0);
        }

        if (query.getPlayedCard6Code() != null) {
            Attribute playedCard6Code = new Attribute("playedCard6Code", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard6Code, new Equal());
            simConfig.setWeight(playedCard6Code, 1.0);
        }

        if (query.getPlayedCard6Suit() != null) {
            Attribute playedCard6Suit = new Attribute("playedCard6Suit", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(playedCard6Suit, new Equal());
            simConfig.setWeight(playedCard6Suit, 1.0);
        }

        if (query.getWhoCard1() != null) {
            Attribute whoCard1 = new Attribute("whoCard1", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(whoCard1, new Equal());
            simConfig.setWeight(whoCard1, 1.0);
        }

        if (query.getWhoCard2() != null) {
            Attribute whoCard2 = new Attribute("whoCard1", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(whoCard2, new Equal());
            simConfig.setWeight(whoCard2, 1.0);
        }

        if (query.getWhoCard3() != null) {
            Attribute whoCard3 = new Attribute("whoCard1", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(whoCard3, new Equal());
            simConfig.setWeight(whoCard3, 1.0);
        }

        if (query.getWhoCard4() != null) {
            Attribute whoCard4 = new Attribute("whoCard1", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(whoCard4, new Equal());
            simConfig.setWeight(whoCard4, 1.0);
        }

        if (query.getWhoCard5() != null) {
            Attribute whoCard5 = new Attribute("whoCard1", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(whoCard5, new Equal());
            simConfig.setWeight(whoCard5, 1.0);
        }

        if (query.getWhoCard6() != null) {
            Attribute whoCard6 = new Attribute("whoCard6", gameStateQuery.getDescription().getClass());
            simConfig.addMapping(whoCard6, new Equal());
            simConfig.setWeight(whoCard6, 1.0);
        }

        Attribute isSucessful = new Attribute("isSucessful", gameStateQuery.getDescription().getClass());
        simConfig.addMapping(isSucessful, new Equal());
        simConfig.setWeight(isSucessful, 1.0);

        return simConfig;
    }
}
