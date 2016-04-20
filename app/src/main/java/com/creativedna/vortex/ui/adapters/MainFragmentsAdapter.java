package com.creativedna.vortex.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.creativedna.vortex.ui.fragments.TabAllEventsFragment;
import com.creativedna.vortex.ui.fragments.TabArtistsFragment;
import com.creativedna.vortex.ui.fragments.TabFavoritesFragment;
import com.creativedna.vortex.ui.fragments.TabPopularFragment;


/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class MainFragmentsAdapter extends FragmentPagerAdapter {
    public MainFragmentsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new TabAllEventsFragment();
        }else if (position == 1) {
            return new TabPopularFragment();
        }else if (position == 2) {
            return new TabArtistsFragment();
        }else if (position == 3) {
            return new TabFavoritesFragment();
        }else{
            return new TabAllEventsFragment();
        }

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "ALL EVENTS" ;
        } else if (position == 1) {
            return "POPULAR";
        } else if (position == 2) {
            return "ALL ARTISTS";
        }else if (position == 3) {
            return "FAVORITES";
        } else {
            return null;
        }
    }
}
