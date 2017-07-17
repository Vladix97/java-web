import helpers.Util;

import java.io.IOException;

/**
 * Created by vladix on 7/17/17.
 */
public class Calculator {

    public static void main(String[] args) throws IOException {
        setType();
        setBody();
        Util.calculate(System.in);

        setFooter();
    }

    private static void setType() {
        String type = "Content-Type: text/html\n";

        System.out.println(type);
    }

    private static void setBody() {
        String body = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Calculator</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method=\"POST\">\n" +
                "    <div>\n" +
                "        <input type=\"number\" name=\"num1\">\n" +
                "        <input type=\"text\" name=\"sign\">\n" +
                "        <input type=\"number\" name=\"num2\">\n" +
                "        <label>=?</label>\n" +
                "    </div>\n" +
                "    <input type=\"submit\" value=\"Calculate\">\n" +
                "</form>\n";

        System.out.println(body);
    }

    private static void setFooter() {
        String footer = "</body>\n" +
                "</html>";

        System.out.println(footer);
    }

}
