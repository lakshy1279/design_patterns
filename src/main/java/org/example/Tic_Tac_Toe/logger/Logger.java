package org.example.Tic_Tac_Toe.logger;

public abstract class Logger {
    Logger nextLogger;
     static int INFO = 1;
     static int WARNING = 2;
     static int ERROR = 3;
     Logger(Logger logger) {
        this.nextLogger = logger;
    }

    public  void log(int type, String message){
        if(nextLogger != null){
            nextLogger.log(type, message);
        }
    };
}
