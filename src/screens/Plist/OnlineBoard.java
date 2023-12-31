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
    String receiverUserName;
    private ServerEventType type = ServerEventType.Invite;
    String currentTurn;
    


    public OnlineBoard(String senderUN, String ReceiverUN) {
        this.senderUserName = senderUN;
        this.receiverUserName = ReceiverUN;
        //this.currentTurn = currentTurn;
    }

    public void setSenderUN(String senderUN) {
        this.senderUserName = senderUN;
    }

    public void setReceiverUN(String ReceiverUN) {
        this.receiverUserName = ReceiverUN;
    }

    public void setCurrentTurn(String currentTurn) {
        this.currentTurn = currentTurn;
    }

    public String getSenderUN() {
        return senderUserName;
    }

    public String getReceiverUN() {
        return receiverUserName;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }
    
    
    
}
