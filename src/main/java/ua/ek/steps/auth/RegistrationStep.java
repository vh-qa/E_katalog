package ua.ek.steps.auth;

import org.openqa.selenium.WebDriver;
import ua.ek.base.BasePage;
import ua.ek.pages.HomePage;
import ua.ek.pages.registration.RegistrationPage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.Helper;

public class RegistrationStep extends BaseStep {

    private WebDriver driver;
    private Helper helper;

    public RegistrationStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
        helper = new Helper(driver);
    }

    public RegistrationPage goAuthPage(WebDriver driver){
        RegistrationPage registrationPage = goHomePage(driver)
                .clickEnterLink();

        return registrationPage;
    }

    public RegistrationPage clickRegisterLink() {
        helper.clickWebElement(getRegistrationPage().getRegisterLink());
        return new RegistrationPage(driver);
    }

    public RegistrationPage enterLogin(String login) {
        helper.enterTextInTextField(getRegistrationPage().getLoginField(), login);
        return new RegistrationPage(driver);
    }

    public RegistrationPage enterEmail(String email) {
        helper.enterTextInTextField(getRegistrationPage().getEmailField(), email);
        return new RegistrationPage(driver);
    }

    public RegistrationPage enterPassword(String password) {
        helper.enterTextInTextField(getRegistrationPage().getPasswordField(), password);
        return new RegistrationPage(driver);
    }

    public BasePage clickCloseLink() {
        helper.getWebElementText(getRegistrationPage().getCloseLinkRegistrationForm());
        return new HomePage(driver);
    }

    public BasePage clickSubmitButton() {
        helper.clickWebElement(getRegistrationPage().getSubmitButton());
        return new RegistrationPage(driver);
    }

    public String getSuccessfulUserRegistrationTextFromWebElement() {
        return helper.getWebElementText(getRegistrationPage().getSuccessfulUserRegistrationElement());
    }
}