package com.karenpownall.android.aca.fragmentslider;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SimpleFragmentPagerAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize a list of 3 fragments
        List<Fragment> fragmentList = new ArrayList<Fragment>();

        //add 3 new fragments to the list
        fragmentList.add(SimpleFragment.newInstance("1"));
        fragmentList.add(SimpleFragment.newInstance("2"));
        fragmentList.add(SimpleFragment.newInstance("3"));

        pageAdapter = new SimpleFragmentPagerAdapter (getSupportFragmentManager(), fragmentList);

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(pageAdapter);
    }

    private class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {


        //a list to hold our fragments
        private List<Fragment>fragments;

        //a constructor to receive a fragment manager and a list
        public SimpleFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments){
            //call the super class' version of the constructor
            super(fm);
            this.fragments = fragments;
        }

        //just 2 methods to override to get current position of adapter and size of List
        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }
}
