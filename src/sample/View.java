package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class View {

    // init class-variables
    static DecimalFormat df = new DecimalFormat("0.00");

    static double configTablePricingSBStart = 5.00, foodPriceFilterChoice = configTablePricingSBStart;
    static boolean cbProof = false;

    static Stage window= new Stage();

    public static void view() throws Exception {
        try {

            // *********************************************************************************************************
            // root
            window.setTitle("SWT-Projekt");

            BorderPane root = new BorderPane();

            // *********************************************************************************************************
            // top ----------------------------------------------
            // layout0
            HBox headBox0View = new HBox(1030);

            // title
            Label viewTitle = new Label("Mensaplan");
            viewTitle.setStyle("-fx-font-size: 20px;");
            viewTitle.setFocusTraversable(true);

            // login
            Button adminLogin = new Button("Login as Admin");

            adminLogin.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    // switch scene
                    try {
                        //window.close();
                        Login.login();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            // set Top
            headBox0View.getChildren().addAll(viewTitle, adminLogin);

            // separator
            Separator separatorLineHead = new Separator(Orientation.HORIZONTAL);

            // layout
            VBox headBoxView = new VBox(10);

            headBoxView.getChildren().addAll(headBox0View, separatorLineHead);
            root.setTop(headBoxView);

            // left ----------------------------------------------

            // center ----------------------------------------------
            // layout0
            VBox bodyBoxView = new VBox(20);
            HBox tableBox = new HBox();
            tableBox.setStyle("-fx-font-size: 18px;");

            // layout table
            GridPane gridTableTitleCol = new GridPane();
            gridTableTitleCol.setPadding(new Insets(10,0,10,0));
            gridTableTitleCol.setHgap(5);
            gridTableTitleCol.setVgap(10);

            gridTableTitleCol.addColumn(1, (new Label("Tag")), (new Label("Menüname")), (new Label("Menü\n\n")), (new Label("Preis")), (new Label("Art")));

            // monday
            GridPane gridTableMonday = new GridPane();
            gridTableMonday.setPadding(new Insets(10,0,10,0));
            gridTableMonday.setHgap(10);
            gridTableMonday.setVgap(10);
            gridTableMonday.setVisible(true);

            gridTableMonday.addColumn(2,
                    (new Label(Model.readFileGetWeekday(Model.file0))),
                    (new Label(Model.readFileGetMenuTitle(Model.file0))),
                    (new Label(Model.readFileGetMenuContent(Model.file0))),
                    (new Label(String.valueOf(df.format(Model.readFileGetMenuPrice(Model.file0))) + "€")),
                    (new Label(Model.readFileGetMenuFoodType(Model.file0))));


            // tuesday
            GridPane gridTableTuesday = new GridPane();
            gridTableTuesday.setPadding(new Insets(10,0,10,0));
            gridTableTuesday.setHgap(5);
            gridTableTuesday.setVgap(10);

            gridTableTuesday.addColumn(3,
                    (new Label(Model.readFileGetWeekday(Model.file1))),
                    (new Label(Model.readFileGetMenuTitle(Model.file1))),
                    (new Label(Model.readFileGetMenuContent(Model.file1))),
                    (new Label(String.valueOf(df.format(Model.readFileGetMenuPrice(Model.file1))) + "€")),
                    (new Label(Model.readFileGetMenuFoodType(Model.file1))));


            // wednesday
            GridPane gridTableWednesday = new GridPane();
            gridTableWednesday.setPadding(new Insets(10,0,10,0));
            gridTableWednesday.setHgap(5);
            gridTableWednesday.setVgap(10);

            gridTableWednesday.addColumn(4,
                    (new Label(Model.readFileGetWeekday(Model.file2))),
                    (new Label(Model.readFileGetMenuTitle(Model.file2))),
                    (new Label(Model.readFileGetMenuContent(Model.file2))),
                    (new Label(String.valueOf(df.format(Model.readFileGetMenuPrice(Model.file2))) + "€")),
                    (new Label(Model.readFileGetMenuFoodType(Model.file2))));


            // thursday
            GridPane gridTableThursday = new GridPane();
            gridTableThursday.setPadding(new Insets(10,0,10,0));
            gridTableThursday.setHgap(5);
            gridTableThursday.setVgap(10);

            gridTableThursday.addColumn(5,
                    (new Label(Model.readFileGetWeekday(Model.file3))),
                    (new Label(Model.readFileGetMenuTitle(Model.file3))),
                    (new Label(Model.readFileGetMenuContent(Model.file3))),
                    (new Label(String.valueOf(df.format(Model.readFileGetMenuPrice(Model.file3))) + "€")),
                    (new Label(Model.readFileGetMenuFoodType(Model.file3))));


            // friday
            GridPane gridTableFriday = new GridPane();
            gridTableFriday.setPadding(new Insets(10,0,10,0));
            gridTableFriday.setHgap(5);
            gridTableFriday.setVgap(10);

            gridTableFriday.addColumn(6,
                    (new Label(Model.readFileGetWeekday(Model.file4))),
                    (new Label(Model.readFileGetMenuTitle(Model.file4))),
                    (new Label(Model.readFileGetMenuContent(Model.file4))),
                    (new Label(String.valueOf(df.format(Model.readFileGetMenuPrice(Model.file4))) + "€")),
                    (new Label(Model.readFileGetMenuFoodType(Model.file4))));



            // configure price
            HBox configTablePricing = new HBox(30);
            Label configTablePricingText = new Label("Preise bis " + df.format(configTablePricingSBStart) + "€");

            ScrollBar configTablePricingSB = new ScrollBar();
            configTablePricingSB.setValue(configTablePricingSBStart);
            configTablePricingSB.setMin(1);
            configTablePricingSB.setMax(15);
            configTablePricingSB.setMinWidth(230);
            configTablePricingSB.setMaxWidth(350);
            configTablePricingSB.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    df.setRoundingMode(RoundingMode.UP);
                    foodPriceFilterChoice = (Double)newValue;
                    configTablePricingText.setText("Preise bis " + String.valueOf(df.format(newValue)) + "€");
                }
            });

            // configure type of food
            HBox configTableFoodType = new HBox(30);

            CheckBox cb0 = new CheckBox("Alles");
            cb0.setSelected(true);
            CheckBox cb1 = new CheckBox("Normal");
            CheckBox cb2 = new CheckBox("Vegetarisch");
            CheckBox cb3 = new CheckBox("Vegan");


            // submit configurations
            HBox submitConfigs = new HBox(30);

            Button submitConfigsButton = new Button("OK");
            Label submitConfigsLabel = new Label();

            submitConfigsButton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    String message = "Dein Filter: [  ";

                    message += df.format(foodPriceFilterChoice) + "€  ";

                    if (cb0.isSelected()) {
                        message += cb0.getText() + "  ";
                        cbProof = true;
                    }
                    if (cb1.isSelected()) {
                        message += cb1.getText() + "  ";
                        cbProof = true;
                    }
                    if (cb2.isSelected()) {
                        message += cb2.getText() + "  ";
                        cbProof = true;
                    }
                    if (cb3.isSelected()) {
                        message += cb3.getText() + "  ";
                        cbProof = true;
                    }

                    if (!(cb0.isSelected() | cb1.isSelected() | cb2.isSelected() | cb3.isSelected()))
                        cbProof = false;

                    message += "]";

                    if (cbProof == true) {
                        submitConfigsLabel.setText(message);

                        // filter monday
                        boolean mondayP=false, mondayFT=false;

                        if (Double.valueOf(Model.readFileGetMenuPrice(Model.file0)) <= foodPriceFilterChoice)
                            mondayP = true;
                        else
                            mondayP = false;

                        if (cb0.isSelected())
                            mondayFT = true;
                        if ((Model.readFileGetMenuFoodType(Model.file0)).equals(cb1.getText()) && cb1.isSelected())
                            mondayFT = true;
                        if ((Model.readFileGetMenuFoodType(Model.file0)).equals(cb2.getText()) && cb2.isSelected())
                            mondayFT = true;
                        if ((Model.readFileGetMenuFoodType(Model.file0)).equals(cb3.getText()) && cb3.isSelected())
                            mondayFT = true;

                        if ( mondayP && mondayFT )
                            gridTableMonday.setVisible(true);
                        else
                            gridTableMonday.setVisible(false);

                        // filter tuesday
                        boolean tuesdayP=false, tuesdayFT=false;

                        if (Double.valueOf(Model.readFileGetMenuPrice(Model.file1)) <= foodPriceFilterChoice)
                            tuesdayP = true;
                        else
                            tuesdayP = false;

                        if (cb0.isSelected())
                            tuesdayFT = true;
                        if ((Model.readFileGetMenuFoodType(Model.file1)).equals(cb1.getText()) && cb1.isSelected())
                            tuesdayFT = true;
                        if ((Model.readFileGetMenuFoodType(Model.file1)).equals(cb2.getText()) && cb2.isSelected())
                            tuesdayFT = true;
                        if ((Model.readFileGetMenuFoodType(Model.file1)).equals(cb3.getText()) && cb3.isSelected())
                            tuesdayFT = true;

                        if ( tuesdayP && tuesdayFT )
                            gridTableTuesday.setVisible(true);
                        else
                            gridTableTuesday.setVisible(false);


                        // filter wednesday
                        boolean wednesdayP=false, wednesdayFT=false;

                        if (Double.valueOf(Model.readFileGetMenuPrice(Model.file2)) <= foodPriceFilterChoice)
                            wednesdayP = true;
                        else
                            wednesdayP = false;

                        if (cb0.isSelected())
                            wednesdayFT = true;
                        if ((Model.readFileGetMenuFoodType(Model.file2)).equals(cb1.getText()) && cb1.isSelected())
                            wednesdayFT = true;
                        if ((Model.readFileGetMenuFoodType(Model.file2)).equals(cb2.getText()) && cb2.isSelected())
                            wednesdayFT = true;
                        if ((Model.readFileGetMenuFoodType(Model.file2)).equals(cb3.getText()) && cb3.isSelected())
                            wednesdayFT = true;

                        if ( wednesdayP && wednesdayFT )
                            gridTableWednesday.setVisible(true);
                        else
                            gridTableWednesday.setVisible(false);

                        // filter thursday
                        boolean thursdayP=false, thursdayFT=false;

                        if (Double.valueOf(Model.readFileGetMenuPrice(Model.file3)) <= foodPriceFilterChoice)
                            thursdayP = true;
                        else
                            thursdayP = false;

                        if (cb0.isSelected())
                            thursdayFT = true;
                        if ((Model.readFileGetMenuFoodType(Model.file3)).equals(cb1.getText()) && cb1.isSelected())
                            thursdayFT = true;
                        if ((Model.readFileGetMenuFoodType(Model.file3)).equals(cb2.getText()) && cb2.isSelected())
                            thursdayFT = true;
                        if ((Model.readFileGetMenuFoodType(Model.file3)).equals(cb3.getText()) && cb3.isSelected())
                            thursdayFT = true;

                        if ( thursdayP && thursdayFT )
                            gridTableThursday.setVisible(true);
                        else
                            gridTableThursday.setVisible(false);


                        // filter friday
                        boolean fridayP=false, fridayFT=false;

                        if (Double.valueOf(Model.readFileGetMenuPrice(Model.file4)) <= foodPriceFilterChoice)
                            fridayP = true;
                        else
                            fridayP = false;

                        if (cb0.isSelected())
                            fridayFT = true;
                        if ((Model.readFileGetMenuFoodType(Model.file4)).equals(cb1.getText()) && cb1.isSelected())
                            fridayFT = true;
                        if ((Model.readFileGetMenuFoodType(Model.file4)).equals(cb2.getText()) && cb2.isSelected())
                            fridayFT = true;
                        if ((Model.readFileGetMenuFoodType(Model.file4)).equals(cb3.getText()) && cb3.isSelected())
                            fridayFT = true;

                        if ( fridayP && fridayFT )
                            gridTableFriday.setVisible(true);
                        else
                            gridTableFriday.setVisible(false);

                    } else
                        submitConfigsLabel.setText("Bitte wähle etwas aus!");

                }});

            // set layout
            tableBox.getChildren().addAll(gridTableTitleCol, gridTableMonday, gridTableTuesday, gridTableWednesday, gridTableThursday, gridTableFriday);

            configTablePricing.getChildren().addAll(configTablePricingSB, configTablePricingText);

            configTableFoodType.getChildren().addAll(cb0, cb1, cb2, cb3);

            submitConfigs.getChildren().addAll(submitConfigsButton, submitConfigsLabel);

            bodyBoxView.getChildren().addAll(tableBox, configTablePricing, configTableFoodType, submitConfigs);

            root.setCenter(bodyBoxView);
            root.setMargin(bodyBoxView, new Insets(10, 10, 10, 10));

            // right ----------------------------------------------

            // bottom ----------------------------------------------
            // layout
            VBox footerBoxView = new VBox();

            // separator
            Separator separatorLineFooter = new Separator(Orientation.HORIZONTAL);

            // layout 2
            AnchorPane footerBox1View = new AnchorPane();

            // authors
            Label authors = new Label("von Jeremy Fuchs und Cedrick Candia Ferreira");
            AnchorPane.setRightAnchor(authors, 5.0);


            footerBox1View.getChildren().addAll(authors);
            footerBoxView.getChildren().addAll(separatorLineFooter,footerBox1View);
            root.setBottom(footerBoxView);


            // *********************************************************************************************************
            Scene sceneView = new Scene(root, 1300, 850);
            root.setStyle("-fx-padding: 5px;" + "-fx-spacing: 20px;");
            window.setScene(sceneView);
            window.show();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
