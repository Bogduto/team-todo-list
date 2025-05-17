package core.utils;

import models.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileTasks implements TaskRepository
{
    private final File file;
    private final String separator = "⁞ ";

    public FileTasks(String filePath)
    {
        this.file = new File(filePath);
    }

    @Override
    public ArrayList<Task> loadTasks()
    {
        ArrayList<Task> tasks = new ArrayList<>();
        byte lineConstraint = 4;

        String line = null;
        String id = null;
        LocalDateTime createdAt = null;
        String value = null;
        boolean active;

        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNextLine())
            {
                line = scanner.nextLine();

                String[] parts = line.split(separator, lineConstraint);

                id = parts[0];
                createdAt = LocalDateTime.parse(parts[1]);
                value = parts[2];
                active = Boolean.parseBoolean(parts[3]);

                Task task = new Task(id, value, createdAt, active);
                tasks.add(task);
            }
        } catch (FileNotFoundException exception)
        {
            System.out.println("File not found -> " + file.getPath());
        }

        return tasks;
    }

    @Override
    public void saveTasks(ArrayList<Task> tasks)
    {
        try (FileWriter writer = new FileWriter(file, false))
        {
            String line = null;

            for (Task task : tasks)
            {
                line = "%s%s%s%s%s".formatted(
                        task.getCreatedAt(), separator,
                        task.getDescription(), separator,
                        task.getDone()
                );

                writer.write(line + "\n");
            }
        }
        catch (IOException exception)
        {
            System.out.println("File save error -> " + file.getPath());
        }
    }
}
