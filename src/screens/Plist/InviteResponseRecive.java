/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.Plist;

import models.JsonReceiveBase;

/**
 *
 * @author Omar
 */
public class InviteResponseRecive extends JsonReceiveBase{
   
    private int status;
    String ReceiverUserName;
    String senderUserName;

    public String getReceiverUserName() {
        return ReceiverUserName;
    }

    public void setReceiverUserName(String ReceiverUserName) {
        this.ReceiverUserName = ReceiverUserName;
    }

    public String getSenderUserName() {
        return senderUserName;
    }

    public void setSenderUserName(String senderUserName) {
        this.senderUserName = senderUserName;
    }

   

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
