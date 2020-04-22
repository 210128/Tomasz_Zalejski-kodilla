package com.kodilla.hibernate.tasklist.repository;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

}
