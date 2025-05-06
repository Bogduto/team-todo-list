package view.components;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import model.ItemState;

public class ItemWithActions {
    private ItemState item; // посилання на модель

    public ItemWithActions(ItemState item) {
        this.item = item;
    }

    public HBox draw() {
        HBox itemContainer = new HBox();
        itemContainer.getStyleClass().add("list__item");
        itemContainer.setSpacing(10);

        CheckBox checkBox = new CheckBox();
        checkBox.getStyleClass().add("list__checkbox");
        checkBox.setSelected(item.isChecked());
        checkBox.setOnAction(e -> item.toggleChecked());

        Label text = new Label(item.getValue());
        text.getStyleClass().add("list__text");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        VBox actions = this.actionsUI();

        CustomDropdown dropdown = new CustomDropdown(actions, "custom", getClass().getResource("../../resources/more_vert.png"));

        itemContainer.getChildren().addAll(checkBox, text, spacer, dropdown);

        return itemContainer;
    }

    private VBox actionsUI() {
        VBox actions = new VBox();
        actions.setStyle("-fx-alignment: center;");
        actions.setSpacing(5);

        Button edit = new Button("edit");
        edit.getStyleClass().addAll("button", "text");
        edit.setOnAction(event -> {
            System.out.println("is Editing");
        });

        Button delete = new Button("delete");
        delete.getStyleClass().addAll("button", "text");
        delete.setOnAction(event -> {
            System.out.println("is Delete");
        });

        actions.getChildren().addAll(edit, delete);

        return actions;
    }
}
