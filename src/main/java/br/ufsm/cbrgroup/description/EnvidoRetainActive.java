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
@Table(name="envido_retain_active")
public class EnvidoRetainActive  extends GenericEnvido implements CaseComponent, Serializable {

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

    @Column(name = "envidoPoints", nullable = true)
    private Integer envidoPoints;

    @Column(name = "points", nullable = true)
    private Integer points;

    @Column(name = "opponentPoints", nullable = true)
    private Integer opponentPoints;

    @Column(name = "opponentPlayedCardCode", nullable = true)
    private Integer opponentPlayedCardCode;

    @Column(name = "opponentPlayedCardSuit", nullable = true)
    private String opponentPlayedCardSuit;

    @Column(name = "envidoChainSize", nullable = true)
    private Integer envidoChainSize;

    @Column(name = "triedEnvidoBluffs", nullable = true)
    private Integer triedEnvidoBluffs;

    @Column(name = "envidoBluffCanBeDetected", nullable = true)
    private Integer envidoBluffCanBeDetected;

    @Column(name = "envidoBluffSuccessful", nullable = true)
    private Integer envidoBluffSuccessful;

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

    @Column(name = "lostPoints", nullable = true)
    private Integer lostPoints;

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

    @Column(name = "canOpponentInferCards", nullable = true)
    private Integer canOpponentInferCards;

    @Column(name = "canInferOpponentCards", nullable = true)
    private Integer canInferOpponentCards;

    @Column(name = "stateDecision", nullable = true)
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

    public Integer getEnvidoPoints() {
        return envidoPoints;
    }

    public void setEnvidoPoints(Integer envidoPoints) {
        this.envidoPoints = envidoPoints;
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

    public Integer getEnvidoChainSize() {
        return envidoChainSize;
    }

    public void setEnvidoChainSize(Integer envidoChainSize) {
        this.envidoChainSize = envidoChainSize;
    }

    public Integer getTriedEnvidoBluffs() {
        return triedEnvidoBluffs;
    }

    public void setTriedEnvidoBluffs(Integer triedEnvidoBluffs) {
        this.triedEnvidoBluffs = triedEnvidoBluffs;
    }

    public Integer getEnvidoBluffCanBeDetected() {
        return envidoBluffCanBeDetected;
    }

    public void setEnvidoBluffCanBeDetected(Integer envidoBluffCanBeDetected) {
        this.envidoBluffCanBeDetected = envidoBluffCanBeDetected;
    }

    public Integer getEnvidoBluffSuccessful() {
        return envidoBluffSuccessful;
    }

    public void setEnvidoBluffSuccessful(Integer envidoBluffSuccessful) {
        this.envidoBluffSuccessful = envidoBluffSuccessful;
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
    public String toString() {
        return "Envido{" +
                "caseId=" + caseId +
                ", isHand=" + isHand +
                ", highCardCode=" + highCardCode +
                ", highCardSuit='" + highCardSuit + '\'' +
                ", mediumCardCode=" + mediumCardCode +
                ", mediumCardSuit='" + mediumCardSuit + '\'' +
                ", lowCardCode=" + lowCardCode +
                ", lowCardSuit='" + lowCardSuit + '\'' +
                ", envidoPoints=" + envidoPoints +
                ", points=" + points +
                ", opponentPoints=" + opponentPoints +
                ", opponentPlayedCardCode=" + opponentPlayedCardCode +
                ", opponentPlayedCardSuit='" + opponentPlayedCardSuit + '\'' +
                ", envidoChainSize=" + envidoChainSize +
                ", triedEnvidoBluffs=" + triedEnvidoBluffs +
                ", envidoBluffCanBeDetected=" + envidoBluffCanBeDetected +
                ", envidoBluffSuccessful=" + envidoBluffSuccessful +
                ", jogada='" + jogada + '\'' +
                ", isBluff=" + isBluff +
                ", typeBluff='" + typeBluff + '\'' +
                ", expectedValue=" + expectedValue +
                ", isSucessful=" + isSucessful +
                ", wonPoints=" + wonPoints +
                ", lostPoints=" + lostPoints +
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
                ", canOpponentInferCards=" + canOpponentInferCards +
                ", canInferOpponentCards=" + canInferOpponentCards +
                ", stateDecision='" + stateDecision + '\'' +
                '}';
    }

    @Override
    public Attribute getIdAttribute() {
        return new Attribute("caseId", this.getClass());
    }
}
