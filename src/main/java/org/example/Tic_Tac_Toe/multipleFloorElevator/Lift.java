package org.example.Tic_Tac_Toe.multipleFloorElevator;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Lift {
    private int currentFloor;
    private List<LiftRequest> requests;
    private LiftState movingUpState, movingDownState, idleState, state;
    public Lift() {
        this.currentFloor = 0;
        this.requests = new ArrayList<>();
        this.movingUpState = new UpState(this);
        this.movingDownState = new DownState(this);
        this.idleState = new IdleState(this);
        this.state = idleState;
    }

    public boolean hasStopInOppositeDirection() {
        char direction = state.getDirection();
        if(direction == 'I')
            return false;
        for(LiftRequest liftRequest : requests) {
            if(liftRequest.getMoveDirection() != state.getDirection())
                return true;
        }
        return false;
    }

    public int getTimeToReachFloor(int floor, char direction){
        return state.getTimeToReachFloor(floor, direction);
    }

    public int countPeople(int floor, char direction) {
        int people = 0;
        for(LiftRequest liftRequest : requests) {
            if(liftRequest.getMoveDirection() == direction){
                if(direction=='U' && floor>=liftRequest.getStartFloor()
                        && floor<liftRequest.getDestinationFloor()) people++;
                else if(direction=='D' && floor<=liftRequest.getStartFloor()
                        && floor>liftRequest.getDestinationFloor()) people++;
            }
        }
        return people;
    }

    public boolean hasSpace(int startFloor, int destinationFloor) {
        if(startFloor==destinationFloor) return false;
        char direction = (startFloor < destinationFloor) ? 'U' : 'D';
        if(direction=='U'){
            for(int floor=startFloor;floor<destinationFloor;floor++)
                if (countPeople(floor, direction) >= 10) {
                    return false;
                }
        }
        else{
            for(int floor=startFloor;floor>destinationFloor;floor--)
                if (countPeople(floor, direction) >= 10) {
                    return false;
                }
        }
        return true;
    }

    public void setState(char direction){
        if(direction=='U'){
            this.state=movingUpState;
            return;
        }
        if(direction=='D'){
            this.state=movingDownState;
            return;
        }
        this.state = idleState;
    }

    public void addRequeest(int start, int destination) {
        LiftRequest liftRequest = new LiftRequest(start, destination);
        this.requests.add(liftRequest);
        if(requests.size() == 1){
            this.setState(liftRequest.getMoveDirection());
        }
    }

    void updateLiftState(){
        if(requests.size()==0||state.getDirection()=='I'){
            setState('I');
            return;
        }
        state.updateFloor();
        updateRequests();
        if (requests.size() == 0) state = idleState;
        else state.updateDirection();
    }

    // updates people moving out of lift
    public void updateRequests(){
        char direction = state.getDirection();
        if(direction=='I') return;
        ArrayList<LiftRequest> newRequests = new ArrayList<>();
        // removing old requests
        for(LiftRequest request: requests){
            if(direction==request.getMoveDirection()){
                boolean liftPassedDestinationGoingUp = direction=='U' &&
                        currentFloor>=request.getDestinationFloor();
                boolean liftPassedDestinationGoingDown = direction=='D' &&
                        currentFloor<=request.getDestinationFloor();
                if(liftPassedDestinationGoingUp
                        || liftPassedDestinationGoingDown)
                    continue;
            }
            newRequests.add(request);
        }
        requests= newRequests;
    }

    public String getLiftState() {
        return this.getCurrentFloor() + "-" + this.getState().getDirection();
    }

    public boolean isLiftStopOnFloor(int floor, char direction) {
        for(LiftRequest liftRequest : requests) {
            if(liftRequest.getMoveDirection() == direction){
                if( floor == liftRequest.getDestinationFloor() || floor == liftRequest.getStartFloor())
                    return true;
            }
        }
        return false;
    }
}
