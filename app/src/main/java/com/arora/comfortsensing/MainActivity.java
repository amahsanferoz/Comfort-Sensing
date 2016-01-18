package com.arora.comfortsensing;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arora.comfortsensing.ui.Battery;
import com.arora.comfortsensing.ui.BatteryStatus;
import com.arora.comfortsensing.ui.PersonalData;
import com.arora.comfortsensing.ui.WifiStatus;

public class MainActivity extends AppCompatActivity {

    ImageView batteryStatus, wifiStatus, personalData;
    TextView nativeBatteryStatus, calculativeBatteryStatus;
    Battery battery = new Battery();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryStatus = (ImageView) findViewById(R.id.batteryStatus);
        wifiStatus = (ImageView) findViewById(R.id.signalStrength);
        personalData = (ImageView) findViewById(R.id.personalData);

        nativeBatteryStatus = (TextView) findViewById(R.id.nativeBatteryStatus);
        calculativeBatteryStatus = (TextView) findViewById(R.id.calculativeBatteryStatus);


        batteryStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creating bundle object
                Bundle batteryInformation = new Bundle();

                //Storing data into bundle
                batteryInformation.putString("batteryLevel", battery.getNativeBatteryStatus());
                batteryInformation.putBoolean("isCurrentlyCharging", battery.getCurrentlyCharging());
                batteryInformation.putString("chargeType", battery.getChargeType());
                batteryInformation.putInt("batteryTemperature", battery.getBatteryTemperature());
                batteryInformation.putInt("batteryVoltage", battery.getBatteryVoltage());
                batteryInformation.putString("batteryTechnology", battery.getBatteryTechnology());

                //Create Intent Object
                Intent intent = new Intent(MainActivity.this, BatteryStatus.class);

                //Storing bundle object into intent
                intent.putExtras(batteryInformation);
                startActivity(intent);
            }
        });

        wifiStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WifiStatus.class);
                startActivity(intent);
            }
        });

        personalData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PersonalData.class);
                startActivity(intent);
            }
        });

        //Update Main Activity Display
        getBatteryInformations();
        updateDisplay();
    }

    //Gathering all the information from the system for battery
    private Battery getBatteryInformations() {
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
        int temp = batteryStatus.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0)/10;

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
        //nativeBatteryStatus.setText(batteryLevel + "%");
    }

    //Update the main display
    private void updateDisplay() {

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = this.registerReceiver(null, ifilter);

        String batteryLevel = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) + "";
        Log.d("batterLevel", "Battery Level: " + batteryLevel);

        nativeBatteryStatus.setText(battery.getNativeBatteryStatus() + "%");
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
