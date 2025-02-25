package org.example.Tic_Tac_Toe.atm.Factory;

import org.example.Tic_Tac_Toe.atm.Atm;
import org.example.Tic_Tac_Toe.atm.States.*;

public class AtmStateFactory {
    public static AtmStates getAtmState(Atm atm, String type){
        switch (type){
            case "idleState":
                return new IdleState(atm);

            case "insertCard":
                return new CardInsertedState(atm);

            case "cashWithdrawal":
                return new CashWithdrawState(atm);

            case "operationSelect":
                return new SelectOperations(atm);

        }
        return null;
    }
}
