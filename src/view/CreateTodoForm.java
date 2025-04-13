package view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;

public class CreateTodoForm {
    private String value;
    private final VBox layout = new VBox(10); // вертикальное расположение с отступом

    public Pane todoForm() {
        TextField tf = new TextField();
        tf.setPromptText("Введите задачу");

        Button submitButton = new Button("Добавить");
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
