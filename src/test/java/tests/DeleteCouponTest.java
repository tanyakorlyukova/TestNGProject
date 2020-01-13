package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CouponPage;
import pages.LoginPage;
import pages.MainPage;

public class DeleteCouponTest extends BaseTest {

    //change coupon name before test
    String couponName = "Coupon99990";

    @BeforeMethod
    public void addCoupon(){
        new LoginPage(driver).logIn("demo@open-eshop.com", "demo");
        MainPage mainPage = new MainPage(driver);
        CouponPage couponPage = mainPage.openCouponsPage();
        couponPage.openNewCouponPage();
        couponPage.addCoupon(couponName, "5", "2020-01-23", "6");
    }

    @Test
    public void deleteCoupon() {
        CouponPage couponPage = new CouponPage(driver).deleteCoupon(couponName);
        couponPage.searchCoupon(couponName);
        Assert.assertFalse(couponPage.isCouponFound());
    }

}
