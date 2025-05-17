package ui.components;

import ui.components.containers.ComponentHolder;
import ui.configs.WindowConfig;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPanelCustom extends JPanel
{
    private final ComponentHolder childComponents;

    public JPanelCustom(ArrayList<Renderable> components)
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