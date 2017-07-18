/*
    Все пояснения к коду записаны в классе Fool
 */

public class Parameters {

    // Авторизация
    static String link = "https://www.bondstreet.ru/";
    static String login = "логин/пароль";
    static String password = "логин/пароль";
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
    static String sendMail = "логин/пароль";
    static String sendMailPassword = "логин/пароль";
    static String[] sendToMail = {"логин/пароль, логин/пароль"}; //
    static String mail = "NO";

    //Note
    static String res = "Failed";
    static String resOk = "Passed";

    //SQL
    static final String URL = "jdbc:mysql://адрес";
    static final String Username = "логин/пароль";
    static final String Password = "логин/пароль";
    static final String INSERT_NEW = "INSERT INTO dvlptest.BondStreet VALUES(?, ?, ? , ? , ?, ?);";
    static final String SELECT = "select * from dvlptest.BondStreet;";

    // Start data
    static String resChat;
    static String resFindBondStreet;
    static String resFool;
    static String resLotto;

}
