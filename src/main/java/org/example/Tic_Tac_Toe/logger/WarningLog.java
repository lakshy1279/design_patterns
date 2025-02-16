package org.example.Tic_Tac_Toe.logger;

public class WarningLog extends Logger {
    public WarningLog(Logger logger) {
        super(logger);
    }
    @Override
    public void log(int type, String message) {
        if(type == WARNING){
            System.out.println("Warning" + " " + message);
        }
        nextLogger.log(type, message);
    }
}
