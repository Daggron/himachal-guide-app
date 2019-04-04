package com.example.himachalguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class customPageAdapter extends FragmentPagerAdapter {

    String title[]={"Hotels","Attractions","Historic","Temples","Events"};


    public  customPageAdapter(FragmentManager fm){
        super(fm);

    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0:
                return new hotelsFragment();


            case 1:
                return new attractionFragment();

            case 2:
                return new historicalFragment();

            case 3:
                return new templesFragment();


            case 4:
                return  new eventsFragment();

                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }


    @Override
    public CharSequence getPageTitle(int position) {


        return title[position];
    }
}
