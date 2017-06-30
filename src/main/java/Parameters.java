/*
    Все пояснения к коду записаны в классе Fool
 */

public class Parameters {

    // Авторизация
    static String link = "ЛОГИН/ПАРОЛЬ";
    static String login = "ЛОГИН/ПАРОЛЬ";
    static String password = "ЛОГИН/ПАРОЛЬ";
    static String xPathLoginButton = "button.btn--red.btn--x3.login_button";
    static String xPathEmailField = "main-email";
    static String xPathPasswordField = "input.auth-password";

    // Скрывать/открывать чат
    static String xPathButtonChat = "/html/body/div[1]/div/div[3]/div[1]/div[3]/div[2]/div[2]/a";

    //Кнопка Игры на главной
    static String xPathButtonGame = "/html/body/div[1]/div/div[3]/div[1]/div[1]/a[3]";

    //Driver
    static String webDriver = "webdriver.gecko.driver";
    static String pathFileWebDriverFF = "C://IT/Test/geckodriver.exe";

    // Отправка писем
    static String sendMail = "devup2012@gmail.com";
    static String sendMailPassword = "upupDevelup404!";
    static String[] sendToMail = {"as@develup.pro", "ek@develup.pro"};

    //Note
    static String res = " cant authorization BondStreet ";

    //SQL
    static final String URL = "ЛОГИН/ПАРОЛЬ";
    static final String Username = "ЛОГИН/ПАРОЛЬ";
    static final String Password = "ЛОГИН/ПАРОЛЬ";
    static final String INSERT_NEW = "INSERT INTO dvlptest.BondStreet VALUES(?, ?, ? , ? , ?, ?);";
    static final String SELECT = "select * from dvlptest.BondStreet;";

}
