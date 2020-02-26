package com.kodilla.execution_model.homework;

import org.junit.jupiter.params.provider.Arguments;

import java.time.LocalDate;
import java.util.stream.Stream;

public class DataSources {
    static Stream<Arguments> provideDateFotTestingRange() {
        return Stream.of(
                Arguments.of(LocalDate.of(2019, 10, 1), LocalDate.of(2020, 3, 31), 5),
                Arguments.of(LocalDate.of(2018, 1, 1), LocalDate.of(2019, 12, 1), 0),
                Arguments.of(LocalDate.of(2019, 12, 1), LocalDate.of(2020, 1, 15), 2)
        );
    }

    static Stream<Arguments> provideRangeOfValueForTestingGetListOfOrdersBasedOfValueRange() {
        return Stream.of(
                Arguments.of(0, 100, 1),
                Arguments.of(60, 300, 0),
                Arguments.of(150, 900, 3),
                Arguments.of(500, 2000, 3),
                Arguments.of(0, 1900, 5)
        );
    }
}