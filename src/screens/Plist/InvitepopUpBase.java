package screens.Plist;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class InvitepopUpBase extends AnchorPane {

    protected final Text sender;
    protected final Text textAlert;
    protected final Button acceptbtn;
    protected final Button cancelbtn;

    public InvitepopUpBase(String Sender) {

        sender = new Text();
        textAlert = new Text();
        acceptbtn = new Button();
        cancelbtn = new Button();

        setId("AnchorPane");
        setPrefHeight(371.0);
        setPrefWidth(598.0);

        sender.setFill(javafx.scene.paint.Color.valueOf("#2aaafd"));
        sender.setLayoutX(36.0);
        sender.setLayoutY(134.0);
        sender.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        sender.setStrokeWidth(0.0);
        //sender.setText("Text");
        sender.setWrappingWidth(127.6708984375);
        sender.setFont(new Font("Comic Sans MS", 41.0));

        textAlert.setFill(javafx.scene.paint.Color.valueOf("#2aaafd"));
        textAlert.setLayoutX(164.0);
        textAlert.setLayoutY(134.0);
        textAlert.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textAlert.setStrokeWidth(0.0);
        //textAlert.setText("has Invite you...");
        textAlert.setWrappingWidth(358.220703125);
        textAlert.setFont(new Font("Comic Sans MS Bold", 41.0));

        acceptbtn.setLayoutX(118.0);
        acceptbtn.setLayoutY(236.0);
        acceptbtn.setMnemonicParsing(false);
        acceptbtn.setPrefHeight(54.0);
        acceptbtn.setPrefWidth(106.0);
        acceptbtn.setText("Accept");
        acceptbtn.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        acceptbtn.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        acceptbtn.setFont(new Font("Comic Sans MS Bold", 24.0));
      

        cancelbtn.setLayoutX(351.0);
        cancelbtn.setLayoutY(236.0);
        cancelbtn.setMnemonicParsing(false);
        cancelbtn.setPrefHeight(54.0);
        cancelbtn.setPrefWidth(106.0);
        cancelbtn.setText("Cancel");
        cancelbtn.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        cancelbtn.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        cancelbtn.setFont(new Font("Comic Sans MS Bold", 24.0));
       

        getChildren().add(sender);
        getChildren().add(textAlert);
        getChildren().add(acceptbtn);
        getChildren().add(cancelbtn);

    }
}
