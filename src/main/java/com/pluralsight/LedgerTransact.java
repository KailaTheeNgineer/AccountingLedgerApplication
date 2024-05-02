package com.pluralsight;

import java.time.LocalDateTime;

public class LedgerTransact {
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;

    LedgerTransact() {
        date = "0000-00-00";
        time = "00:00:00";
        description = "Unknown";
        vendor = "Unknown";
        amount = 0;


    }

    // Constructor method to access the data in the object
    public LedgerTransact(String date, String time, String description, String vendor, double amount) {

      this.date = date;
      this.time = time;
      this.description = description;
      this.vendor = vendor;
      this.amount = amount;

    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }



}
