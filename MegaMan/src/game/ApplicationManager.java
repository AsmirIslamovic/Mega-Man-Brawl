package game;

import javax.swing.*;

public class ApplicationManager {
    private static ApplicationManager instance = null;
    private static Window window;
    private static PanelManager panelManager;

    private ApplicationManager()
    {
        window = Window.getInstance();
        panelManager = PanelManager.getInstance();

    }

    public static void setup()
    {
        JPanel currentPanel = panelManager.getCurrentPanel();
        System.out.println(currentPanel.getName());
        currentPanel.setVisible(true);
        window.add(currentPanel);
    }

    public static void flash()
    {
        while (true)
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            panelManager.switchPanels();
            setup();
        }
    }

    public static ApplicationManager getInstance()
    {
        if (instance == null)
            instance = new ApplicationManager();

        return instance;
    }
}
