package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {

    private static GamePanel instance = null;
    private static JPanel panel;

    private static int x=100;
    private static int y=40;

    private GamePanel()
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GREEN);
        panel.setName("Game");
        addKeyListener();

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

    private static void addKeyListener()
    {
        panel.addKeyListener(new KeyListener(){

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                if (e.getKeyCode() == KeyEvent.VK_UP)
                {
                    System.out.println("Pressed up");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                if (e.getKeyCode() == KeyEvent.VK_UP)
                {
                    System.out.println("Released up");
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

        });
    }

    public static GamePanel getInstance()
    {
        if (instance == null)
            instance = new GamePanel();

        return instance;
    }
}
