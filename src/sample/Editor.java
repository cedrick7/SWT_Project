package sample;

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

public class Editor {

    // init class-variables
    static boolean radioProof = false;
    static int weekdayCounter = 10;
    static String weekday, menuTitle, menuContent, foodType, menuPriceProof;
    static double menuPrice = 0.00;

    public static void editor() throws Exception {
        try {
            // *********************************************************************************************************
            // root
            Stage window = new Stage();
            BorderPane root = new BorderPane();

            // *********************************************************************************************************
            // top ----------------------------------------------
            // layout0
            HBox headBox0Editor = new HBox(310);

            // title
            Label startTitle = new Label("Editor");
            //startTitle.setId("h1");
            startTitle.setStyle("-fx-font-size: 20px;");
            startTitle.setFocusTraversable(true);

            // login
            Button goToView = new Button("zum Mensaplan");

            goToView.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    // switch scene
                    try {
                        View.window.close();
                        window.close();
                        View.view();
                        //Application.launch(View.class, args);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            // set Top
            headBox0Editor.getChildren().addAll(startTitle, goToView);
            //AnchorPane.setTopAnchor(headBoxTopStart, 0.5);

            // separator
            Separator separatorLineHead = new Separator(Orientation.HORIZONTAL);

            // layout
            VBox headBoxEditor = new VBox(10);

            headBoxEditor.getChildren().addAll(headBox0Editor, separatorLineHead);
            root.setTop(headBoxEditor);

            // left ----------------------------------------------

            // center ----------------------------------------------
            // layout
            VBox bodyBoxEditor = new VBox(10);


            // Date
            Label editorMenuDateLabel = new Label("Wochentag:");
            //TextField dashboardMenuDateText = new TextField();
            //dashboardMenuDateText.setPromptText("enter menu-weekday here...");
            ChoiceBox<String> editorMenuDateCB = new ChoiceBox<>();
            editorMenuDateCB.getItems().addAll("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag");
            editorMenuDateCB.getSelectionModel().select(0);


            // Title
            Label editorMenuTitleLabel = new Label("Überschrift:");
            TextField editorMenuTitleText = new TextField();
            editorMenuTitleText.setMaxWidth(300);
            editorMenuTitleText.setPromptText("Tagesmenü KW...");

            // Content
            Label editorMenuContentLabel = new Label("Menu-Inhalt:");
            TextArea editorMenuContentText = new TextArea();
            editorMenuContentText.setMaxWidth(350);
            editorMenuContentText.setPromptText("Menu-Inhalt hier eingeben...");
            editorMenuContentText.setWrapText(true);

            // Price
            Label editorMenuPriceLabel = new Label("Preis:");
            TextField editorMenuPriceText = new TextField();
            editorMenuPriceText.setMaxWidth(300);
            editorMenuPriceText.setPromptText("3.50");
            //price proof
            editorMenuPriceText.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    menuPriceProof = newValue;
                    if (!newValue.matches("\\d{0,2}([\\.]\\d{0,2})?"))
                        menuPrice = Double.parseDouble(oldValue);
                    else
                        menuPrice = Double.parseDouble(newValue);
                }
            });

            // Type of food
            ToggleGroup tg = new ToggleGroup();

            RadioButton editorMenuSelectNormal = new RadioButton("Normal");
            RadioButton editorMenuSelectVegetarian = new RadioButton("Vegetarisch");
            RadioButton editorMenuSelectVegan = new RadioButton("Vegan");

            editorMenuSelectNormal.setToggleGroup(tg);
            editorMenuSelectVegetarian.setToggleGroup(tg);
            editorMenuSelectVegan.setToggleGroup(tg);

            // proof of quantity
            tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                @Override
                public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n) {
                    RadioButton rb = (RadioButton) tg.getSelectedToggle();

                    if (rb != null)
                        radioProof = true;

                    if (rb == editorMenuSelectNormal)
                        foodType = "Normal";
                    else if (rb == editorMenuSelectVegetarian)
                        foodType = "Vegetarisch";
                    else if (rb == editorMenuSelectVegan)
                        foodType = "Vegan";
                }
            });

            // Submit
            Button editorButton = new Button("OK");

            // Failure info
            Label menuSetFailed = new Label();
            menuSetFailed.setTextFill(Color.RED);

            editorButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    weekdayCounter = editorMenuDateCB.getSelectionModel().getSelectedIndex();
                    weekday = editorMenuDateCB.getSelectionModel().getSelectedItem();
                    menuTitle = editorMenuTitleText.getText();
                    menuContent = editorMenuContentText.getText();

                    if (weekday.equals(""))
                        menuSetFailed.setText("Bitte Wochentag eingeben!");
                    else if (menuTitle.equals(""))
                        menuSetFailed.setText("Bitte Überschrift eingeben!");
                    else if (menuContent.equals(""))
                        menuSetFailed.setText("Bitte Menu-Inhalt eingeben!");
                    else if (!menuPriceProof.matches("\\d{0,2}([\\.]\\d{0,2})?"))
                        menuSetFailed.setText("Bitte Preis in richtiger Form eingeben (z.B.: 3.00)!");
                    else if (radioProof == false)
                        menuSetFailed.setText("Bitte triff eine Auswahl!");
                    else {
                        menuSetFailed.setText("Menu gespeichert!");

                        //Model.initAL();

                        System.out.println(
                                "counter: " + weekdayCounter + "\n" +
                                        "menu-weekday: " + weekday + "\n" +
                                        "menu-title: " + menuTitle + "\n" +
                                        "menu-content: " + menuContent + "\n" +
                                        "menu-price: " + menuPrice + "\n" +
                                        "food-type: " + foodType + "\n"
                        );

                        // save object to model.class
                        if(weekdayCounter == 0) {
                            Model.deleteFile(Model.file0);
                            Model.createFile(Model.file0);
                            Model.writeFile(Model.file0, weekdayCounter, weekday, menuTitle, menuContent, menuPrice, foodType);
                        } else if(weekdayCounter == 1) {
                            Model.deleteFile(Model.file1);
                            Model.createFile(Model.file1);
                            Model.writeFile(Model.file1, weekdayCounter, weekday, menuTitle, menuContent, menuPrice, foodType);
                        } else if(weekdayCounter == 2) {
                            Model.deleteFile(Model.file2);
                            Model.createFile(Model.file2);
                            Model.writeFile(Model.file2, weekdayCounter, weekday, menuTitle, menuContent, menuPrice, foodType);
                        } else if(weekdayCounter == 3) {
                            Model.deleteFile(Model.file3);
                            Model.createFile(Model.file3);
                            Model.writeFile(Model.file3, weekdayCounter, weekday, menuTitle, menuContent, menuPrice, foodType);
                        } else if(weekdayCounter == 4) {
                            Model.deleteFile(Model.file4);
                            Model.createFile(Model.file4);
                            Model.writeFile(Model.file4, weekdayCounter, weekday, menuTitle, menuContent, menuPrice, foodType);
                        } else {
                            System.err.println("Da ist wohl was schiefgelaufen mit dem counter...");
                        }

                    }
                }
            });
            bodyBoxEditor.setPadding(new Insets(10, 10, 10, 10));

            bodyBoxEditor.getChildren().addAll(
                    editorMenuDateLabel, editorMenuDateCB,
                    editorMenuTitleLabel, editorMenuTitleText,
                    editorMenuContentLabel, editorMenuContentText,
                    editorMenuPriceLabel, editorMenuPriceText,
                    editorMenuSelectNormal, editorMenuSelectVegetarian, editorMenuSelectVegan,
                    editorButton, menuSetFailed);

            root.setCenter(bodyBoxEditor);


            // right ----------------------------------------------

            // bottom ----------------------------------------------
            // layout
            VBox footerBoxEditor = new VBox();

            // separator
            Separator separatorLineFooter = new Separator(Orientation.HORIZONTAL);

            // layout 2
            AnchorPane footerBox1Editor = new AnchorPane();

            // authors
            Label authors = new Label("von Jeremy Fuchs und Cedrick Candia Ferreira");
            AnchorPane.setRightAnchor(authors, 5.0);


            footerBox1Editor.getChildren().addAll(authors);
            footerBoxEditor.getChildren().addAll(separatorLineFooter, footerBox1Editor);
            root.setBottom(footerBoxEditor);


            // *********************************************************************************************************
            Scene sceneEditor = new Scene(root, 500, 600);
            root.setStyle("-fx-padding: 5px;" + "-fx-spacing: 20px;");
            window.setScene(sceneEditor);
            window.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}