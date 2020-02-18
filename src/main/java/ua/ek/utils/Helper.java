package ua.ek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
    // Get text from web element
    public static String getWebElementText(WebElement webElement){
        return webElement.getText().trim();
    }

    // Enter text to text field
    public static void enterTextInTextField(WebElement textField, String inputText) {
        textField.click();
        textField.clear();
        textField.sendKeys(inputText);
    }

    // Click on web element
    public static void clickWebElement(WebElement webElement){
        webElement.click();
    }
}
