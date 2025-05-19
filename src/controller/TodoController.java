package controller;

import model.Todos;
import schemas.Task;
import sorting.SortByActiveAndNewest;
import sorting.SortByActiveAndOlder;
import sorting.SortByDataNewest;
import sorting.SortByDataOlder;
import view.ConsoleView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TodoController
{
    private final Todos todos;
    private final ConsoleView consoleView;
    private final SortController sortController;

    public TodoController(Todos todos, ConsoleView consoleView, SortController sortController)
    {
        this.todos = todos;
        this.consoleView = consoleView;
        this.sortController = sortController;
    }

    public void handleMenuChoice(int choice)
    {
        switch (choice)
        {
            case 1 -> handleCreateTask();
            case 2 -> handleEditTask();
            case 3 -> handleRemoveTask();
            case 4 -> handleChangeSorting();
            case 0 -> closeProgram();
            default -> consoleView.showMessage("Invalid choice, please try again");
        }
    }

    private void handleCreateTask()
    {
        String text = consoleView.readLine("What you need to do: ");

        Task newTask = new Task(true, LocalDateTime.now().withNano(0), text);

        todos.addNewTask(newTask);
    }

    private void handleEditTask()
    {
        consoleView.showPrompt("Index of what to edit: ");
        int index = consoleView.readInt();

        String newText = consoleView.readLine("Edit text: ");

        todos.editTask(index, newText);
    }

    private void handleRemoveTask()
    {
        consoleView.showPrompt("Index of what to remove: ");
        int index = consoleView.readInt();

        todos.removeTask(index);
    }

    private void handleChangeSorting()
    {
        consoleView.showPrompt("What type of sorting:\n" +
                "1. Active and newest\n" +
                "2. Active and oldest\n" +
                "3. Newest\n" +
                "4. Oldest\n" +
                "Choice -> "

        );

        sortController.changeSorting(consoleView.readInt());
    }

    private void closeProgram()
    {
        System.out.println("Closing program");
        System.exit(0);
    }
}
