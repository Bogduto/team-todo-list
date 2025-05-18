package core.utils;

import models.Task;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class FileTasks implements FileRepository
{
    private final File file;
    private final String separator = "⁞ ";

    public FileTasks(String filePath)
    {
        if (filePath == null || filePath.isEmpty()) {
            this.file = null;
        } else {
            this.file = new File(filePath);
        }
    }

    @Override
    public ArrayList<Task> loadTasks()
    {

        ArrayList<Task> tasks = new ArrayList<>();
        byte lineConstraint = 5;

        String line = null;


        String id = null;
        LocalDateTime createdAt = null;
        LocalDateTime updateAt = null;
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
                updateAt = LocalDateTime.parse(parts[2]);
                value = parts[3];
                active = Boolean.parseBoolean(parts[4]);

                Task task = new Task(id, value, createdAt, updateAt, active);
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
                line = String.join(separator,
                        task.getId(),
                        task.getCreatedAt().toString(),
                        task.getUpdatedAt().toString(),
                        task.getDescription(),
                        String.valueOf(task.getDone())
                );


                writer.write(line + "\n");
            }
        }
        catch (IOException exception)
        {
            System.out.println("File save error -> " + file.getPath());
        }
    }

    public String createNewTaskFile() {
        String id = UUID.randomUUID().toString();
        File file = new File("./src/data/tasks/" + id + ".txt");

        try {
            if (file.createNewFile()) {
                return id;
            } else {
                throw new IOException("File already exists: " + file.getName());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to create new task file", e);
        }
    }
}
