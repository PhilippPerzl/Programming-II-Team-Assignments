package edu.okcu.imagefx;

import edu.okcu.imagefx.filters.GrayScaleFilter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import edu.okcu.imagefx.filters.CarsonsFilter;

public class ImageFXController {
    @FXML
    ImageView imgPhoto;

    @FXML
    ImageView imgPhotoEditied;

    Image image;
    File file;

    @FXML
    protected void onLoadButtonClick() {
        FileChooser chooser = new FileChooser();
        file = chooser.showOpenDialog(null);

        image = new Image(file.toURI().toString());

        imgPhoto.setImage(image);
    }

    public void onConvertGrayScaleClick(ActionEvent actionEvent) throws IOException {
        GrayScaleFilter grayScaleFilter = new GrayScaleFilter();

        Image newImage = grayScaleFilter.apply(file);

        imgPhotoEditied.setImage(newImage);
    }
    public void onConvertCarsonsFilterClick(ActionEvent actionEvent) throws IOException {
        CarsonsFilter carsonsFilter = new CarsonsFilter();

        Image newImage = carsonsFilter.apply(file);

        imgPhotoEditied.setImage(newImage);
    }
}