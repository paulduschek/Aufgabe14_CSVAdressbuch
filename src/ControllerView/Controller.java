/**
 * @author Paul Duschek
 * @version 1.0, 25.2.21
 */

package ControllerView;

import Model.Person;
import Model.Phonebook;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

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
    public void displayPage(int index)
    {
        Person p = book.getPerson(index - 1);
        
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        book = new Phonebook();
        p = 1;
    }
}
