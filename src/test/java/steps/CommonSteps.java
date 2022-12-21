package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CommonPage;
import pages.LoginPage;
import settings.DriverSetup;
import settings.PropertiesFile;

public class CommonSteps extends DriverSetup {
    LoginPage loginPage = new LoginPage(driver);
    CommonPage commonPage = new CommonPage(driver);

    @Given("I navigate to the app")
    public void iNavigateToTheApp(){
        driver.get(new PropertiesFile().getProperty("url"));
    }

    @Given("I log in as {string} user")
    public void iLogInAsUser(String userType){
        switch (userType){
            case "standard":
                loginPage.enterUserName(new PropertiesFile().getProperty("standard-username"));
                loginPage.enterPassword(new PropertiesFile().getProperty("standard-password"));
                loginPage.clickOnLogin();
        }
    }

    @When("I click on {string} button")
    public void iClickOnButton(String text){
        commonPage.clickOnButtonByXpathText(text);
    }

    @Then("I validate {string} message is displayed")
    public void iValidateMessageIsDisplayed(String message){
        Assert.assertTrue(commonPage.findElementByXpathText(message).isDisplayed(), "There was a problem processing the order.");
    }

    @When("I select {string} option on nav bar")
    public void selectNavBarOption(String option){
        commonPage.openNavBar();
        iClickOnButton(option);
    }
}
