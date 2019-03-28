package game;

import javax.swing.*;
import java.awt.*;

public class Window {

    private static Window instance = null;
    public static JFrame window;

    private static int WINDOW_WIDTH = 700;
    private static int WINDOW_HIGHT = 424;

    private Window() {
        window = new JFrame("MegaMan!");
        window.setSize(WINDOW_WIDTH,WINDOW_HIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void add(JPanel x)
    {
        window.getContentPane().add(x);
        window.setVisible(true);
        window.requestFocus();
    }

    public static Window getInstance()
    {
        if (instance == null)
            instance = new Window();

        return instance;
    }
}