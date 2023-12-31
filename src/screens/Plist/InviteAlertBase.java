package screens.Plist;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class InviteAlertBase extends AnchorPane {

    protected final Text txt;
    protected final Text sender;
    protected final Button accept;
    protected final Button cancel;

    public InviteAlertBase(String Sender) {

        txt = new Text();
        sender = new Text();
        accept = new Button();
        cancel = new Button();

        setId("AnchorPane");
        setPrefHeight(371.0);
        setPrefWidth(616.0);

        txt.setFill(javafx.scene.paint.Color.valueOf("#2aaafd"));
        txt.setLayoutX(133.0);
        txt.setLayoutY(122.0);
        txt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txt.setStrokeWidth(0.0);
        txt.setText(" has invited you to start a game");
        txt.setWrappingWidth(482.59375);
        txt.setFont(new Font("Comic Sans MS Bold", 30.0));

        sender.setFill(javafx.scene.paint.Color.valueOf("#2aaafd"));
        sender.setLayoutX(23.0);
        sender.setLayoutY(116.0);
        sender.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        sender.setStrokeWidth(0.0);
        sender.setText(Sender);
        sender.setWrappingWidth(72.6708984375);
        sender.setFont(new Font("Comic Sans MS Bold", 30.0));

        accept.setLayoutX(133.0);
        accept.setLayoutY(230.0);
        accept.setMnemonicParsing(false);
        accept.setPrefHeight(63.0);
        accept.setPrefWidth(144.0);
        accept.setText("Accept");
        accept.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        accept.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        accept.setFont(new Font("System Bold Italic", 24.0));

        cancel.setLayoutX(351.0);
        cancel.setLayoutY(230.0);
        cancel.setMnemonicParsing(false);
        cancel.setPrefHeight(63.0);
        cancel.setPrefWidth(144.0);
        cancel.setText("Cancel");
        cancel.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        cancel.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        cancel.setFont(new Font("System Bold Italic", 24.0));

        getChildren().add(txt);
        getChildren().add(sender);
        getChildren().add(accept);
        getChildren().add(cancel);

    }
}
