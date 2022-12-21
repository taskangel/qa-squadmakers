package settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverSetup {
    protected static WebDriver driver = null;

    public DriverSetup(){
        initialize();
    }

    private void initialize(){
        if(driver==null){
            createDriverInstance();
        }
    }

    private void createDriverInstance(){
        String browser = new PropertiesFile().getProperty("browser");
        boolean headless = new PropertiesFile().getHeadless();

        if(browser.equalsIgnoreCase("chrome")){
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                if(headless){
                    chromeOptions.addArguments("--headless");
                }
                driver = new ChromeDriver(chromeOptions);
        } else if(browser.equalsIgnoreCase( "firefox")){
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                if (headless){
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitingTime.getWaitImplicitly()));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WaitingTime.getWaitForPageLoad()));
    }

    public static void destroyDriver(){
        driver.close();
        driver.quit();
        driver = null;
    }
}
