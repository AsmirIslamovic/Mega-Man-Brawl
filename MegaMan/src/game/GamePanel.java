package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {

    private static GamePanel instance = null;
    private static JPanel panel;

    private GamePanel()
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GREEN);
        panel.setName("Game");

        JLabel label = new JLabel("Hello");
        label.setBounds(50,50,50,50);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Yay you clicked me");
                PanelManager.switchPanels();
                ApplicationManager.getInstance().setup();
            }

        });

        ImageIcon icon = new ImageIcon("../assets/megaman1.png");
        if (icon.getImage() != null){
            System.out.println("There's an image");
            System.out.println(icon.getImage());
        }
        MegaMan megaman = MegaMan.getInstance();
        megaman.render(this);

        addComponent(label);
    }


    public static JPanel getPanel()
    {
        return panel;
    }

    public static void addComponent(Component c)
    {
        if( c!= null)
        {
            panel.add(c);
            panel.setComponentZOrder(c,0);
        }
    }

    public static GamePanel getInstance()
    {
        if (instance == null)
            instance = new GamePanel();

        return instance;
    }
}
