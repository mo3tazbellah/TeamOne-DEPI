package tests;

import components.Navbar;
import handlers.CartItem;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class CartPageTest extends  BaseTest{

    @Test(priority = 3)
    public void cartTest()
    {
        CartPage cartPage = Navbar.clickShoppingCart(driver);
        List<CartItem> cartItemsList = cartPage.getCartItems();

        String actualName =cartItemsList.get(0).nameElement.getText();
        String expectedName = "Sauce Labs Backpack";
        Assert.assertEquals(actualName,expectedName);

        double actualPrice =cartItemsList.get(0).price;
        double expectedPrice = 29.99;
        Assert.assertEquals(actualPrice,expectedPrice);


        String actualNameTwo =cartItemsList.get(1).nameElement.getText();
        String expectedNameTwo = "Sauce Labs Bike Light";
        Assert.assertEquals(actualNameTwo,expectedNameTwo);

        double actualPriceTwo =cartItemsList.get(1).price;
        double expectedPriceTwo = 9.99;
        Assert.assertEquals(actualPriceTwo,expectedPriceTwo);


        String actualNameThree =cartItemsList.get(2).nameElement.getText();
        String expectedNameThree = "Sauce Labs Fleece Jacket";
        Assert.assertEquals(actualNameThree,expectedNameThree);

        double actualPriceThree =cartItemsList.get(2).price;
        double expectedPriceThree = 49.99;
        Assert.assertEquals(actualPriceThree,expectedPriceThree);








    }
}
