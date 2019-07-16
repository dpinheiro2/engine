package br.ufsm.cbrgroup.description;

import es.ucm.fdi.gaia.jcolibri.cbrcore.Attribute;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CaseComponent;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 05/07/2019.
 */


public abstract class GenericPlayCard implements CaseComponent {


    private Integer caseId;
    private Integer isHand;
    private Integer highCardCode;
    private String highCardSuit;
    private Integer mediumCardCode;
    private String mediumCardSuit;
    private Integer lowCardCode;
    private String lowCardSuit;
    private Integer points;
    private Integer opponentPoints;
    private String stateDecisionTurn;
    private String stateDecisionToken;
    private Integer envidoChainSize;
    private Integer florChainSize;
    private Integer trucoChainSize;
    private Integer playedCard1Code;
    private String playedCard1Suit;
    private Integer whoCard1;
    private Integer playedCard2Code;
    private String playedCard2Suit;
    private Integer whoCard2;
    private Integer playedCard3Code;
    private String playedCard3Suit;
    private Integer whoCard3;
    private Integer playedCard4Code;
    private String playedCard4Suit;
    private Integer whoCard4;
    private Integer playedCard5Code;
    private String playedCard5Suit;
    private Integer whoCard5;
    private Integer playedCard6Code;
    private String playedCard6Suit;
    private Integer whoCard6;
    private Integer winnerRound1;
    private Integer winnerRound2;
    private Integer envidoPointsWon;
    private Integer florPointsWon;
    private Integer triedCardBluffs;
    private Integer cardBluffCanBeDetected;
    private Integer cardBluffSuccessful;
    private String jogada;
    private Integer isBluff;
    private String typeBluff;
    private double expectedValue;
    private Integer isSucessful;
    private Integer wonPoints;
    private Integer bluffCanBeDetected;
    private Integer isStrongHand;
    private Integer isWeakHand;
    private Integer isFewPoints;
    private Integer isManyPoints;
    private Integer isManyPointsAgo;
    private Integer isManyPointsForeward;
    private Integer isTestOpponent;
    private Integer isOpponentTight;
    private Integer isOpponentLoose;
    private Integer isOpponentAgressive;
    private Integer isOpponentPassive;

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getIsHand() {
        return isHand;
    }

    public void setIsHand(Integer isHand) {
        this.isHand = isHand;
    }

    public Integer getHighCardCode() {
        return highCardCode;
    }

    public void setHighCardCode(Integer highCardCode) {
        this.highCardCode = highCardCode;
    }

    public String getHighCardSuit() {
        return highCardSuit;
    }

    public void setHighCardSuit(String highCardSuit) {
        this.highCardSuit = highCardSuit;
    }

    public Integer getMediumCardCode() {
        return mediumCardCode;
    }

    public void setMediumCardCode(Integer mediumCardCode) {
        this.mediumCardCode = mediumCardCode;
    }

    public String getMediumCardSuit() {
        return mediumCardSuit;
    }

    public void setMediumCardSuit(String mediumCardSuit) {
        this.mediumCardSuit = mediumCardSuit;
    }

    public Integer getLowCardCode() {
        return lowCardCode;
    }

    public void setLowCardCode(Integer lowCardCode) {
        this.lowCardCode = lowCardCode;
    }

    public String getLowCardSuit() {
        return lowCardSuit;
    }

    public void setLowCardSuit(String lowCardSuit) {
        this.lowCardSuit = lowCardSuit;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getOpponentPoints() {
        return opponentPoints;
    }

    public void setOpponentPoints(Integer opponentPoints) {
        this.opponentPoints = opponentPoints;
    }

    public String getStateDecisionTurn() {
        return stateDecisionTurn;
    }

    public void setStateDecisionTurn(String stateDecisionTurn) {
        this.stateDecisionTurn = stateDecisionTurn;
    }

    public String getStateDecisionToken() {
        return stateDecisionToken;
    }

    public void setStateDecisionToken(String stateDecisionToken) {
        this.stateDecisionToken = stateDecisionToken;
    }

    public Integer getEnvidoChainSize() {
        return envidoChainSize;
    }

    public void setEnvidoChainSize(Integer envidoChainSize) {
        this.envidoChainSize = envidoChainSize;
    }

    public Integer getFlorChainSize() {
        return florChainSize;
    }

    public void setFlorChainSize(Integer florChainSize) {
        this.florChainSize = florChainSize;
    }

    public Integer getTrucoChainSize() {
        return trucoChainSize;
    }

    public void setTrucoChainSize(Integer trucoChainSize) {
        this.trucoChainSize = trucoChainSize;
    }

    public Integer getPlayedCard1Code() {
        return playedCard1Code;
    }

    public void setPlayedCard1Code(Integer playedCard1Code) {
        this.playedCard1Code = playedCard1Code;
    }

    public String getPlayedCard1Suit() {
        return playedCard1Suit;
    }

    public void setPlayedCard1Suit(String playedCard1Suit) {
        this.playedCard1Suit = playedCard1Suit;
    }

    public Integer getWhoCard1() {
        return whoCard1;
    }

    public void setWhoCard1(Integer whoCard1) {
        this.whoCard1 = whoCard1;
    }

    public Integer getPlayedCard2Code() {
        return playedCard2Code;
    }

    public void setPlayedCard2Code(Integer playedCard2Code) {
        this.playedCard2Code = playedCard2Code;
    }

    public String getPlayedCard2Suit() {
        return playedCard2Suit;
    }

    public void setPlayedCard2Suit(String playedCard2Suit) {
        this.playedCard2Suit = playedCard2Suit;
    }

    public Integer getWhoCard2() {
        return whoCard2;
    }

    public void setWhoCard2(Integer whoCard2) {
        this.whoCard2 = whoCard2;
    }

    public Integer getPlayedCard3Code() {
        return playedCard3Code;
    }

    public void setPlayedCard3Code(Integer playedCard3Code) {
        this.playedCard3Code = playedCard3Code;
    }

    public String getPlayedCard3Suit() {
        return playedCard3Suit;
    }

    public void setPlayedCard3Suit(String playedCard3Suit) {
        this.playedCard3Suit = playedCard3Suit;
    }

    public Integer getWhoCard3() {
        return whoCard3;
    }

    public void setWhoCard3(Integer whoCard3) {
        this.whoCard3 = whoCard3;
    }

    public Integer getPlayedCard4Code() {
        return playedCard4Code;
    }

    public void setPlayedCard4Code(Integer playedCard4Code) {
        this.playedCard4Code = playedCard4Code;
    }

    public String getPlayedCard4Suit() {
        return playedCard4Suit;
    }

    public void setPlayedCard4Suit(String playedCard4Suit) {
        this.playedCard4Suit = playedCard4Suit;
    }

    public Integer getWhoCard4() {
        return whoCard4;
    }

    public void setWhoCard4(Integer whoCard4) {
        this.whoCard4 = whoCard4;
    }

    public Integer getPlayedCard5Code() {
        return playedCard5Code;
    }

    public void setPlayedCard5Code(Integer playedCard5Code) {
        this.playedCard5Code = playedCard5Code;
    }

    public String getPlayedCard5Suit() {
        return playedCard5Suit;
    }

    public void setPlayedCard5Suit(String playedCard5Suit) {
        this.playedCard5Suit = playedCard5Suit;
    }

    public Integer getWhoCard5() {
        return whoCard5;
    }

    public void setWhoCard5(Integer whoCard5) {
        this.whoCard5 = whoCard5;
    }

    public Integer getPlayedCard6Code() {
        return playedCard6Code;
    }

    public void setPlayedCard6Code(Integer playedCard6Code) {
        this.playedCard6Code = playedCard6Code;
    }

    public String getPlayedCard6Suit() {
        return playedCard6Suit;
    }

    public void setPlayedCard6Suit(String playedCard6Suit) {
        this.playedCard6Suit = playedCard6Suit;
    }

    public Integer getWhoCard6() {
        return whoCard6;
    }

    public void setWhoCard6(Integer whoCard6) {
        this.whoCard6 = whoCard6;
    }

    public Integer getWinnerRound1() {
        return winnerRound1;
    }

    public void setWinnerRound1(Integer winnerRound1) {
        this.winnerRound1 = winnerRound1;
    }

    public Integer getWinnerRound2() {
        return winnerRound2;
    }

    public void setWinnerRound2(Integer winnerRound2) {
        this.winnerRound2 = winnerRound2;
    }

    public Integer getEnvidoPointsWon() {
        return envidoPointsWon;
    }

    public void setEnvidoPointsWon(Integer envidoPointsWon) {
        this.envidoPointsWon = envidoPointsWon;
    }

    public Integer getFlorPointsWon() {
        return florPointsWon;
    }

    public void setFlorPointsWon(Integer florPointsWon) {
        this.florPointsWon = florPointsWon;
    }

    public Integer getTriedCardBluffs() {
        return triedCardBluffs;
    }

    public void setTriedCardBluffs(Integer triedCardBluffs) {
        this.triedCardBluffs = triedCardBluffs;
    }

    public Integer getCardBluffCanBeDetected() {
        return cardBluffCanBeDetected;
    }

    public void setCardBluffCanBeDetected(Integer cardBluffCanBeDetected) {
        this.cardBluffCanBeDetected = cardBluffCanBeDetected;
    }

    public Integer getCardBluffSuccessful() {
        return cardBluffSuccessful;
    }

    public void setCardBluffSuccessful(Integer cardBluffSuccessful) {
        this.cardBluffSuccessful = cardBluffSuccessful;
    }

    public String getJogada() {
        return jogada;
    }

    public void setJogada(String jogada) {
        this.jogada = jogada;
    }

    public Integer getIsBluff() {
        return isBluff;
    }

    public void setIsBluff(Integer isBluff) {
        this.isBluff = isBluff;
    }

    public String getTypeBluff() {
        return typeBluff;
    }

    public void setTypeBluff(String typeBluff) {
        this.typeBluff = typeBluff;
    }

    public double getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(double expectedValue) {
        this.expectedValue = expectedValue;
    }

    public Integer getIsSucessful() {
        return isSucessful;
    }

    public void setIsSucessful(Integer isSucessful) {
        this.isSucessful = isSucessful;
    }

    public Integer getWonPoints() {
        return wonPoints;
    }

    public void setWonPoints(Integer wonPoints) {
        this.wonPoints = wonPoints;
    }

    public Integer getBluffCanBeDetected() {
        return bluffCanBeDetected;
    }

    public void setBluffCanBeDetected(Integer bluffCanBeDetected) {
        this.bluffCanBeDetected = bluffCanBeDetected;
    }

    public Integer getIsStrongHand() {
        return isStrongHand;
    }

    public void setIsStrongHand(Integer isStrongHand) {
        this.isStrongHand = isStrongHand;
    }

    public Integer getIsWeakHand() {
        return isWeakHand;
    }

    public void setIsWeakHand(Integer isWeakHand) {
        this.isWeakHand = isWeakHand;
    }

    public Integer getIsFewPoints() {
        return isFewPoints;
    }

    public void setIsFewPoints(Integer isFewPoints) {
        this.isFewPoints = isFewPoints;
    }

    public Integer getIsManyPoints() {
        return isManyPoints;
    }

    public void setIsManyPoints(Integer isManyPoints) {
        this.isManyPoints = isManyPoints;
    }

    public Integer getIsManyPointsAgo() {
        return isManyPointsAgo;
    }

    public void setIsManyPointsAgo(Integer isManyPointsAgo) {
        this.isManyPointsAgo = isManyPointsAgo;
    }

    public Integer getIsManyPointsForeward() {
        return isManyPointsForeward;
    }

    public void setIsManyPointsForeward(Integer isManyPointsForeward) {
        this.isManyPointsForeward = isManyPointsForeward;
    }

    public Integer getIsTestOpponent() {
        return isTestOpponent;
    }

    public void setIsTestOpponent(Integer isTestOpponent) {
        this.isTestOpponent = isTestOpponent;
    }

    public Integer getIsOpponentTight() {
        return isOpponentTight;
    }

    public void setIsOpponentTight(Integer isOpponentTight) {
        this.isOpponentTight = isOpponentTight;
    }

    public Integer getIsOpponentLoose() {
        return isOpponentLoose;
    }

    public void setIsOpponentLoose(Integer isOpponentLoose) {
        this.isOpponentLoose = isOpponentLoose;
    }

    public Integer getIsOpponentAgressive() {
        return isOpponentAgressive;
    }

    public void setIsOpponentAgressive(Integer isOpponentAgressive) {
        this.isOpponentAgressive = isOpponentAgressive;
    }

    public Integer getIsOpponentPassive() {
        return isOpponentPassive;
    }

    public void setIsOpponentPassive(Integer isOpponentPassive) {
        this.isOpponentPassive = isOpponentPassive;
    }

    @Override
    public Attribute getIdAttribute() {
        return new Attribute("caseId", this.getClass());
    }

}
