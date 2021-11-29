
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class IntroProcess{

	public int IntroProcess(){
    	
	   int response = JOptionPane.showConfirmDialog( null, "Start Transaction Processor?",
				"Welcome to the Transaction Processor", JOptionPane.YES_NO_OPTION );
	             
				if(response == JOptionPane.YES_OPTION)
				{
					return (1);
				}
				else 			
					System.exit(0);

			
		return (0);
	}//end constructor
}//end class







	