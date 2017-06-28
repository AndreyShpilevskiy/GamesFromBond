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


public class SignIn {

    static String s;
    static String logFileName = "C:\\work\\log_signIn.txt";
    String xPathFirstClick = "//*[@id=\"mCSB_1_container\"]/div[3]/div[1]/a";

    public String signIn() throws IOException, MessagingException, InterruptedException {

            System.setProperty(Parameters.webDriver, Parameters.pathFileWebDriverFF);
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            WebDriver driver = new FirefoxDriver(capabilities);
            WebDriverWait wait = new WebDriverWait(driver, 30);

        try {
            driver.get(Parameters.link);
            driver.findElement(By.id(Parameters.xPathEmailField)).clear();
            driver.findElement(By.id(Parameters.xPathEmailField)).sendKeys(Parameters.login);
            driver.findElement(By.cssSelector(Parameters.xPathPasswordField)).clear();
            driver.findElement(By.cssSelector(Parameters.xPathPasswordField)).sendKeys(Parameters.password);
            Thread.sleep(3000);
            driver.findElement(By.cssSelector(Parameters.xPathLoginButton)).click();
            wait.until(visibilityOfElementLocated(By.xpath(xPathFirstClick)));
            driver.findElement(By.xpath(xPathFirstClick)).click();
            Thread.sleep(3000);
            driver.quit();
            return this.s = "OK";

            } catch (Exception e) {
                try {
                    driver.get(Parameters.link);
                    driver.findElement(By.id(Parameters.xPathEmailField)).clear();
                    driver.findElement(By.id(Parameters.xPathEmailField)).sendKeys(Parameters.login);
                    driver.findElement(By.cssSelector(Parameters.xPathPasswordField)).clear();
                    driver.findElement(By.cssSelector(Parameters.xPathPasswordField)).sendKeys(Parameters.password);
                    Thread.sleep(3000);
                    driver.findElement(By.cssSelector(Parameters.xPathLoginButton)).click();
                    wait.until(visibilityOfElementLocated(By.xpath(xPathFirstClick)));
                    driver.findElement(By.xpath(xPathFirstClick)).click();
                    Thread.sleep(3000);
                    driver.quit();
                    return this.s = "OK";

                } catch (Exception e1) {
                    try {
                        Thread.sleep(20000);
                        driver.get(Parameters.link);
                        driver.findElement(By.id(Parameters.xPathEmailField)).clear();
                        driver.findElement(By.id(Parameters.xPathEmailField)).sendKeys(Parameters.login);
                        driver.findElement(By.cssSelector(Parameters.xPathPasswordField)).clear();
                        driver.findElement(By.cssSelector(Parameters.xPathPasswordField)).sendKeys(Parameters.password);
                        Thread.sleep(3000);
                        driver.findElement(By.cssSelector(Parameters.xPathLoginButton)).click();
                        wait.until(visibilityOfElementLocated(By.xpath(xPathFirstClick)));
                        driver.findElement(By.xpath(xPathFirstClick)).click();
                        Thread.sleep(3000);
                        driver.quit();
                        return this.s = "OK";

                    } catch (Exception e2) {
                        driver.quit();
                        return this.s = "BAD";
                    }
                }
            }
        }

    public static void logSignIn() throws IOException, MessagingException {
        FileReader fr = new FileReader(logFileName);
        BufferedReader br = new BufferedReader(fr);
        Date date = new Date();
        String str = br.readLine();
        String result = date.toString() + " Авторизация успешна " + s;
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

    public void logSignInBad() throws IOException, MessagingException {
        FileReader fr = new FileReader(logFileName);
        BufferedReader br = new BufferedReader(fr);
        Date date = new Date();
        String str = br.readLine();
        String result = date.toString() + " Авторизоваться на BondStreet не восстановилась на протяжении 10 попыток ";
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

    public void mailSignIn() throws IOException, MessagingException {
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
                    return new PasswordAuthentication(Parameters.sendMail, Parameters.sendMailPassword); }});
            try{
                Message mess = new MimeMessage(s);
                mess.setFrom(new InternetAddress(Parameters.sendMail));
                String[] emails = Parameters.sendToMail;
                InternetAddress dests[] = new InternetAddress[emails.length];
                for(int i=0; i<emails.length; i++){
                    dests[i]=new InternetAddress(emails[i].trim().toLowerCase());}
                mess.setRecipients(Message.RecipientType.TO, dests);
                mess.setSubject("Автотест по авторизации на BondStreet не прошел ");
                mess.setText("Автотест по авторизации на BondStreet не прошел  " + date.toString());
                Transport.send(mess);

            }catch (Exception ex){
                System.out.println("что то не то");
            }
        }
    }

    public void mailSignInOk() throws IOException, MessagingException {
        Date date = new Date();
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
            String[] emails = Parameters.sendToMail; //
            InternetAddress dests[] = new InternetAddress[emails.length];
            for(int i=0; i<emails.length; i++){
                dests[i]=new InternetAddress(emails[i].trim().toLowerCase());}
            mess.setRecipients(Message.RecipientType.TO, dests);
            mess.setSubject("Восстановление авторизации на BondStreet ");
            mess.setText("Восстановление авторизации на BondStreet  " + date.toString());
            Transport.send(mess);

        }catch (Exception ex){
            System.out.println("что то не то");
        }
    }
}
