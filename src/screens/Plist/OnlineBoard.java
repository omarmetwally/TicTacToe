/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.Plist;

import models.JsonReceiveBase;
import models.ServerEventType;

/**
 *
 * @author Aya
 */
public class OnlineBoard  {
    String senderUserName;
    String receiverUserName;
    String currentTurn;
    private ServerEventType type = ServerEventType.Invite;


    public OnlineBoard(String senderUN, String ReceiverUN) {
        this.senderUserName = senderUN;
        this.receiverUserName = ReceiverUN;
        //this.currentTurn = currentTurn;
    }

    public void setSenderUserName(String senderUN) {
        this.senderUserName = senderUN;
    }

    public void setReceiverUserName(String ReceiverUN) {
        this.receiverUserName = ReceiverUN;
    }

    public void setCurrentTurn(String currentTurn) {
        this.currentTurn = currentTurn;
    }

    public String getSenderUserName() {
        return senderUserName;
    }

    public String getReceiverUserName() {
        return receiverUserName;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }
    
    
    
}
