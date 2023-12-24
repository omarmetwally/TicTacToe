/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author allam
 */
public class Helper extends Application{
    
    private Socket playerSocket;
    private DataInputStream ear;
    private PrintStream mouth;

    public Helper() {
        
        

        try {
            playerSocket = new Socket("127.0.0.1", 5005);
            ear = new DataInputStream(playerSocket.getInputStream());
            mouth = new PrintStream(playerSocket.getOutputStream());



        } catch (IOException ex) {
            ex.printStackTrace();
        } 
       

    }

    public String registerRequest(String jsonObj) throws IOException{
        
       if (playerSocket.isConnected()) {
            mouth.println(jsonObj);
            return ear.readLine();
        } else {
            return null;
        }
    
    }
     public void closeConnection() throws IOException {
        if (ear != null) ear.close();
        if (mouth != null) mouth.close();
        if (playerSocket != null) playerSocket.close();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String [] args){

      new Helper();
    }
    
}
