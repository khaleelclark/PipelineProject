package org.zindel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    private TaskList taskList;

    @BeforeEach
    void setUp() {
        taskList = new TaskList();
    }

    @Test
    void testAddAndRetrieveTask() {
        Task task = new Task("Test task", false, "100");
        taskList.add(task);

        assertEquals(1, taskList.size());
        assertEquals("Test task", taskList.getFirst().getTaskName());
    }

    @Test
    void testGetCompletedTasks() {
        Task completed = new Task("Finished project", true, "200");
        taskList.add(completed);

        assertTrue(taskList.getFirst().isTaskStatus());
    }

    @Test
    void testGetIncompleteTasks() {
        Task incomplete = new Task("Clean room", false, "300");
        taskList.add(incomplete);

        assertFalse(taskList.getFirst().isTaskStatus());
    }
}
