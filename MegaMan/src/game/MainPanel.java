package game;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private static MainPanel instance = null;
    private static JPanel panel;

    private MainPanel()
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.RED);
        panel.setName("Main");
    }

    public static JPanel getPanel()
    {
        return panel;
    }

    public static MainPanel getInstance()
    {
        if (instance == null)
            instance = new MainPanel();

        return instance;
    }
}
