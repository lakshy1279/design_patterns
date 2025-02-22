package org.example.Tic_Tac_Toe.snakeLadder.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public class Dice {
   int diceCount;
   public Dice(int diceCount){
       this.diceCount = diceCount;
   }

   public int rollDice(){
       int nextPosition = 0;
       int riceRole = 0;
       while(riceRole < this.diceCount){
           int random = ThreadLocalRandom.current().nextInt(1, 7);
           nextPosition += random;
           riceRole++;
       }
       return nextPosition;
   }
}
