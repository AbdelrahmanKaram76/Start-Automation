import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class isElement {
    WebDriver driver;
    String baseURL = "https://the-internet.herokuapp.com/checkboxes";
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
    public void testElementPresent(){
        if(isElementPresent(By.xpath("/html/body/div[2]/div/div/form/input[1]"))){
            WebElement check1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]"));
            if(!check1.isSelected()){
                check1.click();
            }
        }
        else {
            Assert.fail("Check Box 1 doesn't exist");
        }
    }

    private boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

}
