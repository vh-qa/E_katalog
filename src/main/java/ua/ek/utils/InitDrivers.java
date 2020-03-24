package ua.ek.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class InitDrivers {

    private WebDriver driver;

    public void setUp(String browser) {
        initWebDrivers(browser);

        driver.manage().timeouts().implicitlyWait(IWaitTimes.THREE_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    private void initWebDrivers(String browser) {

        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader
                    (this.getClass()
                            .getResourceAsStream(PropertyFiles.COMMON_PROPERTY.getPropertyFileName()),
                                                 PropertyNames.CHARSET_NAME_UTF8.getPropertyName()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (browser) {
            case IBrowsers.CHROME:
                System.setProperty(PropertyNames.WEBDRIVER_CHROME_DRIVER.getPropertyName(),
                        properties.getProperty(PropertyNames.CHROME_DRIVER.getPropertyName()));
                driver = new ChromeDriver();
                break;
            case IBrowsers.FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException(PropertyNames.UNKNOWN_BROWSER.getPropertyName() + " " + browser);
        }
    }
}