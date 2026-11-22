package backend.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Difficulty {
    EASY,
    MEDIUM,
    HARD;

    @JsonCreator
    public static Difficulty from(String value) {
        if (value == null) {
            return null;
        }
        for (Difficulty difficulty : values()) {
            if (difficulty.name().equalsIgnoreCase(value.trim())) {
                return difficulty;
            }
        }
        throw new IllegalArgumentException("Unknown difficulty: " + value);
    }

    @JsonValue
    public String toValue() {
        return name();
    }
}
