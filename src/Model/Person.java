/**
 * @author Paul Duschek
 * @version 2.0, 25.2.21
 */

package Model;

public class Person {
    //variable defintions
    private String name;
    private String addr;
    private String phoneNR;

    //Constructor
    public Person()
    {
        setAddr("-");
        setName("-");
        setPhoneNR("-");
    }

    public Person(String n, String a, String pNR) {
        this.name = n;
        this.addr = a;
        this.phoneNR = pNR;
    }

    //methods
    @Override
    public String toString() {
        return name + "," + addr + "," + phoneNR;
    }

    //getter and setter
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setPhoneNR(String phoneNR) {
        this.phoneNR = phoneNR;
    }

    public String getPhoneNR() {
        return phoneNR;
    }
}
