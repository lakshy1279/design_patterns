package org.example.Tic_Tac_Toe.logger;

public enum LoggerType {
    INFO(1),
    WARNING(2),
    ERROR(3);
    private int value;
    LoggerType(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
