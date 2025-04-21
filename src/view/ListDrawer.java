package view;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;

public class ListDrawer {
    private VBox container = new VBox();
    private int size;

    public ListDrawer(int size) {
        this.size = size;
    }

    public ScrollPane draw() {
        for (int i = 1; i <= size; i++) {
            ItemWithActions li = new ItemWithActions("item" + i);
            this.container.getChildren().add(li.draw());
        }
        this.container.getStyleClass().add("list");
        ScrollPane scrollPane = new ScrollPane(container);
        scrollPane.setFitToWidth(true); // растягивать содержимое по ширине

        // Настройки скролла (необязательно, но полезно)
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        return scrollPane;
    }
}
