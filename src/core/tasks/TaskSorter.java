package core.tasks;

import core.sort.SortType;

import java.util.HashMap;
import java.util.Map;

public class TaskSorter {
    private final TaskManeger tasks;
    private final Map<Integer, SortType> sortMap = new HashMap<>();

    public TaskSorter(TaskManeger tasks) {
        this.tasks = tasks;
        sortMap.put(1, SortType.ACTIVE_AND_NEWEST);
        sortMap.put(2, SortType.ACTIVE_AND_OLDEST);
        sortMap.put(3, SortType.NEWEST);
        sortMap.put(4, SortType.OLDEST);
    }

    public void applySort(int value) {
        SortType sortType = sortMap.get(value);
        if (sortType != null) {
            tasks.sortTasks(sortType.getComparator());
        } else {
            System.out.println("Unknown sort option: " + value);
        }
    }
}

