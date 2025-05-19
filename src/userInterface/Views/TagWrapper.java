package userInterface.Views;

import userInterface.Assets.Fonts;
import userInterface.Components.Button;
import userInterface.Components.Text;
import userInterface.Core.Renderable;

import java.awt.*;

public class TagWrapper implements Renderable
{
    private Point screenPosition = new Point(0, 0); // Default pos
    private final Color textColor = new Color(122, 40, 40);
    private final int fontSize = 15;


    private final Color color = new Color(255, 255, 255);
    private final Dimension size = new Dimension(180, 28);
    private final int roundness = 18;

    public boolean isInView = false;

    private final Text tag = new Text(
            "Tag text",
            screenPosition,
            textColor,
            Fonts.SF_PRO_TEXT_LIGHT,
            fontSize,
            size
    );

    private final Button button = new Button(
            color,
            screenPosition,
            size,
            roundness,
            tag
    );

    @Override
    public void render(Graphics2D graphics2D)
    {
        if (!isInView) return;

        button.render(graphics2D);
        tag.render(graphics2D);
    }

    public void setScreenPosition(Point screenPosition)
    {
        this.screenPosition = screenPosition;
        button.getBackground().getScreenPosition().setLocation(screenPosition);
    }

    public Dimension getSize()
    {
        return size;
    }

    public Text getTag()
    {
        return tag;
    }

    public boolean isInView()
    {
        return isInView;
    }

    public void setInView(boolean inView)
    {
        isInView = inView;
    }
}
