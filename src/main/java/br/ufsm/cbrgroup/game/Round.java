package br.ufsm.cbrgroup.game;

import br.ufsm.cbrgroup.model.Card;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 04/06/2019.
 */


public class Round {

    private int number;
    private Card player1Card;
    private Card player2Card;
    private int winner;
    private int result;
    private boolean faceDownCardPlayer1;
    private boolean faceDownCardPlayer2;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Card getPlayer1Card() {
        return player1Card;
    }

    public void setPlayer1Card(Card player1Card) {
        this.player1Card = player1Card;
    }

    public Card getPlayer2Card() {
        return player2Card;
    }

    public void setPlayer2Card(Card player2Card) {
        this.player2Card = player2Card;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public boolean isFaceDownCardPlayer1() {
        return faceDownCardPlayer1;
    }

    public void setFaceDownCardPlayer1(boolean faceDownCardPlayer1) {
        this.faceDownCardPlayer1 = faceDownCardPlayer1;
    }

    public boolean isFaceDownCardPlayer2() {
        return faceDownCardPlayer2;
    }

    public void setFaceDownCardPlayer2(boolean faceDownCardPlayer2) {
        this.faceDownCardPlayer2 = faceDownCardPlayer2;
    }


}
