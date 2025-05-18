import java.util.Scanner;

import models.Group;
import models.Task;
import core.groups.GroupManager;
import core.utils.FileRoot;


public class Main {

    public static void main(String[] args) {
        FileRoot root = new FileRoot();
        GroupManager groupManager = new GroupManager(root.loadGroups());

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Hi!");
            System.out.println("Menu:");
            System.out.println("  - 1. See groups");
            System.out.println("  - 2. Enter a group");
            System.out.println("  - 3. Add the new group");
            System.out.println("  - 4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    System.out.println("\nGroups:");
                    for (int i = 0; i < groupManager.getAllGroups().size(); i++) {
                        Group group = groupManager.getAllGroups().get(i);
                        System.out.println("  " + (i + 1) + ". " + group.getGroupName());
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter group number: ");
                    int groupNumber = scanner.nextInt();
                    scanner.nextLine();

                    if (groupNumber >= 1 && groupNumber <= groupManager.getAllGroups().size()) {
                        Group selectedGroup = groupManager.getAllGroups().get(groupNumber - 1);
                        boolean insideGroup = true;

                        while (insideGroup) {
                            System.out.println("\nGroup: " + selectedGroup.getGroupName());
                            System.out.println("  - 1. Show tasks");
                            System.out.println("  - 2. Add task");
                            System.out.println("  - 3. Delete task");
                            System.out.println("  - 4. Back to main menu");
                            System.out.print("Your choice: ");

                            int groupChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (groupChoice) {
                                case 1:
                                    System.out.println("Tasks:");
                                    for (Task task : selectedGroup.getTaskManeger().getTasks()) {
                                        System.out.println("  id: " + task.getId() + " | " + task.getDescription());
                                    }
                                    break;

                                case 2:
                                    System.out.print("Enter task description: ");
                                    String desc = scanner.nextLine();

                                    selectedGroup.getTaskManeger().addTask(desc);
                                    System.out.println("Task added.");
                                    break;

                                case 3:
                                    System.out.print("Enter task ID to delete: ");
                                    String taskId = scanner.nextLine();
                                    selectedGroup.getTaskManeger().removeTask(taskId); // нужно реализовать метод
                                    System.out.println("Task deleted (if existed).");
                                    break;

                                case 4:
                                    insideGroup = false;
                                    break;

                                default:
                                    System.out.println("Invalid option.");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Invalid group number.\n");
                    }
                    break;

                case 3:
                    System.out.print("Add a new group: ");
                    String name = scanner.nextLine();

                    groupManager.addGroup(name);

                    System.out.println("Group added.");
                    break;
                case 4:
                    running = false;
                    root.saveGroups(groupManager.getAllGroups());
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.\n");
                    break;
            }
        }




    }

    // TODO:
// 1. Save all data to files when the program exits.
// 2. Automatically create a new <id>.txt file if the group doesn't have an associated tasks file.
// 3. Add validation for group data (e.g. non-empty name, unique ID, etc).

}