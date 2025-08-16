package org.example.Tic_Tac_Toe.flipKartMachineCoding.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Sprint {
    private List<Task> tasks;
    private String name;
    public Sprint(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public boolean checkIfTaskExist(Task task) {
        return tasks.contains(task);
    }
}
