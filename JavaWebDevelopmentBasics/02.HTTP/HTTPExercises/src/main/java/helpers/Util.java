package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vladix on 7/17/17.
 */
public class Util {

    private static boolean isGet() {
        String requestMethod = System.getProperty("cgi.request_method");
        boolean isGet = false;
        if (requestMethod.toLowerCase().equals("get")) {
            isGet = true;
        }

        return isGet;
    }

    private static Map<String, String> getParameters(InputStream inputStream) throws IOException {
        Map<String, String> pairs = new LinkedHashMap<String, String>();
        String queryString = "";

        if (isGet()) {
            queryString = System.getProperty("cgi.query_string");
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            queryString = in.readLine();
        }

        String[] data = queryString.split("&");
        for (String currentPair : data) {

            String[] tokens = currentPair.split("=");
            String key = tokens[0];
            String value = "";
            if (tokens.length == 2) {
                value = tokens[1];
            }

            pairs.put(key, value);
        }

        return pairs;
    }

    public static void printPairs(InputStream inputStream) throws IOException {
        Map<String, String> pairs = getParameters(inputStream);
        for (Map.Entry<String, String> kvp : pairs.entrySet()) {
            if (!kvp.getKey().equals("")) {
                String kvpToPrint = kvp.getKey() + " = " + kvp.getValue();
                System.out.println(String.format("<p>%s</p>", kvpToPrint));
            }
        }
    }
}
