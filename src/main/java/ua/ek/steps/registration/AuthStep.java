package ua.ek.steps.registration;

import org.openqa.selenium.WebDriver;
import ua.ek.steps.HomeStep;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.AssertUtils;

public class AuthStep extends BaseStep {


    public AuthStep(WebDriver driver) {
        super(driver);

    }

    public AuthStep goAuthPage() {
        getHelper().clickWebElement(getHomePage().getEnterLink());
        return this;
    }

    public AuthStep clickAuthLink() {
        getHelper().clickWebElement(getAuthPage().getAuthLink());
        return this;
    }

    public AuthStep enterLoginOrEmail(String loginOrEmail) {
        getHelper().enterTextInTextField(getAuthPage().getLoginOrEmailAuthField(), loginOrEmail);
        return this;
    }

    public AuthStep enterPassword(String password) {
        getHelper().enterTextInTextField(getAuthPage().getPasswordAuthField(), password);
        return this;
    }

    public AuthStep clickRememberMeCheckBoxAuth() {
        getHelper().clickWebElement(getAuthPage().getRememberMeCheckBoxAuth());
        return this;
    }

    public AuthStep clickSubmitButton() {
        getHelper().clickWebElement(getAuthPage().getSubmitButtonAuth());
        return this;
    }

    public String getErrorAuthLoginText() {
        return getHelper().getTextFromWebElement(getAuthPage().getErrorLoginAuth());
    }

    public String getErrorAuthPasswordText() {
        return getHelper().getTextFromWebElement(getAuthPage().getErrorPasswordAuth());
    }

    public AuthStep clickCloseLinkRegistrationForm() {
        getHelper().clickWebElement(getAuthPage().getCloseLinkRegistrationForm());
        return this;
    }
}