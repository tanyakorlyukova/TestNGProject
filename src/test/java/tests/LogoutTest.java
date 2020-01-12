package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage(driver).logIn("demo@open-eshop.com", "demo");
    }

    @Test
    public void logOut() {
        MainPage mainPage = new MainPage(driver).logOut();
        Assert.assertTrue(mainPage.isLoginButtonDisplayed());
    }
}
