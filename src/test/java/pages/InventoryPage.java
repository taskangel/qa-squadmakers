package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage {
    @FindBy(css = ".title")
    private WebElement pageTitle;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartBtn;

    public boolean pageTitleDisplayed(){
        waitElementToAppear(pageTitle);
        return pageTitle.isDisplayed();
    }

    public void addItemToCart(String itemName){
        WebElement element = findElementByXpathText(itemName);//.findElement(By.xpath("//parent::a/parent::div/following-sibling::div/button"));
        scrollToElement(element);
        clickOnElement(element);
        clickOnElement(findElementByXpathText("Add to cart"));
        clickOnElement(findElementByXpathText("Back to products"));
    }

    public void goToCart(){
        clickOnElement(shoppingCartBtn);
    }

    public InventoryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
