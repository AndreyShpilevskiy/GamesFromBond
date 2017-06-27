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
import java.util.Date;
import java.util.Properties;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Fool {



    String s;
    String logFileName = "C:\\work\\log_fool.txt";
    String xPathButtonGameFool = "/html/body/div[1]/div/div[3]/div[4]/div[2]/div[2]/div[2]/div/div[3]/a/div";
    String elementHover = "/html/body/div[1]/div/div[3]/div[4]/div[2]/div[2]/div[2]/div/div[3]";

    public String fool() throws InterruptedException {
        System.setProperty(Parameters.webDriver, Parameters.pathFileWebDriverFF);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        Actions action = new Actions(driver);

        driver.get(Parameters.link);
        driver.findElement(By.id(Parameters.xPathEmailField)).clear(); // ввод логина
        driver.findElement(By.id(Parameters.xPathEmailField)).sendKeys(Parameters.login); // ввод логина
        driver.findElement(By.cssSelector(Parameters.xPathPasswordField)).clear(); // ввод пароля
        driver.findElement(By.cssSelector(Parameters.xPathPasswordField)).sendKeys(Parameters.password); //ввод пароля
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(Parameters.xPathLoginButton)).click(); // клик на авторизоваться
        wait.until(visibilityOfElementLocated(By.xpath(Parameters.xPathButtonChat))); // клик на авторизоваться
        driver.findElement(By.xpath(Parameters.xPathButtonChat)).click(); // закрыть автоматически открывающийся чат

        try {
            wait.until(visibilityOfElementLocated(By.xpath(Parameters.xPathButtonGame))); // вход в раздел Игры
            driver.findElement(By.xpath(Parameters.xPathButtonGame)).click(); // вход в раздел Игры
            Thread.sleep(2000);
            WebElement element = driver.findElement(By.xpath(elementHover)); // скролл на элемент(div) поле с кнопкой Дурак
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element); // скролл на элемент(div), поле с кнопкой Дурак
            Thread.sleep(2000);
            action.build();
            action.moveToElement(driver.findElement(By.xpath(elementHover))).perform(); // ховер на элемент(div), поле с кнопкой Дурак
            wait.until(visibilityOfElementLocated(By.xpath(xPathButtonGameFool))); // клик на кнопку Дурак, которая появилась после ховера
            driver.findElement(By.xpath(xPathButtonGameFool)).click(); // клик на кнопку Дурак, которая появилась после ховера
            Thread.sleep(2000);
            driver.quit();
            return this.s = "OK";

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
                wait.until(visibilityOfElementLocated(By.xpath(xPathButtonGameFool))); // клик на кнопку Дурак, которая появилась после ховера
                driver.findElement(By.xpath(xPathButtonGameFool)).click(); // клик на кнопку Дурак, которая появилась после ховера

                Thread.sleep(2000);
                driver.quit();
                return this.s = "OK";

            } catch (Exception e1) {
                try {
                    Thread.sleep(20000);
                    wait.until(visibilityOfElementLocated(By.xpath(Parameters.xPathButtonGame))); // вход в раздел Игры
                    driver.findElement(By.xpath(Parameters.xPathButtonGame)).click(); // вход в раздел Игры
                    Thread.sleep(2000);
                    WebElement element = driver.findElement(By.xpath(elementHover)); // скролл на элемент(div) поле с кнопкой Дурак
                    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element); // скролл на элемент(div) поле с кнопкой Дурак
                    Thread.sleep(2000);
                    action.build();
                    action.moveToElement(driver.findElement(By.xpath(elementHover))).perform(); // ховер на элемент(div) поле с кнопкой Дурак
                    wait.until(visibilityOfElementLocated(By.xpath(xPathButtonGameFool))); // клик на кнопку Дурак, которая появилась после ховера
                    driver.findElement(By.xpath(xPathButtonGameFool)).click(); // клик на кнопку Дурак, которая появилась после ховера

                    Thread.sleep(2000);
                    driver.quit();
                    return this.s = "OK";

                } catch (Exception e2) {
                    driver.quit();
                    return this.s = "BAD";
                }
            }
        }
    }

    public void logFool() throws IOException, MessagingException {
        FileReader fr = new FileReader(logFileName);
        BufferedReader br = new BufferedReader(fr);
        Date date = new Date();
        String str = br.readLine();
        String result = date.toString() + " Успешность запуска " + s;
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

    public void logFoolBad() throws IOException, MessagingException {
        FileReader fr = new FileReader(logFileName);
        BufferedReader br = new BufferedReader(fr);
        Date date = new Date();
        String str = br.readLine();
        String result = date.toString() + " игра Дурак не восстановилась на протяжении 10 попыток ";
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

    public void mailFool() throws IOException, MessagingException {
        if (s == "OK") ;
        else if (s == "BAD") {
            Date date = new Date();
            Properties props = new Properties();
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
                mess.setSubject("Автоест по игре Дурак не прошел ");
                mess.setText("Автоест по игре Дурак не прошел  " + date.toString());
                Transport.send(mess);
            } catch (Exception ex) {
                System.out.println("что то не то");
            }
        }
    }

    public void mailFoolOk() throws IOException, MessagingException {

        Date date = new Date();
        Properties props = new Properties();
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
            mess.setSubject("Восстановление игры Дурак ");
            mess.setText("Восстановление игры Дурак  " + date.toString());
            Transport.send(mess);

        } catch (Exception ex) {
            System.out.println("что то не то");
        }
    }
}


