package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver ;
    private By username =By.id("username");
    private By passWord = By.id("password");
    private By loginBtn = By.cssSelector("#login button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void setUserName(String userName){
        driver.findElement(username).sendKeys(userName);
    }
    public void setPassword(String password){
        driver.findElement(passWord).sendKeys(password);
    }
    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginBtn).click();
        return new SecureAreaPage(driver);

    }
}
