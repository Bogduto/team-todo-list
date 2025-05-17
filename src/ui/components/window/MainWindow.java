package ui.components.window;

import ui.components.JPanelCustom;
import ui.components.Renderable;
import ui.configs.WindowConfig;

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

        window.add(new JPanelCustom(components));
        window.pack();

        window.setLocationRelativeTo(null);
    }

    public void show()
    {
        window.setVisible(true);
    }
}