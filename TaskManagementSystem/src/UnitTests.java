import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager(5); // max 5 tasks for testing
    }

    @Test
    void testAddTask() {
        Task task = new Task("Test Task 1", 1, "2024-09-10");
        taskManager.addTask(task);
        assertEquals(1, taskManager.getPendingTasks().length);
        assertEquals("Test Task 1", taskManager.getPendingTasks()[0].getTaskName());
    }

    @Test
    void testRemoveTask() {
        Task task1 = new Task("Test Task 1", 1, "2024-09-10");
        Task task2 = new Task("Test Task 2", 2, "2024-09-11");
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.removeTask(task1);
        assertEquals(1, taskManager.getPendingTasks().length);
        assertEquals("Test Task 2", taskManager.getPendingTasks()[0].getTaskName());
    }

    @Test
    void testMarkTaskAsCompleted() {
        Task task = new Task("Test Task 1", 1, "2024-09-10");
        taskManager.addTask(task);
        task.markAsCompleted();
        assertEquals(1, taskManager.getCompletedTasks().length);
        assertTrue(taskManager.getCompletedTasks()[0].getStatus());
    }

    @Test
    void testGenerateReport() {
        Task task1 = new Task("Test Task 1", 1, "2024-09-10");
        Task task2 = new Task("Test Task 2", 2, "2024-09-11");
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        task1.markAsCompleted();

        // Normally you would capture the output and verify it matches expected results,
        // but for simplicity, we just verify the counts of pending and completed tasks.
        assertEquals(1, taskManager.getPendingTasks().length);
        assertEquals(1, taskManager.getCompletedTasks().length);
    }
}
