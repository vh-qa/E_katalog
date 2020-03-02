package ua.ek.registration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.model.User;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.DataGenerator;

public class AuthPageTest extends BaseTest {

    @BeforeMethod
    public void openAuthFormBeforeTest() {
        authStep.goAuthPage(driver);
        authStep.clickAuthLink();
    }

    // Positive scenario

    @Test
    public void authSuccessfulTestWithLogin() {
        User user = DataGenerator.getPositiveUserData();

        authStep.enterLoginOrEmail(user.getLogin());
        authStep.enterPassword(user.getPassword());
        authStep.clickRememberMeCheckBoxAuth(); // uncheck checkbox
        authStep.clickSubmitButton();
        AssertUtils.makeAssert(authStep.getAuthPage().getNickLinkText(),
                "some-login-12345");

        authStep.clickLogOutFromUserProfileLink();
    }

    @Test
    public void authSuccessfulTestWithEmail() {
        User user = DataGenerator.getPositiveUserData();

        authStep.enterLoginOrEmail(user.getEmail());
        authStep.enterPassword(user.getPassword());
        authStep.clickRememberMeCheckBoxAuth(); // uncheck checkbox
        authStep.clickSubmitButton();
        AssertUtils.makeAssert(authStep.getAuthPage().getNickLinkText(),
                "some-login-12345");

        authStep.clickLogOutFromUserProfileLink();
    }

    // Negative scenario

    @Test
    public void authUnSuccessfulTestWithLogin() {
        User user = DataGenerator.getUserDataForUnSuccessfulTestWithLogin();

        authStep.enterLoginOrEmail(user.getLogin());
        authStep.enterPassword(user.getPassword());
        authStep.clickSubmitButton();

        AssertUtils.makeAssert(authStep.getErrorAuthLoginText(),
                "Введите логин/email!");

        authStep.clickCloseLinkRegistrationForm();
    }

    @Test
    public void authUnSuccessfulTestWithEmail() {
        User user = DataGenerator.getUserDataForUnSuccessfulTestWithEmail();

        authStep.enterLoginOrEmail(user.getEmail());
        authStep.enterPassword(user.getPassword());
        authStep.clickSubmitButton();

        AssertUtils.makeAssert(authStep.getErrorAuthLoginText(),
                "Введите логин/email!");

        authStep.clickCloseLinkRegistrationForm();
    }

    @Test
    public void authUnSuccessfulTestWithPassword() {
        User user = DataGenerator.getUserDataForUnSuccessfulTestWithPassword();

        authStep.enterLoginOrEmail(user.getLogin());
        authStep.enterPassword(user.getPassword());
        authStep.clickSubmitButton();
        AssertUtils.makeAssert(authStep.getErrorAuthPasswordText(),
                "Введите пароль!");

        authStep.clickCloseLinkRegistrationForm();
    }
}