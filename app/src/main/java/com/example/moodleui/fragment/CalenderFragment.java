package com.example.moodleui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import com.example.moodleui.R;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;



public class CalenderFragment extends Fragment {
    private DrawerLayout drawerLayout;

    public CalenderFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calender, container, false);

        drawerLayout = view.findViewById(R.id.cdrawer_layout);



        ImageView imageButton = view.findViewById(R.id.cmorebutton);

        imageButton.setOnClickListener(view1 -> {

            PopupMenu popupMenu = new PopupMenu(getContext(), view1);
            MenuInflater inflater1 = popupMenu.getMenuInflater();
            inflater1.inflate(R.menu.calender_more, popupMenu.getMenu());
            popupMenu.setForceShowIcon(true);

            popupMenu.setOnMenuItemClickListener(menuItem -> {
                if (menuItem.getItemId() == R.id.test1) {
                    Toast.makeText(getContext(), "Test 1 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (menuItem.getItemId() == R.id.test2) {
                    Toast.makeText(getContext(), "Test 2 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    return false;
                }
            });


            popupMenu.show();
        });


        ImageView filterButton = view.findViewById(R.id.filter_button);
        filterButton.setOnClickListener(view12 -> {
            if (drawerLayout != null && !drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        return view;
    }
}
