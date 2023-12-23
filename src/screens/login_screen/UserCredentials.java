/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.login_screen;

import helper.ServerEventType;

/**
 *
 * @author allam
 */
public class UserCredentials {

    private ServerEventType type = ServerEventType.Login;
    private String user_name;
    private String password;

    public UserCredentials(String user_name, String password) {

        this.user_name = user_name;
        this.password = password;

    }
    
    public void setUserName(String user_name){
        this.user_name = user_name;
    }
    
    public String getUserName(){
       return user_name;
    }
    
    public void setPassword(String password){
       this.password = password;
    }
    
    public String getPassword(){
      return password;
    }
    
    
 public String getType(){
      return type.toString();
    }
}
