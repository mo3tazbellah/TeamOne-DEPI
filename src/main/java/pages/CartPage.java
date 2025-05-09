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
    // driver
    WebDriver browser;
    // locators
    private final By cartItemWebElementsLocator = By.className("cart_item");
    private final By nameElementLocator = By.tagName("a");
    private final By quantityLocator = By.className("cart_quantity");
    private final By priceLocator = By.className("inventory_item_price");
    private final By removeBtnLocator = By.tagName("button");
    private final By checkoutBtnLocator = By.className("checkout_button");
    private final By conShoppingBtnLocator = By.cssSelector(".cart_footer .btn_secondary");

    // constructor
    public CartPage(WebDriver driver)
    {
        this.browser = driver;
    }
    // methods
    // returns a list of CartItem objects
    public List<CartItem> getCartItems(){
        // creates a new List
        List<CartItem> cartItemsList = new ArrayList<>();
        // gets all swagLabs cart_items elements
        List<WebElement> cartItemWebElements = browser.findElements(cartItemWebElementsLocator);

        // gets each element's data and create a new cartItem object with it
        for (WebElement cartItemElement : cartItemWebElements)
        {
            WebElement nameElement = cartItemElement.findElement(nameElementLocator);
            int quantity = Integer.parseInt(cartItemElement.findElement(quantityLocator).getText());
            double price = Double.parseDouble(cartItemElement.findElement(priceLocator).getText());
            WebElement removeBtn = cartItemElement.findElement(removeBtnLocator);
            // adds new CartItem object in the list
            cartItemsList.add(new CartItem(nameElement, quantity, null, price, removeBtn));
        }
        // return the list of CartItem objects
        return cartItemsList;
    }

    public CheckoutStepOnePage clickCheckout(WebDriver driver){
        WebElement checkoutBtn = browser.findElement(checkoutBtnLocator);
        checkoutBtn.click();
        return new CheckoutStepOnePage(driver);
    }
    
    public InventoryPage clickContinueShopping(WebDriver driver){
        WebElement conShoppingBtn = browser.findElement(conShoppingBtnLocator);
        conShoppingBtn.click();
        return new InventoryPage(driver);
    }
}