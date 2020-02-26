package com.kodilla.execution_model.homework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public List<Order> getListOfOrdersFromPeriod(LocalDate from, LocalDate to) {
        List<Order> order = orders.stream()
                .filter(o -> o.getOrderDate().isAfter(from) && o.getOrderDate().isBefore(to))
                .collect(Collectors.toList());
        return order;
    }

    public List<Order> getListOfOrdersBasedOfValueRange(double min, double max) {
        List<Order> order = orders.stream()
                .filter(o -> o.getOrderValue() >= min && o.getOrderValue() <= max)
                .collect(Collectors.toList());
        return order;
    }

    public int numberOfOrders() {
        return this.orders.size();
    }

    public double sumOfOrders() {
        double ordersSum = orders.stream()
                .map(o -> o.getOrderValue())
                .mapToDouble(or -> or)
                .sum();
        return ordersSum;

    }
}
