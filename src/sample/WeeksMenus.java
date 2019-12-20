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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class WeeksMenus extends Application {

    private static DecimalFormat df = new DecimalFormat("0.00");


    double foodPriceFilterChoice;
    double configTablePricingSBStart = 3.00;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            // *********************************************************************************************************
            // root
            BorderPane root = new BorderPane();

            // *********************************************************************************************************
            // top ----------------------------------------------
            // layout0
            HBox headBox0Start = new HBox(1030);

            // title
            Label startTitle = new Label("Dein Plan");
            startTitle.setId("h1");
            startTitle.setFocusTraversable(true);

            // login
            Button adminLogin = new Button("Login as Admin");

            // set Top
            headBox0Start.getChildren().addAll(startTitle, adminLogin);
            //AnchorPane.setTopAnchor(headBoxTopStart, 0.5);

            // separator
            Separator separatorLineHead = new Separator(Orientation.HORIZONTAL);

            // layout
            VBox headBoxStart = new VBox(10);

            headBoxStart.getChildren().addAll(headBox0Start, separatorLineHead);
            root.setTop(headBoxStart);

            // left ----------------------------------------------

            // center ----------------------------------------------
            // layout table
            GridPane gridTable = new GridPane();
            gridTable.setPadding(new Insets(10,10,10,10));
            gridTable.setHgap(10);
            gridTable.setVgap(10);
            gridTable.setGridLinesVisible(true);

            //root.add(node, spalte, zeile)

            gridTable.add(new Label("x"), 0, 0);
            gridTable.add(new Label("x"), 0, 1);
            gridTable.add(new Label("x"), 0, 2);
            gridTable.add(new Label("x"), 0, 3);
            gridTable.add(new Label("x"), 0, 4);
            gridTable.add(new Label("x"), 0, 5);


            gridTable.add(new Label("x"), 1, 1);
            gridTable.add(new Label("Menüname"), 1, 2);
            gridTable.add(new Label("Inhalt"), 1, 3);
            gridTable.add(new Label("Preis"), 1, 4);
            gridTable.add(new Label("Art"), 1, 5);


            // monday
            gridTable.add(new Label("x"), 2, 0);

            Label menu0Day = new Label("Montag");
            gridTable.add(menu0Day, 2, 1);

            Label menu0Title = new Label("nothing here");
            gridTable.add(menu0Title, 2, 2);

            Label menu0Content = new Label("nothing here");
            gridTable.add(menu0Content, 2, 3);

            Label menu0Pricing = new Label("nothing here");
            gridTable.add(menu0Pricing, 2, 4);

            Label menu0FoodType = new Label("nothing here");
            gridTable.add(menu0FoodType, 2, 5);


            // tuesday
            gridTable.add(new Label("x"), 3, 0);

            Label menu1Day = new Label("Dienstag");
            gridTable.add(menu1Day, 3, 1);

            Label menu1Title = new Label("nothing here");
            gridTable.add(menu1Title, 3, 2);

            Label menu1Content = new Label("nothing here");
            gridTable.add(menu1Content, 3, 3);

            Label menu1Pricing = new Label("nothing here");
            gridTable.add(menu1Pricing, 3, 4);

            Label menu1FoodType = new Label("nothing here");
            gridTable.add(menu1FoodType, 3, 5);


            // wednesday
            gridTable.add(new Label("x"), 4, 0);

            Label menu2Day = new Label("Mittwoch");
            gridTable.add(menu2Day, 4, 1);

            Label menu2Title = new Label("nothing here");
            gridTable.add(menu2Title, 4, 2);

            Label menu2Content = new Label("nothing here");
            gridTable.add(menu2Content, 4, 3);

            Label menu2Pricing = new Label("nothing here");
            gridTable.add(menu2Pricing, 4, 4);

            Label menu2FoodType = new Label("nothing here");
            gridTable.add(menu2FoodType, 4, 5);


            // thursday
            gridTable.add(new Label("x"), 5, 0);

            Label menu3Day = new Label("Donnerstag");
            gridTable.add(menu3Day, 5, 1);

            Label menu3Title = new Label("nothing here");
            gridTable.add(menu3Title, 5, 2);

            Label menu3Content = new Label("nothing here");
            gridTable.add(menu3Content, 5, 3);

            Label menu3Pricing = new Label("nothing here");
            gridTable.add(menu3Pricing, 5, 4);

            Label menu3FoodType = new Label("nothing here");
            gridTable.add(menu3FoodType, 5, 5);


            // friday
            gridTable.add(new Label("x"), 6, 0);

            Label menu4Day = new Label("Freitag");
            gridTable.add(menu4Day, 6, 1);

            Label menu4Title = new Label("nothing here");
            gridTable.add(menu4Title, 6, 2);

            Label menu4Content = new Label("nothing here");
            gridTable.add(menu4Content, 6, 3);

            Label menu4Pricing = new Label("nothing here");
            gridTable.add(menu4Pricing, 6, 4);

            Label menu4FoodType = new Label("nothing here");
            gridTable.add(menu4FoodType, 6, 5);



            //

            HBox configTablePricing = new HBox(10);
            Label configTablePricingText = new Label("Preise bis " + configTablePricingSBStart + "€");

            ScrollBar configTablePricingSB = new ScrollBar();
            configTablePricingSB.setValue(configTablePricingSBStart);
            configTablePricingSB.setMin(1);
            configTablePricingSB.setMax(30);
            configTablePricingSB.setMaxWidth(200);
            //configTablePricingSB = configTablePricingSBStart;
            configTablePricingSB.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    df.setRoundingMode(RoundingMode.UP);
                    foodPriceFilterChoice = (Double)newValue;
                    configTablePricingText.setText("Preise bis " + String.valueOf(df.format(newValue)) + "€");
                }
            });


            // layout 1
            VBox bodyBoxWeeksMenu = new VBox(10);
            bodyBoxWeeksMenu.getChildren().addAll(gridTable, configTablePricing);

            root.setCenter(bodyBoxWeeksMenu);
            root.setMargin(bodyBoxWeeksMenu, new Insets(10, 10, 10, 10));

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
            Scene sceneTable = new Scene(root, 1300, 850);
            sceneTable.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            primaryStage.setScene(sceneTable);
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