package ua.ek.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(

        features = "src/main/resources/features/tabletsfilter",
        glue = "ua.ek.bdd.tabletsfilter",
        tags = "@TabletsFilters",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })

public class TabletsFiltersTestBddRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void setUp() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups="cucumber", dataProvider = "getFeatures")
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