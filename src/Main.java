import ui.contollers.RootController;
import ui.views.RootView;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {

        ArrayList<String> items = new ArrayList<>(Arrays.asList("Элемент 1", "Элемент 2", "Элемент 3", "Элемент 4"));

        JFrame frame = new JFrame("Todo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);

        RootController rootController = new RootController(items);

        JPanel root = new RootView(rootController).getPanel();

        frame.getContentPane().add(root);

        frame.setVisible(true);
    }
}

