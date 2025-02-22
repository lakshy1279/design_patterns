package org.example.Tic_Tac_Toe.atm;

public class Main {
    public static void main(String[] args) {
        Atm atm = new Atm();
        atm.setBalance(3600);
        Account account = new Account("3438493849032409", 5000);
        Card card = new Card("32493473983902", account);
        atm.setCard(card);
        atm.getState().insertCard(atm.getCard());
        atm.getState().enterPin("1234");
        atm.getState().selectMethod("CashWithdrawal");
        atm.getState().withdrawMoney(2700);


    }
}
