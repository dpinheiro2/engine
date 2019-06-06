package br.ufsm.cbrgroup.websocket;



import br.ufsm.cbrgroup.model.Card;

import java.io.Serializable;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 21/04/2019.
 */


public class Message implements Serializable {

    private String action;
    private String info;
    private Card card;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Message{" +
                "action='" + action + '\'' +
                ", info='" + info + '\'' +
                ", card=" + card +
                '}';
    }
}
