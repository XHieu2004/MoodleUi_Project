package com.example.moodleui;

import android.os.Bundle;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 mViewPager2;
    private BottomNavigationView mBottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager2 = findViewById(R.id.view_pager_2);
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
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
                int menuid = item.getItemId();
                if (menuid == R.id.home_dashboard) {
                    mViewPager2.setCurrentItem(0);
                    return true;
                } else if (menuid == R.id.notifications_button) {
                    mViewPager2.setCurrentItem(1);
                    return true;
                } else if (menuid == R.id.calender_button) {
                    mViewPager2.setCurrentItem(2);
                    return true;
                } else if (menuid == R.id.site_blog_button) {
                    mViewPager2.setCurrentItem(3);
                    return true;
                } else if (menuid == R.id.more_button) {
                    mViewPager2.setCurrentItem(4);
                    return true;
                }
                return false;
            }
        });
        }
    }

//        viewPager = findViewById(R.id.view_pager);
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        viewPager.setAdapter(adapter);
//
//       viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//           @Override
//           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//           }
//
//           @Override
//           public void onPageSelected(int position) {
//               switch (position){
//                   case 0:
//                       bottomNavigationView.getMenu().findItem(R.id.home_dashboard).setChecked(true);
//                       break;
//                   case 1:
//                       bottomNavigationView.getMenu().findItem(R.id.notifications_button).setChecked(true);
//                       break;
//                   case 2:
//                       bottomNavigationView.getMenu().findItem(R.id.calender_button).setChecked(true);
//                       break;
//                   case 3:
//                       bottomNavigationView.getMenu().findItem(R.id.site_blog_button).setChecked(true);
//                       break;
//                   case 4:
//                       bottomNavigationView.getMenu().findItem(R.id.more_button).setChecked(true);
//                       break;
//
//
//               }
//
//           }
//
//           @Override
//           public void onPageScrollStateChanged(int state) {
//
//           }
//       });
//
//
//}



