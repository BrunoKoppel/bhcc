//CreateRandomFile.java

// Java core packages

import java.io.*;
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;
import java.io.Serializable;


public class CreateRandomFile extends JFrame implements Serializable {

    RandomAccessAccountRecord blankRecord;
    private BankUI userInterface;
    private JButton enterButton, openButton;
    private static final long serialVersionUID = 7526471155622776147L;

    // set up GUI
    public CreateRandomFile() {
        super("Creating a Random File of Objects");

        // create instance of reusable user interface
        userInterface = new BankUI(8);  // four textfields
        getContentPane().add(
                userInterface, BorderLayout.CENTER);


        // Get the size of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (((screenSize.width - this.getWidth()) / 2) / 2);
        int y = (((screenSize.height - this.getHeight()) / 2) / 2);
        this.setLocation(x, y);


        // get reference to generic task button doTask1 in BankUI
        // and configure button for use in this program
        openButton = userInterface.getDoTask1Button();
        openButton.setText("Save into File ...");

        // register listener to call openFile when button pressed
        openButton.addActionListener(

                // anonymous inner class to handle openButton event
                new ActionListener() {

                    // call openFile when button pressed
                    public void actionPerformed(ActionEvent event) {
                        openFile();
                    }

                }  // end anonymous inner class

        ); // end call to addActionListener

        // get reference to generic task button doTask2 in BankUI
        // and configure button for use in this program
        enterButton = userInterface.getDoTask2Button();
        enterButton.setText("Enter");
        enterButton.setEnabled(false);  // disable button

        // register listener to call addRecord when button pressed
        enterButton.addActionListener(

                // anonymous inner class to handle enterButton event
                new ActionListener() {

                    // call addRecord when button pressed
                    public void actionPerformed(ActionEvent event) {

                    }

                }  // end anonymous inner class

        ); // end call to addActionListener

        // register window listener to handle window closing event
        addWindowListener(

                // anonymous inner class to handle windowClosing event
                new WindowAdapter() {

                    // add current record in GUI to file, then close file
                    public void windowClosing(WindowEvent event) {

                        System.exit(0);

                    }

                }  // end anonymous inner class

        ); // end call to addWindowListener

        setSize(600, 400);
        // show();
        setVisible(true);

    }  // end CreateRandomFile constructor

    // allow user to specify file name
    private void openFile() {
        // display file dialog, so user can choose file to open
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(
                JFileChooser.FILES_ONLY);

        int result = fileChooser.showSaveDialog(this);

        // if user clicked Cancel button on dialog, return
        if (result == -1)
            return;
        //if ( result == JFileChooser.CANCEL_OPTION )
        // return;

        // get selected file
        File fileName = fileChooser.getSelectedFile();

        // display error if invalid
        if (fileName == null ||
                fileName.getName().equals(""))
            JOptionPane.showMessageDialog(this,
                    "Invalid File Name", "Invalid File Name",
                    JOptionPane.ERROR_MESSAGE);

        else {

            // open file
            try {
                RandomAccessFile file =
                        new RandomAccessFile(fileName, "rw");

                

                // write 100 blank records
                for (int count = 0; count < 100; count++){
                    RandomAccessAccountRecord blankRecord =
                        new RandomAccessAccountRecord(count+1, "EMPTY", "EMPTY", "EMPTY", 0, 0.0, 0.0, "EMPTY");
                    blankRecord.write(file);
                }
                    

                // close file
                file.close();

                // display message that file was created
                JOptionPane.showMessageDialog(null,
                        "Created file " + fileName, "Status",
                        JOptionPane.INFORMATION_MESSAGE);

                System.exit(0);  // terminate program
            }

            // process exceptions during open, write or
            // close file operations
            catch (IOException ioException) {
                JOptionPane.showMessageDialog(null,
                        "Error processing file", "Error processing file",
                        JOptionPane.ERROR_MESSAGE);

                System.exit(1);
            }
        }

    }  // end method openFile


    // execute application; CreateRandomFile constructor
    // displays window
    public static void main(String args[]) {
        new CreateRandomFile();
        System.out.printf("\n the value is %d ", JFileChooser.FILES_ONLY);
    }

}  // end class CreateRandomFile

