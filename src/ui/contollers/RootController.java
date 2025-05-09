package ui.contollers;

import java.util.ArrayList;

public class RootController {
    private ArrayList<String> items;

    public RootController(ArrayList<String> items) {
        this.items = items;
    }

    public ArrayList<String> getItems() {
        return items;
    }
}
