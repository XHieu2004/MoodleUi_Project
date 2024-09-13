package com.example.moodleui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.fragment.app.Fragment;

import com.example.moodleui.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CalenderFragment extends Fragment {



    public CalenderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calender, container, false);
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

        return view;
    }
}
