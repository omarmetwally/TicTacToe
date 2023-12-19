package screens.Board;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoe.TicTacToe;

public class xoBase extends AnchorPane {

    protected final ImageView imgview;
    protected final Button xbtn;
    protected final ImageView ximg;
    protected final Button obtn;
    protected final ImageView oimg;
    protected final Button btnBack;

    public xoBase(Stage stage) {

        imgview = new ImageView();
        xbtn = new Button();
        ximg = new ImageView();
        obtn = new Button();
        oimg = new ImageView();
        btnBack=new Button();
        setId("AnchorPane");
        setPrefHeight(824.0);
        setPrefWidth(1416.0);

        imgview.setFitHeight(1174.0);
        imgview.setFitWidth(2043.0);
        imgview.setPickOnBounds(true);
        imgview.setPreserveRatio(true);
        imgview.setImage(new Image(getClass().getResource("/assets/cover.png").toExternalForm()));

        xbtn.setLayoutX(650.0);
        xbtn.setLayoutY(416.0);
        xbtn.setMnemonicParsing(false);
        xbtn.setPrefHeight(141.0);
        xbtn.setPrefWidth(190.0);
        xbtn.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-font-style: Roboto; -fx-background-color: FFFF;");
        xbtn.setOnAction((event) -> {

            BoardFXMLBase boardScreen = new BoardFXMLBase(stage,"You" , "Ai" ,GameMode.AI,'X');
            Scene boardScene = new Scene(boardScreen);
            TicTacToe.changeScene(boardScene);

        });

        ximg.setFitHeight(150.0);
        ximg.setFitWidth(200.0);
        ximg.setPickOnBounds(true);
        ximg.setPreserveRatio(true);
        ximg.setImage(new Image(getClass().getResource("/assets/X.png").toExternalForm()));
        xbtn.setGraphic(ximg);

        obtn.setLayoutX(1035.0);
        obtn.setLayoutY(417.0);
        obtn.setMnemonicParsing(false);
        obtn.setPrefHeight(141.0);
        obtn.setPrefWidth(190.0);
        obtn.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        obtn.setOnAction((event) -> {

            BoardFXMLBase boardScreen = new BoardFXMLBase(stage,"Ai" , "You" ,GameMode.AI,'O');
            Scene boardScene = new Scene(boardScreen);
            TicTacToe.changeScene(boardScene);

        });

        oimg.setFitHeight(150.0);
        oimg.setFitWidth(200.0);
        oimg.setPickOnBounds(true);
        oimg.setPreserveRatio(true);
        oimg.setImage(new Image(getClass().getResource("/assets/O.png").toExternalForm()));
        obtn.setGraphic(oimg);
        
        
             btnBack.setLayoutX(31.0);
        btnBack.setLayoutY(20.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setStyle("-fx-background-radius: 25; -fx-background-color: FFFF; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        btnBack.setText("Back");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        btnBack.setFont(new Font("Comic Sans MS Bold", 25.0));
        btnBack.setOnAction(event -> TicTacToe.goBack());

        getChildren().add(imgview);
        getChildren().add(xbtn);
        getChildren().add(obtn);
        getChildren().add(btnBack);

    }
}
