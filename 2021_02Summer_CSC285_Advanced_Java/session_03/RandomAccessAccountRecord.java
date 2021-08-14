
//RandomAccessAccountRecord.java
// RandomAccessAccountRecord.java
// Subclass of AccountRecord for random access file programs.


// Java core packages

import java.io.*;

public class RandomAccessAccountRecord extends AccountRecord {

    // no-argument constructor calls other constructor
    // with default values
    public RandomAccessAccountRecord() {
        this(0, "", "", "", 0, 0.0, 0.0, "");
    }

    // initialize a RandomAccessAccountRecord
    public RandomAccessAccountRecord(int account, String firstName, String lastName, String address,
                                     int socsec, double balance, double newGpa, String title) {
        super(account, firstName, lastName, address, socsec, balance, newGpa, title);
    }

    // read a record from specified RandomAccessFile
    public void read(RandomAccessFile file) throws IOException {
        setAccount(file.readInt());
        setFirstName(padString(file, 15));
        setLastName(padString(file, 28));
        setAddress(padString(file, 28));
        setSocSec(file.readInt());
        setBalance(file.readDouble());
        setGPA(file.readDouble());
        setTitle(padString(file, 15));
    }

    // ensure that str is proper length
    private String padString(RandomAccessFile file, int ln)
            throws IOException {
        char str[] = new char[ln], temp;

        for (int count = 0; count < str.length; count++) {
            temp = file.readChar();
            str[count] = temp;
        }

        return new String(str).replace('\0', ' ');
    }

    // write a record to specified RandomAccessFile
    public void write(RandomAccessFile file) throws IOException {
        file.writeInt(getAccount());
        writeString(file, getFirstName(), 15);
        writeString(file, getLastName(), 28);
        writeString(file, getAddress(), 28);
        file.writeInt(getSocSec());
        file.writeDouble(getBalance());
        file.writeDouble(getGPA());
        writeString(file, getTitle(), 15);

    }

    // write a str to file; maximum of 15 characters
    private void writeString(RandomAccessFile file, String str, int ln)
            throws IOException {
        StringBuffer buffer = null;

        if (str != null)
            buffer = new StringBuffer(str);
        else
            buffer = new StringBuffer(ln);

        buffer.setLength(ln);
        file.writeChars(buffer.toString());
    }

    // NOTE: This method contains a hard coded value for the
    // size of a record of information.
    public static int size() {
        return (60 + 56 + 56 + 8 + 16);
    }

}  // end class RandomAccessAccountRecord





