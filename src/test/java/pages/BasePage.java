package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.WaitingTime;

import java.time.Duration;

public class BasePage {
    final private WebDriverWait wait;
    final private WebDriver driver;
    final private JavascriptExecutor javascriptExecutor;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(WaitingTime.getWaitForElement()));
        javascriptExecutor = (JavascriptExecutor) this.driver;
    }

    public void waitElementToAppear(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void enterText(WebElement element, String text){
        waitElementToAppear(element);
        element.sendKeys(text);
    }

    public void clickOnElement(WebElement element){
        waitElementToBeClickable(element);
        element.click();
    }

    public WebElement findElementByXpathText(String text){
        return driver.findElement(By.xpath("//*[contains(text(),'"+text+"')]"));
    }

    public void scrollToElement(WebElement element){
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",element);
    }
}
