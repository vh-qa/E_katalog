package ua.ek.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;
import ua.ek.utils.Helper;

public class MapCasesPage extends BasePage {

    // Manufacturers
//    @FindBy(xpath = "//*[@id=\"li_br116\"]/label/a") // Apple
  @FindBy(xpath = "//label[@class='brand-best']/a[text()='Apple']")
            WebElement manufacturerApple;

    @FindBy(xpath = "//*[@id=\"li_br1364\"]/label/a") // Google
            WebElement manufacturerGoogle;

    @FindBy(xpath = "//*[@id=\"li_br147\"]/label/a") // Samsung
            WebElement manufacturerSamsung;

    @FindBy(xpath = "//label[@class='brand-best']/a[text()]")
    WebElement manufacturer;

    //================================================================================//

    // Body colors
    @FindBy(xpath = "//*[@id=\"preset15766\"]/li[2]/label/span") // Белый
            WebElement bodyColor;

    // Display diagonals
    @FindBy(xpath = "//*[@id=\"preset3863\"]/li[4]/label/a") // 10 дюймов
            WebElement displayDiagonal;

    //================================================================================//

    // Operating systems
    @FindBy(xpath = "//*[@id=\"preset3868\"]/li[5]/label/a") // Android 9 Pie
            WebElement operatingSystemAndroid;

    @FindBy(xpath = "//*[@id=\"preset3868\"]/li[7]/label/a") // iOS
            WebElement operatingSystemIos;

    //================================================================================//

    // Internal memory
    @FindBy(xpath = "//*[@id=\"preset5616\"]/li[5]/label/a") // 256 Гб
            WebElement internalMemory;

    public MapCasesPage(WebDriver driver) {
        super(driver);
    }

    public MapCasesPage clickManufacturer(String manufacturerName) {
        String xpath = "//label[@class='brand-best']/a[text()='" + manufacturerName + "']";
        clickWebElementByXpath(xpath);
        return this;
    }

    public MapCasesPage clickBodyColor(WebElement bodyColor) {
        Helper.clickWebElement(bodyColor);
        return this;
    }

    public MapCasesPage clickDisplayDiagonal(WebElement displayDiagonal) {
        Helper.clickWebElement(displayDiagonal);
        return this;
    }

    public MapCasesPage clickOperatingSystem(WebElement operatingSystem) {
        Helper.clickWebElement(operatingSystem);
        return this;
    }

    public MapCasesPage clickInternalMemory(WebElement internalMemory) {
        Helper.clickWebElement(internalMemory);
        return this;
    }


}
