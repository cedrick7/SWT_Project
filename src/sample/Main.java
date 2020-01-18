package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        root.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(new Scene(root, 0, 0));
        primaryStage.show();
        primaryStage.close();
        View.view();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
