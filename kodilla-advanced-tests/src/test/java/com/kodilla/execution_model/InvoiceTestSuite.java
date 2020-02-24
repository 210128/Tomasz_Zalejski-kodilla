package com.kodilla.execution_model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTestSuite {
    Invoice invoice = new Invoice();

    @BeforeEach
    public void initializeInvoice() {
        invoice.addItem(new Item("Java developer course", 10999));
        invoice.addItem(new Item("Python Developer course", 8499));
        invoice.addItem(new Item("Web Developer course", 10499));
    }
    @AfterEach
    public void resetValues(){
        System.out.println("Resetting values...");
    }
    @BeforeAll
    public static void displayIntroMessage(){
        System.out.println("Starting testing");
    }
    @AfterAll
    public static void displayGoodByeMessage(){
        System.out.println("Finishing testing");
    }

    @Test
    public void shouldAddNewItems() {
        assertEquals(3, invoice.getSize());
    }

    @Test
    public void shouldGetItems() {
        assertEquals("Python Developer course", invoice.getItem(1).getName());
        assertEquals(8499, invoice.getItem(1).getPrice(), 0.01);
    }

    @Test
    public void shouldReturnNullWhenPassingNegativeIndex() {
        assertNull(invoice.getItem(-2));
    }

    @Test
    public void shouldReturnNullWhenPassingOutOfRangeIndex() {
        assertNull(invoice.getItem(7));
    }

    @Test
    public void shouldClearInvoice() {
        invoice.clear();
        //Then
        assertEquals(0, invoice.getSize());
    }
}