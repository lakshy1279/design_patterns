package org.example.Tic_Tac_Toe.multipleFloorElevator;

public class IdleState extends LiftState{
    IdleState(Lift lift) {
        super(lift);
    }

    @Override
    public char getDirection() {
        return 0;
    }

    @Override
    public int getTimeToReachFloor(int floor, char direction) {
        return 0;
    }
}
