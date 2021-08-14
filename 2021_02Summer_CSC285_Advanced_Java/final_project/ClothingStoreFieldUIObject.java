/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingStore;

import javax.swing.*;

/**
 *
 * @author bruno
 */
public class ClothingStoreFieldUIObject extends ClothingObject {
    protected int objectSize;
    protected JLabel[] fields = new JLabel[10];
    protected JButton purchaseItem;
    
    public ClothingStoreFieldUIObject(){
        
    }
    
    public ClothingStoreFieldUIObject(int size){
        this.objectSize = size;
        for (int i = 0; i < size; i++){
            fields[i] = new JLabel("");
        }
        purchaseItem = new JButton();
    }
    
    public JLabel getField (int slotNumber){
        if (this.objectSize > slotNumber){
            return fields[slotNumber];
        }
        return new JLabel("");
    }
    
    public JButton getPurchaseItemButton(){
        return this.purchaseItem;
    }
    
    public void populateFields(ClothingObject obj){
        fields[0].setText(String.valueOf(obj.getSKU()));
        fields[1].setText(obj.getName());
        fields[2].setText(obj.getType());
        fields[3].setText(obj.getSizeInStringFormat());
        fields[4].setText(obj.getColor());
        fields[5].setText("$ " + String.valueOf(obj.getPrice()));
        fields[6].setText(String.valueOf(obj.getQuantity()));
    }
}
