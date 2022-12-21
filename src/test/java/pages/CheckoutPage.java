package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckoutPage extends BasePage {
    @FindBy(css = ".inventory_item_name")
    private List<WebElement> itemsInCart;

    @FindBy(id = "first-name")
    private WebElement firstNameTxtBox;

    @FindBy(id = "last-name")
    private WebElement lastNameTxtBox;

    @FindBy(id = "postal-code")
    private WebElement pcTxtBox;

    @FindBy(id = "continue")
    private WebElement continueBtn;


    public List<String> getItemsInCartText(){
        List<String> items = new ArrayList<>();
        itemsInCart.forEach(item->items.add(item.getText()));
        return items;
    }

    public void fillForm(Map<String, String> map){
        enterText(firstNameTxtBox, map.get("First Name"));
        enterText(lastNameTxtBox, map.get("Last Name"));
        enterText(pcTxtBox, map.get("Zip/Postal Code"));
    }

    public void clickOnContinue(){
        clickOnElement(continueBtn);
    }

    public CheckoutPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
