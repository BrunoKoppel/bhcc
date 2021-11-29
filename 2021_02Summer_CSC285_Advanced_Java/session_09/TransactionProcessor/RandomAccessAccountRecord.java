// RandomAccessAccountRecord.java
// Subclass of AccountRecord for random access file programs.


// Java core packages
import java.io.*;

public class RandomAccessAccountRecord extends AccountRecord {
  
   // no-argument constructor calls other constructor
   // with default values
   public RandomAccessAccountRecord()
   {
      this( 0, "", "", 0.0, 0.0 );
   }

   // initialize a RandomAccessAccountRecord
   public RandomAccessAccountRecord( int account, 
      String firstName, String lastName, double balance, double transaction )
   {
      super( account, firstName, lastName, balance, transaction );
   }

   // read a record from specified RandomAccessFile
   public void read( RandomAccessFile file ) throws IOException
   {
      setAccount( file.readInt() );
      setFirstName( padName( file ) );
      setLastName( padName( file ) );
      setBalance( file.readDouble() );
	  setTrans(file.readDouble());
   }

   // ensure that name is proper length
   private String padName( RandomAccessFile file )
      throws IOException
   {
      char name[] = new char[ 15 ], temp;

      for ( int count = 0; count < name.length; count++ ) {
         temp = file.readChar();
         name[ count ] = temp;
      }     
      
      return new String( name ).replace( '\0', ' ' );
   }

   // write a record to specified RandomAccessFile
   public void write( RandomAccessFile file ) throws IOException
   {
      file.writeInt( getAccount() );
      writeName( file, getFirstName() );
      writeName( file, getLastName() );
      file.writeDouble( getBalance() );
	  file.writeDouble(getTrans());
   }

   // write a name to file; maximum of 15 characters
   private void writeName( RandomAccessFile file, String name )
      throws IOException
   {
      StringBuffer buffer = null;

      if ( name != null ) 
         buffer = new StringBuffer( name );
      else 
         buffer = new StringBuffer( 15 );

      buffer.setLength( 15 );
      file.writeChars( buffer.toString() );
   }

   // NOTE: This method contains a hard coded value for the
   // size of a record of information.
   public static int size() 
   { 
      return 80; 
   }

}  // end class RandomAccessAccountRecord
