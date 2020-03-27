package ua.ek.utils;

public enum PropertyNames {

    CHROME_DRIVER("chrome.driver"),
    WEBDRIVER_CHROME_DRIVER("webdriver.chrome.drive"),
    UNKNOWN_BROWSER("unknown.browser"),
    BASE_URL("base.url"),
    CHARSET_NAME_UTF8("charset.name.UTF8"),
    USER_LOGIN("user.login"),
    USER_EMAIL("user.email"),
    USER_PASSWORD("user.password"),
    REMOTE_DRIVER_DEFAULT_BROWSER("remote.driver.default.browser"),
    REMOTE_DRIVER_DEFAULT_OS("remote.driver.default.os"),
    REMOTE_DRIVER_DEFAULT_NODE("remote.driver.default.node"),
    NODE_PORT_5555("node.port.5555"),
    NODE_PORT_7777("node.port.7777"),
    NODE_PORT_9999("node.port.9999"),

    CUCUMBER_TAGS_DATA_FILE("cucumber.tags.data.file"),
    CUCUMBER_TAGS_SHEET_NAME_LOGIN("cucumber.tags.sheet.name.login"),
    CUCUMBER_TAGS_SHEET_NAME_SEARCH("cucumber.tags.sheet.name.search"),
    CUCUMBER_TAGS_CLASS_NAME("cucumber.tags.class.name");

    private String propertyName;

    PropertyNames(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }
}