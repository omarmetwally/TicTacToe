/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import models.JsonReceiveBase;
import screens.login_screen.ServerEventType;

/**
 *
 * @author allam
 */

public class Helper {

    Socket playerSocket;
    DataInputStream ear;
    PrintStream mouth;
    JsonReceiveBase jsonreceive;
    




    public Helper() {

        try {
            playerSocket = new Socket("127.0.0.1", 5005);
            ear = new DataInputStream(playerSocket.getInputStream());
            mouth = new PrintStream(playerSocket.getOutputStream());
           jsonreceive = new JsonReceiveBase();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String registerRequest(String jsonObj) throws IOException {

        if (playerSocket.isConnected()) {
            mouth.println(jsonObj);
            String respo =  ear.readLine();
             System.out.println("in the Helper i recieve from Aya  "+respo);
            return respo;
        } else {
            return null;

        }

    }


    public String loginRequest(String userCredential) throws IOException {

        if (playerSocket.isConnected()) {
            mouth.println(userCredential); 
            String respo =  ear.readLine();
            System.out.println("in the Helper i recieve from Samuel  "+respo);
            return respo; 
        } else {
            return null;
        }

    }
    
        public String ListRequest (String userNameJ) throws IOException{
        if (playerSocket.isConnected()) {
            mouth.println(userNameJ);
           String resposne = ear.readLine();  // Store the response
            System.out.println("in the Helper i recieve from Aya  "+resposne);
           return resposne;
        }else {
            return null;
        }
    }
    
    public String InviteRequest (String userNameJ) throws IOException{
        if (playerSocket.isConnected()) {
            mouth.println(userNameJ);
            return ear.readLine();  // Store the response  
        }else{
            return null;
        }
    }
    
    public String readMessage () throws IOException{
        if (playerSocket.isConnected()) {
            return ear.readLine();  // Store the response  
        }else{
            return null;
        }
    }
  
    
  public String receiveInvitation() throws IOException {
    if (playerSocket.isConnected()) {
           String message = ear.readLine();
           System.out.println("in the Helper i recieve from Allam  "+message);
            return message;
    } else {
        return null;
    }    
}
    

    public void closeConnection() throws IOException {
        if (ear != null) {
            ear.close();
        }
        if (mouth != null) {
            mouth.close();
        }
        if (playerSocket != null) {
            playerSocket.close();
        }
    }


   

     
  

    public static void main(String[] args) {

        new Helper();
    }

}


