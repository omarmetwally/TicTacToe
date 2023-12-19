package screens.Plist;

import java.io.IOException;
import java.lang.*;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tictactoe.TicTacToe;

public class PllistBase extends AnchorPane {
    
    
    protected final ImageView imgview;
    protected final Button playlist;
    protected final HBox hbox;
    protected final Label name;
    protected final Label status;
    protected final Pane pane;
    protected final VBox vBox;
    protected final FlowPane flow1;
    protected final Circle circle1;
    protected final Label aya;
    protected final Label ayanum;
    protected final Button invbtn1;
    protected final FlowPane flow2;
    protected final Circle circle2;
    protected final Label samuel;
    protected final Label samuelnum;
    protected final Button invbtn2;
    protected final FlowPane flow3;
    protected final Circle circle3;
    protected final Label hadi;
    protected final Label hadinum;
    protected final Button invbtn3;
    protected final FlowPane flow4;
    protected final Circle circle4;
    protected final Label omar;
    protected final Label omarnum;
    protected final Button invbtn4;
    protected final FlowPane flow5;
    protected final Circle circle5;
    protected final Label allam;
    protected final Label allamnum;
    protected final Button invbtn5;
    protected final FlowPane flow7;
    protected final Circle circle1111111;
    protected final Label aya111111;
    protected final Label ayanum111111;
    protected final Button invbtn1111111;
    protected final Button Backbtn;
    protected final Image  img1;
    protected final Image  img2;
    protected final Image  img3;
    protected final Image  img4;
    protected final Image  img5;
    protected final Image  img6;
  



    public PllistBase(Stage stage) {

       imgview = new ImageView();
        playlist = new Button();
        hbox = new HBox();
        name = new Label();
        status = new Label();
        pane = new Pane();
        vBox = new VBox(30);
        flow1 = new FlowPane();
        circle1 = new Circle();
        aya = new Label();
        ayanum = new Label();
        invbtn1 = new Button();
        flow2 = new FlowPane();
        circle2 = new Circle();
        samuel = new Label();
        samuelnum = new Label();
        invbtn2 = new Button();
        flow3 = new FlowPane();
        circle3 = new Circle();
        hadi = new Label();
        hadinum = new Label();
        invbtn3 = new Button();
        flow4 = new FlowPane();
        circle4 = new Circle();
        omar = new Label();
        omarnum = new Label();
        invbtn4 = new Button();
        flow5 = new FlowPane();
        circle5 = new Circle();
        allam = new Label();
        allamnum = new Label();
        invbtn5 = new Button();
        flow7 = new FlowPane();
        circle1111111 = new Circle();
        aya111111 = new Label();
        ayanum111111 = new Label();
        invbtn1111111 = new Button();
        Backbtn = new Button();
        img1 = new Image("/assets/a65832155622ac173337874f02b218fb.jpg");
        img2 = new Image("/assets/images.png");   
        img3 = new Image("/assets/download.png");
        img4 = new Image("/assets/im.png");
        img5 = new Image("/assets/images.jpg");
        img6 = new Image("/assets/flat-business-woman-user-profile-avatar-icon-vector-4334111.jpg");
         
         
        setId("AnchorPane");
        setPrefHeight(736.0);
        setPrefWidth(1413.0);
        
        
        
        imgview.setFitHeight(1174.0);
        imgview.setFitWidth(2043.0);
        imgview.setLayoutX(-17.0);
        imgview.setLayoutY(-5.0);
        imgview.setPickOnBounds(true);
        imgview.setPreserveRatio(true);
        imgview.setImage(new Image(getClass().getResource("/assets/cover.png").toExternalForm()));

        playlist.setLayoutX(850);
        playlist.setLayoutY(18.0);
        playlist.setMnemonicParsing(false);
        playlist.setPrefHeight(75.0);
        playlist.setPrefWidth(260.0);
        playlist.setText("Available Players");
        playlist.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,yellow,10,0.3,-5,5); -fx-background-color: FFFF;");
        playlist.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        playlist.setFont(new Font("Comic Sans MS Bold", 26.0));

        hbox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hbox.setLayoutX(602.0);
        hbox.setLayoutY(155.0);
        hbox.setPrefHeight(49.0);
        hbox.setPrefWidth(826.0);

        name.setAlignment(javafx.geometry.Pos.CENTER);
        name.setPrefHeight(30.0);
        name.setPrefWidth(144.0);
        name.setText("Name");
        name.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        name.setFont(new Font("Comic Sans MS Bold", 40.0));

        status.setAlignment(javafx.geometry.Pos.CENTER);
        status.setLayoutX(10.0);
        status.setLayoutY(20.0);
        status.setPrefHeight(39.0);
        status.setPrefWidth(550.0);
        status.setText("Points");
        status.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        status.setFont(new Font("Comic Sans MS Bold", 40.0));

        pane.setLayoutX(555.0);
        pane.setLayoutY(260.0);
        pane.setPrefHeight(490.0);
        pane.setPrefWidth(900.0);

        vBox.setPrefHeight(560.0);
        vBox.setPrefWidth(765.0);

        flow1.setPrefHeight(56.0);
        flow1.setPrefWidth(900.0);

        circle1.setFill(javafx.scene.paint.Color.DODGERBLUE);
        circle1.setRadius(30.0);
        circle1.setStroke(javafx.scene.paint.Color.BLACK);
        circle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        circle1.setFill(new ImagePattern(img1));

        aya.setPrefHeight(60.0);
        aya.setPrefWidth(351.0);
        aya.setText("Aya ");
        aya.setTextFill(javafx.scene.paint.Color.WHITE);
        aya.setFont(new Font("Bookman Old Style Bold", 32.0));
        aya.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));

        ayanum.setLayoutX(80.0);
        ayanum.setLayoutY(10.0);
        ayanum.setPrefHeight(60.0);
        ayanum.setPrefWidth(260.0);
        ayanum.setText("230");
        ayanum.setTextFill(javafx.scene.paint.Color.WHITE);
        ayanum.setFont(new Font("Bookman Old Style Bold", 32.0));
        ayanum.setPadding(new Insets(0.0, 0.0, 0.0, 22.0));

        invbtn1.setMnemonicParsing(false);
        invbtn1.setPrefHeight(50.0);
        invbtn1.setPrefWidth(90.0);
        invbtn1.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        invbtn1.setText("Invite");
        invbtn1.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        invbtn1.setFont(new Font("Bookman Old Style Bold", 20.0));
        invbtn1.setOnAction(e -> {
             invitePlayer();
        });

        
        
        flow2.setPrefHeight(56.0);
        flow2.setPrefWidth(773.0);

        circle2.setFill(javafx.scene.paint.Color.DODGERBLUE);
        circle2.setRadius(30.0);
        circle2.setStroke(javafx.scene.paint.Color.BLACK);
        circle2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        circle2.setFill(new ImagePattern(img2));

        samuel.setPrefHeight(60.0);
        samuel.setPrefWidth(351.0);
        samuel.setText("Samuel ");
        samuel.setTextFill(javafx.scene.paint.Color.WHITE);
        samuel.setFont(new Font("Bookman Old Style Bold", 32.0));
        samuel.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));

        samuelnum.setLayoutX(80.0);
        samuelnum.setLayoutY(10.0);
        samuelnum.setPrefHeight(60.0);
        samuelnum.setPrefWidth(260.0);
        samuelnum.setText("130");
        samuelnum.setTextFill(javafx.scene.paint.Color.WHITE);
        samuelnum.setFont(new Font("Bookman Old Style Bold", 32.0));
        samuelnum.setPadding(new Insets(0.0, 0.0, 0.0, 22.0));

        invbtn2.setMnemonicParsing(false);
        invbtn2.setPrefHeight(50.0);
        invbtn2.setPrefWidth(90.0);
        invbtn2.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        invbtn2.setText("Invite");
        invbtn2.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        invbtn2.setFont(new Font("Bookman Old Style Bold", 20.0));
        invbtn2.setOnAction(e -> {
             invitePlayer();
        });
        
        
        flow3.setPrefHeight(56.0);
        flow3.setPrefWidth(773.0);

        circle3.setFill(javafx.scene.paint.Color.DODGERBLUE);
        circle3.setRadius(30.0);
        circle3.setStroke(javafx.scene.paint.Color.BLACK);
        circle3.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        circle3.setFill(new ImagePattern(img3));

        hadi.setPrefHeight(60.0);
        hadi.setPrefWidth(351.0);
        hadi.setText("Hadi ");
        hadi.setTextFill(javafx.scene.paint.Color.WHITE);
        hadi.setFont(new Font("Bookman Old Style Bold", 32.0));
        hadi.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));

        hadinum.setLayoutX(80.0);
        hadinum.setLayoutY(10.0);
        hadinum.setPrefHeight(60.0);
        hadinum.setPrefWidth(260.0);
        hadinum.setText("200");
        hadinum.setTextFill(javafx.scene.paint.Color.WHITE);
        hadinum.setFont(new Font("Bookman Old Style Bold", 32.0));
        hadinum.setPadding(new Insets(0.0, 0.0, 0.0, 22.0));

        invbtn3.setMnemonicParsing(false);
        invbtn3.setPrefHeight(50.0);
        invbtn3.setPrefWidth(90.0);
        invbtn3.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        invbtn3.setText("Invite");
        invbtn3.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        invbtn3.setFont(new Font("Bookman Old Style Bold", 20.0));
        invbtn3.setOnAction(e -> {
             invitePlayer();
        });
        
        
        flow4.setPrefHeight(56.0);
        flow4.setPrefWidth(773.0);

        circle4.setFill(javafx.scene.paint.Color.DODGERBLUE);
        circle4.setRadius(30.0);
        circle4.setStroke(javafx.scene.paint.Color.BLACK);
        circle4.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        circle4.setFill(new ImagePattern(img4));

        omar.setPrefHeight(60.0);
        omar.setPrefWidth(351.0);
        omar.setText("Omar ");
        omar.setTextFill(javafx.scene.paint.Color.WHITE);
        omar.setFont(new Font("Bookman Old Style Bold", 32.0));
        omar.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));

        omarnum.setLayoutX(80.0);
        omarnum.setLayoutY(10.0);
        omarnum.setPrefHeight(60.0);
        omarnum.setPrefWidth(260.0);
        omarnum.setText("100");
        omarnum.setTextFill(javafx.scene.paint.Color.WHITE);
        omarnum.setFont(new Font("Bookman Old Style Bold", 32.0));
        omarnum.setPadding(new Insets(0.0, 0.0, 0.0, 22.0));

        invbtn4.setMnemonicParsing(false);
        invbtn4.setPrefHeight(50.0);
        invbtn4.setPrefWidth(90.0);
        invbtn4.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        invbtn4.setText("Invite");
        invbtn4.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        invbtn4.setFont(new Font("Bookman Old Style Bold", 20.0));
        invbtn4.setOnAction(e -> {
             invitePlayer();
        });
        
        
        flow5.setPrefHeight(56.0);
        flow5.setPrefWidth(773.0);

        circle5.setFill(javafx.scene.paint.Color.DODGERBLUE);
        circle5.setRadius(30.0);
        circle5.setStroke(javafx.scene.paint.Color.BLACK);
        circle5.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        circle5.setFill(new ImagePattern(img5));
        
        allam.setPrefHeight(60.0);
        allam.setPrefWidth(351.0);
        allam.setText("Allam ");
        allam.setTextFill(javafx.scene.paint.Color.WHITE);
        allam.setFont(new Font("Bookman Old Style Bold", 32.0));
        allam.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));

        allamnum.setLayoutX(80.0);
        allamnum.setLayoutY(10.0);
        allamnum.setPrefHeight(60.0);
        allamnum.setPrefWidth(260.0);
        allamnum.setText("400");
        allamnum.setTextFill(javafx.scene.paint.Color.WHITE);
        allamnum.setFont(new Font("Bookman Old Style Bold", 32.0));
        allamnum.setPadding(new Insets(0.0, 0.0, 0.0, 22.0));

        invbtn5.setMnemonicParsing(false);
        invbtn5.setPrefHeight(50.0);
        invbtn5.setPrefWidth(90.0);
        invbtn5.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        invbtn5.setText("Invite");
        invbtn5.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        invbtn5.setFont(new Font("Bookman Old Style Bold", 20.0));
        invbtn5.setOnAction(e -> {
             invitePlayer();
        });

        flow7.setLayoutX(10.0);
        flow7.setLayoutY(310.0);
        flow7.setPrefHeight(56.0);
        flow7.setPrefWidth(773.0);

        circle1111111.setFill(javafx.scene.paint.Color.DODGERBLUE);
        circle1111111.setRadius(30.0);
        circle1111111.setStroke(javafx.scene.paint.Color.BLACK);
        circle1111111.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        circle1111111.setFill(new ImagePattern(img6));
        aya111111.setPrefHeight(60.0);
        aya111111.setPrefWidth(351.0);
        aya111111.setText("Mariam ");
        aya111111.setTextFill(javafx.scene.paint.Color.WHITE);
        aya111111.setFont(new Font("Bookman Old Style Bold", 32.0));
        aya111111.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));

        ayanum111111.setLayoutX(80.0);
        ayanum111111.setLayoutY(10.0);
        ayanum111111.setPrefHeight(60.0);
        ayanum111111.setPrefWidth(260.0);
        ayanum111111.setText("70");
        ayanum111111.setTextFill(javafx.scene.paint.Color.WHITE);
        ayanum111111.setFont(new Font("Bookman Old Style Bold", 32.0));
        ayanum111111.setPadding(new Insets(0.0, 0.0, 0.0, 22.0));

        invbtn1111111.setMnemonicParsing(false);
        invbtn1111111.setPrefHeight(50.0);
        invbtn1111111.setPrefWidth(90.0);
        invbtn1111111.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        invbtn1111111.setText("Invite");
        invbtn1111111.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        invbtn1111111.setFont(new Font("Bookman Old Style Bold", 20.0));
        invbtn1111111.setOnAction(e -> {
             invitePlayer();
        });
        
        Backbtn.setLayoutX(31.0);
        Backbtn.setLayoutY(20.0);
        Backbtn.setMnemonicParsing(false);
        Backbtn.setStyle("-fx-background-radius: 25; -fx-background-color: FFFF; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        Backbtn.setText("Back");
        Backbtn.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        Backbtn.setFont(new Font("Comic Sans MS Bold", 25.0));
        Backbtn.setOnAction(event -> TicTacToe.goBack());
        
       
        
        getChildren().add(imgview);
        getChildren().add(playlist);
        hbox.getChildren().add(name);
        hbox.getChildren().add(status);
        getChildren().add(hbox);
        flow1.getChildren().add(circle1);
        flow1.getChildren().add(aya);
        flow1.getChildren().add(ayanum);
        flow1.getChildren().add(invbtn1);
        vBox.getChildren().add(flow1);
        flow2.getChildren().add(circle2);
        flow2.getChildren().add(samuel);
        flow2.getChildren().add(samuelnum);
        flow2.getChildren().add(invbtn2);
        vBox.getChildren().add(flow2);
        flow3.getChildren().add(circle3);
        flow3.getChildren().add(hadi);
        flow3.getChildren().add(hadinum);
        flow3.getChildren().add(invbtn3);
        vBox.getChildren().add(flow3);
        flow4.getChildren().add(circle4);
        flow4.getChildren().add(omar);
        flow4.getChildren().add(omarnum);
        flow4.getChildren().add(invbtn4);
        vBox.getChildren().add(flow4);
        flow5.getChildren().add(circle5);
        flow5.getChildren().add(allam);
        flow5.getChildren().add(allamnum);
        flow5.getChildren().add(invbtn5);
        vBox.getChildren().add(flow5);
        flow7.getChildren().add(circle1111111);
        flow7.getChildren().add(aya111111);
        flow7.getChildren().add(ayanum111111);
        flow7.getChildren().add(invbtn1111111);
        vBox.getChildren().add(flow7);
        pane.getChildren().add(vBox);
        getChildren().add(pane);
        getChildren().add(Backbtn);

    }
     private void invitePlayer() {
            try {
                // Load the second FXML file for the invitation dialog
                FXMLLoader loader = new FXMLLoader(getClass().getResource("alert.fxml"));
                Parent root = loader.load();
                
                Button cancel = (Button) loader.getNamespace().get("cnacelbtn");
                cancel.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #2AAAFD;");
                cancel.setTextFill(javafx.scene.paint.Color.valueOf("#ffff"));
                cancel.setFont(new Font("System Bold Italic", 25.0));
                cancel.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Stage stage = (Stage) cancel.getScene().getWindow();
                        stage.close();
                    }
                });
        

                Stage popupStage = new Stage();
                popupStage.initModality(Modality.APPLICATION_MODAL);
                popupStage.initStyle(StageStyle.UNDECORATED);
                popupStage.setScene(new Scene(root, Color.TRANSPARENT));
                popupStage.showAndWait(); 
          
                
        
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
