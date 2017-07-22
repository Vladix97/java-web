package bootstrapPage;

import util.Util;

import java.io.IOException;

/**
 * Created by vladix on 7/21/17.
 */
public class Page {

    public static void main(String[] args) {

        setContent();
        setHtml();
    }

    private static void setContent() {
        String type = "Content-Type: text/html\n\n";
        System.out.println(type);
    }

    private static void setHtml() {
        try {
            String html =
                    Util.readFile("/home/vladix/Programmig/JavaWeb/JavaWebDevelopmentBasics/03.StateManagement/StateManagementHomework/src/main/resources/html/index.html");
            System.out.println(html);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
