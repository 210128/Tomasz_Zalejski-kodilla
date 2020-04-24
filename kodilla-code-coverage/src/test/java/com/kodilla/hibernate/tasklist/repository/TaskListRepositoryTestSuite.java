package com.kodilla.hibernate.tasklist.repository;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListRepositoryTestSuite {
    @Autowired
    private TaskListRepository taskListRepository;


    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("Hibernate", "Test find by ListName");
        taskListRepository.save(taskList);
        String listName = taskList.getListName();
        //When
        List<TaskList> readTaskList = taskListRepository.findByListName(listName);
        //Then
        Assert.assertEquals(1, readTaskList.size());
        //CleanUp
        int id = readTaskList.get(0).getId();
        taskListRepository.deleteById(id);
    }

    @Test
    public void testTaskListRepositorySaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task1 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task1.setTaskFinancialDetails(tfd1);
        TaskList taskList = new TaskList("New list", "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task1);
        task.setTaskList(taskList);
        task1.setTaskList(taskList);
        //When
        taskListRepository.save(taskList);
        int id = taskList.getId();
        //Then
        Assert.assertNotEquals(0, id);
        //CleanUp
        taskListRepository.deleteById(id);
    }

}
