package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage extends BasePage{

    @FindBy(id = "react-burger-menu-btn")
    private WebElement navBarOpenBtn;

    public void clickOnButtonByXpathText(String text){
        clickOnElement(findElementByXpathText(text));
    }

    public void openNavBar(){
        clickOnElement(navBarOpenBtn);
    }

    public CommonPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
