package com.kodilla.exception.homework;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class WarehouseTestSuite {

    @Test
    void testAddOrder() {
        //given
        Warehouse warehouse = new Warehouse();
        //when
        warehouse.addOrder(new Order("5/2020"));
        warehouse.addOrder(new Order("7/2020"));
        //then
        assertEquals(2, warehouse.orders.size());
    }

    @Test
    void testGetOrder() throws OrderDoesntExistException {
        //given
        Warehouse warehouse = new Warehouse();
        warehouse.addOrder(new Order("1/2020"));
        warehouse.addOrder(new Order("2/2020"));
        //when
        Order result = warehouse.getOrder("1/2020");
        //then
        assertEquals("1/2020", result.getNumber());

    }

    @Test
    public void testGetOrder_withException() throws OrderDoesntExistException {

        //given
        var wh = new Warehouse();
        assertThrows(OrderDoesntExistException.class, () -> wh.getOrder("100/2020"));

    }
}