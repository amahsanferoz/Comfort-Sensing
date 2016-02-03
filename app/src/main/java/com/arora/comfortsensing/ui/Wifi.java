package com.arora.comfortsensing.ui;

/**
 * Created by ahsanferoz on 18/01/16.
 */
public class Wifi {

    private float wifiCapacity;
    private float wifiSignalStrength;
    private String wifiAPName;
    private String wifiIP;
    private boolean isEnabled;

    public Wifi(){
        isEnabled = false;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public float getWifiCapacity() {
        return wifiCapacity;
    }

    public void setWifiCapacity(float wifiCapacity) {
        this.wifiCapacity = wifiCapacity;
    }

    public float getWifiSignalStrength() {
        return wifiSignalStrength;
    }

    public void setWifiSignalStrength(float wifiSignalStrength) {
        this.wifiSignalStrength = wifiSignalStrength;
    }

    public String getWifiAPName() {
        return wifiAPName;
    }

    public void setWifiAPName(String wifiAPName) {
        this.wifiAPName = wifiAPName;
    }

    public String getWifiIP() {
        return wifiIP;
    }

    public void setWifiIP(String wifiIP) {
        this.wifiIP = wifiIP;
    }
}
