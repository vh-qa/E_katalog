package ua.ek.steps.registration;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.registration.RegistrationPage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.PageType;

public class RegistrationStep extends BaseStep {

    private RegistrationPage registrationPage;

    public RegistrationStep(WebDriver driver) {
        super(driver);
        registrationPage = (RegistrationPage) getPage(PageType.REGISTRATION_PAGE, driver);
    }

    public RegistrationPage getRegistrationPage() {
        return registrationPage;
    }

    public RegistrationStep goAuthPage(){
        getHelper().clickWebElement(getHomePage().getEnterLink());
        return this;
    }

    public String getRegisterLinkOnRegistrationFormText(){
        return getHelper().getTextFromStalenessOfWebElement(registrationPage.getRegisterLinkOnRegistrationForm());
    }

    public RegistrationStep clickRegisterLink() {
        getHelper().clickWebElement(registrationPage.getRegisterLinkOnRegistrationForm());
        return this;
    }

    public RegistrationStep enterLogin(String login) {
        getHelper().enterTextInTextField(registrationPage.getLoginField(), login);
        return this;
    }

    public RegistrationStep enterEmail(String email) {
        getHelper().enterTextInTextField(registrationPage.getEmailField(), email);
        return this;
    }

    public RegistrationStep enterPassword(String password) {
        getHelper().enterTextInTextField(registrationPage.getPasswordField(), password);
        return this;
    }

    public RegistrationStep clickCloseLink() {
        getHelper().getTextFromWebElement(registrationPage.getCloseLinkRegistrationForm());
        return this;
    }

    public RegistrationStep clickSubmitButton() {
        getHelper().clickWebElement(registrationPage.getSubmitButton());
        return this;
    }

    public String getSuccessfulUserRegistrationTextFromHeaderElement() {
        return getHelper().getTextFromStalenessOfWebElement(registrationPage.getSuccessfulUserRegistrationHeaderElement());
    }

    public String getSuccessfulUserRegistrationButtonText(){
        return getHelper().getTextFromStalenessOfWebElement(registrationPage.getSuccessfulUserRegistrationButton());
    }

    public String getLoginErrorMessage(){
        return getHelper().getTextFromWebElement(registrationPage.getLoginErrorElement());
    }

    public String getEmailErrorMessage(){
        return getHelper().getTextFromWebElement(registrationPage.getEmailErrorElement());
    }

    public String getEmailIncorrectErrorMessage(){
        return getHelper().getTextFromWebElement(registrationPage.getEmailIncorrectErrorElement());
    }

    public String getPasswordErrorMessage(){
        return getHelper().getTextFromWebElement(registrationPage.getPasswordErrorElement());
    }
}