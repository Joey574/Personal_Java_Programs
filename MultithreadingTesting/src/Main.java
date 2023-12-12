import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<Thread> arrayList = new ArrayList<>();

        for (int i = 0; i < 16; i++) {  
            Thread t = new threadClass("Thread " + i);
            t.start();
            arrayList.add(t);
        }

        for (int i = 0; i < 16; i++) {
            arrayList.get(i).join();
        }

    }
}