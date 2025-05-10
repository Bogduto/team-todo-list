package ui.contollers;

import ui.views.FooterView;
import ui.views.MainView;

import javax.swing.*;
import java.util.ArrayList;

public class FooterController {
    private FooterView view;

    public FooterController(FooterView view) {
        this.view = view;
    }

    //    view
    public JPanel getView() {
        return view.getView();
    }
}
