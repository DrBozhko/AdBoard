package util;

import com.domain.Rubric;

public class RubricUtil {
    public static Rubric getRubric() {
        return Rubric.builder()
                .id(0)
                .name("Car")
                .version(0)
                .build();
    }
}
