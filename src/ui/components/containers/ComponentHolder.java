package ui.components.containers;

import ui.components.Renderable;

import java.awt.*;
import java.util.ArrayList;

public class ComponentHolder implements Renderable
{
    private final ArrayList<Renderable> childComponents;

    public ComponentHolder(ArrayList<Renderable> components)
    {
        this.childComponents = components != null ? components : new ArrayList<>();
    }

    public void addComponent(Renderable component)
    {
        childComponents.add(component);
    }

    public void removeComponent(Renderable component)
    {
        childComponents.remove(component);
    }

    @Override
    public void render(Graphics2D graphics2D)
    {
        for (Renderable component : childComponents)
        {
            component.render(graphics2D);
        }
    }
}