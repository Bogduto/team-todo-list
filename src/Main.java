import IO.FileTaskRepository;
import IO.TaskRepository;
import controller.TodoController;
import model.Todos;
import ui.views.RootView;
import view.ConsoleView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    public static void main(String[] args)
    {

        JFrame frame = new JFrame("Simple Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);

        JPanel root = new RootView().getPanel();

        frame.getContentPane().add(root);

        // Отображение окна
        frame.setVisible(true);
    }
}

