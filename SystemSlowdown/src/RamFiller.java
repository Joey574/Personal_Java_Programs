import java.util.Random;

public class RamFiller extends Thread {

    int payload[] = new int[Integer.MAX_VALUE / 2];

    RamFiller() {

    }

    public void run() {
        while(true) {
            Random rn = new Random();
            for (int i = 0; i < payload.length; i++) {
                payload[i] = rn.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
    }
}
