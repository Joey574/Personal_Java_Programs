import javax.swing.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class Pattern {

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

    private String name;
    private String patternString;

    Pattern(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPatternString() {
        return patternString;
    }

    public void setPatternString(String patternString) {
        this.patternString = patternString;
    }

    public String initializePattern() {
        int x = 0;
        int y = 0;
        int len = -1;

        String out = "";
        StringBuilder finalOut = new StringBuilder();

        for (int i = 0; i < patternString.length() - 1; i++) {
            if (patternString.charAt(i) == '$') {
                y++;
                x = 0;
            } else if (patternString.charAt(i) >= '0' && patternString.charAt(i) <= '9') {
                if (len == -1) {
                    len = patternString.charAt(i) - '0';
                } else {
                    len = (len * 10) + (patternString.charAt(i) - '0');
                }
            } else if (patternString.charAt(i) == 'b') {
                x += len;
                len = -1;
            } else if (patternString.charAt(i) == 'o') {

                if (len == -1) {
                    len = 1;
                }

                for (int q = 0; q < len; q++) {
                    StringBuilder xAdjust = new StringBuilder();
                    StringBuilder yAdjust = new StringBuilder();
                    out = resultTemplate;

                    if (x > 0) {
                        xAdjust.append(" + ").append(x);
                    }
                    if (y > 0) {
                        yAdjust.append(" - ").append(y);
                    }

                    out = out.replace("$", xAdjust);
                    out = out.replace("#", yAdjust);

                    finalOut.append(out).append("\n");
                }
                x += len;
                len = -1;
            }
        }
        return fileTemplate + finalOut + "}";
    }
}