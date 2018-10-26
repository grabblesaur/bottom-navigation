package com.example.bogdanov.bottom_navigation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private NavController mHomeController, mNewsController, mCurrentController;

    private FrameLayout mSectionHomeWrapper, mSectionNewsWrapper;

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    public void supportNavigateUpTo(@NonNull Intent upIntent) {
        if (mCurrentController != null) {
            mCurrentController.navigateUp();
        }
    }

    @Override
    public void onBackPressed() {
        if (mCurrentController != null) {
            if (!mCurrentController.popBackStack()) {
                finish();
            }
        }
    }

    private void initViews() {
        mHomeController = Navigation.findNavController(this, R.id.section_home);
        mNewsController = Navigation.findNavController(this, R.id.section_news);
        mSectionHomeWrapper = findViewById(R.id.section_home_wrapper);
        mSectionNewsWrapper = findViewById(R.id.section_news_wrapper);
        mBottomNavigationView = findViewById(R.id.bottomnavigationview);

        BottomNavigationView.OnNavigationItemSelectedListener selectedListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        boolean returnValue = false;

                        switch (item.getItemId()) {
                            case R.id.navigation_menu_home:
                                mCurrentController = mHomeController;
                                mSectionHomeWrapper.setVisibility(View.VISIBLE);
                                mSectionNewsWrapper.setVisibility(View.INVISIBLE);
                                returnValue = true;
                                break;
                            case R.id.navigation_menu_news:
                                mCurrentController = mNewsController;
                                mSectionHomeWrapper.setVisibility(View.INVISIBLE);
                                mSectionNewsWrapper.setVisibility(View.VISIBLE);
                                returnValue = true;
                                break;
                        }
                        return returnValue;
                    }
                };

        mCurrentController = mHomeController;
        mBottomNavigationView.setOnNavigationItemSelectedListener(selectedListener);
        mSectionHomeWrapper.setVisibility(View.VISIBLE);
        mSectionNewsWrapper.setVisibility(View.INVISIBLE);
    }
}
