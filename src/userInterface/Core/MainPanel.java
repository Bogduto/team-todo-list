package userInterface.Core;

import userInterface.Components.ComponentHolder;
import userInterface.Config.RenderQuality;
import userInterface.Config.WindowConfig;
import userInterface.Input.InputHandler;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel implements Updatable
{
    private final ComponentHolder childComponents;
    private final InputHandler inputHandler;

    public MainPanel()
    {
        this.childComponents = new ComponentHolder();

        setPreferredSize(WindowConfig.SIZE);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        inputHandler = new InputHandler();

        addKeyListener(inputHandler);
        addMouseListener(inputHandler);
        addMouseMotionListener(inputHandler);
        addMouseWheelListener(inputHandler);
    }

    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderQuality.applyHighQualityRendering(graphics2D);

        childComponents.render(graphics2D);

        graphics2D.dispose();
    }

    @Override
    public void update()
    {
        childComponents.update();
    }

    public InputHandler getInputHandler()
    {
        return inputHandler;
    }

    public ComponentHolder getChildComponents()
    {
        return childComponents;
    }
}
