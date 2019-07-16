package br.ufsm.cbrgroup.description;

import es.ucm.fdi.gaia.jcolibri.cbrcore.Attribute;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CaseComponent;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 16/06/2019.
 */

@Entity
@Table(name="cards")
public class Carta implements CaseComponent, Serializable {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "idCard")
    private Integer idCard;

    @Column(name = "face", nullable = false)
    private String face;

    @Column(name = "suit", nullable = false)
    private String suit;

    @Column(name = "cbrCode", nullable = false)
    private Integer cbrCode;

   /* @OneToMany(mappedBy="highCard", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Envido> highCard = new LinkedList<Envido>();

    @OneToMany(mappedBy="mediumCard", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Envido> mediumCard = new LinkedList<Envido>();

    @OneToMany(mappedBy="lowCard", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Envido> lowCard = new LinkedList<Envido>();

    @OneToMany(mappedBy="opponentPlayedCard", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Envido> opponentPlayedCard = new LinkedList<Envido>();

    @OneToMany(mappedBy="highCard", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Flor> highCardFlor = new LinkedList<Flor>();

    @OneToMany(mappedBy="mediumCard", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Flor> mediumCardFlor = new LinkedList<Flor>();

    @OneToMany(mappedBy="lowCard", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Flor> lowCardFlor = new LinkedList<Flor>();

    @OneToMany(mappedBy="opponentPlayedCard", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Flor> opponentPlayedCardFlor = new LinkedList<Flor>();

    @OneToMany(mappedBy="highCard", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Truco> highCardTruco = new LinkedList<Truco>();

    @OneToMany(mappedBy="mediumCard", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Truco> mediumCardTruco = new LinkedList<Truco>();

    @OneToMany(mappedBy="lowCard", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Truco> lowCardTruco = new LinkedList<Truco>();

    @OneToMany(mappedBy="playedCard1", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Truco> playedCard1 = new LinkedList<Truco>();

    @OneToMany(mappedBy="playedCard2", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Truco> playedCard2 = new LinkedList<Truco>();

    @OneToMany(mappedBy="playedCard3", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Truco> playedCard3 = new LinkedList<Truco>();

    @OneToMany(mappedBy="playedCard4", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Truco> playedCard4 = new LinkedList<Truco>();

    @OneToMany(mappedBy="playedCard5", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Truco> playedCard5 = new LinkedList<Truco>();

    @OneToMany(mappedBy="playedCard6", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Truco> playedCard6 = new LinkedList<Truco>();

    @OneToMany(mappedBy="highCard", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<PlayCard> highCardPlayCard = new LinkedList<PlayCard>();

    @OneToMany(mappedBy="mediumCard", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<PlayCard> mediumCardPlayCard = new LinkedList<PlayCard>();

    @OneToMany(mappedBy="lowCard", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<PlayCard> lowCardPlayCard = new LinkedList<PlayCard>();

    @OneToMany(mappedBy="playedCard1", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<PlayCard> playedCard1PlayCard = new LinkedList<PlayCard>();

    @OneToMany(mappedBy="playedCard2", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<PlayCard> playedCard2PlayCard = new LinkedList<PlayCard>();

    @OneToMany(mappedBy="playedCard3", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<PlayCard> playedCard3PlayCard = new LinkedList<PlayCard>();

    @OneToMany(mappedBy="playedCard4", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<PlayCard> playedCard4PlayCard = new LinkedList<PlayCard>();

    @OneToMany(mappedBy="playedCard5", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<PlayCard> playedCard5PlayCard = new LinkedList<PlayCard>();

    @OneToMany(mappedBy="playedCard6", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<PlayCard> playedCard6PlayCard = new LinkedList<PlayCard>();*/

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public Integer getCbrCode() {
        return cbrCode;
    }

    public void setCbrCode(Integer cbrCode) {
        this.cbrCode = cbrCode;
    }

    /*public Collection<Envido> getHighCard() {
        return highCard;
    }

    public void setHighCard(Collection<Envido> highCard) {
        this.highCard = highCard;
    }

    public Collection<Envido> getMediumCard() {
        return mediumCard;
    }

    public void setMediumCard(Collection<Envido> mediumCard) {
        this.mediumCard = mediumCard;
    }

    public Collection<Envido> getLowCard() {
        return lowCard;
    }

    public void setLowCard(Collection<Envido> lowCard) {
        this.lowCard = lowCard;
    }

    public Collection<Envido> getOpponentPlayedCard() {
        return opponentPlayedCard;
    }

    public void setOpponentPlayedCard(Collection<Envido> opponentPlayedCard) {
        this.opponentPlayedCard = opponentPlayedCard;
    }

    public Collection<Flor> getHighCardFlor() {
        return highCardFlor;
    }

    public void setHighCardFlor(Collection<Flor> highCardFlor) {
        this.highCardFlor = highCardFlor;
    }

    public Collection<Flor> getMediumCardFlor() {
        return mediumCardFlor;
    }

    public void setMediumCardFlor(Collection<Flor> mediumCardFlor) {
        this.mediumCardFlor = mediumCardFlor;
    }

    public Collection<Flor> getLowCardFlor() {
        return lowCardFlor;
    }

    public void setLowCardFlor(Collection<Flor> lowCardFlor) {
        this.lowCardFlor = lowCardFlor;
    }

    public Collection<Flor> getOpponentPlayedCardFlor() {
        return opponentPlayedCardFlor;
    }

    public void setOpponentPlayedCardFlor(Collection<Flor> opponentPlayedCardFlor) {
        this.opponentPlayedCardFlor = opponentPlayedCardFlor;
    }

    public Collection<Truco> getHighCardTruco() {
        return highCardTruco;
    }

    public void setHighCardTruco(Collection<Truco> highCardTruco) {
        this.highCardTruco = highCardTruco;
    }

    public Collection<Truco> getMediumCardTruco() {
        return mediumCardTruco;
    }

    public void setMediumCardTruco(Collection<Truco> mediumCardTruco) {
        this.mediumCardTruco = mediumCardTruco;
    }

    public Collection<Truco> getLowCardTruco() {
        return lowCardTruco;
    }

    public void setLowCardTruco(Collection<Truco> lowCardTruco) {
        this.lowCardTruco = lowCardTruco;
    }

    public Collection<Truco> getPlayedCard1() {
        return playedCard1;
    }

    public void setPlayedCard1(Collection<Truco> playedCard1) {
        this.playedCard1 = playedCard1;
    }

    public Collection<Truco> getPlayedCard2() {
        return playedCard2;
    }

    public void setPlayedCard2(Collection<Truco> playedCard2) {
        this.playedCard2 = playedCard2;
    }

    public Collection<Truco> getPlayedCard3() {
        return playedCard3;
    }

    public void setPlayedCard3(Collection<Truco> playedCard3) {
        this.playedCard3 = playedCard3;
    }

    public Collection<Truco> getPlayedCard4() {
        return playedCard4;
    }

    public void setPlayedCard4(Collection<Truco> playedCard4) {
        this.playedCard4 = playedCard4;
    }

    public Collection<Truco> getPlayedCard5() {
        return playedCard5;
    }

    public void setPlayedCard5(Collection<Truco> playedCard5) {
        this.playedCard5 = playedCard5;
    }

    public Collection<Truco> getPlayedCard6() {
        return playedCard6;
    }

    public void setPlayedCard6(Collection<Truco> playedCard6) {
        this.playedCard6 = playedCard6;
    }

    public Collection<PlayCard> getHighCardPlayCard() {
        return highCardPlayCard;
    }

    public void setHighCardPlayCard(Collection<PlayCard> highCardPlayCard) {
        this.highCardPlayCard = highCardPlayCard;
    }

    public Collection<PlayCard> getMediumCardPlayCard() {
        return mediumCardPlayCard;
    }

    public void setMediumCardPlayCard(Collection<PlayCard> mediumCardPlayCard) {
        this.mediumCardPlayCard = mediumCardPlayCard;
    }

    public Collection<PlayCard> getLowCardPlayCard() {
        return lowCardPlayCard;
    }

    public void setLowCardPlayCard(Collection<PlayCard> lowCardPlayCard) {
        this.lowCardPlayCard = lowCardPlayCard;
    }

    public Collection<PlayCard> getPlayedCard1PlayCard() {
        return playedCard1PlayCard;
    }

    public void setPlayedCard1PlayCard(Collection<PlayCard> playedCard1PlayCard) {
        this.playedCard1PlayCard = playedCard1PlayCard;
    }

    public Collection<PlayCard> getPlayedCard2PlayCard() {
        return playedCard2PlayCard;
    }

    public void setPlayedCard2PlayCard(Collection<PlayCard> playedCard2PlayCard) {
        this.playedCard2PlayCard = playedCard2PlayCard;
    }

    public Collection<PlayCard> getPlayedCard3PlayCard() {
        return playedCard3PlayCard;
    }

    public void setPlayedCard3PlayCard(Collection<PlayCard> playedCard3PlayCard) {
        this.playedCard3PlayCard = playedCard3PlayCard;
    }

    public Collection<PlayCard> getPlayedCard4PlayCard() {
        return playedCard4PlayCard;
    }

    public void setPlayedCard4PlayCard(Collection<PlayCard> playedCard4PlayCard) {
        this.playedCard4PlayCard = playedCard4PlayCard;
    }

    public Collection<PlayCard> getPlayedCard5PlayCard() {
        return playedCard5PlayCard;
    }

    public void setPlayedCard5PlayCard(Collection<PlayCard> playedCard5PlayCard) {
        this.playedCard5PlayCard = playedCard5PlayCard;
    }

    public Collection<PlayCard> getPlayedCard6PlayCard() {
        return playedCard6PlayCard;
    }

    public void setPlayedCard6PlayCard(Collection<PlayCard> playedCard6PlayCard) {
        this.playedCard6PlayCard = playedCard6PlayCard;
    }*/

   /* @Override
    public String toString() {
        return "Carta{" +
                "face='" + face + '\'' +
                ", suit='" + suit + '\'' +
                ", cbrCode=" + cbrCode +
                '}';
    }*/

    @Override
    public Attribute getIdAttribute() {
        return new Attribute("idCard", this.getClass());
    }
}
