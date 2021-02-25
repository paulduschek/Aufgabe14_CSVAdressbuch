/**
 * @author Paul Duschek
 * @version 1.0, 25.2.21
 */

package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

public class Phonebook {
    private List<Person> phbook = new LinkedList<>();

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

    public void loadFromCsv()
    {
        phbook.clear();

        try(BufferedReader br = new BufferedReader(new FileReader("phonebook.csv")))
        {
            String n = "";
            while ((n = br.readLine()) != null)
            {
                String a[] = n.split(",");

                phbook.add(new Person(a[0],a[1],a[2]));
            }
            System.out.printf("File loaded successfully! %n");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void change(String n, String a, String pNr, int i)
    {
        Person person = phbook.get(i);
        person.setName(n);
        person.setAddr(a);
        person.setPhoneNR(pNr);
    }

    public int getSize()
    {
        return phbook.size();
    }

    public Person getPerson(int i)
    {
        Person person = null;
        try
        {
            person = phbook.get(i);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return person;
    }

    public void addPage()
    {
        phbook.add(new Person());
    }

    public void deletePage(int i)
    {
        try
        {
            phbook.remove(i);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
