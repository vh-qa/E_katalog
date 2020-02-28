package ua.ek.steps.tablets;

import org.openqa.selenium.WebDriver;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.Helper;

public class TabletsManufacturerStep extends BaseStep {

    private WebDriver driver;
    private Helper helper;

    public TabletsManufacturerStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
        helper = new Helper(driver);
    }
}