package com.arora.comfortsensing.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arora.comfortsensing.MainActivity;
import com.arora.comfortsensing.R;
import com.arora.comfortsensing.ui.Battery;

public class BatteryFragment extends Fragment{

    TextView tv_chargingState, tv_chargeRemain, tv_batteryTemp, tv_batteryTechnology,
                tv_batteryVoltage, tv_chargeType, tv_batteryCapacity, tv_actualBatteryCapacity, tv_normalBatteryStatus;

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

        MainActivity mainActivity = (MainActivity) getActivity();
        Battery info = mainActivity.getBatteryInformations();

        tv_chargingState = (TextView) view.findViewById(R.id.tv_chargingState);
        tv_chargeRemain = (TextView) view.findViewById(R.id.tv_chargeRemain);
        tv_batteryTemp = (TextView) view.findViewById(R.id.tv_batteryTemp);
        tv_batteryTechnology = (TextView) view.findViewById(R.id.tv_batteryTechnology);
        tv_batteryVoltage = (TextView) view.findViewById(R.id.tv_batteryVoltage);
        tv_chargeType = (TextView) view.findViewById(R.id.tv_chargeType);
        tv_batteryCapacity = (TextView) view.findViewById(R.id.tv_batteryCapacity);
        tv_actualBatteryCapacity = (TextView) view.findViewById(R.id.tv_actualBatteryCapacity);
        tv_normalBatteryStatus = (TextView) view.findViewById(R.id.tv_normalBatteryStatus);

        tv_normalBatteryStatus.setText(info.getNativeBatteryStatus());
        tv_chargingState.setText(String.valueOf(info.getCurrentlyCharging()));
        tv_chargeType.setText(info.getChargeType());
        tv_batteryTemp.setText(String.valueOf(info.getBatteryTemperature()));
        tv_batteryVoltage.setText(String.valueOf(info.getBatteryVoltage()));
        tv_batteryTechnology.setText(info.getBatteryTechnology());
        tv_batteryCapacity.setText(String.valueOf(info.getBatteryCapacity()));

        // Inflate the layout for this fragment
        return view;
    }

    public void updateDisplay() {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
}
