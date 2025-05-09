package ui.views;

import javax.swing.*;

public class RootView {

    HeaderView headerView = new HeaderView();
    MainView mainView = new MainView();
    FooterView footerView = new FooterView();

    public RootView(){}

    public JPanel getPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(headerView.getView());
        panel.add(mainView.getView());

//        panel.add(Box.createVerticalStrut(50));

        panel.add(footerView.getView());

        return panel;
    }

}
