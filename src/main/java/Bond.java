import javax.mail.MessagingException;
import java.io.IOException;

public class Bond {
    static String link = "https://www.bondstreet.ru/";

    public static void main(String[] args) throws Exception {

        int a = 1;
        while (a == 1) {

            BondStreet gameBondStreet = new BondStreet();
            gameBondStreet.bondStreet();
            gameBondStreet.logAndMailBondStreet();

            Fool gameFool = new Fool();
            gameFool.startFool();
            gameFool.logAndMailFool();

            BondChat gameBondChat = new BondChat();
            gameBondChat.bondChat();
            gameBondChat.logAndMailBondChat();


            Thread.sleep(3600000);
        }
    }
}