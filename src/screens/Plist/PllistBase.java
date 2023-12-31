package screens.Plist;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import helper.Helper;
import java.io.IOException;
import java.lang.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import screens.Plist.AlertMessage;
import models.JsonReceiveBase;
import models.JsonSendBase;
import models.JsonWrapper;
import screens.Board.BoardFXMLBase;
import screens.Board.GameMode;
import screens.login_screen.LoginScreenBase;
import models.ServerEventType;
import javafx.stage.WindowEvent;
import screens.mode.ModeScreenBase;
import tictactoe.TicTacToe;

public class PllistBase extends AnchorPane {

    protected final ImageView imgview;
    protected final Image imgViewP;
    protected final Button playlist;
    protected final HBox hbox;
    protected final Label name;
    protected final Label status;
    protected final Label profileName;
    protected final Circle profilePic;
    protected final Pane pane;
    protected final VBox vBox;
    protected final VBox vBoxx;
    protected ListView<Player> playerListView;
    private ObservableList<Player> observablePlayerList;
    protected final Button Backbtn;
    protected final Image imgCover;
    private JsonReceiveBase jsonReceiveBase;

    private JsonSendBase jsonSendBase;
    private static String userName;
    private String senderUserName;
    private String reciverUserName;
    private volatile boolean inviteResponseReceived = false;
    private volatile boolean inviteAccepted = false;
    private Stage st;
    private alertBase alert;

    public PllistBase(Stage stage, String username) {
        userName = username;
        jsonReceiveBase = new JsonReceiveBase();
        imgview = new ImageView();
        imgViewP = new Image("/assets/download.png");
        playlist = new Button();
        hbox = new HBox();
        name = new Label();
        status = new Label();
        profileName = new Label();
        profilePic = new Circle();
        pane = new Pane();
        vBox = new VBox(30);
        vBoxx = new VBox(30);
        playerListView = new ListView<>();
        Backbtn = new Button();
        imgCover = new Image("/assets/cov.jpg");
        alert = new alertBase();
        setId("AnchorPane");
        setPrefHeight(736.0);
        setPrefWidth(1413.0);
        // setStyle("-fx-background-color: #3C7CD7;");

        imgview.setFitHeight(1174.0);
        imgview.setFitWidth(2043.0);
        imgview.setLayoutX(-17.0);
        imgview.setLayoutY(-5.0);
        imgview.setPickOnBounds(true);
        imgview.setPreserveRatio(true);
        imgview.setImage(imgCover);

        playlist.setLayoutX(850);
        playlist.setLayoutY(18.0);
        playlist.setMnemonicParsing(false);
        playlist.setPrefHeight(75.0);
        playlist.setPrefWidth(260.0);
        playlist.setText("Available Players");
        playlist.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,yellow,10,0.3,-5,5); -fx-background-color: FFFF;");
        playlist.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        playlist.setFont(new Font("Comic Sans MS Bold", 26.0));

        hbox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hbox.setLayoutX(550.0);
        hbox.setLayoutY(155.0);
        hbox.setPrefHeight(49.0);
        hbox.setPrefWidth(848.0);
        hbox.setStyle("-fx-background-color: #4787EE; -fx-background-radius: 10;");

        name.setAlignment(javafx.geometry.Pos.CENTER);
        name.setPrefHeight(30.0);
        name.setPrefWidth(136.0);
        name.setText("Name");
        name.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        name.setFont(new Font("Comic Sans MS Bold", 40.0));

        status.setAlignment(javafx.geometry.Pos.CENTER);
        status.setLayoutX(10.0);
        status.setLayoutY(20.0);
        status.setPrefHeight(39.0);
        status.setPrefWidth(550.0);
        status.setText("Points");
        status.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        status.setFont(new Font("Comic Sans MS Bold", 40.0));

        profileName.setAlignment(javafx.geometry.Pos.CENTER);
        profileName.setLayoutX(1500);
        profileName.setLayoutY(195.0);
        profileName.setPrefHeight(39.0);
        profileName.setPrefWidth(550.0);
        profileName.setText(userName);
        profileName.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        profileName.setFont(new Font("Comic Sans MS Bold", 35.0));

        profilePic.setLayoutX(1788);
        profilePic.setLayoutY(118.0);
        profilePic.setFill(javafx.scene.paint.Color.DODGERBLUE);
        profilePic.setRadius(87.0);
        profilePic.setStroke(javafx.scene.paint.Color.BLACK);
        profilePic.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        profilePic.setFill(new ImagePattern(imgViewP));

        pane.setLayoutX(555.0);
        pane.setLayoutY(260.0);
        pane.setPrefHeight(490.0);
        pane.setPrefWidth(900.0);

        vBox.setPrefHeight(560.0);
        vBox.setPrefWidth(765.0);

        vBoxx.setPrefHeight(560.0);
        vBoxx.setPrefWidth(350.0);

        // Load the CSS file
        String css = getClass().getResource("Plist.css").toExternalForm();
        getStylesheets().add(css);
        playerListView.setCellFactory(param -> new PlayerListCell());
        playerListView.setStyle("-fx-control-inner-background: LIGHTSKYBLUE;");
        playerListView.setPrefHeight(500.0);
        playerListView.setPrefWidth(873.0);
        observablePlayerList = FXCollections.observableArrayList();
        playerListView.setItems(observablePlayerList);
        // playerListView.setBackground(imgList);
        // Add the current player's UI to the map

        Backbtn.setLayoutX(1710.0);
        Backbtn.setLayoutY(250.0);
        Backbtn.setMnemonicParsing(false);
        Backbtn.setStyle("-fx-background-radius: 25; -fx-background-color: FFFF; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        Backbtn.setText("Log out");
        Backbtn.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        Backbtn.setFont(new Font("Comic Sans MS Bold", 25.0));
        Backbtn.setOnAction((event) -> {
            new Thread(() -> {
                try {
                    Helper helper = new Helper();
                    LogOut logOut = getUserName();
                    Gson gson = new Gson();
                    String logg = gson.toJson(logOut);
                    helper.LogOutRequest(logg);
                    System.out.println("Logout req =" + logg);
                    Platform.runLater(() -> {
                        TicTacToe.goBack();
                        TicTacToe.goBack();
                    });
                } catch (IOException ex) {
                    Logger.getLogger(PllistBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }).start();

        });

        getChildren().add(imgview);
        getChildren().add(playlist);
        hbox.getChildren().add(name);
        hbox.getChildren().add(status);
        getChildren().add(hbox);
        pane.getChildren().add(playerListView);
        getChildren().add(pane);
        getChildren().add(Backbtn);
        getChildren().add(profileName);
        getChildren().add(profilePic);
        getActivePlayers();
        startListener();

        stage.setOnCloseRequest((WindowEvent event) -> {
            // Your code to handle the close event goes here
            new Thread(() -> {
                try {
                    Helper helper = new Helper();
                    LogOut logOut = getUserName();
                    Gson gson = new Gson();

                    String logg = gson.toJson(logOut);
                    helper.LogOutRequest(logg);
                    System.out.println("Logout req =" + logg);
                } catch (IOException ex) {
                    Logger.getLogger(PllistBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }).start();
        });

    }

    //Method to get Available players from Server
    private void getActivePlayers() {
        new Thread(() -> {
            Helper helper = new Helper();
            String response = null;
            Player newplayer = new Player();
            newplayer.setUserName(userName);
            Gson gson = new Gson();
            String jsonData = gson.toJson(newplayer);
            try {
                response = helper.ListRequest(jsonData);
                // System.out.println("Received response: Aya " + response);
                Type typee = new TypeToken<ArrayList<Player>>() {
                }.getType();
                ArrayList<Player> playerList = JsonWrapper.fromJson(response, typee);
                // To Remove the Player that login from the list
                playerList.removeIf(player -> player.getUserName().equals(userName));
                // Update the playerListView with the received list of players
                Platform.runLater(() -> {
                    // Clear the existing list and add the new players
                    observablePlayerList.clear();
                    observablePlayerList.addAll(playerList);

                });
            } catch (IOException ex) {
                Logger.getLogger(PllistBase.class.getName()).log(Level.SEVERE, null, ex);
            }

        }).start();
    }

    class PlayerListCell extends ListCell<Player> {

        @Override
        protected void updateItem(Player player, boolean empty) {
            super.updateItem(player, empty);

            if (empty || player == null) {
                setText(null);
                setGraphic(null);
            } else {

                Label nameLabel = new Label(player.getName());
                nameLabel.setTextFill(javafx.scene.paint.Color.WHITE);
                nameLabel.setFont(new Font("Bookman Old Style Bold", 25.0));
                nameLabel.setMinWidth(200);
                // nameLabel.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));
                Label pointsLabel = new Label("" + player.getPoints());
                pointsLabel.setTextFill(javafx.scene.paint.Color.WHITE);
                pointsLabel.setFont(new Font("Bookman Old Style Bold", 25.0));
                pointsLabel.setMinWidth(100);
                //  pointsLabel.setPadding(new Insets(0.0, 0.0, 0.0, 22.0));

                Button inviteButton = new Button("Invite");
                inviteButton.setMnemonicParsing(false);
                inviteButton.setMinWidth(90);
                inviteButton.setLayoutX(200);
                inviteButton.setPrefHeight(50.0);
                inviteButton.setPrefWidth(90.0);
                inviteButton.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: FFFF;");
                inviteButton.setText("Invite");
                inviteButton.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
                inviteButton.setFont(new Font("Bookman Old Style Bold", 20.0));
                // Set the UserData property of the inviteButton to store the associated Player
                // Set the UserData property of the inviteButton to store the associated Player
                inviteButton.setUserData(player);
                inviteButton.setOnAction(e -> invitePlayer((Player) inviteButton.getUserData()));
                HBox hbox = new HBox();
                hbox.getChildren().addAll(nameLabel, new Region(), pointsLabel, new Region(), inviteButton);
                HBox.setHgrow(new Region(), Priority.ALWAYS);   // to add flexible space
                hbox.setSpacing(10);
                HBox.setMargin(nameLabel, new Insets(0, 0, 0, 0));
                hbox.setSpacing(110); // Spacing between pointsLabel and inviteButton

                setGraphic(hbox);

                int index = getIndex();
                if (index % 2 == 0) {
                    // Even row
                    setStyle("-fx-background-color: #3c74ce;");
                } else {
                    // Odd row
                    setStyle("-fx-background-color: #4787EE;");
                }
            }
        }

    }

    private void invitePlayer(Player player) {

        // Retrieve the associated Player object from the item property
        String username = player.getName();
        //To send Username of the Player that i want to play with him
        sendInviteRequest(username);

        AlertMessage alertmsg = new AlertMessage();
        String waitText = "Waiting for Approval...";
        alertmsg.showAction(waitText);

        new Thread(() -> {
            boolean accepted = waitForInviteResponse();

            Platform.runLater(() -> {
                if (accepted) {
                    alertmsg.closeAlert();
                    BoardFXMLBase boardScreen = new BoardFXMLBase(st, senderUserName, reciverUserName, GameMode.Online, userName);
                    Scene boardScene = new Scene(boardScreen);
                    TicTacToe.changeScene(boardScene);
                } else {
                    alertmsg.closeAlert();

                }
            });
        }).start();
        alertmsg.toShowandWait();

    }

    private void sendInviteRequest(String username) {
        new Thread(() -> {
            Helper helper = new Helper();
            OnlineBoard game = new OnlineBoard(userName, username);
            Gson gson2 = new Gson();
            String jsonTwoUsers = gson2.toJson(game);

            System.out.println("Send to Server (Sender,Reciever)" + jsonTwoUsers);

            try {
                String Response = helper.InviteRequest(jsonTwoUsers);
            } catch (IOException ex) {
                Logger.getLogger(PllistBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }

    //to be Client ready for any response from server
    public void startListener() {
        new Thread(() -> {
            Helper helper = new Helper();
            while (true) {
                try {
                    System.out.println("Listening for server messages...");
                    String message = helper.ServerResponse();
                    if (message != null) {
                        System.out.println("Message received: " + message);
                        handleServerMessage(message);
                    }
                    try {
                        Thread.sleep(100);  // Short sleep to prevent tight looping
                    } catch (InterruptedException e) {
                        System.out.println("Listener thread interrupted");
                        break;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(PllistBase.class.getName()).log(Level.SEVERE, "IOException in listener thread", ex);

                } catch (Exception e) {
                    Logger.getLogger(PllistBase.class.getName()).log(Level.SEVERE, "Unexpected exception in listener thread", e);

                }
            }
        }).start();
    }

    private void handleServerMessage(String Message) {
        if (Message == null) {
            System.out.println("Received null message from server.");
            return;
        }
        try {
            if (Message.trim().startsWith("[")) {
                System.out.println("This ArrayList Response");
            } else {

                JsonReceiveBase receivedMessage = JsonWrapper.fromJson(Message, JsonReceiveBase.class);
                if (receivedMessage.getType().equals(ServerEventType.Invite.name())) {
                    // Handle the invite 
                    OnlineBoard online = JsonWrapper.fromJson(Message, OnlineBoard.class);;
                    senderUserName = online.getSenderUserName();
                    reciverUserName = online.getReceiverUserName();
                    if (reciverUserName.equals(userName)) {
                        Platform.runLater(() -> showInvitationPopup(senderUserName));
                    }
                    System.out.println("Receiver Player receive response from server");
                } else if (receivedMessage.getType().equals(ServerEventType.InviteResponse.name())) {
                    InviteResponse response = JsonWrapper.fromJson(Message, InviteResponse.class);
                    if (response.getSenderUserName().equals(userName) && response.getStatus() == 1) {
                        inviteResponseReceived = true;
                        inviteAccepted = true;
                    }
                } else if (receivedMessage.getType().equals(ServerEventType.Login.name())) {
                    getActivePlayers();
                } else if (receivedMessage.getType().equals(ServerEventType.Logout.name())) {
                    getActivePlayers();
                }
            }
        } catch (Exception e) {
            System.out.println("Error parsing server message: " + e.getMessage());
        }
    }

    private void showInvitationPopup(String senderUsername) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InvitepopUp.fxml"));
            Parent root = loader.load();
            Button accept = (Button) loader.getNamespace().get("acceptbtn");
            Button cancel = (Button) loader.getNamespace().get("cancelbtn");
            Text alertText = (Text) loader.getNamespace().get("textAlert");
            Text senderText = (Text) loader.getNamespace().get("sender");
            // String text = " has invited you to start a game";
            accept.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #2AAAFD;");
            accept.setTextFill(javafx.scene.paint.Color.valueOf("#ffff"));
            accept.setFont(new Font("System Bold Italic", 21.0));
            accept.setText("Accept");
            accept.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    System.out.println("Invitation Accepted");
                    acceptInvitation(senderUsername);
                    BoardFXMLBase boardScreen = new BoardFXMLBase(st, senderUsername, reciverUserName, GameMode.Online, userName);
                    Scene boardScene = new Scene(boardScreen);
                    TicTacToe.changeScene(boardScene);
                    Stage stage = (Stage) accept.getScene().getWindow();
                    stage.close();
                }
            });
            cancel.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #2AAAFD;");
            cancel.setTextFill(javafx.scene.paint.Color.valueOf("#ffff"));
            cancel.setFont(new Font("System Bold Italic", 21.0));
            cancel.setText("Cancel");
            cancel.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("Invitation Rejected");
                    rejectInvitation(senderUserName);
                    Stage stage = (Stage) cancel.getScene().getWindow();
                    stage.close();
                }
            });
            senderText.setText(senderUsername);
            alertText.setFont(new Font("Comic Sans MS Bold", 35.0));
            alertText.setText(" invited you to join.");
            senderText.setFont(new Font("Comic Sans MS Bold", 35.0));

            System.out.println("Running on JavaFX Application Thread.");
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.initStyle(StageStyle.UNDECORATED);
            popupStage.setScene(new Scene(root, Color.TRANSPARENT));
            popupStage.showAndWait();
            System.out.println("Custom popup closed.");

        } catch (IOException ex) {
            Logger.getLogger(PllistBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void acceptInvitation(String senderUserName) {
        // Send acceptance message to servers
        sendInviteResponse(senderUserName, true);
    }

    private void rejectInvitation(String senderUserName) {
        // Send acceptance message to server
        sendInviteResponse(senderUserName, false);
    }

    private void sendInviteResponse(String senderUserName, boolean accepted) {
        // Construct the response message
        InviteResponse response = new InviteResponse();
        response.setType(ServerEventType.InviteResponse.name());
        response.setSenderUserName(senderUserName);
        response.setReceiverUserName(reciverUserName); //the playe who response 
        response.setStatus(accepted ? 1 : 0); // 1 for accept, 0 for reject

        String jsonResponse = JsonWrapper.toJson(response);

        // Receive response of  Receiver from server
        try {
            Helper helper = new Helper();
            String Response = helper.InviteRequest(jsonResponse);
            InviteResponseRecive rec = JsonWrapper.fromJson(Response, InviteResponseRecive.class);

            if (rec.getType().equals(ServerEventType.InviteResponse.name())) {
                if (senderUserName.equals(userName)) {
                    if (rec.getStatus() == 1) {

                        System.out.println("Done " + reciverUserName + "Acepted your request");

                    } else {
                        AlertMessage alertRej = new AlertMessage();
                        alertRej.showAction("Sorry your Invitation rejected..");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Method to make Sender wait for response from receiver
    private boolean waitForInviteResponse() {
        while (!inviteResponseReceived) {
            try {
                Thread.sleep(100); // Sleep for a short period to avoid busy waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return inviteAccepted;
    }

    public static LogOut getUserName() {
        return new LogOut(userName);
    }

}
