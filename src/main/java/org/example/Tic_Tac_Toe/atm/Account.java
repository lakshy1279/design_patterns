package org.example.Tic_Tac_Toe.atm;

public class Account {
    String accNumber;
    double balance;
    public Account(String accNumber, double balance) {
        this.accNumber = accNumber;
        this.balance = balance;
    }
    public String getAccNumber() {
        return accNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
