package ua.ek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {

    public static String getWebElementText(WebElement webElement) {
        return webElement.getText().trim();
    }

    public static void enterTextInTextField(WebElement textField, String inputText) {
        textField.click();
        textField.clear();
        textField.sendKeys(inputText);
    }

    public static void clickWebElement(WebElement webElement) {
        webElement.click();
    }

    public static boolean isWebElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static int convertDoubleToInt(double value) {
        return (int) value;
    }

    public static String convertDoubleToString(double value) {
        return String.valueOf(convertDoubleToInt(value));
    }
}