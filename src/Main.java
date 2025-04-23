import model.Todos;
import schemas.Task;
import utils.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

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
        FileReader fileReader = new FileReader("./src/data/todos.txt");

        ArrayList<Task> items = new ArrayList<>();

        fileReader.readFile(items);

        Todos todos = new Todos(items);


        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println(" _____ list _____ \n ");

            for (Task item : todos.getTodos()) {
                System.out.println(item.getId() + " " + item.getValue() + " " + item.getIsActive());
            }

            System.out.println(" ____________ \n ");

            menuText();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введіть текст задачі: ");
                    String text = scanner.nextLine();

                    Task task = new Task("3", "2025-04-05", text, true);

                    todos.addNewTask(task);
                    break;
                case 2:

                    System.out.print("Введіть ID задачі для редагування: ");
                    String editId = scanner.next();
                    scanner.nextLine();
                    System.out.print("Новий текст: ");
                    String newText = scanner.nextLine();
                    todos.editTask(editId, newText);
                    break;
                case 3:
                    System.out.print("Введіть ID задачі для видалення: ");
                    String deleteId = scanner.next();
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

