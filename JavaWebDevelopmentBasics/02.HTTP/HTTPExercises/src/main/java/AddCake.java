import helpers.Util;

import java.io.IOException;

/**
 * Created by vladix on 7/17/17.
 */
public class AddCake {
    public static void main(String[] args) throws IOException {

        setType();
        setBody();
        Util.printPairs(System.in);
        setFooter();
    }

    private static void setFooter() {
        String footer = "</body>\n" +
                "</html>";

        System.out.println(footer);
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
                "    <title>Add Cake</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form method=\"post\">\n" +
                "        <label>Cake</label>\n" +
                "        <input type=\"text\" name=\"name\">\n" +
                "        <label>Price</label>\n" +
                "        <input type=\"text\" name=\"price\">\n" +
                "        <input type=\"submit\" value=\"Create\">\n" +
                "    </form>\n";

        System.out.println(body);
    }
}