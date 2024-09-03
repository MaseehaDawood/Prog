public class WorkTask extends Task {
    private String projectName;
    private String assignedTo;

    public WorkTask(String taskName, int priority, String dueDate, String projectName, String assignedTo) {
        super(taskName, priority, dueDate);
        this.projectName = projectName;
        this.assignedTo = assignedTo;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getAssignedTo() {
        return assignedTo;
    }
}
