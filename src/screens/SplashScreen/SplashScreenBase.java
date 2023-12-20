package screens.SplashScreen;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public  class SplashScreenBase extends AnchorPane {

    protected final ImageView backgroundImage;

    public SplashScreenBase() {

        backgroundImage = new ImageView();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        backgroundImage.setFitHeight(1174.0);
        backgroundImage.setFitWidth(2043.0);
        backgroundImage.setPickOnBounds(true);
        backgroundImage.setPreserveRatio(true);
        backgroundImage.setImage(new Image(getClass().getResource("/assets/splash.png").toExternalForm()));

        getChildren().add(backgroundImage);

    }
}
