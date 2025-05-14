package UserInterface;

import UserInterface.Components.SideBar;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UserInterface
{
    private final MainWindow mainWindow;

    public UserInterface()
    {
        ArrayList<Renderable> components = new ArrayList<>(List.of(
//            new CustomComponent()
                new SideBar()
        ));

        this.mainWindow = new MainWindow(components);
    }

    public void run()
    {
        mainWindow.show();
    }
}

class CustomComponent implements Renderable
{
    @Override
    public void render(Graphics2D graphics2D)
    {
        graphics2D.setColor(Color.blue);
        graphics2D.fillRect(100, 100, 600, 150);
        graphics2D.setColor(Color.white);
        graphics2D.setFont(new Font("Arial", Font.PLAIN, 30));
        graphics2D.drawString("---itallo---0---itallo---", 110, 160);
    }
}
