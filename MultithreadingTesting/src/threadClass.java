public class threadClass extends Thread {

    String name;

    threadClass(String name) {
        this.name = name;
    }

    // this method is called when we use .start()
    public void run() {
        System.out.println("Name: " + name);

    }
}
