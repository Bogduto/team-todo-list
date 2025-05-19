import IO.FileTaskRepository;
import IO.TaskRepository;
import userInterface.UserInterface;
import controller.TodoController;
import model.Todos;
import view.ConsoleView;
import ui.contollers.FooterController;
import ui.contollers.HeaderController;
import ui.contollers.MainController;
import ui.contollers.RootController;
import ui.views.FooterView;
import ui.views.HeaderView;
import ui.views.MainView;
import ui.views.RootView;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main 
{
    public static void main(String[] args)
    {
        String path = "./src/data/todos.txt";
        TaskRepository taskRepository = new FileTaskRepository(path);

        Todos todos = new Todos(taskRepository.loadTasks());
        ConsoleView consoleView = new ConsoleView();
        TodoController todoController = new TodoController(todos, consoleView);

//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//             Тільки коли закриваеться прога
//            taskRepository.saveTasks(todos.getTasks());
//        }));

        UserInterface userInterface = new UserInterface();
        userInterface.run();

//        while (true)
//        {
//            consoleView.showTasks(todos.getTasks());
//            consoleView.showMenu();
//            int choise = consoleView.readInt();
//            todoController.handleMenuChoice(choise);
//
//            //Зберігає постоянно коли якийся двіж йоу
//            taskRepository.saveTasks(todos.getTasks());
//        }
    }
}

