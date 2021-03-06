package ua.ek.utils;

import java.io.IOException;

public class SeleniumGridUtils {
    public static void createHub() {
        String cmd = "cmd /c start java -jar C:/SeleniumGrid/selenium-server-standalone.jar -role hub";

        Process process;
        try {
            process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void createNode(String nodePort) {
        String cmd = "cmd /c start java -Dwebdriver.chrome.driver=\"d:/SeleniumGridNode/chromedriver.exe\" " +
                "-jar d:/SeleniumGridNode/selenium-server-standalone-3.141.59.jar -role node " +
                "-hub http://localhost:4444/grid/register -port " + nodePort;

        Process process;
        try {
            process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void startSeleniumGrid(){
        createHub();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String nodePort = Helper.getProperty(PropertyFiles.COMMON_PROPERTY.getPropertyFileName(),
                PropertyNames.NODE_PORT_5555.getPropertyName());

        createNode(nodePort);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void stopSeleniumGrid(){
        String cmd = "cmd /c start taskkill /f /im java.exe";
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}