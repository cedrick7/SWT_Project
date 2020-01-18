package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.stage.Stage;

public class Start extends Application {

    // init class-variables
    static boolean assortmentRadioProof = false;
    static String assortmentRadioInfo;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // *********************************************************************************************************
            // root
            BorderPane root = new BorderPane();

            // *********************************************************************************************************
            // top ----------------------------------------------
            // layout0
            HBox headBox0Start = new HBox(310);

            // title
            Label startTitle = new Label("Dein Mensaplaner");
            startTitle.setId("h1");
            startTitle.setFocusTraversable(true);

            // login
            Button adminLogin = new Button("Login as Admin");

            // set Top
            headBox0Start.getChildren().addAll(startTitle, adminLogin);

            // separator
            Separator separatorLineHead = new Separator(Orientation.HORIZONTAL);

            // layout
            VBox headBoxStart = new VBox(10);

            headBoxStart.getChildren().addAll(headBox0Start, separatorLineHead);
            root.setTop(headBoxStart);

            // left ----------------------------------------------

            //Label spacing = new Label("a");
            //root.setLeft(spacing);

            // center ----------------------------------------------
            // layout
            VBox bodyBoxStart = new VBox(10);

            // title
            Label bodyTitle = new Label("Bitte wähle einen Plan aus");

            // assortment
            ToggleGroup assortmentTG = new ToggleGroup();

            RadioButton assortmentStandard = new RadioButton("Mensaplan - Heute");
            RadioButton assortmentConfigure = new RadioButton("Mensaplan - Woche");

            assortmentStandard.setToggleGroup(assortmentTG);
            assortmentConfigure.setToggleGroup(assortmentTG);

            // proof of quantity
            assortmentTG.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                @Override
                public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n) {
                    RadioButton assortmentSelected = (RadioButton) assortmentTG.getSelectedToggle();

                    if (assortmentSelected != null)
                        assortmentRadioProof = true;

                    // get info on console
                    if (assortmentSelected == assortmentStandard)
                        assortmentRadioInfo = "standard";
                    else if (assortmentSelected == assortmentConfigure)
                        assortmentRadioInfo = "configure";
                }
            });

            // Submit
            Button startSubmit = new Button("Bestätigen");

            // Failure info
            Label startSubmitFailed = new Label("");
            startSubmitFailed.setId("startSubmitFailedID");
            startSubmitFailed.setTextFill(Color.rgb(255, 24, 0));

            startSubmit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    if (assortmentRadioProof == false)
                        startSubmitFailed.setText("Bitte wähle etwas aus!");
                    else {
                        startSubmitFailed.setText("");

                        //Main.clearConsole();
                        System.out.println("choice: " + assortmentRadioInfo + "\n");

                        // switch scene
                    }
                }
            });

            bodyBoxStart.getChildren().addAll(
                    bodyTitle,
                    assortmentStandard, assortmentConfigure,
                    startSubmit, startSubmitFailed );
            root.setCenter(bodyBoxStart);
            root.setMargin(bodyBoxStart, new Insets(10, 10, 10, 10));

            // right ----------------------------------------------

            // bottom ----------------------------------------------
            // layout
            VBox footerBoxStart = new VBox();

            // separator
            Separator separatorLineFooter = new Separator(Orientation.HORIZONTAL);

            // layout 2
            AnchorPane footerBox1Start = new AnchorPane();

            // authors
            Label authors = new Label("von Jeremy und Cedrick");
            AnchorPane.setRightAnchor(authors, 5.0);


            footerBox1Start.getChildren().addAll(authors);
            footerBoxStart.getChildren().addAll(separatorLineFooter,footerBox1Start);
            root.setBottom(footerBoxStart);


            // *********************************************************************************************************
            //root.getChildren().addAll(headBox, bodyBox, footerBox);
            //root.setPadding(new Insets(10, 10, 10, 10));
            Scene sceneStart = new Scene(root, 600, 600);
            sceneStart.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            primaryStage.setScene(sceneStart);
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
