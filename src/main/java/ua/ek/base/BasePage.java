package ua.ek.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}