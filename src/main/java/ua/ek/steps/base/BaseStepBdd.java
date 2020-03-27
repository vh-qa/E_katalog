package ua.ek.steps.base;

import org.openqa.selenium.WebDriver;
import ua.ek.base.BasePage;
import ua.ek.pages.HomePage;
import ua.ek.utils.Helper;
import ua.ek.utils.InitRemoteDrivers;
import ua.ek.utils.PageFactory;
import ua.ek.utils.PageType;

public abstract class BaseStepBdd {
    private WebDriver driver;
    private HomePage homePage;
    private Helper helper;

    public BaseStepBdd() {
        InitRemoteDrivers initRemoteDrivers = new InitRemoteDrivers();
        initRemoteDrivers.initWithDefaultValues();
        driver = initRemoteDrivers.getDriver();
        homePage = new HomePage(driver);
        helper = new Helper(driver);
    }

    public BasePage getPage(PageType pageType, WebDriver driver){
        PageFactory pageFactory = new PageFactory();
        return pageFactory.createPage(pageType, driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public Helper getHelper() {
        return helper;
    }
}