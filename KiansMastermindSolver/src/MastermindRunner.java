import java.sql.Array;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MastermindRunner {
    public final static int COLOR_AMOUNT = 6;
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayList<Boolean> above5 = new ArrayList<>();
        int guessNum = 0;
        int timesRan = 0;
        MastermindSolver m = new MastermindSolver();
        Clock clock = Clock.systemDefaultZone();
        long startTime = clock.millis();
        for (int i = 0; i < COLOR_AMOUNT; i++) {
            for (int o = 0; o < COLOR_AMOUNT; o++) {
                for (int p = 0; p < COLOR_AMOUNT; p++) {
                    for (int w = 0; w < COLOR_AMOUNT; w++) {
                        String answer = "" + i + o + p + w;
                        guessNum += m.knuthGuess(answer);
                        timesRan++;
                    }
                }
            }
        }

        System.out.println("It took " + (double)guessNum / (double)timesRan + " times and " + (clock.millis() - startTime) + " millis");
        /*while (true) {
            String guess = console.nextLine();
            guessNum = m.knuthGuess(guess);
            System.out.println("It took " + guessNum + " tries");
        }*/
    }
}