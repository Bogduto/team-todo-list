
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import model.Todos;
import schemas.Task;
import utils.FileReader;
import utils.FileWrite;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.CreateTodoForm;
import view.HistoryControls;
import view.ListDrawer;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();

// HEADER
        HBox headerContainer = new HBox();
        headerContainer.setSpacing(10);
        headerContainer.setStyle("-fx-padding: 10; -fx-background-color: #eee;");

        Label header = new Label("Швидкий список задач");
        header.setStyle("-fx-font-size: 16px;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox historyControls = new HistoryControls().draw();
        headerContainer.getChildren().addAll(header, spacer, historyControls);

        root.getChildren().add(headerContainer);

// LIST
        ScrollPane listDrawer = new ListDrawer(5).draw();
        VBox.setVgrow(listDrawer, Priority.ALWAYS); // 👈 делает listDrawer гибким по высоте
        root.getChildren().add(listDrawer);

// FORM
        Pane form = new CreateTodoForm().todoForm();
// не нужно ничего устанавливать — он сам окажется внизу
        root.getChildren().add(form);

        Scene scene = new Scene(root, 400, 500);
        stage.setScene(scene);
        stage.setTitle("JavaFX");
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);

    }
}

//FileReader fileReader = new FileReader("./src/data/todos.txt");
//FileWrite fileWrite = new FileWrite("./src/data/todos.txt", true);
//
//ArrayList<Task> items = new ArrayList<>();
//
//        fileReader.readFile(items);
//
//
//Todos todos = new Todos(items);
//
//Task todo = todos.addNewTask(new Task("3", "2025-04-05", "Італло"));
//
//        fileWrite.writeFile(todo);
//
//        for (Task task : todos.getTodos()) {
//        System.out.println(task.getValue());
//        }
