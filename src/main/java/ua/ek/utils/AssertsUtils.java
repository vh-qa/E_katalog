package ua.ek.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.ek.base.BasePage;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class AssertsUtils {

    private final static Logger LOG = LogManager.getLogger(BasePage.class);
    private static StringBuffer verificationErrors = new StringBuffer();

    public static void makeAssert(String actualErrorMessage, String expectedErrorMessage){
        try {
            assertEquals(actualErrorMessage, expectedErrorMessage);
            LOG.info("Actual Error message: {} - Expected error message: {}",
                    actualErrorMessage, expectedErrorMessage);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    public static void makeAssert(String actualErrorMessage, String expectedErrorMessage,
                                    HashMap<String, String> params){

        try {
            assertEquals(actualErrorMessage, expectedErrorMessage);
            LOG.info("Actual Error message: {} - Expected error message: {}",
                    actualErrorMessage, expectedErrorMessage);
        } catch (Error e) {

            verificationErrors.append("<<<<<<<<<<<<<<<<<<<<" + "\n");

            for(Map.Entry<String, String> entry : params.entrySet()){
                verificationErrors.append(entry.getKey() + " = " + entry.getValue() + "; " + "\n\n");
            }

            verificationErrors.append(e.toString() + "\n" + ">>>>>>>>>>>>>>>>>>>>");
        }
    }
}