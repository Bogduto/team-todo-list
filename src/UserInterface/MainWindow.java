package UserInterface;

import javax.swing.*;
import java.util.ArrayList;

public class MainWindow
{
    private final JFrame window = new JFrame();

    public MainWindow(ArrayList<Renderable> components)
    {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle(WindowConfig.NAME);

        window.add(new MainPanel(components));
        window.pack();

        window.setLocationRelativeTo(null);
    }

    public void show()
    {
        window.setVisible(true);
    }
}
