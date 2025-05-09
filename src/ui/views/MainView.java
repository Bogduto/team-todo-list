package ui.views;

import javax.swing.*;
import java.awt.*;

public class MainView {

    public JScrollPane getView() {
        String[] items = {"Элемент 1", "Элемент 2", "Элемент 3", "Элемент 4"};

        JCheckBox[] checkboxes = new JCheckBox[items.length];
        for (int i = 0; i < items.length; i++) {
            checkboxes[i] = new JCheckBox(items[i]);
        }

        // Создаем панель для размещения чекбоксов
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
