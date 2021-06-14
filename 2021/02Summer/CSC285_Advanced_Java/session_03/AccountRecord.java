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
	private double balance;
	

	// no-argument constructor calls other constructor with
	// default values
	public AccountRecord() {
		this(0, "", "", 0.0); // default way of private variables.
	}
	
	
	// initialize a record
	public AccountRecord(int acct, String first, String last, double bal)
	{
		setAccount(acct);
		setFirstName(first);
		setLastName(last);
		setBalance(bal);
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

	// set balance
	public void setBalance(double bal) {
		balance = bal;
	}

	// get balance
	public double getBalance() {
		return balance;
	}

	
} // end class AccountRecord
