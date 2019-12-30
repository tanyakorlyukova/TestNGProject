package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CouponPage;
import pages.LoginPage;
import pages.MainPage;

public class AddCouponTest extends BaseTest {

    @BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn("demo@open-eshop.com", "demo");
    }

    @Test
    public void addCoupon() {
        MainPage mainPage = new MainPage(driver);
        CouponPage couponPage = mainPage.openCouponsPage();


    }
}
