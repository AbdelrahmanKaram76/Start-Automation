import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class Login {

    WebDriver driver;
    String baseUrl = "https://shop-dev.storex-app.com/login";
    @BeforeTest
    public void prepare() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void callLogin(){
        driver.navigate().to(baseUrl);
    }

    @Test(priority = 0)
    public void validMobileNumber() {
        // Enter valid mobile number
        driver.findElement(By.tagName("input"))
                .sendKeys("01122334455");

        // Click the submit button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Wait for the home page URL to be loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://shop-dev.storex-app.com/"));

        // Verify the current URL
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://shop-dev.storex-app.com/", "Login did not redirect to home page.");
    }
    @Test(priority = 1)
    public void characterSymbols(){
        driver.findElement(By.xpath("//input[@id=':R4som:']"))
                .sendKeys("abdelrahman");

        // Click the submit button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl , "https://shop-dev.storex-app.com/login" , "Login did not redirect to home page.");

    }
    @Test(priority = 2)
    public void emptyLoginField(){
        driver.findElement(By.xpath("//input[@id=':R4som:']"))
                .sendKeys("");

        // Click the submit button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl , "https://shop-dev.storex-app.com/login" , "Login did not redirect to home page.");
    }
    @Test (priority = 3)
    public void moreThan11Number(){
        driver.findElement(By.xpath("//input[@id=':R4som:']"))
                .sendKeys("011223344557");

        // Click the submit button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl , "https://shop-dev.storex-app.com/login" , "Login did not redirect to home page.");
    }

    @AfterTest
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
