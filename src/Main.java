/**
 * @author Paul Duschek
 * @version 2.0, 25.2.21
 */

import ControllerView.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller.show(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

