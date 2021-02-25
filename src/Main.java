/**
 * @author Paul Duschek
 * @version 1.0, 25.2.21
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ControllerView/sample.fxml"));
        primaryStage.setTitle("Duschek - Aufgabe14 Adressbuch");
        primaryStage.setScene(new Scene(root, 591, 400));
        primaryStage.show();
    }
}

