package ua.ek.steps.base;

import org.openqa.selenium.WebDriver;
import ua.ek.utils.Helper;
import ua.ek.utils.InitRemoteDrivers;

public class BaseStepBdd {
    private WebDriver driver;
    private Helper helper;

    public BaseStepBdd() {
        InitRemoteDrivers initRemoteDrivers = new InitRemoteDrivers();
        initRemoteDrivers.initWithDefaultValues();
        driver = initRemoteDrivers.getDriver();
        helper = new Helper(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Helper getHelper() {
        return helper;
    }
}