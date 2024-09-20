package com.example.moodleui;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    private ViewPager2 mViewPager2;
    private BottomNavigationView mBottomNavigationView;
    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager2 = findViewById(R.id.view_pager_2);
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mDrawerLayout = findViewById(R.id.main);
        ImageView mImageView = findViewById(R.id.imageView);
        NavigationView mainNav = findViewById(R.id.main_nav);
        LinearLayout gradesButton = findViewById(R.id.grades_button);
        LinearLayout filesButton = findViewById(R.id.files_button);
        LinearLayout badgesButton = findViewById(R.id.badges_button);
        LinearLayout blog_entriesButton = findViewById(R.id.blog_entries_button);
        LinearLayout preferencesButton = findViewById(R.id.preferences_button);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        mViewPager2.setAdapter(adapter);
        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                switch (position) {
                    case 0:
                        mBottomNavigationView.getMenu().findItem(R.id.home_dashboard).setChecked(true);
                        break;
                    case 1:
                        mBottomNavigationView.getMenu().findItem(R.id.notifications_button).setChecked(true);
                        break;
                    case 2:
                        mBottomNavigationView.getMenu().findItem(R.id.calender_button).setChecked(true);
                        break;
                    case 3:
                        mBottomNavigationView.getMenu().findItem(R.id.site_blog_button).setChecked(true);
                        break;
                    case 4:
                        mBottomNavigationView.getMenu().findItem(R.id.more_button).setChecked(true);
                        break;
                }
            }
            });
        mBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int menu_id = item.getItemId();
                if (menu_id == R.id.home_dashboard) {
                    mViewPager2.setCurrentItem(0);

                    return true;
                } else if (menu_id == R.id.notifications_button) {
                    mViewPager2.setCurrentItem(1);
                    return true;
                } else if (menu_id == R.id.calender_button) {
                    mViewPager2.setCurrentItem(2);
                    return true;
                } else if (menu_id == R.id.site_blog_button) {
                    mViewPager2.setCurrentItem(3);
                    return true;
                } else if (menu_id == R.id.more_button) {
                    mViewPager2.setCurrentItem(4);
                    return true;
                }
                return false;
            }
        });
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout != null && !mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
                    mDrawerLayout.openDrawer(GravityCompat.END);
                }
            }
        });

        //Preview user account element activities:
        gradesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Grades.class);
                startActivity(intent);
            }
        });
        filesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Files.class);
                startActivity(intent1);
            }
        });
        badgesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, Badges.class);
                startActivity(intent2);
            }
        });
        blog_entriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, BlogEntries.class);
                startActivity(intent3);
            }
        });
        preferencesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity.this, Preferences.class);
                startActivity(intent4);
            }
        });

        }
    }




