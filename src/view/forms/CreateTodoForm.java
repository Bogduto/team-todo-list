package view.forms;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.function.Consumer;

public class CreateTodoForm {

    private final Consumer<String> onSubmit;

    public CreateTodoForm(Consumer<String> onSubmit) {
        this.onSubmit = onSubmit;

    }


    public VBox todoForm() {
        VBox layout = new VBox(10);

        TextField tf = new TextField();
        tf.getStyleClass().addAll("input", "text");
        tf.setPromptText("\uD83E\uDD51 авокадо");

        Button submitButton = new Button("Додати");
        submitButton.getStyleClass().addAll("button", "button-submit", "button-submit__text");

        submitButton.setOnAction(e -> {
            String value = tf.getText();
            if (value != null && !value.trim().isEmpty()) {
                onSubmit.accept(value); // callback
                tf.setText("");
            } else {
                System.out.println("Будьласка введіть задачу.");
            }
        });

        layout.getChildren().addAll(tf, submitButton);
        layout.setStyle("-fx-padding: 20 10 40 10;");

        return layout;
    }
}
