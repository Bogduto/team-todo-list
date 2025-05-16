package core.patterns.memento;

import models.Task;

import java.util.ArrayList;

/**
 * Класс в якому буду зберігаться стейт
 * В мойому випадку наверное це буде
 * ArrayList<Task> tasks або task.getDescription()
 * */
public class TaskMemento {
    private final ArrayList<Task> state;

    public TaskMemento(ArrayList<Task> state) {
        this.state = new ArrayList<>(state);
    }

    public ArrayList<Task> getState() {
        return state;
    }
}
