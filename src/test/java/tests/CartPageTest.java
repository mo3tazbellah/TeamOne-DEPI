package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.List;

public class CartPageTest extends  BaseTest{

    @Test
    public void test()
    {

        // declaring & assigning login page locators
        LoginPage login = new LoginPage(driver);
        login.loginAs("standard_user", "secret_sauce", driver);

        driver.findElements(By.cssSelector(".pricebar button")).get(0).click();
        driver.findElements(By.cssSelector(".pricebar button")).get(1).click();
        driver.findElements(By.cssSelector(".pricebar button")).get(2).click();
        driver.findElement(By.className("shopping_cart_link")).click();


        // here we start

        CartPage cartPage = new CartPage(driver);

//        cartPage.getCartItems().get(0).removeBtn.click();
//        cartPage.getCartItems().get(0).removeBtn.click();
//        cartPage.getCartItems().get(0).removeBtn.click();
          System.out.println(cartPage.getCartItems().get(0).nameElement.getText());
//          cartPage.getCartItems().get(0).removeBtn.click();

//        cartPage.getCartItems().get(0).removeBtn.click();

//        cartPage.clickCheckout();
//        cartPage.clickContinueShopping();

    }



}
