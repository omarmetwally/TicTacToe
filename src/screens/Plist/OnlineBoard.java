/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.Plist;

/**
 *
 * @author Aya
 */
public class OnlineBoard {
    String senderUN;
    String ReceiverUN;
    String currentTurn;

    public OnlineBoard(String senderUN, String ReceiverUN, String currentTurn) {
        this.senderUN = senderUN;
        this.ReceiverUN = ReceiverUN;
        this.currentTurn = currentTurn;
    }

    public void setSenderUN(String senderUN) {
        this.senderUN = senderUN;
    }

    public void setReceiverUN(String ReceiverUN) {
        this.ReceiverUN = ReceiverUN;
    }

    public void setCurrentTurn(String currentTurn) {
        this.currentTurn = currentTurn;
    }

    public String getSenderUN() {
        return senderUN;
    }

    public String getReceiverUN() {
        return ReceiverUN;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }
    
    
    
}
