package ui.contollers;

import ui.views.HeaderView;
import ui.views.MainView;

import javax.swing.*;
import java.util.ArrayList;

public class MainController {
    private ArrayList<String> model;
    private MainView view;

    public MainController(MainView view, ArrayList<String> model) {
        this.view = view;
        this.model = model;
    }

    public ArrayList<String> getItems() {
        return model;
    }

    //    view
    public JScrollPane getView() {
        return view.getView(getItems());
    }

    public void updateItems(ArrayList<String> newItems) {
        this.model = newItems;
        view.refreshView(model);
    }

}
