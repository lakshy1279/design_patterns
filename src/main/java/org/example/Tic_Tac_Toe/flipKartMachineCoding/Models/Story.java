package org.example.Tic_Tac_Toe.flipKartMachineCoding.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SplittableRandom;

@Getter
@Setter
public class Story extends Task{
    private String summary;
    private List<SubTask> subtasks;

    public Story(StoryBuilder builder) {
        super(builder.title, builder.creator, builder.assignee, builder.dueDate);
        this.summary = builder.summary;
        this.subtasks = new ArrayList<>();
    }

    @Getter
    @Setter
    public class SubTask {
        private String title;
        private String status;

        public SubTask(String title, String status) {
            this.title = title;
            this.status = status;
            subtasks.add(this);
        }
    }

    public static class StoryBuilder extends TaskBuilder<StoryBuilder> {
        private String title;
        private User creator;
        private User assignee;
        private Date dueDate;
        private String summary;

        @Override
        protected StoryBuilder self() {
            return this;
        }

        public Story build() {
            return new Story(this);
        }
    }
}
