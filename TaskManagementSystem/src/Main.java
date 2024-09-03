import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager(10); // max 10 tasks for simplicity

        while (true) {
            System.out.println("--- Task Management System ---");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task Status");
            System.out.println("3. Remove Task");
            System.out.println("4. View Pending Tasks");
            System.out.println("5. View Completed Tasks");
            System.out.println("6. Generate Report");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Task Name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Enter Task Priority (1-High, 2-Medium, 3-Low): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Due Date (yyyy-mm-dd): ");
                    String dueDate = scanner.nextLine();
                    taskManager.addTask(new Task(taskName, priority, dueDate));
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Task Name to Mark as Completed: ");
                    String taskToComplete = scanner.nextLine();
                    for (Task task : taskManager.getPendingTasks()) {
                        if (task.getTaskName().equals(taskToComplete)) {
                            task.markAsCompleted();
                            System.out.println("Task marked as completed!");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Task Name to Remove: ");
                    String taskToRemove = scanner.nextLine();
                    for (Task task : taskManager.getPendingTasks()) {
                        if (task.getTaskName().equals(taskToRemove)) {
                            taskManager.removeTask(task);
                            System.out.println("Task removed successfully!");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("--- Pending Tasks ---");
                    for (Task task : taskManager.getPendingTasks()) {
                        System.out.println(task.getTaskName() + " - Due: " + task.getDueDate() + " - Priority: " + task.getPriority());
                    }
                    break;
                case 5:
                    System.out.println("--- Completed Tasks ---");
                    for (Task task : taskManager.getCompletedTasks()) {
                        System.out.println(task.getTaskName() + " - Completed");
                    }
                    break;
                case 6:
                    taskManager.generateReport();
                    break;
                case 7:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

