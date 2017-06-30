public class Bond {

    static int a = 1; // для бесконечного цикла
    static int i = 0; // для for,

    public static void main(String[] args) throws Exception {

        while (a == 1) {

            bondChat();
            findBondStreet();
            fool();

//            SignIn.selectSQL();

        Thread.sleep(3600000);
        }
    }

    public static void fool () throws Exception {
        Fool gameFool = new Fool();
        gameFool.fool();
        gameFool.logFool();
        gameFool.writeDB();
        gameFool.mailFool();

        if(gameFool.s == "BAD") {
            for (gameFool.s.equals("BAD"); i < 10; i++) {
                if (gameFool.s == "BAD") {
                    gameFool.fool();
                    gameFool.logFool();
                }
            }
            if (gameFool.s == "OK") {
                gameFool.mailFoolOk();
            }
            else gameFool.logFoolBad();
        }
    }

    public static void findBondStreet() throws Exception {
        BondStreet gameBondStreet = new BondStreet();
        gameBondStreet.bondStreet();
        gameBondStreet.logBondStreet();
        gameBondStreet.writeDB();
        gameBondStreet.mailBondStreet();

        if (gameBondStreet.s == "BAD") {
            for (gameBondStreet.s.equals("BAD"); i < 10; i++) {
                if (gameBondStreet.s == "BAD") {
                    gameBondStreet.bondStreet();
                    gameBondStreet.logBondStreet();
                }
            }
            if (gameBondStreet.s == "OK") {
                gameBondStreet.mailBondStreetOk();
            }
            else gameBondStreet.logBondStreetBad();
        }
    }

    public static void bondChat() throws Exception {
        BondChat gameBondChat = new BondChat();
        gameBondChat.bondChat();
        gameBondChat.logBondChat();
        gameBondChat.writeDB();
        gameBondChat.mailBondChat();

        if(gameBondChat.s == "BAD") {
            for (gameBondChat.s.equals("BAD"); i < 10; i++) {
                if (gameBondChat.s == "BAD") {
                    gameBondChat.bondChat();
                    gameBondChat.logBondChat();
                }
            }
            if (gameBondChat.s == "OK") {
                gameBondChat.mailBondChatOk();
            }
            else gameBondChat.logBondChatBad();
        }
    }
}



