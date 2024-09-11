package com.example.moodleui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.moodleui.fragment.CalenderFragment;
import com.example.moodleui.fragment.More_Fragment;
import com.example.moodleui.fragment.Notifacations_Fragment;
import com.example.moodleui.fragment.SiteBlog_Fragment;
import com.example.moodleui.fragment.USTHHome;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new USTHHome();
            case 1:
                return new Notifacations_Fragment();
            case 2:
                return new CalenderFragment();
            case 3:
                return new SiteBlog_Fragment();
            case 4:
                return new More_Fragment();
            default:
                return new USTHHome();
        }

    }

    @Override
    public int getItemCount() {
        return 5;
    }


//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        switch (position){
//            case 0:
//                return new USTHHome();
//            case 1:
//                return new Notifacations_Fragment();
//            case 2:
//                return new CalenderFragment();
//            case 3:
//                return new SiteBlog_Fragment();
//            case 4:
//                return new More_Fragment();
//            default:
//                return new USTHHome();
//        }
//
//    }
//
//    @Override
//    public int getCount() {
//        return 5;
//    }
}