package com.pluralsight;

// New class to parse information in display all deposits or payments screen
public class Ledger {
    private String date;
    private String time;
    private String information;
    private String vendor;
    private double price;

    // constructor method to gain access to private data
    public Ledger(String date, String time, String information, String vendor, double price) {
        this.date = date;
        this.time = time;
        this.information = information;
        this.vendor = vendor;
        this.price = price;
    }

    public String getdate() {
        return date;
    }

    public String gettime() {
        return time;
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
