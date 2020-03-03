package ua.ek.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ua.ek.steps.HomeStep;
import ua.ek.steps.auth.AuthStep;
import ua.ek.steps.auth.RegistrationStep;
import ua.ek.steps.search.SearchStep;
import ua.ek.steps.tablets.*;
import ua.ek.steps.tablets.filters.PriceFilterStep;
import ua.ek.steps.tablets.manufacturers.AppleTabletsStep;
import ua.ek.utils.Helper;
import ua.ek.utils.InitDrivers;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.testng.FileAssert.fail;

public abstract class BaseTest extends InitDrivers {

    protected final static Logger LOG = LogManager.getLogger(BasePage.class);
    protected StringBuffer verificationErrors = new StringBuffer();
    protected Helper helper;

    protected HomeStep homeStep;
    protected RegistrationStep registrationStep;
    protected AuthStep authStep;
    protected TabletStep tabletStep;
    protected TabletsStep tabletsStep;
    protected TabletsListStep tabletsListStep;
    protected TabletsManufacturerStep tabletsManufacturerStep;
    protected AppleTabletsStep appleTabletsStep;
    protected SearchStep searchStep;
    protected PriceFilterStep priceFilterStep;

    private void init (WebDriver driver){
        homeStep = new HomeStep(driver);
        registrationStep = new RegistrationStep(driver);
        authStep = new AuthStep(driver);
        tabletStep = new TabletStep(driver);
        tabletsStep = new TabletsStep(driver);
        tabletsListStep = new TabletsListStep(driver);
        tabletsManufacturerStep = new TabletsManufacturerStep(driver);
        appleTabletsStep = new AppleTabletsStep(driver);
        searchStep = new SearchStep(driver);
        priceFilterStep = new PriceFilterStep(driver);

        helper = new Helper(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    @BeforeMethod
    public void initStepsAndLogTestStart(Method method, Object[] params) {

        init(driver);

        homeStep.goHomePage();

        LOG.info("Start test {} with parameters {}",
                method.getName(), Arrays.toString(params));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method method) {
        LOG.info("Stop test {}", method.getName());
    }
}