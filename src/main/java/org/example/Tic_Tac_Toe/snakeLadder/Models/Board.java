package org.example.Tic_Tac_Toe.snakeLadder.Models;


import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Setter
@Getter
public class Board {
    Cell[][] cells;
    private int size;
    public Board(int size, int snake, int ladder) {
        this.size = size;
        cells = new Cell[size][size];
        initializeCell();
        addSnakeAndLadder(snake, ladder);
    }

    void initializeCell(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    void addSnakeAndLadder(int snakeCount, int ladderCount){
        int minBound = 1;
        int maxBound = this.size*this.size - 2;
        while(snakeCount > 0) {
            int snakeStart =  ThreadLocalRandom.current().nextInt(minBound, maxBound);
            int snakeEnd =  ThreadLocalRandom.current().nextInt(minBound, maxBound);
            if(snakeEnd >  snakeStart)
                continue;
            Jump jump = new Jump(snakeStart, snakeEnd);
            int startCellRow = snakeStart/this.size;
            int startCellCol = snakeStart%this.size;
            System.out.println("Add snake " + startCellRow + " " + startCellCol);
            setJumpToCell(startCellRow, startCellCol, jump);
            snakeCount--;
        }

        while(ladderCount > 0) {
            int ladderStart =  ThreadLocalRandom.current().nextInt(minBound, maxBound);
            int ladderEnd =  ThreadLocalRandom.current().nextInt(minBound, maxBound);
            if(ladderEnd > ladderStart)
                continue;
            Jump jump = new Jump(ladderStart, ladderEnd);
            int startCellRow = ladderStart /this.size;
            int startCellCol = ladderStart %this.size;
            System.out.println("Add snake " + startCellRow + " " + startCellCol);
            setJumpToCell(startCellRow, startCellCol, jump);
            ladderCount--;
        }
    }

    public void setJumpToCell(int x, int y, Jump jump) {
        cells[x][y].setJump(jump);
    }

    public boolean isJumpInCell(int pos){
        int x = pos / size;
        int y = pos % size;
        return cells[x][y].getJump() != null;
    }

    public Cell getCell(int pos) {
        int x = pos / size;
        int y = pos % size;
        return cells[x][y];
    }
}
