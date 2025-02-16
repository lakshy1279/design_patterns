package org.example.Tic_Tac_Toe.logger;

public class InfoLog extends Logger{

    public InfoLog(Logger logger) {
        super(logger);
    }
    @Override
    public void log(int type, String message) {
        if(type == LoggerType.INFO.getValue()){
            System.out.println("Info" + " " + message);
        }
        else
         nextLogger.log(type, message);
    }
}
