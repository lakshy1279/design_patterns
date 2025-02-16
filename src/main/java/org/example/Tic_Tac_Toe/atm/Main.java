package org.example.Tic_Tac_Toe.atm;

import org.example.Tic_Tac_Toe.atm.States.AtmStates;

public class Main {
    public static void main(String[] args) {
        Atm atm = new Atm();
        atm.setBalance(10000);
        atm.getState().insertCard("8379837");
        atm.getState().enterPin("1234");
        atm.getState().cancelTransaction();
        atm.getState().withdrawMoney(1000);
    }
}
