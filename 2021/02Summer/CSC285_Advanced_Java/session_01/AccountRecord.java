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
	private String socialSecurityNumber;
	private double balance;
	private double gpa;
	private String title;
	private double transactionAmount;

	// no-argument constructor calls other constructor with
	// default values
	public AccountRecord() {
		this(0, "", "", "", "", 0.0, 0.0, "", 0.0); // default way of private variables.
	}

	// initialize a record
	public AccountRecord(int acct, String first, String last, String addr,
			String ss, double bal, double gpa, String title, double ta) {
		setAccount(acct);
		setFirstName(first);
		setLastName(last);
		setAddress(addr);
		setSocialSecurityNumber(ss);
		setBalance(bal);
		setGPA(gpa);
		setTitle(title);
		setTransactionAmount(ta);
		
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
	
	// set socialSecurityNumber
	public void setSocialSecurityNumber(String ss) {
		socialSecurityNumber = ss;
	}

	// get socialSecurityNumber
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	
	// set Balance
	public void setBalance(double balance) {
		this.balance = balance;
	}

	// get Balance
	public double getBalance() {
		return balance;
	}
	
	// set GPA
	public void setGPA(double GPA) {
		this.gpa = GPA;
	}

	// get GPA
	public double getGPA() {
		return gpa;
	}
	
	// set Title
	public void setTitle(String title) {
		this.title = title;
	}

	// get Title
	public String getTitle() {
		return title;
	}
	
	// set Transaction Amount
	public void setTransactionAmount(double ta) {
		transactionAmount = ta;
	}

	// get Transaction Amount
	public double getTransactionAmount() {
		return transactionAmount;
	}
	
} // end class AccountRecord









