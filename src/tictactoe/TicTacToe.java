/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import com.google.gson.Gson;
import helper.Helper;
import java.io.IOException;
import screens.Plist.PllistBase;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import screens.login_screen.LoginScreenBase;
import screens.LocalPlayers.LocalPlayersBase;
import screens.LocalOnlinescreen.LocalonscreenBase;
import screens.Plist.ForExit;
import screens.Plist.LogOut;
import static screens.Plist.PllistBase.getUserName;
import static screens.Plist.PllistBase.getUserNametoExit;
import screens.SplashScreen.SplashScreenBase;
import screens.mode.ModeScreenBase;

/**
 *
 * @author Omar
 */
public class TicTacToe extends Application {

    // PllistBase plist = new PllistBase();
   
    private static Stage primaryStage;
    private static NavigationHistory navHistory = new NavigationHistory();

    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;
        Socket currentSocketParameter;
        Parent root = new SplashScreenBase();
        // push awl Screen "Scene"
        Scene initialScene = new Scene(root);
        navHistory.pushScene(initialScene);
        primaryStage.setScene(initialScene);
        primaryStage.setMaximized(true);
        primaryStage.show();
        new Thread(() -> {
            try {

                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }

            Platform.runLater(() -> {
                try {
                    ModeScreenBase modeScreen = new ModeScreenBase(stage);
                    Scene modeScene = new Scene(modeScreen);
                    changeScene(modeScene);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }).start();
        PllistBase.getUserName();
        primaryStage.setOnCloseRequest((WindowEvent event) -> {
            // Your code to handle the close event goes here
           new Thread(() -> {
                try {
                    Helper helper = new Helper();
                    ForExit forExit = getUserNametoExit();
                    Gson gson = new Gson();
                    
                    String logg = gson.toJson(forExit);
                     helper.LogOutRequest(logg);
                    System.out.println("Logout req =" + logg);
                } catch (IOException ex) {
                    Logger.getLogger(PllistBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }).start();
        });

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
