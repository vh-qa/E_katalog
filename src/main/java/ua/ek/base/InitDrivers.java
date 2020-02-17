package ua.ek.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ua.ek.utils.PropertyReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class InitDrivers {
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) throws Exception {
        initDrivers(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private void initDrivers(String browser) {

/*
        String commonProperties = "src/main/resources/common.properties";
        Properties properties = new Properties();

        if(commonProperties != null) {
            try {
                properties.load(new FileReader(commonProperties));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
*/

        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(this.getClass().getResourceAsStream("/common.properties"), "UTF-8"));
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
