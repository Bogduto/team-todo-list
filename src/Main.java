import ui.contollers.FooterController;
import ui.contollers.HeaderController;
import ui.contollers.MainController;
import ui.contollers.RootController;
import ui.views.FooterView;
import ui.views.HeaderView;
import ui.views.MainView;
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

//      views
        RootView rootView = new RootView();

        HeaderView headerView = new HeaderView();
        MainView mainView = new MainView();
        FooterView footerView = new FooterView();
//      controllers

        HeaderController headerController = new HeaderController(headerView);
        MainController mainController = new MainController(mainView, items);
        FooterController footerController = new FooterController(footerView);

//        root controller
        RootController rootController = new RootController(
                rootView, headerController, mainController, footerController
        );



        frame.getContentPane().add(rootController.getRootPanel());

        frame.setVisible(true);
    }
}

