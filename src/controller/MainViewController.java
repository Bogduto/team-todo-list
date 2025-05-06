package controller;

// Бібліотеки

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.CheckBox;
import java.util.ArrayList;
import java.util.List;

// Компоненти

import view.HistoryControls;
import view.forms.CreateTodoForm;
import view.layout.ListDrawer;
import view.components.CustomDropdown;

public class MainViewController {

    private Stage stage;

    public MainViewController(Stage stage) {
        this.stage = stage;
    }

    public void showMainView() {
        VBox root = new VBox();
        root.getStylesheets().add(getClass().getResource("/resources/global.css").toExternalForm());
        root.getStyleClass().add("main");

        // Добавляем шапку
        HBox header = createHeader();
        root.getChildren().add(header);

        // Добавляем список задач
        ScrollPane listDrawer = new ListDrawer(5).draw();
        VBox.setVgrow(listDrawer, Priority.ALWAYS);
        root.getChildren().add(listDrawer);

        // Добавляем форму
        VBox form = new CreateTodoForm().todoForm();
        root.getChildren().add(form);

        Scene scene = new Scene(root, 400, 500);
        stage.setScene(scene);
        stage.setTitle("Todo");
        stage.show();
    }

    private HBox createHeader() {
        HBox headerContainer = new HBox();
        headerContainer.setSpacing(10);
        headerContainer.getStyleClass().add("header");

        HBox headerLeft = new HBox();
        headerLeft.setSpacing(3);

        Label headerTitle = new Label("Швидкий список задач");
        headerTitle.getStyleClass().add("title");

        VBox headerActionsCol = new VBox();
        HBox headerActionsRow = new HBox();

        // SORT START
        VBox sortContainer = new VBox();
        sortContainer.setSpacing(5);
        Label sortLabel = new Label("Sort");
        sortContainer.getChildren().add(sortLabel);

        List<List<String>> sortItems = List.of(
                List.of("date", "by date"),
                List.of("activity", "by activity"),
                List.of("length", "by Length"),
                List.of("done", "by Done")
        );

        for (List<String> item : sortItems) {
            HBox box = new HBox(5);
            CheckBox checkbox = new CheckBox();
            checkbox.setId(item.get(0));
            Label text = new Label(item.get(1));
            text.getStyleClass().add("text");
            box.getChildren().addAll(checkbox, text);
            sortContainer.getChildren().add(box);
        }
        // SORT END

        // FILTER START
        VBox filterContainer = new VBox();
        filterContainer.setSpacing(5);
        Label filterLabel = new Label("Filter");
        filterContainer.getChildren().add(filterLabel);

        List<List<String>> filterItems = List.of(
                List.of("is_activity", "is activity"),
                List.of("is_done", "is Done")
        );

        for (List<String> item : filterItems) {
            HBox box = new HBox(5);
            CheckBox checkbox = new CheckBox();
            checkbox.setId(item.get(0));
            Label text = new Label(item.get(1));
            text.getStyleClass().add("text");
            box.getChildren().addAll(checkbox, text);
            filterContainer.getChildren().add(box);
        }
        // FILTER END

        headerActionsRow.getChildren().addAll(sortContainer, filterContainer);
        headerActionsRow.setSpacing(10);
        headerActionsCol.getChildren().add(headerActionsRow);

        CustomDropdown dropdown = new CustomDropdown(headerActionsCol, "full", null);
        headerLeft.getChildren().addAll(headerTitle, dropdown);

        // Justify-between
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox historyControls = new HistoryControls().draw();

        headerContainer.getChildren().addAll(headerLeft, spacer, historyControls);

        return headerContainer;
    }
}
