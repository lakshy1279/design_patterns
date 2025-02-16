package org.example.Tic_Tac_Toe.atm.States;

import org.example.Tic_Tac_Toe.atm.Atm;
import org.example.Tic_Tac_Toe.atm.Factory.AtmStateFactory;

public class IdleState implements AtmStates {
    Atm atm;

    public IdleState(Atm atm) {
        System.out.println("Atm in Idle State");
        this.atm = atm;
    }

    @Override
    public void enterPin( String pin) {
        System.out.println("First insert card");
    }

    @Override
    public void withdrawMoney( int amount) {
        System.out.println("First insert card");
    }

    @Override
    public void insertCard( String card) {
        System.out.println("Card Inserted");
        atm.setState(AtmStateFactory.getAtmState(atm, "insertCard"));
    }

    @Override
    public void cancelTransaction() {

    }

    @Override
    public void ejectCard() {
        System.out.println("Not allowed");
    }
}
