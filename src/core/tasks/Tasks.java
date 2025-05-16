package core.tasks;

import models.Task;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Клас в якому зберігаються різні методи
 * */
public class Tasks {

    public static ArrayList<Task> filterByStatus(ArrayList<Task> tasks, boolean status) {
//        return tasks.stream().filter(task -> task.isDone() == status ? true : false).collect(Collectors.toList());
        return tasks;
    }

//    sorts

    public static ArrayList<Task> sortByStatus(ArrayList<Task> tasks) {
        return tasks;
    }

    public static ArrayList<Task> sortByDate(ArrayList<Task> tasks) {
        return tasks;
    }

    public static ArrayList<Task> sortByDone(ArrayList<Task> tasks, boolean status) {
        return tasks;
    }

}
