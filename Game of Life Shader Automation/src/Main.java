import java.io.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static AtomicInteger currentTarget = new AtomicInteger();
    static AtomicInteger numFiles = new AtomicInteger();
    static File folder = new File("Game of Life Shader Automation/all");
    static File[] listOfFiles;
    static int MAX_THREADS = 16;

    public static class FileThread extends Thread {
        public void run() {
            try {
                FileRead fileRead = new FileRead();

                for (int i = 0; i > -1; i++) {
                    int index = currentTarget.getAndIncrement();

                    try {
                        if (listOfFiles[index].getName().endsWith(".rle")) {
                            Pattern pattern = fileRead.readFile("Game of Life Shader Automation/all/" + listOfFiles[index].getName());

                            String fileName = pattern.getName();
                            fileName = fileName.replace("/", "");
                            fileName = fileName.replace(".rle", "");

                            File myObj = new File("C:\\Users\\joeys\\Desktop\\Shaders\\" + fileName + ".compute");

                            FileWriter myWriter = null;
                            myWriter = new FileWriter("C:\\Users\\joeys\\Desktop\\Shaders\\" + fileName + ".compute");

                            myWriter.write(fileRead.getFileString());
                            myWriter.close();

                            System.out.println("Index: " + currentTarget + " File Created");
                            numFiles.incrementAndGet();
                        }
                    } catch (Exception e) {
                        break;
                    }

                }
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }



    public static void main(String[] args) throws IOException {
        numFiles.set(0);
        currentTarget.set(0);

        listOfFiles = folder.listFiles();

        for (int i = 0; i < MAX_THREADS; i++) {
            FileThread t = new FileThread();
            t.start();
        }

        System.out.println("Num Files: " + numFiles);
    }
}