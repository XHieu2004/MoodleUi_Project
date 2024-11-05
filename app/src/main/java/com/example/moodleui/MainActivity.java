package com.example.moodleui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.example.moodleui.homepage.Login;
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


        SharedPreferences sharedPreferences = getSharedPreferences("TOLogin", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

        if (!isLoggedIn) {
            Intent intent = new Intent(MainActivity.this, Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish(); // Close MainActivity if not logged in
            return; // Prevent further processing
        }

        setContentView(R.layout.activity_main);
        // Rest of your code...

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
        LinearLayout logoutButton = findViewById(R.id.log_out_button);

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
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("TOLogin", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.apply();

                // Navigate to LoginActivity and clear the back stack
                Intent intent = new Intent(MainActivity.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish(); // Close MainActivity
            }
        });
    }
}




