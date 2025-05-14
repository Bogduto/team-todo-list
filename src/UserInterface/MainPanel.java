package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPanel extends JPanel
{
    private final ComponentHolder childComponents;

    public MainPanel(ArrayList<Renderable> components)
    {
        this.childComponents = new ComponentHolder(components);

        setPreferredSize(WindowConfig.SIZE);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        childComponents.render((Graphics2D) graphics);
    }
}
