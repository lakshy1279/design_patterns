package org.example.Tic_Tac_Toe.flipKartMachineCoding.Models;

import java.util.Date;

public class Feature extends Task{
    private String summary;
    private ImpactType impact;

    public Feature(FeatureBuilder builder) {
        super(builder.title, builder.creator, builder.assignee, builder.dueDate);
        this.summary = summary;
        this.impact = impact;
    }

    public static class FeatureBuilder extends TaskBuilder<FeatureBuilder> {

        private String summary;
        private ImpactType impact;

        public FeatureBuilder setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public FeatureBuilder setImpact(ImpactType impact) {
            this.impact = impact;
            return this;
        }

        @Override
        protected FeatureBuilder self() {
            return this;
        }

        @Override
        public Feature build() {
            return new Feature(this);
        }
    }
}
