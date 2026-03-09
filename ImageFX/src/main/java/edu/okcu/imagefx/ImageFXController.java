package edu.okcu.imagefx;

import edu.okcu.imagefx.filters.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

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

    public void onConvertSepiaClick(ActionEvent actionEvent) throws IOException {
        SepiaFilter sepiaFilter = new SepiaFilter();

        Image newImage = sepiaFilter.apply(file);

        imgPhotoEditied.setImage(newImage);
    }

    public void onConvertPhilippFilterClick(ActionEvent actionEvent) throws IOException {
        PhilippFilter philippFilter = new PhilippFilter();

        Image newImage = philippFilter.apply(file);

        imgPhotoEditied.setImage(newImage);
    }

    public void onConvertOmelsFilterClick(ActionEvent actionEvent) throws IOException {
        OmelsFilter omelsFilter = new OmelsFilter();

        Image newImage = omelsFilter.apply(file);

        imgPhotoEditied.setImage(newImage);
    }
}