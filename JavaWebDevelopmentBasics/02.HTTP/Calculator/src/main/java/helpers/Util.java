package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vladix on 7/17/17.
 */
public class Util {

    private static boolean isGet() {
        return System.getProperty("cgi.request_method").toLowerCase().equals("get");
    }

    private static Map<String, String> getParams(InputStream inputStream) throws IOException {
        Map<String, String> params = new LinkedHashMap<String, String>();

        String queryString = "";
        if (isGet()) {
            queryString = System.getProperty("cgi.query_string");
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            queryString = in.readLine();
        }

        String[] tokens = queryString.split("&");
        for (String token : tokens) {
            String[] kvpArgs = token.split("=");
            String key = kvpArgs[0];
            String value = "";
            if (kvpArgs.length == 2) {
                value = kvpArgs[1];
            }

            params.put(key, value);
        }

        return params;
    }

    public static void calculate(InputStream inputStream) throws IOException {
        Map<String, String> params = getParams(inputStream);

        double num1 = Double.parseDouble(params.get("num1").trim());
        double num2 = Double.parseDouble(params.get("num2").trim());
        String sign = URLDecoder.decode(params.get("sign").trim(), "UTF-8");

        double result = 0.0;
        if (sign.equals("+")) {
            result = num1 + num2;
        } else if (sign.equals("-")) {
            result = num1 - num2;
        } else if (sign.equals("*")) {
            result = num1 * num2;
        } else if (sign.equals("/")) {
            result = num1 / num2;
        } else {
            System.out.println("Invalid Sign");
            return;
        }

        System.out.println(result);
    }
}
