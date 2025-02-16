package org.example.Tic_Tac_Toe.atm.States;

import org.example.Tic_Tac_Toe.atm.Atm;
import org.example.Tic_Tac_Toe.atm.Factory.AtmStateFactory;

public class CashWithdrawState implements AtmStates{

    Atm atm;
    public CashWithdrawState(Atm atm) {
        this.atm = atm;
    }
    @Override
    public void enterPin(String pin) {
        System.out.println("Pin already entered");
    }

    @Override
    public void withdrawMoney(int amount) {
        if(atm.getBalance() < amount){
            System.out.println("Insufficient balance");
            return;
        }
        atm.setBalance(atm.getBalance() - amount);
        System.out.println("Please Collect your Cash");
        atm.setState(AtmStateFactory.getAtmState(atm, "idleState"));
    }

    @Override
    public void insertCard(String card) {
        System.out.println("Not allowed");
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
