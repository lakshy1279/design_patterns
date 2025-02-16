package org.example.Tic_Tac_Toe.atm.States;

import org.example.Tic_Tac_Toe.atm.Atm;
import org.example.Tic_Tac_Toe.atm.Factory.AtmStateFactory;

public class CardInsertedState implements AtmStates{
    Atm atm;
    public CardInsertedState(Atm atm) {
        this.atm = atm;
    }
    @Override
    public void enterPin(String pin) {
        System.out.println("Pin entered");
        // pin valiadation api call to bank
        // if wrong pin throw error
        atm.setState(AtmStateFactory.getAtmState(atm, "cashWithdrawal"));
    }

    @Override
    public void withdrawMoney( int amount) {
        System.out.println("Enter Pin first");
    }

    @Override
    public void insertCard(String card) {
        System.out.println("Card already inserted");
    }

    @Override
    public void cancelTransaction() {

    }

    @Override
    public void ejectCard() {
        System.out.println("Card Ejected");
        atm.setState(AtmStateFactory.getAtmState(atm, "idleState"));
    }
}
