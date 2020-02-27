package com.kodilla.execution_model.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopTestSuite {
    private Shop shop;

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
    @MethodSource(value = "com.kodilla.execution_model.homework.DataTestFactory#provideDateFotTestingRange")
    public void shouldReturnListOfOrdersFromPeriodTime(LocalDate from, LocalDate to, int expected) {
        //When
        List<Order> result = shop.getListOfOrdersFromPeriod(from, to);
        //Then
        assertEquals(result.size(), expected);
    }

    @ParameterizedTest
    @MethodSource(value = "com.kodilla.execution_model.homework.DataTestFactory#provideRangeOfValueForTestingGetListOfOrdersBasedOfValueRange")
    public void shouldReturnListOfOrdersBasedOnValueRange(double min, double max, int expected) {
        //When
        List<Order> result = shop.getListOfOrdersBasedOfValueRange(min, max);
        //Then
        assertEquals(result.size(), expected);
        result.forEach(o->{
            assertThat(o.getOrderValue(), greaterThan(min));
            assertThat(o.getOrderValue(), lessThan(max)); //coś jeszcze można tu dodać?
        });
    }

    @BeforeEach
    public void initializeInvoice() {
        shop = new DataTestFactory().createShop();
    }
}