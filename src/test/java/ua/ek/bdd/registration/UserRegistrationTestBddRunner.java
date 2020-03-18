package ua.ek.bdd.registration;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.utils.SeleniumGridUtils;

@CucumberOptions(

        features = "src/main/resources/features/registration/userregistration",
        glue = "ua.ek.steps.bdd.registration.userregistration",
        tags = "@UserRegistration",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })

public class UserRegistrationTestBddRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void setUp() {
        SeleniumGridUtils.startSeleniumGrid();
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups="cucumber", dataProvider = "getFeatures")
    public void registrationTest(CucumberFeatureWrapper cucumberFeatureWrapper) {
        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }

    @DataProvider
    public Object[][] getFeatures() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        testNGCucumberRunner.finish();
        SeleniumGridUtils.stopSeleniumGrid();
    }
}