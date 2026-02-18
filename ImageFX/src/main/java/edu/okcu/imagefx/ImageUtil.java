package edu.okcu.imagefx;

import javafx.scene.image.*;

import java.awt.image.BufferedImage;

public class ImageUtil {
    public static Image convertBufferedImageToFXImage(BufferedImage bImage) {
        WritableImage wr = new WritableImage(bImage.getWidth(), bImage.getHeight());
        if (bImage != null) {
            PixelWriter pw = wr.getPixelWriter();
            
            for (int x = 0; x < bImage.getWidth(); x++) {
                for (int y = 0; y < bImage.getHeight(); y++) {
                    pw.setArgb(x, y, bImage.getRGB(x, y));
                }
            }
        }
        return new ImageView(wr).getImage();
    }


}
