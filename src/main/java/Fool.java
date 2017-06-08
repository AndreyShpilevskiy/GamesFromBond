import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Fool {


    static String s;

    public String startFool(String s) throws InterruptedException{
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

        System.out.println(s+ "here");

        try {
            wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/div[4]/div[2]/div[1]/div[1]/div/a")));
            driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/div[4]/div[2]/div[1]/div[1]/div/a")).click();
            Thread.sleep(2000);
            driver.quit();
            return s = "OK";

        } catch (Exception e) {
            try {
                wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/div[4]/div[2]/div[1]/div[1]/div/a")));
                driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/div[4]/div[2]/div[1]/div[1]/div/a")).click();
                Thread.sleep(2000);
                driver.quit();
                return s = "OK";

            } catch (Exception e1){
                try{
                Thread.sleep(300000);
                wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/div[4]/div[2]/div[1]/div[1]/div/a")));
                driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/div[4]/div[2]/div[1]/div[1]/div/a")).click();
                Thread.sleep(2000);
                driver.quit();
                return s = "OK";

                } catch (Exception e2) {
                return s = "BAD";
                }
            }
        }

    //    if (s == "OK") {} // записываем лог и завершаем метод
      //      else if (s == "BAD") {} // записываем лог и переходим к отправке письма с проблемой




        // Если все ок - логирование в файл и брейк
        // Если НЕ ок - логирование и отправка уведомления на почту и брейк

    }
}
