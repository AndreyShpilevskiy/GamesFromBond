import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.Properties;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BondStreet {
    Date date = new Date();
    static String[] lines;
    long time;
    SignIn signIn = new SignIn();
    String note = " ";
    String logFileName = "Files/log_bondStreet.txt";
    String cssSecondClick = "html.scotland-yard.page-game.dev.desktop.html-landscape body footer.b-footer div.b-footer__title p a";
    String elementHover = "/html/body/div[1]/div/div[3]/div[4]/div[2]/div[2]/div[2]/div/div[12]";
    String xPathButtonGameFindBondStreet = "/html/body/div[1]/div/div[3]/div[4]/div[2]/div[2]/div[2]/div/div[12]/a/div";


    public String bondStreet() throws Exception {
        System.setProperty(Parameters.webDriver, Parameters.pathFileWebDriverFF);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        WebDriverWait wait = new WebDriverWait(driver, Parameters.timeOutWaitSec);
        Actions action = new Actions(driver);

        try {
        driver.get(Parameters.link);
        driver.findElement(By.id(Parameters.xPathEmailField)).clear();
        driver.findElement(By.id(Parameters.xPathEmailField)).sendKeys(Parameters.login);
        driver.findElement(By.cssSelector(Parameters.xPathPasswordField)).clear();
        driver.findElement(By.cssSelector(Parameters.xPathPasswordField)).sendKeys(Parameters.password);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(Parameters.xPathLoginButton)).click();
        wait.until(visibilityOfElementLocated(By.xpath(Parameters.xPathButtonChat)));
        driver.findElement(By.xpath(Parameters.xPathButtonChat)).click();
        wait.until(visibilityOfElementLocated(By.xpath(Parameters.xPathLogoMain)));

        signIn.s = "OK во время теста Поиск BondStreet ";
        note = Parameters.resOk;
        SignIn.logSignIn(); }
            catch (Exception e0) {
                Parameters.resFindBondStreet = "BAD";
                driver.quit();
                signIn.s = "BAD во время теста Поиск BondStreet ";
                SignIn.logSignIn();
                return note = Parameters.res;
            }

            try {
                wait.until(visibilityOfElementLocated(By.xpath(Parameters.xPathButtonGame))); // вход в раздел Игры
                driver.findElement(By.xpath(Parameters.xPathButtonGame)).click(); // вход в раздел Игры
                Thread.sleep(2000);
                WebElement element = driver.findElement(By.xpath(elementHover)); // скролл на элемент(div) поле с кнопкой Бондстриит
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element); // скролл на элемент(div), поле с кнопкой Бондстриит
                Thread.sleep(2000);
                action.build();
                action.moveToElement(driver.findElement(By.xpath(elementHover))).perform(); // ховер на элемент(div), поле с кнопкой Бондстриит
                wait.until(visibilityOfElementLocated(By.xpath(xPathButtonGameFindBondStreet))); // клик на кнопку Бондстриит, которая появилась после ховера
                driver.findElement(By.xpath(xPathButtonGameFindBondStreet)).click(); // клик на кнопку Бондстриит, которая появилась после ховера
                wait.until(visibilityOfElementLocated(By.cssSelector(cssSecondClick)));
                driver.findElement(By.cssSelector(cssSecondClick));
                Thread.sleep(2000);
                driver.quit();
                return Parameters.resFindBondStreet = "OK";

            } catch (Exception e) {
                try {
                    wait.until(visibilityOfElementLocated(By.xpath(Parameters.xPathButtonGame))); // вход в раздел Игры
                    driver.findElement(By.xpath(Parameters.xPathButtonGame)).click(); // вход в раздел Игры
                    Thread.sleep(2000);
                    WebElement element = driver.findElement(By.xpath(elementHover)); // скролл на элемент(div) поле с кнопкой Бондстриит
                    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element); // скролл на элемент(div), поле с кнопкой Бондстриит
                    Thread.sleep(2000);
                    action.build();
                    action.moveToElement(driver.findElement(By.xpath(elementHover))).perform(); // ховер на элемент(div), поле с кнопкой Бондстриит
                    wait.until(visibilityOfElementLocated(By.xpath(xPathButtonGameFindBondStreet))); // клик на кнопку Бондстриит, которая появилась после ховера
                    driver.findElement(By.xpath(xPathButtonGameFindBondStreet)).click(); // клик на кнопку Бондстриит, которая появилась после ховера
                    wait.until(visibilityOfElementLocated(By.cssSelector(cssSecondClick)));
                    driver.findElement(By.cssSelector(cssSecondClick));
                    Thread.sleep(2000);
                    driver.quit();
                    return Parameters.resFindBondStreet = "OK";

                } catch (Exception e1) {
                    try {
                        Thread.sleep(10000);
                        wait.until(visibilityOfElementLocated(By.xpath(Parameters.xPathButtonGame))); // вход в раздел Игры
                        driver.findElement(By.xpath(Parameters.xPathButtonGame)).click(); // вход в раздел Игры
                        Thread.sleep(2000);
                        WebElement element = driver.findElement(By.xpath(elementHover)); // скролл на элемент(div) поле с кнопкой Бондстриит
                        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element); // скролл на элемент(div), поле с кнопкой Бондстриит
                        Thread.sleep(2000);
                        action.build();
                        action.moveToElement(driver.findElement(By.xpath(elementHover))).perform(); // ховер на элемент(div), поле с кнопкой Бондстриит
                        wait.until(visibilityOfElementLocated(By.xpath(xPathButtonGameFindBondStreet))); // клик на кнопку Бондстриит, которая появилась после ховера
                        driver.findElement(By.xpath(xPathButtonGameFindBondStreet)).click(); // клик на кнопку Бондстриит, которая появилась после ховераcondClick)));
                        driver.findElement(By.cssSelector(cssSecondClick));
                        Thread.sleep(2000);
                        driver.quit();
                        return Parameters.resFindBondStreet = "OK";

                    } catch (Exception e2) {
                        driver.quit();
                        return Parameters.resFindBondStreet = "BAD";
                    }
                }
            }
        }

    public void logBondStreet() throws IOException, MessagingException {
        FileReader fr = new FileReader(logFileName);
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        String result = date.toString() + " Успешность запуска " + Parameters.resFindBondStreet + " " + note + Parameters.mail;
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

    public void searchStatusBondStreet() throws IOException {

        FileInputStream fis = new FileInputStream(new File(logFileName)); // путь заменить на нужный
        byte[] content = new byte[fis.available()];
        fis.read(content);
        fis.close();
        lines = new String(content, "UTF-8").split("\n"); // кодировку указать нужную
        System.out.println(lines[0]);
        if (lines[0].indexOf(" BAD ") > -1) { Parameters.resFindBondStreet = "BAD";}
        if (lines[0].indexOf(" OK ")> -1) {Parameters.resFindBondStreet = "OK";}
    }

    public void logBondStreetBad() throws IOException, MessagingException {
        FileReader fr = new FileReader(logFileName);
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        String result = date.toString() + " игра Поиск BondStreet не восстановилась на протяжении 10 попыток "+ note;
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

    public void mailBondStreet() throws IOException, MessagingException {
        if     (lines[0].indexOf("BAD") > -1&& lines[0].indexOf("NO") > -1&&
                lines[1].indexOf("BAD") > -1&& lines[1].indexOf("NO") > -1&&
                lines[2].indexOf("BAD") > -1&& lines[2].indexOf("NO") > -1&&
                lines[3].indexOf("BAD") > -1&& lines[3].indexOf("NO") > -1&&
                lines[4].indexOf("BAD") > -1&& lines[4].indexOf("NO") > -1&&
                lines[5].indexOf("BAD") > -1&& lines[5].indexOf("NO") > -1)
        {

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session s = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Parameters.sendMail, Parameters.sendMailPassword); }});
            try{
                Message mess = new MimeMessage(s);
                mess.setFrom(new InternetAddress(Parameters.sendMail));
                String[] emails = Parameters.sendToMail;//
                InternetAddress dests[] = new InternetAddress[emails.length];
                for(int i=0; i<emails.length; i++){
                    dests[i]=new InternetAddress(emails[i].trim().toLowerCase());}
                mess.setRecipients(Message.RecipientType.TO, dests);
                mess.setSubject("Автотест по игре Поиск BondStreet не прошел ");
                mess.setText("Автотест по игре Поиск BondStreet не прошел  " + note + date.toString());
                Transport.send(mess);
                Parameters.mail = "YES";
            }catch (Exception ex){
                System.out.println("что то не то");
            }
        }
    }

    public void mailBondStreetOk() throws IOException, MessagingException {

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session s = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(Parameters.sendMail, Parameters.sendMailPassword); }});
            try{
                Message mess = new MimeMessage(s);
                mess.setFrom(new InternetAddress(Parameters.sendMail));
                String[] emails = Parameters.sendToMail;
                InternetAddress dests[] = new InternetAddress[emails.length];
                for(int i=0; i<emails.length; i++){
                    dests[i]=new InternetAddress(emails[i].trim().toLowerCase());}
                mess.setRecipients(Message.RecipientType.TO, dests);
                mess.setSubject("Восстановление игры Поиск BondStreet ");
                mess.setText("Восстановление игры Поиск BondStreet  " + date.toString());
                Transport.send(mess);

            }catch (Exception ex){
                System.out.println("что то не то");
            }
        }

    public void writeDB() throws IOException {

        Connection connection;
        PreparedStatement preparedStatement;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(Parameters.URL, Parameters.Username, Parameters.Password);
            preparedStatement = connection.prepareStatement(Parameters.INSERT_NEW);
            preparedStatement.setLong(1, 0);
            preparedStatement.setString(2,"FindBondstreet");
            preparedStatement.setString(3, Parameters.resFindBondStreet);
            preparedStatement.setString(4, note);
            preparedStatement.setString(5, date.toString());
            preparedStatement.setLong(6, time = date.getTime());
            preparedStatement.executeUpdate();

        }catch (Exception ex){
            System.out.println("что то не то");
        }
    }
}






