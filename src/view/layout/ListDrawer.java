package view.layout;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import javafx.collections.FXCollections;

import view.components.ItemWithActions;
import context.AppContext;
import model.ItemState;
import schemas.Task;

public class ListDrawer {
    private VBox container = new VBox();
    private ObservableList<Task> items = AppContext.getTodosService().getTodos();

    public ListDrawer() {
        this.container.getStyleClass().add("list");

    }

    public ScrollPane draw() {
        // Сначала рисуем всё, что уже есть
        renderItems();

        // Подписываемся на изменения
        this.items.addListener((ListChangeListener<Task>) c -> {
            renderItems();
        });

        ScrollPane scrollPane = new ScrollPane(container);
        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        return scrollPane;
    }

    private void renderItems() {
        container.getChildren().clear();

        for (Task item : items) {
            ItemWithActions li = new ItemWithActions(new ItemState(item.getId(), item.getValue(), item.getIsActive()));
            container.getChildren().add(li.draw());
        }
    }
}
