
public class Bond {
    static String link = "https://www.bondstreet.ru/";

    public static void main(String[] args) throws InterruptedException {

//        System.setProperty("webdriver.gecko.driver", "C://IT/Test/geckodriver.exe");
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette", true);
//        WebDriver driver = new FirefoxDriver(capabilities);
//        WebDriverWait wait = new WebDriverWait(driver, 40);

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