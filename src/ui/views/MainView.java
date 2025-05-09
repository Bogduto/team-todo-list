package ui.views;

import ui.contollers.RootController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainView {
    public ArrayList<String> items;

    public MainView(RootController controller) {
        this.items = controller.getItems();
    }

    public JScrollPane getView() {

        JCheckBox[] checkboxes = new JCheckBox[items.size()];

        for (int i = 0; i < items.size(); i++) {
            checkboxes[i] = new JCheckBox(items.get(i));
        }

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));

        for (JCheckBox checkbox : checkboxes) {
            checkBoxPanel.add(checkbox);
        }

        JScrollPane scrollPane = new JScrollPane(checkBoxPanel);

        scrollPane.setPreferredSize(new Dimension(400, 400));

        return scrollPane;
    }

}
