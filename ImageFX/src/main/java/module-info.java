module edu.okcu.imagefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens edu.okcu.imagefx to javafx.fxml;
    exports edu.okcu.imagefx;
    exports edu.okcu.imagefx.filters;
    opens edu.okcu.imagefx.filters to javafx.fxml;
}