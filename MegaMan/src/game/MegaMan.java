package game;

import javax.swing.*;

public class MegaMan {

    private static MegaMan instance = null;
    private static JLabel label;

    private static int x;
    private static int y;

    private static ImageIcon[] icons;

    private  MegaMan()
    {

    }

    public static MegaMan getInstance()
    {
        if (instance == null)
            instance = new MegaMan();

        return instance;
    }
}
