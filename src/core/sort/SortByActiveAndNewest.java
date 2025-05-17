package core.sort;

import java.util.Comparator;
import models.Task;

public class SortByActiveAndNewest implements Comparator<Task>
{
    @Override
    public int compare(Task fTask, Task sTask)
    {
        int activeCompare = Boolean.compare(sTask.getDone(), fTask.getDone());
        if (activeCompare != 0)
        {
            return activeCompare;
        }

        return sTask.getCreatedAt().compareTo(fTask.getCreatedAt());
    }

}