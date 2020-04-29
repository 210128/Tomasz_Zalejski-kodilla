package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShippingCenterTestSuite {
    @Test
    public void shouldSendSuccessMessage() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection.homework");
        NotificationService bean = context.getBean(NotificationService.class);
        String message = bean.success(" Wiejska 4");
        Assertions.assertNotNull(message);
    }

    @Test
    public void shouldSendFailMessage() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection.homework");
        NotificationService bean = context.getBean(NotificationService.class);
        String message = bean.fail(" Wiejska 4");
        Assertions.assertNotNull(message);
    }

    @Test
    public void shouldSendMessageAboutSuccessDelivery() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection.homework");
        DeliveryService bean = context.getBean(DeliveryService.class);
        boolean message = bean.deliverPackage("Wiejska 4", 25);
        Assertions.assertTrue(message);
    }

    @Test
    public void shouldSendMessageAboutFailDelivery() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection.homework");
        DeliveryService bean = context.getBean(DeliveryService.class);
        boolean message = bean.deliverPackage("Wiejska 4", 50.1);
        Assertions.assertFalse(message);
    }
    @Test
    public void shouldSendPackage(){
        NotificationService notificationService = new NotificationService();
        DeliveryService deliveryService = new DeliveryService();
        ShippingCenter shippingCenter = Mockito.mock(ShippingCenter.class);
        var result = shippingCenter.sendPackage("Wiejska 10", 15);
        Mockito.verify(shippingCenter).sendPackage("Wiejska 10", 15);
    }

}