package model;

import javafx.collections.ObservableList;
import schemas.Task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Todos {
    private ObservableList<Task> todos;

    public Todos(ObservableList<Task> todos) {
        this.todos = todos;
    }

    public ObservableList<Task> getTodos() {
        return this.todos;
    }

    public Task addNewTask(String value) {
        String id = UUID.randomUUID().toString();
        String createdAt = LocalDateTime.now().toString();

        Task task = new Task(id, createdAt, value, false);

        this.todos.add(task);

        return task;
    }

    /**
     * Метод який редагує опис задачі за заданим ідентифікатором.
     * Якщо задача з таким ідентифікатором знайдена, її опис буде змінено на нове значення.
     *
     * @param id ідентифікатор задачі, яку потрібно відредагувати.
     * @param value новий опис задачі.
     */
    public void editTask(String id, String value) {
        for (Task task : todos) {
            if (task.getId().equals(id)) {
                task.setValue(value);
                break;
            }
        }
    }

    /**
     * Видаляє задачу з колекції за заданим ідентифікатором.
     * Якщо задача з таким ідентифікатором існує, вона буде видалена з колекції задач.
     *
     * @param id ідентифікатор задачі, яку потрібно видалити.
     */
    public void removeTask(String id) {
        todos.removeIf(task -> task.getId().equals(id));
    }

    public void changeActiveTask (String id, Boolean isActive) {
        for (Task task : todos) {
            if (task.getId().equals(id)) {
                task.setIsActive(isActive);
                break;
            }
        }
    }
}
