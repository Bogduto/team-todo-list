package userInterface.Components;

import userInterface.Core.Renderable;
import userInterface.Core.Updatable;
import userInterface.Input.InputHandler;
import userInterface.Views.TagWrapper;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ScrollPanel implements Renderable, Updatable
{
    private final ArrayList<TagWrapper> contents = new ArrayList<>(Arrays.asList(
            new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(),
            new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(),
            new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(),
            new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(),
            new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(),
            new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(),
            new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(),
            new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(),
            new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(),
            new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper(), new TagWrapper()
    ));

    private final InputHandler inputHandler;
    private final Point position;
    private final Rectangle bounds;
    private final Dimension size;

    private final int gapY;
    private final int maxVisibleElements;
    private final int scrollStep;

    private int scrollOffset = 0;

    public ScrollPanel(Point position, Dimension size, InputHandler inputHandler, int gapY, int maxVisibleElements, int scrollStep)
    {
        this.position = position;
        this.size = size;
        this.inputHandler = inputHandler;
        this.gapY = gapY;
        this.maxVisibleElements = maxVisibleElements;
        this.scrollStep = scrollStep;

        this.bounds = new Rectangle(position, size);

        updateElementsPosition();
    }

    @Override
    public void update()
    {
        if (isCursorInside() && inputHandler != null)
        {
            handleScrollInput();
        }
    }

    private boolean isCursorInside()
    {
        return bounds.contains(inputHandler.getMouseInput().getCurrentMousePosition());
    }

    private void handleScrollInput()
    {
        int wheelDelta = inputHandler.getMouseInput().getAndResetWheelRotation();
        if (wheelDelta != 0)
        {
            setScrollOffset(scrollOffset + wheelDelta * scrollStep);
            updateElementsPosition();
        }
    }

    public void updateElementsPosition()
    {
        if (contents.isEmpty()) return;

        int maxOffset = Math.max(0, contents.size() - maxVisibleElements);
        scrollOffset = Math.min(Math.max(scrollOffset, 0), maxOffset);

        int elementsToShow = Math.min(maxVisibleElements, contents.size() - scrollOffset);

        int totalHeight = 0;
        for (int i = scrollOffset; i < scrollOffset + elementsToShow; i++)
        {
            totalHeight += contents.get(i).getSize().height;
            if (i < scrollOffset + elementsToShow - 1) totalHeight += gapY;
        }

        int offsetY = (size.height - totalHeight) / 2;

        int currentY = offsetY;
        int labelIndex = scrollOffset + 1;

        for (int i = 0; i < contents.size(); i++)
        {
            TagWrapper element = contents.get(i);
            Dimension elementSize = element.getSize();

            if (i >= scrollOffset && i < scrollOffset + maxVisibleElements)
            {
                Point elementPosition = new Point(
                        position.x + (size.width - elementSize.width) / 2,
                        position.y + currentY
                );
                element.setScreenPosition(elementPosition);
                element.setInView(true);
                element.getTag().setTextContent("Tag text " + labelIndex++);
                currentY += elementSize.height + gapY;
            } else
            {
                element.setInView(false);
            }
        }
    }

    @Override
    public void render(Graphics2D graphics2D)
    {
        for (TagWrapper element : contents)
        {
            element.render(graphics2D);
        }
    }

    public int getScrollOffset()
    {
        return scrollOffset;
    }

    public void setScrollOffset(int offset)
    {
        int maxOffset = Math.max(0, contents.size() - maxVisibleElements);
        this.scrollOffset = Math.min(Math.max(offset, 0), maxOffset);
    }
}
