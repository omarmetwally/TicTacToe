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
public class OnlineBoard {
    String senderUserName;
    String ReceiverUserName;
    String currentTurn;
    private ServerEventType type = ServerEventType.Invite;


    public OnlineBoard(String senderUN, String ReceiverUN) {
        this.senderUserName = senderUN;
        this.ReceiverUserName = ReceiverUN;
        //this.currentTurn = currentTurn;
    }

    public void setSenderUN(String senderUN) {
        this.senderUserName = senderUN;
    }

    public void setReceiverUN(String ReceiverUN) {
        this.ReceiverUserName = ReceiverUN;
    }

    public void setCurrentTurn(String currentTurn) {
        this.currentTurn = currentTurn;
    }

    public String getSenderUN() {
        return senderUserName;
    }

    public String getReceiverUN() {
        return ReceiverUserName;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }
    
    
    
}
