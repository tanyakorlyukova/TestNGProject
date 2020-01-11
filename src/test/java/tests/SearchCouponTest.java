package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CouponPage;
import pages.LoginPage;
import pages.MainPage;

public class SearchCouponTest extends BaseTest {

    String couponName = "Coupon876876786587768876";// + Math.random()*1000;

    @BeforeMethod
    public void addAndSearchCoupon() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn("demo@open-eshop.com", "demo");
        MainPage mainPage = new MainPage(driver);
        CouponPage couponPage = mainPage.openCouponsPage();
        couponPage.addCoupon(couponName, "5", "2020-01-23", "6");
    }

    @Test void searchCoupon() {
        MainPage mainPage = new MainPage(driver);
        CouponPage couponPage = mainPage.openCouponsPage();
        couponPage.searchCoupon(couponName);
        Assert.assertTrue(couponPage.isCouponFound());
    }
}