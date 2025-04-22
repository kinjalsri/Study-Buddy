package main.models;

public class ToDo {

    private String taskName;
    private boolean isCompleted;

    // Constructor
    public ToDo(String taskName) {
        this.taskName = taskName;
        this.isCompleted = false; // Default: task is incomplete
    }

    // Mark task as complete
    public void markComplete() {
        this.isCompleted = true;
        System.out.println("✅ Task completed: " + taskName);
    }

    // Mark task as incomplete (if needed)
    public void markIncomplete() {
        this.isCompleted = false;
        System.out.println("❌ Task marked as incomplete: " + taskName);
    }

    // Get Task Status (✔ if completed, ❌ if not)
    public String getTaskStatus() {
        return isCompleted ? "✔ " + taskName : "❌ " + taskName;
    }

    // Get Task Name
    public String getTaskName() {
        return taskName;
    }

    // Check if the task is completed
    public boolean isCompleted() {
        return isCompleted;
    }
}
