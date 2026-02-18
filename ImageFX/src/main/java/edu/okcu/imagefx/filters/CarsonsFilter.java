
package edu.okcu.imagefx.filters;

import edu.okcu.imagefx.ImageUtil;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CarsonsFilter implements IFilter {
    @Override
    public Image apply(File file) throws IOException {
        BufferedImage img = ImageIO.read(file);

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int pixel = img.getRGB(x, y);
                Color color = new Color(pixel);

                int alpha = color.getAlpha();
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                // Change to Red Color blind filter
                int newRed   = (int)(0.567 * red + 0.433 * green + 0.000 * blue);
                int newGreen = (int)(0.558 * red + 0.442 * green + 0.000 * blue);
                int newBlue  = (int)(0.000 * red + 0.242 * green + 0.758 * blue);

                // Create an Integer for the new values
                int newPixel = (alpha<<24) | (newRed<<16) | (newGreen<<8) | newBlue;
                img.setRGB(x, y, newPixel);
            }
        }
        Image image = ImageUtil.convertBufferedImageToFXImage(img);

        return image;
    }
    
}
