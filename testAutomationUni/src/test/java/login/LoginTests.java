package login;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUserName("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        System.out.println(secureAreaPage.getAlertText());
        Assert.assertEquals(secureAreaPage.getAlertText()," You logged into a secure area! ");
    }
}
