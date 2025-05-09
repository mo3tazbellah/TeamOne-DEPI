package tests;

import handlers.CartItem;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutStepOnePage;
import pages.CheckoutStepTwoPage;
import pages.InventoryPage;

import java.util.List;

public class CheckoutStepTwoTest extends BaseTest {

    @Test
    public void checkoutStepTwoTest() {
        CheckoutStepOnePage checkoutStepOnePage= new CheckoutStepOnePage(driver);
        CheckoutStepTwoPage checkoutStepTwoPage = checkoutStepOnePage.clickContinueButton();

        String actual = checkoutStepTwoPage.getAssertInCheckOutStepTwoPage();
        String expected = "Checkout: Overview";
        Assert.assertEquals(actual,expected);


        List<String> productNames = checkoutStepTwoPage.getAllProductNames();
        List<Double> productPrices = checkoutStepTwoPage.getAllProductPrices();

        Assert.assertEquals(productNames.get(0), "Sauce Labs Backpack");
        Assert.assertEquals(productNames.get(1), "Sauce Labs Bike Light");
        Assert.assertEquals(productNames.get(2), "Sauce Labs Fleece Jacket");

        Assert.assertEquals(productPrices.get(0), 29.99);
        Assert.assertEquals(productPrices.get(1), 9.99);
        Assert.assertEquals(productPrices.get(2), 49.99);


        double actualTotalPrice = checkoutStepTwoPage.totalPrice();
        double expectedTotalPrice = 97.17;
        Assert.assertEquals(actualTotalPrice,expectedTotalPrice);



    }
}
