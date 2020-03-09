package ua.ek.pages.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class AuthPage extends BasePage {

    @FindBy(xpath = ".//div[@class='l-m']/div/em[contains(text(),'Войти')]")
    private WebElement authLink; // 'Войти' link on the registration form

    @FindBy(xpath = ".//div[@id='mui_user_login_window_avt']/input[@type='text']")
    private WebElement loginOrEmailAuthField;

    @FindBy(xpath = ".//div[@id='mui_user_login_window_avt']/div/input[@type='password']")
    private WebElement passwordAuthField;

    @FindBy(xpath = ".//input[@id='wu_l_frm']")
    private WebElement rememberMeCheckBoxAuth;

    @FindBy(xpath = ".//input[@type='submit' and @value='Войти']")
    private WebElement submitButtonAuth;

//    @FindBy(xpath = ".//div[@class='l-err' and contains(text(),'Введите логин')]")
//    private WebElement errorLoginAuth; // Введите логин/email!

    @FindBy(xpath = ".//div[@id='mui_user_login_window_avt']/div[@class='l-err']")
    private WebElement errorLoginAuth;

//    @FindBy(xpath = ".//div[@class='l-err' and contains(text(),'Введите пароль')]")
//    private WebElement errorPasswordAuth; // Введите пароль!

    @FindBy(xpath = ".//div[@id='mui_user_login_window_avt']/div[@class='l-err']")
    private WebElement errorPasswordAuth;

    @FindBy(xpath = ".//div[@class='jclose']")
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