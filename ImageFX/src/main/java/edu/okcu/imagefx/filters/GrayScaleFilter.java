package edu.okcu.imagefx.filters;

import edu.okcu.imagefx.ImageUtil;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GrayScaleFilter implements IFilter {
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

                // Change to Gray Scale
                int newColor = (red + blue + green) / 3;



                // Create an Integer for the new values
                int newPixel = (alpha<<24) | (newColor<<16) | (newColor<<8) | newColor;
                img.setRGB(x, y, newPixel);
            }
        }
        Image image = ImageUtil.convertBufferedImageToFXImage(img);

        return image;
    }
}
