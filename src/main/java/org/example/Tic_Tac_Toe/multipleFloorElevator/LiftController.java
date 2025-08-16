package org.example.Tic_Tac_Toe.multipleFloorElevator;

import java.util.ArrayList;
import java.util.List;

public class LiftController {
    Lift [] lifts;
    int liftsCount;
    int floor;
    public LiftController(int liftCount, int floor) {
        lifts = new Lift[liftCount];
        this.liftsCount = liftCount;
        this.floor = floor;
        for(int i = 0; i < liftCount; i++) {
            lifts[i] = new Lift();
        }
    }

    public int requestLift(int start, int end) {
        if(start == end) { return -1;};
        int liftId = -1;
        int timeToReach = 1000*1000;
        LiftRequest liftRequest = new LiftRequest(start, end);
        char direction = (start < end) ? 'U' : 'D';
        for(int i = 0; i < liftsCount; i++) {
            if(!lifts[i].hasSpace(start, end)) { return -1;};
            int reachStart = lifts[i].getTimeToReachFloor(start, direction);
            int reachEnd = lifts[i].getTimeToReachFloor(end, direction);
            if(reachStart < 0 || reachEnd < 0 || reachStart > reachEnd) continue;
            if(reachStart < timeToReach) { timeToReach = reachStart; liftId = i;};
        }
        if(liftId>=0 && liftId< liftsCount)
            lifts[liftId].addRequeest(start, end);
        return liftId;
    }

    public void tick() {
        for(int i = 0; i< liftsCount; i++)
            lifts[i].updateLiftState();
    }

    public List<String> getLiftStates() {
        List<String> states = new ArrayList<>();
        for(int i = 0; i< liftsCount; i++)
        {
            states.add(lifts[i].getLiftState());
        }
        return states;
    }

    public int getNoOfPeopleOnLift(int liftId) {
        return lifts[liftId].countPeople(lifts[liftId].getCurrentFloor(), lifts[liftId].getState().getDirection());
    }

    public List<Integer> getLiftsStoppingOnFloor(int floor, char direction) {
          List<Integer> stopping = new ArrayList<>();
          for(int i = 0; i< liftsCount; i++) {
              if(lifts[i].isLiftStopOnFloor(floor, direction)) {
                  stopping.add(i);
              }
          }
          return stopping;
    }
}
