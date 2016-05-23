package com.bsu.bely.medical.entity.type;

public enum FeelingType {
    CLEAR {
        @Override
        public String toString() {
            return "Clear";
        }
    },
    CONFUSION {
        @Override
        public String toString() {
            return "Confusion";
        }
    },
    UNCONSCIOUS {
        @Override
        public String toString() {
            return "Unconscious";
        }
    },
    COMA {
        @Override
        public String toString() {
            return "Coma";
        }
    }
}
