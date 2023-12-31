package screens.register_screen;

import com.google.gson.Gson;
import helper.Helper;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.JsonReceiveBase;
import models.JsonWrapper;
import screens.login_screen.LoginScreenBase;
import models.ServerEventType;
import tictactoe.TicTacToe;

public class RegisterScreenBase extends AnchorPane {

    protected final ImageView backgroundIImage;
    protected final Text text1;
    protected final Text text2;
    protected final Text text3;
    protected final TextField editTextUsername;
    protected final PasswordField editTextPassword;
    protected final PasswordField editTextCofirmPassword;
    protected final Button buttonRegister;
    protected final Button btnBack;
    private JsonReceiveBase jsonReceiveBase;

    public RegisterScreenBase(Stage stage) {
        jsonReceiveBase = new JsonReceiveBase();
        backgroundIImage = new ImageView();
        text1 = new Text();
        text2 = new Text();
        text3 = new Text();
        editTextUsername = new TextField();
        editTextPassword = new PasswordField();
        editTextCofirmPassword = new PasswordField();
        buttonRegister = new Button();
        btnBack = new Button();

        setId("AnchorPane");
        setPrefHeight(890.0);
        setPrefWidth(1854.0);
        setStyle("-fx-background-color: #3D7AD6; -fx-background-image: url('../../assets/cover.png');");

        backgroundIImage.setLayoutX(-2.0);
        backgroundIImage.setLayoutY(-1.0);
        backgroundIImage.setPickOnBounds(true);
        backgroundIImage.setPreserveRatio(true);
        backgroundIImage.setImage(new Image(getClass().getResource("/assets/cover.png").toExternalForm()));
        backgroundIImage.setFitHeight(1174.0);
        backgroundIImage.setFitWidth(2043.0);

        text1.setLayoutX(450.0);
        text1.setLayoutY(365.0);
        text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text1.setFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        text1.setFont(new Font("Comic Sans MS Bold", 58.0));
        text1.setStroke(Color.BLACK);
        text1.setStrokeWidth(2);
        text1.setText("Username");

        text2.setLayoutX(450.0);
        text2.setLayoutY(505.0);
        text2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text2.setFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        text2.setFont(new Font("Comic Sans MS Bold", 58.0));
        text2.setStroke(Color.BLACK);
        text2.setStrokeWidth(2);
        text2.setText("Password");

        text3.setLayoutX(450.0);
        text3.setLayoutY(635.0);
        text3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text3.setFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        text3.setFont(new Font("Comic Sans MS Bold", 58.0));
        text3.setStroke(Color.BLACK);
        text3.setStrokeWidth(2);
        text3.setText("Confirm Password");

        editTextUsername.setLayoutX(1190.0);
        editTextUsername.setLayoutY(325.0);
        editTextUsername.setPrefHeight(55.0);
        editTextUsername.setPrefWidth(350.0);
        editTextUsername.setPromptText("Username");
        editTextUsername.setFont(new Font("Comic Sans MS", 24.0));

        editTextPassword.setLayoutX(1190.0);
        editTextPassword.setLayoutY(465.0);
        editTextPassword.setPrefHeight(55.0);
        editTextPassword.setPrefWidth(350.0);
        editTextPassword.setPromptText("Password");
        editTextPassword.setFont(new Font("Comic Sans MS", 24.0));

        editTextCofirmPassword.setLayoutX(1190.0);
        editTextCofirmPassword.setLayoutY(585.0);
        editTextCofirmPassword.setPrefHeight(55.0);
        editTextCofirmPassword.setPrefWidth(350.0);
        editTextCofirmPassword.setPromptText("Confirm Password");
        editTextCofirmPassword.setFont(new Font("Comic Sans MS", 24.0));

        buttonRegister.setLayoutX(860.0);
        buttonRegister.setLayoutY(770.0);
        buttonRegister.setMnemonicParsing(false);
        buttonRegister.setPrefHeight(101.0);
        buttonRegister.setPrefWidth(338.0);
        buttonRegister.setStyle("-fx-background-radius: 25; -fx-background-color: #ffffff; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-font-family: 'Comic Sans MS'; -fx-font-size: 45; -fx-font-weight: bold; -fx-text-fill: #fcd015; -fx-text-stroke: black; -fx-text-stroke-width: 1;");
        buttonRegister.setText("Register");
        buttonRegister.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        btnBack.setLayoutX(31.0);
        btnBack.setLayoutY(20.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setStyle("-fx-background-radius: 25; -fx-background-color: FFFF; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        btnBack.setText("Back");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        btnBack.setFont(new Font("Comic Sans MS Bold", 25.0));
        btnBack.setOnAction(event -> TicTacToe.goBack());

        getChildren().add(backgroundIImage);
        getChildren().add(text1);
        getChildren().add(text2);
        getChildren().add(text3);
        getChildren().add(editTextUsername);
        getChildren().add(editTextPassword);
        getChildren().add(editTextCofirmPassword);
        getChildren().add(buttonRegister);
        getChildren().add(btnBack);
        RegisterButton(stage);
    }

    private void RegisterButton(Stage stage) {

        buttonRegister.setOnAction((event) -> {
            if (validateRegistrationData()) {
                new Thread(() -> {
                    Helper helper = new Helper();
                    Registration newUserData = extractRegistrationData();
                    Gson gson = new Gson();
                    String jsonData = gson.toJson(newUserData);
                    String registerResponse = null;
                    try {
                        registerResponse = helper.registerRequest(jsonData);

                    } catch (IOException ex) {
                        Logger.getLogger(RegisterScreenBase.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    jsonReceiveBase = JsonWrapper.fromJson(registerResponse, JsonReceiveBase.class);
                    try {

                        Platform.runLater(() -> {
                            if (jsonReceiveBase.getType().equals(ServerEventType.Register.name()) && jsonReceiveBase.getStatus() == 1) {
                                LoginScreenBase loginScreen = new LoginScreenBase(stage);
                                Scene loginScene = new Scene(loginScreen);
                                TicTacToe.changeScene(loginScene);
                            } else if (jsonReceiveBase.getType().equals(ServerEventType.Register.name())) {
                                showAlerDialog(jsonReceiveBase.getMessge());
                            }

                        });
                    } finally {
                        try {
                            helper.closeConnection();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

    private Boolean validateRegistrationData() {

        if (editTextUsername.getText().isEmpty() || editTextPassword.getText().isEmpty() || editTextCofirmPassword.getText().isEmpty()) {

            showAlerDialog("One or more fields are empty. Please fill in all fields.");
            System.out.println("Empty fields");

            return false;

        } else if (editTextUsername.getText().length() < 8) {
            showAlerDialog("Username should be more than 8 chrachters.");

            System.out.println("invalid syntax username");

            return false;

        } else if (!isUsernameValid(editTextUsername.getText())) {

            showAlerDialog("Invalid username please do not use symbols.");

            System.out.println("invalid syntax username");

            return false;

        } else if (editTextPassword.getText().length() < 5) {

            showAlerDialog("Password should be 5 chrachters or more.");

            System.out.println("invalid syntax username");

            return false;

        } else if (!arePassordsMatched()) {
            showAlerDialog("Passwords are not matched.");

            System.out.println("invalid syntax username");

            return false;

        }

        return true;

    }

    private Registration extractRegistrationData() {

        Registration registration = new Registration(
                editTextUsername.getText(), editTextPassword.getText());

        return registration;
    }

    private Boolean arePassordsMatched() {

        if (editTextPassword.getText().equals(editTextCofirmPassword.getText())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isUsernameValid(String username) {

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher matcher = pattern.matcher(username);

        return matcher.matches();
    }

    private void showAlerDialog(String dialogLable) {

        Alert alert = new Alert(AlertType.NONE);
        DialogPane dialogPane = alert.getDialogPane();

        dialogPane.setStyle("-fx-background-color: #3D7AD6;");
        alert.setAlertType(AlertType.ERROR);
        Label label = new Label(dialogLable);
        label.setStyle("-fx-text-fill: #fcd015; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 16;");

        dialogPane.setContent(label);
        alert.show();

    }

}
