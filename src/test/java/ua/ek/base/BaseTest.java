package ua.ek.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ua.ek.steps.HomeStep;
import ua.ek.steps.registration.AuthStep;
import ua.ek.steps.registration.RegistrationStep;
import ua.ek.steps.registration.UserProfileStep;
import ua.ek.steps.search.SearchStep;
import ua.ek.steps.tablets.*;
import ua.ek.steps.tablets.filters.PriceFilterStep;
import ua.ek.steps.tablets.manufacturers.AppleTabletsStep;
import ua.ek.utils.InitDrivers;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.testng.FileAssert.fail;

public abstract class BaseTest extends InitDrivers {

    private final static Logger LOG = LogManager.getLogger(BasePage.class);
    private StringBuffer verificationErrors = new StringBuffer();

    private HomeStep homeStep;
    private RegistrationStep registrationStep;
    private AuthStep authStep;
    private UserProfileStep userProfileStep;
    private TabletStep tabletStep;
    private TabletsStep tabletsStep;
    private TabletsListStep tabletsListStep;
    private TabletsManufacturerStep tabletsManufacturerStep;
    private AppleTabletsStep appleTabletsStep;
    private SearchStep searchStep;
    private PriceFilterStep priceFilterStep;

    private void init (WebDriver driver){
        homeStep = new HomeStep(driver);
        registrationStep = new RegistrationStep(driver);
        authStep = new AuthStep(driver);
        userProfileStep = new UserProfileStep(driver);
        tabletStep = new TabletStep(driver);
        tabletsStep = new TabletsStep(driver);
        tabletsListStep = new TabletsListStep(driver);
        tabletsManufacturerStep = new TabletsManufacturerStep(driver);
        appleTabletsStep = new AppleTabletsStep(driver);
        searchStep = new SearchStep(driver);
        priceFilterStep = new PriceFilterStep(driver);
    }

    @BeforeClass
    public void initSteps(){
        init(getWebDriver());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        getWebDriver().quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    @BeforeMethod
    public void initStepsAndLogTestStart(Method method, Object[] params) {
        homeStep.goHomePage();
        LOG.info("Start test {} with parameters {}",
                method.getName(), Arrays.toString(params));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method method) {
        LOG.info("Stop test {}", method.getName());
    }

    public HomeStep getHomeStep() {
        return homeStep;
    }

    public RegistrationStep getRegistrationStep() {
        return registrationStep;
    }

    public AuthStep getAuthStep() {
        return authStep;
    }

    public UserProfileStep getUserProfileStep() {
        return userProfileStep;
    }

    public TabletStep getTabletStep() {
        return tabletStep;
    }

    public TabletsStep getTabletsStep() {
        return tabletsStep;
    }

    public TabletsListStep getTabletsListStep() {
        return tabletsListStep;
    }

    public TabletsManufacturerStep getTabletsManufacturerStep() {
        return tabletsManufacturerStep;
    }

    public AppleTabletsStep getAppleTabletsStep() {
        return appleTabletsStep;
    }

    public SearchStep getSearchStep() {
        return searchStep;
    }

    public PriceFilterStep getPriceFilterStep() {
        return priceFilterStep;
    }
}