package screens.login_screen;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import screens.register_screen.RegisterScreenBase;
import tictactoe.TicTacToe;
import javafx.scene.Scene;
import screens.Plist.PllistBase;

public  class LoginScreenBase extends AnchorPane {

    protected final ImageView backgroundIImage;
    protected final Label userNameLabel;
    protected final Label passwordLabel;
    protected final TextField userNameTextField;
    protected final TextField passwordTextField;
    protected final Button loginButton;
    protected final Label dontHaveAnAccountLabel;
    protected final Label registerNowButton;
    protected final Button btnBack;

    public LoginScreenBase(Stage stage) {

        backgroundIImage = new ImageView();
        userNameLabel = new Label();
        passwordLabel = new Label();
        userNameTextField = new TextField();
        passwordTextField = new TextField();
        loginButton = new Button();
        dontHaveAnAccountLabel = new Label();
        registerNowButton = new Label();
        btnBack=new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        backgroundIImage.setFitHeight(1174.0);
        backgroundIImage.setFitWidth(2043.0);
        backgroundIImage.setLayoutX(-2.0);
        backgroundIImage.setLayoutY(-1.0);
        backgroundIImage.setPickOnBounds(true);
        backgroundIImage.setPreserveRatio(true);
        backgroundIImage.setImage(new Image(getClass().getResource("/assets/cover.png").toExternalForm()));

        userNameLabel.setLayoutX(659.0);
        userNameLabel.setLayoutY(342.0);
        userNameLabel.setText("User Name");
        userNameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        userNameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        userNameLabel.setFont(new Font("Comic Sans MS Bold", 58.0));

        passwordLabel.setLayoutX(659.0);
        passwordLabel.setLayoutY(442.0);
        passwordLabel.setText("Password");
        passwordLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        passwordLabel.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        passwordLabel.setFont(new Font("Comic Sans MS Bold", 58.0));

        userNameTextField.setLayoutX(1039.0);
        userNameTextField.setLayoutY(358.0);
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

        passwordTextField.setLayoutX(1039.0);
        passwordTextField.setLayoutY(458.0);
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
        loginButton.setLayoutX(944.0);
        loginButton.setLayoutY(634.0);
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
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PllistBase listScreen = new PllistBase(stage);
                Scene bscene = new Scene(listScreen);
                TicTacToe.changeScene(bscene);
            }
        });

        dontHaveAnAccountLabel.setLayoutX(764.0);
        dontHaveAnAccountLabel.setLayoutY(783.0);
        dontHaveAnAccountLabel.setText("Don't have an account?");
        dontHaveAnAccountLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        dontHaveAnAccountLabel.setFont(new Font("Comic Sans MS Bold", 30.0));

        registerNowButton.setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        registerNowButton.setLayoutX(1115.0);
        registerNowButton.setLayoutY(783.0);
        registerNowButton.setText("Register Now");
        registerNowButton.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        registerNowButton.setFont(new Font("Comic Sans MS Bold", 30.0));
        registerNowButton.setOnMouseClicked((event) -> {
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
}
