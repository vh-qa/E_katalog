package ua.ek.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;
import ua.ek.pages.registration.AuthPage;
import ua.ek.pages.tablets.TabletPage;
import ua.ek.pages.tablets.TabletsPage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//li[@class='mainmenu-item']/a[contains(@class,'mainmenu-link') and text()='Компьютеры']")
    private WebElement computersLink; // Menu "Компьютеры"

    @FindBy(xpath = ".//a[contains(@class,'mainmenu-subitem mainmenu-icon30')]")
    private WebElement tabletsLink; // SubMenu "Планшеты"

    public AuthPage clickEnterLink() {
        if (getEnterLink() != null) {
            clickWebElement(getEnterLink());
            return new AuthPage(driver);
        }
        return null;
    }

    public TabletsPage clickTabletsLink() {
        driver.findElement(By.xpath(".//span[contains(@class,'mainmenu-link-helper')]")).click();
        driver.findElement(By.xpath(".//a[contains(@class,'mainmenu-subitem mainmenu-icon30')]")).click();
        return new TabletsPage(driver);
    }

    public TabletPage clickTabletLink() {
        driver.findElement(By.xpath(".//span[contains(@class,'mainmenu-link-helper')]")).click();
        driver.findElement(By.xpath(".//a[contains(@class,'mainmenu-subitem mainmenu-icon30')]")).click();
        return new TabletPage(driver);
    }

    public WebElement getWebElement(WebElement webElement){
        return webElement;
    }
}
