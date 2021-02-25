/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_binaryiolab;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author brunokoppel
 */
public class BrunoKoppel_BinaryIOLab {

  public static File inputFile = new File("data/wxData012015.txt");
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws java.io.IOException {
    List<String> textLines = new ArrayList<String>();
    
    Scanner scannedInputFile = new Scanner(inputFile); 
    if (inputFile.exists()){
      while(scannedInputFile.hasNextLine()){
        textLines.add(scannedInputFile.nextLine());
      }
      
      int fileLines = textLines.size();
      String [][] outputForBinaryFile = new String[fileLines][];
      
      for (int index = 0; index < fileLines; index++){
        outputForBinaryFile[index] = textLines.get(index).split("\t");
      }
      
      outputToBinaryFile(outputForBinaryFile, fileLines);
      readFromBinaryFile();
      
    } else {
      System.out.println("File not found");
    }
  }
  
  public static void outputToBinaryFile(String [][] outputForBinaryFile, int fileLines) throws IOException {
    String buffer = "";
    
    try {
      DataOutputStream dataOutputFile = new DataOutputStream(new FileOutputStream("data/dataOutput.dat"));
      
      for (int indexX = 0; indexX < fileLines; indexX++){
        for (int indexY = 0; indexY < outputForBinaryFile[indexX].length; indexY++){
          buffer += (outputForBinaryFile[indexX][indexY] + "\t");
        }
        dataOutputFile.writeUTF(buffer);
        buffer = "";
      }
      
    } catch (Exception ex){
      System.out.println(ex + " When writing the file");
    } 
  }
  
  public static void readFromBinaryFile() throws IOException{
    String buffer = "";
    try {
      DataInputStream dataInputFile = new DataInputStream(new FileInputStream("data/dataOutput.dat"));
      while(true){
        System.out.println(dataInputFile.readUTF());
      }
    } catch (EOFException ex){
      System.out.println("End of file reached successfully!");
      System.out.println(ex);
    } catch (IOException ex){
      ex.printStackTrace();
    }
  }
}
