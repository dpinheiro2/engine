package br.ufsm.cbrgroup.description;

import es.ucm.fdi.gaia.jcolibri.cbrcore.Attribute;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CaseComponent;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 05/07/2019.
 */

@Entity
@Table(name="card_retain_active")
public class PlayCardRetainActive extends GenericPlayCard implements CaseComponent, Serializable {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "caseId")
    private Integer caseId;

    @Column(name = "isHand", nullable = true)
    private Integer isHand;

    @Column(name = "highCardCode", nullable = true)
    private Integer highCardCode;

    @Column(name = "highCardSuit", nullable = true)
    private String highCardSuit;

    @Column(name = "mediumCardCode", nullable = true)
    private Integer mediumCardCode;

    @Column(name = "mediumCardSuit", nullable = true)
    private String mediumCardSuit;

    @Column(name = "lowCardCode", nullable = true)
    private Integer lowCardCode;

    @Column(name = "lowCardSuit", nullable = true)
    private String lowCardSuit;

    @Column(name = "points", nullable = true)
    private Integer points;

    @Column(name = "opponentPoints", nullable = true)
    private Integer opponentPoints;

    @Column(name = "stateDecisionTurn", nullable = true)
    private String stateDecisionTurn;

    @Column(name = "stateTruco", nullable = true)
    private String stateDecisionToken;

    @Column(name = "envidoChainSize", nullable = true)
    private Integer envidoChainSize;

    @Column(name = "florChainSize", nullable = true)
    private Integer florChainSize;

    @Column(name = "trucoChainSize", nullable = true)
    private Integer trucoChainSize;

    @Column(name = "playedCard1Code", nullable = true)
    private Integer playedCard1Code;

    @Column(name = "playedCard1Suit", nullable = true)
    private String playedCard1Suit;

    @Column(name = "whoCard1", nullable = true)
    private Integer whoCard1;

    @Column(name = "playedCard2Code", nullable = true)
    private Integer playedCard2Code;

    @Column(name = "playedCard2Suit", nullable = true)
    private String playedCard2Suit;

    @Column(name = "whoCard2", nullable = true)
    private Integer whoCard2;

    @Column(name = "playedCard3Code", nullable = true)
    private Integer playedCard3Code;

    @Column(name = "playedCard3Suit", nullable = true)
    private String playedCard3Suit;

    @Column(name = "whoCard3", nullable = true)
    private Integer whoCard3;

    @Column(name = "playedCard4Code", nullable = true)
    private Integer playedCard4Code;

    @Column(name = "playedCard4Suit", nullable = true)
    private String playedCard4Suit;

    @Column(name = "whoCard4", nullable = true)
    private Integer whoCard4;

    @Column(name = "playedCard5Code", nullable = true)
    private Integer playedCard5Code;

    @Column(name = "playedCard5Suit", nullable = true)
    private String playedCard5Suit;

    @Column(name = "whoCard5", nullable = true)
    private Integer whoCard5;

    @Column(name = "playedCard6Code", nullable = true)
    private Integer playedCard6Code;

    @Column(name = "playedCard6Suit", nullable = true)
    private String playedCard6Suit;

    @Column(name = "whoCard6", nullable = true)
    private Integer whoCard6;

    @Column(name = "winnerRound1", nullable = true)
    private Integer winnerRound1;

    @Column(name = "winnerRound2", nullable = true)
    private Integer winnerRound2;

    @Column(name = "envidoPointsWon", nullable = true)
    private Integer envidoPointsWon;

    @Column(name = "florPointsWon", nullable = true)
    private Integer florPointsWon;

    @Column(name = "triedCardBluffs", nullable = true)
    private Integer triedCardBluffs;

    @Column(name = "cardBluffCanBeDetected", nullable = true)
    private Integer cardBluffCanBeDetected;

    @Column(name = "cardBluffSuccessful", nullable = true)
    private Integer cardBluffSuccessful;

    @Column(name = "jogada", nullable = true)
    private String jogada;

    @Column(name = "isBluff", nullable = true)
    private Integer isBluff;

    @Column(name = "typeBluff", nullable = true)
    private String typeBluff;

    @Column(name = "expectedValue", nullable = true)
    private double expectedValue;

    @Column(name = "isSucessful", nullable = true)
    private Integer isSucessful;

    @Column(name = "wonPoints", nullable = true)
    private Integer wonPoints;

    @Column(name = "bluffCanBeDetected", nullable = true)
    private Integer bluffCanBeDetected;

    @Column(name = "isStrongHand", nullable = true)
    private Integer isStrongHand;

    @Column(name = "isWeakHand", nullable = true)
    private Integer isWeakHand;

    @Column(name = "isFewPoints", nullable = true)
    private Integer isFewPoints;

    @Column(name = "isManyPoints", nullable = true)
    private Integer isManyPoints;

    @Column(name = "isManyPointsAgo", nullable = true)
    private Integer isManyPointsAgo;

    @Column(name = "isManyPointsForeward", nullable = true)
    private Integer isManyPointsForeward;

    @Column(name = "isTestOpponent", nullable = true)
    private Integer isTestOpponent;

    @Column(name = "isOpponentTight", nullable = true)
    private Integer isOpponentTight;

    @Column(name = "isOpponentLoose", nullable = true)
    private Integer isOpponentLoose;

    @Column(name = "isOpponentAgressive", nullable = true)
    private Integer isOpponentAgressive;

    @Column(name = "isOpponentPassive", nullable = true)
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
    public String toString() {
        return "PlayCard{" +
                "caseId=" + caseId +
                ", isHand=" + isHand +
                ", highCardCode=" + highCardCode +
                ", highCardSuit='" + highCardSuit + '\'' +
                ", mediumCardCode=" + mediumCardCode +
                ", mediumCardSuit='" + mediumCardSuit + '\'' +
                ", lowCardCode=" + lowCardCode +
                ", lowCardSuit='" + lowCardSuit + '\'' +
                ", points=" + points +
                ", opponentPoints=" + opponentPoints +
                ", stateDecisionTurn='" + stateDecisionTurn + '\'' +
                ", stateDecisionToken='" + stateDecisionToken + '\'' +
                ", envidoChainSize=" + envidoChainSize +
                ", florChainSize=" + florChainSize +
                ", trucoChainSize=" + trucoChainSize +
                ", playedCard1Code=" + playedCard1Code +
                ", playedCard1Suit='" + playedCard1Suit + '\'' +
                ", whoCard1=" + whoCard1 +
                ", playedCard2Code=" + playedCard2Code +
                ", playedCard2Suit='" + playedCard2Suit + '\'' +
                ", whoCard2=" + whoCard2 +
                ", playedCard3Code=" + playedCard3Code +
                ", playedCard3Suit='" + playedCard3Suit + '\'' +
                ", whoCard3=" + whoCard3 +
                ", playedCard4Code=" + playedCard4Code +
                ", playedCard4Suit='" + playedCard4Suit + '\'' +
                ", whoCard4=" + whoCard4 +
                ", playedCard5Code=" + playedCard5Code +
                ", playedCard5Suit='" + playedCard5Suit + '\'' +
                ", whoCard5=" + whoCard5 +
                ", playedCard6Code=" + playedCard6Code +
                ", playedCard6Suit='" + playedCard6Suit + '\'' +
                ", whoCard6=" + whoCard6 +
                ", winnerRound1=" + winnerRound1 +
                ", winnerRound2=" + winnerRound2 +
                ", envidoPointsWon=" + envidoPointsWon +
                ", florPointsWon=" + florPointsWon +
                ", triedCardBluffs=" + triedCardBluffs +
                ", cardBluffCanBeDetected=" + cardBluffCanBeDetected +
                ", cardBluffSuccessful=" + cardBluffSuccessful +
                ", jogada='" + jogada + '\'' +
                ", isBluff=" + isBluff +
                ", typeBluff='" + typeBluff + '\'' +
                ", expectedValue=" + expectedValue +
                ", isSucessful=" + isSucessful +
                ", wonPoints=" + wonPoints +
                ", bluffCanBeDetected=" + bluffCanBeDetected +
                ", isStrongHand=" + isStrongHand +
                ", isWeakHand=" + isWeakHand +
                ", isFewPoints=" + isFewPoints +
                ", isManyPoints=" + isManyPoints +
                ", isManyPointsAgo=" + isManyPointsAgo +
                ", isManyPointsForeward=" + isManyPointsForeward +
                ", isTestOpponent=" + isTestOpponent +
                ", isOpponentTight=" + isOpponentTight +
                ", isOpponentLoose=" + isOpponentLoose +
                ", isOpponentAgressive=" + isOpponentAgressive +
                ", isOpponentPassive=" + isOpponentPassive +
                '}';
    }

    @Override
    public Attribute getIdAttribute() {
        return new Attribute("caseId", this.getClass());
    }
}
