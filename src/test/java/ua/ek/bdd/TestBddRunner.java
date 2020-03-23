package ua.ek.bdd;

import io.cucumber.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.utils.SeleniumGridUtils;

import java.util.ArrayList;
import java.util.List;

@CucumberOptions(

        features = "src/main/resources/features",
        glue = "ua.ek.steps.bdd",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })

public class TestBddRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
 //     SeleniumGridUtils.startSeleniumGrid();
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {

        List<String> tags = pickle.getPickle().getTags();
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < getFeaturesTags().size(); j++) {
                if (tags.get(i).equals(getFeaturesTags().get(j))) {
                    testNGCucumberRunner.runScenario(pickle.getPickle());
                }
            }
        }
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
//      SeleniumGridUtils.stopSeleniumGrid();
    }

    private List<String> getFeaturesTags() {
        List<String> featuresTags = new ArrayList<>();

        featuresTags.add("@LoginUserProfile");
//      featuresTags.add("@UserRegistration");
        featuresTags.add("@TabletsSearch");
//      featuresTags.add("@TabletsRightPanelFilters");
//      featuresTags.add("@TabletsTopPanelFilters");

        return featuresTags;
    }
}