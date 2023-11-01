import java.io.*;
import java.util.Scanner;

public class Main {




    public static void main(String[] args) throws IOException {

        int numFiles = 0;

        FileRead fileRead = new FileRead();

        File folder = new File("Game of Life Shader Automation/all");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().endsWith(".rle")) {
                Pattern pattern = fileRead.readFile("Game of Life Shader Automation/all/" + listOfFiles[i].getName());

                String fileName = pattern.getName();
                fileName = fileName.replace("/", "");
                fileName = fileName.replace(".rle", "");

                File myObj = new File("C:\\Users\\joeys\\Desktop\\Shaders\\" + fileName + ".compute");

                FileWriter myWriter = new FileWriter("C:\\Users\\joeys\\Desktop\\Shaders\\" + fileName + ".compute");
                myWriter.write(fileRead.getFileString());
                myWriter.close();

                System.out.println("File created");
                numFiles++;
            }
        }
        System.out.println("Num Files: " + numFiles);
    }
}