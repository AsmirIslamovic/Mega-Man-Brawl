package game;

import javax.swing.*;
import java.awt.*;

public class Window {

    private static Window instance = null;
    public static JFrame window;

    private static int WINDOW_WIDTH = 1080;
    private static int WINDOW_HEIGHT = 720;

    private Window() {
        window = new JFrame("MegaMan!");
        window.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
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
    public static int getWindowHeight()
    {
        return WINDOW_HEIGHT;
    }
    public static int getWindowWidth()
    {
        return WINDOW_WIDTH;
    }
}