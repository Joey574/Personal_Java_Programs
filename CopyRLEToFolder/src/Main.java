import java.io.*;
import java.util.Scanner;

public class Main {

    static File folder = new File("Game of Life Shader Automation/all");
    static File[] listOfFiles;

    public static void main(String[] args) throws IOException {

        listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().endsWith(".rle")) {
                StringBuilder temp = new StringBuilder();
                FileReader fr = new FileReader("Game of Life Shader Automation/all/" + listOfFiles[i].getName());
                Scanner sc = new Scanner(fr);

                temp.append(sc.nextLine()).append("\n");

                if (!temp.toString().startsWith("#N")) {
                    temp.insert(0, "#N " + listOfFiles[i].getName().substring(0, (listOfFiles[i].getName().length() - 4)) + "\n");
                }

                while(sc.hasNext()) {
                    temp.append(sc.nextLine()).append("\n");
                }

                FileWriter myWriter = new FileWriter("C:\\Users\\joeys\\Desktop\\rleFiles\\" + listOfFiles[i].getName() + ".txt");
                myWriter.write(String.valueOf(temp));

                myWriter.close();
                fr.close();
                sc.close();
            }
        }
    }
}