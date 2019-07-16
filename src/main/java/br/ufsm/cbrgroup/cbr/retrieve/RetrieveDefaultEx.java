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


public class RetrieveDefaultEx implements RetrieveStrategyEx {

    @Override
    public CBRQuery getQueryEnvido(GameState gameState, GenericEnvido desc) {

        CBRQuery cbrQuery = new CBRQuery();

        desc.setIsHand(gameState.isHand() ? 1 : 0);

        desc.setHighCardCode(gameState.getAgentCards().get(2).getCbrCode());
        desc.setHighCardSuit(gameState.getAgentCards().get(2).getSuit().name());

        desc.setMediumCardCode(gameState.getAgentCards().get(1).getCbrCode());
        desc.setMediumCardSuit(gameState.getAgentCards().get(1).getSuit().name());

        desc.setLowCardCode(gameState.getAgentCards().get(0).getCbrCode());
        desc.setLowCardSuit(gameState.getAgentCards().get(0).getSuit().name());

        desc.setEnvidoPoints(gameState.getEnvidoPoints());
        desc.setPoints(gameState.getAgentPoints());
        desc.setOpponentPoints(gameState.getOpponentPoints());
        if (gameState.getStateDecisionToken() != null) {
            desc.setStateDecision(gameState.getStateDecisionToken().name());
        }

        desc.setEnvidoChainSize(gameState.getEnvidoHistory().size());

        if (gameState.getOpponentPlayedCards().size() > 0) {
            desc.setOpponentPlayedCardCode(gameState.getOpponentPlayedCards().get(0).getCbrCode());
            desc.setOpponentPlayedCardSuit(gameState.getOpponentPlayedCards().get(0).getSuit().name());
        }

        desc.setIsSucessful(1);

        cbrQuery.setDescription(desc);

        return cbrQuery;
    }

    @Override
    public CBRQuery getQueryFlor(GameState gameState, GenericFlor desc) {

        CBRQuery query = new CBRQuery();

        desc.setIsHand(gameState.isHand() ? 1 : 0);

        desc.setHighCardCode(gameState.getAgentCards().get(2).getCbrCode());
        desc.setHighCardSuit(gameState.getAgentCards().get(2).getSuit().name());

        desc.setMediumCardCode(gameState.getAgentCards().get(1).getCbrCode());
        desc.setMediumCardSuit(gameState.getAgentCards().get(1).getSuit().name());

        desc.setLowCardCode(gameState.getAgentCards().get(0).getCbrCode());
        desc.setLowCardSuit(gameState.getAgentCards().get(0).getSuit().name());

        desc.setFlorPoints(gameState.getEnvidoPoints());
        desc.setPoints(gameState.getAgentPoints());
        desc.setOpponentPoints(gameState.getOpponentPoints());
        if (gameState.getStateDecisionToken() != null) {
            desc.setStateDecision(gameState.getStateDecisionToken().name());
        }

        desc.setFlorChainSize(gameState.getFlorHistory().size());

        if (gameState.getOpponentPlayedCards().size() > 0) {
            desc.setOpponentPlayedCardCode(gameState.getOpponentPlayedCards().get(0).getCbrCode());
            desc.setOpponentPlayedCardSuit(gameState.getOpponentPlayedCards().get(0).getSuit().name());
        }

        desc.setIsSucessful(1);

        query.setDescription(desc);

        return query;
    }

    @Override
    public CBRQuery getQueryTruco(GameState gameState, GenericTruco desc) {

        CBRQuery query = new CBRQuery();

        desc.setIsHand(gameState.isHand() ? 1 : 0);

        desc.setHighCardCode(gameState.getAgentCards().get(2).getCbrCode());
        desc.setHighCardSuit(gameState.getAgentCards().get(2).getSuit().name());

        desc.setMediumCardCode(gameState.getAgentCards().get(1).getCbrCode());
        desc.setMediumCardSuit(gameState.getAgentCards().get(1).getSuit().name());

        desc.setLowCardCode(gameState.getAgentCards().get(0).getCbrCode());
        desc.setLowCardSuit(gameState.getAgentCards().get(0).getSuit().name());

        desc.setPoints(gameState.getAgentPoints());
        desc.setOpponentPoints(gameState.getOpponentPoints());

        if (gameState.getStateDecisionTurn() != null) {
            desc.setStateDecisionTurn(gameState.getStateDecisionTurn().name());
        }

        if (gameState.getStateDecisionToken() != null) {
            desc.setStateDecisionToken(gameState.getStateDecisionToken().name());
        }

        desc.setTrucoChainSize(gameState.getTrucoHistory().size());

        if (gameState.getTentosEnvido() != null) {
            desc.setEnvidoPointsWon(gameState.getTentosEnvido());
        }

        if (gameState.getTentosFlor() != null) {
            desc.setFlorPointsWon(gameState.getTentosFlor());
        }

        if (gameState.isWinnerRound1() || gameState.isEmpateRound1()) {
            if (gameState.isEmpateRound1()) {
                desc.setWinnerRound1(0);
            } else if (gameState.isWinnerRound1()) {
                desc.setWinnerRound1(1);
            } else {
                desc.setWinnerRound1(2);
            }
        }

        if (gameState.isWinnerRound2() || gameState.isEmpateRound2()) {
            if (gameState.isEmpateRound2()) {
                desc.setWinnerRound2(0);
            } else if (gameState.isWinnerRound2()) {
                desc.setWinnerRound2(1);
            } else {
                desc.setWinnerRound2(2);
            }
        }

        if (gameState.getCarta1() != null) {
            desc.setPlayedCard1Code(gameState.getCarta1().getCbrCode());
            desc.setPlayedCard1Suit(gameState.getCarta1().getSuit());
        }

        if (gameState.getCarta2() != null) {
            desc.setPlayedCard2Code(gameState.getCarta2().getCbrCode());
            desc.setPlayedCard2Suit(gameState.getCarta2().getSuit());
        }

        if (gameState.getCarta3() != null) {
            desc.setPlayedCard3Code(gameState.getCarta3().getCbrCode());
            desc.setPlayedCard3Suit(gameState.getCarta3().getSuit());
        }

        if (gameState.getCarta4() != null) {
            desc.setPlayedCard4Code(gameState.getCarta4().getCbrCode());
            desc.setPlayedCard4Suit(gameState.getCarta4().getSuit());
        }

        if (gameState.getCarta5() != null) {
            desc.setPlayedCard5Code(gameState.getCarta5().getCbrCode());
            desc.setPlayedCard5Suit(gameState.getCarta5().getSuit());
        }

        if (gameState.getCarta6() != null) {
            desc.setPlayedCard6Code(gameState.getCarta6().getCbrCode());
            desc.setPlayedCard6Suit(gameState.getCarta6().getSuit());
        }

        if (gameState.getWhoCarta1() != null) {
            desc.setWhoCard1(gameState.getWhoCarta1());
        }

        if (gameState.getWhoCarta2() != null) {
            desc.setWhoCard2(gameState.getWhoCarta2());
        }

        if (gameState.getWhoCarta3() != null) {
            desc.setWhoCard3(gameState.getWhoCarta3());
        }

        if (gameState.getWhoCarta4() != null) {
            desc.setWhoCard4(gameState.getWhoCarta4());
        }

        if (gameState.getWhoCarta5() != null) {
            desc.setWhoCard5(gameState.getWhoCarta5());
        }

        if (gameState.getWhoCarta6() != null) {
            desc.setWhoCard6(gameState.getWhoCarta6());
        }

        desc.setIsSucessful(1);

        query.setDescription(desc);

        return query;
    }

    @Override
    public CBRQuery getQueryPlayCard(GameState gameState, GenericPlayCard desc) {

        CBRQuery query = new CBRQuery();

        desc.setIsHand(gameState.isHand() ? 1 : 0);

        desc.setHighCardCode(gameState.getAgentCards().get(2).getCbrCode());
        desc.setHighCardSuit(gameState.getAgentCards().get(2).getSuit().name());

        desc.setMediumCardCode(gameState.getAgentCards().get(1).getCbrCode());
        desc.setMediumCardSuit(gameState.getAgentCards().get(1).getSuit().name());

        desc.setLowCardCode(gameState.getAgentCards().get(0).getCbrCode());
        desc.setLowCardSuit(gameState.getAgentCards().get(0).getSuit().name());

        desc.setPoints(gameState.getAgentPoints());
        desc.setOpponentPoints(gameState.getOpponentPoints());

        if (gameState.getStateDecisionTurn() != null) {
            desc.setStateDecisionTurn(gameState.getStateDecisionTurn().name());
        }

        if (gameState.getStateDecisionToken() != null) {
            desc.setStateDecisionToken(gameState.getStateDecisionToken().name());
        }

        desc.setEnvidoChainSize(gameState.getEnvidoHistory().size());
        desc.setFlorChainSize(gameState.getFlorHistory().size());
        desc.setTrucoChainSize(gameState.getTrucoHistory().size());

        if (gameState.getTentosEnvido() != null) {
            desc.setEnvidoPointsWon(gameState.getTentosEnvido());
        }

        if (gameState.getTentosFlor() != null) {
            desc.setFlorPointsWon(gameState.getTentosFlor());
        }

        if (gameState.isWinnerRound1() || gameState.isEmpateRound1()) {
            if (gameState.isEmpateRound1()) {
                desc.setWinnerRound1(0);
            } else if (gameState.isWinnerRound1()) {
                desc.setWinnerRound1(1);
            } else {
                desc.setWinnerRound1(2);
            }
        }

        if (gameState.isWinnerRound2() || gameState.isEmpateRound2()) {
            if (gameState.isEmpateRound2()) {
                desc.setWinnerRound2(0);
            } else if (gameState.isWinnerRound2()) {
                desc.setWinnerRound2(1);
            } else {
                desc.setWinnerRound2(2);
            }
        }

        if (gameState.getCarta1() != null) {
            desc.setPlayedCard1Code(gameState.getCarta1().getCbrCode());
            desc.setPlayedCard1Suit(gameState.getCarta1().getSuit());
        }

        if (gameState.getCarta2() != null) {
            desc.setPlayedCard2Code(gameState.getCarta2().getCbrCode());
            desc.setPlayedCard2Suit(gameState.getCarta2().getSuit());
        }

        if (gameState.getCarta3() != null) {
            desc.setPlayedCard3Code(gameState.getCarta3().getCbrCode());
            desc.setPlayedCard3Suit(gameState.getCarta3().getSuit());
        }

        if (gameState.getCarta4() != null) {
            desc.setPlayedCard4Code(gameState.getCarta4().getCbrCode());
            desc.setPlayedCard4Suit(gameState.getCarta4().getSuit());
        }

        if (gameState.getCarta5() != null) {
            desc.setPlayedCard5Code(gameState.getCarta5().getCbrCode());
            desc.setPlayedCard5Suit(gameState.getCarta5().getSuit());
        }

        if (gameState.getCarta6() != null) {
            desc.setPlayedCard6Code(gameState.getCarta6().getCbrCode());
            desc.setPlayedCard6Suit(gameState.getCarta6().getSuit());
        }

        if (gameState.getWhoCarta1() != null) {
            desc.setWhoCard1(gameState.getWhoCarta1());
        }

        if (gameState.getWhoCarta2() != null) {
            desc.setWhoCard2(gameState.getWhoCarta2());
        }

        if (gameState.getWhoCarta3() != null) {
            desc.setWhoCard3(gameState.getWhoCarta3());
        }

        if (gameState.getWhoCarta4() != null) {
            desc.setWhoCard4(gameState.getWhoCarta4());
        }

        if (gameState.getWhoCarta5() != null) {
            desc.setWhoCard5(gameState.getWhoCarta5());
        }

        if (gameState.getWhoCarta6() != null) {
            desc.setWhoCard6(gameState.getWhoCarta6());
        }

        desc.setIsSucessful(1);

        query.setDescription(desc);

        return query;
    }
}
