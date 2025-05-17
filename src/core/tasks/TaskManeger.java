package core.tasks;

import models.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;
import java.time.LocalDateTime;

public class TaskManeger {
    private ArrayList<Task> tasks;

    public TaskManeger(ArrayList<Task> tasks) {
        if (tasks != null) {
            this.tasks = tasks;
        } else {
            this.tasks = new ArrayList<>();
        }
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

        LocalDateTime createdAt = LocalDateTime.parse(LocalDateTime.now().toString());


        Task task = new Task(id, description, createdAt, createdAt, false);
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

    /**
     * Метод сортування
     * */
    public void sortTasks(Comparator<Task> comparator) {
        tasks.sort(comparator);
    }

}
