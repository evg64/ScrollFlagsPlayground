package com.example.scrollflagsplayground.configscreen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.scrollflagsplayground.R;
import com.google.android.material.tabs.TabLayout;

public class ConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = findViewById(R.id.viewPager);
        pager.setAdapter(new ConfigPagerAdapter(getSupportFragmentManager(), this));
        TabLayout tabs = findViewById(R.id.tabLayout);
        tabs.setupWithViewPager(pager, true);
    }

}
