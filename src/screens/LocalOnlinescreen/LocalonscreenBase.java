package screens.LocalOnlinescreen;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LocalonscreenBase extends AnchorPane {

    protected final ImageView imgView;
    protected final Button localbtn;
    protected final Button onlinebtn;

    public LocalonscreenBase(Stage stage) {

        imgView = new ImageView();
        localbtn = new Button();
        onlinebtn = new Button();

        setId("AnchorPane");
        setPrefHeight(824.0);
        setPrefWidth(1416.0);

        imgView.setFitHeight(1174.0);
        imgView.setFitWidth(2043.0);
        imgView.setLayoutX(-11.0);
        imgView.setLayoutY(-1.0);
        imgView.setPickOnBounds(true);
        imgView.setPreserveRatio(true);
        imgView.setImage(new Image(getClass().getResource("/assets/cover.png").toExternalForm()));

        localbtn.setLayoutX(610.0);
        localbtn.setLayoutY(416.0);
        localbtn.setMnemonicParsing(false);
        localbtn.setPrefHeight(140);
        localbtn.setPrefWidth(260);
        localbtn.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-font-style: Roboto; -fx-background-color: FFFF;");
        localbtn.setText("Local");
        localbtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        localbtn.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        localbtn.setFont(new Font("Comic Sans MS Bold", 45.0));

        onlinebtn.setLayoutX(1026.0);
        onlinebtn.setLayoutY(417.0);
        onlinebtn.setMnemonicParsing(false);
        onlinebtn.setPrefHeight(140);
        onlinebtn.setPrefWidth(260);
        onlinebtn.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-font-style: Roboto; -fx-background-color: FFFF;");
        onlinebtn.setText("Online");
        onlinebtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        onlinebtn.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        onlinebtn.setFont(new Font("Comic Sans MS Bold", 45.0));

        getChildren().add(imgView);
        getChildren().add(localbtn);
        getChildren().add(onlinebtn);

    }
}
