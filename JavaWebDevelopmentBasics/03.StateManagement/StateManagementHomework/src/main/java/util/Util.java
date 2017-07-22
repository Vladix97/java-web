package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by vladix on 7/21/17.
 */
public class Util {

    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();

        BufferedReader bfr = new BufferedReader(new FileReader(filePath));
        try {
            while (true) {
                String line = bfr.readLine();
                if (line == null) break;
                content.append(line);
            }
        } finally {
            bfr.close();
        }

        return content.toString();
    }
}
