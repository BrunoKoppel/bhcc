
// Java core packages
import java.io.Serializable;

public class AccountRecord implements Serializable {
   private int account;
   private String firstName;
   private String lastName;
   private double balance;
   private double transaction;
   
   // no-argument constructor calls other constructor with
   // default values
   public AccountRecord() 
   {
      this( 0, "", "", 0.0, 0.0 );
   }
  
   // initialize a record
   public AccountRecord( int acct, String first,
      String last, double bal, double trans )
   {
      setAccount( acct );
      setFirstName( first );
      setLastName( last );
      setBalance( bal );
	  setTrans(trans);
   }

   // set account number   
   public void setAccount( int acct )
   {
      this.account = acct;
   }

   // get account number   
   public int getAccount() 
   { 
      return account; 
   }
   
   // set first name   
   public void setFirstName( String first )
   {
      firstName = first;
   }

   // get first name   
   public String getFirstName() 
   { 
      return firstName; 
   }
   
   // set last name   
   public void setLastName( String last )
   {
      lastName = last;
   }

   // get last name   
   public String getLastName() 
   {
      return lastName; 
   }
   
   // set balance  
   public void setBalance( double bal )
   {
      balance = bal;
   }

   // get balance   
   public double getBalance() 
   { 
      return balance; 
   }
   
   
   
   // set Transaction amount    
   public void setTrans( double trans )
   {
      transaction = trans;
   }

   // get Transaction amount  
   public double getTrans() 
   { 
      return transaction; 
   }
   
   

}  // end class AccountRecord

