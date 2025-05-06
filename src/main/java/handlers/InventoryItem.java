package handlers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryItem extends BaseItem{

    public WebElement imageElement;
    public WebElement inventoryBtnElem;

    // constructor
    public InventoryItem(WebElement nameElement, WebElement imageElement, String description, double price, WebElement inventoryItemBtnElem)
    {
        super(nameElement, description, price);
        this.imageElement = imageElement;
        this.inventoryBtnElem = inventoryItemBtnElem;

    }


}
