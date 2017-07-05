/*
    Все пояснения к коду записаны в классе Fool
 */

public class Parameters {

    // Авторизация
    static String link = "Твои данные";
    static String login = "Твои данные";
    static String password = "Твои данные";
    static String xPathLoginButton = "button.btn--red.btn--x3.login_button";
    static String xPathEmailField = "main-email";
    static String xPathPasswordField = "input.auth-password";

    // Скрывать/открывать чат
    static String xPathButtonChat = "/html/body/div[1]/div/div[3]/div[1]/div[3]/div[2]/div[2]/a";

    //Кнопка Игры на главной
    static String xPathButtonGame = "/html/body/div[1]/div/div[3]/div[1]/div[1]/a[3]";

    //Driver
    static String webDriver = "webdriver.gecko.driver";
    static String pathFileWebDriverFF = "Files/geckodriver.exe";


    // Отправка писем
    static String sendMail = "Твои данные";
    static String sendMailPassword = "Твои данные";
    static String[] sendToMail = {"Твои данные"};

    //Note
    static String res = "Failed";
    static String resOk = "Passed";

    //SQL
    static final String URL = "Твои данные";
    static final String Username = "Твои данные";
    static final String Password = "Твои данные";
    static final String INSERT_NEW = "INSERT INTO dvlptest.BondStreet VALUES(?, ?, ? , ? , ?, ?);";
    static final String SELECT = "select * from dvlptest.BondStreet;";

    // Start data
    static String resChat = "OK";
    static String resFindBondStreet = "OK";
    static String resFool = "OK";
    static String resLotto = "OK";

}
