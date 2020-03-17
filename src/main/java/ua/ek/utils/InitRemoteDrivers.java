package ua.ek.utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class InitRemoteDrivers {

    private String baseUrl;
    private String browser;
    private String os;
    private String node;

    private WebDriver driver;

    public void initWithDefaultValues() {
        String baseUrl = PropertyReader
                .from("/properties/common.properties", "base.url")
                .getProperty("base.url");

        String browser = PropertyReader
                .from("/properties/common.properties", "remote.driver.default.browser")
                .getProperty("remote.driver.default.browser");

        String os = PropertyReader
                .from("/properties/common.properties", "remote.driver.default.os")
                .getProperty("remote.driver.default.os");

        String node = PropertyReader
                .from("/properties/common.properties", "remote.driver.default.node")
                .getProperty("remote.driver.default.node");

        try {
            init(baseUrl, browser, os, node);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void init(String baseUrl, String browser, String os, String node) throws MalformedURLException {

        this.baseUrl = baseUrl;
        this.browser = browser;
        this.os = os;
        this.node = node;

        Platform platform = Platform.fromString(os);

        switch (browser.trim().toLowerCase()) {
            case IBrowsers.CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.BROWSER_NAME, browser);
                chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                chromeOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
                chromeOptions.addArguments("headless");

                driver = new RemoteWebDriver(new URL(node + "/wd/hub"), chromeOptions);
                break;
            case IBrowsers.FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(CapabilityType.BROWSER_NAME, browser);
                firefoxOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                firefoxOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                firefoxOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
                firefoxOptions.addArguments("headless");

                driver = new RemoteWebDriver(new URL(node + "/wd/hub"), firefoxOptions);
                break;
            default:
                throw new IllegalArgumentException("Unknown browser " + browser);
        }

        driver.manage().timeouts().implicitlyWait(IWaitTimes.THREE_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getBrowser() {
        return browser;
    }

    public String getOs() {
        return os;
    }

    public String getNode() {
        return node;
    }

    public WebDriver getDriver() {
        return driver;
    }
}