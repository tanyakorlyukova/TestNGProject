package tests;

import dataprovider.CouponData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CouponPage;
import pages.LoginPage;
import pages.MainPage;

public class AddCouponTest extends BaseTest {

    @BeforeMethod
    public void login() {
        new LoginPage(driver).logIn("demo@open-eshop.com", "demo");
    }

    @Test(dataProvider = "correctCouponData", dataProviderClass = CouponData.class)
    public void addCorrectCoupon(String couponName, String discountAmount, String validDate, String numberOfCoupons) {
        MainPage mainPage = new MainPage(driver);
        CouponPage couponPage = mainPage.openCouponsPage();
        couponPage.openNewCouponPage();
        couponPage.addCoupon(couponName, discountAmount, validDate, numberOfCoupons);
        Assert.assertTrue(couponPage.isMessageContains("Coupon " + couponName + " created"), couponPage.getAlertMessage());
    }

    @Test(dataProvider = "incorrectCouponData", dataProviderClass = CouponData.class)
    public void addIncorrectCoupon(String couponName, String discountAmount, String validDate, String numberOfCoupons, String errorMessage) {
        MainPage mainPage = new MainPage(driver);
        CouponPage couponPage = mainPage.openCouponsPage();
        couponPage.openNewCouponPage();
        couponPage.addCoupon(couponName, discountAmount, validDate, numberOfCoupons);
        Assert.assertTrue(couponPage.isMessageContains(errorMessage), couponPage.getAlertMessage());
    }
}
