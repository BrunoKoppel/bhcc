package clothingStore;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class InventoryManagerProgram extends JFrame implements Serializable {

    private boolean isFileOpened;
    private RandomAccessFile input;
    private RandomAccessFile output;
    RandomAccessClothingObject blankRecord;
    private InventoryManagerUI userInterface;
    private JButton retriveObjectButton, createOrOpenInvButton, EditInvButton, SaveInvButton;
    private static final long serialVersionUID = 7526471155622776147L;

    public InventoryManagerProgram() {
        super("Creating a Random File of Objects");

        userInterface = new InventoryManagerUI(7);
        getContentPane().add(userInterface, BorderLayout.CENTER);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (((screenSize.width - this.getWidth()) / 2) / 2);
        int y = (((screenSize.height - this.getHeight()) / 2) / 2);
        this.setLocation(x, y);

        retriveObjectButton = userInterface.getFirstActionButton();
        retriveObjectButton.setText("Retrive Object using Address");
        retriveObjectButton.setEnabled(false);

        retriveObjectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    System.out.println("retriveObjectButton pressed");
                    retriveObjectFromFile();
                    System.out.println("retriveObjectButton execution finished");
                } catch (IOException ex) {
                    Logger.getLogger(InventoryManagerProgram.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        createOrOpenInvButton = userInterface.getSecondActionButton();
        createOrOpenInvButton.setText("Create or Open Inventory");
        createOrOpenInvButton.setEnabled(true);

        createOrOpenInvButton.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                createOrOpenFile();
            }
        }
        );

        EditInvButton = userInterface.getThirdActionButton();
        EditInvButton.setText("Edit Current Object");
        EditInvButton.setEnabled(false);

        EditInvButton.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                userInterface.setTextFieldsEnabledForEditing();
            }
        }
        );

        SaveInvButton = userInterface.getFourthActionButton();
        SaveInvButton.setText("Write Current Object");
        SaveInvButton.setEnabled(false);

        SaveInvButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    saveObjectToFile();
                } catch (IOException ex) {
                    Logger.getLogger(InventoryManagerProgram.class.getName()).log(Level.SEVERE, null, ex);
                }
                userInterface.setTextFieldsDisabledForEditing();
            }
        }
        );

        addWindowListener(
                new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        }
        );

        setSize(600, 400);

        setVisible(true);
    }

    private void createOrOpenFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.CANCEL_OPTION) {
            return;
        }

        File fileName = fileChooser.getSelectedFile();

        if (fileName == null || fileName.getName().equals("")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Invalid File Name",
                    "Invalid File Name",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                RandomAccessFile file = new RandomAccessFile(fileName, "rw");
                System.out.println("\n #1 File is => " + file);
                if (file.length() == 0) {
                    for (int count = 0; count < 100; count++) {
                        RandomAccessClothingObject blankRecord = new RandomAccessClothingObject(
                                count,
                                "EMPTY",
                                "EMPTY",
                                0,
                                "EMPTY",
                                0.0,
                                0
                        );
                        blankRecord.write(file);
                        System.out.printf("\nFile Length = %d \n", file.length());
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            "Created file " + fileName,
                            "Status",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }

                input = file;
                this.isFileOpened = true;
                retriveObjectButton.setEnabled(true);
                createOrOpenInvButton.setEnabled(true);
                EditInvButton.setEnabled(false);
                SaveInvButton.setEnabled(false);
                System.out.printf("\nFile Length = %d \n", input.length());
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(
                        this,
                        "File does not exist",
                        "Invalid File Name",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private void retriveObjectFromFile() throws IOException {
        int objectNumber = 0;
        String fields[] = userInterface.getFieldValues();
        RandomAccessClothingObject record = new RandomAccessClothingObject();

        System.out.println("The contents of the field are => " + fields[0]);
        if (!fields[InventoryManagerUI.SKU].equals("")) {
            System.out.println("The contents of the field are => " + fields[0]);
            try {
                objectNumber = Integer.parseInt(fields[InventoryManagerUI.SKU]);

                System.out.println("Object accessed => " + String.valueOf(objectNumber));

                if (objectNumber >= 0 && objectNumber < 100) {
                    System.out.println("Object accessed => " + String.valueOf(objectNumber));
                    System.out.println("Current position in file => " + String.valueOf(input.getFilePointer()));
                    input.seek(objectNumber * record.size());
                    record.read(input);
                    System.out.println("Current position in file => " + String.valueOf(input.getFilePointer()));

                    String values[] = {
                        String.valueOf(record.getSKU()),
                        record.getName(),
                        record.getType(),
                        record.getSizeInStringFormat(),
                        record.getColor(),
                        String.valueOf(record.getPrice()),
                        String.valueOf(record.getQuantity())
                    };

                    userInterface.setFieldValues(values);
                    EditInvButton.setEnabled(true);
                    SaveInvButton.setEnabled(true);
                }
            } catch (NumberFormatException formatException) {
                JOptionPane.showMessageDialog(
                        this,
                        "Bad account number or balance",
                        "Invalid Number Format",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        }

    }

    private void saveObjectToFile() throws IOException {
        output = input;
        int accountNumber = 0;
        String fields[] = userInterface.getFieldValues();
        RandomAccessClothingObject record = new RandomAccessClothingObject();

        if (!fields[InventoryManagerUI.SKU].equals("")) {
            try {
                accountNumber = Integer.parseInt(fields[InventoryManagerUI.SKU]);

                if (accountNumber >= 0 && accountNumber < 100) {
                    record.setSKU(accountNumber);
                    record.setName(fields[InventoryManagerUI.NAME]);
                    record.setType(fields[InventoryManagerUI.TYPE]);
                    record.setSizeFromStringFormat(fields[InventoryManagerUI.SIZE]);
                    record.setColor(fields[InventoryManagerUI.COLOR]);
                    record.setPrice(Double.parseDouble(fields[InventoryManagerUI.PRICE]));
                    record.setQuantity(Integer.parseInt(fields[InventoryManagerUI.QUANTITY]));

                    output.seek(
                            (long) (accountNumber) * RandomAccessClothingObject.size()
                    );
                    record.write(output);
                }
            } catch (NumberFormatException formatException) {
                JOptionPane.showMessageDialog(
                        this,
                        "Bad account number or balance",
                        "Invalid Number Format",
                        JOptionPane.ERROR_MESSAGE
                );
            } catch (IOException ioException) {
                closeFile();
            }
        }
    }

    private void closeFile() {
        try {
            if (output != null) {
                output.close();
            }
            System.exit(0);
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error closing file",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            System.exit(1);
        }
    }

    public boolean getIfFileIsOpened() {
        return this.isFileOpened;
    }

    public static void main(String args[]) {
        new InventoryManagerProgram();
        System.out.printf("\n the value is %d ", JFileChooser.FILES_ONLY);
    }
}
