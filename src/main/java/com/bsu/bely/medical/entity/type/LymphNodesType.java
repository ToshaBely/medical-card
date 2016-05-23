package com.bsu.bely.medical.entity.type;

public enum LymphNodesType {
    INCREASED_PAINLESS {
        @Override
        public String toString() {
            return "Increased painless";
        }
    },
    INCREASED_PAINFUL {
        @Override
        public String toString() {
            return "Increased painful";
        }
    },
    NOT_INCREASED {
        @Override
        public String toString() {
            return "Not increased";
        }
    }
}
