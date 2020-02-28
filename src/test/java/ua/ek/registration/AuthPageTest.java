package ua.ek.registration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.model.User;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.IWaitTimes;
import ua.ek.utils.PropertyReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthPageTest extends BaseTest {

//    @Test(testName = "Login Tests Chrome", dataProvider = "testAuthDataProvider")
//    public void registrationFormTest(String login, String email, String password,
//                             String expectedLoginErrorMessage,
//                             String expectedEmailErrorMessage,
//                             String expectedPasswordErrorMessage) {

    @Test(testName = "Login Tests Chrome")
    public void registrationFormTest() {

        List<User> users = null;

        try {
            users = getUsers();
        }catch (IOException e){
            e.getMessage();
        }

        for (User user: users) {
            authStep.goAuthPage(driver);
            authStep.clickRegisterLink();
            authStep.enterLogin(user.getLogin());
            authStep.enterEmail(user.getEmail());
            authStep.enterPassword(user.getPassword());
            authStep.clickSubmitButton();

            Map<String, String> params = new HashMap<>();
            params.put("login", user.getLogin());
            params.put("email", user.getEmail());
            params.put("password", user.getPassword());

            if(helper.visibilityOfElementLocated(authStep.getAuthPage().getLoginErrorElement(),
                    IWaitTimes.FIVE_SECONDS)){
                checkErrorMessage(authStep.getAuthPage().getLoginErrorMessage(), user.getExpectedLoginErrorMessage(), params);
            }

            if(helper.visibilityOfElementLocated(authStep.getAuthPage().getEmailErrorElement(),
                    IWaitTimes.FIVE_SECONDS)){
                checkErrorMessage(authStep.getAuthPage().getEmailErrorMessage(), user.getExpectedEmailErrorMessage(), params);
            }

            if(helper.visibilityOfElementLocated(authStep.getAuthPage().getPasswordErrorElement(),
                    IWaitTimes.FIVE_SECONDS)){
                checkErrorMessage(authStep.getAuthPage().getPasswordErrorMessage(), user.getExpectedPasswordErrorMessage(), params);
            }

            authStep.clickCloseLink();
        }
    }

    private void checkErrorMessage(String actualErrorMessage, String expectedErrorMessage,
                                   Map<String, String> params) {
        if (!expectedErrorMessage.equals("")) {
            asserts(expectedErrorMessage, actualErrorMessage, params);
        }
    }

    private void asserts(String actualErrorMessage, String expectedErrorMessage, Map<String, String> params) {
        AssertUtils.makeAssert(actualErrorMessage, expectedErrorMessage, params);
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

    private List<User> getUsers() throws IOException {

        List<User> users = new ArrayList<>();

        String pathData = PropertyReader
                .from("/properties/common.properties", "auth.test.data.file")
                .getProperty("auth.test.data.file");

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(pathData));
        XSSFSheet sheet = workbook.getSheet("AuthData");

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            User user = new User();
            XSSFRow parRow = sheet.getRow(i);

            user.setLogin((parRow.getCell(0) == null) ? "" : parRow.getCell(0).getStringCellValue());
            user.setEmail((parRow.getCell(1) == null) ? "" : parRow.getCell(1).getStringCellValue());
            user.setPassword((parRow.getCell(2) == null) ? "" : parRow.getCell(2).getStringCellValue());
            user.setExpectedLoginErrorMessage((parRow.getCell(3) == null) ? "" : parRow.getCell(3).getStringCellValue());
            user.setExpectedEmailErrorMessage((parRow.getCell(4) == null) ? "" : parRow.getCell(4).getStringCellValue());
            user.setExpectedPasswordErrorMessage((parRow.getCell(5) == null) ? "" : parRow.getCell(5).getStringCellValue());

            users.add(user);
        }

        return users;
    }
}