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

public class WorkingWithPrombtAlert {

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
    public void workingWithPrombt() throws InterruptedException {
        WebElement prombt = driver.findElement(By.id("prompt"));
        prombt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Abdelrahman karam from selenium");

        alert.accept();
        WebElement message = driver.findElement(By.id("prompt_demo"));
        Assert.assertEquals("Hello Abdelrahman karam from selenium! How are you today?" , message.getText());
        Thread.sleep(3000);
    }
}
