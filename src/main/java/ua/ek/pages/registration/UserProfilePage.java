package ua.ek.pages.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class UserProfilePage extends BasePage {

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

    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getNickLink() {
        return nickLink;
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