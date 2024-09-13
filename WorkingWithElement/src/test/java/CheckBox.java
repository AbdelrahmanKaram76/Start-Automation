import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class CheckBox {
    WebDriver driver;
    String baseURl = "https://the-internet.herokuapp.com/checkboxes";
    @BeforeTest
    public void prepare(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseURl);
        driver.manage().window().maximize();
    }
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
    @Test
    public void checkBox() throws InterruptedException {
        WebElement check1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        check1.click();

        WebElement check2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        if(check2.isSelected()){
            check2.click();
        }
        boolean selectedCheck = check1.isSelected();
        Assert.assertEquals(selectedCheck , true);
        Thread.sleep(3000);

    }

}
