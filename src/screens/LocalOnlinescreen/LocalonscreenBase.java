package screens.LocalOnlinescreen;

import helper.Helper;
import helper.HelperIP;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import screens.LocalPlayers.LocalPlayersBase;
import screens.Plist.AlertMessage;
import screens.Plist.alertBase;
import screens.login_screen.LoginScreenBase;
import tictactoe.TicTacToe;

public class LocalonscreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button localbtn;
    protected final Button onlinebtn;
    protected final Button btnBack;

    public LocalonscreenBase(Stage stage) {

        imageView = new ImageView();
        localbtn = new Button();
        onlinebtn = new Button();
        btnBack = new Button();

        setId("AnchorPane");
        setPrefHeight(824.0);
        setPrefWidth(1416.0);

        imageView.setFitHeight(1174.0);
        imageView.setFitWidth(2043.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/cover.png").toExternalForm()));

        localbtn.setLayoutX(610.0);
        localbtn.setLayoutY(416.0);
        localbtn.setMnemonicParsing(false);

        localbtn.setPrefHeight(141.0);
        localbtn.setPrefWidth(258.0);

        localbtn.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-font-style: Roboto; -fx-background-color: FFFF;");
        localbtn.setText("Local");
        localbtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        localbtn.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        localbtn.setFont(new Font("Comic Sans MS Bold", 45.0));

        localbtn.setOnAction((event) -> {

            LocalPlayersBase localScreen = new LocalPlayersBase(stage);
            Scene boardScene = new Scene(localScreen);
            TicTacToe.changeScene(boardScene);
        });

        onlinebtn.setLayoutX(1026.0);
        onlinebtn.setLayoutY(417.0);
        onlinebtn.setMnemonicParsing(false);

        onlinebtn.setPrefHeight(141.0);
        onlinebtn.setPrefWidth(278.0);
        onlinebtn.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        onlinebtn.setText("Online");
        onlinebtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        onlinebtn.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        onlinebtn.setFont(new Font("Comic Sans MS Bold", 39.0));
        onlinebtn.setOnAction((event) -> {
            boolean serverIsOn = promptForIPAddress();
            if (serverIsOn) {
                LoginScreenBase localScreen = new LoginScreenBase(stage);
                Scene boardScene = new Scene(localScreen);
                TicTacToe.changeScene(boardScene);
            }

        });

        btnBack.setLayoutX(31.0);
        btnBack.setLayoutY(20.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setStyle("-fx-background-radius: 25; -fx-background-color: FFFF; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        btnBack.setText("Back");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        btnBack.setFont(new Font("Comic Sans MS Bold", 25.0));
        btnBack.setOnAction(event -> TicTacToe.goBack());

        getChildren().add(imageView);
        getChildren().add(localbtn);
        getChildren().add(onlinebtn);
        getChildren().add(btnBack);

    }

    public boolean promptForIPAddress() {
        String ipAddress = "";

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("IP Address Input");
        dialog.setHeaderText("Enter Server IP Address (on cancel IP: 127.0.0.1)");
        dialog.setContentText("Please enter the Server IP address:");

        Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setDisable(true);

        TextField inputField = dialog.getEditor();

        inputField.textProperty().addListener((observable, oldValue, newValue) -> {
            okButton.setDisable(newValue.trim().isEmpty());
        });

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            HelperIP.setIpHelper(result.get());
        } else {
            HelperIP.setIpHelper("127.0.0.1");
        }
        
        Helper newHlper = new Helper();
        return Helper.isCreated;

    }

}
