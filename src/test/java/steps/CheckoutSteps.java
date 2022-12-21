package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CheckoutPage;
import settings.DriverSetup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckoutSteps extends DriverSetup {
    public static List<String> items = new ArrayList<>();
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Then("I validate items in checkout are the same I added")
    public void iValidateItemsInCheckout(){
        Assert.assertEquals(items, checkoutPage.getItemsInCartText(), "Items are not equals.");
        items.clear();
    }

    @When("I fill checkout form with following information")
    public void fillCheckoutForm(DataTable dataTable){
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        checkoutPage.fillForm(map);
    }

    @When("I click on continue button")
    public void iClickOnContinue(){
        checkoutPage.clickOnContinue();
    }
}
