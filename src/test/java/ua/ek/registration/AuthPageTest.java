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
        getAuthStep().goAuthPage()
                .clickAuthLink();
    }

    // Positive scenario

    @Test
    public void authSuccessfulTestWithLogin() {
        User user = DataGenerator.getPositiveUserData();

        getAuthStep().enterLoginOrEmail(user.getLogin())
                .enterPassword(user.getPassword())
                .clickRememberMeCheckBoxAuth() // uncheck checkbox
                .clickSubmitButton();

        AssertUtils.makeAssert(getUserProfileStep().getNickLinkText(),
                "some_login_15");

        getUserProfileStep().clickLogOutFromUserProfileLink();
    }

    @Test
    public void authSuccessfulTestWithEmail() {
        User user = DataGenerator.getPositiveUserData();

        getAuthStep().enterLoginOrEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .clickRememberMeCheckBoxAuth() // uncheck checkbox
                .clickSubmitButton();

        AssertUtils.makeAssert(getUserProfileStep().getNickLinkText(),
                "some_login_15");

        getUserProfileStep().clickLogOutFromUserProfileLink();
    }

    // Negative scenario

    @Test
    public void authUnSuccessfulTestWithLogin() {
        User user = DataGenerator.getUserDataForUnSuccessfulTestWithLogin();

        getAuthStep().enterLoginOrEmail(user.getLogin())
                .enterPassword(user.getPassword())
                .clickSubmitButton();

        AssertUtils.makeAssert(getAuthStep().getErrorAuthLoginText(),
                "Введите логин/email!");

        getAuthStep().clickCloseLinkRegistrationForm();
    }

    @Test
    public void authUnSuccessfulTestWithEmail() {
        User user = DataGenerator.getUserDataForUnSuccessfulTestWithEmail();

        getAuthStep().enterLoginOrEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .clickSubmitButton();

        AssertUtils.makeAssert(getAuthStep().getErrorAuthLoginText(),
                "Введите логин/email!");

        getAuthStep().clickCloseLinkRegistrationForm();
    }

    @Test
    public void authUnSuccessfulTestWithPassword() {
        User user = DataGenerator.getUserDataForUnSuccessfulTestWithPassword();

        getAuthStep().enterLoginOrEmail(user.getLogin())
                .enterPassword(user.getPassword())
                .clickSubmitButton();

        AssertUtils.makeAssert(getAuthStep().getErrorAuthPasswordText(),
                "Введите пароль!");

        getAuthStep().clickCloseLinkRegistrationForm();
    }
}