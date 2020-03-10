package ua.ek.registration;

import io.qameta.allure.Description;
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

    @Test(description = "Positive auth scenario")
    @Description("Test Description: Successful auth test using valid login and password")
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

    @Test(description = "Positive auth scenario")
    @Description("Test Description: Successful auth test using valid email and password")
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

    @Test(description = "Negative auth scenario")
    @Description("Test Description: Unsuccessful auth test using invalid login")
    public void authUnSuccessfulTestWithLogin() {
        User user = DataGenerator.getUserDataForUnSuccessfulTestWithLogin();

        getAuthStep().enterLoginOrEmail(user.getLogin())
                .enterPassword(user.getPassword())
                .clickSubmitButton();

        AssertUtils.makeAssert(getAuthStep().getErrorAuthLoginText(),
                "Введите логин/email!");

        getAuthStep().clickCloseLinkRegistrationForm();
    }

    @Test(description = "Negative auth scenario")
    @Description("Test Description: Unsuccessful auth test using invalid email")
    public void authUnSuccessfulTestWithEmail() {
        User user = DataGenerator.getUserDataForUnSuccessfulTestWithEmail();

        getAuthStep().enterLoginOrEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .clickSubmitButton();

        AssertUtils.makeAssert(getAuthStep().getErrorAuthLoginText(),
                "Введите логин/email!");

        getAuthStep().clickCloseLinkRegistrationForm();
    }

    @Test(description = "Negative auth scenario")
    @Description("Test Description: Unsuccessful auth test using invalid password")
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