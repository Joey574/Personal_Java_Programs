import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static AtomicInteger currentTarget = new AtomicInteger();
    static AtomicInteger numFiles = new AtomicInteger();
    static File folder = new File("Game of Life Shader Automation/all");
    static File[] listOfFiles;
    static int MAX_THREADS = 12;

    public static class FileThread extends Thread {
        public void run() {
            try {
                FileRead fileRead = new FileRead();

                for (int i = 0; i < listOfFiles.length; i++) {
                    int index = currentTarget.getAndIncrement();
                    try {
                        Pattern pattern = fileRead.readFile("Game of Life Shader Automation/all/" + listOfFiles[index].getName());

                        String fileName = pattern.getName();
                        fileName = fileName.replace("/", "");
                        fileName = fileName.replace(".rle", "");

                        File myObj = new File("C:\\Users\\joeys\\Desktop\\Shaders\\" + fileName + ".compute");

                        FileWriter myWriter = new FileWriter("C:\\Users\\joeys\\Desktop\\Shaders\\" + fileName + ".compute");

                        myWriter.write(pattern.initializePattern());
                        myWriter.close();

                        numFiles.incrementAndGet();
                        System.out.println("Total files created: " + numFiles);
                    } catch (Exception e) {
                        break;
                    }
                }
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        numFiles.set(0);
        currentTarget.set(0);

        listOfFiles = folder.listFiles();

        ArrayList<Thread> threads = new ArrayList<>();


        for (int i = 0; i < MAX_THREADS; i++) {
            FileThread t = new FileThread();
            t.start();

            threads.add(t);
        }

        for (int i = 0; i < MAX_THREADS; i++) {
            threads.get(i).join();
        }

    }
}