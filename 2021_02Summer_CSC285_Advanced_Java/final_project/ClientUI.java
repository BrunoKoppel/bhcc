package clothingStore;

import java.awt.*;
import javax.swing.*;

public class ClientUI extends JPanel {

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
    protected JButton openCatalog, prevCatalog, nextCatalog;
    protected JPanel innerPanelNorth, innerPanelCenter, innerPanelSouth;
    protected ClothingStoreFieldUIObject[] merchandise = new ClothingStoreFieldUIObject[10];
    protected JLabel moneySpent;
    protected int size;

    public static final int SKU = 0, NAME = 1, TYPE = 2, SIZE = 3, COLOR
            = 4, PRICE = 5, QUANTITY = 6;

    
    
    public ClientUI(int mySize) {
        size = mySize;
        labels = new JLabel[mySize];

        innerPanelNorth = new JPanel();
        innerPanelNorth.setLayout(new GridLayout(1, 8));
        
        for (int count = 0; count < mySize + 1; count++) {
            if (count < mySize){
                labels[count] = new JLabel(labelNames[count]);
                innerPanelNorth.add(labels[count]);
            } else {
                innerPanelNorth.add(new JLabel(""));
            }           
        }

        innerPanelCenter = new JPanel();
        innerPanelCenter.setLayout(new GridLayout(10, size + 1));

        for (int objectCount = 0; objectCount < 10; objectCount++){
            merchandise[objectCount] = new ClothingStoreFieldUIObject(mySize);
            for (int count = 0; count < size + 2; count++) {
                if (count < size){
                    innerPanelCenter.add(merchandise[objectCount].getField(count));
                } else if (count == size){
                    innerPanelCenter.add(merchandise[objectCount].getPurchaseItemButton());
                }
            }    
        }
        
        openCatalog = new JButton();
        prevCatalog = new JButton();
        nextCatalog = new JButton();

        innerPanelSouth = new JPanel();
        moneySpent = new JLabel();
        moneySpent.setText("$ 0.00");
        
        
        innerPanelSouth.add(openCatalog);
        innerPanelSouth.add(prevCatalog);
        innerPanelSouth.add(nextCatalog);
        innerPanelSouth.add(new JLabel("Money Spent: "));
        innerPanelSouth.add(moneySpent);

        setLayout(new BorderLayout());
        add(innerPanelNorth, BorderLayout.NORTH);
        add(innerPanelCenter, BorderLayout.CENTER);
        add(innerPanelSouth, BorderLayout.SOUTH);
        validate();
    }
    
    public JButton getOpenCatalogButton() {
        return openCatalog;
    }

    public JButton getPrevCatalogButton() {
        return prevCatalog;
    }

    public JButton getNextCatalogButton() {
        return nextCatalog;
    }
    
    public ClothingStoreFieldUIObject getItem(int objectNumber){
        return merchandise[objectNumber];
    }
    
    public JButton getAddToCartButton(int object) {
        return merchandise[object].getPurchaseItemButton();
    }
    
    public void populateField(int objectField, RandomAccessClothingObject obj) {
        merchandise[objectField].populateFields((ClothingObject) obj);
    }
    
    public void setMoneySpent(Double price){
        double currentPrice = Double.parseDouble(moneySpent.getText().substring(2));
        double moneySpentSoFar = currentPrice + price;
        moneySpent.setText("$ " + String.valueOf(moneySpentSoFar));
    }
}