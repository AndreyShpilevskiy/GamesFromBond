public class Bond {

    static int a = 1; // для бесконечного цикла
    static int i = 0; // для for,

    public static void main(String[] args) throws Exception {

        while (a == 1) {

            bondChat();
            findBondStreet();
            fool();
            lotto();

//            SignIn.selectSQL();

        Thread.sleep(600000);
        }
    }

    public static void bondChat() throws Exception {
        BondChat gameBondChat = new BondChat();
        gameBondChat.bondChat();
        gameBondChat.logBondChat();
        gameBondChat.mailBondChat();

        if(gameBondChat.s == "BAD") {
            gameBondChat.writeDB();
            for (gameBondChat.s.equals("BAD"); i < 10; i++) {
                if (gameBondChat.s == "BAD") {
                    gameBondChat.bondChat();
                    gameBondChat.logBondChat();
                }
            }
            if (gameBondChat.s == "OK") {
                BondChat.note = Parameters.resOk;
                gameBondChat.s = "OK";
                gameBondChat.mailBondChatOk();
                gameBondChat.writeDB();
            }
            else gameBondChat.logBondChatBad();
        }
    }

    public static void findBondStreet() throws Exception {
        BondStreet gameBondStreet = new BondStreet();
        gameBondStreet.bondStreet();
        gameBondStreet.logBondStreet();
        gameBondStreet.mailBondStreet();

        if (gameBondStreet.s == "BAD") {
            gameBondStreet.writeDB();
            for (gameBondStreet.s.equals("BAD"); i < 10; i++) {
                if (gameBondStreet.s == "BAD") {
                    gameBondStreet.bondStreet();
                    gameBondStreet.logBondStreet();
                }
            }
            if (gameBondStreet.s == "OK") {
                gameBondStreet.note = Parameters.resOk;
                gameBondStreet.s = "OK";
                gameBondStreet.mailBondStreetOk();
                gameBondStreet.writeDB();
            }
            else gameBondStreet.logBondStreetBad();
        }
    }

    public static void fool () throws Exception {
        Fool gameFool = new Fool();
        gameFool.fool();
        gameFool.logFool();
        gameFool.mailFool();

        if(gameFool.s == "BAD") {
            gameFool.writeDB();
            for (gameFool.s.equals("BAD"); i < 10; i++) {
                if (gameFool.s == "BAD") {
                    gameFool.fool();
                    gameFool.logFool();
                }
            }
            if (gameFool.s == "OK") {
                gameFool.note = Parameters.resOk;
                gameFool.s = "OK";
                gameFool.mailFoolOk();
                gameFool.writeDB();
            }
            else gameFool.logFoolBad();
        }
    }

    public static void lotto() throws Exception {
        Lotto gameLotto = new Lotto();
        gameLotto.lotto();
        gameLotto.logLotto();
        gameLotto.mailLotto();

        if(gameLotto.s == "BAD") {
            gameLotto.writeDB();
            for (gameLotto.s.equals("BAD"); i < 10; i++) {
                if (gameLotto.s == "BAD") {
                    gameLotto.lotto();
                    gameLotto.logLotto();
                }
            }
            if (gameLotto.s == "OK") {
                gameLotto.note = Parameters.resOk;
                gameLotto.s = "OK";
                gameLotto.mailLottoOk();
                gameLotto.writeDB();
            }
            else gameLotto.logLottoBad();
        }
    }
}



