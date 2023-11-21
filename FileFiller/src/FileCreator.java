import java.io.FileWriter;
import java.io.IOException;

public class FileCreator extends Thread {

    private Main.threadCount count;

    public void run() {
        try {
            FileLoop();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    FileCreator(Main.threadCount count) throws IOException {
        this.count = count;
        count.threads.getAndIncrement();
        System.out.println("Thread: " + count.threads);
    }

    private void FileLoop() throws IOException {
        while(true) {
            // create unique filename based on current time and thread id
            //TODO: add operations to name based on thread id to futher make filename unique

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis()).append(threadId());

            // create file with unique name
            FileWriter myWriter = new FileWriter(stringBuilder.toString());

            // content to add to file
            String content = "Balls";

            // write content to file then close
            myWriter.write(content);
            myWriter.close();

            // would not closing the file further use up system resources??
        }

    }
}
