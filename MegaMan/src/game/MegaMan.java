package game;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class MegaMan {

    private static MegaMan instance = null;
    private static JLabel label = new JLabel();

    private static int x=100;
    private static int y=40;

    private static boolean runRight = false;
    private static boolean runLeft = false;


    ImageLoader imageLoader = ImageLoader.getInstance();

    private static HashMap<Integer, ImageIcon> icons;
    private static int currentIcon = 0;

    private MegaMan()
    {
        icons = imageLoader.getAll("/assets/running/");
        System.out.println("Icons:" + icons);
    }

    public static MegaMan getInstance()
    {
        if (instance == null)
            instance = new MegaMan();

        return instance;
    }

    private void addKeyListener()
    {
        JPanel panel = GamePanel.getPanel();
        System.out.println("Adding key listener");
        panel.addKeyListener(new KeyListener(){

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                if (e.getKeyCode() == KeyEvent.VK_W)
                {
                    System.out.println("Pressed W");
                }
                if (e.getKeyCode() == KeyEvent.VK_D)
                {
                    runRight = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A)
                {
                    runLeft = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                if (e.getKeyCode() == KeyEvent.VK_W)
                {
                    System.out.println("Released W");
                }
                if (e.getKeyCode() == KeyEvent.VK_D)
                {
                    runRight = false;
                    currentIcon = 0;
                }
                if (e.getKeyCode() == KeyEvent.VK_A)
                {
                    runLeft = false;
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

        });
    }

    public void render(GamePanel gamePanel)
    {
        Thread running = new Thread() {
            public void run() {
                while(true)
                {
                    label.setIcon(icons.get(currentIcon));
                    label.setBounds(x,y,40,50);

                    if(runRight) {
                        x = x + 10;
                        label.setIcon(icons.get(currentIcon));
                        if(currentIcon < icons.size() -1)
                        {
                            currentIcon++;
                        } else{
                            currentIcon=0;
                        }

                    }

                    if(runLeft) {
                        x = x - 10;
                    }

                    try{
                        Thread.sleep(50);
                    }
                    catch (Exception e)
                    {

                    }
                }
            }
        };
        running.start();


        addKeyListener();
//        try {
//            BufferedImage i = ImageIO.read(this.getClass().getResource("../assets/running.gif"));
//            Icon ii = new ImageIcon(i);
//            label.setIcon(ii);
//            label.setBounds(x,y,40,50);
//
//            Thread running = new Thread()
//            {
//                public void run() {
//                    int i = 0;
//                    while(true)
//                    {
//                        HashMap<Integer, ImageIcon> g = imageLoader.getAll("/assets/running/");
//                        label.setIcon(g.get(i));
//                        if(i < g.size() -1)
//                        {
//                            i++;
//                        } else{
//                            i=0;
//                        }
//                        try{
//                            Thread.sleep(100);
//                        }
//                        catch (Exception e)
//                        {
//
//                        }
//                    }
//                }
//            };
//            running.start();
//        }
//        catch (Exception e) {
//
//        }
        gamePanel.addComponent(label);
    }
}
