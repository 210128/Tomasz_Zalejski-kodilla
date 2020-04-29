package com.kodilla.collections.adv.immutable.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTestSuite {
    @Test
    public void shouldGetTitle() {
        //Given
        Task task = new Task("Homework", 3);
        //When
        String result = task.getTitle();
        //Then
        assertEquals(result, "Homework");
    }

    @Test
    public void ShouldGetDuration() {
        //Given
        Task task = new Task("Homework", 3);
        //When
        int result = task.getDuration();
        //Then
        assertEquals(result, 3);

    }
}