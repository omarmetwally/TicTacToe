package screens.Board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import screens.Record.Record;
import screens.Record.RecordFXMLBase;
import tictactoe.TicTacToe;

public class BoardFXMLBase extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final ColumnConstraints columnConstraints5;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final Button btn00;
    protected final ImageView img00;
    protected final Button btn01;
    protected final ImageView img01;
    protected final Button brn02;
    protected final ImageView img02;
    protected final Button btn10;
    protected final ImageView img10;
    protected final Button btn11;
    protected final ImageView img11;
    protected final Button btn12;
    protected final ImageView img12;
    protected final Button btn20;
    protected final ImageView img20;
    protected final Button btn21;
    protected final ImageView img21;
    protected final Button btn22;
    protected final ImageView img22;
    protected final ImageView imageView1;
    protected final Pane pane;
    protected final Button button;
    protected final ImageView imageView2;
    protected final Text txtPlayer2;
    protected final Pane pane0;
    protected final Button button0;
    protected final ImageView imageView3;
    protected final Text txtPlayer1;
    protected final Button button1;
    protected final Button scorePlayer1;
    protected final Button scorePlayer2;
    protected final Button btnRecord;
    protected final Button btnBack;
    protected final MediaView WinnerVideo;
    protected Text whosTurn;
    protected boolean aiTurn = false;
    protected final Record record;

    protected  MediaPlayer mediaPlayer;

    private boolean isRecording = false;


    protected final GameMode gamemode; //'multi' ,'Single'
    protected ImageView btnImage;

    private TicTacToeGame game;

    public BoardFXMLBase(Stage stage, String Player1, String Player2, GameMode gamemode,String userName) {

        record = new Record();
        this.gamemode = gamemode;
        game = new TicTacToeGame(Player1, Player2, gamemode);

        imageView = new ImageView();
        imageView0 = new ImageView();
        gridPane = new GridPane();
        WinnerVideo = new MediaView();

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        btn00 = new Button();
        img00 = new ImageView();
        btn01 = new Button();
        img01 = new ImageView();
        brn02 = new Button();
        img02 = new ImageView();
        btn10 = new Button();
        img10 = new ImageView();
        btn11 = new Button();
        img11 = new ImageView();
        btn12 = new Button();
        img12 = new ImageView();
        btn20 = new Button();
        img20 = new ImageView();
        btn21 = new Button();
        img21 = new ImageView();
        btn22 = new Button();
        img22 = new ImageView();
        imageView1 = new ImageView();
        pane = new Pane();
        button = new Button();
        imageView2 = new ImageView();
        txtPlayer2 = new Text();
        pane0 = new Pane();
        button0 = new Button();
        imageView3 = new ImageView();
        txtPlayer1 = new Text();
        button1 = new Button();
        scorePlayer1 = new Button();
        scorePlayer2 = new Button();
        btnRecord = new Button();
        btnBack = new Button();
        btnImage = new ImageView();
        whosTurn = new Text();

        setId("AnchorPane");
        setPrefHeight(824.0);
        setPrefWidth(1416.0);
        getStylesheets().add("/screens/Board/style.css");

        imageView.setFitHeight(1174.0);
        imageView.setFitWidth(2043.0);
        imageView.setLayoutX(-2.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/cover.png").toExternalForm()));

        imageView0.setFitHeight(634.0);
        imageView0.setFitWidth(637.0);
        imageView0.setLayoutX(818.0);
        imageView0.setLayoutY(188.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/assets/BlankBoard.png").toExternalForm()));

        gridPane.setLayoutX(913.0);
        gridPane.setLayoutY(278.0);
        gridPane.setPrefHeight(505.0);
        gridPane.setPrefWidth(527.0);
        gridPane.getStyleClass().add("game-board");

        btn00.setMnemonicParsing(false);
        btn00.setPrefHeight(127.0);
        btn00.setPrefWidth(127.0);
        btn00.setStyle("-fx-border-radius: 60;");
        btn00.getStyleClass().add("game-button");

        img00.setFitHeight(118.0);
        img00.setFitWidth(96.0);
        img00.setPickOnBounds(true);
        img00.setPreserveRatio(true);
        btn00.setGraphic(img00);

        GridPane.setColumnIndex(btn01, 3);
        btn01.setMnemonicParsing(false);
        btn01.setPrefHeight(127.0);
        btn01.setPrefWidth(127.0);
        btn01.getStyleClass().add("game-button");

        img01.setFitHeight(118.0);
        img01.setFitWidth(96.0);
        img01.setPickOnBounds(true);
        img01.setPreserveRatio(true);
        btn01.setGraphic(img01);

        GridPane.setColumnIndex(brn02, 6);
        brn02.setMnemonicParsing(false);
        brn02.setPrefHeight(127.0);
        brn02.setPrefWidth(127.0);
        brn02.getStyleClass().add("game-button");

        img02.setFitHeight(118.0);
        img02.setFitWidth(96.0);
        img02.setPickOnBounds(true);
        img02.setPreserveRatio(true);
        brn02.setGraphic(img02);

        GridPane.setRowIndex(btn10, 3);
        btn10.setMnemonicParsing(false);
        btn10.setPrefHeight(127.0);
        btn10.setPrefWidth(127.0);
        btn10.getStyleClass().add("game-button");

        img10.setFitHeight(118.0);
        img10.setFitWidth(96.0);
        img10.setPickOnBounds(true);
        img10.setPreserveRatio(true);
        btn10.setGraphic(img10);

        GridPane.setColumnIndex(btn11, 3);
        GridPane.setRowIndex(btn11, 3);
        btn11.setMnemonicParsing(false);
        btn11.setPrefHeight(127.0);
        btn11.setPrefWidth(127.0);
        btn11.getStyleClass().add("game-button");

        img11.setFitHeight(118.0);
        img11.setFitWidth(96.0);
        img11.setPickOnBounds(true);
        img11.setPreserveRatio(true);
        btn11.setGraphic(img11);

        GridPane.setColumnIndex(btn12, 6);
        GridPane.setRowIndex(btn12, 3);
        btn12.setMnemonicParsing(false);
        btn12.setPrefHeight(127.0);
        btn12.setPrefWidth(127.0);
        btn12.getStyleClass().add("game-button");

        img12.setFitHeight(118.0);
        img12.setFitWidth(96.0);
        img12.setPickOnBounds(true);
        img12.setPreserveRatio(true);
        btn12.setGraphic(img12);

        GridPane.setRowIndex(btn20, 5);
        btn20.setMnemonicParsing(false);
        btn20.setPrefHeight(127.0);
        btn20.setPrefWidth(127.0);
        btn20.getStyleClass().add("game-button");

        img20.setFitHeight(118.0);
        img20.setFitWidth(96.0);
        img20.setPickOnBounds(true);
        img20.setPreserveRatio(true);
        btn20.setGraphic(img20);

        GridPane.setColumnIndex(btn21, 3);
        GridPane.setRowIndex(btn21, 5);
        btn21.setMnemonicParsing(false);
        btn21.setPrefHeight(127.0);
        btn21.setPrefWidth(127.0);
        btn21.getStyleClass().add("game-button");

        img21.setFitHeight(118.0);
        img21.setFitWidth(96.0);
        img21.setPickOnBounds(true);
        img21.setPreserveRatio(true);
        btn21.setGraphic(img21);

        GridPane.setColumnIndex(btn22, 6);
        GridPane.setRowIndex(btn22, 5);
        btn22.setMnemonicParsing(false);
        btn22.setPrefHeight(127.0);
        btn22.setPrefWidth(127.0);
        btn22.getStyleClass().add("game-button");

        img22.setFitHeight(118.0);
        img22.setFitWidth(96.0);
        img22.setPickOnBounds(true);
        img22.setPreserveRatio(true);
        btn22.setGraphic(img22);

        imageView1.setFitHeight(150.0);
        imageView1.setFitWidth(200.0);
        imageView1.setLayoutX(918.0);
        imageView1.setLayoutY(24.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);

        pane.setLayoutX(1526.0);
        pane.setLayoutY(277.0);
        pane.setPrefHeight(300.0);
        pane.setPrefWidth(350.0);

        button.setAlignment(javafx.geometry.Pos.CENTER);
        button.setCacheShape(false);
        button.setCenterShape(false);
        button.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        button.setFocusTraversable(false);
        button.setLayoutX(143.0);
        button.setLayoutY(64.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(99.0);
        button.setPrefWidth(93.0);
        button.setScaleShape(false);
        button.getStyleClass().add("game-button");
        button.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        button.setWrapText(true);

        imageView2.setFitHeight(118.0);
        imageView2.setFitWidth(96.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("/assets/X.png").toExternalForm()));
        button.setGraphic(imageView2);
        button.setFont(new Font("Comic Sans MS Bold", 39.0));

        txtPlayer2.setFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        txtPlayer2.setLayoutX(136.0);
        txtPlayer2.setLayoutY(209.0);
        txtPlayer2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtPlayer2.setStrokeWidth(0.0);
        txtPlayer2.setText(Player2);
        txtPlayer2.setFont(new Font("Comic Sans MS Bold", 25.0));

        pane0.setLayoutX(352.0);
        pane0.setLayoutY(288.0);
        pane0.setPrefHeight(255.0);
        pane0.setPrefWidth(227.0);

        button0.setCacheShape(false);
        button0.setCenterShape(false);
        button0.setFocusTraversable(false);
        button0.setLayoutX(86.0);
        button0.setLayoutY(71.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(99.0);
        button0.setPrefWidth(93.0);
        button0.setScaleShape(false);
        button0.getStyleClass().add("game-button");

        imageView3.setFitHeight(118.0);
        imageView3.setFitWidth(96.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("/assets/O.png").toExternalForm()));
        button0.setGraphic(imageView3);

        txtPlayer1.setFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        txtPlayer1.setLayoutX(84.0);
        txtPlayer1.setLayoutY(216.0);
        txtPlayer1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtPlayer1.setStrokeWidth(0.0);
        txtPlayer1.setText(Player1);
        txtPlayer1.setFont(new Font("Comic Sans MS Bold", 25.0));

        button1.setCacheShape(false);
        button1.setCenterShape(false);
        button1.setFocusTraversable(false);
        button1.setLayoutX(85.0);
        button1.setLayoutY(535.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(103.0);
        button1.setPrefWidth(150.0);
        button1.setScaleShape(false);
        button1.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        button1.setText("Score");
        button1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        button1.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        button1.setFont(new Font("Comic Sans MS Bold", 34.0));
        button1.setVisible(false);

        scorePlayer1.setCacheShape(false);
        scorePlayer1.setCenterShape(false);
        scorePlayer1.setFocusTraversable(false);
        scorePlayer1.setLayoutX(442.0);
        scorePlayer1.setLayoutY(547.0);
        scorePlayer1.setMnemonicParsing(false);
        scorePlayer1.setPrefHeight(82.0);
        scorePlayer1.setPrefWidth(82.0);
        scorePlayer1.setScaleShape(false);
        scorePlayer1.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        scorePlayer1.setText("0");
        scorePlayer1.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        scorePlayer1.setFont(new Font("Comic Sans MS Bold", 35.0));

        scorePlayer2.setAlignment(javafx.geometry.Pos.CENTER);
        scorePlayer2.setCacheShape(false);
        scorePlayer2.setCenterShape(false);
        scorePlayer2.setFocusTraversable(false);
        scorePlayer2.setLayoutX(1686.0);
        scorePlayer2.setLayoutY(553.0);
        scorePlayer2.setMnemonicParsing(false);
        scorePlayer2.setPrefHeight(82.0);
        scorePlayer2.setPrefWidth(82.0);
        scorePlayer2.setScaleShape(false);
        scorePlayer2.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        scorePlayer2.setText("0");
        scorePlayer2.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        scorePlayer2.setFont(new Font("Comic Sans MS Bold", 35.0));

        btnRecord.setLayoutX(1098.0);
        btnRecord.setLayoutY(813.0);
        btnRecord.setMnemonicParsing(false);
        btnRecord.setPrefHeight(81.0);
        btnRecord.setPrefWidth(145.0);
        btnRecord.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
        btnRecord.setText("Record");
        btnRecord.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        btnRecord.setFont(new Font("Comic Sans MS Bold", 25.0));
        btnRecord.setOnAction((event) -> {
            btnRecord.setDisable(true);
            // record.setIsRecording(true);
            record.startRecording(Player1, Player2);
        });

        btnBack.setLayoutX(31.0);
        btnBack.setLayoutY(20.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setStyle("-fx-background-radius: 25; -fx-background-color: FFFF; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        btnBack.setText("Back");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        btnBack.setFont(new Font("Comic Sans MS Bold", 25.0));

        btn00.setOnAction((event) -> {
            handleButtonClick(0, 0, btn00);
        });
        btn01.setOnAction((event) -> {
            handleButtonClick(0, 1, btn01);
        });
        brn02.setOnAction((event) -> {
            handleButtonClick(0, 2, brn02);
        });
        btn10.setOnAction((event) -> {
            handleButtonClick(1, 0, btn10);
        });
        btn11.setOnAction((event) -> {
            handleButtonClick(1, 1, btn11);
        });
        btn12.setOnAction((event) -> {
            handleButtonClick(1, 2, btn12);
        });
        btn20.setOnAction((event) -> {
            handleButtonClick(2, 0, btn20);
        });
        btn21.setOnAction((event) -> {
            handleButtonClick(2, 1, btn21);
        });
        btn22.setOnAction((event) -> {
            handleButtonClick(2, 2, btn22);
        });
        btnBack.setOnAction(event -> TicTacToe.goBack());

        if (gamemode == GameMode.AI) {
            imageView2.setImage(new Image(getClass().getResource("/assets/O.png").toExternalForm()));
            imageView3.setImage(new Image(getClass().getResource("/assets/X.png").toExternalForm()));
            btnRecord.setVisible(false);
        }

        whosTurn.setFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        whosTurn.setLayoutX(870.0);
        whosTurn.setLayoutY(188.0);
        whosTurn.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        whosTurn.setStrokeWidth(0.0);
        whosTurn.setText("");
        whosTurn.setFont(new Font("Comic Sans MS Bold", 60.0));
        getChildren().add(imageView);
        getChildren().add(imageView0);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getColumnConstraints().add(columnConstraints3);
        gridPane.getColumnConstraints().add(columnConstraints4);
        gridPane.getColumnConstraints().add(columnConstraints5);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getRowConstraints().add(rowConstraints3);
        gridPane.getRowConstraints().add(rowConstraints4);
        gridPane.getChildren().add(btn00);
        gridPane.getChildren().add(btn01);
        gridPane.getChildren().add(brn02);
        gridPane.getChildren().add(btn10);
        gridPane.getChildren().add(btn11);
        gridPane.getChildren().add(btn12);
        gridPane.getChildren().add(btn20);
        gridPane.getChildren().add(btn21);
        gridPane.getChildren().add(btn22);
        getChildren().add(gridPane);
        getChildren().add(imageView1);
        pane.getChildren().add(button);
        pane.getChildren().add(txtPlayer2);
        getChildren().add(pane);
        pane0.getChildren().add(button0);
        pane0.getChildren().add(txtPlayer1);
        getChildren().add(pane0);
        getChildren().add(button1);
        getChildren().add(scorePlayer1);
        getChildren().add(scorePlayer2);
        getChildren().add(btnRecord);
        getChildren().add(btnBack);
        getChildren().add(whosTurn);
        if (gamemode == GameMode.RECORD) {
            System.out.println("in record");
            selectRecordFileForReplay();
        }
         if (gamemode == GameMode.AI || gamemode == GameMode.TwoPlayers) {

            whosTurn.setText(Player1 + "'s Turn!");
        }
    }

    private void handleButtonClick(int row, int col, Button button) {
        btnRecord.setDisable(true);
        switch (gamemode) {
            case TwoPlayers:

                if (!game.isGameOver() && game.placeMark(row, col)) {
                    String mark = String.valueOf(game.getCurrentPlayerMark());

                    if (record.isRecording()) {
                        record.recordMove(mark, row, col);
                    }
                    btnImage = new ImageView(new Image(getClass().getResource("/assets/" + mark + ".png").toExternalForm()));
                    button.setGraphic(btnImage);
                    btnImage.setFitHeight(118.0);
                    btnImage.setFitWidth(96.0);
                    btnImage.setPickOnBounds(true);
                    btnImage.setPreserveRatio(true);
                    button.setDisable(true);
                    updateTurnDisplay();

                    if (game.isGameOver()) {
                        if (!game.isDraw()) {
                            game.incrementPlayerScore();
                            updateScoreDisplay();
                        }
                        highlightWinningCombination();
                        endOfGameAlert();
                    }

                }
                break;
            case AI:

                if (!game.isGameOver() && game.placeMark(row, col)) {
                    String mark = String.valueOf(game.getCurrentPlayerMark());
                    btnImage = new ImageView(new Image(getClass().getResource("/assets/" + mark + ".png").toExternalForm()));
                    button.setGraphic(btnImage);
                    btnImage.setFitHeight(118.0);
                    btnImage.setFitWidth(96.0);
                    btnImage.setPickOnBounds(true);
                    btnImage.setPreserveRatio(true);
                    button.setDisable(true);
                    disableAllButtons();
                    aiTurn = true;
                    updateTurnDisplay();

                    if (game.isGameOver()) {

                        endOfGame();
                    } else {
                        // Run AI in thread
                        new Thread(() -> {
                            try {
                                Thread.sleep(500);
                                Platform.runLater(() -> {
                                    game.aiMove();
                                    updateBoardUI();
                                    aiTurn = false;
                                    enableAllButtons();
                                    updateTurnDisplay();
                                    if (game.isGameOver()) {
                                        // b3ml check
                                        endOfGame();
                                    }
                                });
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }).start();
                    }
                }

        }
    }

    private void updateBoardUI() {
        Button[][] buttons = {
            {btn00, btn01, brn02},
            {btn10, btn11, btn12},
            {btn20, btn21, btn22}
        };

        char[][] boardState = game.getBoard();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char cell = boardState[row][col];
                Button button = buttons[row][col];
                if (cell == 'X') {
                    btnImage = new ImageView(new Image(getClass().getResource("/assets/X.png").toExternalForm()));
                    btnImage.setFitHeight(118.0);
                    btnImage.setFitWidth(96.0);
                    btnImage.setPickOnBounds(true);
                    btnImage.setPreserveRatio(true);
                    button.setDisable(true);
                    button.setGraphic(btnImage);
                } else if (cell == 'O') {
                    btnImage = new ImageView(new Image(getClass().getResource("/assets/O.png").toExternalForm()));
                    btnImage.setFitHeight(118.0);
                    btnImage.setFitWidth(96.0);
                    btnImage.setPickOnBounds(true);
                    btnImage.setPreserveRatio(true);
                    button.setDisable(true);
                    button.setGraphic(btnImage);
                } else {
                    button.setGraphic(null);
                }
            }
        }

    }

    private void disableAllButtons() {
        for (int i = 0; i < gridPane.getChildren().size(); i++) {
            Button button = (Button) gridPane.getChildren().get(i);
            button.setDisable(true);
        }

    }
       private void enableAllButtons() {
        for (int i = 0; i < gridPane.getChildren().size(); i++) {
            Button button = (Button) gridPane.getChildren().get(i);
            button.setDisable(false);
        }

    }


    private void endOfGameAlert() {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AlertVideoFXML.fxml"));
            Parent root = loader.load();
            Text headerTextView = (Text) loader.getNamespace().get("headerTextView");
            Button playAgainButton = (Button) loader.getNamespace().get("btnPlayAgain");
            Button backButton = (Button) loader.getNamespace().get("btnBack");
            MediaView winMediaView = (MediaView) loader.getNamespace().get("winMediaView");

            winMediaView.setLayoutX(350.0);
            winMediaView.setLayoutY(190.0);

            System.out.println(game.getWinner());
            String winnerText = game.isDraw() ? "It's a Draw!" : game.getWinner() + " wins!";
            whosTurn.setText(winnerText);
            headerTextView.setText(winnerText);

            if (!game.isDraw()) {
                File videoPath = new File("src/assets/videos/win.mp4");
                Media media = new Media(videoPath.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                winMediaView.setMediaPlayer(mediaPlayer);
                mediaPlayer.play();

            } else {
                File videoPath = new File("src/assets/videos/draw1.mp4");
                Media media = new Media(videoPath.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                winMediaView.setMediaPlayer(mediaPlayer);
                mediaPlayer.play();

            }

            playAgainButton.setOnAction(e -> {
                resetGame();
                stopMediaPlayer();
                ((Stage) root.getScene().getWindow()).close();
            });

            backButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    stopMediaPlayer();
                    Stage stage = (Stage) backButton.getScene().getWindow();
                    stage.close();

                }
            });

            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.initStyle(StageStyle.UNDECORATED);
            popupStage.setScene(new Scene(root, Color.TRANSPARENT));
            popupStage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void stopMediaPlayer() {

        if (mediaPlayer != null) {
            mediaPlayer.stop();

        }
    }

    private void resetGame() {
        game.resetGame();
        resetBoardUI();
        whosTurn.setText("");
    }

    private void resetBoardUI() {

        for (Node node : gridPane.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                button.setGraphic(null);
                button.setStyle("-fx-border-radius: 60;");
                button.getStyleClass().add("game-button");
                button.setDisable(false);
            }
        }
    }

    private void updateScoreDisplay() {
        scorePlayer1.setText(String.valueOf(game.getPlayer1Score()));
        scorePlayer2.setText(String.valueOf(game.getPlayer2Score()));
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void endOfGame() {
        if (!game.isDraw()) {
            game.incrementPlayerScore();
            updateScoreDisplay();
        }
        highlightWinningCombination();
        endOfGameAlert();

    }

    private void highlightWinningCombination() {
        List<int[]> winningCombination = game.getWinningCombination();
        for (int[] coordinate : winningCombination) {
            Button button = (Button) gridPane.getChildren().get(coordinate[0] * 3 + coordinate[1]);
            button.setStyle("-fx-background-color: #FF0000;");
        }
    }

    private void updateTurnDisplay() {
        if (!game.isGameOver() && !aiTurn) {
            char currentPlayer = game.getCurrentPlayerMark();
            String playerName = (currentPlayer == 'X') ? game.getPlayer1Name() : game.getPlayer2Name();
            whosTurn.setText(playerName + "'s Turn!");

        } else {
            String playerName = game.getPlayer2Name();
            whosTurn.setText(playerName + "'s Turn!");
        }
    }

    private List<String> readMovesFromFile(String fileName) {
        List<String> moves = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                moves.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return moves;
    }

    public void replayGame(String fileName) {
        String[] players = extractPlayerNamesFromFile(fileName);
        List<String> moves = readMovesFromFile(fileName);

        initializeBoardWithPlayers();
        new Thread(() -> {
            for (String move : moves) {
              

                Platform.runLater(() -> replayMove(move));
                try {
                    // Sleep for 1 second
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void replayMove(String move) {
     
        String[] parts = move.split("[, ]+"); 
        int row = Integer.parseInt(parts[3]);
        int col = Integer.parseInt(parts[5]);

        if (!game.isGameOver() && game.placeMark(row, col)) {
       
            updateBoardUI();
            if (game.isGameOver()) {

                highlightWinningCombination();
                String winnerText = game.isDraw() ? "It's a Draw!" : game.getWinner() + " wins!";
                whosTurn.setText(winnerText);
            }

        }

    }

    private void initializeBoardWithPlayers() {

        scorePlayer1.setVisible(false);
        scorePlayer2.setVisible(false);
        btnRecord.setVisible(false);

        resetGame(); 
    }

    public void selectRecordFileForReplay() {
        String directory = System.getProperty("user.dir") + "/src/screens/Record/";
        File selectedFile = new File(directory, RecordFXMLBase.fileName);

        System.out.println("Absolute path: " + selectedFile.getAbsolutePath());

        if (selectedFile != null) {
            replayGame(selectedFile.getAbsolutePath());
        }
    }

    private String[] extractPlayerNamesFromFile(String fileName) {
    
        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        return baseName.split("&");
    }

}
