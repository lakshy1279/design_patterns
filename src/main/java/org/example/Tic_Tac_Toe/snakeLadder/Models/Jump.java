package org.example.Tic_Tac_Toe.snakeLadder.Models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jump {
    private int start;
    private int end;
    public Jump(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
