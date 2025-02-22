package org.example.Tic_Tac_Toe.atm;

import org.example.Tic_Tac_Toe.atm.States.AtmStates;
import org.example.Tic_Tac_Toe.atm.States.IdleState;

public class Atm {
    int balance;
    Card card;
    AtmStates state;
    int twoThousandNotes = 1;
    int fiveHundredNotes = 2;
    int hundredNotes = 6;
    Atm() {
        balance = 0;
        state = new IdleState(this);
    }
    public void setState(AtmStates state) {
        this.state = state;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public AtmStates getState() {
        return state;
    }

    public int getTwoThousandNotes() {
        return twoThousandNotes;
    }
    public void setTwoThousandNotes(int twoThousandNotes) {
        this.twoThousandNotes = twoThousandNotes;
    }
    public int getFiveHundredNotes() {
        return fiveHundredNotes;
    }
    public void setFiveHundredNotes(int fiveHundredNotes) {
        this.fiveHundredNotes = fiveHundredNotes;
    }
    public int getHundredNotes() {
        return hundredNotes;
    }
    public void setHundredNotes(int hundredNotes) {
        this.hundredNotes = hundredNotes;
    }
}
