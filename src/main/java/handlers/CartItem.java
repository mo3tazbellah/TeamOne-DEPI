package handlers;

import org.openqa.selenium.WebElement;

public class CartItem extends BaseItem{
    public int quantity;
    public WebElement removeBtn;

    public CartItem(WebElement nameElement, int quantity, String description, double price, WebElement removeBtn)
    {
        super(nameElement, description, price);
        this.removeBtn = removeBtn;
        this.quantity = quantity;
    }
}
