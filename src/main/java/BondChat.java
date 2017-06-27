import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class BondChat {

    String s;
    String logFileName = "C:\\work\\log_bondChat.txt";
    String nameIframe = "iframe";
    String xPathFindElement1 = "//*[@id=\"mCSB_1_container\"]/div[3]/div[1]/div[3]/div[2]/div[1]";
    String xPathFirstClick = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[4]/span";
    String xPathSecondClick = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[3]/span";

    public String bondChat() throws Exception {

        System.setProperty(Parameters.webDriver, Parameters.pathFileWebDriverFF);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get(Parameters.link);
        driver.findElement(By.id(Parameters.xPathEmailField)).clear();
        driver.findElement(By.id(Parameters.xPathEmailField)).sendKeys(Parameters.login);
        driver.findElement(By.cssSelector(Parameters.xPathPasswordField)).clear();
        driver.findElement(By.cssSelector(Parameters.xPathPasswordField)).sendKeys(Parameters.password);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(Parameters.xPathLoginButton)).click();

        try {
            wait.until(visibilityOfElementLocated(By.xpath(xPathFindElement1)));
            Thread.sleep(5000);
            WebElement frame = driver.findElement(By.tagName(nameIframe));
            driver.switchTo().frame(frame);
            Thread.sleep(3000);
            wait.until(visibilityOfElementLocated(By.xpath(xPathFirstClick)));
            driver.findElement(By.xpath(xPathFirstClick)).click();
            Thread.sleep(3000);
            wait.until(visibilityOfElementLocated(By.xpath(xPathSecondClick)));
            driver.findElement(By.xpath(xPathSecondClick)).click();
            Thread.sleep(2000);
            driver.quit();
            return this.s = "OK";

        } catch (Exception e) {
            try {
                wait.until(visibilityOfElementLocated(By.xpath(xPathFindElement1)));
                Thread.sleep(5000);
                WebElement frame = driver.findElement(By.tagName(nameIframe));
                driver.switchTo().frame(frame);
                Thread.sleep(3000);
                wait.until(visibilityOfElementLocated(By.xpath(xPathFirstClick)));
                driver.findElement(By.xpath(xPathFirstClick)).click();
                Thread.sleep(3000);
                wait.until(visibilityOfElementLocated(By.xpath(xPathSecondClick)));
                driver.findElement(By.xpath(xPathSecondClick)).click();
                Thread.sleep(2000);
                driver.quit();
                return this.s = "OK";

            } catch (Exception e1) {
                try {
                    Thread.sleep(20000);
                    wait.until(visibilityOfElementLocated(By.xpath(xPathFindElement1)));
                    Thread.sleep(5000);
                    WebElement frame = driver.findElement(By.tagName(nameIframe));
                    driver.switchTo().frame(frame);
                    Thread.sleep(3000);
                    wait.until(visibilityOfElementLocated(By.xpath(xPathFirstClick)));
                    driver.findElement(By.xpath(xPathFirstClick)).click();
                    Thread.sleep(3000);
                    wait.until(visibilityOfElementLocated(By.xpath(xPathSecondClick)));
                    driver.findElement(By.xpath(xPathSecondClick)).click();
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

    public void logBondChat() throws IOException, MessagingException {
        FileReader fr = new FileReader(logFileName);
        BufferedReader br = new BufferedReader(fr);
        Date date = new Date();
        String str = br.readLine();
        String result = date.toString() + " Чат работает " + s;
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

    public void logBondChatBad() throws IOException, MessagingException {
        FileReader fr = new FileReader(logFileName);
        BufferedReader br = new BufferedReader(fr);
        Date date = new Date();
        String str = br.readLine();
        String result = date.toString() + " Чат не восстановился на протяжении 10 попыток ";
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

    public void mailBondChat() throws IOException, MessagingException {
        if (s == "OK") ;
        else if (s == "BAD") {
            Properties props = new Properties();
            Date date = new Date();
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
                mess.setSubject("Чат на проде BondStreet упал ");
                mess.setText("Чат на проде упал BondStreet. Время:  " + date.toString());
                Transport.send(mess);

            } catch (Exception ex) {
                System.out.println("что то не то");
            }
        }
    }

    public void mailBondChatOk() throws IOException, MessagingException {

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
            mess.setSubject("Восстановление чата на проде BondStreet ");
            mess.setText("Восстановление чата на проде BondStreet  " + date.toString());
            Transport.send(mess);

        }catch (Exception ex){
            System.out.println("что то не то");
        }
    }
}





