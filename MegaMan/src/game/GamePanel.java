package game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private static GamePanel instance = null;
    private static JPanel panel;


    private GamePanel()
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GREEN);
        panel.setName("Game");
    }


    public static JPanel getPanel()
    {
        return panel;
    }

    public static GamePanel getInstance()
    {
        if (instance == null)
            instance = new GamePanel();

        return instance;
    }
}
