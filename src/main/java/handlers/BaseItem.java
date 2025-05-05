package handlers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseItem {
        public WebElement nameElement;
        public String description;
        public double price;

        // constructor
        public BaseItem(WebElement nameElement, String description, double price) {
            this.nameElement = nameElement;
            this.description = description;
            this.price = price;
        }
}
