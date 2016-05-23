package com.bsu.bely.medical.entity.type;

public enum SkinType {
    WITHOUT_CHANGES {
        @Override
        public String toString() {
            return "Without changes";
        }
    },
    ICTERIC {
        @Override
        public String toString() {
            return "Icteric";
        }
    },
    HYPEREMIC {
        @Override
        public String toString() {
            return "Hyperemic";
        }
    },
    PALE {
        @Override
        public String toString() {
            return "Pale";
        }
    }
}
