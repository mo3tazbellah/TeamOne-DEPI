package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MethodHandles;

import java.util.ArrayList;
import java.util.List;

public class CheckoutStepTwoPage extends MethodHandles {
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    private final By assertInCheckOutStepTwoPage=By.xpath("//*[text()=\"Checkout: Overview\"]");
    private final By fishButton=By.xpath("//*[text()=\"FINISH\"]");

    private final By itemsName=By.className("inventory_item_name");
    private final By itemsPrice=By.className("inventory_item_price");


    public String getAssertInCheckOutStepTwoPage() {
        return getText(assertInCheckOutStepTwoPage);
    }

    public List<String> getAllProductNames() {
        List<WebElement> productElements = driver.findElements(itemsName);
        List<String> productNames = new ArrayList<>();
        for (WebElement elem : productElements) {
            productNames.add(elem.getText());
        }
        return productNames;
    }

    public List<Double> getAllProductPrices() {
        List<WebElement> priceElements = driver.findElements(itemsPrice);
        List<Double> productPrices = new ArrayList<>();
        for (WebElement elem : priceElements) {
            String priceText = elem.getText().replace("$", "");
            productPrices.add(Double.parseDouble(priceText));
        }
        return productPrices;
    }



    public double totalPrice() {
        List<Double> productPrices = getAllProductPrices();
        double total = 0;
        for (double price : productPrices) {
            total += price;
        }
        total += 7.20;
        return total;
    }

    public CheckoutCompletePage clickFinishButton() {
        click(fishButton,5);
        return new CheckoutCompletePage(driver);
    }

}