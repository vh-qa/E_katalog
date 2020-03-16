package ua.ek.steps.registration;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.registration.AuthPage;
import ua.ek.pages.registration.UserProfilePage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.PageType;

public class AuthStep extends BaseStep {

    private AuthPage authPage;
    private UserProfilePage userProfilePage;

    public AuthStep(WebDriver driver) {
        super(driver);
        authPage = (AuthPage) getPage(PageType.AUTH_PAGE, driver);
        userProfilePage = (UserProfilePage) getPage(PageType.USER_PROFILE_PAGE, driver);
    }

    public AuthPage getAuthPage() {
        return authPage;
    }

    public UserProfilePage getUserProfilePage() {
        return userProfilePage;
    }

    public AuthStep goAuthPage() {
        getHelper().clickWebElement(getHomePage().getEnterLink());
        return this;
    }

    public AuthStep clickAuthLink() {
        getHelper().clickWebElement(authPage.getAuthLinkOnAuthForm());
        return this;
    }

    public AuthStep enterLoginOrEmail(String loginOrEmail) {
        getHelper().enterTextInTextField(authPage.getLoginOrEmailAuthField(), loginOrEmail);
        return this;
    }

    public AuthStep enterPassword(String password) {
        getHelper().enterTextInTextField(authPage.getPasswordAuthField(), password);
        return this;
    }

    public AuthStep clickRememberMeCheckBoxAuth() {
        getHelper().clickWebElement(authPage.getRememberMeCheckBoxAuth());
        return this;
    }

    public AuthStep clickSubmitButton() {
        getHelper().clickWebElement(authPage.getSubmitButtonAuth());
        return this;
    }

    public String getUserProfileNickLinkText() {
        return getHelper().getTextFromStalenessOfWebElement(userProfilePage.getNickLink());
    }

    public String getErrorAuthLoginText() {
        return getHelper().getTextFromWebElement(authPage.getErrorLoginAuth());
    }

    public String getErrorAuthPasswordText() {
        return getHelper().getTextFromWebElement(authPage.getErrorPasswordAuth());
    }

    public AuthStep clickCloseLinkRegistrationForm() {
        getHelper().clickVisibleWebElementWithJS(authPage.getCloseLinkRegistrationForm());
        return this;
    }
}