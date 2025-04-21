package view;
import javafx.scene.control.Button;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ItemWithActions extends Item {
    private boolean isChecked;
    private VBox actions  = new VBox(); // значення для dropdown

    public ItemWithActions(String value) {
        super(value);

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

        this.actions.setStyle("-fx-alignment: center;");
        this.actions.setSpacing(5);
        this.actions.getChildren().addAll(edit, delete);
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked() {
        this.isChecked = !this.isChecked;
    }

    public VBox getActions() {
        return actions;
    }

    public HBox draw() {
        HBox itemContainer = new HBox();
        itemContainer.getStyleClass().add("list__item");
        itemContainer.setSpacing(10);
        CheckBox checkBox = new CheckBox();
        checkBox.getStyleClass().add("list__checkbox");
        checkBox.setSelected(this.isChecked);

        Label text = new Label(this.getValue());
        text.getStyleClass().add("list__text");



        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);


        CustomDropdown dropdown = new CustomDropdown(this.actions, "custom", getClass().getResource("../resources/more_vert.png"));

        itemContainer.getChildren().addAll(checkBox, text, spacer, dropdown);

        return itemContainer;
    }
}
