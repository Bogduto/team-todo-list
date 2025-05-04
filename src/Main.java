import schemas.Task;
import utils.FileReader;

import java.util.*;

import model.Todos;
import utils.FileWrite;

public class Main {

    public static void menuText() {
        System.out.println("\n--- TODO Меню ---");
        System.out.println("1. Додати задачу");
        System.out.println("2. Редагувати задачу");
        System.out.println("3. Видалити задачу");
        System.out.println("0. Вихід");
        System.out.print("Ваш вибір: ");
    }


    public static void main(String[] args) {
        String path = "./src/data/todos.txt";
        FileReader fileReader = new FileReader(path);
        FileWrite fileWrite = new FileWrite(path);

        ArrayList<Task> items = new ArrayList<>();

        fileReader.readFile(items);

        Todos todos = new Todos(items);
        GregorianCalendar calendar = new GregorianCalendar();

        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println(" _____ list _____ \n ");

//            for (Task item : todos.getTodos()) {
//                System.out.println(item.getId() + " " + " " + item.getValue() + " " + item.getIsActive());
//                System.out.printf("? - | %s | %s - %s\n", item.getCreatedAt(), item.getValue(), item.getIsActive() ? "To do" : "Done");
//            }

            int todosSize = todos.getTodos().size();
            ArrayList<Task> todosArray = todos.getTodos();
            Task item = null;

            for (int i = 0; i < todosSize; i++)
            {
                item = todosArray.get(i);
                System.out.printf("%s - | %s | %s | %s\n", i, item.getCreatedAt(), item.getIsActive() ? "ToDo" : "Done",
                        item.getValue());
            }

            System.out.println(" ____________ \n ");

            menuText();

            int choice = scanner.nextInt();
            scanner.nextLine();

            fileWrite.writeAllTasks(todos.getTodos(), false);

            switch (choice) {
                case 1:
                    System.out.print("Введіть текст задачі: ");
                    String text = scanner.nextLine();

                    String createdAt = "%02d.%02d.%d - %02d:%02d:%02d".formatted(
                            calendar.get(Calendar.DAY_OF_MONTH),
                            calendar.get(Calendar.MONTH) + 1,
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.HOUR_OF_DAY),
                            calendar.get(Calendar.MINUTE),
                            calendar.get(Calendar.SECOND)
                    );

                    Task task = new Task(true, createdAt, text);

                    todos.addNewTask(task);
                    break;
                case 2:
                    System.out.print("Введіть ID задачі для редагування: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Новий текст: ");
                    String newText = scanner.nextLine();
                    todos.editTask(editId, newText);
                    break;
                case 3:
                    System.out.print("Введіть ID задачі для видалення: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    todos.removeTask(deleteId);
                    break;
                case 0:
                    System.out.println("Вихід з програми...");
                    return;
                default:
                    System.out.println("Невірний вибір, спробуйте ще.");
            }

        } while (true);

    }
}

