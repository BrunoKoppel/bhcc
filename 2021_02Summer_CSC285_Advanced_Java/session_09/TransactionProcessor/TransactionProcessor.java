
// This program reads a random-access file sequentially,
// updates records already written to the file, creates new
// records to be placed in the file and deletes data
// already in the file.

// Java core packages
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import java.awt.Dimension;
import java.util.*;
// Java extension packages
import javax.swing.*;

class MenuActionListener implements ActionListener {
  public void actionPerformed(ActionEvent actionEvent) {
    System.out.println("Selected: " + actionEvent.getActionCommand());
  }
}


public class TransactionProcessor extends JFrame {   
   private UpdateDialog updateDialog;
   private NewDialog newDialog;
   private DeleteDialog deleteDialog;
   private CreateRandomFile createFile;
   private JMenuItem createItem, newItem, updateItem, deleteItem, 
      openItem, exitItem;
   private JDesktopPane desktop;
   private RandomAccessFile file;  
   private RandomAccessAccountRecord record;  
   
   // set up GUI
   public TransactionProcessor()
   {
      super( "Transaction Processor" );

	  
	  ActionListener menuListener = new MenuActionListener();
      // set up desktop, menu bar and File menu
      desktop = new JDesktopPane();
      getContentPane().add( desktop );
 
      JMenuBar menuBar = new JMenuBar();
      setJMenuBar( menuBar );

      JMenu fileMenu = new JMenu( "File" );
	  fileMenu.setMnemonic(KeyEvent.VK_F);
      menuBar.add( fileMenu );
     
	  
	  // set up for creating file 
      createItem = new JMenuItem( "Create File", KeyEvent.VK_C );
	  createItem.addActionListener(menuListener);
      	  
	  // display create file dialog when user selects create
      createItem.addActionListener( 

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
                CreateRandomFile application = new CreateRandomFile();
				application.createFile();
				
				createItem.setEnabled(false);
            }
         }
      );

      // set up menu item for adding a record
      newItem = new JMenuItem( "New Record", KeyEvent.VK_N );
	  newItem.addActionListener(menuListener);
      newItem.setEnabled( false );
      // display new record dialog when user selects New Record
      newItem.addActionListener( 

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               newDialog.setVisible( true );              
            }
         }
      );

      // set up menu item for updating a record
      updateItem = new JMenuItem( "Update Record", KeyEvent.VK_U );
	  updateItem.addActionListener(menuListener);
      updateItem.setEnabled( false );


      // display update dialog when user selects Update Record
      updateItem.addActionListener( 

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               updateDialog.setVisible( true ); 
            }
         }
      );
      
      // set up menu item for deleting a record
      deleteItem = new JMenuItem( "Delete Record", KeyEvent.VK_D );
	  deleteItem.addActionListener(menuListener);
      deleteItem.setEnabled( false );

      // display delete dialog when user selects Delete Record
      deleteItem.addActionListener( 

         new ActionListener() {            

            public void actionPerformed( ActionEvent event )
            {
               deleteDialog.setVisible( true );              
            }
         }
      );

      // set up button for opening file
      openItem = new JMenuItem( "New/Open File", KeyEvent.VK_O );
	  openItem.addActionListener(menuListener);


      // enable user to select file to open, then set up 
      // dialog boxes
      openItem.addActionListener( 

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               boolean opened = openFile();

               if ( !opened )
                  return;

               openItem.setEnabled( false );

               // set up internal frames for record processing
               updateDialog = new UpdateDialog( file );
               desktop.add( updateDialog );
               
               deleteDialog = new DeleteDialog( file );  
               desktop.add ( deleteDialog );
               
               newDialog = new NewDialog( file );
               desktop.add( newDialog );
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      // set up menu item for exiting program
      exitItem = new JMenuItem( "Exit", KeyEvent.VK_X );
	  exitItem.addActionListener(menuListener);
      exitItem.setEnabled( true );

      // teminate application
      exitItem.addActionListener( 

         new ActionListener() {            

            public void actionPerformed( ActionEvent event )
            {
               closeFile();              
            }
         }
      );

      // attach menu items to File menu
	  fileMenu.add( createItem );
      fileMenu.add( openItem );
      fileMenu.add( newItem );
      fileMenu.add( updateItem );
      fileMenu.add( deleteItem );
      fileMenu.addSeparator();
      fileMenu.add( exitItem );

      // configure window
      setDefaultCloseOperation( 
         WindowConstants.EXIT_ON_CLOSE );
		 
		 // Get the size of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (((screenSize.width - this.getWidth()) / 2) / 2); 
		int y = (((screenSize.height - this.getHeight()) / 2) / 2);
		this.setLocation(x, y);
		// Set font style
		Font myFont = new Font("Franklin", Font.BOLD, 14);
		fileMenu.setFont(myFont);
		//produce the frame and show its
        setSize( 400, 250  );
        setVisible( true );

   }  // end TransactionProcessor constructor

   // enable user to select file to open
   private boolean openFile()
   {
      // display dialog so user can select file
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setFileSelectionMode(
         JFileChooser.FILES_ONLY );

      int result = fileChooser.showOpenDialog( this );

      // if user clicked Cancel button on dialog, return
      if ( result == JFileChooser.CANCEL_OPTION )
         return false;

      // obtain selected file
      File fileName = fileChooser.getSelectedFile();

      // display error if file name invalid
      if ( fileName == null ||
           fileName.getName().equals( "" ) ) {
         JOptionPane.showMessageDialog( this,
            "Invalid File Name", "Invalid File Name",
            JOptionPane.ERROR_MESSAGE );

         return false;
      }

      else {

         // open file
         try {
            file = new RandomAccessFile( fileName, "rw" );
            openItem.setEnabled( false );
            newItem.setEnabled( true );
            updateItem.setEnabled( true );
            deleteItem.setEnabled( true );
         }
  
         // process problems opening file
         catch ( IOException ioException ) {
            JOptionPane.showMessageDialog( this,
               "File does not exist", "Invalid File Name",
               JOptionPane.ERROR_MESSAGE );

            return false;
         }      
      }

      return true;  // file opened
   }

   // close file and terminate application
   private void closeFile() 
   {
      // close file and exit
      try {
         if ( file != null )
            file.close();

         System.exit( 0 );
      }

      // process exceptions closing file
      catch( IOException ioException ) {
         JOptionPane.showMessageDialog( this,
            "Error closing file",
            "Error", JOptionPane.ERROR_MESSAGE );
         System.exit( 1 );
      }
   }
  
   // execute application
   public static void main( String args[] )
   { 
		
	  IntroProcess start = new IntroProcess();
	  int x = start.IntroProcess();
	  if ( x > 0 )
	  {
	    new TransactionProcessor();
	  }
	  else
		System.exit( 0 );
   }

}  // end class TransactionProcessor

// class for udpating records
class UpdateDialog extends JInternalFrame {
   private RandomAccessFile file;  
   private InvestmentUI userInterface;

   // set up GUI
   public UpdateDialog( RandomAccessFile updateFile )
   {
      super( "Update Record" );

      file = updateFile;

      // set up GUI components
      userInterface = new InvestmentUI( 5 );
      getContentPane().add( userInterface,
         BorderLayout.CENTER );
		 
		JTextField accountField = 
         userInterface.getFields()[ InvestmentUI.ACCOUNT ];
		 
	final JTextField transactionField = 
         userInterface.getFields()[ InvestmentUI.TRANSACTION ];	 
		
      // set up Save Changes button and register listener
      final JButton saveButton = userInterface.getDoTask1Button();
      saveButton.setText( "Save Changes" );
	   
	   saveButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
					addRecord( getRecord() );					
					setVisible( false );
					userInterface.clearFields();
			} // keyPressed
        }/*KeyAdapter*/);

      saveButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               addRecord( getRecord() );                 
               setVisible( false );	
			   userInterface.clearFields();			   
            }
         }      
      );

      // set up Cancel button and register listener
      JButton cancelButton = userInterface.getDoTask2Button();
      cancelButton.setText( "Cancel" );
	   cancelButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    setVisible( false );
					userInterface.clearFields();
            } // keyPressed
        }/*KeyAdapter*/);

      cancelButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               setVisible( false );
               userInterface.clearFields();     
            }
         }
      );
  
      // set up listener for transaction textfield
      transactionField.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // add transaction amount to balance
               try {
                  RandomAccessAccountRecord record = getRecord();

				      // get textfield values from userInterface
                  String fieldValues[] = 
                     userInterface.getFieldValues();

                  // get transaction amount
                  double change = Double.parseDouble( 
                     fieldValues[ InvestmentUI.TRANSACTION ] );

                  // specify Strings to display in GUI
                  String[] values = {
                     String.valueOf( record.getAccount() ),
                     record.getFirstName(),
                     record.getLastName(),
                     String.valueOf( record.getBalance()
                        + change ), 
                     "0" };

                  // display Strings in GUI
                  userInterface.setFieldValues( values );
				  saveButton.requestFocus();
               }  

               // process invalid number in transaction field
               catch ( NumberFormatException numberFormat ) {
                  JOptionPane.showMessageDialog( null,
                     "Invalid Transaction",
                     "Invalid Number Format",
                     JOptionPane.ERROR_MESSAGE );
               }

            }  // end method actionPerformed

         }  // end anonymous inner class

      ); // end call to addActionListener

      // set up listener for account text field
      accountField.addActionListener(

         new ActionListener() {

            // get record and display contents in GUI
            public void actionPerformed( ActionEvent event )
            {
               RandomAccessAccountRecord record = getRecord();

               if ( record.getAccount() != 0 )  {
                  String values[] = {
                     String.valueOf( record.getAccount() ),
                     record.getFirstName(),
                     record.getLastName(),
                     String.valueOf( record.getBalance() ),
                     "Charge(+) or payment (-)" };

                  userInterface.setFieldValues( values );
				  transactionField.requestFocus();
				  transactionField.selectAll();	//selects all text for easy editing when you start typing!!!!	
               }       

            }  // end method actionPerformed

         }  // end anonymous inner class
         
      ); // end call to addActionListener

      setSize( 300, 175 );	  
      setVisible( false );
	  accountField.requestFocus();	  
   }

   // get record from file
   private RandomAccessAccountRecord getRecord() 
   {
      RandomAccessAccountRecord record = 
         new RandomAccessAccountRecord();

      // get record from file
      try {
         JTextField accountField =  
            userInterface.getFields()[ InvestmentUI.ACCOUNT ];

         int accountNumber = 
            Integer.parseInt( accountField.getText() );

         if ( accountNumber < 1 || accountNumber > 100 ) {
            JOptionPane.showMessageDialog( this,
               "Account Does Not Exist",
               "Error", JOptionPane.ERROR_MESSAGE );
			   accountField.requestFocus();
		       accountField.selectAll();
            return record;
         }

         // seek to appropriate record location in file
         file.seek( ( accountNumber - 1 ) * 
            RandomAccessAccountRecord.size() );
         record.read( file );
      
         if ( record.getAccount() == 0 ){
            JOptionPane.showMessageDialog( this,
               "Account Does Not Exist",
               "Error", JOptionPane.ERROR_MESSAGE );
		       accountField.requestFocus();
		       accountField.selectAll();}
      }

      // process invalid account number format
      catch ( NumberFormatException numberFormat ) {
         JOptionPane.showMessageDialog( this,
            "Invalid Account", "Invalid Number Format",
            JOptionPane.ERROR_MESSAGE );
      }
 
      // process file processing problems
      catch ( IOException ioException ) {
         JOptionPane.showMessageDialog( this,
            "Error Reading File",
            "Error", JOptionPane.ERROR_MESSAGE );
      }

      return record;

   }  // end method getRecord

   // add record to file
   public void addRecord( RandomAccessAccountRecord record )
   {
      // update record in file
      try {
         int accountNumber = record.getAccount();

         file.seek( ( accountNumber - 1 ) * 
            RandomAccessAccountRecord.size() ); 

         String[] values = userInterface.getFieldValues();   

         // set firstName, lastName and balance in record
        record.setFirstName( values[ InvestmentUI.FIRSTNAME ] );
        record.setLastName( values[ InvestmentUI.LASTNAME ] );
        record.setBalance( Double.parseDouble( values[ InvestmentUI.BALANCE ]  ) );
		record.setTrans(Double.parseDouble(values [InvestmentUI.TRANSACTION] ) );
         
         // rewrite record to file
         record.write( file );
      }

      // process file processing problems
      catch ( IOException ioException ) {
         JOptionPane.showMessageDialog( this,
            "Error Writing To File",
            "Error", JOptionPane.ERROR_MESSAGE );
      }

      // process invalid balance value
      catch ( NumberFormatException numberFormat ) {
         JOptionPane.showMessageDialog( this,
         "Bad Balance", "Invalid Number Format",
         JOptionPane.ERROR_MESSAGE );
      }

   }  // end method addRecord

}  // end class UpdateDialog

// class for creating new records
class NewDialog extends JInternalFrame {
   private RandomAccessFile file;  
   private InvestmentUI userInterface;

   // set up GUI
   public NewDialog( RandomAccessFile newFile )
   {
      super( "New Record" );

      file = newFile;

      // attach user interface to dialog
      userInterface = new InvestmentUI( 5 );
      getContentPane().add( userInterface,
         BorderLayout.CENTER );

      // set up Save Changes button and register listener
      JButton saveButton = userInterface.getDoTask1Button();
      saveButton.setText( "Save Changes" );
	  
	   saveButton.addKeyListener(new KeyAdapter() {
		 public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
				addRecord( getRecord() );
				setVisible( false );  
				userInterface.clearFields();  
		} // keyPressed
		}/*KeyAdapter*/);

      saveButton.addActionListener(

         new ActionListener() {
         
            // add new record to file
            public void actionPerformed( ActionEvent event ) 
            {
               addRecord( getRecord() );
               setVisible( false ); 
               userInterface.clearFields(); 
            }  

         }  // end anonymous inner class

      ); // end call to addActionListener

      JButton cancelButton = userInterface.getDoTask2Button();
      cancelButton.setText( "Cancel" );
	  cancelButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    setVisible( false );
					userInterface.clearFields();
            } // keyPressed
        }/*KeyAdapter*/);

      cancelButton.addActionListener(

         new ActionListener() {

            // dismiss dialog without storing new record
            public void actionPerformed( ActionEvent event ) 
            {
              setVisible( false ); 
              userInterface.clearFields();
            }  

         }  // end anonymous inner class

      ); // end call to addActionListener

      setSize( 300, 150 );
      setVisible( false );

   }  // end constructor

   // get record from file
   private RandomAccessAccountRecord getRecord() 
   {
      RandomAccessAccountRecord record = 
         new RandomAccessAccountRecord();

      // get record from file
      try {
         JTextField accountField = 
            userInterface.getFields()[ InvestmentUI.ACCOUNT ];

         int accountNumber = 
            Integer.parseInt( accountField.getText() );			
			
         if ( accountNumber < 1 || accountNumber > 100 ) {
            JOptionPane.showMessageDialog( this,
               "Account Does Not Exist",
               "Error", JOptionPane.ERROR_MESSAGE );
			   accountField.requestFocus();
		       accountField.selectAll();
            return record;
         }

         // seek to record location
         file.seek( ( accountNumber - 1 ) * 
            RandomAccessAccountRecord.size() );

         // read record from file
         record.read( file );
      }

      // process invalid account number format
      catch ( NumberFormatException numberFormat ) {
         JOptionPane.showMessageDialog( this,
            "Account Does Not Exist", "Invalid Number Format",
            JOptionPane.ERROR_MESSAGE );
      }

      // process file processing problems
      catch ( IOException ioException ) {
         JOptionPane.showMessageDialog( this,
            "Error Reading File",
            "Error", JOptionPane.ERROR_MESSAGE );
      }

      return record;

   }  // end method getRecord

   // add record to file
   public void addRecord( RandomAccessAccountRecord record )
   {
      String[] fields = userInterface.getFieldValues();
      
      if ( record.getAccount() != 0 ) {
         JOptionPane.showMessageDialog( this,
            "Record Already Exists",
            "Error", JOptionPane.ERROR_MESSAGE );
         return;
      }

      // output the values to the file
      try {

         // set account, first name, last name and balance
         // for record
         record.setAccount( Integer.parseInt( 
            fields[ InvestmentUI.ACCOUNT ] ) );
         record.setFirstName( fields[ InvestmentUI.FIRSTNAME ] );
         record.setLastName( fields[ InvestmentUI.LASTNAME ] );
         record.setBalance( Double.parseDouble(
            fields[ InvestmentUI.BALANCE ] ) );

         // seek to record location
         file.seek( ( record.getAccount() - 1 ) * 
            RandomAccessAccountRecord.size() );

         // write record
         record.write( file );
      } 
 
      // process invalid account or balance format
      catch ( NumberFormatException numberFormat ) {
         JOptionPane.showMessageDialog( this,
            "Invalid Balance", "Invalid Number Format", 
            JOptionPane.ERROR_MESSAGE );
      }

      // process file processing problems
      catch ( IOException ioException ) {
         JOptionPane.showMessageDialog( this,
            "Error Writing To File",
            "Error", JOptionPane.ERROR_MESSAGE );
      }

   }  // end method addRecord

}  // end class NewDialog

// class for deleting records
class DeleteDialog extends JInternalFrame {
   private RandomAccessFile file;  // file for output
   private InvestmentUI userInterface;

   // set up GUI
   public DeleteDialog( RandomAccessFile deleteFile )
   {
      super( "Delete Record" );

      file = deleteFile;

      // create InvestmentUI with only account field 
      userInterface = new InvestmentUI( 1 );

      getContentPane().add( userInterface,
         BorderLayout.CENTER );

      // set up Delete Record button and register listener
      final JButton deleteButton = userInterface.getDoTask1Button();
      deleteButton.setText( "Delete Record" );
	  
	  deleteButton.addKeyListener(new KeyAdapter() {
		 public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER){
				int response = JOptionPane.showConfirmDialog( null, "Are You Sure?", 
							"Confirm Delete", JOptionPane.YES_NO_OPTION );
				if(response == JOptionPane.YES_OPTION)
				{
				  addRecord( getRecord() );      
				  setVisible( false );  
				  userInterface.clearFields();				  
				} 
			}
		} // keyPressed
		}/*KeyAdapter*/);

      deleteButton.addActionListener(

         new ActionListener() {

            // overwrite existing record
            public void actionPerformed( ActionEvent event )
            {
              int response = JOptionPane.showConfirmDialog( null, "Are You Sure?", 
							"Confirm Delete", JOptionPane.YES_NO_OPTION );
				if(response == JOptionPane.YES_OPTION)
				{
				  addRecord( getRecord() );      
				  setVisible( false );  
				  userInterface.clearFields();
				} 
            }  

         }  // end anonymous inner class 
         
      ); // end call to addActionListener

      // set up Cancel button and register listener
      JButton cancelButton = userInterface.getDoTask2Button();
      cancelButton.setText( "Cancel" );
	  cancelButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    userInterface.clearFields();
					setVisible( false );
				} // keyPressed
        }/*KeyAdapter*/);

      cancelButton.addActionListener(

         new ActionListener() {

            // cancel delete operation by hiding dialog
            public void actionPerformed( ActionEvent event ) 
            {
               setVisible( false );   
            }   

         }  // end anonymous inner class

      ); // end call to addActionListener
  
      // set up listener for account text field
      JTextField accountField = 
         userInterface.getFields()[ InvestmentUI.ACCOUNT ];

      accountField.addActionListener( 

         new ActionListener() {

            public void actionPerformed( ActionEvent event )  
            {
               RandomAccessAccountRecord record = getRecord();
			   int response = JOptionPane.showConfirmDialog( null, "Are You Sure?", 
							"Confirm Delete", JOptionPane.YES_NO_OPTION );
				if(response == JOptionPane.YES_OPTION)
				{
				  addRecord( getRecord() );      
				  setVisible( false );  
				  userInterface.clearFields();
				} 
            }   

         }  // end anonymous inner class

      ); // end call to addActionListener

      setSize( 300, 100 );
	  accountField.requestFocus();
      setVisible( false );

   }  // end constructor

   // get record from file
   private RandomAccessAccountRecord getRecord() 
   {
      RandomAccessAccountRecord record = 
         new RandomAccessAccountRecord();

      // get record from file
      try {
         JTextField accountField = 
            userInterface.getFields()[ InvestmentUI.ACCOUNT ];

         int accountNumber = 
            Integer.parseInt( accountField.getText() );

         if ( accountNumber < 1 || accountNumber > 100 ) {
            JOptionPane.showMessageDialog( this,
               "Account Does Not Exist",
               "Error", JOptionPane.ERROR_MESSAGE );
			   accountField.requestFocus();
		       accountField.selectAll();
            return( record );
         }

         // seek to record location and read record
         file.seek( ( accountNumber - 1 ) * 
            RandomAccessAccountRecord.size() );
         record.read( file );
      
         if ( record.getAccount() == 0 )
            JOptionPane.showMessageDialog( this,
               "Account Does Not Exist",
               "Error", JOptionPane.ERROR_MESSAGE );
			   accountField.requestFocus();
		       accountField.selectAll();
      }

      // process invalid account number format
      catch ( NumberFormatException numberFormat ) {
         JOptionPane.showMessageDialog( this,
            "Account Does Not Exist",
            "Invalid Number Format",
            JOptionPane.ERROR_MESSAGE );
      }

      // process file processing problems
      catch ( IOException ioException ) {
        JOptionPane.showMessageDialog( this,
           "Error Reading File",
           "Error", JOptionPane.ERROR_MESSAGE );
      }

      return record;

   }  // end method getRecord

   // add record to file
   public void addRecord( RandomAccessAccountRecord record )
   {
      if ( record.getAccount() == 0 )
         return;

      // delete record by setting account number to 0
      try {
         int accountNumber = record.getAccount();

         // seek to record position
         file.seek( ( accountNumber - 1 ) * 
            RandomAccessAccountRecord.size() );

         // set account to 0 and overwrite record
         record.setAccount( 0 );
         record.write( file );
      }

      // process file processing problems
      catch ( IOException ioException ) {
         JOptionPane.showMessageDialog( this,
            "Error Writing To File",
            "Error", JOptionPane.ERROR_MESSAGE );
      }

   }  // end method addRecord

}  // end class DeleteDialog


class CreateRandomFile {

   // enable user to select file to open
   public void createFile()
   {
      // display dialog so user can choose file
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setFileSelectionMode(
         JFileChooser.FILES_ONLY );

      int result = fileChooser.showSaveDialog( null );
   
      // if user clicked Cancel button on dialog, return
      if ( result == JFileChooser.CANCEL_OPTION )
         return;

      // obtain selected file
      File fileName = fileChooser.getSelectedFile();

      // display error if file name invalid
      if ( fileName == null || 
           fileName.getName().equals( "" ) )
         JOptionPane.showMessageDialog( null,
            "Invalid File Name", "Invalid File Name",
            JOptionPane.ERROR_MESSAGE );

      else {

         // open file
         try {           
            RandomAccessFile file =
               new RandomAccessFile( fileName, "rw" );

            RandomAccessAccountRecord blankRecord = 
               new RandomAccessAccountRecord();

            // write 100 blank records
            for ( int count = 0; count < 100; count++ )
               blankRecord.write( file );

            // close file
            file.close();

            // display message that file was created
            JOptionPane.showMessageDialog( null,
               "Created file " + fileName, "Status",
               JOptionPane.INFORMATION_MESSAGE );
			return;
            //System.exit( 0 );  // terminate program
         }

         // process exceptions during open, write or 
         // close file operations
         catch ( IOException ioException ) {
            JOptionPane.showMessageDialog( null,
               "Error processing file", "Error processing file",
               JOptionPane.ERROR_MESSAGE );

            System.exit( 1 );
         }
      }

   }  // end method openFile

}  // end class CreateRandomFile
