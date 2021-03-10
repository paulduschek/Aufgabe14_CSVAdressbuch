/**
 * @author Paul Duschek
 * @version 2.0, 25.2.21
 */

package ControllerView;

import Model.Person;
import Model.Phonebook;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
    Phonebook book;
    private int p;          //variable for pages later
    public static Controller c;

    //methods
    public static void show(Stage stage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("sample.fxml"));
            Parent root = fxmlLoader.load();

            stage.setTitle("Aufgabe 15 - Duschek");
            stage.setScene(new Scene(root, 591, 400));
            stage.show();
            c = fxmlLoader.getController();
            c.stageClose(stage);
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
        loadCsv();

        //phoneOnlyNumbers();           didnt work out properly for my implementation
    }

    public void phoneOnlyNumbers()
    {
        phone.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    phone.setText(oldValue);
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
            if(phone.getText().contains("+") && name.getText().contains(" ") && adress.getText().contains(" ")) {       //first and second name, street and house number required
                book.change(name.getText(), adress.getText(), phone.getText(), p - 1);
                System.out.println("Changes saved successfully.");
            }
            else
            {
                System.out.println("Type in valid data.");
            }
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

    public void stageClose(Stage s)
    {
        s.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                save();
                saveCsv();
                s.close();
            }
        });
    }
}
