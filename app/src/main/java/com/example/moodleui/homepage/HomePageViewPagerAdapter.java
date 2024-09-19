package com.example.moodleui.homepage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;



public class HomePageViewPagerAdapter extends FragmentStateAdapter {
    public HomePageViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new SiteHomeFragment();
            case 1:
                return new DashBoardFragment();
            default:
                return new SiteHomeFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

}


