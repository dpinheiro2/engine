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


public abstract class GenericFlor implements CaseComponent {


    private Integer caseId;
    private Integer isHand;
    private Integer highCardCode;
    private String highCardSuit;
    private Integer mediumCardCode;
    private String mediumCardSuit;
    private Integer lowCardCode;
    private String lowCardSuit;
    private Integer florPoints;
    private Integer points;
    private Integer opponentPoints;
    private Integer opponentPlayedCardCode;
    private String opponentPlayedCardSuit;
    private Integer florChainSize;
    private Integer triedFlorBluffs;
    private Integer florBluffCanBeDetected;
    private Integer florBluffSuccessful;
    private String jogada;
    private Integer isBluff;
    private String typeBluff;
    private double expectedValue;
    private Integer isSucessful;
    private Integer wonPoints;
    private Integer lostPoints;
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
    private Integer canOpponentInferCards;
    private Integer canInferOpponentCards;
    private String stateDecision;

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

    public Integer getFlorPoints() {
        return florPoints;
    }

    public void setFlorPoints(Integer florPoints) {
        this.florPoints = florPoints;
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

    public Integer getOpponentPlayedCardCode() {
        return opponentPlayedCardCode;
    }

    public void setOpponentPlayedCardCode(Integer opponentPlayedCardCode) {
        this.opponentPlayedCardCode = opponentPlayedCardCode;
    }

    public String getOpponentPlayedCardSuit() {
        return opponentPlayedCardSuit;
    }

    public void setOpponentPlayedCardSuit(String opponentPlayedCardSuit) {
        this.opponentPlayedCardSuit = opponentPlayedCardSuit;
    }

    public Integer getFlorChainSize() {
        return florChainSize;
    }

    public void setFlorChainSize(Integer florChainSize) {
        this.florChainSize = florChainSize;
    }

    public Integer getTriedFlorBluffs() {
        return triedFlorBluffs;
    }

    public void setTriedFlorBluffs(Integer triedFlorBluffs) {
        this.triedFlorBluffs = triedFlorBluffs;
    }

    public Integer getFlorBluffCanBeDetected() {
        return florBluffCanBeDetected;
    }

    public void setFlorBluffCanBeDetected(Integer florBluffCanBeDetected) {
        this.florBluffCanBeDetected = florBluffCanBeDetected;
    }

    public Integer getFlorBluffSuccessful() {
        return florBluffSuccessful;
    }

    public void setFlorBluffSuccessful(Integer florBluffSuccessful) {
        this.florBluffSuccessful = florBluffSuccessful;
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

    public Integer getLostPoints() {
        return lostPoints;
    }

    public void setLostPoints(Integer lostPoints) {
        this.lostPoints = lostPoints;
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

    public Integer getCanOpponentInferCards() {
        return canOpponentInferCards;
    }

    public void setCanOpponentInferCards(Integer canOpponentInferCards) {
        this.canOpponentInferCards = canOpponentInferCards;
    }

    public Integer getCanInferOpponentCards() {
        return canInferOpponentCards;
    }

    public void setCanInferOpponentCards(Integer canInferOpponentCards) {
        this.canInferOpponentCards = canInferOpponentCards;
    }

    public String getStateDecision() {
        return stateDecision;
    }

    public void setStateDecision(String stateDecision) {
        this.stateDecision = stateDecision;
    }

    @Override
    public Attribute getIdAttribute() {
        return new Attribute("caseId", this.getClass());
    }
}
