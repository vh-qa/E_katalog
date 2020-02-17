package ua.ek;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import ua.ek.base.BasePage;
import ua.ek.base.BaseTest;
import ua.ek.page.AuthPage;
import ua.ek.page.HomePage;
import ua.ek.page.PageManager;
import ua.ek.utils.PropertyReader;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class AuthPageTest extends BaseTest {

    private final static Logger LOG = LogManager.getLogger(BasePage.class);
    private PageManager pageManager = new PageManager();

    @Test(testName = "Login Tests Chrome", dataProvider = "testAuthDataProvider")
    public void authFormTest(String login, String email, String password,
                             String expected_login_error_message,
                             String expected_email_error_message,
                             String expected_password_error_message) {

        AuthPage authPage = pageManager.goAuthPage(driver);
        authPage
                .enterLogin(login)
                .enterEmail(email)
                .enterPassword(password)
                .submit();

        if (!expected_login_error_message.equals("")) {
            if (isWebElementPresent(By.xpath(authPage.getLoginErrorLink()))) {
                if (!authPage.getLoginErrorMessage().equals("")) {
                    try {
                        assertEquals(authPage.getLoginErrorMessage(), expected_login_error_message);
                        LOG.info("Login Error message: {} - Login Expected error message: {}", authPage.getLoginErrorMessage(), expected_login_error_message);
                    } catch (Error e) {
                        verificationErrors.append("<<<<<<<<<<<<<<<<<<<<" + "\n" + "login = " + login + "; " +
                        "email = " + email + "; " + "password = " + password + "\n\n" +
                                e.toString() + "\n" + ">>>>>>>>>>>>>>>>>>>>");
                    }
                }
            }
        }

        if (!expected_email_error_message.equals("")) {
            if (isWebElementPresent(By.xpath(authPage.getEmailFillErrorLink()))) {
                if (!authPage.getEmailFillErrorMessage().equals("")) {
                    try {
                        assertEquals(authPage.getEmailFillErrorMessage(), expected_email_error_message);
                        LOG.info("Email Fill Error message: {} - Email Fill Expected error message: {}", authPage.getEmailFillErrorMessage(), expected_email_error_message);
                    } catch (Error e) {
                        verificationErrors.append("<<<<<<<<<<<<<<<<<<<<" + "\n" + "login = " + login + "; " +
                                "email = " + email + "; " + "password = " + password + "\n\n" +
                                e.toString() + "\n" + ">>>>>>>>>>>>>>>>>>>>");
                    }
                }
            }
        }

/*
        if (isWebElementPresent(By.xpath(authPage.getEmailCorrectErrorLink()))) {
            if (!authPage.getEmailCorrectErrorMessage().equals("")) {
                try {
                    assertEquals(authPage.getEmailCorrectErrorMessage(), expected_email_error_message);
                    LOG.info("Email Correct Error message: {} - Email Correct Expected error message: {}", authPage.getEmailCorrectErrorMessage(), expected_email_error_message);
                } catch (Error e) {
                      verificationErrors.append("<<<<<<<<<<<<<<<<<<<<" + "\n" + "login = " + login + "; " +
                        "email = " + email + "; " + "password = " + password + "\n\n" +
                                e.toString() + "\n" + ">>>>>>>>>>>>>>>>>>>>");
                }
            }
        }
*/

        if (!expected_password_error_message.equals("")) {
            if (isWebElementPresent(By.xpath(authPage.getPasswordErrorLink()))) {
                if (!authPage.getPasswordErrorMessage().equals("")) {
                    try {
                        assertEquals(authPage.getPasswordErrorMessage(), expected_password_error_message);
                        LOG.info("Password Error message: {} - Password Expected error message: {}", authPage.getPasswordErrorMessage(), expected_password_error_message);
                    } catch (Error e) {
                        verificationErrors.append("<<<<<<<<<<<<<<<<<<<<" + "\n" + "login = " + login + "; " +
                                "email = " + email + "; " + "password = " + password + "\n\n" +
                                e.toString() + "\n" + ">>>>>>>>>>>>>>>>>>>>");
                    }
                }
            }
        }

        authPage.clickCloseLink();
    }

/*
    @DataProvider(name = "testAuthDataProvider")
    private Object[][] testAuthDataProvider() throws IOException {

        Object[][] authData = new Object[3][4];

        authData[0][0] = "some-login";
        authData[0][1] = "some-email";
        authData[0][2] = "some-password";
        authData[0][3] = "Поле \"e-mail\" введено некорректно";

        authData[1][0] = "some-login";
        authData[1][1] = "";
        authData[1][2] = "some-password";
        authData[1][3] = "Заполните поле \"email\"";

        authData[2][0] = "some-login";
        authData[2][1] = "some-email-1@company.com";
        authData[2][2] = "";
        authData[2][3] = "Заполните поле \"Пароль\"";

        return authData;
    }
*/


    @DataProvider(name = "testAuthDataProvider")
    private Object[][] testAuthDataProvider() throws IOException {

        String pathData = PropertyReader
                .from("/common.properties", "auth.test.data.file")
                .getProperty("auth.test.data.file");

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(pathData));

        XSSFSheet sheet = workbook.getSheet("AuthData");
        Object[][] authData = new Object[sheet.getLastRowNum()][6];

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow parRow = sheet.getRow(i);
            authData[i - 1][0] = (parRow.getCell(0) == null) ? "" : parRow.getCell(0).getStringCellValue();
            authData[i - 1][1] = (parRow.getCell(1) == null) ? "" : parRow.getCell(1).getStringCellValue();
            authData[i - 1][2] = (parRow.getCell(2) == null) ? "" : parRow.getCell(2).getStringCellValue();
            authData[i - 1][3] = (parRow.getCell(3) == null) ? "" : parRow.getCell(3).getStringCellValue();
            authData[i - 1][4] = (parRow.getCell(4) == null) ? "" : parRow.getCell(4).getStringCellValue();
            authData[i - 1][5] = (parRow.getCell(5) == null) ? "" : parRow.getCell(5).getStringCellValue();
        }

        return authData;
    }
}
