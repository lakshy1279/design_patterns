package org.example.Tic_Tac_Toe.multipleFloorElevator;

import java.util.List;

public class UpState extends LiftState {
    public UpState(Lift lift) {
        super(lift);
    }

    @Override
    public char getDirection() {
        return 'U';
    }

    public void updateFloor() {
        int maxFloor = getMaxUpFloor();
        if(maxFloor > lift.getCurrentFloor()) {
            lift.setCurrentFloor(lift.getCurrentFloor() + 1);
        }
    }


    public void updateDirection() {
       if(lift.getCurrentFloor() >= getMaxUpFloor())
           lift.setState('D');
    }

    @Override
    public int getTimeToReachFloor(int floor, char direction) {
       int currentFloor = this.lift.getCurrentFloor();
       int maxUpFloor = getMaxUpFloor();
       boolean hasStopInOppDirc = lift.hasStopInOppositeDirection();
       if(floor > maxUpFloor && hasStopInOppDirc) {
           return -1;
       }
       if(direction == 'U') {
           if (floor == currentFloor) {
               return 0;
           };
           if (floor < currentFloor) {
               return -1;
           };
       }
       if(floor > maxUpFloor) {
           return floor - currentFloor;
       }
       return maxUpFloor - currentFloor + ( maxUpFloor - floor);
    }

    private int getMaxUpFloor() {
        List<LiftRequest> req = lift.getRequests();
        int maxFloor = 0;
        for(LiftRequest req1 : req) {
            if(maxFloor < req1.getStartFloor()){
                maxFloor = req1.getStartFloor();
            }
            if(maxFloor < req1.getDestinationFloor()){
                maxFloor = req1.getDestinationFloor();
            }
        }
        return maxFloor;
    }
}
