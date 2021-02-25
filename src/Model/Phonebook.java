/**
 * @author Paul Duschek
 * @version 1.0, 25.2.21
 */

package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedList;

public class Phonebook {
    private LinkedList<Person> phbook = new LinkedList<Person>();

    public void saveToCsv()          //Method to save the file to phonebook.csv
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("phonebook.csv")))
        {
            for(int i = 0; i < phbook.size(); i++)
            {
                bw.write(phbook.get(i).toString());
                bw.newLine();
            }
            System.out.printf("File saved succesfully! %n");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    
}
