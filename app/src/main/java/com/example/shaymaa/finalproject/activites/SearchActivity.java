package com.example.shaymaa.finalproject.activites;

import android.support.design.widget.TabLayout;
 import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;


import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.fragments.SearchWithActivites;
import com.example.shaymaa.finalproject.fragments.SearchWithName;
import com.example.shaymaa.finalproject.fragments.SearchWithProducte;

public class SearchActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("البحث عن المصانع");
           // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    SearchWithName searchWithName = new SearchWithName();
                    return searchWithName;
                case 1:
                    SearchWithActivites searchWithActivites = new SearchWithActivites();
                    return searchWithActivites;
                case 2:
                    SearchWithProducte searchWithProducte = new SearchWithProducte();
                    return searchWithProducte;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "ابحث بإسم المصنع";
                case 1:
                    return "ابحث بالنشاط";
                case 2:
                    return "ابحث بالمنتج";
            }
            return null;
        }
    }
}
