import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static class threadCount {
        public static AtomicInteger threads = new AtomicInteger();
        public static int MAX_THREADS;
    }

    public static void main(String[] args) throws IOException {

        threadCount count = new threadCount();
        count.threads.set(0);

        // set max threads
        count.MAX_THREADS = 10000;

        // Create file creator threads and start them
        for (int i = 0; i < count.MAX_THREADS; i++) {
            System.out.println(i);
            Thread mainT = new FileCreator(count);
            mainT.start();
        }

        // output number of threads active every second
        while(true) {
            if (System.currentTimeMillis() % 1000 == 0) {
                System.out.println("Active threads: " + count.threads);
            }
        }
    }
}