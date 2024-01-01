/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.Plist;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import screens.Board.BoardFXMLBase;
import screens.Board.GameMode;
import tictactoe.TicTacToe;

/**
 *
 * @author Aya
 */
public class AlertMessage {
    public Stage popupStage = new Stage();
    
    public  void showAction(String text) {
        try {
                
                // Load the second FXML file for the invitation dialog
                FXMLLoader loader = new FXMLLoader(getClass().getResource("alert.fxml"));
                
                Parent root = loader.load();
                System.out.println("here");
                Button cancel = (Button) loader.getNamespace().get("cnacelbtn");
                Text alertText = (Text) loader.getNamespace().get("waittxt");
                cancel.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #2AAAFD;");
                cancel.setTextFill(javafx.scene.paint.Color.valueOf("#ffff"));
                cancel.setFont(new Font("System Bold Italic", 25.0));
                cancel.setText("Ok");
                cancel.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Stage stage = (Stage) cancel.getScene().getWindow();
                        stage.close();
                    }
                });
                
                alertText.setText(text);
                alertText.setFont(new Font("Comic Sans MS Bold", 41.0));
               // Stage popupStage = new Stage();
                popupStage.initModality(Modality.APPLICATION_MODAL);
                popupStage.initStyle(StageStyle.UNDECORATED);
                popupStage.setScene(new Scene(root, Color.TRANSPARENT));
               // popupStage.showAndWait(); 
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    
    public void toShowandWait() {
        
        popupStage.showAndWait();
    }
    
    public void closeAlert() {
        
        popupStage.close();
    }
}
