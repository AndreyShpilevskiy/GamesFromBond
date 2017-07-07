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
        gameBondChat.searchStatusBondChat();
        if (Parameters.resChat == "OK") {
            gameBondChat.bondChat();

            if (Parameters.resChat == "BAD") {
                gameBondChat.logBondChat();
                gameBondChat.mailBondChat();
                gameBondChat.writeDB();
            }
        }

        else if (Parameters.resChat == "BAD") {
            for (int i = 0; i < 5; i++) {
                if (Parameters.resChat == "BAD") gameBondChat.bondChat();

                else if (Parameters.resChat == "OK") {
                    i = 10;
                    BondChat.note = Parameters.resOk;
                    Parameters.resChat = "OK";
                    gameBondChat.mailBondChatOk();
                    gameBondChat.logBondChat();
                    gameBondChat.writeDB();
                }
            }if (Parameters.mail == "YES") {gameBondChat.logBondChat();}
        }
    }

    public static void findBondStreet() throws Exception {
        BondStreet gameBondStreet = new BondStreet();
        gameBondStreet.searchStatusBondStreet();
        if (Parameters.resFindBondStreet == "OK") {
            gameBondStreet.bondStreet();

            if (Parameters.resFindBondStreet == "BAD") {
                gameBondStreet.logBondStreet();
                gameBondStreet.mailBondStreet();
                gameBondStreet.writeDB();
            }
        }

        else if (Parameters.resFindBondStreet == "BAD") {
            for (int i = 0; i < 5; i++) {
                if (Parameters.resFindBondStreet == "BAD") gameBondStreet.bondStreet();

                else if (Parameters.resFindBondStreet == "OK") {
                    i = 10;
                    gameBondStreet.note = Parameters.resOk;
                    Parameters.resFindBondStreet = "OK";
                    gameBondStreet.mailBondStreetOk();
                    gameBondStreet.logBondStreet();
                    gameBondStreet.writeDB();
                }
            }if (Parameters.mail == "YES") {gameBondStreet.logBondStreet();}
        }
    }

    public static void fool() throws Exception {
        Fool gameFool = new Fool();
        gameFool.searchStatusFool();
        if (Parameters.resFool == "OK") {
            gameFool.fool();

            if (Parameters.resFool == "BAD") {
                gameFool.logFool();
                gameFool.mailFool();
                gameFool.writeDB();
            }
        }

        else if (Parameters.resFool == "BAD") {
            for (int i =0; i < 5; i++) {
                if (Parameters.resFool == "BAD") gameFool.fool();

                else if (Parameters.resFool == "OK") {
                    i = 10;
                    gameFool.note = Parameters.resOk;
                    Parameters.resFool = "OK";
                    gameFool.mailFoolOk();
                    gameFool.logFool();
                    gameFool.writeDB();
                }
            }if (Parameters.mail == "YES") {gameFool.logFool();}
        }
    }

    public static void lotto() throws Exception {
        Lotto gameLotto = new Lotto();
        gameLotto.searchStatusLotto();
        if (Parameters.resLotto == "OK") {
            gameLotto.lotto();

            if (Parameters.resLotto == "BAD") {
                gameLotto.logLotto();
                gameLotto.mailLotto();
                gameLotto.writeDB();
            }
        }

        else if (Parameters.resLotto == "BAD") {
            for (int i = 0; i < 5; i++) {
                if (Parameters.resLotto == "BAD") gameLotto.lotto();

                else if (Parameters.resLotto == "OK") {
                    i = 10;
                    gameLotto.note = Parameters.resOk;
                    Parameters.resLotto = "OK";
                    gameLotto.mailLottoOk();
                    gameLotto.logLotto();
                    gameLotto.writeDB();
                }
            }if (Parameters.mail == "YES") {gameLotto.logLotto();}
        }
    }
}