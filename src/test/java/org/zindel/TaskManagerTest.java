package org.zindel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void testGenerateTaskIdProducesUniqueIds() {
        String id1 = TaskManager.generateTaskId();
        String id2 = TaskManager.generateTaskId();
        assertNotNull(id1);
        assertNotNull(id2);
        assertNotEquals(id1, id2);
    }

    @Test
    void testGetTaskById() {
        Task task = new Task("Laundry", false, "123");
        TaskManager.taskList.add(task);

        Task found = TaskManager.getTaskByID("123");
        assertNotNull(found);
        assertEquals("Laundry", found.getTaskName());
    }
}
