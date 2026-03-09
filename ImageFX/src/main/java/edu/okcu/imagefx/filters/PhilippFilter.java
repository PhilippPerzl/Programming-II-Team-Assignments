package edu.okcu.imagefx.filters;

import edu.okcu.imagefx.ImageUtil;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PhilippFilter implements IFilter {
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

                // Philipp Filter (=Negative Filter meaning it basically just inverts colors. For example black becomes white and white becomes black)
                int newRed = 255 - red;
                int newGreen = 255 - green;
                int newBlue = 255 - blue;

                int newPixel = (alpha << 24) | (newRed << 16) | (newGreen << 8) | newBlue;
                img.setRGB(x, y, newPixel);
            }
        }

        return ImageUtil.convertBufferedImageToFXImage(img);
    }
}