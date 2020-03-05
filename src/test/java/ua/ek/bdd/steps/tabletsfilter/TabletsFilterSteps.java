package ua.ek.bdd.steps.tabletsfilter;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.ek.pages.tablets.TabletsListPage;
import ua.ek.steps.HomeStep;
import ua.ek.steps.tablets.TabletsStep;
import ua.ek.steps.tablets.manufacturers.AppleTabletsStep;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.Helper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TabletsFilterSteps {

    WebDriver driver;
    Helper helper;
    HomeStep homeStep;
    TabletsStep tabletsStep;
    AppleTabletsStep appleTabletsStep;

    public TabletsFilterSteps() {
        initDrivers("chrome");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        helper = new Helper(driver);
        homeStep = new HomeStep(driver);
        tabletsStep = new TabletsStep(driver);
        appleTabletsStep = new AppleTabletsStep(driver);
    }

    @Given("^I am on home page$")
    public void i_am_on_home_page()  {
        homeStep.goHomePage();
    }

    @When("^I go tablets page$")
    public void i_click_on_Компьютеры_link()  {
        tabletsStep.goTabletsPage(driver);
    }

    @And("^I click on \"([^\"]*)\" checkbox$")
    public void i_click_on_checkbox(String manufacturer)  {
     tabletsStep.clickManufacturer(manufacturer);
    }

    @And("^I click on 'Показать' button$")
    public void i_click_on_Показать_button()  {
      tabletsStep.clickShowButton();
    }

    @Then("^I am on page with list of Apples tablets$")
    public void i_am_on_page_with_list_of_Apples_tablets() {
        AssertUtils.makeAssert(appleTabletsStep.getPageTitleText(), "Планшеты Apple");
    }

    private void initDrivers(String browser) {

        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(this.getClass().getResourceAsStream("/properties/common.properties"), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unknown browser " + browser);
        }
    }
}