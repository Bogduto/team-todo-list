package userInterface.Input;

import java.awt.event.*;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
{
    private final Keyboard keyboardInput = new Keyboard();
    private final MouseInput mouseInput = new MouseInput();

    public Keyboard getKeyboardInput()
    {
        return keyboardInput;
    }

    public MouseInput getMouseInput()
    {
        return mouseInput;
    }

    @Override
    public void keyTyped(KeyEvent keyboardEvent)
    {
        keyboardInput.keyTyped(keyboardEvent);
    }

    @Override
    public void keyPressed(KeyEvent keyboardEvent)
    {
        keyboardInput.keyPressed(keyboardEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyboardEvent)
    {
        keyboardInput.keyReleased(keyboardEvent);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {
        mouseInput.mouseClicked(mouseEvent);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent)
    {
        mouseInput.mousePressed(mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent)
    {
        mouseInput.mouseReleased(mouseEvent);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent)
    {
        mouseInput.mouseEntered(mouseEvent);
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent)
    {
        mouseInput.mouseExited(mouseEvent);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent)
    {
        mouseInput.mouseDragged(mouseEvent);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent)
    {
        mouseInput.mouseMoved(mouseEvent);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent)
    {
        mouseInput.mouseWheelMoved(mouseWheelEvent);
    }
}
