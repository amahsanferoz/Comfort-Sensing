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
import com.arora.comfortsensing.ui.Wifi;

public class WifiFragment extends Fragment {

    TextView tv_wifiStatus, tv_wifiConnectedTo;

    public WifiFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wifi, container, false);

        //Initializing UI resources
        tv_wifiStatus = (TextView) view.findViewById(R.id.tv_wifiState);
        tv_wifiConnectedTo = (TextView) view.findViewById(R.id.tv_wifiConnectedTo);

        MainActivity mainActivity = (MainActivity) getActivity();
        Wifi info = mainActivity.getWifiInformation();

        tv_wifiStatus.setText(String.valueOf(info.isEnabled()));


        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

}
