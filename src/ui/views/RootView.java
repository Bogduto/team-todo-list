package ui.views;

import ui.contollers.HeaderController;
import ui.contollers.RootController;

import javax.swing.*;

public class RootView {
    public JPanel getView(RootController controller) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(controller.getHeaderController().getView());
        panel.add(controller.getMainController().getView());
        panel.add(controller.getFooterController().getView());

        return panel;
    }
}

