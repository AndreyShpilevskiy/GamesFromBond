/*
    Все пояснения к коду записаны в классе Fool
 */

public class Parameters {

    // Авторизация
    static String link = "https://www.bondstreet.ru/";
    static String login = "vkfbok@mail.ru";
    static String password = "11111111";
    static String xPathLoginButton = "button.btn--red.btn--x3.login_button";
    static String xPathEmailField = "main-email";
    static String xPathPasswordField = "input.auth-password";
    static String xPathLogoMain = "/html/body/div[1]/div/div[3]/div[1]/a";

    // Скрывать/открывать чат
    static String xPathButtonChat = "/html/body/div[1]/div/div[3]/div[1]/div[3]/div[2]/div[2]/a";

    //Кнопка Игры на главной
    static String xPathButtonGame = "/html/body/div[1]/div/div[3]/div[1]/div[1]/a[3]";

    //Driver
    static String webDriver = "webdriver.gecko.driver";
    static String pathFileWebDriverFF = "Files/geckodriver.exe";
    static int timeOutWaitSec = 90;


    // Отправка писем
    static String sendMail = "devup2012@gmail.com";
    static String sendMailPassword = "upupDevelup404!";
    static String[] sendToMail = {"as@develup.pro, ek@develup.pro"}; //
    static String mail = "NO";

    //Note
    static String res = "Failed";
    static String resOk = "Passed";

    //SQL
    static final String URL = "jdbc:mysql://185.69.152.87:3306";
    static final String Username = "dvlptest";
    static final String Password = "dvlptest";
    static final String INSERT_NEW = "INSERT INTO dvlptest.BondStreet VALUES(?, ?, ? , ? , ?, ?);";
    static final String SELECT = "select * from dvlptest.BondStreet;";

    // Start data
    static String resChat;
    static String resFindBondStreet;
    static String resFool;
    static String resLotto;

}
