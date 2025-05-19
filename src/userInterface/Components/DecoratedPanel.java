package userInterface.Components;

import userInterface.Core.Renderable;

import java.awt.*;
import java.util.Map;
import java.util.function.Consumer;

public class DecoratedPanel implements Renderable
{
    private final Color color;
    private Point screenPosition;
    private final Dimension size;
    private final int roundness;
    private final boolean isRounded;

    private final Map<Boolean, Consumer<Graphics2D>> backgroundType;

    public DecoratedPanel(Color color, Point screenPosition, Dimension size, int roundness)
    {
        this.color = color;
        this.screenPosition = screenPosition;
        this.size = size;
        this.roundness = roundness;

        this.isRounded = roundness > 0;
        backgroundType = Map.of(
                true, graphics2D -> graphics2D.fillRoundRect(
                        screenPosition.x, screenPosition.y,
                        size.width, size.height,
                        roundness, roundness),
                false, graphics2D -> graphics2D.fillRect(
                        screenPosition.x, screenPosition.y,
                        size.width, size.height)
        );
    }

    public DecoratedPanel(Color color, Point screenPosition, Dimension size)
    {
        this(color, screenPosition, size, 0);
    }

    @Override
    public void render(Graphics2D graphics2D)
    {
        graphics2D.setColor(color);
        backgroundType.get(isRounded).accept(graphics2D);
    }

    public Color getColor()
    {
        return color;
    }

    public Point getScreenPosition()
    {
        return screenPosition;
    }

    public void setScreenPosition(Point screenPosition)
    {
        this.screenPosition = screenPosition;
    }

    public Dimension getSize()
    {
        return size;
    }

    public int getRoundness()
    {
        return roundness;
    }

    public boolean isRounded()
    {
        return isRounded;
    }

    public Map<Boolean, Consumer<Graphics2D>> getBackgroundType()
    {
        return backgroundType;
    }
}
