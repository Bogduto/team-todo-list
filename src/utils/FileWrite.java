package utils;

import schemas.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWrite {
    private final File file;

    public FileWrite(String fileName) {
        this.file = new File(fileName);
    }

    private String formatTask(Task task) {
        return "%s⁞ %s⁞ %s".formatted(task.getCreatedAt(), task.getValue(), task.getIsActive());
    }

    public void writeTask(Task task, boolean append) {
        try (FileWriter writer = new FileWriter(file, append)) {
            writer.write(formatTask(task) + "\n");
        } catch (IOException e) {
            System.err.println("Помилка запису задачі: " + e.getMessage());
        }
    }

    public void writeAllTasks(List<Task> tasks, boolean append) {
        try (FileWriter writer = new FileWriter(file, append)) {
            for (Task task : tasks) {
                writer.write(formatTask(task) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Помилка масового запису задач: " + e.getMessage(), e);
        }
    }
}
