/**
 * Created by vladix on 7/14/17.
 */
public class AddCake {

    public static void main(String[] args) {
        setType();
        setHtml();
    }

    private static void setType() {
        String type = "Content-Type: text/html\n";

        System.out.println(type);
    }

    private static void setHtml() {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Add Cake</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><a href=\"by-the-cake-home.sh\">Back to home</a></p>\n" +
                "<form action=\"POST\">\n" +
                "    Name: <input type=\"text\" name=\"name\">\n" +
                "    Price: <input type=\"text\"n name=\"price\">\n" +
                "    <input type=\"submit\" value=\"Create\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";

        System.out.println(html);
    }
}
