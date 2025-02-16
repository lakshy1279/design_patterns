package org.example.Tic_Tac_Toe.atm.States;

import org.example.Tic_Tac_Toe.atm.Atm;

public interface AtmStates {
    void enterPin(String pin);
    void withdrawMoney(int amount);
    void insertCard(String card);
    void cancelTransaction();
    void ejectCard();
}
