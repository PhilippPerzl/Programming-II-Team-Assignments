package edu.okcu.imagefx.filters;

import edu.okcu.imagefx.ImageUtil;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SepiaFilter implements IFilter {
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

                // Sepia Filter
                int newRed = (int)((red * 0.393) + (green * 0.769) + (blue * 0.189));
                int newGreen = (int)((red * 0.349) + (green * 0.686) + (blue * 0.168));
                int newBlue = (int)((red * 0.272) + (green * 0.534) + (blue * 0.131));

                newRed = Math.min(255, newRed);
                newGreen = Math.min(255, newGreen);
                newBlue = Math.min(255, newBlue);

                int newPixel = (alpha << 24) | (newRed << 16) | (newGreen << 8) | newBlue;
                img.setRGB(x, y, newPixel);
            }
        }

        return ImageUtil.convertBufferedImageToFXImage(img);
    }
}