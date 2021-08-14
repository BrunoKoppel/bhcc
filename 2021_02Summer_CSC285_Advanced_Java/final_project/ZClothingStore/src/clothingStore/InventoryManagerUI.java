package clothingStore;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
// Java extension packages
import javax.swing.*;

public class InventoryManagerUI extends JPanel {

    private static final long serialVersionUID = 9178478442623178927L;
    protected static final String labelNames[] = {
        "SKU",
        "Name",
        "Type",
        "Size",
        "Color",
        "Price",
        "Quantity",};

    protected JLabel labels[];
    protected JTextField fields[];
    protected JButton firstAction, secondAction, thirdAction, fourthAction;
    protected JPanel innerPanelNorth, innerPanelCenter, innerPanelSouth;
    protected int size;

    public static final int SKU = 0, NAME = 1, TYPE = 2, SIZE = 3, COLOR
            = 4, PRICE = 5, QUANTITY = 6;

    public InventoryManagerUI(int mySize) {
        size = mySize;
        labels = new JLabel[mySize];
        fields = new JTextField[mySize];

        for (int count = 0; count < mySize; count++) {
            labels[count] = new JLabel(labelNames[count]);
            fields[count] = new JTextField();
        }

        for (int x = 0; x < size; x++) {
            final int fieldSize = x;
            fields[x].addKeyListener(
                    new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        if (fieldSize == (size - 1)) {
                            secondAction.requestFocus();
                        } else {
                            fields[fieldSize + 1].requestFocus();
                        }
                    }
                }
            }
            );
        }

        innerPanelNorth = new JPanel();
        innerPanelNorth.setLayout(new GridLayout(1, 3));
        firstAction = new JButton();

        innerPanelCenter = new JPanel();
        innerPanelCenter.setLayout(new GridLayout(size, 2));
        
        for (int count = 0; count < fields.length; count++) {
            fields[count] = new JTextField();
        }

        for (int count = 0; count < size; count++) {
            if (count == 0) {
                innerPanelNorth.add(labels[count]);
                innerPanelNorth.add(fields[count]);
                innerPanelNorth.add(firstAction);
            } else {
                innerPanelCenter.add(labels[count]);
                innerPanelCenter.add(fields[count]);
            }
        }

        setTextFieldsDisabledForEditing();
        
        secondAction = new JButton();
        thirdAction = new JButton();
        fourthAction = new JButton();

        innerPanelSouth = new JPanel();

        innerPanelSouth.add(secondAction);
        innerPanelSouth.add(thirdAction);
        innerPanelSouth.add(fourthAction);

        setLayout(new BorderLayout());
        add(innerPanelNorth, BorderLayout.NORTH);
        add(innerPanelCenter, BorderLayout.CENTER);
        add(innerPanelSouth, BorderLayout.SOUTH);
        validate();
    }

    public JButton getFirstActionButton() {
        return firstAction;
    }

    public JButton getSecondActionButton() {
        return secondAction;
    }

    public JButton getThirdActionButton() {
        return thirdAction;
    }

    public JButton getFourthActionButton() {
        return fourthAction;
    }

    public void setTextFieldsEnabledForEditing() {
        for (int i = 1; i < labels.length; i++){
            fields[i].setEnabled(true);
        }
    }
    
    public void setTextFieldsDisabledForEditing() {
        for (int i = 1; i < labels.length; i++){
            fields[i].setEnabled(false);
        }
    }
    
    public JTextField[] getFields() {
        return fields;
    }

    public void clearFields() {
        for (int count = 0; count < size; count++) {
            fields[count].setText("");
        }
    }

    public void setFieldValues(String strings[]) throws IllegalArgumentException {
        if (strings.length != size) {
            throw new IllegalArgumentException(
                    "There must be " + size + " Strings in the array"
            );
        }

        for (int count = 0; count < size; count++) {
            fields[count].setText(strings[count]);
        }
    }

    public String[] getFieldValues() {
        String values[] = new String[size];

        for (int count = 0; count < size; count++) {
            values[count] = fields[count].getText();
            System.out.println("Field #" + count + " => " + fields[count].getText());
        }

        return values;
    }
}
