/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.Plist;

import models.ServerEventType;

/**
 *
 * @author Aya
 */
public class LogOut {
    private ServerEventType type = ServerEventType.Logout;
    private String userName;
    
    public LogOut(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
