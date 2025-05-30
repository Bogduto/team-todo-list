package sorting;

import schemas.Task;

import java.util.Comparator;

public class SortByActiveAndOlder implements Comparator<Task>
{
    @Override
    public int compare(Task fTask, Task sTask)
    {
        int activeCompare = Boolean.compare(sTask.getIsActive(), fTask.getIsActive());
        if (activeCompare != 0)
        {
            return activeCompare;
        }

        return fTask.getCreatedAt().compareTo(sTask.getCreatedAt());
    }
}
