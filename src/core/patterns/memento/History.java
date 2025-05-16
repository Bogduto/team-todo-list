package core.patterns.memento;

import models.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public class History {
    private final Stack<TaskMemento> undoStack = new Stack<>();
    private final Stack<TaskMemento> redoStack = new Stack<>();

    /**
     * Метод додає новий масів в історію
     * */
    public void push(TaskMemento memento) {
        undoStack.push(memento);
        redoStack.clear();
    }

    /**
     * Метод який видаляє останнє значення з масиву
     * */
    public TaskMemento undo(ArrayList<Task> currentState) {
        if (undoStack.isEmpty()) return null;
        TaskMemento previous = undoStack.pop();
        redoStack.push(new TaskMemento(new ArrayList<>((Collection) currentState)));
        return previous;
    }

    /**
     * Метод який повертає останнє значення в масиву
     * */
    public TaskMemento redo(ArrayList<Task> currentState) {
        if (redoStack.isEmpty()) return null;
        TaskMemento next = redoStack.pop();
        undoStack.push(new TaskMemento(new ArrayList<>((Collection) currentState)));
        return next;
    }
}
