package view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;

public class CreateTodoForm {
    private String value;
    private final VBox layout = new VBox(10);

    public Pane todoForm() {
        TextField tf = new TextField();
        tf.getStyleClass().addAll("input", "text");
        tf.setPromptText("\uD83E\uDD51 авокадо");

        Button submitButton = new Button("Додати");
        submitButton.getStyleClass().addAll("button", "button-submit", "button-submit__text");
        submitButton.setOnAction(e -> {
            value = tf.getText();
            // Тут логика добавления нового todo
            System.out.println("Добавлена задача: " + value);
        });

        this.layout.getChildren().addAll(tf, submitButton);

        this.layout.setStyle("-fx-padding: 20 10 40 10;");

        return this.layout;

    }
}
