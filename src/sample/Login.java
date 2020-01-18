package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Login {

    // init class-variables

    public static void login() throws Exception {
        try {
            // *********************************************************************************************************
            // root
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            BorderPane root = new BorderPane();

            // *********************************************************************************************************
            // top ----------------------------------------------
            // layout0
            HBox headBox0Login = new HBox(310);

            // title
            Label startTitle = new Label("Login");
            //startTitle.setId("h1");
            startTitle.setStyle("-fx-font-size: 20px;");
            startTitle.setFocusTraversable(true);

            // set Top
            headBox0Login.getChildren().add(startTitle);
            //AnchorPane.setTopAnchor(headBoxTopStart, 0.5);

            // separator
            Separator separatorLineHead = new Separator(Orientation.HORIZONTAL);

            // layout
            VBox headBoxStart = new VBox(10);

            headBoxStart.getChildren().addAll(headBox0Login, separatorLineHead);
            root.setTop(headBoxStart);

            // left ----------------------------------------------

            // center ----------------------------------------------
            // layout
            VBox bodyBoxLogin = new VBox(10);

            // Username
            Label usernameLabel = new Label("Benutzername:");
            TextField usernameTextField = new TextField();
            usernameTextField.setMaxWidth(300);
            usernameTextField.setPromptText("Benutzernamen hier eingeben...");

            // Password
            Label passwordLabel = new Label("Passwort:");
            PasswordField passwordTextField = new PasswordField();
            passwordTextField.setMaxWidth(300);
            passwordTextField.setPromptText("Passwort hier eingeben...");

            // Submit
            Button loginButton = new Button("OK");

            // Failure info
            Label loginFailed = new Label();
            loginFailed.setTextFill(Color.RED);

            loginButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String username = usernameTextField.getText();
                    String password = passwordTextField.getText();

                    if(username.equals(""))
                        loginFailed.setText("Bitte Benutzernamen eingeben!");
                    else if(password.equals(""))
                        loginFailed.setText("Bitte Passwort eingeben!");
                    else if(username.equals("admin") && password.equals("admin123")) {
                        window.close();
                        // switch scene
                        try {
                            window.close();
                            Editor.editor();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else
                        loginFailed.setText("Falscher Benutzernamen oder falsches Passwort!");
                }

            });

            bodyBoxLogin.setPadding(new Insets(10, 10, 10, 10));

            bodyBoxLogin.getChildren().addAll(
                    usernameLabel, usernameTextField,
                    passwordLabel, passwordTextField,
                    loginButton, loginFailed );

            root.setCenter(bodyBoxLogin);

            // right ----------------------------------------------

            // bottom ----------------------------------------------
            // layout
            VBox footerBoxLogin = new VBox();

            // separator
            Separator separatorLineFooter = new Separator(Orientation.HORIZONTAL);

            // layout 2
            AnchorPane footerBox1Login = new AnchorPane();

            // authors
            Label authors = new Label("von Jeremy Fuchs und Cedrick Candia Ferreira");
            AnchorPane.setRightAnchor(authors, 5.0);


            footerBox1Login.getChildren().addAll(authors);
            footerBoxLogin.getChildren().addAll(separatorLineFooter,footerBox1Login);
            root.setBottom(footerBoxLogin);


            // *********************************************************************************************************
            Scene sceneLogin = new Scene(root, 500, 600);
            root.setStyle("-fx-padding: 5px;" + "-fx-spacing: 20px;");
            window.setScene(sceneLogin);
            window.showAndWait();


        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}