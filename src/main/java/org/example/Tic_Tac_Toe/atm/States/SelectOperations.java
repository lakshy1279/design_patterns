package org.example.Tic_Tac_Toe.atm.States;

import org.example.Tic_Tac_Toe.atm.Atm;
import org.example.Tic_Tac_Toe.atm.Factory.AtmStateFactory;

public class SelectOperations extends AtmStates{
    Atm atm;
    public SelectOperations(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void selectMethod(String option){
        switch (option){
            case "CashWithdrawal":
                 atm.setState(AtmStateFactory.getAtmState(atm,"cashWithdrawal"));
                 break;
        }
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Cancelling transaction");
        ejectCard();
    }

    @Override
    public void ejectCard() {
        System.out.println("Card Ejected");
        atm.setState(AtmStateFactory.getAtmState(atm, "idleState"));
    }
}
