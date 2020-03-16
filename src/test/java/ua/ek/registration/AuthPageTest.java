package ua.ek.registration;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.model.User;
import ua.ek.steps.registration.AuthStep;
import ua.ek.steps.registration.UserProfileStep;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.DataGenerator;
import ua.ek.utils.PropertyReader;
import ua.ek.utils.StepType;

public class AuthPageTest extends BaseTest {

    private User userPositive = DataGenerator.getPositiveUserData();
    private AuthStep authStep;
    private UserProfileStep userProfileStep;

    @BeforeMethod
    public void openAuthFormBeforeTest() {
        authStep = (AuthStep) getStep(StepType.AUTH_STEP);
        userProfileStep = (UserProfileStep) getStep(StepType.USER_PROFILE_STEP);

        authStep.goAuthPage()
                .clickAuthLink();
    }

    // Positive scenario

    @Test(priority = 15, description = "Positive auth scenario")
    @Description("Test Description: Successful auth test using valid login and password")
    public void authSuccessfulTestWithLogin() {
        String loginExpectedMessage = PropertyReader
                .from("/properties/expectedMessages.properties",
                        "auth.form.login.expected.message")
                .getProperty("auth.form.login.expected.message");

        makePositiveAuth(userPositive.getLogin(), userPositive.getPassword(), loginExpectedMessage);
    }

    @Test(priority = 25, description = "Positive auth scenario")
    @Description("Test Description: Successful auth test using valid email and password")
    public void authSuccessfulTestWithEmail() {
        String loginExpectedMessage = PropertyReader
                .from("/properties/expectedMessages.properties",
                        "auth.form.login.expected.message")
                .getProperty("auth.form.login.expected.message");
        makePositiveAuth(userPositive.getEmail(), userPositive.getPassword(), loginExpectedMessage);
    }

    // Negative scenario

    @Test(priority = 3, description = "Negative auth scenario")
    @Description("Test Description: Unsuccessful auth test using invalid login")
    public void authUnSuccessfulTestWithEmptyLogin() {
        User userNegative = DataGenerator.getUserDataForUnSuccessfulTestWithLogin();
        String errorLoginExpectedMessage = PropertyReader
                .from("/properties/messagesFromWebSite.properties",
                        "auth.form.login.error.message")
                .getProperty("auth.form.login.error.message");
        auth(userNegative.getLogin(), userNegative.getPassword());
        makeNegativeAuth(authStep.getErrorAuthLoginText(), errorLoginExpectedMessage);
    }

    @Test(priority = 4, description = "Negative auth scenario")
    @Description("Test Description: Unsuccessful auth test using invalid email")
    public void authUnSuccessfulTestWithEmptyEmail() {
        User userNegative = DataGenerator.getUserDataForUnSuccessfulTestWithEmail();
        String errorEmailExpectedMessage = PropertyReader
                .from("/properties/messagesFromWebSite.properties",
                        "auth.form.email.error.message")
                .getProperty("auth.form.email.error.message");
        auth(userNegative.getEmail(), userNegative.getPassword());
        makeNegativeAuth(authStep.getErrorAuthLoginText(), errorEmailExpectedMessage);
    }

    @Test(priority = 5, description = "Negative auth scenario")
    @Description("Test Description: Unsuccessful auth test using invalid password")
    public void authUnSuccessfulTestWithEmptyPassword() {
        User userNegative = DataGenerator.getUserDataForUnSuccessfulTestWithPassword();
        String errorPasswordExpectedMessage = PropertyReader
                .from("/properties/messagesFromWebSite.properties",
                        "auth.form.password.error.message")
                .getProperty("auth.form.password.error.message");
        auth(userNegative.getLogin(), userNegative.getPassword());
        makeNegativeAuth(authStep.getErrorAuthPasswordText(), errorPasswordExpectedMessage);
    }

    private void makePositiveAuth(String loginOrEmail, String password, String expectedMessage) {
        auth(loginOrEmail, password);
        AssertUtils.makeAssert(userProfileStep.getNickLinkText(), expectedMessage);
        userProfileStep.clickLogOutFromUserProfileLink();
    }

    private void makeNegativeAuth(String actualMessage, String expectedMessage) {
        AssertUtils.makeAssert(actualMessage, expectedMessage);
        authStep.clickCloseLinkRegistrationForm();
    }

    private void auth(String loginOrEmail, String password) {
        authStep.enterLoginOrEmail(loginOrEmail)
                .enterPassword(password)
                .clickRememberMeCheckBoxAuth() // uncheck checkbox
                .clickSubmitButton();
    }
}