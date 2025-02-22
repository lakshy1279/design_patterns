package org.example.Tic_Tac_Toe.atm.States;

import org.example.Tic_Tac_Toe.atm.Atm;
import org.example.Tic_Tac_Toe.atm.Card;
import org.example.Tic_Tac_Toe.atm.Factory.AtmStateFactory;

public class IdleState extends AtmStates {
    Atm atm;

    public IdleState(Atm atm) {
        System.out.println("Atm in Idle State");
        this.atm = atm;
    }

    public void insertCard(Card card) {
        System.out.println("Card Inserted");
        atm.setState(AtmStateFactory.getAtmState(atm, "insertCard"));
    }
}
