import com.beust.ah.A;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Mouse {
    WebDriver driver;
    String baseURL = "http://cookbook.seleniumacademy.com/DoubleClickDemo.html";
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
    @Test(enabled = false)
    public void DoubleClickEvent() throws InterruptedException {
        WebElement message = driver.findElement(By.id("message"));
        String cssValues = message.getCssValue("background-color");
        System.out.println(cssValues);
        Actions builder = new Actions(driver);
        builder.doubleClick(message).build().perform();
        String cssAfterAction = message.getCssValue("background-color");
        System.out.println(cssAfterAction);
        Assert.assertNotEquals(cssAfterAction , cssValues);
        Thread.sleep(5000);

    }
    @Test(enabled = false)
    public void DragAndDrop() throws InterruptedException {
        driver.navigate().back();
        driver.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");
        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.id("droppable"));

        Actions builder = new Actions(driver);
        builder.dragAndDrop(source , target).build().perform();
        Thread.sleep(5000);
        Assert.assertEquals("Dropped!" , target.getText());
    }
}
