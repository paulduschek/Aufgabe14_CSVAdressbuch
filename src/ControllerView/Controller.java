/**
 * @author Paul Duschek
 * @version 1.0, 25.2.21
 */

package ControllerView;

import Model.Phonebook;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    //FXML implementations
    @FXML
    private TextField name;
    @FXML
    private TextField adress;
    @FXML
    private TextField phone;
    @FXML
    private Label pageNr;

    //variable definitions
    private Phonebook book;
    private int p;          //variable for pages later

    //methods
}
