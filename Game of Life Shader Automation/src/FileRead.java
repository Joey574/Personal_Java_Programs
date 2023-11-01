import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileRead {

    private Pattern out;

    public Pattern readFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        Scanner sc = new Scanner(fr);

        StringBuilder pattern = new StringBuilder();

        while (sc.hasNext()) {
            String temp = sc.nextLine();
            if (temp.startsWith("#N")) {
                out = new Pattern(temp.substring(3));
            } else if (!temp.startsWith("#") && !temp.startsWith("x")) {
                pattern.append(temp);
            }
        }

        fr.close();
        sc.close();

        out.setPatternString(pattern.toString());
        return out;
    }
}
