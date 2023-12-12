import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    static File folder = new File("Game of Life Shader Automation/all");
    static File[] listOfFiles;

    public static void main(String[] args) throws FileNotFoundException {

        listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().endsWith(".rle")) {

            }
        }
    }
}