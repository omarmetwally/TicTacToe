/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login_screen.LoginScreenBase;
import screens.LocalPlayers.LocalPlayersBase;
import screens.LocalOnlinescreen.LocalonscreenBase;
import screens.mode.ModeScreenBase;

/**
 *
 * @author Omar
 */
public class TicTacToe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = new LoginScreenBase();

      //  Parent root = new LocalPlayersBase();

      //  Parent root = new LocalonscreenBase(stage);
        
       Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
