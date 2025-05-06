package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryItemPage {
    //WebDriver
    WebDriver InventoryItemDriver;

    //Locators
    private By addToCartButton = By.className("btn_primary");
    private By backButton = By.className("inventory_details_back_button");
    private By headerLocator = By.className("product_label");
    private By cartNumber = By.className("fa-layers-counter");
    private By removeButton = By.className("btn_secondary");
    private By productName = By.className("inventory_details_name");
    private By productDescription = By.className("inventory_details_desc");
    private By productPrice = By.className("inventory_details_price");

    //constructor
    public InventoryItemPage(WebDriver driver)
    {
        this.InventoryItemDriver = driver;
    }

    //Actions
    public InventoryPage clickBackBtn(WebDriver driver){
        InventoryItemDriver.findElement(backButton).click();
        return new InventoryPage(driver);
    }

    //check the header in the inventory page after click on back button and navigate to inventory page

    public boolean checkProductHeaderIfIsDisplayed(){
        return InventoryItemDriver.findElement(headerLocator).isDisplayed();
    }

    public void clickAddToCartBtn(){
        InventoryItemDriver.findElement(addToCartButton).click();
    }

    public void clickRemoveBtn(){
        InventoryItemDriver.findElement(removeButton).click();
    }

    public String getProductName(){
        return InventoryItemDriver.findElement(productName).getText();
    }

    public String getProductDescription(){
        return InventoryItemDriver.findElement(productDescription).getText();
    }

    public int getProductPrice(){
        return Integer.parseInt(InventoryItemDriver.findElement(productPrice).getText().substring(1));
    }

    public boolean checkCartNumberIfIsDisplayed(){
        return InventoryItemDriver.findElement(cartNumber).isDisplayed();
    }


}
