package screens.mode;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import screens.Board.BoardFXMLBase;
import screens.LocalOnlinescreen.LocalonscreenBase;
import tictactoe.TicTacToe;

public class ModeScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button btnSingle;
    protected final Button btnMulti;

    public ModeScreenBase(Stage stage) {

        imageView = new ImageView();
        btnSingle = new Button();
        btnMulti = new Button();

        setId("AnchorPane");
        setPrefHeight(824.0);
        setPrefWidth(1416.0);

        imageView.setFitHeight(1174.0);
        imageView.setFitWidth(2043.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/cover.png").toExternalForm()));

        btnSingle.setLayoutX(610.0);
        btnSingle.setLayoutY(416.0);
        btnSingle.setMnemonicParsing(false);
        btnSingle.setPrefHeight(141.0);
        btnSingle.setPrefWidth(258.0);
        btnSingle.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-font-style: Roboto; -fx-background-color: FFFF;");
        btnSingle.setText("Single");
        btnSingle.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnSingle.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        btnSingle.setFont(new Font("Comic Sans MS Bold", 45.0));
        btnSingle.setOnAction((event) -> {

        });

        btnMulti.setLayoutX(1026.0);
        btnMulti.setLayoutY(417.0);
        btnMulti.setMnemonicParsing(false);
        btnMulti.setPrefHeight(141.0);
        btnMulti.setPrefWidth(278.0);
        btnMulti.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        btnMulti.setText("MultiPlayer");
        btnMulti.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnMulti.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        btnMulti.setFont(new Font("Comic Sans MS Bold", 39.0));
        btnMulti.setOnAction((event) -> {

            LocalonscreenBase localScreen = new LocalonscreenBase(stage);
            Scene boardScene = new Scene(localScreen);
            TicTacToe.changeScene(boardScene);

        });

        getChildren().add(imageView);
        getChildren().add(btnSingle);
        getChildren().add(btnMulti);

    }
}
