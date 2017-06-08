import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Fool {

       public void fool() throws InterruptedException {
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


        Thread.sleep(2000);
        wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/div[4]/div[2]/div[1]/div[1]/div/a")));
        driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/div[4]/div[2]/div[1]/div[1]/div/a")).click();

        driver.quit();

    }
}

