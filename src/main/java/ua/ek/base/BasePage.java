package ua.ek.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.ek.utils.Helper;

public abstract class BasePage {

    protected WebDriver driver;
    protected Helper helper;

    @FindBy(xpath = ".//span[@class='wu_entr']//em")
    private WebElement enterLink; // "Войти" link

    public BasePage(WebDriver driver) {
        this.driver = driver;
        helper = new Helper(driver);
        PageFactory.initElements(driver, this);
    }

    protected WebElement getEnterLink() {
        if (helper.isWebElementDisplayed(enterLink)) {
            return enterLink;
        }
        return null;
    }
}