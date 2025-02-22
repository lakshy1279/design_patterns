package org.example.Tic_Tac_Toe.snakeLadder.Models;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Board {
    Cell[][] cells;
    private int size;
    public Board(int size) {
        this.size = size;
        cells = new Cell[size][size];
        initializeCell();
    }

    void initializeCell(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void setJumpToCell(int x, int y, Jump jump) {
        cells[x][y].setJump(jump);
    }

    public boolean isJumpInCell(int x, int y){
        return cells[x][y].getJump() != null;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }
}
