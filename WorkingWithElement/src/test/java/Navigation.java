
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
public class Navigation {

    WebDriver driver;
    String baseURl = "https://the-internet.herokuapp.com/";
    @BeforeTest
    public void prepare(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseURl);
        driver.manage().window().maximize();
    }
    /*
    @Test
    public void controlChrome(){
      driver.navigate().to("https://the-internet.herokuapp.com/geolocation");
        System.out.println(driver.getCurrentUrl());
      driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
      driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());
      driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());

    }*/
    @Test
    public void loginWithAssertion(){
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        WebElement txtUsername = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        txtUsername.sendKeys("tomsmith");
        txtPassword.sendKeys("SuperSecretPassword!");
        btnLogin.click();

        WebElement successLogin =  driver.findElement(By.tagName("h2"));

       // Assert.assertEquals(driver.getCurrentUrl() , "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(successLogin.getText().contains("Secure Area"));
    }
}
