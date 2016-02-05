package com.arora.comfortsensing.ui;

/**
 * Created by ahsanferoz on 06/12/15.
 */
public class Battery {

    private String nativeBatteryStatus;
    private int nativeBatteryAliveTime;
    private int nativeTimeToFullCharge;
    private Boolean currentlyCharging;
    private String chargeType;
    private int batteryVoltage;
    private String batteryTechnology;
    private double batteryCapacity;

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Battery() {
        currentlyCharging = false;
    }

    public int getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(int batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public String getBatteryTechnology() {
        return batteryTechnology;
    }

    public void setBatteryTechnology(String batteryTechnology) {
        this.batteryTechnology = batteryTechnology;
    }

    private int calculatedBatteryCapacity;
    private int batteryTemperature;

    public String getNativeBatteryStatus() {
        return nativeBatteryStatus;
    }

    public void setNativeBatteryStatus(String nativeBatteryStatus) {
        this.nativeBatteryStatus = nativeBatteryStatus;
    }

    public int getNativeBatteryAliveTime() {
        return nativeBatteryAliveTime;
    }

    public void setNativeBatteryAliveTime(int nativeBatteryAliveTime) {
        this.nativeBatteryAliveTime = nativeBatteryAliveTime;
    }

    public int getNativeTimeToFullCharge() {
        return nativeTimeToFullCharge;
    }

    public void setNativeTimeToFullCharge(int nativeTimeToFullCharge) {
        this.nativeTimeToFullCharge = nativeTimeToFullCharge;
    }

    public Boolean getCurrentlyCharging() {
        return currentlyCharging;
    }

    public void setCurrentlyCharging(Boolean currentlyCharging) {
        this.currentlyCharging = currentlyCharging;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public int getCalculatedBatteryCapacity() {
        return calculatedBatteryCapacity;
    }

    public void setCalculatedBatteryCapacity(int calculatedBatteryCapacity) {
        this.calculatedBatteryCapacity = calculatedBatteryCapacity;
    }

    public int getBatteryTemperature() {
        return batteryTemperature;
    }

    public void setBatteryTemperature(int batteryTemperature) {
        this.batteryTemperature = batteryTemperature;
    }
}
