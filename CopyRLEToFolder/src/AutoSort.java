import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class AutoSort {

    private int loc;
    private String category = "Misc";

    AutoSort(String temp) throws IOException {
        String t;
        try {
            t  = temp.substring(temp.indexOf("#C"));

            while(t.startsWith("#C")) {
                if ((t.startsWith("#C https") || t.startsWith("#C www")) && !t.substring(0, t.indexOf("\n")).endsWith(".rle")) {

                    URL url = new URL(t.substring(3, t.indexOf("\n")));

                    // Get the input stream through URL Connection
                    URLConnection con = url.openConnection();
                    InputStream is = con.getInputStream();

                    BufferedReader br = new BufferedReader(new InputStreamReader(is));

                    String line;

                    StringBuilder finalString = new StringBuilder();

                    while ((line = br.readLine()) != null) {
                        finalString.append(line).append("\n");
                    }

                    try {
                        if (finalString.toString().contains("Pattern type")) {
                            line = finalString.toString().substring(finalString.toString().indexOf("Pattern type"));
                            category = line.substring(line.indexOf("title=\"") + 7, line.indexOf("\">"));
                        }
                    } catch(Exception e) {
                        br.close();
                        is.close();
                        break;
                    }
                    br.close();
                    is.close();
                    break;

                } else {
                    t = t.substring(t.indexOf("\n") + 1); // go to next line
                }
            }
        } catch (Exception e) {}
    }

    public String getCategory() {
        return category;
    }

}
