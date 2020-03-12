package ua.ek.utils;

import ua.ek.model.User;
import java.util.Random;

public class DataGenerator {

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

        String login = Helper.getProperty("/properties/common.properties",
                "user.login");

        String email = Helper.getProperty("/properties/common.properties",
                "user.email");

        String password = Helper.getProperty("/properties/common.properties",
                "user.password");

        User user = new User();

        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }

    public static User getUserDataForUnSuccessfulTestWithLogin() {

        String email = Helper.getProperty("/properties/common.properties",
                "user.email");

        String password = Helper.getProperty("/properties/common.properties",
                "user.password");

        User user = new User();

        user.setLogin("");
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }

    public static User getUserDataForUnSuccessfulTestWithEmail() {

        String login = Helper.getProperty("/properties/common.properties",
                "user.login");

        String password = Helper.getProperty("/properties/common.properties",
                "user.password");

        User user = new User();

        user.setLogin(login);
        user.setEmail("");
        user.setPassword(password);

        return user;
    }

    public static User getUserDataForUnSuccessfulTestWithPassword() {

        String login = Helper.getProperty("/properties/common.properties",
                "user.login");

        String email = Helper.getProperty("/properties/common.properties",
                "user.email");

        User user = new User();

        user.setLogin(login);
        user.setEmail(email);
        user.setPassword("");

        return user;
    }
}