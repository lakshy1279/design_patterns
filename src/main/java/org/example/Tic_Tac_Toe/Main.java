package org.example.Tic_Tac_Toe;

import org.example.Tic_Tac_Toe.atm.States.AtmStates;
import org.example.Tic_Tac_Toe.atm.States.IdleState;
import org.example.Tic_Tac_Toe.logger.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = new InfoLog(new WarningLog( new ErrorLog()));
        logger.log(LoggerType.INFO.getValue(), "ndndnn");
        logger.log(LoggerType.WARNING.getValue(), "nddbddndnn");
        logger.log(LoggerType.ERROR.getValue(), "djsbdwdb");
        logger.log(6, "djsbdwdb");
    }
}