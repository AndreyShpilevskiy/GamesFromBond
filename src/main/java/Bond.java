
public class Bond {
    static String link = "https://www.bondstreet.ru/";

    public static void main(String[] args) throws InterruptedException {

        int a = 1;
        while (a == 1) {

            BondStreet gameBondStreet = new BondStreet();
            gameBondStreet.bondStreet();

            Fool gameFool = new Fool();
            gameFool.fool();

            Thread.sleep(3000000);
        }
    }
}