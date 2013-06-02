import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class FileOI {
  public static void main(String[] args) {
    int i = 0;
    Boolean loop = true;
    int numOfFiles = args.length;
    String[] fileNames;
    String[] lines;
    Scanner keyboard  = new Scanner(System.in);
    String outputFileName = "Output.txt";

    // Allocate memory for the number of files
    fileNames = new String[numOfFiles];
    lines = new String[numOfFiles];

    for (i = 0; i < numOfFiles; i++) {
      fileNames[i] = args[i];
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
            System.out.print(", ");
            outputStream.print(", ");
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

    System.exit(0);
  }
}