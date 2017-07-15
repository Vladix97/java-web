/**
 * Created by vladix on 7/14/17.
 */
public class ByTheCakeHome {

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
                "    <title>By The Cake</title>\n" +
                "    <meta name=\"description\" content=\"Buy the cake in By The Cake\">\n" +
                "    <meta name=\"Keywords\" content=\"Cakes, Buy\">\n" +
                "    <meta name=\"Author\" content=\"Vasil Gramov\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1 id=\"home\">By the Cake</h1>\n" +
                "<h2>Enjoy our awesome cakes</h2>\n" +
                "<hr>\n" +
                "<ul>\n" +
                "    <li><a href=\"#home\">Home</a></li>\n" +
                "    <ul>\n" +
                "        <li>Our cakes</li>\n" +
                "        <li>Our stores</li>\n" +
                "    </ul>\n" +
                "    <li><a href=\"add-cake.sh\">Add cake</a></li>\n" +
                "    <li><a href=\"browse-cakes.sh\">Brose cakes</a></li>\n" +
                "    <li><a href=\"about-me.sh\">About us</a></li>\n" +
                "</ul>\n" +
                "<h2>Home</h2>\n" +
                "<h3>Our cakes</h3>\n" +
                "<p>Our cakes”, paragraph with text “Cake is a form of sweet dessert that is typically baked. In its oldest forms, cakes were modifications of breads, but cakes now cover a wide range of preparations that can be simple or elaborate, and that share features with other desserts such as pastries, meringues, custards, and pies</p>\n" +
                "<img src=\"/images/cake-img.jpg\" alt=\"cake-img\" width=\"250px\">\n" +
                "<h2>Our stores</h2>\n" +
                "<p>Our stores are located in 21 cities all over the world. Come and see what we have for you.” and a random cake store image.</p>\n" +
                "<img src=\"/images/cake-store.jpg\" alt=\"cake-store-img\" width=\"250px\">\n" +
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
