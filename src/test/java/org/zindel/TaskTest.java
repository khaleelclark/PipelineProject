package org.zindel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testTaskCreation() {
        Task task = new Task("Write report", false, "1");
        assertEquals("1", task.getTaskId());
        assertEquals("Write report", task.getTaskName());
        assertFalse(task.isTaskStatus());
    }

    @Test
    void testSettersAndGetters() {
        Task task = new Task("Draft email", false, "2");
        task.setTaskName("Send email");
        task.setTaskStatus(true);
        task.setTaskId("22");

        assertEquals("Send email", task.getTaskName());
        assertTrue(task.isTaskStatus());
        assertEquals("22", task.getTaskId());
    }

    @Test
    void testTaskStatusOutput() {
        Task task = new Task("Do homework", true, "3");
        assertEquals("Completed ✓", task.taskStatus());

        task.setTaskStatus(false);
        assertEquals("Incomplete ✗", task.taskStatus());
    }

    @Test
    void testTaskInformation() {
        Task task = new Task("Buy groceries", false, "4");
        String info = task.getTaskInformation();
        assertTrue(info.contains("Buy groceries"));
        assertTrue(info.contains("Incomplete"));
    }
}
