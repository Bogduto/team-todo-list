package userInterface.Components;

import userInterface.Core.Renderable;

import java.awt.*;

public class Button implements Renderable
{
    private final Color backgroundColor;
    private final Point screenPosition;
    private final Dimension size;
    private final int roundness;

    private final Text text;

    private final DecoratedPanel background;

    public Button(Color backgroundColor, Point screenPosition, Dimension size, int roundness, Text text)
    {
        this.backgroundColor = backgroundColor;
        this.screenPosition = screenPosition;
        this.size = size;
        this.roundness = roundness;
        this.text = text;

        background = new DecoratedPanel(
                backgroundColor,
                screenPosition,
                size,
                roundness
        );
    }

    @Override
    public void render(Graphics2D graphics2D)
    {
        background.render(graphics2D);
        text.render(graphics2D);
    }

    public Color getBackgroundColor()
    {
        return backgroundColor;
    }

    public Point getScreenPosition()
    {
        return screenPosition;
    }

    public Dimension getSize()
    {
        return size;
    }

    public int getRoundness()
    {
        return roundness;
    }

    public Text getText()
    {
        return text;
    }

    public DecoratedPanel getBackground()
    {
        return background;
    }
}
