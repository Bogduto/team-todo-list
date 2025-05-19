package userInterface.Views;

import userInterface.Components.DecoratedPanel;
import userInterface.Core.Renderable;
import userInterface.Config.WindowConfig;

import java.awt.*;

public class Background implements Renderable
{
    private final Color color = new Color(225, 225, 225);
    private final Dimension size = new Dimension(WindowConfig.SIZE.width, WindowConfig.SIZE.height);

    private final DecoratedPanel decoratedPanel = new DecoratedPanel(
            color,
            new Point(0, 0),
            size
    );

    @Override
    public void render(Graphics2D graphics2D)
    {
        decoratedPanel.render(graphics2D);
    }
}
