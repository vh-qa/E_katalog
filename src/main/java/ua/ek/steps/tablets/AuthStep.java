package ua.ek.steps.tablets;

import org.openqa.selenium.WebDriver;
import ua.ek.base.BasePage;
import ua.ek.pages.HomePage;
import ua.ek.pages.registration.AuthPage;
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

    public AuthPage goAuthPage(WebDriver driver){
        AuthPage authPage = goHomePage(driver)
                .clickEnterLink();

        return authPage;
    }

    public AuthPage clickRegisterLink() {
        helper.clickWebElement(getAuthPage().getRegisterLink());
        return new AuthPage(driver);
    }

    public AuthPage enterLogin(String login) {
        helper.enterTextInTextField(getAuthPage().getLoginField(), login);
        return new AuthPage(driver);
    }

    public AuthPage enterEmail(String email) {
        helper.enterTextInTextField(getAuthPage().getEmailField(), email);
        return new AuthPage(driver);
    }

    public AuthPage enterPassword(String password) {
        helper.enterTextInTextField(getAuthPage().getPasswordField(), password);
        return new AuthPage(driver);
    }

    public BasePage clickCloseLink() {
        helper.getWebElementText(getAuthPage().getCloseLink());
        return new HomePage(driver);
    }

    public BasePage clickSubmitButton() {
        helper.clickWebElement(getAuthPage().getSubmit());
        return new AuthPage(driver);
    }
}