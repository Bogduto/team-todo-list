package userInterface.Input;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

public class MouseInput implements MouseListener, MouseMotionListener, MouseWheelListener
{
    private final Set<Integer> mouseButtonsJustPressed = new HashSet<>();
    private final Set<Integer> mouseButtonsHeldDown = new HashSet<>();

    private Point currentMousePosition = new Point(0, 0);
    private int accumulatedWheelRotation = 0;

    public boolean isMouseButtonPressed(int mouseButtonCode)
    {
        return mouseButtonsHeldDown.contains(mouseButtonCode);
    }

    public boolean isMouseButtonJustPressed(int mouseButtonCode)
    {
        return mouseButtonsJustPressed.remove(mouseButtonCode);
    }

    public Point getCurrentMousePosition()
    {
        return currentMousePosition;
    }

    public int getAndResetWheelRotation()
    {
        int rotationDelta = accumulatedWheelRotation;
        accumulatedWheelRotation = 0;
        return rotationDelta;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent)
    {
        int mouseButtonCode = mouseEvent.getButton();
        if (!mouseButtonsHeldDown.contains(mouseButtonCode))
        {
            mouseButtonsJustPressed.add(mouseButtonCode);
        }
        mouseButtonsHeldDown.add(mouseButtonCode);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent)
    {
        mouseButtonsHeldDown.remove(mouseEvent.getButton());
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent)
    {
        currentMousePosition = mouseEvent.getPoint();
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent)
    {
        currentMousePosition = mouseEvent.getPoint();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent)
    {
        accumulatedWheelRotation += mouseWheelEvent.getWheelRotation();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent)
    {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent)
    {
    }
}
