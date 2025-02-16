package org.example.Tic_Tac_Toe.atm;

import org.example.Tic_Tac_Toe.atm.States.AtmStates;
import org.example.Tic_Tac_Toe.atm.States.IdleState;

public class Atm {
    int balance;
    AtmStates state;
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

    public AtmStates getState() {
        return state;
    }
}
