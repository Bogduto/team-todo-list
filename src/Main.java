import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Todos;
import schemas.Task;
import utils.FileReader;
import utils.FileWrite;
import view.CreateTodoForm;
import view.CustomDropdown;
import view.HistoryControls;
import view.ListDrawer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.getStylesheets().add(getClass().getResource("./resources/global.css").toExternalForm());
        root.getStyleClass().add("main");
        // HEADER
        HBox headerContainer = new HBox();
        headerContainer.setSpacing(10);
        headerContainer.getStyleClass().add("header");

        HBox headerLeft = new HBox();
        headerLeft.setSpacing(3);

        Label headerTitle = new Label("Швидкий список задач");
        headerTitle.getStyleClass().add("title");


        VBox headerActionsCol = new VBox();

        HBox headerActionsRow = new HBox();

//        SORT START
        VBox sortContainer = new VBox();
        sortContainer.setSpacing(5);
        Label sortLabel = new Label("Sort");

        sortContainer.getChildren().add(sortLabel);

        List<List<String>> sortItems = new ArrayList<>(
                List.of(
                        new ArrayList<>(List.of("date", "by date")), // id label
                        new ArrayList<>(List.of("activity", "by activity")),
                        new ArrayList<>(List.of("length", "by Length")),
                        new ArrayList<>(List.of("done", "by Done"))

                )
        );

        ArrayList<HBox> sort = new ArrayList<HBox>();

        for (List<String> sortItem : sortItems)
        {
                HBox box = new HBox();
                box.setSpacing(5);

                CheckBox checkbox = new CheckBox();
                checkbox.setId(sortItem.get(0));
                Label text = new Label(sortItem.get(1));
                text.getStyleClass().add("text");
                box.getChildren().addAll(checkbox, text);
                sort.add(box);

        }

        for (HBox item : sort) {
            sortContainer.getChildren().add(item);
        }
//        SORT END
//      FILTER START

        VBox filterContainer = new VBox();
        filterContainer.setSpacing(5);

        Label filterLabel = new Label("Filter");

        filterContainer.getChildren().add(filterLabel);

        List<List<String>> filterItems = new ArrayList<>(
                List.of(
                        new ArrayList<>(List.of("is_activity", "is activity")), // id label
                        new ArrayList<>(List.of("is_done", "is Done"))

                )
        );


        ArrayList<HBox> filter = new ArrayList<HBox>();

        for (List<String> filterItem : filterItems)
        {
            HBox box = new HBox();
            box.setSpacing(5);

            CheckBox checkbox = new CheckBox();
            checkbox.setId(filterItem.get(0));
            Label text = new Label(filterItem.get(1));
            text.getStyleClass().add("text");

            box.getChildren().addAll(checkbox, text);
            filter.add(box);

        }

        for (HBox item : filter) {
            filterContainer.getChildren().add(item);
        }
//        FILTER END

        headerActionsRow.getChildren().addAll(sortContainer, filterContainer);
        headerActionsRow.setSpacing(10);
        headerActionsCol.getChildren().add(headerActionsRow);

        CustomDropdown dropdown = new CustomDropdown(
                headerActionsCol,
                "full",
                null
        );


        headerLeft.getChildren().addAll(headerTitle, dropdown);

        // it's like justify-between
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // header left side
        HBox historyControls = new HistoryControls().draw();
        headerContainer.getChildren().addAll(headerLeft, spacer, historyControls);

        root.getChildren().add(headerContainer);

// LIST
        ScrollPane listDrawer = new ListDrawer(5).draw();
        VBox.setVgrow(listDrawer, Priority.ALWAYS);
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
