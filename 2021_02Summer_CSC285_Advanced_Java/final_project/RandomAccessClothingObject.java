package clothingStore;

import java.io.*;

public class RandomAccessClothingObject extends ClothingObject {

  public RandomAccessClothingObject() {
    this(0, "", "", 0, "", 0.00, 0);
  }

  public RandomAccessClothingObject(
    int SKU,
    String name,
    String type,
    int size,
    String color,
    double price,
    int quantity
  ) {
    super(SKU, name, type, size, color, price, quantity);
  }

  public void read(RandomAccessFile file) throws IOException {
    setSKU(file.readInt());
    setName(padString(file, 32));
    setType(padString(file, 16));
    setSize(file.readInt());
    setColor(padString(file, 16));
    setPrice(file.readDouble());
    setQuantity(file.readInt());
  }

  private String padString(RandomAccessFile file, int ln) throws IOException {
    char str[] = new char[ln], temp;

    for (int count = 0; count < str.length; count++) {
      temp = file.readChar();
      str[count] = temp;
    }

    return new String(str).replace('\0', ' ');
  }

  public void write(RandomAccessFile file) throws IOException {
    file.writeInt(getSKU());
    writeString(file, getName(), 32);
    writeString(file, getType(), 16);
    file.writeInt(getSize());
    writeString(file, getColor(), 16);
    file.writeDouble(getPrice());
    file.writeInt(getQuantity());
  }

  private void writeString(RandomAccessFile file, String str, int ln)
    throws IOException {
    StringBuffer buffer = null;

    if (str != null) {
      buffer = new StringBuffer(str);
    } else {
      buffer = new StringBuffer(ln);
    }

    buffer.setLength(ln);
    file.writeChars(buffer.toString());
  }

  public static int size() {
    return (4 + 64 + 32 + 4 + 32 + 8 + 4);
  }
}
