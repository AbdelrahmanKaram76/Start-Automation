import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;


public class ConfirmationAlert {
    WebDriver driver;
    String baseUrl = "http://cookbook.seleniumacademy.com/Alerts.html";
    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
    @AfterTest
    public void quit(){
        driver.quit();
    }
    @AfterMethod
   /* public void refreshPage(){
        driver.navigate().refresh();
    }*/
    @Test
    public void confirmAlert() throws InterruptedException {
        WebElement button = driver.findElement(By.id("confirm"));
        button.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement confirmMessage = driver.findElement(By.id("demo"));
        Assert.assertEquals("You Accepted Alert!" , confirmMessage.getText());
        Thread.sleep(3000);
    }
    @Test
    public void dismissAlert() throws InterruptedException {
        WebElement button = driver.findElement(By.id("confirm"));
        button.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement dismissMessage = driver.findElement(By.id("demo"));
        Assert.assertEquals("You Dismissed Alert!" , dismissMessage.getText());
        Thread.sleep(3000);
    }
}
