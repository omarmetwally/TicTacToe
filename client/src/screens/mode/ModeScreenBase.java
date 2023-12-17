package screens.mode;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public  class ModeScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button button;
    protected final ImageView imageView0;
    protected final Button button0;
    protected final ImageView imageView1;

    public ModeScreenBase() {

        imageView = new ImageView();
        button = new Button();
        imageView0 = new ImageView();
        button0 = new Button();
        imageView1 = new ImageView();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(825.0);
        imageView.setFitWidth(1280.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../../assets/cover.png").toExternalForm()));

        button.setLayoutX(323.0);
        button.setLayoutY(207.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(203.0);
        button.setPrefWidth(258.0);
        button.setStyle("-fx-background-radius: 25; -fx-background-color: FCF75E; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        button.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        imageView0.setFitHeight(193.0);
        imageView0.setFitWidth(224.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("../../assets/pve.png").toExternalForm()));
        button.setGraphic(imageView0);

        button0.setLayoutX(693.0);
        button0.setLayoutY(207.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(203.0);
        button0.setPrefWidth(258.0);
        button0.setStyle("-fx-background-radius: 25; -fx-background-color: FCF75E; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        button0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        imageView1.setFitHeight(193.0);
        imageView1.setFitWidth(209.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("../../assets/pvp.png").toExternalForm()));
        button0.setGraphic(imageView1);

        getChildren().add(imageView);
        getChildren().add(button);
        getChildren().add(button0);

    }
}
