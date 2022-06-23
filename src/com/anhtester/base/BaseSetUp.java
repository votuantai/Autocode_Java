package com.anhtester.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


//initialization and closed the driver
public class BaseSetUp {
    private WebDriver driver;

    static String driverPath = "Resources\\drivers\\";

    public WebDriver getDriver() {
        return driver;
    }

    //create a function driver nomination
    private void setDriver(String browserType, String appURL) { 
        switch(browserType) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFireFoxDriver(appURL);
                break;
            default:
                System.out.println("Browser: " + browserType + "invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver(appURL);
        }
    }

    // browser configuration
    public static WebDriver initChromeDriver(String appURl) {
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURl);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    public static WebDriver initFireFoxDriver(String appURL){
        System.out.println("Launching FireFox browser...");
        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    @Parameters({ "browserType", "appURL"})
    @BeforeClass
    public void initializeTestBaseSetup(String browserType, String appURL) {
        try {
            setDriver(browserType, appURL);
        } catch (Exception e) {
            System.out.println("Error..." + e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
