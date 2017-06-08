
public class Bond {


    public static void main(String[] args) throws InterruptedException {

//        System.setProperty("webdriver.gecko.driver", "C://IT/Test/geckodriver.exe");
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette", true);
//        WebDriver driver = new FirefoxDriver(capabilities);
//        WebDriverWait wait = new WebDriverWait(driver, 40);
        int a = 1;
        while (a == 1) {

            BondStreet gameBondStreet = new BondStreet();
            String street = "";
            gameBondStreet.bondStreet(street);

            Fool gameFool = new Fool();
            String fool = "";
            gameFool.fool(fool);

            Thread.sleep(3600000);
        }
    }
}