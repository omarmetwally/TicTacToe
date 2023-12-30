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

/**
 *
 * @author allam
 */

public class Helper {

    Socket playerSocket;
    DataInputStream ear;
    PrintStream mouth;
    public Helper() {

        try {
            playerSocket = new Socket("127.0.0.1", 5005);
            ear = new DataInputStream(playerSocket.getInputStream());
            mouth = new PrintStream(playerSocket.getOutputStream());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String registerRequest(String jsonObj) throws IOException {

        if (playerSocket.isConnected()) {
            mouth.println(jsonObj);
            return ear.readLine();
        } else {
            return null;

        }

    }


    public String loginRequest(String userCredential) throws IOException {

        if (playerSocket.isConnected()) {
            mouth.println(userCredential); 
            return ear.readLine(); 
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


   
    public String sendMove(String moveJson) throws IOException {

        if (playerSocket.isConnected()) {
            mouth.println(moveJson); 
            return ear.readLine(); 
        } else {
            return null;
        }

    }
     
  

    public static void main(String[] args) {
        new Helper();
    }

}


