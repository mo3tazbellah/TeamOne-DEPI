package pages;

import handlers.CartItem;
import handlers.InventoryItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage {
    // driver
    WebDriver browser;
    // locators
    private By inventoryItemLocator = By.className("inventory_item");
    private By nameElementLocator = By.cssSelector(".inventory_item_label a");
    private By imageElementLocator = By.tagName("img");
    private By descriptionLocator = By.className("inventory_item_desc");
    private By priceLocator = By.className("inventory_item_price");
    private By inventoryBtnLocator = By.tagName("button");
    private By dropdownLocator = By.className("product_sort_container");
    // constructor
    public InventoryPage(WebDriver driver)
    {
       this.browser = driver;
    }
    // methods
    // returns a list of InventoryItem objects
    public List<InventoryItem> getInventoryItems(){
        // creates a new List
        List<InventoryItem> inventoryItemsList = new ArrayList<>();
        // gets all swagLabs inventory_items elements
        List<WebElement> InvenItemWebElements = browser.findElements(inventoryItemLocator);

        // gets each element's data and create a new InventoryItem object with it
        for (WebElement InvenItemElement : InvenItemWebElements)
        {
            WebElement nameElement = InvenItemElement.findElement(nameElementLocator);
            WebElement imageElement = InvenItemElement.findElement(imageElementLocator);
            String description = InvenItemElement.findElement(descriptionLocator).getText();
            double price = Double.parseDouble(InvenItemElement.findElement(priceLocator).getText().substring(1));
            WebElement inventoryBtn = InvenItemElement.findElement(inventoryBtnLocator);
            // adds new CartItem object in the list
            inventoryItemsList.add(new InventoryItem(nameElement, imageElement, description, price, inventoryBtn));
        }
        // return the list of CartItem objects
        return inventoryItemsList;
    }

    public InventoryItemPage clickInventoryItemImg(InventoryItem item, WebDriver driver )
    {
        item.imageElement.click();
        return new InventoryItemPage(driver);
    }
    public InventoryItemPage clickInventoryItemName(InventoryItem item, WebDriver driver )
    {
        item.nameElement.click();
        return new InventoryItemPage(driver);
    }

    public void selectSortingOption(int index){
        WebElement dropdown = browser.findElement(dropdownLocator);
        Select sortSelect = new Select(dropdown);

        switch (index){
            case 4:
                sortSelect.selectByValue("hilo");
                break;
            case 3:
                sortSelect.selectByValue("lohi");
                break;
            case 2:
                sortSelect.selectByValue("za");
                break;
            default:
                sortSelect.selectByValue("az");

        }
    }

}