package com.example.moodleui.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.moodleui.R;
import com.example.moodleui.homepage.HomePageViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class USTHHome extends Fragment {
    private ViewPager2 hviewPager2;
    private TabLayout htabLayout;


    public USTHHome() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_usth_home, container, false);

        hviewPager2 = view.findViewById(R.id.hviewPager2);
        htabLayout = view.findViewById(R.id.htabLayout);
        HomePageViewPagerAdapter adapter = new HomePageViewPagerAdapter(getActivity());
        hviewPager2.setAdapter(adapter);

        new TabLayoutMediator(htabLayout, hviewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Site home");
                    break;
                case 1:
                    tab.setText("Dashboard");
                    break;
            }
        }).attach();

        return view;
    }
}
