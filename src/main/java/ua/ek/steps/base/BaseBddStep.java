package ua.ek.steps.base;

import org.openqa.selenium.WebDriver;
import ua.ek.utils.InitDrivers;

public class BaseBddStep {

    public static WebDriver getWebDriver() {
        InitDrivers initDrivers = new InitDrivers();
        initDrivers.setUp("chrome");
        return initDrivers.getWebDriver();
    }
}