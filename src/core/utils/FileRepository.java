package core.utils;

import models.Task;

import java.util.ArrayList;

public interface TaskRepository
{
    public ArrayList<Task> loadTasks(String groupId);

    public void saveTasks(String groupId, ArrayList<Task> tasks);
}
