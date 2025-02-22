package org.example.Tic_Tac_Toe.atm.States;

import org.example.Tic_Tac_Toe.atm.Card;

public abstract class  AtmStates {
    public void enterPin(String pin){
        System.out.println("Not allowed");
    };
    public void withdrawMoney(int amount){
        System.out.println("Not allowed");
    };
    public void insertCard(Card card){
        System.out.println("Not allowed");
    };

    public void selectMethod(String option){
        System.out.println("Not allowed jnewn");
    };

    public  void cancelTransaction() {
        System.out.println("Not allowed jrndkjdn");
    }
    public void selectMethod() {
        System.out.println("Not allowed");
    }
    public void ejectCard(){
        System.out.println("Not allowed");
    };
}
