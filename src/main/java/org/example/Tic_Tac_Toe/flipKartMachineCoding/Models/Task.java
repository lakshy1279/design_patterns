package org.example.Tic_Tac_Toe.flipKartMachineCoding.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class Task extends Base {
    private String title;
    private User creator;
    private User assisgne;
    private Date dueDate;
    private TaskStatus status;

    public Task(String title, User creator, User assisgne, Date dueDate) {
       this.title = title;
       this.creator = creator;
       this.dueDate = dueDate;
       this.assisgne = assisgne;
    }

    public abstract static class TaskBuilder<T extends TaskBuilder<T>> {
        protected String title;
        protected User creator;
        protected User assignee; // Optional
        protected Date dueDate;

        public T setTitle(String title) {
            this.title = title;
            return self();
        }

        public T setCreator(User creator) {
            this.creator = creator;
            return self();
        }

        public T setAssignee(User assignee) { // Optional
            this.assignee = assignee;
            return self();
        }

        public T setDueDate(Date dueDate) {
            this.dueDate = dueDate;
            return self();
        }

        protected abstract T self(); // Enforces method chaining in subclasses
        public abstract Task build(); // Subclasses must implement this
    }
}
