package backend.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ExamType {
    JEE,
    NEET,
    BOTH;

    @JsonCreator
    public static ExamType from(String value) {
        if (value == null) {
            return null;
        }
        for (ExamType examType : values()) {
            if (examType.name().equalsIgnoreCase(value.trim())) {
                return examType;
            }
        }
        throw new IllegalArgumentException("Unknown exam type: " + value);
    }

    @JsonValue
    public String toValue() {
        return name();
    }
}
