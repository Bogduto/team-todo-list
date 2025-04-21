package view;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;

public class HistoryControls {

    public HBox draw() {
        HBox container = new HBox();
        container.setSpacing(2);

//        IMAGE URL START
        URL undo_icon_url = getClass().getResource("../resources/undo.png");

        if (undo_icon_url == null) {
            throw new RuntimeException("Файл не найден: /resources/undo.png");
        }

        Image image = new Image(undo_icon_url.toString(), 24, 24, true, true);

        ImageView imageView = new ImageView(image);
//      IMAGE URL END
        Button buttonLeft = new Button();
        buttonLeft.setGraphic(imageView);

        buttonLeft.setOnAction(e -> {
            System.out.println("Левая кнопка нажата!");
        });

//        IMAGE URL START
        URL redo_icon_url = getClass().getResource("../resources/redo.png");

        if (redo_icon_url == null) {
            throw new RuntimeException("Файл не найден: /resources/redo.png");
        }

        Image image2 = new Image(redo_icon_url.toString(), 24, 24, true, true);

        ImageView imageView2 = new ImageView(image2);
//      IMAGE URL END

        Button buttonRight = new Button();
        buttonRight.setGraphic(imageView2);


        buttonRight.setOnAction(e -> {
            System.out.println("Правая кнопка нажата!");
        });

        container.getChildren().addAll(buttonLeft, buttonRight);

        return container;
    }
}
