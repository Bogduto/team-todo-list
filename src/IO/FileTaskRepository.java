package IO;

import schemas.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileTaskRepository implements TaskRepository
{
    private final File file;
    private final String separator = "⁞ ";

    public FileTaskRepository(String filePath)
    {
        this.file = new File(filePath);
    }

    @Override
    public ArrayList<Task> loadTasks()
    {
        ArrayList<Task> tasks = new ArrayList<>();
        byte lineConstraint = 3;

        String line = null;
        LocalDateTime createdAt = null;
        String value = null;
        boolean active;

        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNextLine())
            {
                line = scanner.nextLine();

                String[] parts = line.split(separator, lineConstraint);

                createdAt = LocalDateTime.parse(parts[0]);
                value = parts[1];
                active = Boolean.parseBoolean(parts[2]);

                Task task = new Task(active, createdAt, value);
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
                        task.getValue(), separator,
                        task.getIsActive()
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