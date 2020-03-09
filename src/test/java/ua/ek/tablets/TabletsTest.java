package ua.ek.tablets;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.GetDataFromExcel;
import ua.ek.utils.Helper;
import java.io.IOException;

public class TabletsTest extends BaseTest {

    @Test(testName = "Tablets Page Filters Tests", dataProvider = "testTabletsDataProvider")
    public void tabletsPageFiltersTests(String manufacturerName,
                                        double displayDiagonal,
                                        String expectedMessage) {

        getTabletsStep().goTabletsPage()
                   .clickManufacturer(manufacturerName)
                   .clickDisplayDiagonal(Helper.convertDoubleToInt(displayDiagonal))
                   .clickShowButton();

        AssertUtils.makeAssert(getTabletsManufacturerStep().getTabletsManufacturerPage().getPageTitle(), expectedMessage);
    }

    @DataProvider(name = "testTabletsDataProvider")
    private Object[][] testTabletsDataProvider() throws IOException {

        return GetDataFromExcel.getDataToObjectArray("/properties/common.properties",
                "tablets.test.data.file", "Filter_test_1");
    }
}