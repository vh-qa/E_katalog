package ua.ek.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.ek.base.BasePage;
import ua.ek.utils.Helper;
import ua.ek.utils.ITimeOfWait;

public class MapCasesPage extends BasePage {

    // Manufacturers
    //   @FindBy(xpath = "//*[@id=\"li_br116\"]/label/a") // Apple
//  @FindBy(xpath = "//label[@class='brand-best']/a[text()='Apple']")
    @FindBy(xpath = "//*[@id=\"li_br116\"]/label")
    private WebElement manufacturerApple;

    //    @FindBy(xpath = "//label[@class='brand-best']/a[text()='Google']") // Google
    @FindBy(xpath = "//*[@id=\"li_br1364\"]/label/a")
    private WebElement manufacturerGoogle;

    //   @FindBy(xpath = "//label[@class='brand-best']/a[text()='Samsung']") // Samsung
    @FindBy(xpath = "//*[@id=\"li_br147\"]/label/a")
    private WebElement manufacturerSamsung;

    @FindBy(xpath = "//label[@class='brand-best']/a[text()]")
    private WebElement manufacturer;

    //================================================================================//

    // Display diagonals
    @FindBy(xpath = ".//label[@for='c5699']") // 10 дюймов
    private WebElement displayDiagonal;

    //================================================================================//

    // Operating systems
    @FindBy(xpath = "//*[@id=\"preset3868\"]/li[5]/label/a") // Android 9 Pie
    private WebElement operatingSystemAndroid9Pie;

    @FindBy(xpath = "//*[@id=\"preset3868\"]/li[7]/label/a") // iOS
    private WebElement operatingSystemIos;

    //================================================================================//

    // Internal memory
    @FindBy(xpath = "//*[@id=\"preset5616\"]/li[5]/label/a") // 256 Гб
    private WebElement internalMemory;


    // 'Показать' button
    @FindBy(xpath = "//*[@id=\"tt-info\"]/a")
    private WebElement showButton;

    public MapCasesPage(WebDriver driver) {
        super(driver);
    }

    public MapCasesPage clickManufacturer(String manufacturerName) {
        //      String xpath = "//label[@class='brand-best']/a[text()='" + manufacturerName + "']";

//        String xpath = "//*[@id='li_br116']/label"; // Apple
//        String xpath = "//*[@id='li_br1364']/label"; // Google
        String xpath = "//*[@id='li_br147']/label"; // Samsung

        WebElement webElement = driver.findElement(By.xpath(xpath));

        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, webElement);

//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOf(webElement));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);

        return this;
    }

    public MapCasesPage clickAppleManufacturer() {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, manufacturerApple);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", manufacturerApple);

        return this;
    }

    public MapCasesPage clickSamsungManufacturer() {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, manufacturerSamsung);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", manufacturerSamsung);

        return this;
    }

    public MapCasesPage clickIosOperatingSystem() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", operatingSystemIos);

        return this;
    }

    public MapCasesPage clickAndroid9PieOperatingSystem() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", operatingSystemAndroid9Pie);

        return this;
    }


    public MapCasesPage clickDisplayDiagonal() {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, displayDiagonal);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", displayDiagonal);

        return this;
    }

    public MapCasesPage clickInternalMemory() {
        internalMemory.click();
        return this;
    }

    public MapCasesManufacturerPage clickShowButton() {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, showButton);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", showButton);

        return new MapCasesManufacturerPage(driver);
    }
}
