package com.kodilla.execution_model.homework;

import java.time.LocalDate;

public class Order {
    private LocalDate orderDate;
    private String username;
    private double orderValue;

    public Order(LocalDate orderDate, String username, double orderValue) {
        this.orderDate = orderDate;
        this.username = username;
        this.orderValue = orderValue;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getUsername() {
        return username;
    }

    public double getOrderValue() {
        return orderValue;
    }

    @Override
    public String toString() {
        return "Order{"+"Date=" + orderDate +
                ", Username='" + username + '\'' +
                ", Value=" + orderValue +
                '}';
    }
}
