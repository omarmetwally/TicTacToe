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
import models.JsonReceiveBase;
import models.JsonSendBase;
import models.JsonWrapper;
import screens.Board.BoardFXMLBase;
import screens.Board.GameMode;
import screens.login_screen.LoginScreenBase;
import screens.login_screen.ServerEventType;
import tictactoe.TicTacToe;

public class PllistBase extends AnchorPane {

    protected final ImageView imgview;
    protected final Button playlist;
    protected final HBox hbox;
    protected final Label name;
    protected final Label status;
    protected final Pane pane;
    protected final VBox vBox;
    protected ListView<Player> playerListView;
    private ObservableList<Player> observablePlayerList;
    protected final Button Backbtn;
    protected final Image imgCover;
    private JsonReceiveBase jsonReceiveBase;
    private JsonSendBase jsonSendBase;
    private String userName;
    private String senderUserName;
    private String reciverUserName;
    private Stage st;
    private volatile boolean inviteResponseReceived = false;
    private volatile boolean inviteAccepted = false;

    public PllistBase(Stage stage, String username) {
        st = stage;
        userName = username;
        jsonReceiveBase = new JsonReceiveBase();
        imgview = new ImageView();
        playlist = new Button();
        hbox = new HBox();
        name = new Label();
        status = new Label();
        pane = new Pane();
        vBox = new VBox(30);
        playerListView = new ListView<>();
        Backbtn = new Button();
        imgCover = new Image("/assets/cover.png");

        setId("AnchorPane");
        setPrefHeight(736.0);
        setPrefWidth(1413.0);

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
        hbox.setPrefWidth(826.0);

        name.setAlignment(javafx.geometry.Pos.CENTER);
        name.setPrefHeight(30.0);
        name.setPrefWidth(130.0);
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

        pane.setLayoutX(555.0);
        pane.setLayoutY(260.0);
        pane.setPrefHeight(490.0);
        pane.setPrefWidth(900.0);

        vBox.setPrefHeight(560.0);
        vBox.setPrefWidth(765.0);

        // Load the CSS file
        playerListView.setCellFactory(param -> new PlayerListCell());
        playerListView.setStyle("-fx-control-inner-background: LIGHTSKYBLUE;");
        playerListView.setPrefHeight(500.0);
        playerListView.setPrefWidth(873.0);
        observablePlayerList = FXCollections.observableArrayList();
        playerListView.setItems(observablePlayerList);
        // playerListView.setBackground(imgList);

        // Update the observable list with the received list of players
        Backbtn.setLayoutX(31.0);
        Backbtn.setLayoutY(20.0);
        Backbtn.setMnemonicParsing(false);
        Backbtn.setStyle("-fx-background-radius: 25; -fx-background-color: FFFF; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        Backbtn.setText("Back");
        Backbtn.setTextFill(javafx.scene.paint.Color.valueOf("#fcd015"));
        Backbtn.setFont(new Font("Comic Sans MS Bold", 25.0));
        Backbtn.setOnAction(event -> TicTacToe.goBack());

        getChildren().add(imgview);
        getChildren().add(playlist);
        hbox.getChildren().add(name);
        hbox.getChildren().add(status);
        getChildren().add(hbox);
        pane.getChildren().add(playerListView);
        getChildren().add(pane);
        getChildren().add(Backbtn);

        getActivePlayers(stage);
        startServerListener();

    }

    //Method to get Available players from Server
    private void getActivePlayers(Stage stage) {
        new Thread(() -> {

            Helper helper = new Helper();
            String response = null;
            Player newplayer = new Player();
            newplayer.setUserName(userName);
            Gson gson = new Gson();
            String jsonData = gson.toJson(newplayer);
            try {
                response = helper.ListRequest(jsonData);
                System.out.println("Received response: Aya " + response);

                //Proccess the response from the server
                //JsonReceiveBase jsonReceiveBase = JsonWrapper.fromJson(response, JsonReceiveBase.class);
                // Check the status in the JsonReceiveBase object
                Type typee = new TypeToken<ArrayList<Player>>() {
                }.getType();
                ArrayList<Player> playerList = JsonWrapper.fromJson(response, typee);

                // Update the playerListView with the received list of players
                Platform.runLater(() -> {
                    // Clear the existing list and add the new players
                    observablePlayerList.clear();
                    observablePlayerList.addAll(playerList);
                });

//                    int status = jsonReceiveBase.getStatus();
//                    String type = jsonReceiveBase.getType();
//                    String message = jsonReceiveBase.getMessge();
//                    if (status == 1 && ServerEventType.AvailPlayers.name().equals(type)){
//                         
//                    Type typee = new TypeToken<ArrayList<Player>>() {}.getType();                   
//                    ArrayList<Player> playerList = JsonWrapper.fromJson(response, typee);
//                     
//                     // Update the playerListView with the received list of players
//                        Platform.runLater(() -> playerListView.getItems().setAll(playerList));
//                    }else {
//                        System.out.println("Invalid response from the server.");
//                    }  
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

                /*   Circle circle= new Circle();
            circle.setFill(javafx.scene.paint.Color.DODGERBLUE);
            circle.setRadius(30.0);
            circle.setStroke(javafx.scene.paint.Color.BLACK);
            circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
            circle.setFill(new ImagePattern(player.getImage()));   */
                Label nameLabel = new Label(player.getName());
                nameLabel.setTextFill(javafx.scene.paint.Color.WHITE);
                nameLabel.setFont(new Font("Bookman Old Style Bold", 25.0));
                // nameLabel.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));
                Label pointsLabel = new Label("" + player.getPoints());
                pointsLabel.setTextFill(javafx.scene.paint.Color.WHITE);
                pointsLabel.setFont(new Font("Bookman Old Style Bold", 25.0));
                //  pointsLabel.setPadding(new Insets(0.0, 0.0, 0.0, 22.0));

                Button inviteButton = new Button("Invite");
                inviteButton.setMnemonicParsing(false);

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
                HBox.setHgrow(new Region(), Priority.ALWAYS);   //to add felxiable space 
                hbox.setSpacing(10);   //Space between image and name
                HBox.setMargin(nameLabel, new Insets(0, 0, 0, 0)); // Right and left margin for pointsLabel
                hbox.setSpacing(120); // Spacing between pointsLabel and inviteButton   
                setGraphic(hbox);
            }
        }

    }

    private void invitePlayer(Player player) {

        // Retrieve the associated Player object from the item property
        String username = player.getName();
        //To send Username of the Player that i want to play with him
        sendInviteRequest(username);
        try {
            // Load the second FXML file for the invitation dialog
            FXMLLoader loader = new FXMLLoader(getClass().getResource("alert.fxml"));
            Parent root = loader.load();
            Button cancel = (Button) loader.getNamespace().get("cnacelbtn");
            cancel.setStyle("-fx-background-radius: 35; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #2AAAFD;");
            cancel.setTextFill(javafx.scene.paint.Color.valueOf("#ffff"));
            cancel.setFont(new Font("System Bold Italic", 25.0));
            cancel.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Stage stage = (Stage) cancel.getScene().getWindow();
                    stage.close();
                }
            });

            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.initStyle(StageStyle.UNDECORATED);
            popupStage.setScene(new Scene(root, Color.TRANSPARENT));

            new Thread(() -> {
                boolean accepted = waitForInviteResponse();

                Platform.runLater(() -> {
                    if (accepted) {
                        popupStage.close();
                        BoardFXMLBase boardScreen = new BoardFXMLBase(st, senderUserName, reciverUserName, GameMode.TwoPlayers);
                        Scene boardScene = new Scene(boardScreen);
                        TicTacToe.changeScene(boardScene);
                    } else {
                        // Handle rejection case
                    }
                });
            }).start();
            popupStage.showAndWait();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendInviteRequest(String username) {
        new Thread(() -> {

            System.out.println("in sendInviteRequest" + userName);
            Helper helper = new Helper();
            OnlineBoard game = new OnlineBoard(userName, username);
            Gson gson2 = new Gson();
            String jsonTwoUsers = gson2.toJson(game);
            System.out.println("UserName of the Player that need to invite him " + jsonTwoUsers);

            try {
                String Response = helper.InviteRequest(jsonTwoUsers);

                //handle Response from Server
            } catch (IOException ex) {
                Logger.getLogger(PllistBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }


    public void startServerListener() {
        new Thread(() -> {
            Helper helper = new Helper();
            while (true) {
                try {
                    System.out.println("Listening for server messages...");
                    String message = helper.readMessage();
                    if (message != null) {
                        System.out.println("Message received: " + message);
                        handleServerMessage(message);
                    }
                    try {
                        Thread.sleep(100);  // Short sleep to prevent tight looping
                    } catch (InterruptedException e) {
                        System.out.println("Listener thread interrupted");
                        break;  // Exit loop if interrupted
                    }
                } catch (IOException ex) {
                    Logger.getLogger(PllistBase.class.getName()).log(Level.SEVERE, "IOException in listener thread", ex);
                    // Decide if you want to break the loop here

                } catch (Exception e) {
                    Logger.getLogger(PllistBase.class.getName()).log(Level.SEVERE, "Unexpected exception in listener thread", e);
                    // Decide if you want to break the loop here

                }
            }
            System.out.println("Listener thread exiting");
        }).start();
    }

    private void handleServerMessage(String message) {
        if (message == null) {
            System.out.println("Received null message from server.");
            return;
        }

        try {

            if (message.trim().startsWith("[")) {
                System.out.println("nothing"); //3lshan request Aya bta3 el array
            } // If not an array, process as JsonReceiveBase (Login, Register, Invite)
            else {

                JsonReceiveBase receivedMessage = JsonWrapper.fromJson(message, JsonReceiveBase.class);
                if (receivedMessage.getType().equals(ServerEventType.Invite.name())) {
                    // Handle the invite 
                    OnlineBoard on = JsonWrapper.fromJson(message, OnlineBoard.class);;
                    senderUserName = on.getSenderUserName();
                    reciverUserName = on.getReceiverUserName();
                    if (on.getReceiverUserName().equals(userName)) {
                        Platform.runLater(() -> showInviteDialog(on.getSenderUserName()));
                    }
                } else if (receivedMessage.getType().equals(ServerEventType.InviteResponse.name())) {
                    System.out.println("bs Baraa" + " b3at LLLLL");

                    InviteResponse response = JsonWrapper.fromJson(message, InviteResponse.class);
                    if (response.getSenderUserName().equals(userName) && response.getStatus() == 1) {
                        System.out.println("enta" + response.getSenderUserName() + " b3at L" + response.getReceiverUserName());
                        inviteResponseReceived = true;
                        inviteAccepted = true; // Assuming 1 means accepted
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("Error parsing server message: " + e.getMessage());
        }
    }

    private void showInviteDialog(String invitingPlayer) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Game Invitation");
        alert.setHeaderText("You have received an invitation!");

        ButtonType buttonAccept = new ButtonType("Accept", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonReject = new ButtonType("Reject", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonAccept, buttonReject);

        Label label = new Label("Would you like to accept the game invitation from" + invitingPlayer + " ?");
        alert.getDialogPane().setContent(label);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonAccept) {
            System.out.println("Invitation Accepted");
            acceptInvite(senderUserName);
            BoardFXMLBase boardScreen = new BoardFXMLBase(st, senderUserName, reciverUserName, GameMode.TwoPlayers);
            Scene boardScene = new Scene(boardScreen);
            TicTacToe.changeScene(boardScene);

        } else {
            System.out.println("Invitation Rejected");
            rejectInvite(senderUserName);
        }
    }

    private void acceptInvite(String invitingPlayer) {
        // Send acceptance message to server
        sendInviteResponse(invitingPlayer, true);
    }

    private void rejectInvite(String invitingPlayer) {
        // Send rejection message to server
        sendInviteResponse(invitingPlayer, false);
    }

    private void sendInviteResponse(String invitingPlayer, boolean accepted) {
        // Construct the response message
        InviteResponse response = new InviteResponse();
        response.setType(ServerEventType.InviteResponse.name());
        response.setSenderUserName(invitingPlayer); // The player who sent the invite
        response.setReceiverUserName(reciverUserName);
        response.setStatus(accepted ? 1 : 0); // 1 for accept, 0 for reject

        String jsonResponse = JsonWrapper.toJson(response);

        // Send the response to the server
        try {
            Helper helper = new Helper();
            String Response = helper.InviteRequest(jsonResponse);
            InviteResponseRecive rec = JsonWrapper.fromJson(Response, InviteResponseRecive.class);

            if (rec.getType().equals(ServerEventType.InviteResponse.name())) {
                if (rec.getStatus() == 1) {
                   
                     System.out.println("Done " + reciverUserName + "Acepted your request");
                  
                } else {
                    System.out.println("Sorry " + reciverUserName + "Rejected your request");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            // Handle IOException
        }
    }

    private boolean waitForInviteResponse() {
        while (!inviteResponseReceived) {
            try {
                System.out.println("gwa wait");
                Thread.sleep(100); // Sleep for a short period to avoid busy waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
                // Handle the interruption appropriately
            }
        }
        System.out.println("bara waitttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
        return inviteAccepted;
    }

}
