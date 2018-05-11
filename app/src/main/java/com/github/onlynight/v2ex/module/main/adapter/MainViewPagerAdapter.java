package com.github.onlynight.v2ex.module.main.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.github.onlynight.v2ex.base.BaseFragment;
import com.github.onlynight.v2ex.module.topic_list.HotTopicListFragment;
import com.github.onlynight.v2ex.module.topic_list.LatestTopicListFragment;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private BaseFragment[] fragments = {
            new HotTopicListFragment(),
            new LatestTopicListFragment()
    };

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments[position].getFragmentTitle();
    }
}
