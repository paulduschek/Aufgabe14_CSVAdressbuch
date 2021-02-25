/**
 * @author Paul Duschek
 * @version 1.0, 25.2.21
 */

package ControllerView;

import Model.Person;
import Model.Phonebook;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
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
    public static void show(Stage stage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("sample.fxml"));
            Parent root = fxmlLoader.load();

            stage.setTitle("Aufgabe 14 - Duschek");
            stage.setScene(new Scene(root, 591, 400));
            stage.show();
        } catch (IOException ex) {
            System.err.println("Something wrong with sample.fxml!");
            ex.printStackTrace(System.err);
        }
    }

    public void showPage(int i)
    {
        Person p = book.getPerson(i - 1);
        name.setText(p.getName());
        adress.setText(p.getAddr());
        phone.setText(p.getPhoneNR());
        pageNr.setText((i) + " / " + book.getSize());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        book = new Phonebook();
        p = 1;
        showPage(p);
    }

    public void previous()
    {
        if(p > 1)
        {
            p--;
            showPage(p);
        }
        else
        {
            p = book.getSize();
            showPage(p);
        }
    }

    public void next()
    {
        if(p < book.getSize())
        {
            p++;
            showPage(p);
        }
        else
        {
            p = 1;
            showPage(p);
        }
    }

    public void add()
    {
        book.addPage();
        p = book.getSize();
        showPage(p);
    }

    public void delete()
    {
        book.deletePage(p -1);
        p--;
        showPage(p);
    }

    public void save()
    {
        book.change(name.getText(), adress.getText(), phone.getText(), p-1);
    }

    public void loadCsv()
    {
        book.loadFromCsv();
        p = 1;
        showPage(p);
    }

    public void saveCsv()
    {
        book.saveToCsv();
    }
}
