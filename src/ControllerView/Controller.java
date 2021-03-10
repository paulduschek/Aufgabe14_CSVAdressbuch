/**
 * @author Paul Duschek
 * @version 1.0, 25.2.21
 */

package ControllerView;

import Model.Person;
import Model.Phonebook;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
        Person p = book.getPerson(i-1);
        try {
            name.setText(p.getName());
            adress.setText(p.getAddr());
            phone.setText(p.getPhoneNR());
            pageNr.setText((i) + " / " + book.getSize());
        }
        catch (Exception ex)
        {
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        book = new Phonebook();
        p = 1;
        showPage(p);

        phoneOnlyNumber();
    }

    public void phoneOnlyNumber()
    {
        phone.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    phone.setText(oldValue);
                    System.out.println("Please type in numbers, not letters.");
                }
            }
        });
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
        try {
            book.change(name.getText(), adress.getText(), phone.getText(), p - 1);
            System.out.println("Changes saved successfully.");
        }
        catch (Exception ex)
        {
            System.out.println("No data for saving available, try again please.");
        }
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
