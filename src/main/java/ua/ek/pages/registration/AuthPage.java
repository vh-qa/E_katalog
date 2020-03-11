package ua.ek.pages.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class AuthPage extends BasePage {

    @FindBy(xpath = ".//div[@class='signin-with-wrap clearfix']/div[@class=\"signin-with signin-with-ek d-flex justify-content-center align-items-center\"]")
    private WebElement authLink; // 'Войти' link on the registration form

    @FindBy(xpath = ".//div[@class='signin-name ek-form-group']/input[@class='ek-form-control']")
    private WebElement loginOrEmailAuthField;

    @FindBy(xpath = ".//div[@class='signin-password ek-form-group']/input[@class='ek-form-control']")
    private WebElement passwordAuthField;

    @FindBy(xpath = ".//div[@class='signin-remember grey d-flex align-items-center']/input[@name='remember_me_']")
    private WebElement rememberMeCheckBoxAuth;

    @FindBy(xpath = ".//div[@class='signin-actions ml-auto']/button[@class='ek-form-btn']")
    private WebElement backButtonAuth;

    @FindBy(xpath = ".//div[@class='signin-actions ml-auto']/button[@class='ek-form-btn blue']")
    private WebElement submitButtonAuth;

    @FindBy(xpath = ".//div[@class='signin-name ek-form-group invalid']/div[@class='ek-form-text']")
    private WebElement errorLoginAuth; // Введите логин/email!

    @FindBy(xpath = ".//div[@class='signin-password ek-form-group invalid']/div[@class='ek-form-text']")
    private WebElement errorPasswordAuth; // Введите пароль!

    @FindBy(xpath = ".//button[@class='swal2-close']")
    private WebElement closeLinkRegistrationForm;

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAuthLink() {
        return authLink;
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

