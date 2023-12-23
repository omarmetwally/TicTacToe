/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.login_screen;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author allam
 */
public class UserCredentialsImpl {

    public UserCredentialsImpl() {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        try {
            Parent root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(UserCredentialsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        LoginScreenController controller = loader.getController();

        String username = controller.getUserName();
        String password = controller.getPassword();

        UserCredentials userCredentials = new UserCredentials(username, password);
        Gson gson = new Gson();
        String jsonUserCredentials = gson.toJson(userCredentials);

    }



    public static void main(String[] args) {
        launch(args);

    }

}
