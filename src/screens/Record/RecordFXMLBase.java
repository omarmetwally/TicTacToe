package screens.Record;

import java.io.File;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import screens.Board.BoardFXMLBase;
import screens.Board.GameMode;
import tictactoe.TicTacToe;

public class RecordFXMLBase extends AnchorPane {

    protected final ImageView imageView;

    private ListView<String> recordListView;
    protected final Button btnBack;
    public static String fileName;
    protected final Label noRecordsLabel;
    Stage s;

    public RecordFXMLBase(Stage stage) {

        imageView = new ImageView();
        recordListView = new ListView();
        btnBack = new Button();
        s = stage;

        setId("AnchorPane");
        setPrefHeight(824.0);
        setPrefWidth(1416.0);

        imageView.setFitHeight(1174.0);
        imageView.setFitWidth(2043.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/cover.png").toExternalForm()));

        recordListView.setLayoutX(435.0);
        recordListView.setLayoutY(172.0);
        recordListView.setPrefHeight(674.0);
        recordListView.setPrefWidth(1126.0);

        btnBack.setLayoutX(31.0);
        btnBack.setLayoutY(20.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setStyle("-fx-background-radius: 25; -fx-background-color: FFFF; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        btnBack.setText("Back");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        btnBack.setFont(new Font("Comic Sans MS Bold", 25.0));
        btnBack.setOnAction(event -> TicTacToe.goBack());
        noRecordsLabel = new Label("No records");
        noRecordsLabel.setLayoutX(807);
        noRecordsLabel.setLayoutY(439);
        noRecordsLabel.setFont(new Font("Comic Sans MS Bold", 90));
        noRecordsLabel.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));

        noRecordsLabel.setVisible(true);

        getChildren().add(imageView);
        getChildren().add(recordListView);
        getChildren().add(btnBack);
        getChildren().add(noRecordsLabel);
        initialize();

    }

    public void initialize() {
        String directory = System.getProperty("user.dir") + "/src/screens/Record/";
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                recordListView.getItems().add(file.getName());
            }
        }

        if (recordListView.getItems().isEmpty()) {
            recordListView.setVisible(false);
            noRecordsLabel.setVisible(true);
        } else {
            recordListView.setVisible(true);
            noRecordsLabel.setVisible(false);
        }
        recordListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println(newValue);
                fileName = newValue;
                String[] baseName = extractPlayerNamesFromFile(fileName);
                BoardFXMLBase boardScreen = new BoardFXMLBase(s, baseName[0], baseName[1], GameMode.RECORD);
                Scene boardScene = new Scene(boardScreen);
                TicTacToe.changeScene(boardScene);
            }
        });
    }

    private String[] extractPlayerNamesFromFile(String fileName) {
        
        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        return baseName.split("&");
    }
}
