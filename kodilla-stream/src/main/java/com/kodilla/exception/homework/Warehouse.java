package com.kodilla.exception.homework;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Warehouse {
    public final Set<Order> orders = new HashSet<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order getOrder(String number) throws OrderDoesntExistException {

        Optional<Order> order = orders.stream()
                .filter(o -> o.getNumber().equals(number))
                .findFirst();

        if (orders.stream()
                .filter(o -> o.getNumber().equals(number))
                .findFirst().isEmpty())

            throw new OrderDoesntExistException();
        return order.get();
    }
}
