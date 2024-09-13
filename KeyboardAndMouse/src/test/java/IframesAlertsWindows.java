import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IframesAlertsWindows {
    WebDriver driver;
    String baseURL = "http://cookbook.seleniumacademy.com/Alerts.html";
    @BeforeTest
    public void prepare(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

    @Test
    public void testSimpleAlert() throws InterruptedException {
        WebElement clickAlert = driver.findElement(By.id("simple"));
        clickAlert.click();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();

        Assert.assertEquals("Hello! I am an alert box!" , alertText);
        Thread.sleep(3000);
        alert.accept();

    }
}
