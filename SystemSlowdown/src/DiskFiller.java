import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DiskFiller extends Thread {

    StringBuilder stringBuilder = new StringBuilder();
    Random rn = new Random();

    DiskFiller() {

    }

    public void run() {
        for (int i = 0; i < 1000000; i++) {
            int t = rn.nextInt(0, 10000);
            stringBuilder.append((char)t);
        }

        fileCreateAndDelete();
    }

    private void fileCreateAndDelete() {
        String fileName = null;
        FileWriter myWriter = null;

        while (true) {
            if (fileName != null) {
                new File("C:\\Users\\joeys\\Desktop\\TempLoc\\" + fileName + ".txt").delete();
            }

            fileName = (System.currentTimeMillis() + "XXX" + (rn.nextInt(0, 1000) * rn.nextFloat()));

            try {
                File myObj = new File("C:\\Users\\joeys\\Desktop\\TempLoc\\" + fileName + ".txt");
                myWriter = new FileWriter("C:\\Users\\joeys\\Desktop\\TempLoc\\" + fileName + ".txt");
                myWriter.write(stringBuilder.toString());
                myWriter.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Done");
        }
    }
}
