package context;

import javafx.collections.FXCollections;
import model.Todos;
import schemas.Task;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Класс який дає змогу не пересоздавати необхідні класи в якій є логика
 * */
public class AppContext {
    private static final Todos todosService = new Todos(FXCollections.observableArrayList(
            new Task("1", "c", "Finish dark souls 3", false)
    ));


    private AppContext() {}

    public static Todos getTodosService() {
        return todosService; // повертає всі методи
    }
}

