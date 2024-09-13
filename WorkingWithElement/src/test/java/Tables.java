import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;

public class Tables {
    WebDriver driver;
    String baseURl = "https://the-internet.herokuapp.com/tables";
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
    public void tablesDate(){
        WebElement table = driver.findElement(By.id("table2"));
        //get all ro
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        Assert.assertEquals(5, rows.size());

        //get all cells data
        for ( WebElement row : rows){
            List<WebElement> columns = row.findElements(By.tagName("td"));
                    for (WebElement column : columns){
                        System.out.println(column.getText());
                    }
        }
    }
}
