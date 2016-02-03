package com.arora.comfortsensing.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.arora.comfortsensing.fragment.BatteryFragment;
import com.arora.comfortsensing.fragment.WifiFragment;

/**
 * Created by ahsanferoz on 31/01/16.
 */
public class TabsPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public TabsPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                BatteryFragment tab1 = new BatteryFragment();
                return tab1;
            case 1:
                WifiFragment tab2 = new WifiFragment();
                return tab2;
        }
        return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
