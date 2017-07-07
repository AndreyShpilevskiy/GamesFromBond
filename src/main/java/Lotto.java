import com.mysql.fabric.jdbc.FabricMySQLDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Properties;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Lotto {

    static String[] lines;
    Date date = new Date();
    SignIn signIn = new SignIn();
    String note = " ";
    String logFileName = "Files/log_lotto.txt";
    String xPathButtonGameLotto = "/html/body/div[1]/div/div[3]/div[4]/div[2]/div[2]/div[2]/div/div[2]/a";
    String elementHover = "/html/body/div[1]/div/div[3]/div[4]/div[2]/div[2]/div[2]/div/div[2]";

    public String lotto() throws Exception {
        System.setProperty(Parameters.webDriver, Parameters.pathFileWebDriverFF);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        WebDriverWait wait = new WebDriverWait(driver, Parameters.timeOutWaitSec);
        Actions action = new Actions(driver);

        try{
            driver.get(Parameters.link);
            driver.findElement(By.id(Parameters.xPathEmailField)).clear(); // ввод логина
            driver.findElement(By.id(Parameters.xPathEmailField)).sendKeys(Parameters.login); // ввод логина
            driver.findElement(By.cssSelector(Parameters.xPathPasswordField)).clear(); // ввод пароля
            driver.findElement(By.cssSelector(Parameters.xPathPasswordField)).sendKeys(Parameters.password); //ввод пароля
            Thread.sleep(3000);
            driver.findElement(By.cssSelector(Parameters.xPathLoginButton)).click(); // клик на авторизоваться
            wait.until(visibilityOfElementLocated(By.xpath(Parameters.xPathButtonChat))); // клик на авторизоваться
            driver.findElement(By.xpath(Parameters.xPathButtonChat)).click(); // закрыть автоматически открывающийся чат
            wait.until(visibilityOfElementLocated(By.xpath(Parameters.xPathLogoMain)));
            signIn.s = "OK во время теста игры Лото "; // присвоение данных для передачи в запись лога
            note = Parameters.resOk;
            SignIn.logSignIn(); } // запуск записи лога
        catch (Exception e0) { // исключение, если не получилось try
            Parameters.resLotto = "BAD";
            driver.quit(); // закрываем драйвер
            signIn.s = "BAD во время теста игры Лото "; // присвоение данных для передачи в запись лога
            SignIn.logSignIn(); // запуск записи лога
            return note = Parameters.res; // присвоение нового занчения в переменню для записи в лог
        }

        try {
            wait.until(visibilityOfElementLocated(By.xpath(Parameters.xPathButtonGame))); // вход в раздел Игры
            driver.findElement(By.xpath(Parameters.xPathButtonGame)).click(); // вход в раздел Игры
            Thread.sleep(2000);
            WebElement element = driver.findElement(By.xpath(elementHover)); // скролл на элемент(div) поле с кнопкой Дурак
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element); // скролл на элемент(div), поле с кнопкой Дурак
            Thread.sleep(2000);
            action.build();
            action.moveToElement(driver.findElement(By.xpath(elementHover))).perform(); // ховер на элемент(div), поле с кнопкой Дурак
            wait.until(visibilityOfElementLocated(By.xpath(xPathButtonGameLotto))); // клик на кнопку Дурак, которая появилась после ховера
            driver.findElement(By.xpath(xPathButtonGameLotto)).click(); // клик на кнопку Дурак, которая появилась после ховера
            Thread.sleep(2000);
            driver.quit();
            return Parameters.resLotto = "OK";

        } catch (Exception e) {
            try {
                wait.until(visibilityOfElementLocated(By.xpath(Parameters.xPathButtonGame))); // вход в раздел Игры
                driver.findElement(By.xpath(Parameters.xPathButtonGame)).click(); // вход в раздел Игры
                Thread.sleep(2000);
                WebElement element = driver.findElement(By.xpath(elementHover)); // скролл на элемент(div) поле с кнопкой Дурак
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element); // скролл на элемент(div) поле с кнопкой Дурак
                Thread.sleep(2000);
                action.build();
                action.moveToElement(driver.findElement(By.xpath(elementHover))).perform(); // ховер на элемент(div) поле с кнопкой Дурак
                wait.until(visibilityOfElementLocated(By.xpath(xPathButtonGameLotto))); // клик на кнопку Дурак, которая появилась после ховера
                driver.findElement(By.xpath(xPathButtonGameLotto)).click(); // клик на кнопку Дурак, которая появилась после ховера

                Thread.sleep(2000);
                driver.quit();
                return Parameters.resLotto = "OK";

            } catch (Exception e1) {
                try {
                    Thread.sleep(10000);
                    wait.until(visibilityOfElementLocated(By.xpath(Parameters.xPathButtonGame))); // вход в раздел Игры
                    driver.findElement(By.xpath(Parameters.xPathButtonGame)).click(); // вход в раздел Игры
                    Thread.sleep(2000);
                    WebElement element = driver.findElement(By.xpath(elementHover)); // скролл на элемент(div) поле с кнопкой Дурак
                    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element); // скролл на элемент(div) поле с кнопкой Дурак
                    Thread.sleep(2000);
                    action.build();
                    action.moveToElement(driver.findElement(By.xpath(elementHover))).perform(); // ховер на элемент(div) поле с кнопкой Дурак
                    wait.until(visibilityOfElementLocated(By.xpath(xPathButtonGameLotto))); // клик на кнопку Дурак, которая появилась после ховера
                    driver.findElement(By.xpath(xPathButtonGameLotto)).click(); // клик на кнопку Дурак, которая появилась после ховера

                    Thread.sleep(2000);
                    driver.quit();
                    return Parameters.resLotto = "OK";

                } catch (Exception e2) {
                    driver.quit();
                    return Parameters.resLotto = "BAD";
                }
            }
        }
    }

    public void logLotto() throws IOException, MessagingException { // пишем лог в файл
        FileReader fr = new FileReader(logFileName);
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        String result = date.toString() + " Успешность запуска " + Parameters.resLotto +" " + note + Parameters.mail;
        while (str != null) {
            String lineSeparator = System.getProperty("line.separator");
            result += lineSeparator + str;
            str = br.readLine();
        }
        FileWriter fw = new FileWriter(logFileName);
        fw.write(result);
        fw.close();
        fr.close();
        br.close();
    }

    public void searchStatusLotto() throws IOException {

        FileInputStream fis = new FileInputStream(new File(logFileName)); // путь заменить на нужный
        byte[] content = new byte[fis.available()];
        fis.read(content);
        fis.close();
        lines = new String(content, "UTF-8").split("\n"); // кодировку указать нужную
        if (lines[0].indexOf(" BAD ") > -1) {Parameters.resLotto = "BAD";}
        if (lines[0].indexOf(" OK ") > -1) {Parameters.resLotto = "OK";}
    }

    public void logLottoBad() throws IOException, MessagingException { // пишем лог, когда все попытки неудачные
        FileReader fr = new FileReader(logFileName);
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        String result = date.toString() + " игра Лото не восстановилась на протяжении 10 попыток " + note;
        while (str != null) {
            String lineSeparator = System.getProperty("line.separator");
            result += lineSeparator + str;
            str = br.readLine();
        }
        FileWriter fw = new FileWriter(logFileName);
        fw.write(result);
        fw.close();
        fr.close();
        br.close();
    }

    Properties props = new Properties();
    public void mailLotto() throws IOException, MessagingException { // отправка уведомления о проблеме на почту
        if     (lines[0].indexOf("BAD") > -1&& lines[0].indexOf("NO") > -1&&
                lines[1].indexOf("BAD") > -1&& lines[1].indexOf("NO") > -1&&
                lines[2].indexOf("BAD") > -1&& lines[2].indexOf("NO") > -1&&
                lines[3].indexOf("BAD") > -1&& lines[3].indexOf("NO") > -1&&
                lines[4].indexOf("BAD") > -1&& lines[4].indexOf("NO") > -1&&
                lines[5].indexOf("BAD") > -1&& lines[5].indexOf("NO") > -1)
        {
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session s = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(Parameters.sendMail, Parameters.sendMailPassword);
                }
            });
            try {
                Message mess = new MimeMessage(s);
                mess.setFrom(new InternetAddress(Parameters.sendMail));
                String[] emails = Parameters.sendToMail;
                InternetAddress dests[] = new InternetAddress[emails.length];
                for (int i = 0; i < emails.length; i++) {
                    dests[i] = new InternetAddress(emails[i].trim().toLowerCase());
                }
                mess.setRecipients(Message.RecipientType.TO, dests);
                mess.setSubject("Автоест по игре Лото не прошел ");
                mess.setText("Автоест по игре Лото не прошел  " + note + date.toString());
                Transport.send(mess);
                Parameters.mail = "YES";
            } catch (Exception ex) {
                System.out.println("что то не то");
            }
        }
    }

    public void mailLottoOk() throws IOException, MessagingException { // отправка уведомления на почту если работа восстановлена

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session s = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Parameters.sendMail, Parameters.sendMailPassword);
            }
        });
        try {
            Message mess = new MimeMessage(s);
            mess.setFrom(new InternetAddress(Parameters.sendMail));
            String[] emails = Parameters.sendToMail;
            InternetAddress dests[] = new InternetAddress[emails.length];
            for (int i = 0; i < emails.length; i++) {
                dests[i] = new InternetAddress(emails[i].trim().toLowerCase());
            }
            mess.setRecipients(Message.RecipientType.TO, dests);
            mess.setSubject("Восстановление игры Лото ");
            mess.setText("Восстановление игры Лото  " + date.toString());
            Transport.send(mess);

        } catch (Exception ex) {
            System.out.println("что то не то");
        }
    }

    public void writeDB() throws IOException { //пишем данные в БД MySQL

        Connection connection;
        PreparedStatement preparedStatement;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(Parameters.URL, Parameters.Username, Parameters.Password);
            preparedStatement = connection.prepareStatement(Parameters.INSERT_NEW);
            preparedStatement.setLong(1, 0);
            preparedStatement.setString(2,"Lotto");
            preparedStatement.setString(3, Parameters.resLotto);
            preparedStatement.setString(4, note);
            preparedStatement.setString(5, date.toString());
            preparedStatement.setLong(6, date.getTime()); //преобразование даты и времени в TimeStamp
            preparedStatement.executeUpdate();

        }catch (Exception ex){
            System.out.println("что то не то");
        }
    }
}