package view.components;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.Node;

import context.AppContext;
import model.ItemState;

public class ItemWithActions {
    private ItemState item;
    private boolean isEditing = false;
    private HBox itemContainer;

    public ItemWithActions(ItemState item) {
        this.item = item;
    }

    public void setIsEditing(boolean isEditing) {
        this.isEditing = isEditing;
    }

    public HBox draw() {
        itemContainer = new HBox();
        itemContainer.getStyleClass().add("list__item");
        itemContainer.setSpacing(10);

        CheckBox checkBox = new CheckBox();
        checkBox.getStyleClass().add("list__checkbox");
        checkBox.setSelected(item.isChecked());
        checkBox.setOnAction(e -> AppContext.getTodosService().changeActiveTask(item.getId(), checkBox.isSelected()));

        Node textNode = createTextNode();

        Region spacer = new Region();
        if (!isEditing) {
            HBox.setHgrow(spacer, Priority.ALWAYS);
        }

        VBox actions = this.actionsUI();

        CustomDropdown dropdown = new CustomDropdown(actions, "custom", getClass().getResource("../../resources/more_vert.png"));

        if (!isEditing) {
            itemContainer.getChildren().addAll(checkBox, textNode, spacer, dropdown);
        } else {
            itemContainer.getChildren().addAll(checkBox, textNode, dropdown);
        }

        return itemContainer;
    }


    private Node createTextNode() {
        Node textNode = this.isEditing ? new TextField(item.getValue()) : new Label(item.getValue());

        if (this.isEditing && textNode instanceof TextField tf) {
            tf.getStyleClass().addAll("input", "text");

            HBox.setHgrow(tf, Priority.ALWAYS);

            tf.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
                if (!isNowFocused) {
                    // Сохраняем текст обратно в модель
                    item.setValue(tf.getText());
                    setIsEditing(false);
                    replaceTextNode(tf.getText());
                }
            });
        } else if (!this.isEditing && textNode instanceof Label lbl) {
            lbl.getStyleClass().add("list__text");
        }

        return textNode;
    }


    private void replaceTextNode(String value) {
        Node newTextNode = createTextNode();

        if (value != null && !value.trim().isEmpty()) {
            AppContext.getTodosService().editTask(item.getId(), value);
        }

        itemContainer.getChildren().set(1, newTextNode);
    }

    private VBox actionsUI() {
        VBox actions = new VBox();
        actions.setStyle("-fx-alignment: center;");
        actions.setSpacing(5);

        Button edit = new Button("edit");
        edit.getStyleClass().addAll("button", "text");
        edit.setOnAction(event -> {
            setIsEditing(true);
            replaceTextNode(null);
        });

        Button delete = new Button("delete");
        delete.getStyleClass().addAll("button", "text");
        delete.setOnAction(event -> {
            AppContext.getTodosService().removeTask(item.getId());
        });

        actions.getChildren().addAll(edit, delete);

        return actions;
    }
}
