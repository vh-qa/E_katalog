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
            properties.load(new InputStreamReader(this.getClass().getResourceAsStream("/properties/common.properties"), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unknown browser " + browser);
        }
    }
}