import javax.swing.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class Pattern {

    private String name;
    private String patternString;
    private ArrayList<Cell> cellStates = new ArrayList<>();
    private ArrayList<Cell> liveCells = new ArrayList<>();

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
        boolean alive;

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
                alive = false;
                x += initalizeCreateCell(x, y, len, alive);
                len = -1;
            } else if (patternString.charAt(i) == 'o') {
                alive = true;
                x += initalizeCreateCell(x, y, len, alive);
                len = -1;
            }
        }

        for (int i = 0; i < cellStates.size(); i++) {
            if (cellStates.get(i).alive) {
                liveCells.add(cellStates.get(i));
            }
        }
    }
}
