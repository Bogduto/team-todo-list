package core.utils;

import models.Group;
import core.tasks.TaskManeger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRoot {
    private File rootPath = new File("./src/data/root.txt");
    private final String separator = "⁞ ";


    public ArrayList<Group> loadGroups() {
        ArrayList<Group> taskGroupList = new ArrayList<>();
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

                FileTasks fileTasks = new FileTasks("./src/data/tasks/" + tasksId + ".txt");
                TaskManeger taskManeger = new TaskManeger(fileTasks.loadTasks());
                Group taskGroup = new Group(id, name, taskManeger, tasksId);

                taskGroupList.add(taskGroup);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File not found -> " + rootPath.getPath());
        }

        return taskGroupList;
    }


    public void saveGroups(ArrayList<Group> groups) {
        try (FileWriter writer = new FileWriter(rootPath, false)) {
            for (Group group : groups) {
                String taskListId = group.getListId();

                if (taskListId == null || taskListId.isEmpty()) {
                    taskListId = new FileTasks(null).createNewTaskFile();
                }

                FileTasks fileTasks = new FileTasks("./src/data/tasks/" + taskListId + ".txt");
                fileTasks.saveTasks(group.getTaskManeger().getTasks());

                String line = String.join(separator,
                        group.getGroupId(),
                        group.getGroupName(),
                        taskListId
                );
                writer.write(line + "\n");
            }
        } catch (IOException exception) {
            System.out.println("File save error -> " + rootPath.getPath());
        }
    }

}
