package game;

import javax.swing.*;

public class PanelManager {

    private static PanelManager instance = null;
    private static JPanel currentPanel = null;
    private static JPanel mainPanel;
    private static JPanel gamePanel;

    private PanelManager()
    {
        mainPanel = MainPanel.getInstance().getPanel();
        gamePanel = GamePanel.getInstance().getPanel();
        setInitialPanel();
    }

    private static void setInitialPanel()
    {
        currentPanel = mainPanel;
    }

    public static JPanel getCurrentPanel()
    {
        return currentPanel;
    }

    public static void switchPanels()
    {
        mainPanel.setVisible(false);
        gamePanel.setVisible(false);
        if (currentPanel == mainPanel)
        {
            currentPanel = gamePanel;
        } else if(currentPanel == gamePanel)
        {
            currentPanel = mainPanel;
        }
    }

    public static PanelManager getInstance()
    {
        if (instance == null)
            instance = new PanelManager();

        return instance;
    }
}
