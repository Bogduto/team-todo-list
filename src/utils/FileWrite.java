package utils;

import schemas.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
    private File fileName;
    private boolean append;

    public FileWrite(String fileName, boolean append) {
        this.fileName = new File(fileName);
        this.append = append;
    }

    public void writeFile(Task task) {
        try (FileWriter writer = new FileWriter(this.fileName, this.append)) {
            writer.write("\n" + task.getId() + " " + task.getCreatedAt() + " " + task.getValue() + " " + task.getIsActive());
        } catch (IOException e) {
            System.out.print(e);
        }
    }
}
