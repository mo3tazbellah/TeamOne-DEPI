package tests;

import handlers.InventoryItem;
import org.testng.annotations.Test;
import pages.InventoryPage;

import java.util.List;

public class InventoryTest extends BaseTest {
    @Test(priority = 2)
    public void inventoryItemTest() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        List<InventoryItem> inventoryItemsList =inventoryPage.getInventoryItems();
        inventoryItemsList.get(0).inventoryBtnElem.click();
        inventoryItemsList.get(1).inventoryBtnElem.click();
        inventoryItemsList.get(3).inventoryBtnElem.click();
    }
}
