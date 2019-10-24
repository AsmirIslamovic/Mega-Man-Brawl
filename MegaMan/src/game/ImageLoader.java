package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;

public class ImageLoader {
    private static ImageLoader instance = null;


    private ImageLoader() { }

    public ImageIcon get(String fileName)
    {
        ImageIcon icon = null;
        try
        {
            BufferedImage image = ImageIO.read(this.getClass().getResource(fileName));
            icon = new ImageIcon(image);
        }
        catch (Exception e)
        {

        }
        return icon;
    }

    public HashMap<Integer, ImageIcon> getAll(String folderName){
        HashMap<Integer, ImageIcon> icons = new HashMap<>() ;
        try {
            File folder = new File(this.getClass().getResource(folderName).toURI());
            if (folder.isDirectory()) {
                for (final File f : folder.listFiles(IMAGE_FILTER)) {

                    BufferedImage img = ImageIO.read(f);

                    ImageIcon icon = new ImageIcon(img);

                    int index = Integer.parseInt(f.getName().split("\\.")[0]);
                    System.out.println(index);

                    icons.put(index, icon);
                }
            }
        }
        catch (Exception e) { }
        return icons;
    }
    static final String[] EXTENSIONS = new String[]{
            "gif", "png", "bmp" // and other formats you need
    };

    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }

    };

    public static ImageLoader getInstance()
    {
        if (instance == null)
            instance = new ImageLoader();

        return instance;
    }
}
