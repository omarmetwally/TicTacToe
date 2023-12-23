/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.login_screen;


import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author allam
 */
public class LoginScreenController {
    
    @FXML
    private TextField userNameTextField;
    
    @FXML
    private PasswordField passwordTextField;
    
    public String getUserName(){
      return userNameTextField.getText();
    }
    
    public String getPassword(){
      return passwordTextField.getText();
    }
    
    
    
}
