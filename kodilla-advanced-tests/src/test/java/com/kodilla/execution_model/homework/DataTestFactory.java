package com.kodilla.execution_model.homework;

import org.junit.jupiter.params.provider.Arguments;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class DataTestFactory {

    public List<Order> createOrders() {
        Order order1 = new Order(LocalDate.of(2019, 12, 30), "Roberto", 521.13);
        Order order2 = new Order(LocalDate.of(2020, 1, 13), "Roberto", 320.15);
        Order order3 = new Order(LocalDate.of(2020, 1, 24), "Marta", 781.12);
        Order order4 = new Order(LocalDate.of(2020, 2, 15), "Mike1", 56.01);
        Order order5 = new Order(LocalDate.of(2020, 2, 25), "Alf", 1583);
        return List.of(order1, order2, order3, order4, order5);
    }

    public Shop createShop() {
        var shop = new Shop();
        createOrders().stream()
                .forEach(o -> shop.addOrder(o));
        return shop;
    }

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