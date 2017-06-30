/*
    Все пояснения к коду записаны в классе Fool
 */

public class Parameters {

    // Авторизация
    static String link = "Логин/Пароль";
    static String login = "Логин/Пароль";
    static String password = "Логин/Пароль";
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
    static String sendMail = "Логин/Пароль";
    static String sendMailPassword = "Логин/Пароль!";
    static String[] sendToMail = {"Логин/Пароль", "Логин/Пароль"};

    //Note
    static String res = " cant authorization BondStreet ";
    static String resOk = " authorization after Failed ";

    //SQL
    static final String URL = "Логин/Пароль";
    static final String Username = "Логин/Пароль";
    static final String Password = "Логин/Пароль";
    static final String INSERT_NEW = "INSERT INTO dvlptest.BondStreet VALUES(?, ?, ? , ? , ?, ?);";
    static final String SELECT = "select * from dvlptest.BondStreet;";

    static String chatStart = "OK";

}
