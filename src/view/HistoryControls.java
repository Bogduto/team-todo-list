package view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HistoryControls {

    public HBox draw() {
        HBox container = new HBox();
        container.setSpacing(2);


        Button buttonLeft = new Button("<");

        buttonLeft.setOnAction(e -> {
            System.out.println("Левая кнопка нажата!");
        });

        Button buttonRight = new Button(">");

        buttonRight.setOnAction(e -> {
            System.out.println("Правая кнопка нажата!");
        });

        container.getChildren().addAll(buttonLeft, buttonRight);

        return container;
    }
}
