/**
 * Created by vladix on 7/14/17.
 */
public class AboutUs {

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
                "    <title>About Me</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<ul>\n" +
                "    <li>ByTheCake EOOD</li>\n" +
                "    <ul>\n" +
                "        <li>Chochko Cakes</li>\n" +
                "    </ul>\n" +
                "    <li>Vasil</li>\n" +
                "    <ul>\n" +
                "        <li>Owner: Vasil</li>\n" +
                "    </ul>\n" +
                "</ul>\n" +
                "<pre style=\"background-color: #f94f80\">\n" +
                "                                                            City: HongKong                                  City: Salzburg\n" +
                "                                                            Address: ChoCoLad 18                            Address: SchokoLeiden 73\n" +
                "                                                            Phone: +78952804429                             Phone: +49241432990\n" +
                "</pre>\n" +
                "<hr>\n" +
                "<footer style=\"text-align: center;\n" +
                "                font-size: 20px;\n" +
                "                font-weight: bold\">&#64; All Rights Reserved.</footer>\n" +
                "</body>\n" +
                "</html>";

        System.out.println(html);
    }
}
