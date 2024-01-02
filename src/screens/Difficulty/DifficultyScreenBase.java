package screens.Difficulty;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import screens.Board.BoardFXMLBase;
import screens.Board.GameMode;
import tictactoe.TicTacToe;

public  class DifficultyScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button btnEasyMode;
    protected final Button btnMeduimMode;
    protected final Button btnHardMode;
    protected final Button btnBack;

    public DifficultyScreenBase(Stage stage) {

        imageView = new ImageView();
        btnEasyMode = new Button();
        btnMeduimMode = new Button();
        btnHardMode = new Button();
         btnBack = new Button();

        setId("AnchorPane");
        setPrefHeight(824.0);
        setPrefWidth(1416.0);

        imageView.setFitHeight(1174.0);
        imageView.setFitWidth(2043.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/cover.png").toExternalForm()));

        btnEasyMode.setLayoutX(535.0);
        btnEasyMode.setLayoutY(416.0);
        btnEasyMode.setMnemonicParsing(false);
        btnEasyMode.setPrefHeight(141.0);
        btnEasyMode.setPrefWidth(258.0);
        btnEasyMode.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-font-style: Roboto; -fx-background-color: FFFF;");
        btnEasyMode.setText("Easy");
        btnEasyMode.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnEasyMode.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        btnEasyMode.setFont(new Font("Comic Sans MS Bold", 45.0));

        btnMeduimMode.setLayoutX(859.0);
        btnMeduimMode.setLayoutY(419.0);
        btnMeduimMode.setMnemonicParsing(false);
        btnMeduimMode.setPrefHeight(141.0);
        btnMeduimMode.setPrefWidth(278.0);
        btnMeduimMode.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        btnMeduimMode.setText("Medium");
        btnMeduimMode.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnMeduimMode.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        btnMeduimMode.setFont(new Font("Comic Sans MS Bold", 39.0));

        btnHardMode.setLayoutX(1201.0);
        btnHardMode.setLayoutY(418.0);
        btnHardMode.setMnemonicParsing(false);
        btnHardMode.setPrefHeight(141.0);
        btnHardMode.setPrefWidth(278.0);
        btnHardMode.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        btnHardMode.setText("Hard");
        btnHardMode.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnHardMode.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        btnBack.setLayoutX(31.0);
        btnBack.setLayoutY(20.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setStyle("-fx-background-radius: 25; -fx-background-color: FFFF; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        btnBack.setText("Back");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        btnBack.setFont(new Font("Comic Sans MS Bold", 25.0));
        btnBack.setOnAction(event -> TicTacToe.goBack());
        
        btnHardMode.setFont(new Font("Comic Sans MS Bold", 39.0));
          btnEasyMode.setOnAction((event) -> {

            BoardFXMLBase boardScreen = new BoardFXMLBase(stage, "Player 1", "  Robot", GameMode.AI_EASY,null);
            Scene boardScene = new Scene(boardScreen);
            TicTacToe.changeScene(boardScene);

        });
           btnMeduimMode.setOnAction((event) -> {

            BoardFXMLBase boardScreen = new BoardFXMLBase(stage, "Player 1", "  Robot", GameMode.AI_MEDIUM,null);
            Scene boardScene = new Scene(boardScreen);
            TicTacToe.changeScene(boardScene);

        });
            btnHardMode.setOnAction((event) -> {

            BoardFXMLBase boardScreen = new BoardFXMLBase(stage, "Player 1", "  Robot", GameMode.AI_HARD,null);
            Scene boardScene = new Scene(boardScreen);
            TicTacToe.changeScene(boardScene);

        });

        getChildren().add(imageView);
        getChildren().add(btnEasyMode);
        getChildren().add(btnMeduimMode);
        getChildren().add(btnHardMode);
        getChildren().add(btnBack);

    }
}
