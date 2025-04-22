package main.services;

import main.models.ToDo;
import java.util.ArrayList;
import java.util.List;

public class ToDoService {
    private List<ToDo> taskList = new ArrayList<>();

    public void addTask(String taskName) {
        taskList.add(new ToDo(taskName));
        System.out.println("✅ Task added: " + taskName);
    }

    public void completeTask(String taskName) {
        for (ToDo task : taskList) {
            if (task.getTaskName().equals(taskName)) {
                task.markComplete();
                return;
            }
        }
        System.out.println("❌ Task not found.");
    }

    public void showTasks() {
        if (taskList.isEmpty()) {
            System.out.println("📌 No tasks added yet.");
            return;
        }

        System.out.println("📋 Task List:");
        for (ToDo task : taskList) {
            System.out.println(task.getTaskStatus());
        }
    }
}
