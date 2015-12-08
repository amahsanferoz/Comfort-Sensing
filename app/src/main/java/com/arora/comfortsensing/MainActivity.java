package com.arora.comfortsensing;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arora.comfortsensing.ui.BatteryStatus;
import com.arora.comfortsensing.ui.PersonalData;
import com.arora.comfortsensing.ui.WifiStatus;

public class MainActivity extends AppCompatActivity {

    ImageView batteryStatus, wifiStatus, personalData;
    TextView nativeBatteryStatus, calculativeBatteryStatus;

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
                Intent intent = new Intent(MainActivity.this, BatteryStatus.class);
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

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = this.registerReceiver(null, ifilter);

        String batteryLevel = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) + "";
        nativeBatteryStatus.setText(batteryLevel + "%");
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
