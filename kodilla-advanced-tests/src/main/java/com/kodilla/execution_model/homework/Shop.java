package com.kodilla.execution_model.homework;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Shop {
    private final Set<Order> orders = new HashSet<>();

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public List<Order> getListOfOrdersFromPeriod(LocalDate from, LocalDate to) {
        return orders.stream()
                .filter(o -> o.getOrderDate().isAfter(from) && o.getOrderDate().isBefore(to))
                .collect(Collectors.toList());
    }

    public List<Order> getListOfOrdersBasedOfValueRange(double min, double max) {
        return orders.stream()
                .filter(o -> o.getOrderValue() >= min && o.getOrderValue() <= max)
                .collect(Collectors.toList());
    }

    public int numberOfOrders() {
        return this.orders.size();
    }

    public double sumOfOrders() {
        return orders.stream()
                .map(Order::getOrderValue)
                .mapToDouble(or -> or)
                .sum();

    }
}
