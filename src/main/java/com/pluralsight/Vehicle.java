package com.pluralsight;

public class Vehicle {
    long vehicleId;
    String makeModel;
    String color;
    int odometerReading;
    double price;

    public Vehicle(long vehicleId, String makeModel, String color, int odometerReading, double price) {
        this.vehicleId = vehicleId;
        this.makeModel = makeModel;
        this.color = color;
        this.odometerReading = odometerReading;
        this.price = price;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        int dollars = (int) price;
        int cents = (int) ((price - dollars) * 100);
        String formattedPrice = "$" + dollars + "." + (cents < 10 ? "0" + cents : cents);
        String border = "------------------------------------------";

        return
                "\n| VEHICLE ID:   " + this.vehicleId +
                "\n| MAKE/MODEL:   " + this.makeModel +
                "\n| COLOR:        " + this.color +
                "\n| ODOMETER:     " + this.odometerReading + " miles" +
                "\n| PRICE:        " + formattedPrice +
                "\n" + border;
    }
}
