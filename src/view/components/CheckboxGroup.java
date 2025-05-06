package view.components;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CheckboxGroup extends VBox {

    public CheckboxGroup(String title, ArrayList<CheckOption> items) {
        super(5);
        Label label = new Label(title);
        this.getChildren().add(label);

        for (CheckOption item : items) {
            HBox box = new HBox(5);
            // checkbox
            CheckBox checkbox = new CheckBox();
            checkbox.setId(item.getLabel());
            checkbox.setSelected(item.isStatus());

            // text
            Label text = new Label(item.getValue());
            text.getStyleClass().add("text");

            box.getChildren().addAll(checkbox, text);
            this.getChildren().add(box);
        }
    }
}
