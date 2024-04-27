package com.pluralsight;

// New class to parse information in display all deposits or payments screen
public class Ledger {
    private String Datetime;
    private  String payType;
    private String information;
    private String vendor;
    private double price;

    // constructor method to gain access to private data
    public Ledger(String datetime, String payType, String information, String vendor, double price) {
        Datetime = datetime;
        this.payType = payType;
        this.information = information;
        this.vendor = vendor;
        this.price = price;
    }

    public String getDatetime() {
        return Datetime;
    }

    public String getPayType() {
        return payType;
    }

    public String getInformation() {
        return information;
    }

    public String getVendor() {
        return vendor;
    }

    public double getPrice() {
        return price;
    }
}
