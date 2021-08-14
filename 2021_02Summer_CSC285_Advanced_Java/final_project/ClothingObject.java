package clothingStore;

public class ClothingObject {

  // Stock Keeping Unit (Number ID for inventory items at stores) but for this it will be the address in the file
  private int SKU;
  private String name;
  private String color;
  private String type;
  private int size;
  private double price;
  private int quantity;

  ClothingObject() {
    setSKU(0);
    setName("");
    setType("");
    setSize(0);
    setColor("");
    setPrice(0.00);
    setQuantity(0);
  }

  ClothingObject(
    int value,
    String name,
    String type,
    int size,
    String color,
    double price,
    int quantity
  ) {
    setSKU(value);
    setName(name);
    setType(type);
    setSize(size);
    setColor(color);
    setPrice(price);
    setQuantity(quantity);
  }

  public void setSKU(int value) {
    this.SKU = value;
  }

  public int getSKU() {
    return this.SKU;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return this.type;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getSize() {
    return this.size;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getColor() {
    return this.color;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getPrice() {
    return this.price;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public String getSizeInStringFormat() {
    String sizeString = "";
    switch (this.getSize()) {
      case 0:
        sizeString = "XS";
        break;
      case 1:
        sizeString = "S";
        break;
      case 2:
        sizeString = "M";
        break;
      case 3:
        sizeString = "L";
        break;
      case 4:
        sizeString = "XL";
        break;
      case 5:
        sizeString = "XXL";
        break;
    }
    return sizeString;
  }

  public void setSizeFromStringFormat(String size) {
    int sizeInteger = 0;
    if (size.equals("XS")) sizeInteger = 0;
    if (size.equals("S")) sizeInteger = 1;
    if (size.equals("M")) sizeInteger = 2;
    if (size.equals("L")) sizeInteger = 3;
    if (size.equals("XL")) sizeInteger = 4;
    if (size.equals("XXL")) sizeInteger = 5;
    this.setSize(sizeInteger);
  }

  @Override
  public String toString() {
    return (
      "Item ID => " +
      String.valueOf(this.getSKU()) +
      "\n" +
      "Item Name => " +
      this.getName() +
      "\n" +
      "Item Type => " +
      this.getType() +
      "\n" +
      "Item Size => " +
      this.getSize() +
      "\n" +
      "Item Color => " +
      this.getColor()
    );
  }
}
