public class Bond {

    static int a = 1; // для бесконечного цикла

    public static void main(String[] args) throws Exception {

        while (a == 1) {

            bondChat();
            findBondStreet();
            fool();
            lotto();

//            SignIn.selectSQL();

            Thread.sleep(300000);
        }
    }

    public static void bondChat() throws Exception {
        BondChat gameBondChat = new BondChat();
        if (Parameters.resChat.equals("OK")) {
            gameBondChat.bondChat();

            if (Parameters.resChat == "BAD") {
                gameBondChat.logBondChat();
                gameBondChat.mailBondChat();
                gameBondChat.writeDB();
            }
        }

        if (Parameters.resChat != ("OK")) {
            for (int i = 0; i < 5; i++) {
                if (Parameters.resChat != ("OK")) gameBondChat.bondChat();

                if (Parameters.resChat == "OK") {
                    i = 10;
                    BondChat.note = Parameters.resOk;
                    Parameters.resChat = "OK";
                    gameBondChat.mailBondChatOk();
                    gameBondChat.logBondChat();
                    gameBondChat.writeDB();
                }
            }
        }
    }

    public static void findBondStreet() throws Exception {
        BondStreet gameBondStreet = new BondStreet();
        if (Parameters.resFindBondStreet.equals("OK")) {
            gameBondStreet.bondStreet();

            if (Parameters.resFindBondStreet == "BAD") {
                gameBondStreet.logBondStreet();
                gameBondStreet.mailBondStreet();
                gameBondStreet.writeDB();
            }
        }

        if (Parameters.resFindBondStreet != ("OK")) {
            for (int i = 0; i < 5; i++) {
                if (Parameters.resFindBondStreet != ("OK")) gameBondStreet.bondStreet();

                if (Parameters.resFindBondStreet == "OK") {
                    i = 10;
                    gameBondStreet.note = Parameters.resOk;
                    Parameters.resFindBondStreet = "OK";
                    gameBondStreet.mailBondStreetOk();
                    gameBondStreet.logBondStreet();
                    gameBondStreet.writeDB();
                }
            }
        }
    }

    public static void fool() throws Exception {
        Fool gameFool = new Fool();
        if (Parameters.resFool.equals("OK")) {
            gameFool.fool();

            if (Parameters.resFool == "BAD") {
                gameFool.logFool();
                gameFool.mailFool();
                gameFool.writeDB();
            }
        }

        if (Parameters.resFool != ("OK")) {
            for (int i =0; i < 5; i++) {
                if (Parameters.resFool != ("OK")) gameFool.fool();

                if (Parameters.resFool == "OK") {
                    i = 10;
                    gameFool.note = Parameters.resOk;
                    Parameters.resFool = "OK";
                    gameFool.mailFoolOk();
                    gameFool.logFool();
                    gameFool.writeDB();
                }
            }
        }
    }

    public static void lotto() throws Exception {
        Lotto gameLotto = new Lotto();
        if (Parameters.resLotto.equals("OK")) {
            gameLotto.lotto();

            if (Parameters.resLotto == "BAD") {
                gameLotto.logLotto();
                gameLotto.mailLotto();
                gameLotto.writeDB();
            }
        }

        else if (Parameters.resLotto != ("OK")) {
            for (int i = 0; i < 5; i++) {
                if (Parameters.resLotto != ("OK")) gameLotto.lotto();

                if (Parameters.resLotto == "OK") {
                    i = 10;
                    gameLotto.note = Parameters.resOk;
                    Parameters.resLotto = "OK";
                    gameLotto.mailLottoOk();
                    gameLotto.logLotto();
                    gameLotto.writeDB();
                }
            }
        }
    }
}