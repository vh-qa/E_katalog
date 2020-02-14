package ua.ek;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BasePage;
import ua.ek.base.BaseTest;
import ua.ek.page.AuthPage;
import ua.ek.page.HomePage;
import ua.ek.utils.PropertyReader;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class AuthPageTest extends BaseTest {

    private final static Logger LOG = LogManager.getLogger(BasePage.class);

    private HomePage goHomePage(){
        String commonProperties = "src/main/resources/common.properties";
        Properties properties = new Properties();

        if (commonProperties != null) {
            try {
                properties.load(new FileReader(commonProperties));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//      String baseUrl = PropertyReader.from("common").getProperty("base.url");

        String baseUrl = properties.getProperty("base.url");
        driver.get(baseUrl);

        return new HomePage(driver);
    }

    private AuthPage goAuthPage(){
        return goHomePage().clickEnterLink().registerLinkClick();
    }

    @Test(testName = "Login Tests Chrome", dataProvider = "testAuthDataProvider")
    public void authFormTest(String login, String email, String password, String expectedErrorMessage) {

        String errorMessage = "";

       //  написать ожидания элементов

        AuthPage authPage = goAuthPage();

        authPage.enterLogin(login);
        authPage.enterEmail(email);
        authPage.enterPassword(password);
        authPage.submit();

        if(isWebElementPresent(By.xpath(authPage.getLoginErrorLink()))){
            if(!authPage.getEmailErrorMessage().equals("")){
                errorMessage = authPage.getEmailErrorMessage();
            }
        }
        if(isWebElementPresent(By.xpath(authPage.getEmailErrorLink()))){
            if(!authPage.getEmailErrorMessage().equals("")){
                errorMessage = authPage.getEmailErrorMessage();
            }
        }
        if(isWebElementPresent(By.xpath(authPage.getPasswordErrorLink()))){
            if(!authPage.getPasswordErrorMessage().equals("")){
                errorMessage = authPage.getPasswordErrorMessage();
            }
        }

        try {
            assertEquals(errorMessage, expectedErrorMessage);

            LOG.info("Error message {} - Expected error message", errorMessage, expectedErrorMessage);

        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        authPage.clickCloseLink();
    }

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


/*
    @DataProvider(name = "testAuthDataProvider")
    private Object[][] testAuthDataProvider() throws IOException {

        String pathData = "src/data/e_katalog_auth_data.xls";

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(pathData));

        XSSFSheet sheet = workbook.getSheet("AuthData");
        Object[][] authData = new Object[sheet.getLastRowNum()][3];
//      System.out.println(sheet.getLastRowNum());
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow parRow = sheet.getRow(i);
            authData[i - 1][0] = (parRow.getCell(0) == null) ? "" : parRow.getCell(0).getStringCellValue();
            authData[i - 1][1] = (parRow.getCell(1) == null) ? "" : parRow.getCell(1).getStringCellValue();
            authData[i - 1][2] = parRow.getCell(2).getStringCellValue();
        }

        return authData;
    }
*/
}
