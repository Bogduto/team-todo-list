package core.sort;


import java.util.Comparator;
import models.Task;

public class SortByDataNewest implements Comparator<Task>
{
    @Override
    public int compare(Task fTask, Task sTask)
    {
        return sTask.getCreatedAt().compareTo(fTask.getCreatedAt());
    }
}