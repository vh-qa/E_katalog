package ua.ek.pages.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class AuthPage extends BasePage {

    // Auth page

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

    @FindBy(xpath = ".//div[@class='l-err' and contains(text(),'Введите логин')]")
    private WebElement errorLoginAuth; // Введите логин/email!

    @FindBy(xpath = ".//div[@class='l-err' and contains(text(),'Введите пароль')]")
    private WebElement errorPasswordAuth; // Введите пароль!

    @FindBy(xpath = ".//div[@class='jclose']")
    private WebElement closeLinkRegistrationForm;

    // User Profile page

    @FindBy(xpath = ".//a[@class='info-nick']")
    private WebElement nickLink;

    @FindBy(xpath = ".//a[@class='user-menu__edit']")
    private WebElement editUserMenuLink;

    @FindBy(xpath = ".//input[@class='ek-form-control' and @name='p_[NikName]']")
    private WebElement nickInUserProfileField; // Ваш ник (check value attribute)

    @FindBy(xpath = ".//input[@class='ek-form-control' and @name='p_[EMail]']")
    private WebElement emailInUserProfileField; // E-mail (check value attribute)

    @FindBy(xpath = ".//a[@class='help2']")
    private WebElement logOutFromUserProfileLink;

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

    public WebElement getNickLink() {
        return nickLink;
    }

    public String getNickLinkText(){
        return helper.getWebElementText(nickLink);
    }

    public WebElement getEditUserMenuLink() {
        return editUserMenuLink;
    }

    public WebElement getNickInUserProfileField() {
        return nickInUserProfileField;
    }

    public WebElement getEmailInUserProfileField() {
        return emailInUserProfileField;
    }

    public WebElement getLogOutFromUserProfileLink() {
        return logOutFromUserProfileLink;
    }
}
