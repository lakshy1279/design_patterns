package org.example.Tic_Tac_Toe.logger;

public class ErrorLog extends Logger {

    public ErrorLog() {
        super(null);
    }
    @Override
    public void log(int type, String message) {
        if(type == LoggerType.ERROR.getValue()){
            System.out.println("Error" + " " + message);
        }
        super.log(type, message);
    }
}
