// File: FileOIDemo.java
// Created Date: June 02, 2013 
// Programmer: Ka-Son Chan
// Description: This program is a demo of using the functions of the class 
// FileOI.

public class FileOIDemo {
  public static void main(String[] args) {
    FileOI FileOI = new FileOI();

    if (args[0].toLowerCase().equals("join")) {
      FileOI.Join(args);
    }
    else if (args[0].equalsIgnoreCase("split")) {
      FileOI.Split(args);
    }

    System.exit(0);
  }
}
