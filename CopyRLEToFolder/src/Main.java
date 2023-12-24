import java.io.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static File folder = new File("Game of Life Shader Automation/all");
    static File[] listOfFiles;

    private static AtomicInteger index = new AtomicInteger();

    private static int THREAD_COUNT = 16;

    public static void main(String[] args) throws IOException {
        index.set(0);

        for (int i = 0; i < THREAD_COUNT; i++) {
            FileCreator t = new FileCreator();
            t.start();
        }
    }

    public static class FileCreator extends Thread {
        @Override
        public void run() {
            try {

                listOfFiles = folder.listFiles();

                for (int i = index.getAndIncrement(); i < listOfFiles.length; i = index.getAndIncrement()) {

                    System.out.println(i);

                    if (listOfFiles[i].getName().endsWith(".rle")) {
                        StringBuilder temp = new StringBuilder();
                        FileReader fr = new FileReader("Game of Life Shader Automation/all/" + listOfFiles[i].getName());
                        Scanner sc = new Scanner(fr);

                        temp.append(sc.nextLine()).append("\n");

                        if (!temp.toString().startsWith("#N")) {
                            temp.insert(0, "#N " + listOfFiles[i].getName().substring(0, (listOfFiles[i].getName().length() - 4)) + "\n");
                        }

                        while(sc.hasNext()) {
                            temp.append(sc.nextLine()).append("\n");
                        }

                        AutoSort autoSort = new AutoSort(temp.toString());

                        String subFolder = autoSort.getCategory();

                        String directory = "C:\\Users\\joeys\\Desktop\\rleFiles\\" + subFolder;

                        File f = new File(directory);

                        if (!f.exists()) {
                            f.mkdir();
                        }

                        FileWriter myWriter = new FileWriter(directory + "\\" + listOfFiles[i].getName().replace(".rle",
                                "") + ".txt");
                        myWriter.write(String.valueOf(temp));

                        myWriter.close();
                        fr.close();
                        sc.close();
                    }
                }
            } catch (Exception e) {

            }
        }
    }
}