package ua.ek.utils;

import ua.ek.models.User;
import java.util.Random;

public class DataGenerator {

    private static String login = Helper.getProperty(PropertyFiles.COMMON_PROPERTY.getPropertyFileName(),
            PropertyNames.USER_LOGIN.getPropertyName());

    private static String email = Helper.getProperty(PropertyFiles.COMMON_PROPERTY.getPropertyFileName(),
            PropertyNames.USER_EMAIL.getPropertyName());

    private static String password = Helper.getProperty(PropertyFiles.COMMON_PROPERTY.getPropertyFileName(),
            PropertyNames.USER_PASSWORD.getPropertyName());

    public static User getUser(){
        User user = new User();

        Random random = new Random();
        int randomIntNumber = Math.abs(random.nextInt());

        StringBuffer login = new StringBuffer();
        login.append("some_login_").append(randomIntNumber);

        StringBuffer email = new StringBuffer();
        email.append("some_email_").append(randomIntNumber).append("@company.com");

        user.setLogin(login.toString());
        user.setEmail(email.toString());

        StringBuffer password = new StringBuffer();
        password.append("some_password_").append(randomIntNumber);

        user.setPassword(password.toString());

        return user;
    }

    public static User getPositiveUserData(){
        User user = new User();

        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }

    public static User getUserDataForUnSuccessfulTestWithLogin() {
        User user = new User();

        user.setLogin("");
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }

    public static User getUserDataForUnSuccessfulTestWithEmail() {
        User user = new User();

        user.setLogin(login);
        user.setEmail("");
        user.setPassword(password);

        return user;
    }

    public static User getUserDataForUnSuccessfulTestWithPassword() {
        User user = new User();

        user.setLogin(login);
        user.setEmail(email);
        user.setPassword("");

        return user;
    }
}