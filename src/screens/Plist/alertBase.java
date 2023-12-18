package screens.Plist;

import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class alertBase extends AnchorPane {

    protected final Text waittxt;
    protected final Button cnacelbtn;

    public alertBase() {

        waittxt = new Text();
        cnacelbtn = new Button();

        setId("AnchorPane");
        setPrefHeight(371.0);
        setPrefWidth(574.0);

        waittxt.setFill(javafx.scene.paint.Color.valueOf("#2aaafd"));
        waittxt.setLayoutX(61.0);
        waittxt.setLayoutY(142.0);
        waittxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        waittxt.setStrokeWidth(0.0);
        waittxt.setText("Waiting for Approval...");
        waittxt.setFont(new Font("Comic Sans MS Bold", 41.0));

        cnacelbtn.setLayoutX(238.0);
        cnacelbtn.setLayoutY(234.0);
        cnacelbtn.setMnemonicParsing(false);
        cnacelbtn.setPrefHeight(57.0);
        cnacelbtn.setPrefWidth(116.0);
        cnacelbtn.setText("Cancel");
        cnacelbtn.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        cnacelbtn.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        cnacelbtn.setFont(new Font("System Bold Italic", 25.0));

        getChildren().add(waittxt);
        getChildren().add(cnacelbtn);
        
    }
    
         
}

    