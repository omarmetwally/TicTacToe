/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.login_screen;

import models.ServerEventType;

/**
 *
 * @author allam
 */
public class UserCredentials {

    private ServerEventType type = ServerEventType.Login;
    private String userName;

    public ServerEventType getType() {
        return type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserCredentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    private String password;

}
