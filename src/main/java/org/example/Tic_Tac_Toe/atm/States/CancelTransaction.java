package org.example.Tic_Tac_Toe.atm.States;

import org.example.Tic_Tac_Toe.atm.Atm;
import org.example.Tic_Tac_Toe.atm.Factory.AtmStateFactory;

public class CancelTransaction implements AtmStates {

    Atm atm;
    public CancelTransaction(Atm atm) {
        this.atm = atm;
    }
    @Override
    public void enterPin(String pin) {

    }

    @Override
    public void withdrawMoney(int amount) {

    }

    @Override
    public void insertCard(String card) {

    }

    @Override
    public void cancelTransaction() {
       atm.setState(AtmStateFactory.getAtmState(atm, "idleState"));
    }

    @Override
    public void ejectCard() {
        atm.setState(AtmStateFactory.getAtmState(atm, "idleState"));
    }
}
