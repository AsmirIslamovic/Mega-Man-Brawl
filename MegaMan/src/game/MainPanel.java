package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class MainPanel extends JPanel {
    private static MainPanel instance = null;
    private static JPanel panel;

    private static int x;
    private static int y;


    private MainPanel()
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.RED);
        panel.setName("Main");

        ImageIcon icon = new ImageIcon("../assets/megaman1.png");
        if (icon.getImage() != null){
            System.out.println("There's an image");
            System.out.println(icon.getImage());
        }
        final JLabel wIcon = new JLabel();

        ImageLoader gif = new ImageLoader("/assets/running/" );

        wIcon.setIcon(gif.getIcons().get(0));
        wIcon.setBounds(x,y,40,50);

        try {
            BufferedImage i = ImageIO.read(this.getClass().getResource("../assets/running.gif"));
            Icon ii = new ImageIcon(i);
            wIcon.setIcon(ii);
            wIcon.setBounds(x,y,40,50);

            Thread running = new Thread()
            {
                public void run() {
                    int i = 0;
                    while(true)
                    {
                        wIcon.setIcon(gif.getIcons().get(i));
                        if(i < gif.size() -1)
                        {
                            i++;
                        } else{
                            i=0;
                        }
                        try{
                            Thread.sleep(150);
                        }
                        catch (Exception e)
                        {

                        }
                    }
                }
            };
            running.start();
        }
        catch (Exception e) {

        }




        JLabel label = new JLabel("TEST",icon,10);
        label.setBounds(50,50,40,50);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Yay you clicked me");
                PanelManager.switchPanels();
                ApplicationManager.getInstance().setup();
            }

        });

        addComponent(label);
        addComponent(wIcon);

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

    public static MainPanel getInstance()
    {
        if (instance == null)
            instance = new MainPanel();

        return instance;
    }
}
