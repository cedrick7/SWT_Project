package sample;

import com.sun.tools.javac.comp.Check;
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
import javafx.stage.Stage;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class View extends Application {

    // init class-variables
    private static DecimalFormat df = new DecimalFormat("0.00");

    double configTablePricingSBStart = 3.00, foodPriceFilterChoice = configTablePricingSBStart;
    boolean cbProof = false;


    String priceMonday = String.valueOf(Model.readFileGetMenuPrice(Model.file0));
    boolean priceMondayBool = false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            // *********************************************************************************************************
            // root
            BorderPane root = new BorderPane();

            // *********************************************************************************************************
            // top ----------------------------------------------
            // layout0
            HBox headBox0View = new HBox(1030);

            // title
            Label viewTitle = new Label("Dein Plan");
            viewTitle.setId("h1");
            viewTitle.setFocusTraversable(true);

            // login
            Button adminLogin = new Button("Login as Admin");

            // set Top
            headBox0View.getChildren().addAll(viewTitle, adminLogin);
            //AnchorPane.setTopAnchor(headBoxTopStart, 0.5);

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

            // layout table
            GridPane gridTable = new GridPane();
            gridTable.setPadding(new Insets(10,10,10,10));
            gridTable.setHgap(20);
            gridTable.setVgap(10);
            //gridTable.setGridLinesVisible(true);
            gridTable.setStyle(
                    "-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 5;" +
                    "-fx-border-radius: 5;" +
                    "-fx-border-color: blue;" +
                    "-fx-background-fill: black;" );

            //root.add(node, spalte, zeile)

            gridTable.add(new Label("x"), 0, 0);
            gridTable.add(new Label("x"), 0, 1);
            gridTable.add(new Label("x"), 0, 2);
            gridTable.add(new Label("x"), 0, 3);
            gridTable.add(new Label("x"), 0, 4);
            gridTable.add(new Label("x"), 0, 5);

/*
            gridTable.add(new Label("x"), 1, 1);
            gridTable.add(new Label("Menüname"), 1, 2);
            gridTable.add(new Label("Menü"), 1, 3);
            gridTable.add(new Label("Preis"), 1, 4);
            gridTable.add(new Label("Art"), 1, 5);
*/
            gridTable.addColumn(1, (new Label("x")), (new Label("Menüname")), (new Label("Menü")), (new Label("Preis")), (new Label("Art")));

/*
            // monday
            gridTable.add(new Label("x"), 2, 0);
            gridTable.add(new Label(Model.readFileGetWeekday(Model.file0)), 2, 1);
            gridTable.add(new Label(Model.readFileGetMenuTitle(Model.file0)), 2, 2);
            gridTable.add(new Label(Model.readFileGetMenuContent(Model.file0)), 2, 3);
            gridTable.add(new Label(String.valueOf(Model.readFileGetMenuPrice(Model.file0))), 2, 4);
            gridTable.add(new Label(Model.readFileGetMenuFoodType(Model.file0)), 2, 5);
   */
            gridTable.addColumn(2,
                    (new Label("x")),
                    (new Label(Model.readFileGetWeekday(Model.file0))),
                    (new Label(Model.readFileGetMenuTitle(Model.file0))),
                    (new Label(Model.readFileGetMenuContent(Model.file0))),
                    (new Label(priceMonday)),
                    (new Label(Model.readFileGetMenuFoodType(Model.file0))));


            // tuesday
            gridTable.add(new Label("x"), 3, 0);
            gridTable.add(new Label(Model.readFileGetWeekday(Model.file1)), 3, 1);
            gridTable.add(new Label(Model.readFileGetMenuTitle(Model.file1)), 3, 2);
            gridTable.add(new Label(Model.readFileGetMenuContent(Model.file1)), 3, 3);
            gridTable.add(new Label(String.valueOf(Model.readFileGetMenuPrice(Model.file1))), 3, 4);
            gridTable.add(new Label(Model.readFileGetMenuFoodType(Model.file1)), 3, 5);


            // wednesday
            gridTable.add(new Label("x"), 4, 0);
            gridTable.add(new Label(Model.readFileGetWeekday(Model.file2)), 4, 1);
            gridTable.add(new Label(Model.readFileGetMenuTitle(Model.file2)), 4, 2);
            gridTable.add(new Label(Model.readFileGetMenuContent(Model.file2)), 4, 3);
            gridTable.add(new Label(String.valueOf(Model.readFileGetMenuPrice(Model.file2))), 4, 4);
            gridTable.add(new Label(Model.readFileGetMenuFoodType(Model.file2)), 4, 5);


            // thursday
            gridTable.add(new Label("x"), 5, 0);
            gridTable.add(new Label(Model.readFileGetWeekday(Model.file3)), 5, 1);
            gridTable.add(new Label(Model.readFileGetMenuTitle(Model.file3)), 5, 2);
            gridTable.add(new Label(Model.readFileGetMenuContent(Model.file3)), 5, 3);
            gridTable.add(new Label(String.valueOf(Model.readFileGetMenuPrice(Model.file3))), 5, 4);
            gridTable.add(new Label(Model.readFileGetMenuFoodType(Model.file3)), 5, 5);


            // friday
            gridTable.add(new Label("x"), 6, 0);
            gridTable.add(new Label(Model.readFileGetWeekday(Model.file4)), 6, 1);
            gridTable.add(new Label(Model.readFileGetMenuTitle(Model.file4)), 6, 2);
            gridTable.add(new Label(Model.readFileGetMenuContent(Model.file4)), 6, 3);
            gridTable.add(new Label(String.valueOf(Model.readFileGetMenuPrice(Model.file4))), 6, 4);
            gridTable.add(new Label(Model.readFileGetMenuFoodType(Model.file4)), 6, 5);



            // configure price

            HBox configTablePricing = new HBox(30);
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

                    df.setRoundingMode(RoundingMode.UP);
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

                    if(!(cb0.isSelected() | cb1.isSelected() | cb2.isSelected() | cb3.isSelected()))
                        cbProof = false;

                    message += "]";

                    if(cbProof == true)
                        submitConfigsLabel.setText(message);
                    else
                        submitConfigsLabel.setText("Bitte wähle etwas aus!");

                    if( (Model.readFileGetMenuPrice(Model.file0)) > (foodPriceFilterChoice) )
                        priceMondayBool = true;
                }

            });

            // set layout

            configTablePricing.getChildren().addAll(configTablePricingSB, configTablePricingText);

            configTableFoodType.getChildren().addAll(cb0, cb1, cb2, cb3);

            submitConfigs.getChildren().addAll(submitConfigsButton, submitConfigsLabel);

            bodyBoxView.getChildren().addAll(gridTable, configTablePricing, configTableFoodType, submitConfigs);

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
            Label authors = new Label("von Jeremy und Cedrick");
            AnchorPane.setRightAnchor(authors, 5.0);


            footerBox1View.getChildren().addAll(authors);
            footerBoxView.getChildren().addAll(separatorLineFooter,footerBox1View);
            root.setBottom(footerBoxView);


            // *********************************************************************************************************
            //root.getChildren().addAll(headBox, bodyBox, footerBox);
            //root.setPadding(new Insets(10, 10, 10, 10));
            Scene sceneView = new Scene(root, 1300, 850);
            sceneView.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            primaryStage.setScene(sceneView);
            primaryStage.setTitle("SWT-Projekt");
            primaryStage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void filterTable() {

    }

    public static void main(String[] args) {
        launch(args);
    }
}