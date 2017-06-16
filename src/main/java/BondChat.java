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

    public String bondChat() throws Exception {

        System.setProperty("webdriver.gecko.driver", "C://IT/Test/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get(Bond.link);
        driver.findElement(By.id("main-email")).clear();
        driver.findElement(By.id("main-email")).sendKeys("vkfbok@mail.ru");
        driver.findElement(By.cssSelector("input.auth-password")).clear();
        driver.findElement(By.cssSelector("input.auth-password")).sendKeys("11111111");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button.btn--red.btn--x3.login_button")).click();

        try {
            wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"mCSB_1_container\"]/div[3]/div[1]/div[3]/div[2]/div[1]")));
            Thread.sleep(5000);
            WebElement frame = driver.findElement(By.tagName("iframe"));
            driver.switchTo().frame(frame);
            Thread.sleep(3000);
            wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[4]/span")));
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[4]/span")).click();
            Thread.sleep(3000);
            wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[3]/span")));
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[3]/span")).click();
            Thread.sleep(2000);
            driver.quit();
            return this.s = "OK";

        } catch (Exception e) {
            try {
                wait.until(visibilityOfElementLocated(By.xpath("//div[@id='mCSB_1_container']/div[2]/div/div[3]/div[2]/div[2]/a/div/div")));
                Thread.sleep(5000);
                WebElement frame = driver.findElement(By.tagName("iframe"));
                driver.switchTo().frame(frame);
                wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[4]/span")));
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[4]/span")).click();
                Thread.sleep(3000);
                wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[3]/span")));
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[3]/span")).click();
                Thread.sleep(2000);
                driver.quit();
                return this.s = "OK";

            } catch (Exception e1) {
                try {
                    Thread.sleep(30000);
                    wait.until(visibilityOfElementLocated(By.xpath("//div[@id='mCSB_1_container']/div[2]/div/div[3]/div[2]/div[2]/a/div/div")));
                    Thread.sleep(5000);
                    WebElement frame = driver.findElement(By.tagName("iframe"));
                    driver.switchTo().frame(frame);
                    wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[4]/span")));
                    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[4]/span")).click();
                    Thread.sleep(3000);
                    wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[3]/span")));
                    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[3]/span")).click();
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
        FileReader fr = new FileReader("C:\\work\\log_bondChat.txt");
        BufferedReader br = new BufferedReader(fr);
        Date date = new Date();
        String str = br.readLine();
        String result = date.toString() + " Чат работает " + s;
        while (str != null) {
            String lineSeparator = System.getProperty("line.separator");
            result += lineSeparator + str;
            str = br.readLine();
        }
        FileWriter fw = new FileWriter("C:\\work\\log_bondChat.txt");
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
                    return new PasswordAuthentication("devup2012@gmail.com", "upupDevelup404!");
                }
            });
            try {
                Message mess = new MimeMessage(s);
                mess.setFrom(new InternetAddress("devup2012@gmail.com"));
                String[] emails = {"as@develup.pro", "ek@develup.pro"};
                InternetAddress dests[] = new InternetAddress[emails.length];
                for (int i = 0; i < emails.length; i++) {
                    dests[i] = new InternetAddress(emails[i].trim().toLowerCase());
                }
                mess.setRecipients(Message.RecipientType.TO, dests);
                mess.setSubject("Чат на деве упал ");
                mess.setText("Чат на деве упал. Время:  " + date.toString());
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
                return new PasswordAuthentication("devup2012@gmail.com", "upupDevelup404!");
            }
        });
        try {
            Message mess = new MimeMessage(s);
            mess.setFrom(new InternetAddress("devup2012@gmail.com"));
            String[] emails = {"as@develup.pro", "ek@develup.pro"};
            InternetAddress dests[] = new InternetAddress[emails.length];
            for (int i = 0; i < emails.length; i++) {
                dests[i] = new InternetAddress(emails[i].trim().toLowerCase());
            }
            mess.setRecipients(Message.RecipientType.TO, dests);
            mess.setSubject("Восстановление чата BondStreet ");
            mess.setText("Восстановление чата BondStreet  " + date.toString());
            Transport.send(mess);

        }catch (Exception ex){
            System.out.println("что то не то");
        }
    }
}





