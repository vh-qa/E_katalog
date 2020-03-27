package ua.ek.bdd;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.models.CucumberTag;
import ua.ek.utils.*;
import java.util.List;

@CucumberOptions(

        features = "src/test/java/ua/ek/bdd/features/registration",
        glue = "ua.ek.steps.bdd.registration",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })

public class AuthBddRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        SeleniumGridUtils.startSeleniumGrid();
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "login", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {

        List<String> tags = pickle.getPickle().getTags();
        List<CucumberTag> cucumberTags = getFeaturesTags();

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < getFeaturesTags().size(); j++) {
                CucumberTag cucumberTag = cucumberTags.get(j);
                if (tags.get(i).equals(cucumberTag.getTagName())) {
                    testNGCucumberRunner.runScenario(pickle.getPickle());
                }
            }
        }

//        for (int i = 0; i < 1; i++) {
//            for (int j = 0; j < getFeaturesTags().size(); j++) {
//                if (tags.get(i).equals(getFeaturesTags().get(j))) {
//                    testNGCucumberRunner.runScenario(pickle.getPickle());
//                }
//            }
//        }
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
        SeleniumGridUtils.stopSeleniumGrid();
    }

    private List<CucumberTag> getFeaturesTags() {

        List<CucumberTag> featuresTags;
        List<Object> objectList;

        String sheetName = Helper.getProperty(PropertyFiles.COMMON_PROPERTY.getPropertyFileName(),
                PropertyNames.CUCUMBER_TAGS_SHEET_NAME_LOGIN.getPropertyName());

        String className = Helper.getProperty(PropertyFiles.COMMON_PROPERTY.getPropertyFileName(),
                PropertyNames.CUCUMBER_TAGS_CLASS_NAME.getPropertyName());

        objectList = GetDataFromExcel
                .getDataToList
                        (PropertyFiles.COMMON_PROPERTY.getPropertyFileName(),
                                PropertyNames.CUCUMBER_TAGS_DATA_FILE.getPropertyName(),
                                sheetName, className);

        featuresTags = ClassConverter.cast(CucumberTag.class, objectList);
        return featuresTags;

//        List<String> featuresTags = new ArrayList<>();
//
//        featuresTags.add("@LoginUserProfile");
//        featuresTags.add("@UserRegistration");
////      featuresTags.add("@TabletsSearch");
////      featuresTags.add("@TabletsRightPanelFilters");
////      featuresTags.add("@TabletsTopPanelFilters");
//
//        return featuresTags;
    }
}