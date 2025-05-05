package pages;

import handlers.BaseItem;
import handlers.CartItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    WebDriver driver;

    // constructor
    public CartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    // returns a list of CartItem objects
    public List<CartItem> getCartItems(){
        // creates a new List
        List<CartItem> cartItemsList = new ArrayList<>();
        // gets all swagLabs cart_items elements
        List<WebElement> cartItemWebElements = driver.findElements(By.className("cart_item"));

        // gets each element's data and create a new cartItem object with it
        for (WebElement cartItemElement : cartItemWebElements)
        {
            WebElement nameElement = cartItemElement.findElement(By.tagName("a"));
            int quantity = Integer.parseInt(cartItemElement.findElement(By.className("cart_quantity")).getText());
            double price = Double.parseDouble(cartItemElement.findElement(By.className("inventory_item_price")).getText());
            WebElement removeBtn = cartItemElement.findElement(By.tagName("button"));
            // adds new CartItem object in the list
            cartItemsList.add(new CartItem(nameElement, quantity, null, price, removeBtn));
        }
        // return the list of CartItem objects
        return cartItemsList;
    }

    public void clickCheckout(){
        By checkoutBtnLocator = By.className("checkout_button");
        WebElement checkoutBtn = driver.findElement(checkoutBtnLocator);
        checkoutBtn.click();
    }
    
    public void clickContinueShopping(){
        By conShoppingBtnLocator = By.cssSelector(".cart_footer .btn_secondary");
        WebElement conShoppingBtn = driver.findElement(conShoppingBtnLocator);
        conShoppingBtn.click();
    }
}