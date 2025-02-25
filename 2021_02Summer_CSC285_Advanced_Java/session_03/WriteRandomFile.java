//WriteRandomFile.java

// This program uses textfields to get information from the
// user at the keyboard and writes the information to a
// random-access file.

// Java core packages

import java.awt.*;
import java.awt.event.*;
import java.io.*;

// Java extension packages
import javax.swing.*;

public class WriteRandomFile extends JFrame {
    private RandomAccessFile output;
    private BankUI userInterface;
    private JButton enterButton, openButton;
    private JTextField setFcs;
    // set up GUI


    public WriteRandomFile() {
        super("Write to random access file");

        // create instance of reusable user interface BankUI
        userInterface = new BankUI(8);  // four textfields
        getContentPane().add(userInterface,
                BorderLayout.CENTER);

        // get reference to generic task button doTask1 in BankUI
        openButton = userInterface.getDoTask1Button();
        openButton.setText("Open...");

        // register listener to call openFile when button pressed
        openButton.addActionListener(

                // anonymous inner class to handle openButton event
                new ActionListener() {

                    // allow user to select file to open
                    public void actionPerformed(ActionEvent event) {
                        openFile();
                    }

                }  // end anonymous inner class

        ); // end call to addActionListener


        // configure window
        setDefaultCloseOperation(
                WindowConstants.EXIT_ON_CLOSE);


        // get reference to generic task button doTask2 in BankUI
        enterButton = userInterface.getDoTask2Button();
        enterButton.setText("Enter");
        enterButton.setEnabled(false);

        // register listener to call addRecord when button pressed
        enterButton.addActionListener(

                // anonymous inner class to handle enterButton event
                new ActionListener() {

                    // add record to file
                    public void actionPerformed(ActionEvent event) {
                        addRecord();
                    }

                }  // end anonymous inner class

        ); // end call to addActionListener


        // add Enter key listener
        enterButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    addRecord();
                setFcs = userInterface.fields[0];
                setFcs.requestFocus();
            } // keyPressed
        }/* KeyAdapter */);


        setSize(600, 400);
//  show(); 
        setVisible(true);
    }

    // enable user to choose file to open
    private void openFile() {
        // display file dialog so user can select file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(
                JFileChooser.FILES_ONLY);

        int result = fileChooser.showOpenDialog(this);

        // if user clicked Cancel button on dialog, return
        if (result == JFileChooser.CANCEL_OPTION)
            return;

        // obtain selected file
        File fileName = fileChooser.getSelectedFile();

        // display error if file name invalid
        if (fileName == null ||
                fileName.getName().equals(""))
            JOptionPane.showMessageDialog(this,
                    "Invalid File Name", "Invalid File Name",
                    JOptionPane.ERROR_MESSAGE);

        else {

            // open file
            try {
                output = new RandomAccessFile(fileName, "rw");
                enterButton.setEnabled(true);
                openButton.setEnabled(false);
            }

            // process exception while opening file
            catch (IOException ioException) {
                JOptionPane.showMessageDialog(this,
                        "File does not exist",
                        "Invalid File Name",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }  // end method openFile

    // close file and terminate application
    private void closeFile() {
        // close file and exit
        try {
            if (output != null)
                output.close();

            System.exit(0);
        }

        // process exception while closing file
        catch (IOException ioException) {
            JOptionPane.showMessageDialog(this,
                    "Error closing file",
                    "Error", JOptionPane.ERROR_MESSAGE);

            System.exit(1);
        }
    }

    // add one record to file
    public void addRecord() {
        int accountNumber = 0;
        String fields[] = userInterface.getFieldValues();
        RandomAccessAccountRecord record =
                new RandomAccessAccountRecord();

        // ensure account field has a value
        if (!fields[BankUI.ACCOUNT].equals("")) {

            // output values to file
            try {
                accountNumber =
                        Integer.parseInt(fields[BankUI.ACCOUNT]);

                if (accountNumber > 0 && accountNumber <= 100) {
                    record.setAccount(accountNumber);
                    record.setFirstName(fields[BankUI.FIRSTNAME]);
                    record.setLastName(fields[BankUI.LASTNAME]);
                    record.setAddress(fields[BankUI.ADDRESS]);
                    record.setSocSec(Integer.parseInt(fields[BankUI.SOCSEC]));
                    record.setBalance(Double.parseDouble(fields[BankUI.BALANCE]));
                    record.setGPA(Double.parseDouble(fields[BankUI.GPA]));
                    record.setTitle(fields[BankUI.TITLE]);


                    output.seek((long) (accountNumber - 1) *
                            RandomAccessAccountRecord.size());
                    record.write(output);
                }

                userInterface.clearFields();  // clear TextFields
            }

            // process improper account number or balance format
            catch (NumberFormatException formatException) {
                JOptionPane.showMessageDialog(this,
                        "Bad account number or balance",
                        "Invalid Number Format",
                        JOptionPane.ERROR_MESSAGE);
            }

            // process exceptions while writing to file
            catch (IOException ioException) {
                closeFile();
            }
        }

    }  // end method addRecord

    // execute application
    public static void main(String args[]) {
        new WriteRandomFile();
    }

}  // end class WriteRandomFile
