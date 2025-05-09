package ui.views;
import javax.swing.*;

public class HeaderView {

    public HeaderView() {

    }

    public JPanel getView() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel leftPanel = new JPanel();

        JLabel title = new JLabel("Todo");

        JButton button = new JButton("Сортування");

        JButton button1 = new JButton("Фільтр");

        leftPanel.add(title);
        leftPanel.add(button);
        leftPanel.add(button1);

//        memento

        JPanel rightPanel = new JPanel();

        JButton prev = new JButton("<");
        JButton next = new JButton(">");

        rightPanel.add(prev);

        rightPanel.add(next);


        panel.add(leftPanel);

        panel.add(rightPanel);

        return panel;
    }
}
