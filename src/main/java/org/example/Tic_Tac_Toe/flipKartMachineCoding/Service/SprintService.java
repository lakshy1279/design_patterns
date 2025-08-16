package org.example.Tic_Tac_Toe.flipKartMachineCoding.Service;

import org.example.Tic_Tac_Toe.flipKartMachineCoding.Models.Sprint;
import org.example.Tic_Tac_Toe.flipKartMachineCoding.Models.Task;

import java.util.ArrayList;
import java.util.List;

public class SprintService {
    List<Sprint> sprints;
    public SprintService() {
        sprints = new ArrayList<>();
    }

    private boolean checkIfTaskAlreadyExist(Task task) {
        for (Sprint sprint : sprints) {
            if(sprint.equals(task)) {
                return true;
            }
        }
        return false;
    }

    public void addTask(Sprint sprint, Task task) {
        if(checkIfTaskAlreadyExist(task)){
            throw new IllegalArgumentException("Task already exist");
        }
        sprint.addTask(task);
    }

    public void removeTask(Sprint sprint, Task task) {
        sprint.removeTask(task);
    }

    public void addSprint(Sprint sprint) {
        sprints.add(sprint);
    }

    public void removeSprint(Sprint sprint) {
        sprints.remove(sprint);
    }
}
