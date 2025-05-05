package view;

import schemas.Task;

import java.util.List;
import java.util.Scanner;

public class ConsoleView
{
    private final Scanner scanner = new Scanner(System.in);

    private final String border = "▬";

    public void showTasks(List<Task> tasks)
    {
        int taskCount = tasks.size();
        Task task = null;

        String line = border.repeat(40);
        String header = " TASKS ";
        String closeLine = border.repeat(header.length() + (line.length() * 2));

        System.out.println(line + header + line);

        for (int i = 0; i < taskCount; i++)
        {
            task = tasks.get(i);
            System.out.printf("%s - | %s | %s | %s\n", i,
                    task.getCreatedAt(),
                    task.getIsActive() ? "ToDo" : "Done",
                    task.getValue());
        }

        System.out.println(closeLine + "\n\n");
    }

    public void showMenu()
    {
        String line = border.repeat(40);
        String header = " MENU ";
        String closeLine = border.repeat(header.length() + (line.length() * 2));

        String menuOptions =
                "1. Add a new task\n" +
                "2. Edit a task\n" +
                "3. Delete a task\n" +
                "0. Exit";

        System.out.println(line + header + line);
        System.out.println(menuOptions);
        System.out.println(closeLine);
        System.out.print("Choice -> ");
    }

    public int readInt()
    {
        String input = scanner.nextLine();
        try
        {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException exception)
        {
            System.out.println("Invalid number, try again:");
            return readInt();
        }
    }

    public void showMessage(String message)
    {
        System.out.println(message);
    }

    public void showPrompt(String message)
    {
        System.out.print(message);
    }

    public String readLine(String prompt)
    {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
