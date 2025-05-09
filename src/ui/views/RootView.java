package ui.views;

import ui.contollers.RootController;

import javax.swing.*;

public class RootView {

    RootController root;

    HeaderView headerView;
    MainView mainView;
    FooterView footerView;

    public RootView(RootController root) {
        this.root = root;

        headerView = new HeaderView();
        mainView = new MainView(root);
        footerView = new FooterView();

    }

    public JPanel getPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(headerView.getView());
        panel.add(mainView.getView());

        panel.add(Box.createVerticalStrut(20));

        panel.add(footerView.getView());

        return panel;
    }

}
