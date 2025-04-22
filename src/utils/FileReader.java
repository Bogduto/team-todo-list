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

                 // Розділяємо рядок на частини за пробілами
                String[] parts = line.split(" ", 5);  // 5 частин: id, дата, час, опис, активність
                if (parts.length >= 5) {
                    String id = parts[0];
                    String createdAt = parts[1] + " " + parts[2];
                    String value = parts[3].substring(1, parts[3].length() - 1);  // Прибираємо лапки навколо опису
                    Boolean active = Boolean.parseBoolean(parts[4]);

                    Task task = new Task(id, createdAt, value, active);
                    todos.add(task);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + fileName);
        }
    }
}
