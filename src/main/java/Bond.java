
public class Bond {
    static String link = "https://www.bondstreet.ru/";

    public static void main(String[] args) throws InterruptedException {

        int a = 1;
        while (a == 1) {
//
//            BondStreet gameBondStreet = new BondStreet();
//            gameBondStreet.bondStreet();

            Fool gameFool = new Fool();
            gameFool.startFool();
            gameFool.logAndMail();
            gameFool.print();

            Thread.sleep(3600000);
        }
    }
}