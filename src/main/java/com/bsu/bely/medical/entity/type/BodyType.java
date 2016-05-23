package com.bsu.bely.medical.entity.type;

public enum BodyType {
    CORRECT_FIGURE {
        @Override
        public String toString() {
            return "Correct figure";
        }
    },
    ASTHENIC {
        @Override
        public String toString() {
            return "Asthenic";
        }
    },
    HYPERSTHENIC {
        @Override
        public String toString() {
            return "Hypersthenic";
        }
    }
}
