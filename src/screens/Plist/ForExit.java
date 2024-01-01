/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.Plist;

import screens.login_screen.ServerEventType;

/**
 *
 * @author Aya
 */
public class ForExit {
    private ServerEventType type = ServerEventType.Exit;
    private String userName;
    
    public ForExit(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
