package ui.contollers;
import ui.views.RootView;

import javax.swing.*;

public class RootController {
    private RootView rootView;
    private HeaderController headerController;
    private MainController mainController;
    private FooterController footerController;

    public RootController(RootView rootView,
                          HeaderController headerController,
                          MainController mainController,
                          FooterController footerController) {
        this.rootView = rootView;
        this.headerController = headerController;
        this.mainController = mainController;
        this.footerController = footerController;
    }

    public JPanel getRootPanel() {
        return rootView.getView(this);
    }

    // Геттеры для дочерних контроллеров
    public HeaderController getHeaderController() {
        return headerController;
    }

    public MainController getMainController() {
        return mainController;
    }

    public FooterController getFooterController() {
        return footerController;
    }
}
