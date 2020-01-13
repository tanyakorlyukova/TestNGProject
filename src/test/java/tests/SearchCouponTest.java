package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CouponPage;
import pages.LoginPage;
import pages.MainPage;

public class SearchCouponTest extends BaseTest {

    //change coupon name before test
    String couponName = "Coupon0909090909";

    @BeforeMethod
    public void addCoupon() {
        new LoginPage(driver).logIn("demo@open-eshop.com", "demo");
        MainPage mainPage = new MainPage(driver);
        CouponPage couponPage = mainPage.openCouponsPage();
        couponPage.openNewCouponPage();
        couponPage.addCoupon(couponName, "5", "2020-01-23", "6");
    }

    @Test void searchCoupon() {
        CouponPage couponPage = new CouponPage(driver).searchCoupon(couponName);
        Assert.assertTrue(couponPage.isCouponFound());
    }
}