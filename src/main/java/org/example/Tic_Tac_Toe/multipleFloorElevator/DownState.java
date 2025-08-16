package org.example.Tic_Tac_Toe.multipleFloorElevator;

import java.util.List;

public class DownState extends LiftState{
    DownState(Lift lift) {
        super(lift);
    }

    @Override
    public char getDirection() {
        return 'D';
    }

    public void updateFloor() {
        int minFloor = getMinDownFloor();
        if(minFloor < lift.getCurrentFloor()) {
            lift.setCurrentFloor(lift.getCurrentFloor() - 1);
        }
    }


    public void updateDirection() {
        if(lift.getCurrentFloor() <= getMinDownFloor())
            lift.setState('U');
    }

    @Override
    public int getTimeToReachFloor(int floor, char direction) {
        int minFloor = getMinDownFloor();
        int currentFloor = lift.getCurrentFloor();
        boolean hasStopInOppDirc = lift.hasStopInOppositeDirection();
        if(hasStopInOppDirc && minFloor > floor) { return -1;};
        if(direction == 'D') {
           if(floor < minFloor) return -1;
           if(floor == currentFloor) return 0;
        }
        if(floor < currentFloor) return floor - currentFloor;
        return currentFloor - minFloor + floor - minFloor;
    }

    private int getMinDownFloor() {
        List<LiftRequest> req = lift.getRequests();
        int minFloor = 1000*1000;
        for(LiftRequest req1 : req) {
            if(minFloor > req1.getStartFloor()){
                minFloor = req1.getStartFloor();
            }
            if(minFloor > req1.getDestinationFloor()){
                minFloor = req1.getDestinationFloor();
            }
        }
        return minFloor;
    }
}
