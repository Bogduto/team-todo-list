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
            HBox li = this.Item("Item " + i);
            this.container.getChildren().add(li);
        }

        ScrollPane scrollPane = new ScrollPane(container);
        scrollPane.setFitToWidth(true); // растягивать содержимое по ширине

        // Настройки скролла (необязательно, но полезно)
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        return scrollPane;
    }

    private HBox Item(String name) {
        HBox div = new HBox();
        div.setSpacing(10);
        div.setStyle("-fx-padding: 10; -fx-background-color: #f0f0f0; -fx-border-color: #ccc;");

        CheckBox cb = new CheckBox();
        cb.setIndeterminate(false);
        cb.setStyle("-fx-border-width: 1; -fx-border-radius: 10;");
        div.getChildren().add(cb);

        Label label = new Label(name);
        div.getChildren().add(label);

        return div;
    }
}
