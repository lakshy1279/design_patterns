package org.example.Tic_Tac_Toe.atm.CashWithdrawal;

import org.example.Tic_Tac_Toe.atm.Atm;

public abstract class CashWithdrawalProcess {
    CashWithdrawalProcess  next;
    public CashWithdrawalProcess(CashWithdrawalProcess process){
        this.next = process;
    }

    public void withdrawCash(Atm atm, int amount){
        if(next != null){
            next.withdrawCash(atm, amount);
        }
    }
}
