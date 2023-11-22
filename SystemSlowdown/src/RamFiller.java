import java.util.ArrayList;
import java.util.Random;

public class RamFiller extends Thread {

    ArrayList<ClutterClass> test = new ArrayList<>();

    RamFiller() {

    }

    public void run() {

        // Get current size of heap in bytes
        long heapSize = Runtime.getRuntime().totalMemory() / 1000000;

        // Get maximum size of heap in bytes. The heap cannot grow beyond this size.
        // Any attempt will result in an OutOfMemoryException.
        long heapMaxSize = Runtime.getRuntime().maxMemory() / 1000000;


        // Get amount of free memory within the heap in bytes. This size will increase
        // after garbage collection and decrease as new objects are created.
        long heapFreeSize = Runtime.getRuntime().freeMemory() / 1000000;

        System.out.println(heapSize + " mb current");
        System.out.println(heapMaxSize + " mb total");
        System.out.println(heapFreeSize + " mb free");

        Random rn = new Random();

        int min = 0;
        int max = 10;

        while(Runtime.getRuntime().freeMemory() > 1000000) {

            int a = rn.nextInt(min, max);
            int b = rn.nextInt(min, max);
            int c = rn.nextInt(min, max);
            int d = rn.nextInt(min, max);
            int e = rn.nextInt(min, max);
            int f = rn.nextInt(min, max);
            int g = rn.nextInt(min, max);

            test.add(new ClutterClass(a,b,c,d,e,f,g));
        }
        test.clear();
        System.out.println("done");
    }
}
