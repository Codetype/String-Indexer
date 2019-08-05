package pl.pgedlek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String input = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/example.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            String lineSeparator = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(lineSeparator);
            }

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();

            input = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringIndexer stringIndexer = new StringIndexer(input);

        stringIndexer.transform();
    }
}
