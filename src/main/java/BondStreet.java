import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class BondStreet {

    String s;
    SignIn signIn = new SignIn();

    public String bondStreet() throws InterruptedException, IOException, MessagingException {
        System.setProperty("webdriver.gecko.driver", "C://IT/Test/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        WebDriverWait wait = new WebDriverWait(driver, 40);

            driver.get(Bond.link);
            driver.findElement(By.id("main-email")).clear();
            driver.findElement(By.id("main-email")).sendKeys("vkfbok@mail.ru");
            driver.findElement(By.cssSelector("input.auth-password")).clear();
            driver.findElement(By.cssSelector("input.auth-password")).sendKeys("11111111");
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("button.btn--red.btn--x3.login_button")).click();

            try {
                wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"mCSB_1_container\"]/div[3]/div[4]/div[1]/div/div/div[1]/div[4]/div[8]/div[2]/a/span")));
                driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/div[3]/div[4]/div[1]/div/div/div[1]/div[4]/div[8]/div[2]/a/span")).click();
                wait.until(visibilityOfElementLocated(By.cssSelector("html.scotland-yard.page-game.dev.desktop.html-landscape body footer.b-footer div.b-footer__title p a")));
                driver.findElement(By.cssSelector("html.scotland-yard.page-game.dev.desktop.html-landscape body footer.b-footer div.b-footer__title p a"));
                Thread.sleep(2000);
                driver.quit();
                return this.s = "OK";

            } catch (Exception e) {
                try {
                    wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"mCSB_1_container\"]/div[3]/div[4]/div[1]/div/div/div[1]/div[4]/div[8]/div[2]/a/span")));
                    driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/div[3]/div[4]/div[1]/div/div/div[1]/div[4]/div[8]/div[2]/a/span")).click();
                    wait.until(visibilityOfElementLocated(By.cssSelector("html.scotland-yard.page-game.dev.desktop.html-landscape body footer.b-footer div.b-footer__title p a")));
                    driver.findElement(By.cssSelector("html.scotland-yard.page-game.dev.desktop.html-landscape body footer.b-footer div.b-footer__title p a"));
                    Thread.sleep(2000);
                    driver.quit();
                    return this.s = "OK";

                } catch (Exception e1) {
                    try {
                        Thread.sleep(5000);
                        wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"mCSB_1_container\"]/div[3]/div[4]/div[1]/div/div/div[1]/div[4]/div[8]/div[2]/a/span")));
                        driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/div[3]/div[4]/div[1]/div/div/div[1]/div[4]/div[8]/div[2]/a/span")).click();
                        wait.until(visibilityOfElementLocated(By.cssSelector("html.scotland-yard.page-game.dev.desktop.html-landscape body footer.b-footer div.b-footer__title p a")));
                        driver.findElement(By.cssSelector("html.scotland-yard.page-game.dev.desktop.html-landscape body footer.b-footer div.b-footer__title p a"));
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

    public void logBondStreet() throws IOException, MessagingException {
        FileReader fr = new FileReader("C:\\work\\log_bondStreet.txt");
        BufferedReader br = new BufferedReader(fr);
        Date date = new Date();
        String str = br.readLine();
        String result = date.toString() + " Успешность запуска " + s;
        while (str != null) {
            String lineSeparator = System.getProperty("line.separator");
            result += lineSeparator + str;
            str = br.readLine();
        }
        FileWriter fw = new FileWriter("C:\\work\\log_bondStreet.txt");
        fw.write(result);
        fw.close();
        fr.close();
        br.close();
    }

    public void mailBondStreet() throws IOException, MessagingException {
        if (s == "OK") ;
        else if (s == "BAD"){
            Date date = new Date();
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session s = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("devup2012@gmail.com", "upupDevelup404!"); }});
            try{
                Message mess = new MimeMessage(s);
                mess.setFrom(new InternetAddress("devup2012@gmail.com"));
                String[] emails={"as@develup.pro", "ek@develup.pro"  };//
                InternetAddress dests[] = new InternetAddress[emails.length];
                for(int i=0; i<emails.length; i++){
                    dests[i]=new InternetAddress(emails[i].trim().toLowerCase());}
                mess.setRecipients(Message.RecipientType.TO, dests);
                mess.setSubject("Автотест по игре Поиск BondStreet не прошел ");
                mess.setText("Автотест по игре Поиск BondStreet не прошел  " + date.toString());
                Transport.send(mess);

            }catch (Exception ex){
                System.out.println("что то не то");
            }
        }
    }

    public void mailBondStreetOk() throws IOException, MessagingException {
            Date date = new Date();
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session s = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("devup2012@gmail.com", "upupDevelup404!"); }});
            try{
                Message mess = new MimeMessage(s);
                mess.setFrom(new InternetAddress("devup2012@gmail.com"));
                String[] emails={"as@develup.pro", "ek@develup.pro"}; //, "ek@develup.pro"
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
}






