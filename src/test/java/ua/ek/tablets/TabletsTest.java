package ua.ek.tablets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.steps.tablets.TabletsManufacturerStep;
import ua.ek.steps.tablets.TabletsStep;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.GetDataFromExcel;
import ua.ek.utils.Helper;
import ua.ek.utils.StepType;

import java.io.IOException;

public class TabletsTest extends BaseTest {

    private TabletsStep tabletsStep;
    private TabletsManufacturerStep tabletsManufacturerStep;

    @BeforeMethod
    public void init(){
        tabletsStep = (TabletsStep)getStep(StepType.TABLETS_STEP);
        tabletsManufacturerStep = (TabletsManufacturerStep)getStep(StepType.TABLETS_MANUFACTURER_STEP);
    }

    @Test(testName = "Tablets Page Filters Tests", dataProvider = "testTabletsDataProvider")
    public void tabletsPageFiltersTests(String manufacturerName,
                                        double displayDiagonal,
                                        String expectedMessage) {

        tabletsStep.goTabletsPage()
                   .clickManufacturer(manufacturerName)
                   .clickDisplayDiagonal(Helper.convertDoubleToInt(displayDiagonal))
                   .clickShowButton();

        AssertUtils.makeAssert(tabletsManufacturerStep.getTabletsManufacturerPage().getPageTitle(), expectedMessage);
    }

    @DataProvider(name = "testTabletsDataProvider")
    private Object[][] testTabletsDataProvider() throws IOException {

        return GetDataFromExcel.getDataToObjectArray("/properties/common.properties",
                "tablets.test.data.file", "Filter_test_1");
    }
}