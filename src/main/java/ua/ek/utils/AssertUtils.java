package ua.ek.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.ek.base.BasePage;
import static org.testng.Assert.assertEquals;

public class AssertUtils {

    private final static Logger LOG = LogManager.getLogger(BasePage.class);

    public static void makeAssert(String actualMessage, String expectedMessage) {
        try {
            assertEquals(actualMessage, expectedMessage);
            LOG.info("Actual Error message: {} - Expected error message: {}",
                    actualMessage, expectedMessage);
        } catch (Error e) {
            e.printStackTrace();
        }
    }
}