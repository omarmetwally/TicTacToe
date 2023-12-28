/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package screens.Plist;
import javafx.scene.image.Image;
import screens.login_screen.ServerEventType;
/**
 *
 * @author Aya
 */
public class Player {
    private ServerEventType type = ServerEventType.AvailPlayers;
    private String userName;
    private int score;
   // private Image image; // You may want to use a more appropriate type for an image, like Image or URL
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
  
    public Player()
    {
        this.userName=null;
    
    }
    public Player(String name, int points) {
        this.userName = name;
        this.score = points;
     //   this.image = new Image("/assets/a65832155622ac173337874f02b218fb.jpg");
    }
    // Getters and setters for name, points, and image
    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public int getPoints() {
        return score;
    }

    public void setPoints(int points) {
        this.score = points;
    }
    public ServerEventType getType() {
        return type;
    }
    /*   public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    } */ 
}
