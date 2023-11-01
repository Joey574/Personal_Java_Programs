import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileRead {

    private Pattern out;

    private String fileTemplate = "#pragma kernel CSMain\n" +
            "\n" +
            "RWTexture2D<float4> Result;\n" +
            "\n" +
            "float xPos;\n" +
            "float yPos;\n" +
            "\n" +
            "float4 color;\n\n" +
            "[numthreads(1, 1, 1)]\n" +
            "void CSMain(uint3 id : SV_DispatchThreadID)\n" +
            "{\n";

    private String resultTemplate = "Result[int2(xPos$, yPos#)] = color;";

    public Pattern readFile(String fileName) throws FileNotFoundException {
        FileReader fr = new FileReader(fileName);
        Scanner sc = new Scanner(fr);

        while (sc.hasNext()) {
            String temp = sc.nextLine();
            if (temp.startsWith("#N")) {
                out = new Pattern(temp.substring(3));
            } else if (!temp.startsWith("#") && !temp.startsWith("x")) {
                out.setPatternString(temp);
            }
        }

        out.initializePattern();

        return out;
    }

    public String getFileString() {
        String finalString = "";

        for (int i = 0; i < out.getLiveCells().size(); i++) {
            String temp = resultTemplate;
            String xAdjust = "";
            String yAdjust = "";

            Cell cell = out.getLiveCells().get(i);

            if (cell.x > 0) {
                xAdjust = " + " + cell.x;
            }

            if (cell.y > 0) {
                yAdjust = " + " + cell.y;
            }

            temp = temp.replace("$", xAdjust);
            temp = temp.replace("#", yAdjust);

            finalString += temp + "\n";
        }

        return fileTemplate + finalString + "}";

    }
}
