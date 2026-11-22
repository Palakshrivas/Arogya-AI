package backend.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CorrectOption {
    A,
    B,
    C,
    D;

    @JsonCreator
    public static CorrectOption from(String value) {
        if (value == null) {
            return null;
        }
        for (CorrectOption option : values()) {
            if (option.name().equalsIgnoreCase(value.trim())) {
                return option;
            }
        }
        throw new IllegalArgumentException("Unknown correct option: " + value);
    }

    @JsonValue
    public String toValue() {
        return name();
    }
}
