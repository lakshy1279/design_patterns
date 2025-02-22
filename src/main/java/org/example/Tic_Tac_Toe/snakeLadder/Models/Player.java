package org.example.Tic_Tac_Toe.snakeLadder.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Player {
    private String id;
    private int  currPos;
    public Player(){
        this.id = UUID.randomUUID().toString();
        this.currPos = 0;
    }
}
