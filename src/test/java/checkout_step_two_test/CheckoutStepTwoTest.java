package checkout_step_two_test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutStepTwoPage;

public class CheckoutStepTwoTest extends BaseTest {

    @Test
    public void checkoutStepTwoTest() {
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);

        String actualAssertInCheckOutStepTwoPage = checkoutStepTwoPage.getAssertInCheckOutStepTwoPage();
        String expectedAssertInCheckOutStepTwoPage = "Checkout: Overview";
        Assert.assertEquals(actualAssertInCheckOutStepTwoPage, expectedAssertInCheckOutStepTwoPage);


        String actualProductNameOne = checkoutStepTwoPage.getProductOne();
        String expectedProductNameOne = "Sauce Labs Backpack";

        String actualProductNameTwo = checkoutStepTwoPage.getProductTwo();
        String expectedProductNameTwo = "Sauce Labs Bike Light";

        String actualProductNameThree = checkoutStepTwoPage.getProductThree();
        String expectedProductNameThree = "Sauce Labs Fleece Jacket";

        double actualProductOnePrice = Double.parseDouble(checkoutStepTwoPage.getProductOnePrice());
        double expectedProductOnePrice = 29.99;

        double actualProductTwoPrice = Double.parseDouble(checkoutStepTwoPage.getProductTwoPrice());
        double expectedProductTwoPrice = 9.99;

        double actualProductThreePrice = Double.parseDouble(checkoutStepTwoPage.getProductThreePrice());
        double expectedProductThreePrice = 49.99;

        double actualTotalPrice = checkoutStepTwoPage.totalPrice();
        double expectedTotalPrice = 99.97;

        Assert.assertEquals(actualProductNameOne, expectedProductNameOne);
        Assert.assertEquals(actualProductNameTwo, expectedProductNameTwo);
        Assert.assertEquals(actualProductNameThree, expectedProductNameThree);
        Assert.assertEquals(actualProductOnePrice, expectedProductOnePrice);
        Assert.assertEquals(actualProductTwoPrice, expectedProductTwoPrice);
        Assert.assertEquals(actualProductThreePrice, expectedProductThreePrice);
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);

        checkoutStepTwoPage.clickFinishButton();
    }
}
