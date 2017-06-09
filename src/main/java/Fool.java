import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

    public String startFool() throws InterruptedException {
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
            wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/div[4]/div[2]/div[1]/div[1]/div/a")));
            driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/div[4]/div[2]/div[1]/div[1]/div/a")).click();
            Thread.sleep(2000);
            driver.quit();
            return this.s = "OK1" ;

        } catch (Exception e) {
            try {
                wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/div[4]/div[2]/div[1]/div[1]/div/a")));
                driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/div[4]/div[2]/div[1]/div[1]/div/a")).click();
                Thread.sleep(2000);
                driver.quit();
                return this.s = "OK" ;

            } catch (Exception e1) {
                try {
                    Thread.sleep(300000);
                    wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/div[4]/div[2]/div[1]/div[1]/div/a")));
                    driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/div[4]/div[2]/div[1]/div[1]/div/a")).click();
                    Thread.sleep(2000);
                    driver.quit();
                    return this.s = "OK" ;

                } catch (Exception e2) {
                    driver.quit();
                    return this.s = "BAD" ;
                }
            }
        }
    }

    public void logAndMail() throws IOException, MessagingException {
        FileReader fr = new FileReader("C:\\work\\log_fool.txt");
        BufferedReader br = new BufferedReader(fr);
        Date date = new Date();
        String str = br.readLine();
        String result = date.toString() + " Успешность запуска " + s;
        while (str != null) {
            String lineSeparator = System.getProperty("line.separator");
            result += lineSeparator+ str;
            str = br.readLine();
            //System.out.println();
        }
        FileWriter fw = new FileWriter("C:\\work\\log_fool.txt");
        fw.write(result);
        fw.close();
        fr.close();
        br.close();
        if (s == "OK") ;
            else if (s == "BAD"){

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

                Session s = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("andrej.shpilevskij@gmail.com", "50650608"); }});

                try{

                    Message mess = new MimeMessage(s);
                    mess.setFrom(new InternetAddress("andrej.shpilevskij@gmail.com"));
                    String[] emails={"rekoj@list.ru", "kuzhelod@gmail.com"};
                    InternetAddress dests[] = new InternetAddress[emails.length];
                        for(int i=0; i<emails.length; i++){
                        dests[i]=new InternetAddress(emails[i].trim().toLowerCase());}
                    mess.setRecipients(Message.RecipientType.TO, dests);
                    mess.setSubject("Автоест по игре Дурак не прошел ");
                    mess.setText("Автоест по игре Дурак не прошел  " + date.toString());
                    Transport.send(mess);

                }catch (Exception ex){
                    System.out.println("что то не то");
                }

        }
    }
}


