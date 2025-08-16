package org.example.Tic_Tac_Toe.flipKartMachineCoding.Service;

import org.example.Tic_Tac_Toe.flipKartMachineCoding.Factory.TaskFactory;
import org.example.Tic_Tac_Toe.flipKartMachineCoding.Models.Task;
import org.example.Tic_Tac_Toe.flipKartMachineCoding.Models.User;

import java.util.*;

public class TaskService {
    private HashMap<String, List<Task>> tasks;
    private TaskFactory taskFactory;

    public TaskService() {
        tasks = new HashMap<>();
        taskFactory = new TaskFactory();
    }

    public Task createTask(String taskType, User user) {
//        Task task = taskFactory.createTask("Bug").setCreator(user).setDueDate(new Date()).setTitle("");
//        if(user != null) {
//            tasks.putIfAbsent(user.getId(), new ArrayList<>());
//            tasks.get(user.getId()).add(task);
//        }
        return null;
    }



}
