package ua.ek.bdd;

import cucumber.api.testng.*;
import cucumber.api.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(

        features = "src/main/resources/features/loginuserprofile",
        glue = "ua.ek.steps.bdd.loginuserprofile",
        tags = "@LoginUserProfile",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })

public class AuthTestBddRunner extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void setUp() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", dataProvider = "features")
    public void authLoginTest(CucumberFeatureWrapper cucumberFeatureWrapper) {
        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }

    @DataProvider
    public Object[][] getFeatures() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        testNGCucumberRunner.finish();
    }
}