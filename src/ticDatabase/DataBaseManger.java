/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import org.apache.derby.jdbc.ClientDriver;
import screens.login_screen.LoginScreenBase;

/**
 *
 * @author allam
 */
public class DataBaseManger  {
    
    Connection con;
    LoginScreenBase logscrbase;
    
    public DataBaseManger(){
    
        try {
            DriverManager.registerDriver(new ClientDriver());
            
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/tic_tac_toe", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManger.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    
    }
    
    public void addNewPlayer(Stage stage){
       
          
        }
    
}
