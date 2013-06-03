// File: FileOI.java
// Created Date: June 02, 2013 
// Programmer: Ka-Son Chan
// Description: This file contains the FileOI class. This class contains the 
// Join and Split functions.
 
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.BufferedWriter;

public class FileOI {
  public void Join(String[] args) {
    int i = 0;
    Boolean loop = true;
    int numOfFiles = args.length - 3;
    String[] fileNames;
    String[] lines;
    String outputFileName = args[2];

    // Allocate memory for the number of files
    fileNames = new String[numOfFiles];
    lines = new String[numOfFiles];
 
    for (i = 0; i < numOfFiles; i++) {
      fileNames[i] = args[i + 3];
    }

    // Declare input stream
    Scanner[] inputStreams = new Scanner[numOfFiles];
    
    for (i = 0; i < numOfFiles; i++) {
      try {
        // Open file
        inputStreams[i] = new Scanner(new File(fileNames[i]));
      } 
      catch (FileNotFoundException e) {
        // If can not open file
        System.out.println("Error opening the file " + fileNames[i]);

        System.exit(-1);
      }
    }

    PrintWriter outputStream = null;

    try {
      outputStream = new PrintWriter(outputFileName);
    }
    catch(FileNotFoundException e) {
      System.out.println("Error opening the file " + outputFileName);
      System.exit(-1);
    }

    do {
      for (i = 0; i < numOfFiles; i++) {
        if (inputStreams[i].hasNextLine()) {
          // Read line from file and print it
          lines[i] = inputStreams[i].nextLine();
          System.out.print(lines[i]);
          outputStream.print(lines[i]);
          if (i < numOfFiles - 1) {
            System.out.print(args[1] + " ");
            outputStream.print(args[1] + " ");
          }
          else { 
            System.out.println(" ");
            outputStream.println(" ");
          }
        }
        else {
          loop = false;
          break;
        }
      }
    } while (loop);

    for (i = 0; i < numOfFiles; i++) {
      inputStreams[i].close();
    }

    outputStream.close();
  }

  public void Split(String[] args) {
    int i = 0;
    Boolean loop = true;
    int numOfFiles = args.length - 3;
    String intputFileName = args[2];
    String line;
    String[] outputFileNames;
    String delims = args[1] + " ";
    String[] tokens;
    PrintWriter[] output = new PrintWriter[numOfFiles];

    // Allocate memory for the number of output file names
    outputFileNames = new String[numOfFiles];

    for (i = 0; i < numOfFiles; i++) {
      outputFileNames[i] = args[i + 3];
    }

    // Declare input stream
    Scanner inputStream = null;
    
    try {
      // Open file
      inputStream = new Scanner(new File(intputFileName));
      // inputStream.useDelimiter(args[1] + " ");
    } 
    catch (FileNotFoundException e) {
      // If can not open file
      System.out.println("Error opening the file " + intputFileName);

      System.exit(-1);
    }

    try {
      for (i = 0; i < numOfFiles; i++) {
        output[i] = new PrintWriter(outputFileNames[i]);
      }

      while (inputStream.hasNextLine()) {
        // Read line from file and print it
        line = inputStream.nextLine();
        System.out.println(line);
      
        tokens = line.split(delims);

        for (i = 0; i < numOfFiles; i++) {
          output[i].println(tokens[i]);      
        }
      }

      for (i = 0; i < numOfFiles; i++) {
        output[i].close();      
      }
    }
    catch(FileNotFoundException e) {
      System.out.println("Error opening the file " + outputFileNames[0]);
      System.exit(-1);
    }

    inputStream.close();
  }
}
