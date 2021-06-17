//AccountRecord.java
// Java core packages
// @HW@
// add grade average point GPA
//

import java.io.Serializable;

public class AccountRecord implements Serializable { // if it is interface it
    // should be implements
    // (tagging interface);

    private static final long serialVersionUID = 3417040053089159204L;
    private int account;
    private String firstName;
    private String lastName;
    private String address;
    private int SocSec;
    private double balance;
    private double GPA;
    private String title;


    // no-argument constructor calls other constructor with
    // default values
    public AccountRecord() {
        this(0, "", "", "", 0, 0.0, 0.0, ""); // default way of private variables.
    }


    // initialize a record
    public AccountRecord(int acct, String first, String last, String addr,
                         int ssec, double bal, double newGpa, String titl) {
        setAccount(acct);
        setFirstName(first);
        setLastName(last);
        setAddress(addr);
        setSocSec(ssec);
        setBalance(bal);
        setGPA(newGpa);
        setTitle(titl);
    }


    // set account number
    public void setAccount(int account) {
        this.account = account;
    }

    // get account number
    public int getAccount() {
        return account;
    }

    // set first name
    public void setFirstName(String first) {
        firstName = first;
    }

    // get first name
    public String getFirstName() {
        return firstName;
    }

    // set last name
    public void setLastName(String last) {
        lastName = last;
    }

    // get last name
    public String getLastName() {
        return lastName;
    }

    // set address
    public void setAddress(String addr) {
        address = addr;
    }

    // get address
    public String getAddress() {
        return address;
    }

    // set SocSec
    public void setSocSec(int ssec) {
        SocSec = ssec;
    }

    // get SocSec
    public int getSocSec() {
        return SocSec;
    }

    // set balance
    public void setBalance(double bal) {
        balance = bal;
    }

    // get balance
    public double getBalance() {
        return balance;
    }

    // set GPA
    public void setGPA(double newGpa) {
        GPA = newGpa;
    }

    // get GPA
    public double getGPA() {
        return GPA;
    }

    // set Title
    public void setTitle(String titl) {
        title = titl;
    }

    // get Title
    public String getTitle() {
        return title;
    }
} // end class AccountRecord
