package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.InventoryPage;
import settings.DriverSetup;

public class InventoryPageSteps extends DriverSetup {
    InventoryPage inventoryPage = new InventoryPage(driver);

    @Given("I am in inventory page")
    public void iValidateInventoryPageDisplayed(){
        Assert.assertTrue(inventoryPage.pageTitleDisplayed(), "Inventory page is not displayed.");
    }

    @When("I add {string} to cart")
    public void iAddItemToCart(String item) {
        CheckoutSteps.items.add(item);
        inventoryPage.addItemToCart(item);
    }

    @When("I go to my shopping cart")
    public void iGoToShoppingCart(){
        inventoryPage.goToCart();
    }
}
