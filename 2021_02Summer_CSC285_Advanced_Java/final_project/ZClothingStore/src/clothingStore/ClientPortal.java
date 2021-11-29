package clothingStore;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ClientPortal extends JFrame implements Serializable {

    private boolean isFileOpened;
    private RandomAccessFile input;
    private ClientUI userInterface;
    ArrayList<RandomAccessClothingObject> records = new ArrayList<RandomAccessClothingObject>();
    private final JButton[] purchaseItemButton = new JButton[10];
    private JButton openCatalogButton, prevCatalogButton, nextCatalogButton;
    private static final long serialVersionUID = 7526471155622776147L;
    private int currentFirstRecordDisplayed = 0;
    private int currentLastRecordDisplayed = 0;

    public ClientPortal() {
        super("Welcome to the Clothing Store Portal");

        userInterface = new ClientUI(7);
        getContentPane().add(userInterface, BorderLayout.CENTER);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (((screenSize.width - this.getWidth()) / 2) / 2);
        int y = (((screenSize.height - this.getHeight()) / 2) / 2);
        this.setLocation(x, y);

        for (int objectCount = 0; objectCount < 10; objectCount++) {
            purchaseItemButton[objectCount] = initiateButton(userInterface.getAddToCartButton(objectCount), "Purchase", false);
        }

        openCatalogButton = initiateButton(userInterface.getOpenCatalogButton(), "Open Catalog", true);
        openCatalogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                openFile();
                try {
                    loadFileInventory();
                } catch (IOException ex) {
                    Logger.getLogger(ClientPortal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        prevCatalogButton = initiateButton(userInterface.getPrevCatalogButton(), "Previous", false);
        prevCatalogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    currentFirstRecordDisplayed = currentFirstRecordDisplayed - 10;
                    loadFileInventory();
                } catch (IOException ex) {
                    Logger.getLogger(ClientPortal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        nextCatalogButton = initiateButton(userInterface.getNextCatalogButton(), "Next", false);
        nextCatalogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    currentFirstRecordDisplayed = currentFirstRecordDisplayed + 10;
                    loadFileInventory();
                } catch (IOException ex) {
                    Logger.getLogger(ClientPortal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        purchaseItemButton[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                purchaseItem(Integer.parseInt(userInterface.getItem(0).getField(0).getText()));
            }
        });

        purchaseItemButton[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                purchaseItem(Integer.parseInt(userInterface.getItem(1).getField(0).getText()));
            }
        });

        purchaseItemButton[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                purchaseItem(Integer.parseInt(userInterface.getItem(2).getField(0).getText()));
            }
        });

        purchaseItemButton[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                purchaseItem(Integer.parseInt(userInterface.getItem(3).getField(0).getText()));
            }
        });

        purchaseItemButton[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                purchaseItem(Integer.parseInt(userInterface.getItem(4).getField(0).getText()));
            }
        });

        purchaseItemButton[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                purchaseItem(Integer.parseInt(userInterface.getItem(5).getField(0).getText()));
            }
        });

        purchaseItemButton[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                purchaseItem(Integer.parseInt(userInterface.getItem(6).getField(0).getText()));
            }
        });

        purchaseItemButton[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                purchaseItem(Integer.parseInt(userInterface.getItem(7).getField(0).getText()));
            }
        });

        purchaseItemButton[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                purchaseItem(Integer.parseInt(userInterface.getItem(8).getField(0).getText()));
            }
        });

        purchaseItemButton[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                purchaseItem(Integer.parseInt(userInterface.getItem(9).getField(0).getText()));
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                closeFile();
                System.exit(0);
            }
        });

        setSize(900, 400);

        setVisible(true);
    }

    private void openFile() {
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
                input = new RandomAccessFile(fileName, "rw");
                this.isFileOpened = true;
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

    private void loadFileInventory() throws IOException {
        long numberOfRecordsInFile = input.length() / RandomAccessClothingObject.size();
        if (records.size() > 0){
            records.clear();    
        }
                
        for (int objectCount = 0; objectCount < numberOfRecordsInFile; objectCount++) {
            records.add(retriveObjectFromFile(objectCount));
        }
        
        for (int i = 0; i < 10; i++){
            userInterface.populateField(i, records.get(currentFirstRecordDisplayed + i));
            if (records.get(currentFirstRecordDisplayed + i).getQuantity() > 0){
                purchaseItemButton[i].setEnabled(true);
            } else {
                purchaseItemButton[i].setEnabled(false);
            }
        }
        
        currentLastRecordDisplayed = currentFirstRecordDisplayed + 9;
        
        System.out.println("currentFirstRecordDisplayed => " + String.valueOf(currentFirstRecordDisplayed));
        System.out.println("currentLastRecordDisplayed => " + String.valueOf(currentLastRecordDisplayed));
        System.out.println("numberOfRecordsInFile => " + String.valueOf(numberOfRecordsInFile));

        if (currentFirstRecordDisplayed > 0) {
            prevCatalogButton.setEnabled(true);
            System.out.println("Prev Button is On!");
        } else {
            prevCatalogButton.setEnabled(false);
            System.out.println("Prev Button is Off!");
        }

        if (currentLastRecordDisplayed < numberOfRecordsInFile) {
            nextCatalogButton.setEnabled(true);
            System.out.println("Next Button is On!");
        } else {
            nextCatalogButton.setEnabled(false);
            System.out.println("Next Button is Off!");
        }
    }

    private RandomAccessClothingObject retriveObjectFromFile(int objectNumber) throws IOException {
        RandomAccessClothingObject record = new RandomAccessClothingObject();
        try {
            input.seek(objectNumber * RandomAccessClothingObject.size());
            record.read(input);
        } catch (NumberFormatException formatException) {
            JOptionPane.showMessageDialog(
                    this,
                    "Bad account number or balance",
                    "Invalid Number Format",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return record;
    }

    private void closeFile() {
        try {
            if (input != null) {
                input.close();
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

    public JButton initiateButton(JButton self, String text, boolean active) {
        self.setText(text);
        self.setEnabled(active);
        return self;
    }

    public void purchaseItem(int objectSKU) {
        RandomAccessClothingObject newRecord = new RandomAccessClothingObject();
        try {
            input.seek((long) ((objectSKU) * RandomAccessClothingObject.size()));
            newRecord.read(input);
            newRecord.setQuantity(newRecord.getQuantity() - 1);
            input.seek((long) ((objectSKU) * RandomAccessClothingObject.size()));
            newRecord.write(input);
            loadFileInventory();
            userInterface.setMoneySpent(newRecord.getPrice());
        } catch (IOException ex) {
            Logger.getLogger(ClientPortal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        new ClientPortal();
        System.out.printf("\n the value is %d ", JFileChooser.FILES_ONLY);
    }
}
