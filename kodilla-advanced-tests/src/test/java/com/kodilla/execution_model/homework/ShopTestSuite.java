package com.kodilla.execution_model.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopTestSuite {
    Shop shop = new Shop();
    Order order1 = new Order(LocalDate.of(2019, 12, 30), "Roberto", 521.13);
    Order order2 = new Order(LocalDate.of(2020, 1, 13), "Roberto", 320.15);
    Order order3 = new Order(LocalDate.of(2020, 1, 24), "Marta", 781.12);
    Order order4 = new Order(LocalDate.of(2020, 2, 15), "Mike1", 56.01);
    Order order5 = new Order(LocalDate.of(2020, 2, 25), "Alf", 1583);


    @Test
    public void shouldAddNewOrderAndReturnNumberOfOrders() {
        //When
        int numberOfOrders = shop.numberOfOrders();
        //Then
        assertEquals(5, numberOfOrders);
    }

    @Test
    public void shouldReturnValueOfAllOrders() {
        //When
        double result = shop.sumOfOrders();
        //then
        assertEquals(3261.41, result, 0.01);
    }

    @ParameterizedTest
    @MethodSource(value = "com.kodilla.execution_model.homework.DataSources#provideDateFotTestingRange")
    public void shouldReturnListOfOrdersFromPeriodTime(LocalDate from, LocalDate to, int expected) {
        //When
        List<Order> result = shop.getListOfOrdersFromPeriod(from, to);
        //Then
        assertEquals(result.size(), expected);
    }

    @ParameterizedTest
    @MethodSource(value = "com.kodilla.execution_model.homework.DataSources#provideRangeOfValueForTestingGetListOfOrdersBasedOfValueRange")
    public void shouldReturnListOfOrdersBasedOnValueRange(double min, double max, int expected) {
        //When
        List<Order> result = shop.getListOfOrdersBasedOfValueRange(min, max);
        //Then
        assertEquals(result.size(), expected);
    }

    @BeforeEach
    public void initializeInvoice() {
        shop.addOrder(order1);
        shop.addOrder(order2);
        shop.addOrder(order3);
        shop.addOrder(order4);
        shop.addOrder(order5);
    }
}