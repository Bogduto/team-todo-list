package ui.components;

import ui.components.window.MainWindow;
import ui.configs.Colors;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UserInterface
{
    private final MainWindow mainWindow;

    public UserInterface()
    {
//        тут будуть компоненти як Sidebar, main, header
        ArrayList<Renderable> components = new ArrayList<>(List.of(
//            new CustomComponent()
                new ButtonCustom(0, 0, 200, 50, "Кнопка", Colors.SIDEBAR_BACKGROUND, Colors.TEXT_PRIMARY)
        ));

        this.mainWindow = new MainWindow(components);
    }

    public void run()
    {
        mainWindow.show();
    }
}
