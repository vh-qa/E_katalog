package ua.ek.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage implements IBasePage {
    public BasePage(WebDriver driver) {
        init(driver);
    }

    @Override
    public void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}