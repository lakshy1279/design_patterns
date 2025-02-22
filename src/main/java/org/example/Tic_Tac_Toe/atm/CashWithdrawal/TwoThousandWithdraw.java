package org.example.Tic_Tac_Toe.atm.CashWithdrawal;

import org.example.Tic_Tac_Toe.atm.Atm;

public class TwoThousandWithdraw extends CashWithdrawalProcess{
    public TwoThousandWithdraw(CashWithdrawalProcess process) {
        super(process);
    }

    @Override
    public void withdrawCash(Atm atm, int amount) {
        if(amount < 2000)
         super.withdrawCash(atm, amount);
        else{
            int notes = amount / 2000;
            int noteCount = Math.min(atm.getTwoThousandNotes(), notes);
            int remainder = amount - noteCount*2000;
            atm.setTwoThousandNotes(atm.getTwoThousandNotes() - noteCount);
            System.out.println("Two Housand notes withdraw:" + " " + noteCount);
            if(remainder > 0)
                super.withdrawCash(atm, remainder);
        }
    }
}
