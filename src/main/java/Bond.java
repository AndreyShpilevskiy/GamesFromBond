
public class Bond {
    static String link = "https://www.bondstreet.ru/";


    public static void main(String[] args) throws Exception {

        int a = 1; // для бесконечного цикла
        int i = 0; // для for,
        while (a == 1) {


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

        Thread.sleep(3600000);

        }
    }
}



