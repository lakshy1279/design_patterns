package org.example.Tic_Tac_Toe.snakeLadder;

import org.example.Tic_Tac_Toe.snakeLadder.Models.Board;
import org.example.Tic_Tac_Toe.snakeLadder.Models.Dice;
import org.example.Tic_Tac_Toe.snakeLadder.Models.Jump;
import org.example.Tic_Tac_Toe.snakeLadder.Models.Player;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players;
    Player winner;
    public Game() {
        intializeGame();
    }

    void intializeGame() {
        board = new Board(10, 5, 4);
        players = new LinkedList<>();
        setPlayers();
        dice = new Dice(1);
        winner = null;
    }

    Player getNextPlayerTurn(){
        return players.pollFirst();
    }

    public void startGame(){
        while(winner == null){
            Player currentPlayer = getNextPlayerTurn();
            int diceValue = dice.rollDice();
            int currentPos = currentPlayer.getCurrPos();
            int nextPos = currentPos + diceValue;
            System.out.println("Current position: " + currentPos + " Next: " + nextPos + " " + "Player: " + currentPlayer.getId());
            if(nextPos >= board.getSize()*board.getSize()){
                winner = currentPlayer;
                System.out.println("Winner is " + winner.getId());
                break;
            }
            boolean isJumpInNextPos = board.isJumpInCell(nextPos);
            if(isJumpInNextPos){
                Jump jump = board.getCell(nextPos).getJump();
                System.out.println("Taking Jump: " + jump.getStart() + " " + jump.getEnd());
                nextPos = jump.getEnd();
            }
            currentPlayer.setCurrPos(nextPos);
            players.addLast(currentPlayer);
        }
    }

    void setPlayers() {
        Player player1 = new Player();
        Player player2 = new Player();
        players.add(player1);
        players.add(player2);
    }
}
