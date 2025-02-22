package org.example.Tic_Tac_Toe.atm.CashWithdrawal;

import org.example.Tic_Tac_Toe.atm.Atm;

public class HundredWithdraw extends CashWithdrawalProcess{
    public HundredWithdraw(CashWithdrawalProcess process) {
        super(process);
    }

    @Override
    public void withdrawCash(Atm atm, int amount) {
        int reqNotes = amount / 100;
        int balance = amount % 100;
        if(atm.getHundredNotes() >= reqNotes)
        {
            atm.setHundredNotes(atm.getHundredNotes() - reqNotes);
            System.out.println("Hundred Notes Withdraw:" + " " +  reqNotes);
            balance =0;
        }
        if(balance != 0){
            System.out.println("Something went wrong");
        }
    }
}
