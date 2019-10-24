package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPanel extends JPanel {
    private static MainPanel instance = null;
    private static JPanel panel;
    ImageLoader imageLoader = ImageLoader.getInstance();

    private MainPanel()
    {
        setup();
    }

    public static JPanel getPanel()
    {
        return panel;
    }

    private void setup()
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.RED);
        panel.setName("Main");

        ImageIcon backgroundIcon = imageLoader.get("/assets/background.png");
        Image backgroundImage = backgroundIcon
                .getImage()
                .getScaledInstance(Window.getWindowWidth(), Window.getWindowHeight(), Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0,0,Window.getWindowWidth(), Window.getWindowHeight());

        ImageIcon playIcon = imageLoader.get("/assets/play.gif");
        JLabel playLabel = new JLabel(playIcon);


        int playButtonX = Window.getWindowWidth()/2 - playIcon.getIconWidth()/2;
        int playButtonY = 2*Window.getWindowHeight()/3 - playIcon.getIconHeight()/2;

        playLabel.setBounds(playButtonX,playButtonY,playIcon.getIconWidth(),playIcon.getIconHeight());
        playLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PanelManager.switchPanels();
                ApplicationManager.getInstance().setup();
            }

        });
        //border
        //playLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE,5));
        playLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("HOVERING");

                int width = playIcon.getIconWidth();
                int height = playIcon.getIconHeight();

                int xOffset = (int)(0.1*width);
                int yOffset = (int)(0.1*height);
                int newWidth = width + 2*xOffset;
                int newHeight = height+ 2*yOffset;

                playLabel.setBounds(playButtonX - xOffset,playButtonY - yOffset ,newWidth,newHeight);
                Image playImage = playIcon
                        .getImage()
                        .getScaledInstance(playLabel.getWidth(), playLabel.getHeight(), Image.SCALE_SMOOTH);
                playLabel.setIcon(new ImageIcon(playImage));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                playLabel.setBounds(playButtonX,playButtonY,playIcon.getIconWidth(),playIcon.getIconHeight());
                Image playImage = playIcon
                        .getImage()
                        .getScaledInstance(playLabel.getWidth(), playLabel.getHeight(), Image.SCALE_SMOOTH);
                playLabel.setIcon(new ImageIcon(playImage));
            }

        });

        addComponent(playLabel,0);
        addComponent(backgroundLabel,1);
    }

    public static void addComponent(Component c, int index)
    {
        if( c!= null)
        {
            panel.add(c);
            panel.setComponentZOrder(c,index);
        }
    }

    public static MainPanel getInstance()
    {
        if (instance == null)
            instance = new MainPanel();

        return instance;
    }
}
