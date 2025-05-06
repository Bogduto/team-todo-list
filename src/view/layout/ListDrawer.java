package view.layout;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.ItemState;
import view.components.ItemWithActions;

public class ListDrawer {
    private VBox container = new VBox();
    private int size;

    public ListDrawer(int size) {
        this.size = size;
        this.container.getStyleClass().add("list");
    }

    public ScrollPane draw() {
        this.container.getChildren().clear();
//        дані заміняться на настоящі
        for (int i = 1; i <= size; i++) {
            ItemWithActions li = new ItemWithActions(new ItemState("item" + i));
            this.container.getChildren().add(li.draw());
        }

        ScrollPane scrollPane = new ScrollPane(container);
        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        return scrollPane;
    }
}
