package com.dreamfactory.novax.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dreamfactory.novax.fragment.MenuHomeFragment;
import com.dreamfactory.novax.fragment.MenuOrderFragment;
import com.dreamfactory.novax.fragment.MenuPortfoiloFragment;
import com.dreamfactory.novax.fragment.MenuSocialFragment;

public class MenuPageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    private Fragment fragment;

    public MenuPageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                fragment = new MenuHomeFragment();
                break;
            case 1:
                fragment = new MenuPortfoiloFragment();
                break;
            case 2:
                fragment = new MenuOrderFragment();
                break;
            case 3:
                fragment = new MenuSocialFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
