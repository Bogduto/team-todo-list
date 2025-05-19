package userInterface;

import userInterface.Components.ComponentHolder;
import userInterface.Core.MainWindow;
import userInterface.Core.Renderable;
import userInterface.Input.InputHandler;
import userInterface.Views.Background;
import userInterface.Views.SideBar;
import java.util.ArrayList;
import java.util.List;

public class UserInterface
{
    private final MainWindow mainWindow;
    private final InputHandler inputHandler;

    public UserInterface()
    {
        this.mainWindow = new MainWindow();
        inputHandler = mainWindow.getMainPanel().getInputHandler();

        ComponentHolder componentHolder = mainWindow.getMainPanel().getChildComponents();

        ArrayList<Renderable> components = new ArrayList<>(List.of(
                new Background(),
                new SideBar(inputHandler)
        ));

        componentHolder.addComponents(components);
    }

    public void run()
    {
        mainWindow.run();
    }
}
