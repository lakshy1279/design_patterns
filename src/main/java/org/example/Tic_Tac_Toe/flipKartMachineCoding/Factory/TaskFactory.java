package org.example.Tic_Tac_Toe.flipKartMachineCoding.Factory;

import org.example.Tic_Tac_Toe.flipKartMachineCoding.Models.*;

public class TaskFactory {
    public static Task.TaskBuilder<?> createTask(String taskType) {
        System.out.println("Creating task of type " + taskType);
        switch (taskType) {
            case "Bug":
                return new Bug.BugBuilder();
            case "Feature":
                return new Feature.FeatureBuilder();
            case "Story":
                return new Story.StoryBuilder();
            default:
                throw new IllegalArgumentException("Unknown task type: " + taskType);
        }
    }
}
