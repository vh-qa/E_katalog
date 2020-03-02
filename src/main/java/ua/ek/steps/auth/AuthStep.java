package ua.ek.steps.auth;

import org.openqa.selenium.WebDriver;
import ua.ek.base.BasePage;
import ua.ek.pages.HomePage;
import ua.ek.pages.registration.AuthPage;
import ua.ek.pages.registration.RegistrationPage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.Helper;

public class AuthStep extends BaseStep {

    private WebDriver driver;
    private Helper helper;

    public AuthStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
        helper = new Helper(driver);
    }

    public RegistrationPage goAuthPage(WebDriver driver){
        RegistrationPage registrationPage = goHomePage(driver)
                .clickEnterLink();

        return registrationPage;
    }

    public AuthPage clickAuthLink() {
        helper.clickWebElement(getAuthPage().getAuthLink());
        return new AuthPage(driver);
    }

    public AuthPage enterLoginOrEmail(String loginOrEmail) {
        helper.enterTextInTextField(getAuthPage().getLoginOrEmailAuthField(), loginOrEmail);
        return new AuthPage(driver);
    }

    public AuthPage enterPassword(String password) {
        helper.enterTextInTextField(getAuthPage().getPasswordAuthField(), password);
        return new AuthPage(driver);
    }

    public AuthPage clickRememberMeCheckBoxAuth(){
        getAuthPage().getRememberMeCheckBoxAuth().click();
        return new AuthPage(driver);
    }

    public BasePage clickSubmitButton() {
        helper.clickWebElement(getAuthPage().getSubmitButtonAuth());
        return new AuthPage(driver);
    }

    public String getErrorAuthLoginText() {
        return helper.getWebElementText(getAuthPage().getErrorLoginAuth());
    }

    public String getErrorAuthPasswordText() {
        return helper.getWebElementText(getAuthPage().getErrorPasswordAuth());
    }

    public HomePage clickCloseLinkRegistrationForm(){
        helper.clickWebElement(getAuthPage().getCloseLinkRegistrationForm());
        return new HomePage(driver);
    }

    public HomePage clickLogOutFromUserProfileLink() {
        helper.clickWebElement(getAuthPage().getLogOutFromUserProfileLink());
        return new HomePage(driver);
    }
}
