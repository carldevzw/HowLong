package com.grpprj.howlong;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

public class CampusActivity extends AppCompatActivity {

    private static final String TAG = "MapActivity";
    private ViewPager2 viewPager2;
    TabLayout tabLayout;
    CampusesViewPageAdapter campusesViewPageAdapter;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);

        viewPager2 = findViewById(R.id.vp2);
        tabLayout = findViewById(R.id.campusesTab);

        FragmentManager fragmentManager = getSupportFragmentManager();

        campusesViewPageAdapter = new CampusesViewPageAdapter(fragmentManager, getLifecycle());

        viewPager2.setAdapter(campusesViewPageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}
