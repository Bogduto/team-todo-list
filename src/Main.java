import javafx.application.Application;
import javafx.stage.Stage;
import controller.MainViewController;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainViewController controller = new MainViewController(primaryStage);
        controller.showMainView();
    }


    public static void main(String[] args) {
        launch(args);
    }
}