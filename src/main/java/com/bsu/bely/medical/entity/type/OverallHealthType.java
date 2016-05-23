package com.bsu.bely.medical.entity.type;

public enum OverallHealthType {
    SATISFACTORY {
        @Override
        public String toString() {
            return "Satisfactory";
        }
    },
    MEDIUM_DAMAGED {
        @Override
        public String toString() {
            return "Medium damaged";
        }
    },
    DAMAGED {
        @Override
        public String toString() {
            return "Damaged";
        }
    },
    EXTREMELY_DAMAGED {
        @Override
        public String toString() {
            return "Extremely damaged";
        }
    }
}
