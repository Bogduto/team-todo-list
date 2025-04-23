package model;

import schemas.Task;
import java.io.*;
import java.util.Iterator;
import java.util.ArrayList;

public class Todos {
    private ArrayList<Task> todos;

    public Todos(ArrayList<Task> todos) {
        this.todos = todos;
    }

    /**
     * Повертає массив об'єктів
     *
     * @return повертає массив
     */
    public ArrayList<Task> getTodos() {
        return this.todos;
    }

    /**
     * Додає нову задачу до списку.
     *
     * @param task об'єкт задачі, яку потрібно додати
     * @return об'єкт доданої задачі
     */
    public Task addNewTask(Task task) {
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

}