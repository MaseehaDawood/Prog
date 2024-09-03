import java.util.Arrays;

public class TaskManager {
    private Task[] tasks;
    private int taskCount;

    public TaskManager(int maxTasks) {
        this.tasks = new Task[maxTasks];
        this.taskCount = 0;
    }

    public void addTask(Task task) {
        if (taskCount < tasks.length) {
            tasks[taskCount++] = task;
        }
    }

    public void removeTask(Task task) {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].equals(task)) {
                tasks[i] = tasks[--taskCount];
                tasks[taskCount] = null;
                break;
            }
        }
    }

    public Task[] getPendingTasks() {
        return Arrays.stream(tasks)
                .filter(task -> task != null && !task.getStatus())
                .toArray(Task[]::new);
    }

    public Task[] getCompletedTasks() {
        return Arrays.stream(tasks)
                .filter(task -> task != null && task.getStatus())
                .toArray(Task[]::new);
    }

    public void generateReport() {
        System.out.println("--- Task Report ---");
        System.out.println("Pending Tasks:");
        for (Task task : getPendingTasks()) {
            System.out.println(task.getTaskName() + " - Due: " + task.getDueDate() + " - Priority: " + task.getPriority());
        }
        System.out.println("Completed Tasks:");
        for (Task task : getCompletedTasks()) {
            System.out.println(task.getTaskName() + " - Completed");
        }
    }
}

