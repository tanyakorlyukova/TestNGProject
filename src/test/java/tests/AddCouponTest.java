package tests;

import org.testng.Assert;
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
    public void addCorrectCoupon(String couponName, String discountAmount, String validDate, String numberOfCoupons) {
        MainPage mainPage = new MainPage(driver);
        CouponPage couponPage = mainPage.openCouponsPage();

        couponPage.addCoupon(couponName, discountAmount, validDate, numberOfCoupons);
       // Assert.assertTrue();
    }

    @Test
    public void addIncorrectCoupon(String couponName, String discountAmount, String validDate, String numberOfCoupons, String errorMessage) {

    }
}
