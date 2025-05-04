package utils;

import schemas.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public void readFile(List<Task> todos) {
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split("⁞ ", 3);
                if (parts.length >= 3) {
                    String createdAt = parts[0];
                    String value = parts[1];
                    boolean active = Boolean.parseBoolean(parts[2]);

                    Task task = new Task(active, createdAt, value);
                    todos.add(task);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + fileName);
        }
    }
}
