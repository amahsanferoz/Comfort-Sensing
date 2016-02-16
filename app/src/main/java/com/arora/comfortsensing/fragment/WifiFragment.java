package com.arora.comfortsensing.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.arora.comfortsensing.MainActivity;
import com.arora.comfortsensing.R;
import com.arora.comfortsensing.ui.Wifi;

import java.util.ArrayList;
import java.util.HashMap;

public class WifiFragment extends ListFragment{

    String[] item1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
    String[] item2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
    String[] item3 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
    String[] item4 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};

    ArrayList<HashMap<String, String>> data = new ArrayList<>();
    SimpleAdapter adapter;

    TextView tv_wifiStatus, tv_wifiConnectedTo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wifi, container, false);

        //Initializing UI resources
        tv_wifiStatus = (TextView) view.findViewById(R.id.tv_wifiState);
        tv_wifiConnectedTo = (TextView) view.findViewById(R.id.tv_wifiConnectedTo);

        MainActivity mainActivity = (MainActivity) getActivity();
        Wifi info = mainActivity.getWifiInformation();

        tv_wifiStatus.setText(String.valueOf(info.isEnabled()));

        //Map
        HashMap<String, String> map = new HashMap<String, String>();
        //Fill with data

        for (int i = 0; i<item1.length; i++) {
            map = new HashMap<String, String>();
            //map = new HashMap<String, String>();
            //map = new HashMap<String, String>();
            Log.d("Size of the array: ", String.valueOf(item1.length));
            map.put("Item1", item1[i]);
            map.put("Item2", item2[i]);
            map.put("Item3", item3[i]);
            map.put("Item4", item4[i]);

            data.add(map);
        }

        //Keys in Map
        String[] from = {"Item1", "Item2", "Item3", "Item4"};
        //IDs of the views
        int[] to = {R.id.Itemname1, R.id.Itemname2, R.id.Itemname3, R.id.Itemname4};

        //Adapter
        adapter = new SimpleAdapter(getActivity(), data, R.layout.list_wifi_row, from, to);
        setListAdapter(adapter);

        return view;
    }
}
