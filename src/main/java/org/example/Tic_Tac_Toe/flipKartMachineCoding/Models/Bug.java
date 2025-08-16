package org.example.Tic_Tac_Toe.flipKartMachineCoding.Models;

import java.util.ArrayList;
import java.util.Date;


public class Bug extends Task {
    private SeverityType severity;

    private Bug(BugBuilder builder) {
        super(builder.title, builder.creator, builder.assignee, builder.dueDate);
        this.severity = builder.severity;
    }

    public static class BugBuilder extends TaskBuilder<BugBuilder> {
        private SeverityType severity;

        @Override
        protected BugBuilder self() {
            return this;
        }

        public BugBuilder setSeverity(SeverityType severity) {
            this.severity = severity;
            return this;
        }

        @Override
        public Bug build() {
            if (title == null || creator == null || severity == null) {
                throw new IllegalArgumentException("Title, Creator, and Severity are required!");
            }
            return new Bug(this);
        }
    }
}
