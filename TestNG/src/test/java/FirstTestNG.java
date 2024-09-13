import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNG {
    WebDriver driver;

    @BeforeTest
    public void prepare()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void register(){
        System.out.println("Hello From Register Method");
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }
    @Test
    public void login(){
        System.out.println("Hello From Login Method");
    }

    @Test
    public void addToCart(){
        System.out.println("Hello From Add to Cart Method");
    }
}
