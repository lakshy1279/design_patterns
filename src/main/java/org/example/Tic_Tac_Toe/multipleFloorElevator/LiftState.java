package org.example.Tic_Tac_Toe.multipleFloorElevator;

public abstract class LiftState {
    protected Lift lift;
    LiftState(Lift lift) {
       this.lift = lift;
    }

    public void updateFloor() {

    }

    public void updateDirection() {

    }

    public abstract char getDirection();

    public abstract int getTimeToReachFloor(int floor, char direction);
}
