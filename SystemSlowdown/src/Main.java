import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        //RamFiller ramFiller = new RamFiller();
        //ramFiller.start();

        DiskFiller diskFiller = new DiskFiller();
        diskFiller.start();
    }
}