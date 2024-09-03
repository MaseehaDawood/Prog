public class Task {
    private String taskName;
    private int priority; // 1-High, 2-Medium, 3-Low
    private String dueDate; // in the format yyyy-mm-dd
    private boolean isCompleted;

    public Task(String taskName, int priority, String dueDate) {
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getPriority() {
        return priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean getStatus() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }
}

