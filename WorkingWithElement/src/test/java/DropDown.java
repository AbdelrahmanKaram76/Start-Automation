import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class DropDown {
    WebDriver driver;
    String baseURl = "https://the-internet.herokuapp.com/dropdown";
    @BeforeTest
    public void prepare(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseURl);
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void dropDownOption1(){
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select option = new Select(dropDown);
        Assert.assertFalse(option.isMultiple());
        Assert.assertEquals(3,option.getOptions().size());
        option.selectByVisibleText("Option 2");

    }
    @Test
    public void dropDownOption2(){
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select option = new Select(dropDown);
        option.selectByVisibleText("Option 1");

    }
    @Test
    public void disableChoice(){
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select option = new Select(dropDown);
        WebElement optionToCheck = option.getFirstSelectedOption();
        boolean isDisabled = optionToCheck.getAttribute("disabled") != null;
        if (isDisabled){
            System.out.println("This Option disabled");
        }
        else {
            System.out.println("This option enabled");
        }
     //   Assert.assertEquals(true , optionToCheck.getAttribute("disabled"));



    }
}
