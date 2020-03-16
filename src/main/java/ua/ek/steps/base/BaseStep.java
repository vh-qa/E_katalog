package ua.ek.steps.base;

import org.openqa.selenium.WebDriver;
import ua.ek.base.BasePage;
import ua.ek.pages.HomePage;
import ua.ek.utils.*;

public abstract class BaseStep {

    private Helper helper;
    private HomePage homePage;

    public BaseStep(WebDriver driver){
        helper = new Helper(driver);
        homePage = new HomePage(driver);
    }

    public BasePage getPage(PageType pageType, WebDriver driver){
        PageFactory pageFactory = new PageFactory();
        return pageFactory.createPage(pageType, driver);
    }

    public Helper getHelper() {
        return helper;
    }

    public HomePage getHomePage() {
        return homePage;
    }
}