package screens.login_screen;

import models.ServerEventType;
import com.google.gson.Gson;
import helper.Helper;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.JsonReceiveBase;
import models.JsonWrapper;
import screens.Plist.PllistBase;
import screens.register_screen.RegisterScreenBase;
import tictactoe.TicTacToe;

public class LoginScreenBase extends AnchorPane {

    protected final ImageView backgroundIImage;
    protected final Text userNameLabel;
    protected final Text passwordLabel;
    protected final TextField userNameTextField;
    protected final PasswordField passwordTextField;
    protected final Button loginButton;
    protected final Label dontHaveAnAccountLabel;
    protected final Label registerNowButton;
    protected final Button btnBack;
    private JsonReceiveBase jsonReceiveBase;
    
    public LoginScreenBase(Stage stage) {
        
        jsonReceiveBase=new JsonReceiveBase();
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        backgroundIImage = new ImageView();
        passwordLabel = new Text();
        userNameTextField = new TextField();
        passwordTextField = new PasswordField();
        loginButton = new Button();
        dontHaveAnAccountLabel = new Label();
        registerNowButton = new Label();
        userNameLabel = new Text();
        btnBack = new Button();
        setId("AnchorPane");
        setPrefHeight(Screen.getPrimary().getVisualBounds().getWidth());
        setPrefWidth(Screen.getPrimary().getVisualBounds().getHeight());

        backgroundIImage.setLayoutX(-2.0);
        backgroundIImage.setLayoutY(-1.0);
        backgroundIImage.setPickOnBounds(true);
        backgroundIImage.setPreserveRatio(true);
        backgroundIImage.setImage(new Image(getClass().getResource("/assets/cover.png").toExternalForm()));
        backgroundIImage.setFitHeight(1174.0);
        backgroundIImage.setFitWidth(2043.0);
//        backgroundIImage.setFitWidth(screenBounds.getWidth());
//        backgroundIImage.setFitHeight(screenBounds.getHeight());

        userNameLabel.setLayoutX(500.0);
        userNameLabel.setLayoutY(310);
        userNameLabel.setText("User Name");
        userNameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        userNameLabel.setFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        userNameLabel.setFont(new Font("Comic Sans MS Bold", 58.0));
        userNameLabel.setStroke(Color.BLACK);
        userNameLabel.setStrokeWidth(2);

        passwordLabel.setLayoutX(500.0);
        passwordLabel.setLayoutY(410.0);
        passwordLabel.setText("Password");
        passwordLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        passwordLabel.setFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        passwordLabel.setFont(new Font("Comic Sans MS Bold", 58.0));
        passwordLabel.setStroke(Color.BLACK);
        passwordLabel.setStrokeWidth(2);
        userNameTextField.setLayoutX(881.0);
        userNameTextField.setLayoutY(270.0);
        userNameTextField.setPrefHeight(50.0);
        userNameTextField.setPrefWidth(369.0);
        userNameTextField.setFont(new Font(20.0));
        userNameTextField.setPromptText("Enter your user name");
        userNameTextField.setStyle(
                "-fx-border-color: black; "
                + "-fx-border-width: 2px;"
                + "-fx-background-radius: 10; "
                + "-fx-border-radius: 10;"
        );
        passwordTextField.setLayoutX(881.0);
        passwordTextField.setLayoutY(370.0);
        passwordTextField.setPrefHeight(50.0);
        passwordTextField.setPrefWidth(369.0);
        passwordTextField.setFont(new Font(20.0));
        passwordTextField.setPromptText("Enter your password");
        passwordTextField.setStyle(
                "-fx-border-color: black; "
                + "-fx-border-width: 2px;"
                + "-fx-background-radius: 10; "
                + "-fx-border-radius: 10;"
        );
        loginButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        loginButton.setLayoutX(786.0);
        loginButton.setLayoutY(540.0);
        loginButton.setMnemonicParsing(false);
        loginButton.setText("Login");
        loginButton.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        loginButton.setFont(new Font("Comic Sans MS Bold", 50.0));
        loginButton.setStyle(
                "-fx-background-color: white; "
                + "-fx-effect: dropshadow(gaussian, black, 10, 0.5, 0, 0); "
                + "-fx-border-color: black; "
                + "-fx-border-width: 3px;"
                + "-fx-background-radius: 10; "
                + "-fx-border-radius: 10;"
        );
//        loginButton.setOnAction((event) -> {
//            userNameTextField.getText();
//            passwordTextField.getText();
//        });

        loginButton.setOnAction((event) -> {
            new Thread(() -> {
                try {
                    Helper helper = new Helper();
                    UserCredentials userCredentials = getUserCredentials();
                    Gson gson = new Gson();
                    String jsonUserCredentials = gson.toJson(userCredentials);
                    String loginResponse = helper.loginRequest(jsonUserCredentials);
                     jsonReceiveBase = JsonWrapper.fromJson(loginResponse, JsonReceiveBase.class);
                    /// start here 
                    //System.out.println(loginResponse);
                    Platform.runLater(() -> {
                        if(jsonReceiveBase.getType().equals(ServerEventType.Login.name())&&jsonReceiveBase.getStatus()==1){
                        PllistBase listscreen = new PllistBase(stage,userNameTextField.getText());
                        Scene playerListScene = new Scene(listscreen);
                        TicTacToe.changeScene(playerListScene);
                        }else if(jsonReceiveBase.getType().equals(ServerEventType.Login.name())){
                            System.out.println(jsonReceiveBase.getMessge());
                        }
                    });

                } catch (IOException ex) {
                    Logger.getLogger(LoginScreenBase.class.getName()).log(Level.SEVERE, null, ex);
                }

            }).start();

        });
        
     

        dontHaveAnAccountLabel.setLayoutX(606.0);
        dontHaveAnAccountLabel.setLayoutY(689.0);
        dontHaveAnAccountLabel.setText("Don't have an account?");
        dontHaveAnAccountLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        dontHaveAnAccountLabel.setFont(new Font("Comic Sans MS Bold", 30.0));

        registerNowButton.setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        registerNowButton.setLayoutX(957.0);
        registerNowButton.setLayoutY(689.0);
        registerNowButton.setText("Register Now");
        registerNowButton.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        registerNowButton.setFont(new Font("Comic Sans MS Bold", 30.0));
        registerNowButton.setOnMouseClicked((event) -> {
            System.out.println("Register Now clicked");
            RegisterScreenBase registerScreen = new RegisterScreenBase(stage);
            Scene registerScene = new Scene(registerScreen);
            TicTacToe.changeScene(registerScene);
        });

        btnBack.setLayoutX(31.0);
        btnBack.setLayoutY(20.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setStyle("-fx-background-radius: 25; -fx-background-color: FFFF; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        btnBack.setText("Back");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        btnBack.setFont(new Font("Comic Sans MS Bold", 25.0));
        btnBack.setOnAction(event -> TicTacToe.goBack());
        getChildren().add(backgroundIImage);
        getChildren().add(userNameLabel);
        getChildren().add(passwordLabel);
        getChildren().add(userNameTextField);
        getChildren().add(passwordTextField);
        getChildren().add(loginButton);
        getChildren().add(dontHaveAnAccountLabel);
        getChildren().add(registerNowButton);
        getChildren().add(btnBack);
    }
    
    private UserCredentials getUserCredentials() {

        return new UserCredentials(userNameTextField.getText(),
                passwordTextField.getText());
    }
    


}
