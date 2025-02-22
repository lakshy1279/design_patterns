package org.example.Tic_Tac_Toe.atm.CashWithdrawal;

import org.example.Tic_Tac_Toe.atm.Atm;

public class FiveHunwithdrawProcess extends CashWithdrawalProcess{
    public FiveHunwithdrawProcess(CashWithdrawalProcess process) {
        super(process);
    }

    @Override
    public void withdrawCash(Atm atm, int amount) {
            int notes = amount / 500;
            int noteCount = Math.min(atm.getFiveHundredNotes(), notes);
            int remainder = amount - noteCount*500;
            atm.setFiveHundredNotes(atm.getFiveHundredNotes() - noteCount);
            System.out.println("FiveHundred Notes Withdraw:" + " " +  noteCount);
            if(remainder > 0)
                super.withdrawCash(atm, remainder);
    }
}
