import model.Todos;
import schemas.Task;
import utils.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        FileReader fileReader = new FileReader("./src/data/todos.txt");

        ArrayList<Task> items = new ArrayList<>();

        fileReader.readFile(items);

        Todos todos = new Todos(items);

        todos.addNewTask(new Task("3", "2025-04-05", "Італло"));

        for (Task task : todos.getTodos()) {
            System.out.println(task.getValue());
        }

    }
}
