package br.ufsm.cbrgroup.game;

import br.ufsm.cbrgroup.description.Carta;
import br.ufsm.cbrgroup.enums.Face;
import br.ufsm.cbrgroup.enums.StateDecisionToken;
import br.ufsm.cbrgroup.enums.StateDecisionTurn;
import br.ufsm.cbrgroup.enums.Suit;
import br.ufsm.cbrgroup.model.Card;

import javax.websocket.Session;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 19/04/2019.
 */


public class GameState implements Serializable {

    LinkedList<Action> envidoHistory;
    LinkedList<Action> trucoHistory;
    LinkedList<Action> florHistory;
    LinkedList<Action> cardHistory;

    private Carta carta1;
    private Carta carta2;
    private Carta carta3;
    private Carta carta4;
    private Carta carta5;
    private Carta carta6;

    private Integer whoCarta1;
    private Integer whoCarta2;
    private Integer whoCarta3;
    private Integer whoCarta4;
    private Integer whoCarta5;
    private Integer whoCarta6;

    private Integer tentosEnvido;
    private Integer tentosFlor;

    private StateDecisionTurn stateDecisionTurn;
    private StateDecisionToken stateDecisionToken;

    private ArrayList<Card> agentCards;
    //private ArrayList<Card> agentHandCards;
    private LinkedList<Card> agentPlayedCards;
    private LinkedList<Card> opponentPlayedCards;
    private LinkedList<Card> dealtCards;

    private Round round1;
    private Round round2;
    private Round round3;

    private LinkedList<Round> rounds;

    private int agentPoints = 0;
    private int opponentPoints = 0;

    private int envidoPoints = 0;
    private int opponentEnvidoPoints = 0;

    private boolean isWinnerRound1 = false;
    private boolean isEmpateRound1 = false;

    private boolean isWinnerRound2 = false;
    private boolean isEmpateRound2 = false;

    private boolean isWinnerRound3 = false;
    private boolean isEmpateRound3 = false;

    private boolean isResultRound1 = false;
    private boolean isResultRound2 = false;
    private boolean isResultRound3 = false;

    private int opponentCartaVirada = 0;
    private int agentCartaVirada = 0;

    private boolean isHand;
    private boolean turno;
    private boolean token;
    private boolean isPlaying;
    private boolean hasFlor;
    private boolean envido;
    private boolean flor;
    private boolean truco;
    private boolean isLastRaise;
    private int trucoLevel = 0;
    private int florLevel = 0;
    private int envidoLevel = 0;
    private boolean isLastFlorRaise;
    private boolean isLastEnvidoRaise;
    private int currentRound = 1;

    private int envidoSize = 0;
    private int trucoSize = 0;
    private int florSize = 0;

    private int numberGames = 1;
    private int countGames = 0;

    private String idPartida;

    private int triedEnvidoBluffs = 0;
    private int envidoBluffCanBeDetected = 0;
    private int envidoBluffSuccessful = 0;

    private int triedFlorBluffs = 0;
    private int florBluffCanBeDetected = 0;
    private int florBluffSuccessful = 0;

    private int triedTrucoBluffs = 0;
    private int trucoBluffCanBeDetected = 0;
    private int trucoBluffSuccessful = 0;

    private int triedCardBluffs = 0;
    private int cardBluffCanBeDetected = 0;
    private int cardBluffSuccessful = 0;

    private int bluffCanBeDetected = 0;


    public StateDecisionTurn getStateDecisionTurn() {
        return stateDecisionTurn;
    }

    public void setStateDecisionTurn(StateDecisionTurn stateDecisionTurn) {
        this.stateDecisionTurn = stateDecisionTurn;
    }

    public StateDecisionToken getStateDecisionToken() {
        return stateDecisionToken;
    }

    public void setStateDecisionToken(StateDecisionToken stateDecisionToken) {
        this.stateDecisionToken = stateDecisionToken;
    }

    public ArrayList<Card> getAgentCards() {
        return agentCards;
    }

    public void setAgentCards(ArrayList<Card> agentCards) {
        this.agentCards = agentCards;
    }

    /*public ArrayList<Card> getAgentHandCards() {
        return agentHandCards;
    }

    public void setAgentHandCards(ArrayList<Card> agentHandCards) {
        this.agentHandCards = agentHandCards;
    }
*/
    public LinkedList<Card> getAgentPlayedCards() {
        return agentPlayedCards;
    }

    public void setAgentPlayedCards(LinkedList<Card> agentPlayedCards) {
        this.agentPlayedCards = agentPlayedCards;
    }

    public LinkedList<Card> getOpponentPlayedCards() {
        return opponentPlayedCards;
    }

    public void setOpponentPlayedCards(LinkedList<Card> opponentPlayedCards) {
        this.opponentPlayedCards = opponentPlayedCards;
    }

    public LinkedList<Card> getDealtCards() {
        return dealtCards;
    }

    public void setDealtCards(LinkedList<Card> dealtCards) {
        this.dealtCards = dealtCards;
    }

    public int getAgentPoints() {
        return agentPoints;
    }

    public void setAgentPoints(int agentPoints) {
        this.agentPoints = agentPoints;
    }

    public int getOpponentPoints() {
        return opponentPoints;
    }

    public void setOpponentPoints(int opponentPoints) {
        this.opponentPoints = opponentPoints;
    }

    public int getEnvidoPoints() {
        return envidoPoints;
    }

    public void setEnvidoPoints(int envidoPoints) {
        this.envidoPoints = envidoPoints;
    }

    public int getOpponentEnvidoPoints() {
        return opponentEnvidoPoints;
    }

    public void setOpponentEnvidoPoints(int opponentEnvidoPoints) {
        this.opponentEnvidoPoints = opponentEnvidoPoints;
    }

    public boolean isWinnerRound1() {
        return isWinnerRound1;
    }

    public void setWinnerRound1(boolean winnerRound1) {
        isWinnerRound1 = winnerRound1;
    }

    public boolean isEmpateRound1() {
        return isEmpateRound1;
    }

    public void setEmpateRound1(boolean empateRound1) {
        isEmpateRound1 = empateRound1;
    }

    public boolean isWinnerRound2() {
        return isWinnerRound2;
    }

    public void setWinnerRound2(boolean winnerRound2) {
        isWinnerRound2 = winnerRound2;
    }

    public boolean isEmpateRound2() {
        return isEmpateRound2;
    }

    public void setEmpateRound2(boolean empateRound2) {
        isEmpateRound2 = empateRound2;
    }

    public boolean isWinnerRound3() {
        return isWinnerRound3;
    }

    public void setWinnerRound3(boolean winnerRound3) {
        isWinnerRound3 = winnerRound3;
    }

    public boolean isEmpateRound3() {
        return isEmpateRound3;
    }

    public void setEmpateRound3(boolean empateRound3) {
        isEmpateRound3 = empateRound3;
    }

    public int getOpponentCartaVirada() {
        return opponentCartaVirada;
    }

    public void setOpponentCartaVirada(int opponentCartaVirada) {
        this.opponentCartaVirada = opponentCartaVirada;
    }

    public int getAgentCartaVirada() {
        return agentCartaVirada;
    }

    public void setAgentCartaVirada(int agentCartaVirada) {
        this.agentCartaVirada = agentCartaVirada;
    }

    public boolean isHand() {
        return isHand;
    }

    public void setHand(boolean hand) {
        isHand = hand;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public boolean isToken() {
        return token;
    }

    public void setToken(boolean token) {
        this.token = token;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public boolean isHasFlor() {
        return hasFlor;
    }

    public void setHasFlor(boolean hasFlor) {
        this.hasFlor = hasFlor;
    }

    public boolean isEnvido() {
        return envido;
    }

    public void setEnvido(boolean envido) {
        this.envido = envido;
    }

    public boolean isFlor() {
        return flor;
    }

    public void setFlor(boolean flor) {
        this.flor = flor;
    }

    public boolean isTruco() {
        return truco;
    }

    public void setTruco(boolean truco) {
        this.truco = truco;
    }

    public boolean isLastRaise() {
        return isLastRaise;
    }

    public void setLastRaise(boolean lastRaise) {
        isLastRaise = lastRaise;
    }

    public int getTrucoLevel() {
        return trucoLevel;
    }

    public void setTrucoLevel(int trucoLevel) {
        this.trucoLevel = trucoLevel;
    }

    public int getFlorLevel() {
        return florLevel;
    }

    public void setFlorLevel(int florLevel) {
        this.florLevel = florLevel;
    }

    public int getEnvidoLevel() {
        return envidoLevel;
    }

    public void setEnvidoLevel(int envidoLevel) {
        this.envidoLevel = envidoLevel;
    }

    public boolean isLastFlorRaise() {
        return isLastFlorRaise;
    }

    public void setLastFlorRaise(boolean lastFlorRaise) {
        isLastFlorRaise = lastFlorRaise;
    }

    public boolean isLastEnvidoRaise() {
        return isLastEnvidoRaise;
    }

    public void setLastEnvidoRaise(boolean lastEnvidoRaise) {
        isLastEnvidoRaise = lastEnvidoRaise;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    public int getNumberGames() {
        return numberGames;
    }

    public void setNumberGames(int numberGames) {
        this.numberGames = numberGames;
    }

    public int getCountGames() {
        return countGames;
    }

    public void setCountGames(int countGames) {
        this.countGames = countGames;
    }

    public boolean isResultRound1() {
        return isResultRound1;
    }

    public void setResultRound1(boolean resultRound1) {
        isResultRound1 = resultRound1;
    }

    public boolean isResultRound2() {
        return isResultRound2;
    }

    public void setResultRound2(boolean resultRound2) {
        isResultRound2 = resultRound2;
    }

    public boolean isResultRound3() {
        return isResultRound3;
    }

    public void setResultRound3(boolean resultRound3) {
        isResultRound3 = resultRound3;
    }

    public int getEnvidoSize() {
        return envidoSize;
    }

    public void setEnvidoSize(int envidoSize) {
        this.envidoSize = envidoSize;
    }

    public int getTrucoSize() {
        return trucoSize;
    }

    public void setTrucoSize(int trucoSize) {
        this.trucoSize = trucoSize;
    }

    public int getFlorSize() {
        return florSize;
    }

    public void setFlorSize(int florSize) {
        this.florSize = florSize;
    }

    public Round getRound1() {
        return round1;
    }

    public void setRound1(Round round1) {
        this.round1 = round1;
    }

    public Round getRound2() {
        return round2;
    }

    public void setRound2(Round round2) {
        this.round2 = round2;
    }

    public Round getRound3() {
        return round3;
    }

    public void setRound3(Round round3) {
        this.round3 = round3;
    }

    public LinkedList<Round> getRounds() {
        return rounds;
    }

    public void setRounds(LinkedList<Round> rounds) {
        this.rounds = rounds;
    }

    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    public LinkedList<Action> getEnvidoHistory() {
        return envidoHistory;
    }

    public void setEnvidoHistory(LinkedList<Action> envidoHistory) {
        this.envidoHistory = envidoHistory;
    }

    public LinkedList<Action> getTrucoHistory() {
        return trucoHistory;
    }

    public void setTrucoHistory(LinkedList<Action> trucoHistory) {
        this.trucoHistory = trucoHistory;
    }

    public LinkedList<Action> getFlorHistory() {
        return florHistory;
    }

    public void setFlorHistory(LinkedList<Action> florHistory) {
        this.florHistory = florHistory;
    }

    public LinkedList<Action> getCardHistory() {
        return cardHistory;
    }

    public void setCardHistory(LinkedList<Action> cardHistory) {
        this.cardHistory = cardHistory;
    }

    public Carta getCarta1() {
        return carta1;
    }

    public void setCarta1(Carta carta1) {
        this.carta1 = carta1;
    }

    public Carta getCarta2() {
        return carta2;
    }

    public void setCarta2(Carta carta2) {
        this.carta2 = carta2;
    }

    public Carta getCarta3() {
        return carta3;
    }

    public void setCarta3(Carta carta3) {
        this.carta3 = carta3;
    }

    public Carta getCarta4() {
        return carta4;
    }

    public void setCarta4(Carta carta4) {
        this.carta4 = carta4;
    }

    public Carta getCarta5() {
        return carta5;
    }

    public void setCarta5(Carta carta5) {
        this.carta5 = carta5;
    }

    public Carta getCarta6() {
        return carta6;
    }

    public void setCarta6(Carta carta6) {
        this.carta6 = carta6;
    }

    public Integer getWhoCarta1() {
        return whoCarta1;
    }

    public void setWhoCarta1(Integer whoCarta1) {
        this.whoCarta1 = whoCarta1;
    }

    public Integer getWhoCarta2() {
        return whoCarta2;
    }

    public void setWhoCarta2(Integer whoCarta2) {
        this.whoCarta2 = whoCarta2;
    }

    public Integer getWhoCarta3() {
        return whoCarta3;
    }

    public void setWhoCarta3(Integer whoCarta3) {
        this.whoCarta3 = whoCarta3;
    }

    public Integer getWhoCarta4() {
        return whoCarta4;
    }

    public void setWhoCarta4(Integer whoCarta4) {
        this.whoCarta4 = whoCarta4;
    }

    public Integer getWhoCarta5() {
        return whoCarta5;
    }

    public void setWhoCarta5(Integer whoCarta5) {
        this.whoCarta5 = whoCarta5;
    }

    public Integer getWhoCarta6() {
        return whoCarta6;
    }

    public void setWhoCarta6(Integer whoCarta6) {
        this.whoCarta6 = whoCarta6;
    }

    public Integer getTentosEnvido() {
        return tentosEnvido;
    }

    public void setTentosEnvido(Integer tentosEnvido) {
        this.tentosEnvido = tentosEnvido;
    }

    public Integer getTentosFlor() {
        return tentosFlor;
    }

    public void setTentosFlor(Integer tentosFlor) {
        this.tentosFlor = tentosFlor;
    }

    public int getTriedEnvidoBluffs() {
        return triedEnvidoBluffs;
    }

    public void setTriedEnvidoBluffs(int triedEnvidoBluffs) {
        this.triedEnvidoBluffs = triedEnvidoBluffs;
    }

    public int getEnvidoBluffCanBeDetected() {
        return envidoBluffCanBeDetected;
    }

    public void setEnvidoBluffCanBeDetected(int envidoBluffCanBeDetected) {
        this.envidoBluffCanBeDetected = envidoBluffCanBeDetected;
    }

    public int getEnvidoBluffSuccessful() {
        return envidoBluffSuccessful;
    }

    public void setEnvidoBluffSuccessful(int envidoBluffSuccessful) {
        this.envidoBluffSuccessful = envidoBluffSuccessful;
    }

    public int getTriedFlorBluffs() {
        return triedFlorBluffs;
    }

    public void setTriedFlorBluffs(int triedFlorBluffs) {
        this.triedFlorBluffs = triedFlorBluffs;
    }

    public int getFlorBluffCanBeDetected() {
        return florBluffCanBeDetected;
    }

    public void setFlorBluffCanBeDetected(int florBluffCanBeDetected) {
        this.florBluffCanBeDetected = florBluffCanBeDetected;
    }

    public int getFlorBluffSuccessful() {
        return florBluffSuccessful;
    }

    public void setFlorBluffSuccessful(int florBluffSuccessful) {
        this.florBluffSuccessful = florBluffSuccessful;
    }

    public int getTriedTrucoBluffs() {
        return triedTrucoBluffs;
    }

    public void setTriedTrucoBluffs(int triedTrucoBluffs) {
        this.triedTrucoBluffs = triedTrucoBluffs;
    }

    public int getTrucoBluffCanBeDetected() {
        return trucoBluffCanBeDetected;
    }

    public void setTrucoBluffCanBeDetected(int trucoBluffCanBeDetected) {
        this.trucoBluffCanBeDetected = trucoBluffCanBeDetected;
    }

    public int getTrucoBluffSuccessful() {
        return trucoBluffSuccessful;
    }

    public void setTrucoBluffSuccessful(int trucoBluffSuccessful) {
        this.trucoBluffSuccessful = trucoBluffSuccessful;
    }

    public int getTriedCardBluffs() {
        return triedCardBluffs;
    }

    public void setTriedCardBluffs(int triedCardBluffs) {
        this.triedCardBluffs = triedCardBluffs;
    }

    public int getCardBluffCanBeDetected() {
        return cardBluffCanBeDetected;
    }

    public void setCardBluffCanBeDetected(int cardBluffCanBeDetected) {
        this.cardBluffCanBeDetected = cardBluffCanBeDetected;
    }

    public int getCardBluffSuccessful() {
        return cardBluffSuccessful;
    }

    public void setCardBluffSuccessful(int cardBluffSuccessful) {
        this.cardBluffSuccessful = cardBluffSuccessful;
    }

    public int getBluffCanBeDetected() {
        return bluffCanBeDetected;
    }

    public void setBluffCanBeDetected(int bluffCanBeDetected) {
        this.bluffCanBeDetected = bluffCanBeDetected;
    }

    public void initHand() {

        agentCards = new ArrayList<>();
        //agentHandCards = new ArrayList<>();
        agentPlayedCards = new LinkedList<>();
        opponentPlayedCards = new LinkedList<>();
        dealtCards = new LinkedList<>();
        rounds = new LinkedList<>();

        envidoHistory = new LinkedList<>();
        trucoHistory = new LinkedList<>();
        florHistory = new LinkedList<>();
        cardHistory = new LinkedList<>();

        envidoPoints = 0;
        opponentEnvidoPoints = 0;

        isWinnerRound1 = false;
        isEmpateRound1 = false;

        isWinnerRound2 = false;
        isEmpateRound2 = false;

        isWinnerRound3 = false;
        isEmpateRound3 = false;

        opponentCartaVirada = 0;
        agentCartaVirada = 0;

        turno  = false;
        token  = false;
        isPlaying = false;
        envido = false;
        flor = false;
        truco = false;
        isLastRaise = false;
        trucoLevel = 0;
        florLevel = 0;
        envidoLevel = 0;
        isLastFlorRaise = false;
        isLastEnvidoRaise = false;

        envidoSize = 0;
        trucoSize = 0;
        florSize = 0;

        currentRound = 1;

        stateDecisionToken = null;
        stateDecisionTurn = null;

        isResultRound1 = false;
        isResultRound2 = false;
        isResultRound2 = false;

        round1 = null;
        round2 = null;
        round3 = null;

        idPartida = null;

        triedEnvidoBluffs = 0;
        envidoBluffCanBeDetected = 0;
        envidoBluffSuccessful = 0;

        triedFlorBluffs = 0;
        florBluffCanBeDetected = 0;
        florBluffSuccessful = 0;

        triedTrucoBluffs = 0;
        trucoBluffCanBeDetected = 0;
        trucoBluffSuccessful = 0;

        triedCardBluffs = 0;
        cardBluffCanBeDetected = 0;
        cardBluffSuccessful = 0;

        bluffCanBeDetected = 0;

    }

    public boolean isPlayedCard(LinkedList<Card> list, Card card) {

        for (Card c : list) {
            if (c.getFace() == card.getFace() && c.getSuit()==card.getSuit()) {
                return true;
            }
        }

        return false;
    }

    public int getEnvidoPoints(ArrayList<Card> cards) {
        HashMap<Suit, ArrayList<Card>> cardsBySuit = new HashMap<>();

        cards.forEach(card -> {
            if (card != null) {
                if (!cardsBySuit.containsKey(card.getSuit())) {
                    cardsBySuit.put(card.getSuit(), new ArrayList<>());
                }
                cardsBySuit.get(card.getSuit()).add(card);
            }
        });

        int modeLength = 0;
        Suit modeSuit = Suit.ESPADAS;

        for(Suit suit : cardsBySuit.keySet()){
            if(cardsBySuit.get(suit).size() > modeLength){
                modeLength = cardsBySuit.get(suit).size();
                modeSuit = suit;
            }
        }
        int envidoPoints = 0;

        if(modeLength > 1) {
            ArrayList<Card> envidoCards = cardsBySuit.get(modeSuit);
            envidoPoints = 20;

            for(Card card : envidoCards){
                envidoPoints += card.getFace().getValue();
            }
            return envidoPoints;
        } else {
            for(Card card : cards) {
                if(card.getFace().getValue() > envidoPoints)
                {
                    envidoPoints = card.getFace().getValue();
                }
            }
            return envidoPoints;
        }
    }

    public void addCardTable(Card card){

        dealtCards.add(card);

        if (dealtCards.size() < 2) {
            currentRound = 1;
        } else if (dealtCards.size() >= 2 && dealtCards.size() < 4) {
            currentRound = 2;
        } else  {
            currentRound = 3;
        }
    }

    public void processaRound(Card card, int player){

        switch (dealtCards.size()){
            case 1:
                round1 = new Round();
                if (player == 1) {
                    if (card != null) {
                        round1.setPlayer1Card(card);
                    } else {
                        round1.setFaceDownCardPlayer1(true);
                    }
                } else {
                    if (card != null) {
                        round1.setPlayer2Card(card);
                    } else {
                        round1.setFaceDownCardPlayer2(true);
                    }
                }
                break;
            case 2:
                if (player == 1) {
                    if (card != null) {
                        round1.setPlayer1Card(card);
                    } else {
                        round1.setFaceDownCardPlayer1(true);
                    }
                } else {
                    if (card != null) {
                        round1.setPlayer2Card(card);
                    } else {
                        round1.setFaceDownCardPlayer2(true);
                    }
                }
                compareCards(round1);
                rounds.add(round1);
                break;
            case 3:
                round2 = new Round();
                if (player == 1) {
                    if (card != null) {
                        round2.setPlayer1Card(card);
                    } else {
                        round2.setFaceDownCardPlayer1(true);
                    }
                } else {
                    if (card != null) {
                        round2.setPlayer2Card(card);
                    } else {
                        round2.setFaceDownCardPlayer2(true);
                    }
                }
                break;
            case 4:
                if (player == 1) {
                    if (card != null) {
                        round2.setPlayer1Card(card);
                    } else {
                        round2.setFaceDownCardPlayer1(true);
                    }
                } else {
                    if (card != null) {
                        round2.setPlayer2Card(card);
                    } else {
                        round2.setFaceDownCardPlayer2(true);
                    }
                }
                compareCards(round2);
                rounds.add(round2);
                break;
            case 5:
                round3 = new Round();
                if (player == 1) {
                    if (card != null) {
                        round3.setPlayer1Card(card);
                    } else {
                        round3.setFaceDownCardPlayer1(true);
                    }
                } else {
                    if (card != null) {
                        round3.setPlayer2Card(card);
                    } else {
                        round3.setFaceDownCardPlayer2(true);
                    }
                }
                break;
            case 6:
                if (player == 1) {
                    if (card != null) {
                        round3.setPlayer1Card(card);
                    } else {
                        round3.setFaceDownCardPlayer1(true);
                    }
                } else {
                    if (card != null) {
                        round3.setPlayer2Card(card);
                    } else {
                        round3.setFaceDownCardPlayer2(true);
                    }
                }
                compareCards(round3);
                rounds.add(round3);
                break;
        }

    }

    public void compareCards(Round round) {

        if (round.isFaceDownCardPlayer1() || round.isFaceDownCardPlayer2()) {
            if (round.isFaceDownCardPlayer1() && round.isFaceDownCardPlayer2()) {
                round.setWinner(0);
                round.setResult(0);
            } else if (!round.isFaceDownCardPlayer1() && round.isFaceDownCardPlayer2()) {
                round.setWinner(1);
                round.setResult(1);
            } else {
                round.setWinner(2);
                round.setResult(2);
            }
        } else {
            if (round.getPlayer1Card().getCbrCode() > round.getPlayer2Card().getCbrCode()) {
                round.setWinner(1);
                round.setResult(1);
            } else if (round.getPlayer1Card().getCbrCode() < round.getPlayer2Card().getCbrCode()) {
                round.setWinner(2);
                round.setResult(2);
            } else {
                round.setWinner(0);
                round.setResult(0);
            }
        }
    }

    /**
     * Se empatar na primeira rodada, quem ganhar a segunda vence a mão;
     * Se empatar na segunda rodada, quem ganhou a primeira vence a mão;
     * Se empatar na primeira e segunda rodadas, quem ganhar a terceira vence a mão;
     * Se empatar na terceira rodada, quem ganhou a primeira vence a mão;
     * Se todas as três rodadas empatarem, quem iniciou a mão vence a mão.  */

    public Boolean isHandFinish() {
        Boolean isHandFinish = false;
        if (rounds.size() == 2) {
            if (rounds.getFirst().getResult() != 0 && rounds.getFirst().getResult() == rounds.getLast().getResult()) {
                isHandFinish = true;
            } else if (rounds.getFirst().getResult() != 0 && rounds.getLast().getResult() == 0) {
                isHandFinish = true;
            } else if (rounds.getFirst().getResult() == 0 && rounds.getLast().getResult() != 0) {
                isHandFinish = true;
            }
        }

        if (rounds.size() == 3) {
            isHandFinish = true;
        }
        return isHandFinish;
    }

    public Card getLastCardHand() {

        Card card;

        if (!isPlayedCard(getAgentPlayedCards(), getAgentCards().get(0))) {
            card =  getAgentCards().get(0);
        } else if (!isPlayedCard(getAgentPlayedCards(), getAgentCards().get(1))) {
            card = getAgentCards().get(1);
        } else {
            card = getAgentCards().get(2);
        }

        return card;

    }

    public ArrayList<Card> getHandCards() {

        ArrayList<Card> handCards = new ArrayList<>();

        if (!isPlayedCard(getAgentPlayedCards(), getAgentCards().get(0))) {
            handCards.add(getAgentCards().get(0));
        }

        if (!isPlayedCard(getAgentPlayedCards(), getAgentCards().get(1))) {
            handCards.add(getAgentCards().get(1));
        }

        if (!isPlayedCard(getAgentPlayedCards(), getAgentCards().get(2))) {
            handCards.add(getAgentCards().get(2));
        }

        return handCards;

    }


    public boolean isFinishGame() {
        return agentPoints >= 24 || opponentPoints >= 24;
    }

    public boolean isEnvidoPossible(int cbrCode, int pontos) {

        boolean isPossible = false;

        if (pontos == 33) {
            if (cbrCode == 4 || cbrCode == 42 || cbrCode == 40 || cbrCode == 3)
                isPossible = true;
        } else if (pontos == 32) {
            if (cbrCode == 2 || cbrCode == 4 || cbrCode == 42 || cbrCode == 40)
                isPossible = true;
        } else if (pontos == 31) {
            if (cbrCode == 1 || cbrCode == 4 || cbrCode == 42 || cbrCode == 40 || cbrCode == 2 || cbrCode == 3)
                isPossible = true;
        } else if (pontos == 30) {
            if (cbrCode == 24 || cbrCode == 4 || cbrCode == 42 || cbrCode == 40 || cbrCode == 1 || cbrCode == 3)
                isPossible = true;
        } else if (pontos == 29) {
            if (cbrCode == 16 || cbrCode == 4 || cbrCode == 42 || cbrCode == 40 || cbrCode == 24 || cbrCode == 3 ||
                    cbrCode == 1 || cbrCode == 2 )
                isPossible = true;
        } else if (pontos == 28) {
            if (cbrCode == 12 || cbrCode == 52 || cbrCode == 50 || cbrCode == 4 || cbrCode == 42 || cbrCode == 40 ||
                    cbrCode == 16 || cbrCode == 3 || cbrCode == 24 || cbrCode == 2 )
                isPossible = true;
        } else if (pontos == 27) {
            if (cbrCode == 12 || cbrCode == 52 || cbrCode == 50 || cbrCode == 6 || cbrCode == 7 || cbrCode == 8 ||
                    cbrCode == 16 || cbrCode == 24 || cbrCode == 1 || cbrCode == 2 || cbrCode == 3 || cbrCode == 4 ||
                    cbrCode == 42 || cbrCode == 40)
                isPossible = true;
        } else if (pontos == 26) {
            if (cbrCode == 12 || cbrCode == 52 || cbrCode == 50 || cbrCode == 6 || cbrCode == 7 || cbrCode == 8 ||
                    cbrCode == 16 || cbrCode == 1 || cbrCode == 2 || cbrCode == 3)
                isPossible = true;
        } else if (pontos == 25) {
            if (cbrCode == 12 || cbrCode == 52 || cbrCode == 50 || cbrCode == 6 || cbrCode == 7 || cbrCode == 8 ||
                    cbrCode == 16 || cbrCode == 24 || cbrCode == 1 || cbrCode == 2)
                isPossible = true;
        } else if (pontos == 24) {
            if (cbrCode == 12 || cbrCode == 52 || cbrCode == 50 || cbrCode == 6 || cbrCode == 7 || cbrCode == 8 ||
                    cbrCode == 24 || cbrCode == 1)
                isPossible = true;
        } else if (pontos == 23) {
            if (cbrCode == 12 || cbrCode == 52 || cbrCode == 50 || cbrCode == 6 || cbrCode == 7 || cbrCode == 8 ||
                    cbrCode == 16 || cbrCode == 24)
                isPossible = true;
        } else if (pontos == 22) {
            if (cbrCode == 12 || cbrCode == 52 || cbrCode == 50 || cbrCode == 6 || cbrCode == 7 || cbrCode == 8 || cbrCode == 16)
                isPossible = true;
        } else if (pontos == 21) {
            if (cbrCode == 12 || cbrCode == 52 || cbrCode == 50 || cbrCode == 6 || cbrCode == 7 || cbrCode == 8)
                isPossible = true;
        } else if (pontos == 20) {
            if (cbrCode == 6 || cbrCode == 7 || cbrCode == 8)
                isPossible = true;
        } else if (pontos == 7) {
            if (cbrCode == 4 || cbrCode == 42 || cbrCode == 40)
                isPossible = true;
        } else if (pontos == 6) {
            if (cbrCode == 3)
                isPossible = true;
        } else if (pontos == 5) {
            if (cbrCode == 2)
                isPossible = true;
        } else if (pontos == 4) {
            if (cbrCode == 1)
                isPossible = true;
        } else if (pontos == 3) {
            if (cbrCode == 24)
                isPossible = true;
        } else if (pontos == 2) {
            if (cbrCode == 16)
                isPossible = true;
        } else if (pontos == 1) {
            if (cbrCode == 12 || cbrCode == 52 || cbrCode == 50)
                isPossible = true;
        }

        return isPossible;
    }

    public String getStringAgentPlayedCards() {
        String cards = "";
        if (agentPlayedCards.size() > 0) {
            for (Card card : agentPlayedCards) {
                cards += card.getFace().name() + "-" + card.getSuit().name().substring(0,1) + "; ";
            }
        }
        return cards;
    }

    public String getStringHandCards() {

        String handCards = "";

        if (getHandCards().size() > 0) {
            for (Card card : getHandCards()) {
                handCards += getFaceAbrev(card.getFace()) + "-" + card.getSuit().name().substring(0,1) + "; ";
            }
        }

        return handCards;
    }

    public String getStringOpponentPlayedCards() {
        String cards = "";
        if (opponentPlayedCards.size() > 0) {
            for (Card card : opponentPlayedCards) {
                if (card != null) {
                    cards += getFaceAbrev(card.getFace()) + "-" + card.getSuit().name().substring(0,1) + "; ";
                } else {
                    cards += "Face Down Card;";
                }

            }
        }
        return cards;
    }

    public String getFaceAbrev(Face face) {
        String abrev = "";
        switch (face) {
            case AS:
                abrev = "1";
                break;
            case DOIS:
                abrev = "2";
                break;
            case TRES:
                abrev = "3";
                break;
            case QUATRO:
                abrev = "4";
                break;
            case CINCO:
                abrev = "5";
                break;
            case SEIS:
                abrev = "6";
                break;
            case SETE:
                abrev = "7";
                break;
            case DEZ:
                abrev = "10";
                break;
            case VALETE:
                abrev = "11";
                break;
            case REI:
                abrev = "12";
                break;
        }

        return abrev;
    }

}
