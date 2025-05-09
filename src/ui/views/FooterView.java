package ui.views;

import javax.swing.*;
import java.awt.*;

public class FooterView {

    public JPanel getView() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setPreferredSize(new Dimension(300, 50));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JTextField input = new JTextField("new ");

        JButton submitButton = new JButton("Add");

        panel.add(input);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(submitButton);

        return panel;

    }
}
