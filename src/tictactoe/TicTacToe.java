/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.net.Socket;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import screens.login_screen.LoginScreenBase;
import screens.LocalPlayers.LocalPlayersBase;
import screens.LocalOnlinescreen.LocalonscreenBase;
import screens.SplashScreen.SplashScreenBase;
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
