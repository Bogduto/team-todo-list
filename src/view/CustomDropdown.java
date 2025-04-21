package view;

import com.sun.tools.javac.Main;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Window;

import java.net.URL;
import java.util.List;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CustomDropdown extends VBox {
    private final Button triggerButton;
    private final Popup popup;
    private final VBox dropdownContent; // Головний контейнер

    public CustomDropdown(VBox items, String size, URL icon_url) {
        if (icon_url == null) {
            icon_url = getClass().getResource("../resources/arrow_down.png");
        }

        if (icon_url == null) {
            throw new RuntimeException("Файл не найден: /assets/arrow_down.png");
        }

        Image image = new Image(icon_url.toString(), 24, 24, true, true);

        ImageView imageView = new ImageView(image);


        this.triggerButton = new Button();
        this.triggerButton.setGraphic(imageView);
        this.triggerButton.getStyleClass().addAll("button", "button-icon");
        this.dropdownContent = new VBox(5);
        this.popup = new Popup();

        setupItems(items);
        setupPopup();
        setupTrigger(size);

        this.getChildren().add(triggerButton);
    }

    /*
    * Метод який добавляє елементи в список
    * */
    private void setupItems(VBox items) {
        dropdownContent.getChildren().clear();
        dropdownContent.getChildren().add(items);
    }


    /*
     * Метод який показує панель
     * */
    private void setupPopup() {
        dropdownContent.setStyle("-fx-background-color: #EFEFF0; -fx-padding: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 4);");
        popup.getContent().add(dropdownContent);
        popup.setAutoHide(true);
    }



    private void setupTrigger(String size) {

        switch (size) {
            case "custom":
                triggerButton.setOnAction(e -> {
                    if (!popup.isShowing()) {
                        Bounds bounds = triggerButton.localToScreen(triggerButton.getBoundsInLocal());
                        popup.show(triggerButton.getScene().getWindow(), bounds.getMinX(), bounds.getMaxY() + 10);
                    } else {
                        popup.hide();
                    }
                });

                break;
            case "full":
            case "default":
                triggerButton.setOnAction(e -> {
                    if (!popup.isShowing()) {
                        Window window = triggerButton.getScene().getWindow();
                        Bounds bounds = triggerButton.localToScreen(triggerButton.getBoundsInLocal());

                        // Устанавливаем ширину дропдауна = ширине окна
                        double windowWidth = window.getWidth() - 20;
                        dropdownContent.setPrefWidth(windowWidth);

                        double popupWidth = dropdownContent.prefWidth(-1);
                        double popupHeight = dropdownContent.prefHeight(-1);

                        double buttonX = bounds.getMinX();
                        double buttonY = bounds.getMaxY();

                        double windowX = window.getX();
                        double windowY = window.getY();
                        double screenRight = windowX + windowWidth;
                        double screenBottom = windowY + window.getHeight();

                        double showX = windowX; // Левый край окна
                        double showY = buttonY + 10;

                        // Если не помещается по высоте — показать сверху
                        if (showY + popupHeight > screenBottom) {
                            showY = bounds.getMinY() - popupHeight - 10;
                        }

                        popup.show(window, showX, showY);
                    } else {
                        popup.hide();
                    }
                });
                break;
            default:
                // Логика по умолчанию, если нужно
                break;
        }


    }
}
