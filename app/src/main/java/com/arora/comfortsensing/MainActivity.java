package com.arora.comfortsensing;

import android.app.ActionBar;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.arora.comfortsensing.adapter.TabsPagerAdapter;
import com.arora.comfortsensing.ui.Battery;
import com.arora.comfortsensing.ui.Wifi;

public class MainActivity extends AppCompatActivity {

    ImageView batteryStatus, wifiStatus, personalData;
    TextView nativeBatteryStatus, calculativeBatteryStatus, wifiStatusEnable;
    WifiManager mWifiManager;
    Battery battery = new Battery();
    Wifi wifi = new Wifi();

    //Declaring Tabs
    Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabsPagerAdapter mAdapter;
    private TabLayout mTabLayout;
    private ActionBar mActionBar;

    //Tab Titles
    private String[] tab = {"Battery", "WiFi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.addTab(mTabLayout.newTab().setText("Battery"));
        mTabLayout.addTab(mTabLayout.newTab().setText("WIFI"));

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());

        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        getBatteryInformations();
    }

    /*
    public void sendBatteryData() {
        Log.d("Battery Level: ", battery.getNativeBatteryStatus());
        Log.d("Is Charging: ", String.valueOf(battery.getCurrentlyCharging()));
        Log.d("Charging Type: ", battery.getChargeType());
        Log.d("Battery Temperature: ", String.valueOf(battery.getBatteryTemperature()));
        Log.d("Battery Voltage: ", String.valueOf(battery.getBatteryVoltage()));
        Log.d("Battery Technology: ", battery.getBatteryTechnology());
        //Creating bundle object to send data to Battery and Wifi Fragment
        Bundle batteryInformation = new Bundle();

        //String hagu = battery.getNativeBatteryStatus();

        //Storing Battery data into bundle
        batteryInformation.putString("batteryLevel", battery.getNativeBatteryStatus());
        batteryInformation.putBoolean("isCurrentlyCharging", battery.getCurrentlyCharging());
        batteryInformation.putString("chargeType", battery.getChargeType());
        batteryInformation.putInt("batteryTemperature", battery.getBatteryTemperature());
        batteryInformation.putInt("batteryVoltage", battery.getBatteryVoltage());
        batteryInformation.putString("batteryTechnology", battery.getBatteryTechnology());

        BatteryFragment batteryFragment = new BatteryFragment();
        batteryFragment.setArguments(batteryInformation);
    } */

    //Gathering all the information from the system for battery
    public Battery getBatteryInformations() {
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = this.registerReceiver(null, ifilter);

        //Current Battery Level
        String batteryLevel = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) + "";
        Log.d("batterLevel", "Battery Level: " + batteryLevel);

        //Are we charging
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;

        Log.d("isCharging", "IS Charging: " + isCharging);

        //How are we charging
        int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;

        String chargingType = "";
        if (isCharging) {
            if (usbCharge)
                chargingType = "USB Plugged";
            else
                chargingType = "AC Plugged";
        }

        //Battery Temperature
        int temp = batteryStatus.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0) / 10;

        //Battery Voltage
        int voltage = batteryStatus.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);

        //Battery Technology
        String technology = batteryStatus.getExtras().getString(BatteryManager.EXTRA_TECHNOLOGY);

        //Set the value for the battery instance
        battery.setNativeBatteryStatus(batteryLevel);
        battery.setCurrentlyCharging(isCharging);
        battery.setChargeType(chargingType);
        battery.setBatteryTemperature(temp);
        battery.setBatteryVoltage(voltage);
        battery.setBatteryTechnology(technology);

         return battery;
    }

    //Update the main display
    private void updateDisplay() {

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = this.registerReceiver(null, ifilter);

        String batteryLevel = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) + "";
        Log.d("batterLevel", "Battery Level: " + batteryLevel);

        nativeBatteryStatus.setText(battery.getNativeBatteryStatus() + "%");

        if (wifi.isEnabled()) {
            wifiStatusEnable.setText("Enable");
        } else {
            wifiStatusEnable.setText("Disable");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
