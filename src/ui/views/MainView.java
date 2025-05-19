package ui.views;

import ui.contollers.RootController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainView {
    private JPanel checkBoxPanel;
    private JScrollPane scrollPane;

    public MainView() {
        checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(checkBoxPanel);
        scrollPane.setPreferredSize(new Dimension(400, 400));
    }

    public JScrollPane getView(ArrayList<String> items) {
        refreshView(items); // рисуем изначально
        return scrollPane;
    }

    public void refreshView(ArrayList<String> items) {
        checkBoxPanel.removeAll(); // удаляем старые элементы

        for (String item : items) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.X_AXIS));

            JCheckBox checkBox = new JCheckBox(item);
            itemPanel.add(checkBox);

            itemPanel.add(Box.createHorizontalGlue());

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

            JButton editButton = new JButton("E");
            JButton deleteButton = new JButton("X");

            buttonPanel.add(editButton);
            buttonPanel.add(Box.createHorizontalStrut(5));
            buttonPanel.add(deleteButton);

            itemPanel.add(buttonPanel);
            checkBoxPanel.add(itemPanel);
        }

        checkBoxPanel.revalidate(); // обновляем UI
        checkBoxPanel.repaint();
    }
}
