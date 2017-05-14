package Email;

/**
 * Created by Андрей on 14.05.2017.
 */

public class SendEmail {
    private static Sender tlsSender = new Sender("redkovskiyandrey@gmail.com", "Andrey_231097");

    public static void sendEmail(String adress, String result) {
        tlsSender.send("Hotel Albatros", result, "redkovskiyandrey@gmail.com", adress);
    }
}