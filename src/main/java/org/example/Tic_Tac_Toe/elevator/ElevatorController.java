package org.example.Tic_Tac_Toe.elevator;


import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import static java.lang.Thread.sleep;

class Floor{
    private int id;
    private int no;
    static int counter = 0;
    Floor(int no){
        id = counter++;
        this.no = no;
    }

    public int getFloorNo(){
        return no;
    }

    public int setNo(int no) {
        this.no = no;
        return no;
    }
 }

enum State {
    UP,
    DOWN,
    IDLE
}

class Elevator {
    int id;
    Floor currentFloor;
    State state;
    PriorityQueue<Floor> upRequest;
    PriorityQueue<Floor> downRequest;
    Elevator(int id, Floor currentFloor, State state) {
        this.id = id;
        this.currentFloor = new Floor(0);
        this.state = state;
        upRequest = new PriorityQueue<>();
        downRequest = new PriorityQueue<>(Collections.reverseOrder());
    }

    void moveUp(){

    }

    void moveDown(){

    }

    void openGate(){

    }

    void closeGate(){

    }

    synchronized void addDestination(Floor destination){
        if(destination.getFloorNo() > currentFloor.getFloorNo()){
                upRequest.add(destination);
        } else if(destination.getFloorNo() == currentFloor.getFloorNo()){
            System.out.println("Invalid Input");
        } else {
            downRequest.add(destination);
        }
        notify();
    }

    public void moveToFloor(Floor floor){
        int currentFloorNo = floor.getFloorNo();
        while (floor.getFloorNo() > currentFloorNo){
            currentFloorNo++;
            currentFloor.setNo(currentFloorNo);
            sleep();
        }
        while (floor.getFloorNo() < currentFloorNo){
            currentFloorNo--;
            currentFloor.setNo(currentFloorNo);
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000); // Simulate movement time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void run() {
        while(true){
            synchronized (this) {
                while(upRequest.isEmpty() && downRequest.isEmpty()){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
            while(!upRequest.isEmpty()){
                moveToFloor(upRequest.poll());
            }
            while(!downRequest.isEmpty()){
                moveToFloor(downRequest.poll());
            }
        }
    }

    public int getFloorNo(){
        return currentFloor.getFloorNo();
    }
}


class Scheduler {
    List<Elevator> elevators;

    Scheduler(List<Elevator> elevators) {
        this.elevators = elevators;
    }
    public void scheduleRequest(Floor floor){
        Elevator targetElevator = elevators.get(0);
        for(int i = 0; i < elevators.size(); i++){
            int dis1 = floor.getFloorNo() - targetElevator.getFloorNo();
            int dis2 = floor.getFloorNo() - elevators.get(i).getFloorNo();
            if(dis2 < dis1){
                targetElevator = elevators.get(i);
            }
        }
        targetElevator.addDestination(floor);
    }
}

public class ElevatorController {

    Scheduler scheduler;
    private static ElevatorController controller;
    private ElevatorController(){

    }

    public synchronized ElevatorController getInstance(){
        if(controller == null){
            controller = new ElevatorController();
        }
        return controller;
    }

    public void requestElevator(Floor floor){
        scheduler.scheduleRequest(floor);
    }
}
