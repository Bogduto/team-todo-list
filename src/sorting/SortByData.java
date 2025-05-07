package sorting;

import schemas.Task;

import java.util.Comparator;

public class SortByData implements Comparator<Task>
{

    @Override
    public int compare(Task fTask, Task sTask)
    {
//        fTask.getCreatedAt().compareTo(sTask.getCreatedAt());
        return 1;
    }
}
