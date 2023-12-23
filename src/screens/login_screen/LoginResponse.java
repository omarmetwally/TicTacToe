/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.login_screen;

/**
 *
 * @author allam
 */
public class LoginResponse {
   
    private Boolean isSuccessfull ;

    public LoginResponse(Boolean isSuccessfull, String message) {
        this.isSuccessfull = isSuccessfull;
        this.message = message;
    }

    public Boolean getIsSuccessfull() {
        return isSuccessfull;
    }

    public void setIsSuccessfull(Boolean isSuccessfull) {
        this.isSuccessfull = isSuccessfull;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    private String message ;
    
}
