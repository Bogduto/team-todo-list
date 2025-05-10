package ui.contollers;

import ui.views.HeaderView;

import javax.swing.*;
import java.util.ArrayList;

public class HeaderController {
    private HeaderView view;

    public HeaderController(HeaderView view) {
        this.view = view;
//        this.model = model;
    }

//    sort, filter action
    public void setSort() {}
    public void setFilter() {}

//    memento
    public void prevAction() {}
    public void nextAction() {}


//    view
    public JPanel getView() {
        return view.getView();
    }

}
