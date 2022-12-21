package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement userNameTxtBox;

    @FindBy(id = "password")
    private WebElement passwordTxtBox;

    @FindBy(id="login-button")
    private WebElement loginBtn;

    public void enterUserName(String userName){
        enterText(userNameTxtBox, userName);
    }

    public void enterPassword(String password){
        enterText(passwordTxtBox, password);
    }

    public void clickOnLogin(){
        clickOnElement(loginBtn);
    }

    public boolean loginButtonDisplayed(){
        waitElementToAppear(loginBtn);
        return loginBtn.isDisplayed();
    }

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
