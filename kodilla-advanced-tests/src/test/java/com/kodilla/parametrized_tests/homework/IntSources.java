package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class IntSources {
    static Stream<Arguments> provideIntForTestingBMI() {
        return Stream.of(
                Arguments.of(1.40, 29, "Very severely underweight"),
                Arguments.of(1.45, 32, "Severely underweight"),
                Arguments.of(1.5, 41, "Underweight"),
                Arguments.of(1.55, 45, "Normal (healthy weight)"),
                Arguments.of(1.60, 65, "Overweight"),
                Arguments.of(1.65, 82, "Obese Class I (Moderately obese)"),
                Arguments.of(1.70, 102, "Obese Class II (Severely obese)"),
                Arguments.of(1.75, 123, "Obese Class III (Very severely obese"),
                Arguments.of(1.8, 146, "Obese Class IV (Morbidly Obese)"),
                Arguments.of(1.85, 172, "Obese Class V (Super Obese)"),
                Arguments.of(1.9, 217, "Obese Class VI (Hyper Obese)")
        );
    }
}
