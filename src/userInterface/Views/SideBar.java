package userInterface.Views;

import userInterface.Components.Button;
import userInterface.Components.DecoratedPanel;
import userInterface.Components.ScrollPanel;
import userInterface.Components.Text;
import userInterface.Assets.Fonts;
import userInterface.Core.Renderable;
import userInterface.Config.WindowConfig;
import userInterface.Core.Updatable;
import userInterface.Input.InputHandler;

import java.awt.*;

public class SideBar implements Renderable, Updatable
{
    private final InputHandler inputHandler;

    private final Color backgroundColor = new Color(255, 255, 255);
    private final Color backgroundShadowColor = new Color(0, 0, 0, 3);
    private final Color buttonColor = new Color(225, 225, 225);
    private final Color buttonTextColor = new Color(0, 0, 0);
    private final Color headerTextColor = Color.BLACK;

    private final int sidebarWidth = 220;
    private final int sidebarMarginBottom = 15;
    private final int sidebarRoundness = 15;

    private final Dimension size = new Dimension(sidebarWidth, WindowConfig.SIZE.height - sidebarMarginBottom);
    private final Point screenPosition = new Point(7, (WindowConfig.SIZE.height - size.height) / 2);


    private final int shadowExtraWidth = 4;
    private final int shadowExtraHeight = 4;
    private final int shadowOffsetX = shadowExtraWidth;
    private final int shadowOffsetY = shadowExtraHeight;

    private final Point shadowPosition = new Point(
            screenPosition.x - (shadowOffsetX / 2),
            screenPosition.y - (shadowOffsetY / 2)
    );

    private final Dimension shadowSize = new Dimension(
            size.width + shadowExtraWidth,
            size.height + shadowExtraHeight
    );

    private final int buttonWidth = 200;
    private final int buttonHeight = 33;
    private final int buttonRoundness = 30;
    private final int buttonOffsetFromBottom = 50;

    private final Dimension buttonSize = new Dimension(buttonWidth, buttonHeight);

    private final Point addTagButtonPosition = new Point(
            screenPosition.x + (size.width - buttonSize.width) / 2,
            WindowConfig.SIZE.height - buttonOffsetFromBottom
    );

    private final float headerFontSize = 20f;
    private final float buttonFontSize = 16f;

    private final Text header = new Text(
            "Tags",
            new Point(17, 43),
            headerTextColor,
            Fonts.SF_PRO_TEXT_MEDIUM,
            headerFontSize
    );

    private final DecoratedPanel decoratedPanel = new DecoratedPanel(
            backgroundColor,
            screenPosition,
            size,
            sidebarRoundness
    );

    private final DecoratedPanel decoratedPanelShadow = new DecoratedPanel(
            backgroundShadowColor,
            shadowPosition,
            shadowSize,
            sidebarRoundness
    );

    private final Button addTag = new Button(
            buttonColor,
            addTagButtonPosition,
            buttonSize,
            buttonRoundness,
            new Text(
                    "Create tag",
                    addTagButtonPosition,
                    buttonTextColor,
                    Fonts.SF_PRO_TEXT_LIGHT,
                    buttonFontSize,
                    buttonSize
            )
    );

    private final ScrollPanel scrollPanel;

    private final DecoratedPanel tagsScrollPanel = new DecoratedPanel(
            new Color(255, 0, 0, 115),
            new Point(screenPosition.x + 5, screenPosition.y + 48),
            new Dimension(size.width - 10, size.height - 98)
    );

    public SideBar(InputHandler inputHandler)
    {
        this.inputHandler = inputHandler;

        this.scrollPanel = new ScrollPanel(
                new Point(screenPosition.x + 5, screenPosition.y + 48),
                new Dimension(size.width - 10, size.height - 98),
                inputHandler,
                5,
                14,
                1
        );
    }

    @Override
    public void render(Graphics2D graphics2D)
    {
        decoratedPanelShadow.render(graphics2D);
        decoratedPanel.render(graphics2D);
        tagsScrollPanel.render(graphics2D);

        scrollPanel.updateElementsPosition();
        scrollPanel.render(graphics2D);

        header.render(graphics2D);
        addTag.render(graphics2D);
    }

    @Override
    public void update()
    {
        scrollPanel.update();
    }
}
