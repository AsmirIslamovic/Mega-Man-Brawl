package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;

public class ImageLoader {
    private HashMap<Integer, ImageIcon> icons = new HashMap<>();


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

    public ImageLoader(String folderName)
    {
        try {
            File folder = new File(this.getClass().getResource(folderName).toURI());
            if (folder.isDirectory()) {
                for (final File f : folder.listFiles(IMAGE_FILTER)) {

                    BufferedImage img = null;
                    img = ImageIO.read(f);

                    ImageIcon icon = new ImageIcon(img);

                    int index = Integer.parseInt(f.getName().split("\\.")[0]);

                    icons.put(index, icon);
                }
            }
        }
        catch (Exception e) { }
    }

    public int size()
    {
        return icons.size();
    }

    public HashMap<Integer, ImageIcon> getIcons()
    {
        return icons;
    }

}
