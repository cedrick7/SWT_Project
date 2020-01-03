package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Login extends Application {

    // init class-variables

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // *********************************************************************************************************
            // root
            BorderPane root = new BorderPane();

            // *********************************************************************************************************
            // top ----------------------------------------------
            // layout0
            HBox headBox0Login = new HBox(310);

            // title
            Label startTitle = new Label("Login");
            startTitle.setId("h1");
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
            Label usernameLabel = new Label("username:");
            TextField usernameTextField = new TextField();
            usernameTextField.setMaxWidth(300);
            usernameTextField.setPromptText("enter username here...");
            //Label usernameFailed = new Label("pls enter username!");
            //usernameFailed.setVisible(false);

            // Password
            Label passwordLabel = new Label("password:");
            PasswordField passwordTextField = new PasswordField();
            passwordTextField.setMaxWidth(300);
            passwordTextField.setPromptText("enter password here...");
            //Label passwordFailed = new Label("pls enter password!");
            //passwordFailed.setVisible(false);

            // Submit
            Button loginButton = new Button("login...");

            // Failure info
            Label loginFailed = new Label();
            loginFailed.setTextFill(Color.RED);

            loginButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String username = usernameTextField.getText();
                    String password = passwordTextField.getText();

                    if(username.equals(""))
                        loginFailed.setText("pls enter username!");
                    else if(password.equals(""))
                        loginFailed.setText("pls enter password!");
                    else if(username.equals("admin") && password.equals("admin123")) {
                        primaryStage.close();
                        // switch scene
                    }
                    else
                        loginFailed.setText("incorrect username or password!");
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
            Label authors = new Label("von Jeremy und Cedrick");
            AnchorPane.setRightAnchor(authors, 5.0);


            footerBox1Login.getChildren().addAll(authors);
            footerBoxLogin.getChildren().addAll(separatorLineFooter,footerBox1Login);
            root.setBottom(footerBoxLogin);


            // *********************************************************************************************************
            //root.getChildren().addAll(headBox, bodyBox, footerBox);
            //root.setPadding(new Insets(10, 10, 10, 10));
            Scene sceneLogin = new Scene(root, 500, 600);
            sceneLogin.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            primaryStage.setScene(sceneLogin);
            primaryStage.setTitle("SWT-Projekt");
            primaryStage.show();


        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}