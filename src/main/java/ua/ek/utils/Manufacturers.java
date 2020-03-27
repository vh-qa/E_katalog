package ua.ek.utils;

public enum Manufacturers {
    APPLE("apple"),
    GOOGLE("google"),
    SAMSUNG("samsung"),
    LENOVO("lenovo");

    private String manufacturerName;

    Manufacturers(String manufacturerName){
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }
}