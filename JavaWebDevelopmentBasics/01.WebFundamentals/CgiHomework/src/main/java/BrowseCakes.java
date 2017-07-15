/**
 * Created by vladix on 7/14/17.
 */
public class BrowseCakes {

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
                "    <title>Brose Cakes</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>BROWSING CAKES</h1>\n" +
                "</body>\n" +
                "</html>";

        System.out.println(html);
    }
}
