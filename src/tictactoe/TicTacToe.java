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
import screens.login_screen.LoginScreenBase;
import screens.LocalPlayers.LocalPlayersBase;
import screens.LocalOnlinescreen.LocalonscreenBase;
import screens.mode.ModeScreenBase;

/**
 *
 * @author Omar
 */
public class TicTacToe extends Application {
    private static Stage primaryStage;
    private static NavigationHistory navHistory = new NavigationHistory();
    
    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;
        Parent root = new ModeScreenBase(stage);
        // push awl Screen "Scene"
        Scene initialScene = new Scene(root);
        navHistory.pushScene(initialScene);
        primaryStage.setScene(initialScene);
        primaryStage.setMaximized(true);
        primaryStage.show();

    }

    public static void changeScene(Scene newScene) {
        navHistory.pushScene(newScene);
        primaryStage.setScene(newScene);
    }

    public static void goBack() {
        navHistory.popScene(); 
        Scene previousScene = navHistory.peekScene();
        if (previousScene != null) {
            primaryStage.setScene(previousScene);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
