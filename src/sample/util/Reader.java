package sample.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static sample.util.Constants.VERTICAL_BAR;


public final class Reader {

    public static String readFile(String filePath) {
        BufferedReader br = null;
        FileReader fr = null;
        StringBuilder fileContent = new StringBuilder();

        try {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);

            String currentLine;
            while ((currentLine = br.readLine()) != null) fileContent.append(currentLine).append(VERTICAL_BAR);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return fileContent.toString();
    }

    private Reader() {
    }
}
