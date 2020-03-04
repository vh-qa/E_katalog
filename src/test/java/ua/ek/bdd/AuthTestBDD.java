package ua.ek.bdd;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;

@CucumberOptions(

        features = {"src/main/resources/features"},
        glue = "ua.ek.bdd.steps",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"

        })

public class AuthTestBDD extends BaseTest {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void setUp() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "getFeatures")
    public void authLoginTest() {
//        testNGCucumberRunner.runScenario();
    }

    @DataProvider
    public Object[][] getFeatures() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        testNGCucumberRunner.finish();
    }
}

