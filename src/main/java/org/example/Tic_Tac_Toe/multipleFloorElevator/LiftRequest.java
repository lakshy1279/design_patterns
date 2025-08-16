package org.example.Tic_Tac_Toe.multipleFloorElevator;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LiftRequest {
    int startFloor;
    int destinationFloor;
    public LiftRequest(int startFloor, int endFloor) {
        this.startFloor = startFloor;
        this.destinationFloor = endFloor;
    }


    public char getMoveDirection(){
        if(startFloor!=destinationFloor)
            return startFloor<destinationFloor ? 'U':'D';
        return 'I';
    }

    public String toString() {
        return "(" + startFloor+"-"+destinationFloor + ")";
    }

}
