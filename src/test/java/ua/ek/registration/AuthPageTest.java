package ua.ek.registration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.pages.PageManager;
import ua.ek.pages.registration.AuthPage;
import ua.ek.utils.AssertsUtils;
import ua.ek.utils.Helper;
import ua.ek.utils.PropertyReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class AuthPageTest extends BaseTest {

    private PageManager pageManager = new PageManager();

    @Test(testName = "Login Tests Chrome", dataProvider = "testAuthDataProvider")
    public void registrationFormTest(String login, String email, String password,
                             String expectedLoginErrorMessage,
                             String expectedEmailErrorMessage,
                             String expectedPasswordErrorMessage) {

        AuthPage authPage = pageManager.goAuthPage(driver);
        authPage
                .enterLogin(login)
                .enterEmail(email)
                .enterPassword(password)
                .submit();

        HashMap<String, String> params = new HashMap<>();
        params.put("login", login);
        params.put("email", email);
        params.put("password", password);

        if(Helper.isWebElementPresent(driver, authPage.getLoginErrorElement())){
            checkErrorMessage(authPage.getLoginErrorMessage(), expectedLoginErrorMessage, params);
        }

        if(Helper.isWebElementPresent(driver, authPage.getEmailErrorElement())){
            checkErrorMessage(authPage.getEmailErrorMessage(), expectedEmailErrorMessage, params);
        }

        if(Helper.isWebElementPresent(driver, authPage.getPasswordErrorElement())){
            checkErrorMessage(authPage.getPasswordErrorMessage(), expectedPasswordErrorMessage, params);
        }

        authPage.clickCloseLink();
    }

    private void checkErrorMessage(String actualErrorMessage, String expectedErrorMessage,
                                   HashMap<String, String> params) {
        if (!expectedErrorMessage.equals("")) {
            asserts(expectedErrorMessage, actualErrorMessage, params);
        }
    }

    private void asserts(String actualErrorMessage, String expectedErrorMessage, HashMap<String, String> params) {
        AssertsUtils.makeAssert(actualErrorMessage, expectedErrorMessage, params);
    }

    @DataProvider(name = "testAuthDataProvider")
    private Object[][] testAuthDataProvider() throws IOException {

        String pathData = PropertyReader
                          .from("/properties/common.properties", "auth.test.data.file")
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