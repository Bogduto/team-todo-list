package model;

import schemas.Task;
import java.io.*;
import java.util.Iterator;
import java.util.ArrayList;

public class Todos {
    private final ArrayList<Task> todos;

    public Todos(ArrayList<Task> todos) {
        this.todos = todos;
    }

    /**
     * Повертає массив об'єктів
     *
     * @return повертає массив
     */
    public ArrayList<Task> getTasks() {
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
     * @param value новий опис задачі.
     */
    public void editTask(int index, String value) {
        if (isIndexValid(index))
        {
            todos.get(index).setValue(value);
        }
    }

    /**
     * Видаляє задачу з колекції за заданим ідентифікатором.
     * Якщо задача з таким ідентифікатором існує, вона буде видалена з колекції задач.
     */
    public void removeTask(int index) {
        if (isIndexValid(index))
        {
            todos.remove(index);
        }
    }

    private boolean isIndexValid(int index)
    {
        return index >= 0 && index < todos.size();
    }
}