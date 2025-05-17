import core.patterns.memento.History;
import core.patterns.memento.TaskMemento;
import core.tasks.TaskManeger;
import core.tasks.TaskSorter;
import models.Task;
import ui.components.UserInterface;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static void start() {
        ArrayList<String> items = new ArrayList<>(Arrays.asList("Элемент 1", "Элемент 2", "Элемент 3", "Элемент 4"));

       /* JFrame frame = new JFrame("Todo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);
*/
////      views
//        RootView rootView = new RootView();
//
//        HeaderView headerView = new HeaderView();
//        MainView mainView = new MainView();
//        FooterView footerView = new FooterView();
//
////      controllers
//
//        HeaderController headerController = new HeaderController(headerView);
//        MainController mainController = new MainController(mainView, items);
//        FooterController footerController = new FooterController(footerView);
//
////        root controller
//        RootController rootController = new RootController(
//                rootView, headerController, mainController, footerController
//        );


//
//        frame.getContentPane().add(rootController.getRootPanel());
//
//        frame.setVisible(true);
    }

    public static void main(String[] args) {
        start();
        ArrayList<Task> tasks = new ArrayList<>(
                Arrays.asList(
                        new Task("1", "hello world 0", "10-12-2004"),
                        new Task("2", "hello world 1", "15-04-2014"),
                        new Task("3", "hello world 2", "01-11-2007")
                )
        );

        TaskManeger taskManeger = new TaskManeger(tasks);

        TaskSorter taskSorter = new TaskSorter(taskManeger);

        taskSorter.applySort(1);


//        for (Task task : taskManeger.getTasks()) {
//            System.out.println("id: " + task.getId() + " value: " + task.getDescription());
//        }

    }





    public static void mementoMain() {
        ArrayList<Task> tasks = new ArrayList<>(
                Arrays.asList(
                        new Task("1", "hello world 0", "10-12-2004"),
                        new Task("2", "hello world 1", "15-04-2014"),
                        new Task("3", "hello world 2", "01-11-2007")
                )
        );

        TaskManeger taskManeger = new TaskManeger(tasks);
        History history = new History();

//        if add new

        history.push(new TaskMemento(taskManeger.getTasks()));
        taskManeger.addTask("addy");

//        if undo

//        TaskMemento memento = history.undo(taskManeger.getTasks());
//        if (memento != null) {
//            taskManeger.setTasks(memento.getState());
//        }


//        if redo

//        TaskMemento redoMemento = history.redo(taskManeger.getTasks());
//        if (redoMemento != null) {
//            taskManeger.setTasks(redoMemento.getState());
//        }

    }
}
