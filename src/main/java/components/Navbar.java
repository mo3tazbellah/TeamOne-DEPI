package components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CartPage;

public class Navbar {

    public static CartPage clickShoppingCart(WebDriver driver){
        WebElement cart = driver.findElement(By.className("shopping_cart_link"));
        cart.click();
        return new CartPage(driver);
    }

    public static int getCartBadge(WebDriver driver){
        int cartBadgeNumber;

        try {
            WebElement badgeElement = driver.findElement(By.className("shopping_cart_badge"));
            cartBadgeNumber = Integer.parseInt(badgeElement.getText());
        }catch (NoSuchElementException e) {
            cartBadgeNumber = 0;
        }

        return cartBadgeNumber;
    }
}
