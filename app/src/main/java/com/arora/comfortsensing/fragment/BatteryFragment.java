package com.arora.comfortsensing.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arora.comfortsensing.R;
import com.arora.comfortsensing.ui.Battery;

public class BatteryFragment extends Fragment {

    TextView tv_chargingState, tv_chargeRemain, tv_batteryTemp, tv_batteryTechnology,
                tv_batteryVoltage, tv_chargeType, tv_batteryCapacity, tv_actualBatteryCapacity, tv_normalBatteryStatus;

    Battery battery = new Battery();

    public BatteryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_battery,
                container, false);
        
        tv_chargingState = (TextView) view.findViewById(R.id.tv_chargingState);
        tv_chargeRemain = (TextView) view.findViewById(R.id.tv_chargeRemain);
        tv_batteryTemp = (TextView) view.findViewById(R.id.tv_batteryTemp);
        tv_batteryTechnology = (TextView) view.findViewById(R.id.tv_batteryTechnology);
        tv_batteryVoltage = (TextView) view.findViewById(R.id.tv_batteryVoltage);
        tv_chargeType = (TextView) view.findViewById(R.id.tv_chargeType);
        tv_batteryCapacity = (TextView) view.findViewById(R.id.tv_batteryCapacity);
        tv_actualBatteryCapacity = (TextView) view.findViewById(R.id.tv_actualBatteryCapacity);
        tv_normalBatteryStatus = (TextView) view.findViewById(R.id.tv_normalBatteryStatus);

        updateDisplay();

        // Inflate the layout for this fragment
        return view;
    }

    public void updateDisplay() {
        String chargingType = battery.getChargeType() + "";
        String batteryLevel = battery.getNativeBatteryStatus() + "";
        Log.d("Battery Status: ", chargingType);

        Log.d("Charging Type: ", chargingType);
        tv_chargeType.setText(chargingType);

        tv_normalBatteryStatus.setText(batteryLevel + "%");
    }

}
