package com.demo.myapplication.Adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.demo.myapplication.Fragment.CallsFragment;
import com.demo.myapplication.Fragment.CameraFragment;
import com.demo.myapplication.Fragment.ChatFragment;
import com.demo.myapplication.Fragment.StatusFragment;

public class PageAdapter extends FragmentPagerAdapter {

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new CameraFragment();
            case 1:
                return new ChatFragment();
            case 2:
                return new StatusFragment();
            case 3:
                return new CallsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
