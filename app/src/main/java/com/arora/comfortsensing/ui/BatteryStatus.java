package com.arora.comfortsensing.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.arora.comfortsensing.R;

public class BatteryStatus extends AppCompatActivity {

    TextView tvbatterNativeCharge;
    TextView tvisChargingOrNot;
    TextView tvchargeType;
    TextView tvBatteryTemperature;
    TextView tvBatteryVoltage;
    TextView tvBatteryTechnology;

    String isCharging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_status);

        tvbatterNativeCharge = (TextView) findViewById(R.id.batteryNativeCharge);
        tvisChargingOrNot = (TextView) findViewById(R.id.isBatteryCharging);
        tvchargeType = (TextView) findViewById(R.id.chargeType);
        tvBatteryTemperature = (TextView) findViewById(R.id.batteryTemperature);
        tvBatteryVoltage = (TextView) findViewById(R.id.batteryVoltage);
        tvBatteryTechnology = (TextView) findViewById(R.id.batteryTechnology);




        /*tvbatterNativeCharge.setText(batteryStatus);
        tvisChargingOrNot.setText(isCharge);
        tvchargeType.setText(chargeType);
        tvBatteryTemperature.setText(batteryTemperature);
        tvBatteryVoltage.setText(batteryVoltage);
        tvBatteryTechnology.setText(batteryTechnology);*/
    }

}
