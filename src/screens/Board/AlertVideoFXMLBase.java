package screens.Board;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class AlertVideoFXMLBase extends AnchorPane {

    protected final Text headerTextView;
    protected final MediaView winMediaView;
    protected final Button btnPlayAgain;
    protected final Button btnBack;

    public AlertVideoFXMLBase() {

        headerTextView = new Text();
        winMediaView = new MediaView();
        btnPlayAgain = new Button();
        btnBack = new Button();

        setId("AnchorPane");
        setPrefHeight(800.0);
        setPrefWidth(1280.0);
        setStyle("-fx-background-color: linear-gradient(#ffffff,#E5EDEE);");

        AnchorPane.setLeftAnchor(headerTextView, 180.0);
        AnchorPane.setRightAnchor(headerTextView, 180.0);
        AnchorPane.setTopAnchor(headerTextView, 80.0);
        headerTextView.setFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        headerTextView.setLayoutX(176.0);
        headerTextView.setLayoutY(200.0);
        headerTextView.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        headerTextView.setStrokeWidth(0.0);
        headerTextView.setText("Winner");
        headerTextView.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        headerTextView.setWrappingWidth(1031.6117244958878);
        headerTextView.setFont(new Font("Comic Sans MS Bold", 70.0));

        winMediaView.setFitHeight(400.0);
        winMediaView.setFitWidth(880.0);
        winMediaView.setLayoutX(256.0);
        winMediaView.setLayoutY(200.0);

        btnPlayAgain.setLayoutX(256.0);
        btnPlayAgain.setLayoutY(633.0);
        btnPlayAgain.setMnemonicParsing(false);
        btnPlayAgain.setPrefHeight(104.0);
        btnPlayAgain.setPrefWidth(312.0);
        btnPlayAgain.setStyle("-fx-background-color: fcd015; -fx-background-radius: 45; -fx-effect: dropshadow( one-pass-box  , #BFBFC3 , 10 ,0.4 , -7, 7 );");
        btnPlayAgain.setText("Play Again");
        btnPlayAgain.setTextFill(javafx.scene.paint.Color.valueOf("#fffefe"));
        btnPlayAgain.setFont(new Font("Comic Sans MS", 50.0));

        btnBack.setLayoutX(956.0);
        btnBack.setLayoutY(633.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(100.0);
        btnBack.setPrefWidth(180.0);
        btnBack.setStyle("-fx-background-color: fcd015; -fx-background-radius: 45; -fx-effect: dropshadow( one-pass-box  , #BFBFC3 , 10 ,0.4 , -7, 7 );");
        btnBack.setText("Back");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#fffefe"));
        btnBack.setFont(new Font("Comic Sans MS", 50.0));

        getChildren().add(headerTextView);
        getChildren().add(winMediaView);
        getChildren().add(btnPlayAgain);
        getChildren().add(btnBack);

    }
}
