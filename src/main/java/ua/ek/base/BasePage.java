package ua.ek.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import ua.ek.utils.Helper;

public abstract class BasePage {

    private WebDriver driver;
    private Helper helper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        helper = new Helper(driver);
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Helper getHelper() {
        return helper;
    }
}