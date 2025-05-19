package userInterface.Components;

import userInterface.Core.Renderable;
import userInterface.Core.Updatable;

import java.awt.*;
import java.util.ArrayList;

public class ComponentHolder implements Renderable, Updatable
{
    private final ArrayList<Renderable> childComponents;

    public ComponentHolder(ArrayList<Renderable> components)
    {
        this.childComponents = components != null ? components : new ArrayList<>();
    }

    public ComponentHolder()
    {
        this.childComponents = new ArrayList<>();
    }

    public void addComponent(Renderable component)
    {
        childComponents.add(component);
    }

    public void addComponents(ArrayList<Renderable> components)
    {
        childComponents.addAll(components);
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

    @Override
    public void update()
    {
        for (Renderable renderableComponent : childComponents)
        {
            if (renderableComponent instanceof Updatable updatableComponent)
            {
                updatableComponent.update();
            }
        }
    }
}