package sorting;

import schemas.Task;

import java.util.Comparator;

public class SortByDataNewest implements Comparator<Task>
{
    @Override
    public int compare(Task fTask, Task sTask)
    {
        return sTask.getCreatedAt().compareTo(fTask.getCreatedAt());
    }
}
