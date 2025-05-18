package core.utils;

import core.tasks.TaskGroup;
import core.tasks.TaskManeger;
import models.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRoot {
    private File rootPath = new File("./src/data/root.txt");
    private final String separator = "⁞ ";


    public ArrayList<TaskGroup> loadGroups() {
        ArrayList<TaskGroup> taskGroupList = new ArrayList<>();
        int expectedParts = 3;

        try (Scanner scanner = new Scanner(rootPath)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(separator, expectedParts);

                if (parts.length < expectedParts) {
                    System.out.println("Incorrect line format: " + line);
                    continue;
                }

                String id = parts[0];
                String name = parts[1];
                String tasksId = parts[2];

                FileTasks fileTasks = new FileTasks("./src/data/" + tasksId + ".txt");
                TaskManeger taskManeger = new TaskManeger(fileTasks.loadTasks());
                TaskGroup taskGroup = new TaskGroup(id, name, taskManeger);

                taskGroupList.add(taskGroup);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File not found -> " + rootPath.getPath());
        }

        return taskGroupList;
    }


    public void saveGroups(String groupId, ArrayList<Task> tasks) {

    }
}
