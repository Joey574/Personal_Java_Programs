import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException {
        FileRead fileRead = new FileRead();

        File folder = new File("Game of Life Shader Automation/all");
        File[] listOfFiles = folder.listFiles();

        System.out.println(listOfFiles[2902].getName());

        Pattern pattern = fileRead.readFile("Game of Life Shader Automation/all/" + listOfFiles[2902].getName());

        String fileName = pattern.getName();
        fileName = fileName.replace("/", "");
        fileName = fileName.replace(".rle", "");

        System.out.println("Pattern String: " + pattern.getPatternString());

        File myObj = new File("C:\\Users\\joeys\\Desktop\\Shaders\\" + fileName + ".compute");

        FileWriter myWriter = null;
        myWriter = new FileWriter("C:\\Users\\joeys\\Desktop\\Shaders\\" + fileName + ".compute");

        myWriter.write(fileRead.getFileString());
        myWriter.close();
    }
}
