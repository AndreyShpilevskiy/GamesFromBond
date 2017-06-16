import javax.mail.MessagingException;
import java.io.IOException;

public class Bond {
    static String link = "https://www.bondstreet.ru/";
    static int a = 1; // для бесконечного цикла
    static int i = 0; // для for,

    public static void main(String[] args) throws Exception {

        while (a == 1) {
            findBondStreet();
            fool();
            bondChat();

        Thread.sleep(3600000);
        }
    }

    public static void findBondStreet() throws InterruptedException, IOException, MessagingException {
        BondStreet gameBondStreet = new BondStreet();
        gameBondStreet.bondStreet();
        gameBondStreet.logBondStreet();
        gameBondStreet.mailBondStreet();
        if (gameBondStreet.s == "BAD") {
            for (gameBondStreet.s.equals("BAD"); i < 15; i++) {
                if (gameBondStreet.s == "BAD") {
                    gameBondStreet.bondStreet();
                    gameBondStreet.logBondStreet();
                }
            }
            if (gameBondStreet.s == "OK") {
                gameBondStreet.mailBondStreetOk();
            }
        }
    }
    public static void fool () throws InterruptedException, IOException, MessagingException {
        Fool gameFool = new Fool();
        gameFool.fool();
        gameFool.logFool();
        gameFool.mailFool();

        if(gameFool.s == "BAD") {
            for (gameFool.s.equals("BAD"); i < 15; i++) {
                if (gameFool.s == "BAD") {
                    gameFool.fool();
                    gameFool.logFool(); } }
            if (gameFool.s == "OK") {
                gameFool.mailFoolOk();
            }
        }
    }
    public static void bondChat() throws Exception {
        BondChat gameBondChat = new BondChat();
        gameBondChat.bondChat();
        gameBondChat.logBondChat();
        gameBondChat.mailBondChat();

        if(gameBondChat.s == "BAD") {
            for (gameBondChat.s.equals("BAD"); i < 15; i++) {
                if (gameBondChat.s == "BAD") {
                    gameBondChat.bondChat();
                    gameBondChat.logBondChat(); } }
            if (gameBondChat.s == "OK") {
                gameBondChat.mailBondChatOk();
            }
        }
    }
}



