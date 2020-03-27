package ua.ek.utils;

public enum PropertyFiles {
    COMMON_PROPERTY("/properties/common.properties");
    private String propertyFileName;

    PropertyFiles(String propertyFileName) {
        this.propertyFileName = propertyFileName;
    }

    public String getPropertyFileName() {
        return propertyFileName;
    }
}