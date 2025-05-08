import IO.FileTaskRepository;
import IO.TaskRepository;
import controller.SortController;
import controller.TodoController;
import model.Todos;
import sorting.SortByActiveAndNewest;
import sorting.SortByActiveAndOlder;
import sorting.SortByDataNewest;
import sorting.SortByDataOlder;
import view.ConsoleView;

import java.util.Collections;

public class Main {

    public static void main(String[] args)
    {
        String path = "./src/data/todos.txt";
        TaskRepository taskRepository = new FileTaskRepository(path);

        Todos todos = new Todos(taskRepository.loadTasks());
        ConsoleView consoleView = new ConsoleView();
        SortController sortController = new SortController(todos);
        TodoController todoController = new TodoController(todos, consoleView, sortController);

//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//             Тільки коли закриваеться прога
//            taskRepository.saveTasks(todos.getTasks());
//        }));

        while (true)
        {
            consoleView.showTasks(todos.getTasks());
            consoleView.showMenu();
            int choise = consoleView.readInt();
            todoController.handleMenuChoice(choise);

            //Зберігає постоянно коли якийся двіж йоу
            taskRepository.saveTasks(todos.getTasks());
        }
    }
}

