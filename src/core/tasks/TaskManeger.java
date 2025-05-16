package core.tasks;

import core.patterns.memento.TaskMemento;
import models.Task;

import java.util.ArrayList;
import java.util.Stack;
import java.util.UUID;
import java.time.LocalDateTime;


public class TaskManeger {
    private ArrayList<Task> tasks;

    public TaskManeger(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Метод який повертає масив з тасками
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Метод який змінює массив
     * */
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }


    /**
     * Метод який добавляє нову таску
     * */
    public void addTask(String description) {
        String id = UUID.randomUUID().toString();

        String createdAt = LocalDateTime.now().toString();


        Task task = new Task(id, description, createdAt);
        tasks.add(task);
    }

    /**
     * Метод який видаляє таску по id
     * */

    public void removeTask (String id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }

    /**
     * Метод який редагує таску по id
     * */
    public void editTask(String id, String description) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setDescription(description);
                break;
            }
        }

    }


}
