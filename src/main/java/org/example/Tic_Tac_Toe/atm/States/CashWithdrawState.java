package org.example.Tic_Tac_Toe.atm.States;

import org.example.Tic_Tac_Toe.atm.Atm;
import org.example.Tic_Tac_Toe.atm.CashWithdrawal.CashWithdrawalProcess;
import org.example.Tic_Tac_Toe.atm.CashWithdrawal.FiveHunwithdrawProcess;
import org.example.Tic_Tac_Toe.atm.CashWithdrawal.HundredWithdraw;
import org.example.Tic_Tac_Toe.atm.CashWithdrawal.TwoThousandWithdraw;
import org.example.Tic_Tac_Toe.atm.Factory.AtmStateFactory;

public class CashWithdrawState extends AtmStates{

    Atm atm;
    public CashWithdrawState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void withdrawMoney(int amount) {
        System.out.println("Withdrawing " + amount);
        if(atm.getBalance() < amount){
            System.out.println("Insufficient balance");
            return;
        }
        CashWithdrawalProcess process = new TwoThousandWithdraw(new FiveHunwithdrawProcess(new HundredWithdraw(null)));
        process.withdrawCash(atm, amount);
        atm.setBalance(atm.getBalance() - amount);
        System.out.println("Please Collect your Cash");
        ejectCard();
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
