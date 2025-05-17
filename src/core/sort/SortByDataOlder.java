package core.sort;


import java.util.Comparator;
import models.Task;

public class SortByDataOlder implements Comparator<Task>
{
    @Override
    public int compare(Task fTask, Task sTask)
    {
        return fTask.getCreatedAt().compareTo(sTask.getCreatedAt());
    }
}