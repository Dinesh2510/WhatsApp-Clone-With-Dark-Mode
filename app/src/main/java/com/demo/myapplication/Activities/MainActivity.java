package com.demo.myapplication.Activities;

import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.demo.myapplication.Adapter.PageAdapter;
import com.demo.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Toolbar toolbar;
    ImageView imageView;
    private FloatingActionButton fabbtn1, fabbtn2;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private PageAdapter adapter;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;
    private static final String NIGHT_MODE = "night_mode";
    private SharedPreferences mSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSharedPref = getPreferences(Context.MODE_PRIVATE);

        if (isNightModeEnabled()) {
            setAppTheme(R.style.DarkMode);
        } else {
            setAppTheme(R.style.LightMode);
        }
        initviews();
        SetViewPager();
    }


    @SuppressLint("RestrictedApi")
    private void initviews() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_camera_alt_black_24dp)));
        tabLayout.addTab(tabLayout.newTab().setText("CHATS"));
        tabLayout.addTab(tabLayout.newTab().setText("STATUS"));
        tabLayout.addTab(tabLayout.newTab().setText("CALLS"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager = findViewById(R.id.view_pager);
        
        fabbtn1 = findViewById(R.id.fab_btn1);
        fabbtn2 = findViewById(R.id.fab_btn2);
        fabbtn2.setVisibility(View.GONE);

        fabbtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doMyThing();
            }
        });
        fabbtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doMyThing();
            }
        });
    }

    private void doMyThing() {
        Toast.makeText(this, "Hey! You Clicked", Toast.LENGTH_SHORT).show();
    }

    private void SetViewPager() {
        adapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(1);  //Default  screen

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (viewPager.getCurrentItem() != tab.getPosition()) {
                    viewPager.setCurrentItem(tab.getPosition());
                }
                //0=camera  1=Chat   3=status   4=calls
                if (tab.getPosition() == 0) {
                    OpenCamera();
                    tab.setIcon(getResources().getDrawable(R.drawable.ic_camera_alt_black_24dp));
                    fabbtn1.setVisibility(View.GONE);

                    fabbtn2.setVisibility(View.GONE);

                } else if (tab.getPosition() == 1) {

                    fabbtn1.setVisibility(View.VISIBLE);
                    fabbtn2.setVisibility(View.GONE);
                    fabbtn1.setImageResource(R.drawable.ic_message);

                } else if (tab.getPosition() == 2) {

                    fabbtn1.setVisibility(View.VISIBLE);
                    fabbtn2.setVisibility(View.VISIBLE);
                    fabbtn1.setImageResource(R.drawable.ic_camera_alt_black_24dp);
                    fabbtn2.setImageResource(R.drawable.ic_edit_black_24dp);

                } else if (tab.getPosition() == 3) {

                    fabbtn2.setVisibility(View.GONE);
                    fabbtn1.setVisibility(View.VISIBLE);
                    fabbtn1.setImageResource(R.drawable.white_call);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    tabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.ic_camera_alt_black_24dp));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void OpenCamera() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,
                CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        imageView = findViewById(R.id.image);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
// Get state from preferences
        if (isNightModeEnabled()) {
            item.setChecked(true);
        } else {
            item.setChecked(false);
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.Dark_mode) {

            if (isNightModeEnabled()) {
                setIsNightModeEnabled(false);
                setAppTheme(R.style.LightMode);
            } else {
                setIsNightModeEnabled(true);
                setAppTheme(R.style.DarkMode);
            }

            // Recreate activity
            recreate();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setAppTheme(@StyleRes int style) {
        setTheme(style);
    }

    private boolean isNightModeEnabled() {
        return mSharedPref.getBoolean(NIGHT_MODE, false);
    }

    private void setIsNightModeEnabled(boolean state) {
        SharedPreferences.Editor mEditor = mSharedPref.edit();
        mEditor.putBoolean(NIGHT_MODE, state);
        mEditor.apply();
    }
}


