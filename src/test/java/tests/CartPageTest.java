package tests;

import components.Navbar;
import handlers.CartItem;
import handlers.InventoryItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.*;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.List;

public class CartPageTest extends  BaseTest{

    @Test
    public void test()
    {
        InventoryPage inventoryPage = new LoginPage(driver).loginAs("standard_user", "secret_sauce",driver);
        inventoryPage.selectSortingOption(4);
        List<InventoryItem> inventoryItemList = inventoryPage.getInventoryItems();
        InventoryItemPage inventoryItemPage;
        for(int i = 0; i < inventoryItemList.size(); i++) {
            inventoryItemPage = inventoryPage.clickInventoryItemImg(inventoryItemList.get(i), driver);
            inventoryItemPage.clickAddToCartBtn();
            inventoryPage = inventoryItemPage.clickBackBtn(driver);
        }
        CartPage cartPage = Navbar.clickShoppingCart(driver);
        CheckoutStepOnePage checkoutStepOnePage = cartPage.clickCheckout(driver);
        checkoutStepOnePage.enterDetails("moataz","bellah","12345");
        CheckoutStepTwoPage checkoutStepTwoPage = checkoutStepOnePage.clickContinueButton();
        CheckoutCompletePage checkoutCompletePage = checkoutStepTwoPage.clickFinishButton();
    }
}
