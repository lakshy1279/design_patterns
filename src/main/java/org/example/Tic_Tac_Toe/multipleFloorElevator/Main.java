package org.example.Tic_Tac_Toe.multipleFloorElevator;

public class Main {

    public static void main(String[] args) {
        LiftController liftController = new LiftController(2, 6);
        System.out.println("Lift" + " " + liftController.requestLift(0, 4));
        liftController.tick();
        System.out.println("Lift" + " " + liftController.requestLift(1, 5));
        liftController.tick();
        System.out.println(liftController.requestLift(4, 1));
        liftController.tick();
        System.out.println(liftController.requestLift(1, 5));
        liftController.tick();
        System.out.println(liftController.requestLift(2, 6));
        System.out.println(liftController.requestLift(0, 5));
        System.out.println(liftController.getNoOfPeopleOnLift(1));
    }
}
