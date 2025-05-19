package userInterface.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class Keyboard implements KeyListener
{
    private final Set<Integer> keysJustPressed = new HashSet<>();
    private final Set<Integer> keysHeldDown = new HashSet<>();

    public boolean isKeyPressed(int keyCode)
    {
        return keysHeldDown.contains(keyCode);
    }

    public boolean isKeyJustPressed(int keyCode)
    {
        return keysJustPressed.remove(keyCode);
    }

    @Override
    public void keyTyped(KeyEvent event)
    {
    }

    @Override
    public void keyPressed(KeyEvent event)
    {
        int keyCode = event.getKeyCode();
        if (!keysHeldDown.contains(keyCode))
        {
            keysJustPressed.add(keyCode);
        }
        keysHeldDown.add(keyCode);
    }

    @Override
    public void keyReleased(KeyEvent event)
    {
        keysHeldDown.remove(event.getKeyCode());
    }
}
