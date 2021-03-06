package ua.ek.pages.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class AuthPage extends BasePage {

    @FindBy(xpath = ".//div[contains(@class, 'signin-with-ek')]")
    private WebElement authLinkOnAuthForm;

    @FindBy(xpath = ".//div[@class='signin-name ek-form-group']/input[@class='ek-form-control']")
    private WebElement loginOrEmailAuthField;

    @FindBy(xpath = ".//div[@class='signin-password ek-form-group']/input[@class='ek-form-control']")
    private WebElement passwordAuthField;

    @FindBy(xpath = ".//input[@name='remember_me_']")
    private WebElement rememberMeCheckBoxAuth;

    @FindBy(xpath = ".//div[@class='signin-actions ml-auto']/button[@class='ek-form-btn']")
    private WebElement backButtonAuth;

    @FindBy(xpath = ".//div[@class='signin-actions ml-auto']/button[@class='ek-form-btn blue']")
    private WebElement submitButtonAuth;

    @FindBy(xpath = ".//div[@class='signin-name ek-form-group invalid']/div[@class='ek-form-text']")
    private WebElement errorLoginAuth;

    @FindBy(xpath = ".//div[@class='signin-password ek-form-group invalid']/div[@class='ek-form-text']")
    private WebElement errorPasswordAuth;

    @FindBy(xpath = ".//button[@class='swal2-close']")
    private WebElement closeLinkRegistrationForm;

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAuthLinkOnAuthForm() {
        return authLinkOnAuthForm;
    }

    public WebElement getLoginOrEmailAuthField() {
        return loginOrEmailAuthField;
    }

    public WebElement getPasswordAuthField() {
        return passwordAuthField;
    }

    public WebElement getRememberMeCheckBoxAuth() {
        return rememberMeCheckBoxAuth;
    }

    public WebElement getBackButtonAuth() {
        return backButtonAuth;
    }

    public WebElement getSubmitButtonAuth() {
        return submitButtonAuth;
    }

    public WebElement getErrorLoginAuth() {
        return errorLoginAuth;
    }

    public WebElement getErrorPasswordAuth() {
        return errorPasswordAuth;
    }

    public WebElement getCloseLinkRegistrationForm() {
        return closeLinkRegistrationForm;
    }
}