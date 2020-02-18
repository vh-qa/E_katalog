package ua.ek.pages.tablets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;
import ua.ek.utils.ITimeOfWait;

public class TabletsPage extends BasePage {

    // Manufacturers
//  @FindBy(xpath = ".//label[@class='brand-best']/a[text()='Apple']")
    @FindBy(xpath = ".//*[@id=\"li_br116\"]/label") // Apple
    private WebElement manufacturerApple;

    //    @FindBy(xpath = ".//label[@class='brand-best']/a[text()='Google']")
    @FindBy(xpath = ".//*[@id=\"li_br1364\"]/label/a") // Google
    private WebElement manufacturerGoogle;

    //   @FindBy(xpath = ".//label[@class='brand-best']/a[text()='Samsung']")
    @FindBy(xpath = ".//*[@id=\"li_br147\"]/label/a") // Samsung
    private WebElement manufacturerSamsung;

    @FindBy(xpath = ".//label[@class='brand-best']/a[text()]")
    private WebElement manufacturer;

    //================================================================================//

    // Display diagonals
    @FindBy(xpath = ".//label[@for='c5699']") // 10 дюймов
    private WebElement displayDiagonal;

    //================================================================================//

    // Operating systems
    @FindBy(xpath = ".//*[@id=\"preset3868\"]/li[5]/label/a") // Android 9 Pie
    private WebElement operatingSystemAndroid9Pie;

    @FindBy(xpath = ".//*[@id=\"preset3868\"]/li[7]/label/a") // iOS
    private WebElement operatingSystemIos;

    //================================================================================//

    // Internal memory
    @FindBy(xpath = ".//*[@id=\"preset5616\"]/li[5]/label/a") // 256 Гб
    private WebElement internalMemory;

    // 'Показать' button
    @FindBy(xpath = ".//*[@id=\"tt-info\"]/a")
    private WebElement showButton;

    public TabletsPage(WebDriver driver) {
        super(driver);
    }

    public TabletsPage clickManufacturer(String manufacturerName) {
        switch (manufacturerName.trim().toLowerCase()) {
            case "apple":
                clickAppleManufacturer();
                break;
            case "samsung":
                clickSamsungManufacturer();
                break;
            default:
                break;
        }
        return this;
    }

    public TabletsPage clickAppleManufacturer() {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, manufacturerApple);
        executeWebElement(manufacturerApple);

        return this;
    }

    public TabletsPage clickSamsungManufacturer() {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, manufacturerSamsung);
        executeWebElement(manufacturerSamsung);

        return this;
    }

    public TabletsPage clickIosOperatingSystem() {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, operatingSystemIos);
        executeWebElement(operatingSystemIos);

        return this;
    }

    public TabletsPage clickAndroid9PieOperatingSystem() {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, operatingSystemAndroid9Pie);
        executeWebElement(operatingSystemAndroid9Pie);

        return this;
    }


    public TabletsPage clickDisplayDiagonal() {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, displayDiagonal);
        executeWebElement(displayDiagonal);

        return this;
    }

    public TabletsPage clickInternalMemory() {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, internalMemory);
        executeWebElement(internalMemory);

        return this;
    }

    public TabletsManufacturerPage clickShowButton() {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, showButton);
        executeWebElement(showButton);

        return new TabletsManufacturerPage(driver);
    }
}
