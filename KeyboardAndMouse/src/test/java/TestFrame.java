import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFrame {

    WebDriver driver;
    String baseURL = "http://cookbook.seleniumacademy.com/Config.html";
    @BeforeTest
    public void prepare(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }
    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
    @Test(priority = 1)
    public void widnowFrame(){
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("visitbutton")).click();
        for (String windowID : driver.getWindowHandles() ){
            String title = driver.switchTo().window(windowID).getTitle();
            if( title.equals("Visit Us")){
                Assert.assertEquals("Visit Us" , driver.getTitle());
                driver.close();
                break;
            }
        }
        driver.switchTo().window(currentWindow);
    }
    @Test(priority = 2)
    public void testWindowsUsingName(){
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("helpbutton")).click();
        driver.switchTo().window("HelpWindow");
        Assert.assertEquals("Help" ,driver.getTitle());
        driver.close();
        driver.switchTo().window(currentWindow);

    }
}

