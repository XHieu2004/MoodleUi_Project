package com.example.moodleui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public USTHHome() {
        // Required empty public constructor
    }

    public static USTHHome newInstance(String param1, String param2) {
        USTHHome fragment = new USTHHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_u_s_t_h_home, container, false);

        // Corrected findViewById calls with IDs from XML layout
        hviewPager2 = view.findViewById(R.id.hviewPager2);
        htabLayout = view.findViewById(R.id.htabLayout);
        HomePageViewPagerAdapter adapter = new HomePageViewPagerAdapter(getActivity());
        hviewPager2.setAdapter(adapter);

        // Synchronize ViewPager2 with TabLayout
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
