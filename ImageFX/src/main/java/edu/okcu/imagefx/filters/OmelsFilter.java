package edu.okcu.imagefx.filters;

import edu.okcu.imagefx.ImageUtil;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OmelsFilter implements IFilter {
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

                //  Blue Tint Filter
                red = red / 2;
                green = green / 2;
                blue = Math.min(255, blue + 80);

                // Create an Integer for the new values
                int newPixel = (alpha<<24) | (red<<16) | (green<<8) | blue;
                img.setRGB(x, y, newPixel);
            }
        }
        Image image = ImageUtil.convertBufferedImageToFXImage(img);

        return image;
    }
}
