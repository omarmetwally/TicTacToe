package screens.LocalPlayers;

import javafx.geometry.Insets;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import screens.Board.BoardFXMLBase;
import screens.Board.GameMode;
import tictactoe.TicTacToe;


public class LocalPlayersBase extends AnchorPane {

    protected final ImageView imgCover;
    protected final Text tPlayerOne;
    protected final Text tPlayerTwo;
    protected final Rectangle rectangle;
    protected final TextField tfPlayerOne;
    protected final Rectangle rectangle0;
    protected final TextField tfPlayerTwo;
    protected final Button btnStart;

    protected final Button btnBack;

    public LocalPlayersBase(Stage stage) {


        imgCover = new ImageView();
        tPlayerOne = new Text();
        tPlayerTwo = new Text();
        rectangle = new Rectangle();
        tfPlayerOne = new TextField();
        rectangle0 = new Rectangle();
        tfPlayerTwo = new TextField();
        btnStart = new Button();

        btnBack=new Button();


        setId("AnchorPane");
        setPrefHeight(1000.0);
        setPrefWidth(2000.0);


        imgCover.setFitHeight(1174.0);
        imgCover.setFitWidth(2043.0);
        


        imgCover.setPickOnBounds(true);
        imgCover.setImage(new Image(getClass().getResource("/assets/cover.png").toExternalForm()));

        tPlayerOne.setFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        tPlayerOne.setLayoutX(600.0);
        tPlayerOne.setLayoutY(350.0);
        tPlayerOne.setStroke(javafx.scene.paint.Color.BLACK);
        tPlayerOne.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        tPlayerOne.setText("Player 1");
        tPlayerOne.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        tPlayerOne.setWrappingWidth(200.0);
        tPlayerOne.setFont(new Font("Comic Sans MS Bold", 50.0));

        tPlayerTwo.setFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        tPlayerTwo.setLayoutX(600.0);
        tPlayerTwo.setLayoutY(500.0);
        tPlayerTwo.setStroke(javafx.scene.paint.Color.BLACK);
        tPlayerTwo.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        tPlayerTwo.setText("Player 2");
        tPlayerTwo.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        tPlayerTwo.setWrappingWidth(200.0);
        tPlayerTwo.setFont(new Font("Comic Sans MS Bold", 50.0));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setHeight(63.5);
        rectangle.setLayoutX(948.0);
        rectangle.setLayoutY(298.0);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(384.0);

        tfPlayerOne.setLayoutX(950.0);
        tfPlayerOne.setLayoutY(300.0);
        tfPlayerOne.setPrefHeight(60.0);
        tfPlayerOne.setPrefWidth(380.0);
        tfPlayerOne.setOpaqueInsets(new Insets(0.0));

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setHeight(63.5);
        rectangle0.setLayoutX(948.0);
        rectangle0.setLayoutY(448.0);
        rectangle0.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(384.0);

        tfPlayerTwo.setLayoutX(950.0);
        tfPlayerTwo.setLayoutY(450.0);
        tfPlayerTwo.setPrefHeight(60.0);
        tfPlayerTwo.setPrefWidth(380.0);

        btnStart.setAlignment(javafx.geometry.Pos.CENTER);
        btnStart.setLayoutX(900.0);
        btnStart.setLayoutY(700.0);
        btnStart.setMnemonicParsing(false);
        btnStart.setPrefHeight(150.0);
        btnStart.setPrefWidth(250.0);
        btnStart.setStyle("-fx-background-radius: 25; -fx-background-color: #ffffff; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,5,0.3,-2,5);");
        btnStart.setText("Start");
        btnStart.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnStart.setTextFill(javafx.scene.paint.Color.valueOf("#facc16"));
        btnStart.setFont(new Font("Comic Sans MS Bold", 50.0));

        btnStart.setOnAction((event) -> {
       


            BoardFXMLBase boardScreen =new BoardFXMLBase(stage,tfPlayerOne.getText(),tfPlayerTwo.getText(),GameMode.TwoPlayers);

            Scene boardScene = new Scene(boardScreen);
            TicTacToe.changeScene(boardScene);
        });
        
        
        btnBack.setLayoutX(31.0);
        btnBack.setLayoutY(20.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setStyle("-fx-background-radius: 25; -fx-background-color: FFFF; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        btnBack.setText("Back");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        btnBack.setFont(new Font("Comic Sans MS Bold", 25.0));
        btnBack.setOnAction(event -> TicTacToe.goBack());
        


        getChildren().add(imgCover);
        getChildren().add(tPlayerOne);
        getChildren().add(tPlayerTwo);
        getChildren().add(rectangle);
        getChildren().add(tfPlayerOne);
        getChildren().add(rectangle0);
        getChildren().add(tfPlayerTwo);
        getChildren().add(btnStart);

        getChildren().add(btnBack);


    }
}
