package userInterface.Core;

import userInterface.Config.WindowConfig;

import javax.swing.*;

public class MainWindow
{
    private final JFrame window = new JFrame();
    private final MainPanel mainPanel;
    private final Loop loop;

    public MainWindow()
    {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle(WindowConfig.NAME);

        mainPanel= new MainPanel();
        window.add(mainPanel);
        loop = new Loop(mainPanel);
        window.pack();

        window.setLocationRelativeTo(null);
    }

    public void run()
    {
        loop.start();
        window.setVisible(true);
    }

    public MainPanel getMainPanel()
    {
        return mainPanel;
    }
}
