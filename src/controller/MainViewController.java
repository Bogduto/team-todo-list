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
import java.util.ArrayList;
import java.util.List;

// Компоненти

import view.HistoryControls;
import view.components.CheckOption;
import view.forms.CreateTodoForm;
import view.layout.ListDrawer;
import view.components.CustomDropdown;
import view.components.CheckboxGroup;

public class MainViewController {

    private Stage stage;

    public MainViewController(Stage stage) {
        this.stage = stage;
    }

    public void showMainView() {
        VBox root = new VBox();
        root.getStylesheets().add(getClass().getResource("/resources/global.css").toExternalForm());
        root.getStyleClass().add("main");

        // Шапка
        HBox header = createHeader();
        root.getChildren().add(header);

        // Список завдань
        ScrollPane listDrawer = new ListDrawer(5).draw();
        VBox.setVgrow(listDrawer, Priority.ALWAYS);
        root.getChildren().add(listDrawer);

        // Форма для створення
        VBox form = new CreateTodoForm(value -> {
            System.out.println(value); // заміниться на логіку яка додає новий елемент в список
        }).todoForm();
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

        Label headerTitle = new Label("Список задач");
        headerTitle.getStyleClass().add("title");

        VBox headerActionsCol = new VBox();
        HBox headerActionsRow = new HBox();

        // SORT START

        List<CheckOption> options = new ArrayList<CheckOption>();
        options.add(new CheckOption("date", "by date", true));
        options.add(new CheckOption("activity", "by activity", false));
        options.add(new CheckOption( "length", "by Length", false));
        options.add(new CheckOption( "done", "by Done", false));

        VBox sortContainer = new CheckboxGroup("Sort", (ArrayList<CheckOption>) options);

        // SORT END

        // FILTER START

        List<CheckOption> filterOptions = new ArrayList<CheckOption>();
        filterOptions.add(new CheckOption("is_activity", "is activity", false));
        filterOptions.add(new CheckOption("is_done", "is Done", false));

        VBox filterContainer = new CheckboxGroup("Filter", (ArrayList<CheckOption>) filterOptions);

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
