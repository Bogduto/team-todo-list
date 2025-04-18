package model;

import schemas.Task;

import java.util.ArrayList;

public class Todos {
    private ArrayList<Task> todos;

    public Todos(ArrayList<Task> todos) {
        this.todos = todos;
    }

    public ArrayList<Task> getTodos() {
        return this.todos;
    }

    public Task addNewTask(Task task) {
        this.todos.add(task);

        return task;
    }


    public void editTask(String id, String value) {}
    public void removeTask(String id) {}
}
