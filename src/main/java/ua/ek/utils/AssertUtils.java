package ua.ek.utils;

import static org.testng.Assert.assertEquals;

public class AssertUtils {

    public static void makeAssert(String actualMessage, String expectedMessage) {
        assertEquals(actualMessage, expectedMessage);
    }
}