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
import javafx.stage.Stage;

public class Editor extends Application {

    // init class-variables
    boolean radioProof = false;
    static int weekdayCounter = 10;
    static String weekday, menuTitle, menuContent, foodType, menuPriceProof;
    static double menuPrice = 0.00;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // *********************************************************************************************************
            // root
            BorderPane root = new BorderPane();

            // *********************************************************************************************************
            // top ----------------------------------------------
            // layout0
            HBox headBox0Editor = new HBox(310);

            // title
            Label startTitle = new Label("Editor");
            startTitle.setId("h1");
            startTitle.setFocusTraversable(true);

            // login
            Button goToView = new Button("zum Mensaplan");

            goToView.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    // switch scene
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
            Label editorMenuDateLabel = new Label("menu-weekday:");
            //TextField dashboardMenuDateText = new TextField();
            //dashboardMenuDateText.setPromptText("enter menu-weekday here...");
            ChoiceBox<String> editorMenuDateCB = new ChoiceBox<>();
            editorMenuDateCB.getItems().addAll("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag");
            editorMenuDateCB.getSelectionModel().select(0);


            // Title
            Label editorMenuTitleLabel = new Label("menu-title:");
            TextField editorMenuTitleText = new TextField();
            editorMenuTitleText.setPromptText("enter menu-title here...");

            // Content
            Label editorMenuContentLabel = new Label("menu-content:");
            TextArea editorMenuContentText = new TextArea();
            editorMenuContentText.setPromptText("enter menu-content here...");
            editorMenuContentText.setWrapText(true);

            // Price
            Label editorMenuPriceLabel = new Label("menu-content:");
            TextField editorMenuPriceText = new TextField();
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

            RadioButton editorMenuSelectNormal = new RadioButton("normal");
            RadioButton editorMenuSelectVegetarian = new RadioButton("vegetarian");
            RadioButton editorMenuSelectVegan = new RadioButton("vegan");

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
                        foodType = "normal";
                    else if (rb == editorMenuSelectVegetarian)
                        foodType = "vegetarian";
                    else if (rb == editorMenuSelectVegan)
                        foodType = "vegan";
                }
            });

            // Submit
            Button editorButton = new Button("submit menu");

            // Failure info
            Label menuSetFailed = new Label();

            editorButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    weekdayCounter = editorMenuDateCB.getSelectionModel().getSelectedIndex();
                    weekday = editorMenuDateCB.getSelectionModel().getSelectedItem();
                    menuTitle = editorMenuTitleText.getText();
                    menuContent = editorMenuContentText.getText();

                    if (weekday.equals(""))
                        menuSetFailed.setText("pls enter menu-weekday!");
                    else if (menuTitle.equals(""))
                        menuSetFailed.setText("pls enter menu-title!");
                    else if (menuContent.equals(""))
                        menuSetFailed.setText("pls enter menu-content!");
                    else if (!menuPriceProof.matches("\\d{0,2}([\\.]\\d{0,2})?"))
                        menuSetFailed.setText("pls use correct price naming");
                    else if (radioProof == false)
                        menuSetFailed.setText("pls click radio!");
                    else {
                        menuSetFailed.setText("menu safed!");

                        Model.initAL();

                        System.out.println(
                                "counter: " + weekdayCounter + "\n" +
                                        "menu-weekday: " + weekday + "\n" +
                                        "menu-title: " + menuTitle + "\n" +
                                        "menu-content: " + menuContent + "\n" +
                                        "menu-price: " + menuPrice + "\n" +
                                        "food-type: " + foodType + "\n"
                        );

                        // save object to model.class
                        Model.changeMenu(weekdayCounter, new Menu(weekdayCounter, weekday, menuTitle, menuContent, menuPrice, foodType));





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
            Label authors = new Label("von Jeremy und Cedrick");
            AnchorPane.setRightAnchor(authors, 5.0);


            footerBox1Editor.getChildren().addAll(authors);
            footerBoxEditor.getChildren().addAll(separatorLineFooter, footerBox1Editor);
            root.setBottom(footerBoxEditor);


            // *********************************************************************************************************
            //root.getChildren().addAll(headBox, bodyBox, footerBox);
            //root.setPadding(new Insets(10, 10, 10, 10));
            Scene sceneEditor = new Scene(root, 600, 600);
            sceneEditor.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            primaryStage.setScene(sceneEditor);
            primaryStage.setTitle("SWT-Projekt");
            primaryStage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}