package dataprovider;

import org.testng.annotations.DataProvider;

public class CouponData {

    @DataProvider(name = "correctCouponData")
    public Object[][] correctCouponData() {
        return new Object[][] {
                {"Coupon" + getRandomValue(), "1231", "2020-01-23", "3"},
                {"Coupon" + getRandomValue(), "999999", "2020-09-12", "11111111"}
        };
    }

    @DataProvider(name = "incorrectCouponData")
    public Object[][] incorrectCouponData() {
        return new Object[][] {
                {"", "", "", "1", "Coupon not created, errors: valid_date must not be empty - name must not be empty"},
                {"", "", "2020-01-16", "1", "Coupon not created, errors: name must not be empty"},
                {"Coupon" + getRandomValue(), "", "*&(*&(*($##", "1", "not created, errors: valid_date must be a date"}
        };
    }

    private String getRandomValue() {
        return String.valueOf(Math.random()*100000);
    }
}
