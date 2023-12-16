package screens.register_screen;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tictactoe.TicTacToe;

public class RegisterScreenBase extends AnchorPane {

    protected final ImageView backgroundIImage;
    protected final Text text;
    protected final Text text0;
    protected final Text text1;
    protected final Text text2;
    protected final Text text3;
    protected final TextField editTextFirstName;
    protected final TextField editTextLastName;
    protected final TextField editTextUsername;
    protected final PasswordField editTextPassword;
    protected final PasswordField editTextCofirmPassword;
    protected final Button buttonRegister;
    protected final Button btnBack;

    public RegisterScreenBase(Stage stage) {

        backgroundIImage = new ImageView();
        text = new Text();
        text0 = new Text();
        text1 = new Text();
        text2 = new Text();
        text3 = new Text();
        editTextFirstName = new TextField();
        editTextLastName = new TextField();
        editTextUsername = new TextField();
        editTextPassword = new PasswordField();
        editTextCofirmPassword = new PasswordField();
        buttonRegister = new Button();
        btnBack=new Button();
        
        setId("AnchorPane");
        setPrefHeight(890.0);
        setPrefWidth(1854.0);
        setStyle("-fx-background-color: #3D7AD6; -fx-background-image: url('../../assets/cover.png');");

        backgroundIImage.setFitHeight(1200.0);
        backgroundIImage.setFitWidth(2124.0);
        backgroundIImage.setLayoutX(-2.0);
        backgroundIImage.setLayoutY(-1.0);
        backgroundIImage.setPickOnBounds(true);
        backgroundIImage.setPreserveRatio(true);
        backgroundIImage.setImage(new Image(getClass().getResource("/assets/cover.png").toExternalForm()));

        text.setLayoutX(450.0);
        text.setLayoutY(115.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 45; -fx-font-weight: bold; -fx-fill: #fcd015; -fx-stroke: black; -fx-stroke-width: 1;");
        text.setText("First Name");

        text0.setLayoutX(450.0);
        text0.setLayoutY(245.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 45; -fx-font-weight: bold; -fx-fill: #fcd015; -fx-stroke: black; -fx-stroke-width: 1;");
        text0.setText("Last Name");

        text1.setLayoutX(450.0);
        text1.setLayoutY(365.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 45; -fx-font-weight: bold; -fx-fill: #fcd015; -fx-stroke: black; -fx-stroke-width: 1;");
        text1.setText("Username");

        text2.setLayoutX(450.0);
        text2.setLayoutY(505.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 45; -fx-font-weight: bold; -fx-fill: #fcd015; -fx-stroke: black; -fx-stroke-width: 1;");
        text2.setText("Password");

        text3.setLayoutX(450.0);
        text3.setLayoutY(635.0);
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 45; -fx-font-weight: bold; -fx-fill: #fcd015; -fx-stroke: black; -fx-stroke-width: 1;");
        text3.setText("Confirm Password");

        editTextFirstName.setLayoutX(1190.0);
        editTextFirstName.setLayoutY(65.0);
        editTextFirstName.setPrefHeight(55.0);
        editTextFirstName.setPrefWidth(350.0);
        editTextFirstName.setPromptText("First Name");
        editTextFirstName.setFont(new Font("Comic Sans MS", 24.0));

        editTextLastName.setLayoutX(1190.0);
        editTextLastName.setLayoutY(195.0);
        editTextLastName.setPrefHeight(55.0);
        editTextLastName.setPrefWidth(350.0);
        editTextLastName.setPromptText("Last Name");
        editTextLastName.setFont(new Font("Comic Sans MS", 24.0));

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
        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(text1);
        getChildren().add(text2);
        getChildren().add(text3);
        getChildren().add(editTextFirstName);
        getChildren().add(editTextLastName);
        getChildren().add(editTextUsername);
        getChildren().add(editTextPassword);
        getChildren().add(editTextCofirmPassword);
        getChildren().add(buttonRegister);
        getChildren().add(btnBack);
    }
}
